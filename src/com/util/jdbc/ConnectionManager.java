package com.util.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.util.customexception.ExceptionMessages;
import com.util.customexception.TaskException;

public class ConnectionManager {

    private Connection connection;

    // Initiate Connection
    public void init_connection() throws TaskException {
        try {
            this.connection = DriverManager.getConnection(DbConfig.getDbUrl(),
            											  DbConfig.getDbUser(), 
            											  DbConfig.getDbPassword()
            											  );
        } 
        catch (SQLException e) {
            throw new TaskException(ExceptionMessages.CONNECTION_FAILED, e);
        }
    }

    // Get connection
    public Connection getConnection() {
        return this.connection;
    }

    
    // Stop Connection
    public void stop_connection() {
        if (this.connection != null) {
            
        	try {
                this.connection.close();
            } 
            catch (SQLException e) {
                // Log or handle silently
            }
        }
    }
}