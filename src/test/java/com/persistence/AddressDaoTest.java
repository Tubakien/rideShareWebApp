package com.persistence;

import com.entity.Address;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 4/17/17.
 */
public class AddressDaoTest {
    AddressDao dao;
    Address testAddress;

    @Before
    public void setUp() throws Exception {
        dao = new AddressDao();
        testAddress = new Address();
        testAddress.setAddress("123 Test Drvie, Test, WI 53700");
        testAddress.setBusinessName("Big Test Business, Inc.");
    }

    @Test
    public void getAllAddresses() throws Exception {
        List<Address> addresses = dao.getAllAddresses();
        boolean addressesLength;

        if (addresses.size() > 0) {
            addressesLength = true;
        } else {//
            addressesLength = false;
        }
        assertTrue(addressesLength);
    }

    @Test
    public void getAddress() throws Exception {

    }

    @Test
    public void deleteAddress() throws Exception {

    }

}