package library.model.dao.impl;

import library.model.dao.factory.DBDaoFactory;
import library.model.dao.factory.DaoFactoryImpl;
import org.junit.Assert;
import org.junit.Test;

public class TestDBDaoFactory {
    @Test
    public void testGetDefaultImpl() {
        DaoFactoryImpl factory = new DBDaoFactory().newInstance();
        Assert.assertNotNull(factory);
    }
}
