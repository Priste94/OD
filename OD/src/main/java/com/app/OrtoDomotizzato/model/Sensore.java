package com.app.OrtoDomotizzato.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Sensore {
	
@Id 
@GeneratedValue
private Long id;

@Enumerated(EnumType.STRING)
public TipoSensore tipo;

public TipoSensore getTipo() {
	return tipo;
}
public void setTipo(TipoSensore tipo) {
	this.tipo = tipo;
}
@Enumerated(EnumType.STRING)
public PosizioneSensore posizione;

private String unità;

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}


public String getUnità() {
	return unità;
}
public void setUnità(String unità) {
	this.unità = unità;
}





}
