package com.persistence;

import com.entity.Vehicle;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by student on 2/28/17.
 */
public class VehicleDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * add a vehicle
     *
     * @param vehicle
     * @return the id of the inserted record.
     */
    public int addVehicle(Vehicle vehicle) {
        int id = 0;
        Session session = null;
        Transaction trans = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            trans = session.beginTransaction();
            id = (int) session.save(vehicle); // INSERT statement
            trans.commit();
        } catch (HibernateException he) {
            if (trans!=null) trans.rollback();
            log.error("HibernateException: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return id;
    }
}

}
