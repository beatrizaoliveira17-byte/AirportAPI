package br.eti.kge.airports.repositories;

import br.eti.kge.airports.entities.Airport;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author digma
 */


public interface AirportRepository  extends JpaRepository<Airport, Long> {
    
    List<Airport> findByCityIgnoreCase(String City);
}