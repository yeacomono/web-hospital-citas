package com.negocio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.negocio.entidades.Paciente;
import com.negocio.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	PacienteRepository pacienteRepository;
	
	public List<Paciente> listarTodo(){
		return pacienteRepository.findAll();
	}
	
	public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

	
}
