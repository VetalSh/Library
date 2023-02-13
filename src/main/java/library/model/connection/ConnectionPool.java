package library.model.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Configures and obtains HikariDataSource that we use to connect to the dataBase.
 * return instance of HikariDataSource
 */
public class ConnectionPool {
    static ResourceBundle resourceBundle = ResourceBundle.getBundle("dataBase");
    private static final String DB_USER = resourceBundle.getString("db.user");
    private static final String DB_PASSWORD = resourceBundle.getString("db.password");
    private static String DB_URL = resourceBundle.getString("db.url");
    private static String DRIVER = resourceBundle.getString("driver");
    private static final Logger logger = LogManager.getLogger(ConnectionPool.class);
    private static HikariDataSource dataSource;

    private static final ConnectionPool instance = new ConnectionPool();

    static {
        try {
            dataSource = new HikariDataSource(getHikariConfig());
            logger.info("Connection pool initialized.");
        } catch (Exception e) {
            logger.fatal("Unable to init database pool: {}", e.getMessage());
        }
    }

    private ConnectionPool() {}

    public static ConnectionPool getInstance() {
        return instance;
    }

    public Connection getConnection() throws SQLException {
        Connection conn = dataSource.getConnection();
        logger.trace("New connection created {}", conn);
        return conn;
    }

    private static HikariConfig getHikariConfig() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(DB_URL);
        config.setUsername(DB_USER);
        config.setPassword(DB_PASSWORD);
        config.setDriverClassName(DRIVER);
        return config;
    }
}
