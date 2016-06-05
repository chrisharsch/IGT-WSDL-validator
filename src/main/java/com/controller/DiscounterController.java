package com.controller;

import com.entities.Customer;
import com.entities.dao.ArticleDao;
import com.entities.dao.CustomerDao;
import com.entities.dao.TurnoverDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/discount")
public class DiscounterController {
    @Autowired
    private CustomerDao _customerDao;
    @Autowired
    private TurnoverDao _turnoverDao;
    @RequestMapping(value = "/calculate")
    @ResponseBody
    public String create(int customerId) {
        try {
            Customer customer=_customerDao.getCustomer(customerId);
            boolean discount= _turnoverDao.checkDiscount(_customerDao.getPeerGroup(customerId),customer,true);
            if(discount==false){
                discount=_turnoverDao.checkDiscount(_customerDao.getAllUser(),customer,false);
            }
            return ""+discount;
        } catch (Exception ex) {
            return ex.getMessage();
        }

    }

}