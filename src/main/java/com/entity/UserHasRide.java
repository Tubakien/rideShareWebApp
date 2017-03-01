package com.entity;

import javax.persistence.*;

/**
 * Created by student on 2/28/17.
 */
@Entity
@Table(name = "user_has_ride", schema = "ride_share", catalog = "")
@IdClass(UserHasRidePK.class)
public class UserHasRide {
    private int userId;
    private int rideId;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "ride_id")
    public int getRideId() {
        return rideId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserHasRide that = (UserHasRide) o;

        if (userId != that.userId) return false;
        if (rideId != that.rideId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + rideId;
        return result;
    }
}
