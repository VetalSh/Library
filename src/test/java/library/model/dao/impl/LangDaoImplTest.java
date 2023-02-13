package library.model.dao.impl;

import library.model.dao.LangDao;
import library.model.dao.factory.DaoFactoryCreator;
import library.model.dao.factory.DaoFactoryImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class LangDaoImplTest {
    private DaoFactoryImpl daoFactory = DaoFactoryCreator.getDefaultFactory().newInstance();

    @Test
    public void testLangDaoImplGetInstance() {
        LangDao langDao = daoFactory.getLangDao();
        assertEquals(langDao.getClass(), LangDaoImpl.class);
    }
}