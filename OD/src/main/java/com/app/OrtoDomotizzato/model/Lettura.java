package com.app.OrtoDomotizzato.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Lettura {
	
	@Id 
	@GeneratedValue
	private Long id;
	
	@ManyToOne (cascade = CascadeType.PERSIST)
	private Sensore sensore;
	
	private double valore;
	private LocalDateTime timestamp;
	
	@PrePersist
	public void prePersist() {
		timestamp = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Sensore getSensore() {
		return sensore;
	}

	public void setSensore(Sensore sensore) {
		this.sensore = sensore;
	}

	public double getValore() {
		return valore;
	}

	public void setValore(double valore) {
		this.valore = valore;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
