package com.api.hotelmanagementsystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_guests")
public class Guest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Guest name cannot be blank.")
    private String name;
    @NotBlank(message = "Guest SSN cannot be blank.")
    private String socialSecurityNumber;

    @OneToMany(mappedBy = "id.guest")
    private List<Stay> stay = new ArrayList<>();

    public Guest() {
    }

    public Guest(Long id, String name, String socialSecurityNumber) {
        this.id = id;
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public List<Stay> getStay() {
        return stay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return Objects.equals(id, guest.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
