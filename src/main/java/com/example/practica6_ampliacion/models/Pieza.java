package com.example.practica6_ampliacion.models;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "Pieza")

public class Pieza {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String nombre;

    @Column( unique = true, length = 6)
    private String codigo;

    @Column(scale = 2, precision = 6)
    private BigDecimal precio;

    @Column
    private int stock;

    @Column
    private boolean disponible;

}
