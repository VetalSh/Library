package library.model.dao.factory;

import library.model.dao.*;
import library.model.dao.impl.*;

/**
 * DBFactory implementation for MySQL
 */
public class MySQLDaoFactory implements DaoFactoryImpl {

    @Override
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }

    @Override
    public BookingDao getBookingDao() {
        return new BookingDaoImpl();
    }

    @Override
    public BookDao getBookDao() {
        return new BookDaoImpl();
    }

    @Override
    public AuthorDao getAuthorDao() {
        return new AuthorDaoImpl();
    }

    @Override
    public LangDao getLangDao() {
        return new LangDaoImpl();
    }

}
