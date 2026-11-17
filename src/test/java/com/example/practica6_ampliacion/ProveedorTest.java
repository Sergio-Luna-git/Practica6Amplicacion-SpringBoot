package com.example.practica6_ampliacion;


import com.example.practica6_ampliacion.models.Proveedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ProveedorTest {
    private static final Logger myLogg = LoggerFactory.getLogger(PiezaTest.class);
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public void ejecutar(){
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre("Proveedor de ejemplo");
        proveedor.setCif("1234abcd");
        proveedor.setTelefono("12345678");
        proveedor.setEmail("proveedor@ejemplo.com");
        proveedor.setActivo(true);

        myLogg.info("Proveedor de ejemplo antes de guardar,{}", proveedor);
        entityManager.persist(proveedor);
        myLogg.info("Proveedor de ejemplo después de guardar,{}", proveedor);
        proveedor.setNombre("Nombre modificado");
        entityManager.flush();
        myLogg.info("Gestionado o no por el JPA,{}", entityManager.contains(proveedor));
        entityManager.detach(proveedor);
        myLogg.info("¿El proveedor sigue gestionado? {}", entityManager.contains(proveedor));
        Proveedor proveedorModificado = entityManager.merge(proveedor);
        myLogg.info("Esta siendo gestionado el proveedor merge?,{}", entityManager.contains(proveedorModificado));
    }
}
