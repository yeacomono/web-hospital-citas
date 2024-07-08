package com.negocio.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "citas")
public class Cita {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="idcitas")
private Long idcitas;

@ManyToOne
@JoinColumn(name="idpaciente",nullable = false)

private Paciente paciente;

@Column(name="sede")
private String sede;

@Column(name="modalidad")
private String modalidad;

@Column(name="especialidad")
private String especialidad;

@Column(name="fecha")
private String fecha;


public Long getIdcitas() {
	return idcitas;
}
public void setIdcitas(Long idcitas) {
	this.idcitas = idcitas;
}
public Paciente getPaciente() {
	return paciente;
}
public void setPaciente(Paciente paciente) {
	this.paciente = paciente;
}
public String getSede() {
	return sede;
}
public void setSede(String sede) {
	this.sede = sede;
}
public String getModalidad() {
	return modalidad;
}
public void setModalidad(String modalidad) {
	this.modalidad = modalidad;
}
public String getEspecialidad() {
	return especialidad;
}
public void setEspecialidad(String especialidad) {
	this.especialidad = especialidad;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}


public Cita(Long idcitas, Paciente paciente, String sede, String modalidad, String especialidad, String fecha) {
	this.idcitas = idcitas;
	this.paciente = paciente;
	this.sede = sede;
	this.modalidad = modalidad;
	this.especialidad = especialidad;
	this.fecha = fecha;
}


public Cita() {
}





}
