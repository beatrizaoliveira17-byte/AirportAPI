package br.eti.kge.airports.controllers;

import br.eti.kge.airports.entities.Airport;
import br.eti.kge.airports.service.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digma
 */
@RestController
public class AirportController {

    @Autowired

    private AirportService airportService;

    /**
     * Endpoint /airports/airport Retorna TODOS os aeroportos da base de dados.
     *
     * @return
     */
    @GetMapping("/airport")

    public List<Airport> findAll() {
        List<Airport> result = airportService.findAll();
        return result;
        
    }
        /**
         * Endpoint /airports/city/{cityName}
         * @param cityName
         * @return
         * 
         */
        
        @GetMapping("/city/{cityName}")
        public ResponseEntity<List<Airport>> findByCityIgnoreCase(@PathVariable String cityName){
        List<Airport> result = airportService.findByCity(cityName);
  
        
    if  (result.isEmpty()){
        // Ops.. Lista vazia
        // NotFound devolve 404
        
        return ResponseEntity.notFound().build();
        
                }else{
        // Oba! Tem dados.
        // Ok devolve 200
        return ResponseEntity.ok (result);
    }
            
        

        }
}


    

