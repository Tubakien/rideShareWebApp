package com.persistence;

import com.entity.Ride;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by student on 4/12/17.
 */
public class RideDao {
    private final Logger log = Logger.getLogger(this.getClass());

    public int addRide(Ride ride) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        int id = 0;
        try {
            tx = session.beginTransaction();
            id = (int) session.save(ride);
            tx.commit();
        } catch (HibernateException e) {
            if (tx !=  null) tx.rollback();
            log.error("Hibernate Exception", e);
        } finally {
            session.close();
        }

        return id;
    }
}
