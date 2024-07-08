package com.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.negocio.entidades.Paciente;
import java.util.List;


public interface PacienteRepository extends JpaRepository<Paciente, Long>{

	Paciente findByDniAndContraseña(String dni, String contraseña);
	

}
