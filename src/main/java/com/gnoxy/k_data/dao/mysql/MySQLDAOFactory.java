/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gnoxy.k_data.dao.mysql;

import com.gnoxy.k_data.dao.DAOFactory;
import com.gnoxy.k_data.dao.PersonDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author pmaher
 */
public class MySQLDAOFactory extends DAOFactory {
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    private Connection connection;
    private MySQLPersonDAO person;

    public MySQLDAOFactory(String connectionString) throws SQLException {
        LOGGER.traceEntry();
        if (connection == null) {
//            try {
                connection = DriverManager.getConnection(connectionString);
//            } catch (SQLException ex) {
//                LOGGER.error(ex);
//            }
        }
        LOGGER.traceExit();
    }

    @Override
    public PersonDAO getPersonDAO() {
        if (person == null) {
            person = new MySQLPersonDAO(connection);
        }
        return person;
    }

    @Override
    public void close() {
        person = null;
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
