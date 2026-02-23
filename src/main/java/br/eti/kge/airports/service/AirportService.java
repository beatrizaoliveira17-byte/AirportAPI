package br.eti.kge.airports.service;

import br.eti.kge.airports.entities.Airport;
import br.eti.kge.airports.repositories.AirportRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author digma
 */

    
    @Service
public class AirportService {
        
    @Autowired
    private AirportRepository airportRepository;
   
    public List<Airport>findAll(){
       
        return airportRepository.findAll();
    }
}

