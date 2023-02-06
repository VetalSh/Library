package library.model.dao;

import library.exceptions.DaoException;
import library.model.entities.Book;

import java.util.List;

/**
 * Functions specific to Book class
 */
public interface BookDao extends AbstractSuperDao<Book> {
    List<Book> getBooksInBooking(long id) throws DaoException;
}
