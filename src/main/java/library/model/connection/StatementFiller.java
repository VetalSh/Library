package library.model.connection;

import library.model.entities.Entity;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Interface to be used in lambda-s in {@link library.model.connection.BaseDao} class.
 * Fills Prepared statement with data from Entity of given type
 */
@FunctionalInterface
public interface StatementFiller<T extends Entity> {
  int accept(T entity, PreparedStatement ps) throws SQLException;
}
