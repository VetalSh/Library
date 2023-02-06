package library.model.dao;

import library.model.dao.factory.AbstractDaoFactory;
import library.model.dao.factory.DaoFactoryCreator;
import org.junit.Assert;
import org.junit.Test;

public class DaoFactoryCreatorTest {
    @Test
    public void testGetDefaultFactory() {
        AbstractDaoFactory factory = DaoFactoryCreator.getDefaultFactory();
        Assert.assertNotNull(factory);
    }
}
