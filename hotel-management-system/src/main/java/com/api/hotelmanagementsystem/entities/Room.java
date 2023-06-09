package com.api.hotelmanagementsystem.entities;

import com.api.hotelmanagementsystem.entities.enums.RoomStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_rooms")
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private RoomStatus status;

    @JsonIgnore
    @OneToMany(mappedBy = "id.room")
    private Set<Stay> stay = new HashSet<>();

    public Room() {
    }

    public Room(Long id, RoomStatus status) {
        this.id = id;
        this.status = status;
    }

    public Set<Stay> getStay() {
        return stay;
    }

    @JsonIgnore
    public boolean isFree() {
        return status.equals(RoomStatus.FREE);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
