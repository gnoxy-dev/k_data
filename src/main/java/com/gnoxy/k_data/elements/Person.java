/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gnoxy.k_data.elements;

/**
 *
 * @author pmaher
 */
public class Person {
    private int id;
    private String fname;
    private String lname;
    
    public Person(int id, String first, String last) {
        this.id = id;
        this.fname = first;
        this.lname = last;
    }
    
    public String getFirstName() {
        return fname;
    }
    
    public String getLastName() {
        return lname;
    }
    
    public String getName() {
        return fname + " " + lname;
    }
    
    public String toString() {
        return
                " [Person: " +
                " Id: " + id +
                " First Name: " + fname +
                " Last Name: " + lname +
                "]"
                ;
    }
    
}
