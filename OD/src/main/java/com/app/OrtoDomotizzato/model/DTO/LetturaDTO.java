package com.app.OrtoDomotizzato.model.DTO;

import java.time.LocalDateTime;

import com.app.OrtoDomotizzato.model.TipoSensore;

public class LetturaDTO {

    private String tipoSensore;
    
    private double valore;
    private LocalDateTime timestamp;
    private String posizione;

    public LetturaDTO(String tipoSensore, double valore, LocalDateTime timestamp) {
        this.tipoSensore = tipoSensore;
        this.valore = valore;
        this.timestamp = timestamp;
    }

    public LetturaDTO(TipoSensore tipo, double valore, LocalDateTime timestamp) {
		this.tipoSensore = tipoSensore;
        this.valore = valore;
        this.timestamp = timestamp;
	}

	// Getters e setters
    public String getTipoSensore() {
        return tipoSensore;
    }

    public void setTipoSensore(String tipoSensore) {
        this.tipoSensore = tipoSensore;
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

	public String getPosizione() {
		return posizione;
	}

	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}
}
