package com.krakedev.asistencias.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.asistencias.entidades.Estudiante;
import com.krakedev.asistencias.services.ServicioEstudiantes;

@RestController

@RequestMapping("/estudiantes")
public class EstudianteController {

	private final ServicioEstudiantes servicioEstudiante;

	public EstudianteController(ServicioEstudiantes servicioEstudiante) {
		this.servicioEstudiante = servicioEstudiante;
	}

	@PostMapping
	public void agregar(@RequestBody Estudiante estudiante) {
		servicioEstudiante.agregar(estudiante);
	}

	@GetMapping
	public ArrayList<Estudiante> listar() {
		return servicioEstudiante.listar();
	}

	@GetMapping("/{cedula}")
	public Estudiante buscarPorCedula(@PathVariable String cedula) {
		return servicioEstudiante.buscarPorCedula(cedula);
	}

	@PutMapping("/{cedula}")
	public void actualizar(@PathVariable String cedula, @RequestBody Estudiante nuevo) {
		servicioEstudiante.actualizar(cedula, nuevo);
	}

	@DeleteMapping("/{cedula}")
	public void eliminar(@PathVariable String cedula) {
		servicioEstudiante.eliminar(cedula);
	}
}