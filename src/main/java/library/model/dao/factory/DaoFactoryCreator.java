package library.model.dao.factory;

/**
 * Abstract factory, returns factory of supported storage type: DB, XML, ...
 */
public class DaoFactoryCreator {

    private DaoFactoryCreator() {}

    public static AbstractDaoFactory getDefaultFactory() {
        return new DBDaoFactory();
    }
}

