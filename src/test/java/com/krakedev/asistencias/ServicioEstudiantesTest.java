package com.krakedev.asistencias;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.asistencias.entidades.Estudiante;
import com.krakedev.asistencias.services.ServicioEstudiantes;

class ServicioEstudiantesTest {

    private ServicioEstudiantes servicio;

    @BeforeEach
    void setUp() {
        servicio = new ServicioEstudiantes();
    }

    @Test
    void testAgregarEstudiante() {
        Estudiante e = new Estudiante("1712345678", "Juan", "Pérez");
        servicio.agregar(e);

        assertNotNull(servicio.buscarPorCedula("1712345678"), 
            "El estudiante debería haberse agregado y ser encontrado");
    }

    @Test
    void testNoAgregarDuplicado() {
        Estudiante e1 = new Estudiante("1712345678", "Juan", "Pérez");
        Estudiante e2 = new Estudiante("1712345678", "Carlos", "Gómez");

        servicio.agregar(e1);
        servicio.agregar(e2); // No debería agregarse

        assertEquals(1, servicio.listar().size(), 
            "No debería permitir duplicados por cédula");
    }

    @Test
    void testBuscarPorCedula() {
        Estudiante e = new Estudiante("1756789123", "Ana", "López");
        servicio.agregar(e);

        Estudiante encontrado = servicio.buscarPorCedula("1756789123");
        
        assertNotNull(encontrado, "Debería encontrar el estudiante");
        assertEquals("Ana", encontrado.getNombre(), "El nombre no coincide");
        assertEquals("1756789123", encontrado.getCedula(), "La cédula no coincide");
    }
}