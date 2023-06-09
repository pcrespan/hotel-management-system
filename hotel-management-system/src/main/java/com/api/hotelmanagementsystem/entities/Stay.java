package com.api.hotelmanagementsystem.entities;

import com.api.hotelmanagementsystem.entities.pk.StayPK;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_stay")
public class Stay implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private StayPK id = new StayPK();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date arrival;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date leaving;

    public Stay() {
    }

    public Stay(Guest guest, Room room, Date arrival, Date leaving) {
        id.setGuest(guest);
        id.setRoom(room);
        this.arrival = arrival;
        this.leaving = leaving;
    }

    public void setRoom(Room room) {
        id.setRoom(room);
    }

    public void setGuest(Guest guest) {
        id.setGuest(guest);
    }

    public Room getRoom() {
        return id.getRoom();
    }

    @JsonIgnore
    public Guest getGuest() {
        return id.getGuest();
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public Date getLeaving() {
        return leaving;
    }

    public void setLeaving(Date leaving) {
        this.leaving = leaving;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stay stay = (Stay) o;
        return Objects.equals(id, stay.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
