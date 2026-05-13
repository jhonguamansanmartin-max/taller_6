package com.krakedev.asistencias.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.entidades.Asistencia;
import com.krakedev.asistencias.entidades.Estudiante;
import com.krakedev.asistencias.entidades.RegistroAsistencia;

@Service
public class ServicioAsistencia {
	private ArrayList<RegistroAsistencia> registros = new ArrayList<>();
	private final ServicioEstudiantes servicioEstudiantes;

	public ServicioAsistencia(ServicioEstudiantes servicioEstudiantes) {
		this.servicioEstudiantes = servicioEstudiantes;
	}

	public RegistroAsistencia registrarAsistencia(String cedula) {
		Estudiante encontrado = servicioEstudiantes.buscarPorCedula(cedula);
		if (encontrado != null) {

			Asistencia asistencia = new Asistencia();
			asistencia.setFechasClase(LocalDate.now());
			asistencia.setFechaHoraRegistro(LocalDateTime.now());
			asistencia.setEstado("P");

			RegistroAsistencia r = new RegistroAsistencia(encontrado, asistencia);
			registros.add(r);
			return r;
		} else {
			return null;
		}
	}

	public ArrayList<Asistencia> consultarAsistencia(String cedula) {
		ArrayList<Asistencia> a = new ArrayList<Asistencia>();
		Estudiante encontrado = servicioEstudiantes.buscarPorCedula(cedula);
		for (RegistroAsistencia r : registros) {
			if (r.getEstudiante().equals(encontrado)) {
				a.add(r.getAsistencia());
			}
		}
		return a;
	}
}