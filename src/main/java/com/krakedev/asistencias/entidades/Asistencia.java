package com.krakedev.asistencias.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Asistencia {
	private LocalDate fechasClase;
	private LocalDateTime fechaHoraRegistro;
	private String estado;

	public LocalDate getFechasClase() {
		return fechasClase;
	}

	public void setFechasClase(LocalDate fechasClase) {
		this.fechasClase = fechasClase;
	}

	public LocalDateTime getFechaHoraRegistro() {
		return fechaHoraRegistro;
	}

	public void setFechaHoraRegistro(LocalDateTime fechaHoraRegistro) {
		this.fechaHoraRegistro = fechaHoraRegistro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Asistencia() {
	}

	public Asistencia(LocalDate fechasClase, LocalDateTime fechaHoraRegistro, String estado) {
		super();
		this.fechasClase = fechasClase;
		this.fechaHoraRegistro = fechaHoraRegistro;
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Asistencia [fechasClase=" + fechasClase + ", fechaHoraRegistro=" + fechaHoraRegistro + ", estado="
				+ estado + "]";
	}
	
	
}