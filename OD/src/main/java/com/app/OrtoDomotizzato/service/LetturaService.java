package com.app.OrtoDomotizzato.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.OrtoDomotizzato.model.Evento;
import com.app.OrtoDomotizzato.model.Lettura;
import com.app.OrtoDomotizzato.model.TipoSensore;
import com.app.OrtoDomotizzato.model.DTO.LetturaDTO;
import com.app.OrtoDomotizzato.repository.*;

@Service
public class LetturaService {
	
	TipoSensore tipoSensore;

	@Autowired
	private  LetturaRepository letturaRepo;
	
	@Autowired
	private  EventoRepository eventoRepo;
	
	public void salvaLettura(Lettura lettura) {
		if(lettura.getSensore().getTipo().toString().equalsIgnoreCase(tipoSensore.temperatura.toString())){
			lettura.getSensore().setUnità("°C");
		}
		if(lettura.getSensore().getTipo().toString().equalsIgnoreCase(tipoSensore.umidità.toString())){
			lettura.getSensore().setUnità("%");
		}
		letturaRepo.save(lettura);
	}
	public void salvaLettura(List<Lettura> letture) {
		for (Lettura lettura : letture) {
	
        String tipo = lettura.getSensore().getTipo().toString();

        if (tipo.equalsIgnoreCase(tipoSensore.temperatura.toString())) {
            lettura.getSensore().setUnità("°C");
        } else if (tipo.equalsIgnoreCase(tipoSensore.umidità.toString())) {
            lettura.getSensore().setUnità("%");
        }

        // TODO: qui sarebbe bene cercare sensori già esistenti per evitare duplicati

        letturaRepo.save(lettura);
    }
	}
	
	public List<LetturaDTO> ultimeLetture() {
        return letturaRepo.findTop5ByOrderByTimestampDesc()
                .stream()
                .map(l -> new LetturaDTO(
                        l.getSensore().getTipo(), // <-- prendi il tipo dal Sensore
                        l.getValore(),
                        l.getTimestamp()
                ))
                .collect(Collectors.toList());
    }
	
	public void controllaUmidita() {
		
			List<LetturaDTO> recenti = ultimeLetture();
			for (LetturaDTO l : recenti) {
				if (TipoSensore.umidità.toString().equalsIgnoreCase(l.getTipoSensore().toString()) && l.getValore() < 30) {
					
					Evento e = new Evento();
					e.setTipo("ALLARME");
					e.setMessaggio("Umidità troppo bassa (" + l.getValore() + "%)");
					eventoRepo.save(e);
				}
			}
			
	}
	
}
