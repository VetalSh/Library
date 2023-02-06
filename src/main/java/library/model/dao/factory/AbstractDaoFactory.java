package library.model.dao.factory;

/**
 * Abstract Factory interface
 */
public interface AbstractDaoFactory {
    /**
     * @return concrete factory of given type
     */
    DaoFactoryImpl newInstance();
}
