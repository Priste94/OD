package com.app.OrtoDomotizzato.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.OrtoDomotizzato.model.Evento;


public interface EventoRepository extends JpaRepository<Evento, Long>{
	
}

