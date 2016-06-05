package com.controller;

import com.entities.Address;
import com.entities.Customer;
import com.entities.dao.AddressDao;

import com.entities.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.sql.Date;

@Controller
@RequestMapping(value = "/address",method = RequestMethod.GET)
public class AddressController {
    @Autowired
    private AddressDao _addressDao;

    @Autowired
    private CustomerDao _customerDao;

    @RequestMapping(value = "/add")
    @ResponseBody
    public String create(String city, String postcode, String street, Customer customer) {
        try {
            Address address = new Address(city, postcode, street,customer);
            _addressDao.save(address);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Address succesfully saved!";
    }
}


