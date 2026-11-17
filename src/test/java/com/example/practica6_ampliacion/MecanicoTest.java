package com.example.practica6_ampliacion;


import com.example.practica6_ampliacion.models.Mecanico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static com.example.practica6_ampliacion.enums.Especialidad.MOTOR;

@Component
public class MecanicoTest {
    private static final Logger myLogg = LoggerFactory.getLogger(MecanicoTest.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void ejecutar(){
        Mecanico mecanico = new Mecanico();
        mecanico.setNombre("Mecanico");
        mecanico.setApellidos("Ejemplo de Mecanico");
        mecanico.setEspecialidad(MOTOR);
        mecanico.setFechaContratacion(LocalDate.of(2020,12,1));
        mecanico.setAniosExperiencia(20);

        myLogg.info("Mecanico de ejemplo antes de conservarlo: {}", mecanico);
        entityManager.persist(mecanico);
        myLogg.info("Mecanico de ejemplo después de conservarlo: {}", mecanico);
        mecanico.setNombre("Nombre Modificado");
        entityManager.flush();
        myLogg.info("Pasamos a DETACHED ");
        entityManager.detach(mecanico);
        myLogg.info("¿El mecánico sigue gestionado? {}", entityManager.contains(mecanico));
        Mecanico mecanicoModificado = entityManager.merge(mecanico);
        myLogg.info("Esta siendo comprendido el mecanico modificado?,{}", entityManager.contains(mecanicoModificado));
    }
}
