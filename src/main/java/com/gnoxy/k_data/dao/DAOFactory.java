/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gnoxy.k_data.dao;

import com.gnoxy.k_data.dao.mysql.MySQLDAOFactory;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author pat
 */
public abstract class DAOFactory {

    private static final Logger LOGGER = LogManager.getLogger();

    public abstract PersonDAO getPersonDAO();

    public static DAOFactory getDAOFactory(String factoryType, String connectionString) throws SQLException {
        LOGGER.traceEntry();
        if (factoryType.equalsIgnoreCase("MySQL")) {
            return new MySQLDAOFactory(connectionString);
        }
        
        LOGGER.traceExit();
        return null;
    }
    
    public abstract void close();

}
