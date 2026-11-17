package com.example.practica6_ampliacion;


import com.example.practica6_ampliacion.models.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
public class ClienteTest {
    private static final Logger myLogg = LoggerFactory.getLogger(ClienteTest.class);

    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public void ejecutar(){
        Cliente cliente = new Cliente();
        cliente.setNombre("Cliente");
        cliente.setApellidos("Ejemplo Cliente");
        cliente.setDni("12345678A");
        cliente.setTelefono("123456789");
        cliente.setEmail("cliente@ejemplo.com");

        myLogg.info("Cliente de ejemplo ANTES de ser guardado: {}" + cliente);
        entityManager.persist(cliente);
        myLogg.info("Cliente de ejemplo DESPUÉS de guardarlo: {}" + cliente);
        cliente.setNombre("Nombre modificado");
        myLogg.info("Esta siendo comprendido el cliente?, {}", entityManager.contains(cliente));
        entityManager.flush();
        myLogg.info("Lo pasamos a DETACHED");
        entityManager.detach(cliente);
        myLogg.info("¿El cliente sigue gestionado? {}", entityManager.contains(cliente));
        Cliente clienteModificado = entityManager.merge(cliente);
        myLogg.info("Esta siendo compendido el cliente modificado? {}", entityManager.contains(clienteModificado));


    }


}
