package com.gierat.anna.services.impl;

import com.gierat.anna.model.CustomerB2B;
import com.gierat.anna.services.ICustomerServiceB2B;
import com.gierat.anna.services.IHibernateSessionFactoryService;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Component
public class CustomerServiceB2B implements ICustomerServiceB2B {

    @Autowired
    public IHibernateSessionFactoryService sessionFactoryService;

    public void saveCustomer(CustomerB2B customerB2B) {
        Session session = this.sessionFactoryService.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(customerB2B);
        transaction.commit();
        session.close();
    }

    public CustomerB2B getCustomerById(int id) {
        Session session = this.sessionFactoryService.getSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery query = criteriaBuilder.createQuery(CustomerB2B.class);

        Root<CustomerB2B> root = query.from(CustomerB2B.class);

        query.select(root).where(criteriaBuilder.equal(root.get("id"),id));

        Query<CustomerB2B> q = session.createQuery(query);
        CustomerB2B customerB2B = q.getSingleResult();

        transaction.commit();
        session.close();
        return customerB2B;
    }

}

