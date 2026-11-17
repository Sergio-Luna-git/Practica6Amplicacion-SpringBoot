package com.example.practica6_ampliacion;


import com.example.practica6_ampliacion.models.Vehiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class VehiculoTest {
    private static final Logger myLogg = LoggerFactory.getLogger(VehiculoTest.class);
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public void ejecutar(){
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setMatricula("abcd1234");
        vehiculo.setMarca("Toyota");
        vehiculo.setModelo("Corolla");
        vehiculo.setAnioFabricacion(2019);
        vehiculo.setKilometraje(12000);

        myLogg.info("Vehiculo de ejemplo antes de guardar,{}", vehiculo);
        entityManager.persist(vehiculo);
        myLogg.info("Vehiculo de ejemplo después de guardar.{}", vehiculo);
        vehiculo.setModelo("Toyota modificado");
        entityManager.flush();
        myLogg.info("Esta siendo comprendido el vehiculo?, {}", entityManager.contains(vehiculo));
        myLogg.info("Lo pasamos a DETACHED");
        entityManager.detach(vehiculo);
        myLogg.info("¿El vehículo sigue gestionado? {}", entityManager.contains(vehiculo));
        Vehiculo vehiculoModificado = entityManager.merge(vehiculo);
        myLogg.info("Esta siendo comprendido el vehiculo merge?, {}", entityManager.contains(vehiculoModificado));
        }

}
