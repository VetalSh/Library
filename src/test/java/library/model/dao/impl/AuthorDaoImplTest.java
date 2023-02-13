package library.model.dao.impl;

import library.model.dao.AuthorDao;
import library.model.dao.factory.DaoFactoryCreator;
import library.model.dao.factory.DaoFactoryImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthorDaoImplTest {
    private DaoFactoryImpl daoFactory = DaoFactoryCreator.getDefaultFactory().newInstance();

    @Test
    public void testAuthorDaoImplGetInstance() {
        AuthorDao authorDao = daoFactory.getAuthorDao();
        assertEquals(authorDao.getClass(), AuthorDaoImpl.class);
    }
}