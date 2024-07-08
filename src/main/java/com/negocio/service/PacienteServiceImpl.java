package com.negocio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.negocio.entidades.Paciente;
import com.negocio.repository.PacienteRepository;
import com.negocio.repository.PacienteServiceImple;

@Service
public class PacienteServiceImpl implements PacienteServiceImple{

	private final PacienteRepository pacienteRepository;

	@Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

	@Override
    public Paciente autenticar(String dni, String contraseña) {
        return pacienteRepository.findByDniAndContraseña(dni, contraseña);
    }
	
}
