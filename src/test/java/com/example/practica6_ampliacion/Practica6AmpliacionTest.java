package com.example.practica6_ampliacion;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Practica6AmpliacionTest {

    public static void main(String[] args) {
        SpringApplication.run(Practica6AmpliacionTest.class, args);
    }

    @Bean
    public CommandLineRunner run(ClienteTest clienteTest,
                                 MecanicoTest mecanicoTest,
                                 OrdenReparacionTest ordenReparacion,
                                 PiezaTest piezaTest,
                                 ProveedorTest proveedorTest,
                                 VehiculoTest vehiculoTest ){
        return args -> {

            clienteTest.ejecutar();
            mecanicoTest.ejecutar();
            ordenReparacion.ejecutar();
            piezaTest.ejecutar();
            proveedorTest.ejecutar();
            vehiculoTest.ejecutar();
        };
    }
}
