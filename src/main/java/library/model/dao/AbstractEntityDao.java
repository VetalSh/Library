package library.model.dao;

import library.exceptions.DaoException;
import library.model.entities.Entity;

/**
 * Common function for all entities
 * @param <E> sub-class of Entity
 */
public interface AbstractEntityDao<E extends Entity> {
    void create(E entity) throws DaoException;
    E read(long id) throws DaoException;
    void update(E entity) throws DaoException;
    void delete(long id) throws DaoException;
}
