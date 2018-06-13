/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gnoxy.k_data.dao.mysql;

import com.gnoxy.k_data.dao.PersonDAO;
import com.gnoxy.k_data.elements.Person;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author pmaher
 */
public class MySQLPersonDAO implements PersonDAO {
    private static final Logger LOGGER = LogManager.getLogger();
    private final Connection connection;

    public MySQLPersonDAO(Connection connection) {
        this.connection = connection;
    }    
    
    @Override
    public Set<Person> getPeople() {
        LOGGER.traceEntry();
        Set<Person> people = new HashSet<>();
        String query = "Select * from mytest.Persons";
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            if (resultSet != null) {
                while (resultSet.next()) {
                    people.add(new Person(resultSet.getInt("Id"), resultSet.getString("FirstName"), resultSet.getString("LastName")));
                }
            }
        } catch (SQLException ex) {
            LOGGER.error(ex);
        }
        LOGGER.traceExit();

        return people;
    }    
}
