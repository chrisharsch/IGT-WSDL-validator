package com.controller;

import com.entities.Order;
import com.entities.Customer;
import com.entities.dao.OrderDao;

import com.entities.dao.CustomerDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/order", method = RequestMethod.GET)
public class OrderController {
    @Autowired
    private OrderDao _orderDao;
    @Autowired
    private CustomerDao _customerDao;

    @RequestMapping(value = "/add")
    @ResponseBody
    public String create(int customerId, double value) {
        try {
            Customer customer = _customerDao.getCustomer(customerId);
            Order order = new Order(customer, value);
            _orderDao.save(order);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Order succesfully saved!";
    }
}


