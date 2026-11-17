package com.example.practica6_ampliacion.models;

import jakarta.persistence.*;
import lombok.*;

@Table( name = "Vehiculo")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Vehiculo {

    @Id
    @Column
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @Column( unique = true, length = 8)
    private String matricula;

    @Column
    private String marca;

    @Column
    private String modelo;

    @Column
    private int anioFabricacion;

    @Column( nullable = false)
    private int kilometraje;

    @Column
    @Transient
    private Cliente cliente;
}