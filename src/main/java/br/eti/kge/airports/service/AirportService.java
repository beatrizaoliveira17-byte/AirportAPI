package br.eti.kge.airports.service;

import br.eti.kge.airports.DTO.AirportMinDTO;
import br.eti.kge.airports.DTO.AirportNearMeDTO;
import br.eti.kge.airports.entities.Airport;
import br.eti.kge.airports.projections.AirportNearMeProjection;
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

    public List<Airport> findAll() {

        return airportRepository.findAll();

    }

    /**
     * Retorna DTO Airport por iataCode
     *
     * @param iataCode
     * @return
     */
    public Airport findByIataCode(String iataCode) {
        Airport result = airportRepository.findByIataCode(iataCode);

        return result;
    }

    /**
     * Retorna DTO AirportNearMe
     *
     * * @param latitude
     * @param longitude
     * @return
     */
    public List<AirportNearMeDTO> findNearMe(double latitude, double longitude) {
        List<AirportNearMeProjection> resultNearAirports = airportRepository.findNearMe(latitude, longitude);

        List<AirportNearMeDTO> resultDTO = resultNearAirports.stream()
                .map(x -> new AirportNearMeDTO(x)).toList();

        return resultDTO;
    }
}
