package com.example.practica6_ampliacion;

import com.example.practica6_ampliacion.enums.Estado;
import com.example.practica6_ampliacion.models.OrdenReparacion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class OrdenReparacionTest {
    public static final Logger myLogg = LoggerFactory.getLogger(OrdenReparacionTest.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void ejecutar(){
        OrdenReparacion ordenReparacion = new OrdenReparacion();
        ordenReparacion.setDescripcion("Descripcion");
        ordenReparacion.setFechaEntrada(LocalDate.of(2020,12,1));
        ordenReparacion.setEstado(Estado.FINALIZADA);
        ordenReparacion.setCosteEstimado(new BigDecimal("120.95"));

        myLogg.info("Orden de Reparacion de ejemplo antes de guardar, {}", ordenReparacion);
        entityManager.persist(ordenReparacion);
        myLogg.info("Orden de reparacion despues de guardarla, {}", ordenReparacion);
        ordenReparacion.setDescripcion("Descripcion modificada");
        entityManager.flush();
        myLogg.info("Lo pasamos a DETACHED o así");
        entityManager.detach(ordenReparacion);
        myLogg.info("¿La orden sigue gestionada? {}", entityManager.contains(ordenReparacion));
        OrdenReparacion ordenReparacionModificada = entityManager.merge(ordenReparacion);
        myLogg.info("Esta siendo comprendida la Orden de Reparacion modificada,{}", entityManager.contains(ordenReparacionModificada));
    }
}
