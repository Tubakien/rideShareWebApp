package com.persistence;

import com.entity.Address;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kien Warren on 4/17/17.
 */
public class AddressDao {
    private final Logger log = Logger.getLogger(this.getClass());

    public List<Address> getAllAddresses() {
        List<Address> addresses = new ArrayList<Address>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        addresses = session.createCriteria(Address.class).list();
        return addresses;
    }
    
    public Address getAddress(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        Address address = null;

        try {
            transaction = session.beginTransaction();
            address = (Address) session.get(Address.class, id);
            transaction.commit();
        }catch (HibernateException hibernateException) {
            if (transaction!=null) transaction.rollback();
            log.error("Hibernate Exception", hibernateException);
        }finally {
            session.close();
        }
        return address;
    }
    
    public void deleteAddress(int id) {
        Session session = null;
        Transaction trans = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.delete(getAddress(id));
            trans.commit();
        } catch (HibernateException he) {
            log.error("HibernateException: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


}
