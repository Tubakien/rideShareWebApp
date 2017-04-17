package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

// TO DO (Solved) 1452 Cannot add or update a child row: a foreign key constraint fails
/**
 * Created by student on 2/26/17.
 */
@Entity
@Table(name="user")
public class User {
//    private VehicleOwner vehicleOwner;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name="home_address_id")
    private int homeAddressId;

    @Column(name = "phone")
    private int phoneNumber;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="user_id")
    private int userId;

    public User() {
    }

    public User(String username, String email, int phone) {
        this();
        this.userId = 0;
        this.username = username;
        this.email = email;
        this.phoneNumber = phone;
        this.firstName = "";
        this.lastName = "";
//        this.vehicleOwner = null;
        this.homeAddressId = 1; // This is set to a  dummy row in database;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHomeAddressId() {
        return homeAddressId;
    }

    public void setHomeAddressId(int homeAddressId) {
        this.homeAddressId = homeAddressId;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "vehicle_owner", cascade = CascadeType.ALL)
//    public void setVehicleOwner(VehicleOwner vehicleOwner) {
//        this.vehicleOwner = vehicleOwner;
//    }
//
//    public VehicleOwner getVehicleOwner() {
//        return this.vehicleOwner;
//    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", homeAddressId=" + homeAddressId +
                ", phoneNumber=" + phoneNumber +
                ", userId=" + userId +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (phoneNumber != user.phoneNumber) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + phoneNumber;
        return result;
    }
}
