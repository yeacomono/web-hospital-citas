package com.negocio.repository;

import com.negocio.entidades.Paciente;


public interface PacienteServiceImple {

	Paciente autenticar(String sni, String contraseña);

}
