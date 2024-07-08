package com.negocio.service;

import com.negocio.entidades.Cita;
import com.negocio.entidades.Paciente;
import com.negocio.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {
    @Autowired
    CitaRepository citaRepository;

    public Cita save(Cita cita){
        return citaRepository.save(cita);
    }

    public List<Cita> listCitabyUser(Paciente paciente){
        return citaRepository.findCitaByPaciente_Idpaciente(paciente.getIdpaciente());
    }

}
