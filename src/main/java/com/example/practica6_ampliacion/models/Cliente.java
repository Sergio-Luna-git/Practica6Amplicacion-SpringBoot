package com.example.practica6_ampliacion.models;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "Cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Data
public class Cliente {
    @Id
    @Column
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @Column
    private String apellidos;

    @Column(unique = true, length = 9)
    private String dni;
    @Column
    private String telefono;

    @Column(unique = true)
    private String email;
}
