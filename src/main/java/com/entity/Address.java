package com.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by student on 2/28/17.
 */
@Entity
public class Address {
    private int addressId;
    private String address;
    private byte isBusiness;
    private String businessName;

    public Address() {
    }

    public Address(String address) {
        this.address = address;
    }

    @Id
    @Column(name = "address_id")
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "is_business")
    public byte getIsBusiness() {
        return isBusiness;
    }

    public void setIsBusiness(byte isBusiness) {
        this.isBusiness = isBusiness;
    }

    @Basic
    @Column(name = "business_name")
    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address1 = (Address) o;

        if (addressId != address1.addressId) return false;
        if (isBusiness != address1.isBusiness) return false;
        if (address != null ? !address.equals(address1.address) : address1.address != null) return false;
        if (businessName != null ? !businessName.equals(address1.businessName) : address1.businessName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addressId;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (int) isBusiness;
        result = 31 * result + (businessName != null ? businessName.hashCode() : 0);
        return result;
    }
}
