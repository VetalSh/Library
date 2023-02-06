package library.model.dao.factory;

/**
 * Abstract factory of DB factories
 */
public class DBDaoFactory implements AbstractDaoFactory {
    public DaoFactoryImpl newInstance() {
        return new MySQLDaoFactory();
    }
}

