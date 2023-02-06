package library.model.tasks;

import library.exceptions.DaoException;
import library.exceptions.ServiceException;
import library.model.dao.BookingDao;
import library.model.dao.factory.DaoFactoryCreator;
import library.model.dao.factory.DaoFactoryImpl;
import library.model.entities.Booking;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

/**
 * TimerTask which cancels BOOKED booking after period specified in web.xml time to free the reserved books
 */
public class BookingExpireTask extends AbstractPeriodicTask {
    public static final Logger logger = LogManager.getLogger(BookingExpireTask.class);
    static final String INIT_PARAM_PERIOD = BookingExpireTask.class.getName() + ".period";
    public static final String TIMER_TASK_INIT_ERROR = "Required attribute {} was not set: " +
            "this.init(servletContext) was not called";

    public final DaoFactoryImpl daoFactory;
    private volatile int daysBeforeExpired = -1;

    /**
     * Normal way to use this class
     */
    public BookingExpireTask() {
        this.daoFactory = DaoFactoryCreator.getDefaultFactory().newInstance();
    }

    /**
     * For testing purpose
     * @param daoFactory daoFactory to be used to get daos
     */
    public BookingExpireTask(DaoFactoryImpl daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void run() {
        logger.debug("start");
        if (daysBeforeExpired == -1) {
            logger.fatal(TIMER_TASK_INIT_ERROR, INIT_PARAM_PERIOD);
            return;
        }

        BookingDao dao = daoFactory.getBookingDao();
        try {
            for (Booking booking: dao.findBy("BOOKED", "state")) {
                logger.trace("check booking={}", booking);
                Calendar now = Calendar.getInstance();
                long pastDays = ChronoUnit.DAYS.between(booking.getModified().toInstant(), now.toInstant());

                if (pastDays >= daysBeforeExpired) {
                    booking.setState(Booking.State.CANCELED);
                    dao.update(booking);
                    logger.info("booking (id {}) is expired", booking.getId());
                }
            }
            logger.info("All BOOKED bookings proceed");
        } catch (ServiceException | DaoException e) {
            logger.error("Unable to get list of BOOKED bookings: {}", e.getMessage());
        }

        logger.debug("end");
    }

    @Override
    public void init(ServletContext context) throws ServiceException {
        logger.debug("start");

        String periodStr = context.getInitParameter(INIT_PARAM_PERIOD);
        if (periodStr == null) {
            throw new ServiceException(INIT_PARAM_PERIOD + " is not specified in web.xml");
        }

        try {
            int daysBeforeExpiredCandidate = Integer.parseInt(periodStr);
            if (daysBeforeExpiredCandidate < 0) {
                throw new ServiceException("it's not positive " + daysBeforeExpiredCandidate);
            }
            synchronized (this) {
                daysBeforeExpired = daysBeforeExpiredCandidate;
            }
            logger.info("Days before expired initialized successfully");
        } catch (NumberFormatException e) {
            throw new ServiceException(INIT_PARAM_PERIOD + " should be valid positive integer value: " + e.getMessage());
        }

        logger.debug("end");
    }
}
