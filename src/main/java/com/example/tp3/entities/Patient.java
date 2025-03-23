package com.example.tp3.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissanec;
    private boolean malade;
    @OneToMany(mappedBy = "patient" , fetch = FetchType.LAZY)
    private Collection<com.tp2.demo.entities.RendezVous> rendezVous;
    private int score;
}
