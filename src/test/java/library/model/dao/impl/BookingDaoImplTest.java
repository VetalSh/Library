package library.model.dao.impl;

import library.model.dao.BookingDao;
import library.model.dao.factory.DaoFactoryCreator;
import library.model.dao.factory.DaoFactoryImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookingDaoImplTest {
    private DaoFactoryImpl daoFactory = DaoFactoryCreator.getDefaultFactory().newInstance();

    @Test
    public void testBookingDaoImplGetInstance() {
        BookingDao bookingDao = daoFactory.getBookingDao();
        assertEquals(bookingDao.getClass(), BookingDaoImpl.class);
    }
}