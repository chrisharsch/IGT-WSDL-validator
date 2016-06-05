package com.entities.dao;

import javax.transaction.Transactional;

import com.entities.Customer;
import com.entities.Turnover;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class CustomerDao {
    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void save(Customer customer) {
        getSession().save(customer);
    }

    @SuppressWarnings("unchecked")
    public List<Customer> getAllUser() {
        List<Customer> result = (List<Customer>) getSession().createQuery("from Customer").list();
        return result;
    }
    @SuppressWarnings("unchecked")
    public List<Customer> getPeerGroup(int id) {
        String hql = "select birthDate from Customer where customerId like :id";
        Session session= getSession();
        Query query = session.createQuery(hql);
        query.setInteger("id",id);
        List results = query.list();
        Date customerDate=(Date)results.get(0);
        Date date=  new java.sql.Date(customerDate.getTime());
        Date date2= new java.sql.Date(customerDate.getTime());
        date.setYear(customerDate.getYear()+5);
        date2.setYear(customerDate.getYear()-5);
        hql = "from Customer where (birthDate between :date2 and :date) and (customerId != :id)";
        query = session.createQuery(hql);
        query.setDate("date",date);
        query.setDate("date2",date2);
        query.setInteger("id",id);
        List<Customer> result = query.list();
        return result;
    }
    @SuppressWarnings("unchecked")
    public Customer getCustomer(int id){
        String hql = "from Customer where customerId like :id";
        Session session= getSession();
        Query query = session.createQuery(hql);
        query.setInteger("id",id);
        List results = query.list();
        return (Customer)results.get(0);
    }

    @SuppressWarnings("unchecked")
    public Turnover getTurnover(int id){
        String hql = "from Turnover where customerId like :id";
        Session session= getSession();
        Query query = session.createQuery(hql);
        query.setInteger("id",id);
        List results = query.list();
        return (Turnover) results.get(0);
    }
}
