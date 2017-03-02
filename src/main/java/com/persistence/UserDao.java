package com.persistence;

import com.entity.User;
import org.hibernate.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2/26/17.
 */
public class UserDao {

    private final Logger log = Logger.getLogger(this.getClass());
    Session session;
    Transaction trans;

    /** Return a list of all users
     *
     * @return All users
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        users = session.createCriteria(User.class).list();
        return users;
    }

    public User getUser(String username) {
        session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();

        SQLQuery output = session.createSQLQuery("SELECT * FROM user WHERE username=\'test\'");
        output.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List users =  output.list();
        // TODO: get return from query to User Object
        return users.get(0);
    }

    /**
     * add a user
     *
     * @param user
     * @return the id of the inserted record.
     */
    public int addUser(User user) {
        int id = 0;
        session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            trans = session.beginTransaction();
            id = (int) session.save(user); // INSERT statement
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
