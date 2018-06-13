/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gnoxy.k_data.dao;

import com.gnoxy.k_data.elements.Person;

import java.util.Set;


/**
 *
 * @author pmaher
 */
public interface PersonDAO {
    public Set<Person> getPeople();
}
