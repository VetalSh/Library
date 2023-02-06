package library.model.connection;

import library.exceptions.DaoException;
import library.model.entities.Entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interface to be used in lambda-s in {@link library.model.connection.BaseDao} class.
 * Parses Result Set to Entity of given type
 */
@FunctionalInterface
public interface EntityParser<T extends Entity> {
  T accept(Connection c, ResultSet rs) throws SQLException, DaoException;
}