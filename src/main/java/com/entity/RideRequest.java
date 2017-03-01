package com.entity;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by student on 2/28/17.
 */
@Entity
@Table(name = "ride_request", schema = "ride_share", catalog = "")
public class RideRequest {
    private int requestId;
    private String recurrenceDays;
    private String recurrenceDaysFulfilled;
    private Time dropoffTime;

    @Id
    @Column(name = "request_id")
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    @Basic
    @Column(name = "recurrence_days")
    public String getRecurrenceDays() {
        return recurrenceDays;
    }

    public void setRecurrenceDays(String recurrenceDays) {
        this.recurrenceDays = recurrenceDays;
    }

    @Basic
    @Column(name = "recurrence_days_fulfilled")
    public String getRecurrenceDaysFulfilled() {
        return recurrenceDaysFulfilled;
    }

    public void setRecurrenceDaysFulfilled(String recurrenceDaysFulfilled) {
        this.recurrenceDaysFulfilled = recurrenceDaysFulfilled;
    }

    @Basic
    @Column(name = "dropoff_time")
    public Time getDropoffTime() {
        return dropoffTime;
    }

    public void setDropoffTime(Time dropoffTime) {
        this.dropoffTime = dropoffTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RideRequest that = (RideRequest) o;

        if (requestId != that.requestId) return false;
        if (recurrenceDays != null ? !recurrenceDays.equals(that.recurrenceDays) : that.recurrenceDays != null)
            return false;
        if (recurrenceDaysFulfilled != null ? !recurrenceDaysFulfilled.equals(that.recurrenceDaysFulfilled) : that.recurrenceDaysFulfilled != null)
            return false;
        if (dropoffTime != null ? !dropoffTime.equals(that.dropoffTime) : that.dropoffTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = requestId;
        result = 31 * result + (recurrenceDays != null ? recurrenceDays.hashCode() : 0);
        result = 31 * result + (recurrenceDaysFulfilled != null ? recurrenceDaysFulfilled.hashCode() : 0);
        result = 31 * result + (dropoffTime != null ? dropoffTime.hashCode() : 0);
        return result;
    }
}
