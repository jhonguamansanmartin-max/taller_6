package com.krakedev.asistencias.services;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.krakedev.asistencias.entidades.Estudiante;

@Service
public class ServicioEstudiantes {

    private ArrayList<Estudiante> estudiantes = new ArrayList<>();

    public void agregar(Estudiante estudiante) {
        if (buscarPorCedula(estudiante.getCedula()) == null) {
            estudiantes.add(estudiante);
            System.out.println("Estudiante agregado correctamente");
        } else {
            System.out.println("Ya existe un estudiante con esa cédula");
        }
    }

    public Estudiante buscarPorCedula(String cedula) {
        for (Estudiante e : estudiantes) {
            if (e.getCedula().equals(cedula)) {
                return e;
            }
        }
        return null;
    }

    public void eliminar(String cedula) {
        estudiantes.removeIf(e -> e.getCedula().equals(cedula));
    }

    public void actualizar(String cedula, Estudiante nuevo) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getCedula().equals(cedula)) {
                estudiantes.set(i, nuevo);
                return;
            }
        }
    }

    public ArrayList<Estudiante> listar() {
        return estudiantes;
    }
}