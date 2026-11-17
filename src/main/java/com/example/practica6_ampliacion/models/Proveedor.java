package com.example.practica6_ampliacion.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@Entity
@ToString
@Table( name = "Proveedor")
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class Proveedor {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String nombre;

    @Column( unique = true )
    private String cif;

    @Column
    private String  telefono;

    @Column(nullable = true)
    private String email;

    @Column
    private boolean activo;

}
