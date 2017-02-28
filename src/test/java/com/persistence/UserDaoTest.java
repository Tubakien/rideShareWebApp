package com.persistence;

import com.entity.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 2/26/17.
 */
public class UserDaoTest {
    UserDao dao;

    @Before
    public void setup() {
        dao = new UserDao();
    }

    @Test
    public void getAllUsers() throws Exception {

    }

    @Test
    public void addUser() throws Exception {
        User user = new User("test", "test@test.com", 1234567890);
        String username = "";
        int returnValue = dao.addUser(user);

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        SQLQuery output = session.createSQLQuery("SELECT username FROM user WHERE username=\'test\'");
        List<String> users = output.list();

        if (users.size() > 0) {
            username = users.get(0);
        }

        System.out.println(username);
        assertEquals("addUser failed",1, returnValue);
    }

//    @After
//    public void deleteTestUser() {
//        Session session = SessionFactoryProvider.getSessionFactory().openSession();
//        session.beginTransaction();
//        SQLQuery query = session.createSQLQuery("DELETE FROM user WHERE username = \'test\'");
//        query.executeUpdate();
//        session.getTransaction().commit();
//    }
}