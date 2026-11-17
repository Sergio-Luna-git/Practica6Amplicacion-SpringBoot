package com.example.practica6_ampliacion.models;

import com.example.practica6_ampliacion.enums.Especialidad;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Table(name = "Mecanico")
@Entity
@Getter
@Setter
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class Mecanico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String nombre;

    @Column
    private  String apellidos;

    @Column
    private Especialidad especialidad;

    @Column
    private LocalDate fechaContratacion;

    @Column
    private int aniosExperiencia;

}
