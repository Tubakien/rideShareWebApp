package com.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by student on 2/28/17.
 */
@Entity
public class Ride {
    private int rideId;
    private String departTime;
    private String recurrence;
    private int vehicleId;
    private String riderUserIds;
    private byte rideIsFull;
    private String pickupAddressesIds;

    @Id
    @Column(name = "ride_id")
    public int getRideId() {
        return rideId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    @Basic
    @Column(name = "depart_time")
    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    @Basic
    @Column(name = "recurrence")
    public String getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }

    @Basic
    @Column(name = "vehicle_id")
    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Basic
    @Column(name = "rider_user_ids")
    public String getRiderUserIds() {
        return riderUserIds;
    }

    public void setRiderUserIds(String riderUserIds) {
        this.riderUserIds = riderUserIds;
    }

    @Basic
    @Column(name = "ride_is_full")
    public byte getRideIsFull() {
        return rideIsFull;
    }

    public void setRideIsFull(byte rideIsFull) {
        this.rideIsFull = rideIsFull;
    }

    @Basic
    @Column(name = "pickup_addresses_ids")
    public String getPickupAddressesIds() {
        return pickupAddressesIds;
    }

    public void setPickupAddressesIds(String pickupAddressesIds) {
        this.pickupAddressesIds = pickupAddressesIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ride ride = (Ride) o;

        if (rideId != ride.rideId) return false;
        if (vehicleId != ride.vehicleId) return false;
        if (rideIsFull != ride.rideIsFull) return false;
        if (departTime != null ? !departTime.equals(ride.departTime) : ride.departTime != null) return false;
        if (recurrence != null ? !recurrence.equals(ride.recurrence) : ride.recurrence != null) return false;
        if (riderUserIds != null ? !riderUserIds.equals(ride.riderUserIds) : ride.riderUserIds != null) return false;
        if (pickupAddressesIds != null ? !pickupAddressesIds.equals(ride.pickupAddressesIds) : ride.pickupAddressesIds != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rideId;
        result = 31 * result + (departTime != null ? departTime.hashCode() : 0);
        result = 31 * result + (recurrence != null ? recurrence.hashCode() : 0);
        result = 31 * result + vehicleId;
        result = 31 * result + (riderUserIds != null ? riderUserIds.hashCode() : 0);
        result = 31 * result + (int) rideIsFull;
        result = 31 * result + (pickupAddressesIds != null ? pickupAddressesIds.hashCode() : 0);
        return result;
    }
}
