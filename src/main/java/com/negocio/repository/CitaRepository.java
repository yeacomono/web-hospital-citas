package com.negocio.repository;

import com.negocio.entidades.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findCitaByPaciente_Idpaciente(Long idpaciente);
}
