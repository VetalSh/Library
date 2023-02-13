package library.model.dao.impl;

import library.model.dao.BookDao;
import library.model.dao.factory.DaoFactoryCreator;
import library.model.dao.factory.DaoFactoryImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookDaoImplTest {
    private DaoFactoryImpl daoFactory = DaoFactoryCreator.getDefaultFactory().newInstance();

    @Test
    public void testBookDaoImplGetInstance() {
        BookDao bookDao = daoFactory.getBookDao();
        assertEquals(bookDao.getClass(), BookDaoImpl.class);
    }
}