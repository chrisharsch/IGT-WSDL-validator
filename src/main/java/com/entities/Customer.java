package com.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int customerId;

    @NotNull
    private String lastName;

    @NotNull
    private String firstName;

    @NotNull
    private String email;


    @NotNull
    private Date birthDate;

    @Override
    public String
    toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public Customer() { }

    public Customer(int customerId) {
        this.customerId = customerId;
    }

    public Customer(String lastName, String firstName, Date birthDate, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCustomerId() {
        return customerId;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}