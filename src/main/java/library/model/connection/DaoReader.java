package library.model.connection;

import library.exceptions.DaoException;

import java.sql.Connection;

/**
 * Interface to be used in lambda-s in {@link library.model.connection.Transaction} class.
 * Reads something from DB, should be used in non-transaction
 */
@FunctionalInterface
public interface DaoReader<T> {
  T proceed(Connection c) throws DaoException;
}