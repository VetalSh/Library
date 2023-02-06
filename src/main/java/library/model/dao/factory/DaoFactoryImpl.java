package library.model.dao.factory;

import library.model.dao.*;

/**
 * Concrete factory interface
 */
public interface DaoFactoryImpl {
    UserDao getUserDao();
    BookingDao getBookingDao();
    BookDao getBookDao();
    AuthorDao getAuthorDao();
    LangDao getLangDao();
}
