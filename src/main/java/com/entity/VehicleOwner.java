package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by student on 2/28/17.
 */
@Entity
@Table(name = "vehicle_owner", schema = "ride_share")
@IdClass(VehicleOwnerPK.class)
public class VehicleOwner {
    private int userId;
    private User user;
    private int vehicleId;
    private Vehicle vehicle;
    private int maxRidersInclDriver;
    private int vin;
    private String insuranceProvider;
    private String driversLicense;
    private String licensePlate;

    @GenericGenerator(name="generator", strategy = "foreign")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "user_id", unique=true, nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public User getUser() {
        return this.user;
    }

    public void setUser(User user ) {
        this.user = user;
    }

    @Id
    @Column(name = "vehicle_id")
    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }



    @Column(name = "max_riders_incl_driver")
    public int getMaxRidersInclDriver() {
        return maxRidersInclDriver;
    }

    public void setMaxRidersInclDriver(int maxRidersInclDriver) {
        this.maxRidersInclDriver = maxRidersInclDriver;
    }

    @Column(name = "vin")
    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    @Column(name = "insurance_provider")
    public String getInsuranceProvider() {
        return insuranceProvider;
    }

    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }

    @Column(name = "drivers_license")
    public String getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(String driversLicense) {
        this.driversLicense = driversLicense;
    }

    @Column(name = "license_plate")
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehicleOwner that = (VehicleOwner) o;

        if (userId != that.userId) return false;
        if (vehicleId != that.vehicleId) return false;
        if (maxRidersInclDriver != that.maxRidersInclDriver) return false;
        if (vin != that.vin) return false;
        if (insuranceProvider != null ? !insuranceProvider.equals(that.insuranceProvider) : that.insuranceProvider != null)
            return false;
        if (driversLicense != null ? !driversLicense.equals(that.driversLicense) : that.driversLicense != null)
            return false;
        if (licensePlate != null ? !licensePlate.equals(that.licensePlate) : that.licensePlate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + vehicleId;
        result = 31 * result + maxRidersInclDriver;
        result = 31 * result + vin;
        result = 31 * result + (insuranceProvider != null ? insuranceProvider.hashCode() : 0);
        result = 31 * result + (driversLicense != null ? driversLicense.hashCode() : 0);
        result = 31 * result + (licensePlate != null ? licensePlate.hashCode() : 0);
        return result;
    }
}
