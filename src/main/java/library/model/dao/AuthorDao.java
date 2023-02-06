package library.model.dao;

import library.exceptions.DaoException;
import library.model.entities.Author;

import java.util.List;

/**
 * Functions specific to Author class
 */
public interface AuthorDao extends AbstractSuperDao<Author> {
    List<Author> findByBookID(long id) throws DaoException;
    Author read(String name) throws DaoException;
    List<Author> findByPattern(String what) throws DaoException;
}
