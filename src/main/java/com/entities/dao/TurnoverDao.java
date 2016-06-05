package com.entities.dao;

import com.entities.Customer;
import com.entities.Turnover;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Zero on 30.05.2016.
 */
@Repository
@Transactional
public class TurnoverDao {
    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void save(Turnover turnover) {
        getSession().save(turnover);
    }
    public void update(Turnover turnover) {
        getSession().update(turnover);
    }

    @SuppressWarnings("unchecked")
    public double getTurnover(Customer customer){
        int id=customer.getCustomerId();
        String hql = "select amount from Turnover where customerId = :id";
        Session session= getSession();
        Query query = session.createQuery(hql);
        query.setInteger("id",id);
        List results = query.list();
        return (double)results.get(0);

    }

    public boolean checkDiscount(List<Customer> list,Customer customer,boolean peer){
        double allTurnover=0;
        double customerTurnover=getTurnover(customer);
        for(Customer temp :list) {
            allTurnover += getTurnover(temp);
        }
        if(peer==true){
            if(customerTurnover>(allTurnover+(allTurnover*0.2))){
                return true;
            }else{
                return false;
            }
        }else{
            if(customerTurnover>(allTurnover+(allTurnover*0.1))){
                return true;
            }else{
                return false;
            }
        }
    }
}