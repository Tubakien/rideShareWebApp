package com.persistence;

import com.entity.VehicleOwner;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by student on 4/11/17.
 */
public class VehicleOwnerDao {
    private final Logger log = Logger.getLogger(this.getClass());

    public int addVehicleOwner(VehicleOwner vehicleOwner){
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        int id = 0;
        try {
            tx = session.beginTransaction();
            id = (int) session.save(vehicleOwner);
            tx.commit();
        } catch (HibernateException e) {
            if (tx !=  null) tx.rollback();
            log.error("Hibernate Exception", e);
        } finally {
            session.close();
        }
        return id;
    }

    public List<VehicleOwner> getAllVehicleOwners() {
        List<VehicleOwner> vehicleOwners = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        try {
            vehicleOwners = session.createCriteria(VehicleOwner.class).list();
        } catch (HibernateException e) {
            log.error("Hibernate Exception", e);
        }finally {
            session.close();
        }

        return vehicleOwners;
    }

    public VehicleOwner getVehicleOwner(int id) {
        VehicleOwner vehicleOwner = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            vehicleOwner = (VehicleOwner) session.get(VehicleOwner.class, id);
        } catch (HibernateException e) {
            log.error("Hibernate Exception", e);
        } finally {
            session.close();
        }

        return vehicleOwner;
    }
}
