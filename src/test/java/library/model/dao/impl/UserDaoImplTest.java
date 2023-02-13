package library.model.dao.impl;

import library.model.dao.UserDao;
import library.model.dao.factory.DaoFactoryCreator;
import library.model.dao.factory.DaoFactoryImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserDaoImplTest {
    private DaoFactoryImpl daoFactory = DaoFactoryCreator.getDefaultFactory().newInstance();

    @Test
    public void testUserDaoImplGetInstance() {
        UserDao userDao = daoFactory.getUserDao();
        assertEquals(userDao.getClass(), UserDaoImpl.class);
    }
}