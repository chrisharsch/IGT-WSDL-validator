package com.controller;

import com.entities.Address;
import com.entities.Customer;
import com.entities.Turnover;
import com.entities.dao.AddressDao;
import com.entities.dao.CustomerDao;

import com.entities.dao.TurnoverDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private CustomerDao _customerDao;
    @Autowired
    private AddressDao _addressDao;
    @Autowired
    private TurnoverDao _turnoverDao;

    @RequestMapping(value = "/add")
    @ResponseBody
    public String create(String lastName, String firstName, Date birthDate, String email,String street,String postcode, String city) {
        try {
            Customer customer = new Customer(lastName, firstName, birthDate, email);
            Address address= new Address(city,postcode,street,customer);
            Turnover turnover= new Turnover(0,customer);
            _customerDao.save(customer);
            _addressDao.save(address);
            _turnoverDao.save(turnover);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "User succesfully added!";
    }

    @RequestMapping(value = "/peer")
    @ResponseBody
    public List<Customer> peer(){
        return _customerDao.getPeerGroup(2);
    }

}
