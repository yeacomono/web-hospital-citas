package com.negocio.entidades;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="paciente")
public class Paciente {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="idpaciente")
private Long idpaciente;

@Column(name="nombres")
private String nombres;

@Column(name="apaterno")
private String apaterno;

@Column(name="amaterno")
private String amaterno;

@Column(name="dni")
private String dni;

@Column(name="email")
private String email;

@Column(name="contraseña")
private String contraseña;

@Column(name="fechanac")
private LocalDate fechanac;

@OneToMany(mappedBy="paciente",cascade = CascadeType.ALL,orphanRemoval = true)
private List<Cita> citas;



public Long getIdpaciente() {
	return idpaciente;
}

public void setIdpaciente(Long idpaciente) {
	this.idpaciente = idpaciente;
}

public String getNombres() {
	return nombres;
}

public void setNombres(String nombres) {
	this.nombres = nombres;
}

public String getApaterno() {
	return apaterno;
}

public void setApaterno(String apaterno) {
	this.apaterno = apaterno;
}

public String getAmaterno() {
	return amaterno;
}

public void setAmaterno(String amaterno) {
	this.amaterno = amaterno;
}

public String getDni() {
	return dni;
}

public void setDni(String dni) {
	this.dni = dni;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getContraseña() {
	return contraseña;
}

public void setContraseña(String contraseña) {
	this.contraseña = contraseña;
}

public LocalDate getFechanac() {
	return fechanac;
}

public void setFechanac(LocalDate fechanac) {
	this.fechanac = fechanac;
}

public List<Cita> getCitas() {
	return citas;
}

public void setCitas(List<Cita> citas) {
	this.citas = citas;
}



public Paciente(Long idpaciente, String nombres, String apaterno, String amaterno, String dni, String email,
		String contraseña, LocalDate fechanac, List<Cita> citas) {
	this.idpaciente = idpaciente;
	this.nombres = nombres;
	this.apaterno = apaterno;
	this.amaterno = amaterno;
	this.dni = dni;
	this.email = email;
	this.contraseña = contraseña;
	this.fechanac = fechanac;
	this.citas = citas;
}



public Paciente() {
}




}
