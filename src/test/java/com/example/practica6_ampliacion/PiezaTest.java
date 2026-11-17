package com.example.practica6_ampliacion;


import com.example.practica6_ampliacion.models.Pieza;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PiezaTest {
    public static final Logger myLogg = LoggerFactory.getLogger(PiezaTest.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void ejecutar(){
        Pieza pieza = new Pieza();
        pieza.setNombre("Pieza de ejemplo");
        pieza.setCodigo("122345");
        pieza.setPrecio(new BigDecimal("99.99"));
        pieza.setStock(4);
        pieza.setDisponible(true);

        myLogg.info("Pieza de ejemplo antes de guardar,{}", pieza);
        entityManager.persist(pieza);
        myLogg.info("Pieza de ejemplo después de guardar,{}", pieza);

        myLogg.info("Pasamos con el setter el stock a 0");
        pieza.setStock(0);
        entityManager.flush();
        myLogg.info("Gestionada o no por JPA {}", entityManager.contains(pieza));
        myLogg.info("Lo pasamos a DETACHED");
        entityManager.detach(pieza);
        myLogg.info("¿La pieza sigue gestionada? {}", entityManager.contains(pieza));
        Pieza piezaGestionada = entityManager.merge(pieza);
        myLogg.info("La copia esta gestionada?. {}", entityManager.contains(piezaGestionada));
    }

}
