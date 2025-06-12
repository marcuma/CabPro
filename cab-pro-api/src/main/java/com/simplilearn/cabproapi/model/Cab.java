package com.simplilearn.cabproapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name="CabsPro")
@Table(name="Cabs")
public class Cab {
    @Id
    private Long id;

    @Column(name="cab_type")
    private String cabType;
    private Long rate;
}
