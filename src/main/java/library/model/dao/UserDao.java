package library.model.dao;

import library.exceptions.DaoException;
import library.model.entities.User;

import java.util.List;

/**
 * Functions specific to User class
 */
public interface UserDao extends AbstractSuperDao<User> {
    User findByEmail(String email) throws DaoException;
    List<User> getAll() throws DaoException;
}
