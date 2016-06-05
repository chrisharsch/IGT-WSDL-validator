package com.entities;

import javax.persistence.*;
import javax.sql.rowset.serial.SerialArray;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Severin on 28.05.2016.
 */
@Entity
public class Address implements Serializable{

    @Id
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="customerId")
    Customer customer;

    @NotNull
    String postcode;


    @NotNull
    String city;

    @NotNull
    String street;



    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }


    public Customer getCustomer() {
        return customer;
    }

    public Address(String city, String postcode, String street,Customer customer) {
        this.city = city;
        this.postcode = postcode;
        this.street = street;
        this.customer=customer;
    }

    public Address() {
    }
}
