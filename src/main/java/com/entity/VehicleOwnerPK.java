package com.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2/28/17.
 */
public class VehicleOwnerPK implements Serializable {
    private int userId;
    private int vehicleId;

    @Column(name = "user_id")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "vehicle_id")
    @Id
    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehicleOwnerPK that = (VehicleOwnerPK) o;

        if (userId != that.userId) return false;
        if (vehicleId != that.vehicleId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + vehicleId;
        return result;
    }
}
