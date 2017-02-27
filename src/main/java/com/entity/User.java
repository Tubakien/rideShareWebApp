package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by student on 2/26/17.
 */
@Entity
@Table(name="user")
public class User {
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
        this.username = username;
        this.email = email;
        this.phoneNumber = phone;
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
}
