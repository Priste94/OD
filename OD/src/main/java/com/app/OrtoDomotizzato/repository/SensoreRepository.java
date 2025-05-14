package com.app.OrtoDomotizzato.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.OrtoDomotizzato.model.Sensore; 

public interface SensoreRepository extends JpaRepository<Sensore, Long>{
	
}
