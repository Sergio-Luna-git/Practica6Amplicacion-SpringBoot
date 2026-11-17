package com.example.practica6_ampliacion.models;


import com.example.practica6_ampliacion.enums.Estado;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table( name = "OrdenReparacion")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class OrdenReparacion {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String descripcion;

    @Column
    private LocalDate fechaEntrada;

    @Column
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(precision = 7, scale = 2)
    private BigDecimal costeEstimado;

    @Column
    @Transient
    private Vehiculo vehiculo;

    @Column
    @Transient
    private Mecanico mecanico;

}
