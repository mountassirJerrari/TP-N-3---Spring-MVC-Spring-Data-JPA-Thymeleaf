package com.example.tp3.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Date;
import java.util.Objects;

@Data
@Entity
@AllArgsConstructor @NoArgsConstructor
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id ;
    @Temporal(TemporalType.DATE)
    private Date dateConsultation;
    @OneToOne
    private RendezVous rendezVous ;

}
