package com.app.OrtoDomotizzato.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.OrtoDomotizzato.model.Lettura;

public interface LetturaRepository extends JpaRepository<Lettura, Long>{
	
	List<Lettura> findTop5ByOrderByTimestampDesc();
	
}

