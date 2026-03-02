package br.eti.kge.airports.controllers;

import br.eti.kge.airports.DTO.AirportMinDTO;
import br.eti.kge.airports.DTO.AirportNearMeDTO;
import br.eti.kge.airports.entities.Airport;
import br.eti.kge.airports.service.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     *
     * @param countryName
     * @return
     *
     */

    @GetMapping("/iatacode/{iataCode}")
    public ResponseEntity<Airport> findByIataCode(@PathVariable String iataCode) {
        Airport result = airportService.findByIataCode(iataCode);

        if (result == null) {
            // Ops.. Aeroporto vazio
            // NotFound devolve 404

            return ResponseEntity.notFound().build();

        } else {
            // Oba! Tem dados.
            // Ok devolve 200
            return ResponseEntity.ok(result);
        }

    }
    /**
 * Endpoint /airports/nearme
 * Retorna os aeroportos próximos a coordenada enviada como parâmetro
 * da requisição GET.
 *
 * @param latitude
 * @param longitude
 * @return
 */
@GetMapping("/nearme")
public ResponseEntity<List<AirportNearMeDTO>> findNearMe(
        @RequestParam double latitude,
        @RequestParam double longitude ) {

    List<AirportNearMeDTO> result = airportService.findNearMe(latitude, longitude);

    if (result.isEmpty()) {
        // Ops.. lista vazia...
        // notFound devolve 404
        return ResponseEntity.notFound().build();

    } else {
        // Eba! Tem dados!
        // ok devolve 200
        return ResponseEntity.ok(result);
    }
}
}
