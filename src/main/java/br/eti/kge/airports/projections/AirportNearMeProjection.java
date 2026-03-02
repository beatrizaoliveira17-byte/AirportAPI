
package br.eti.kge.airports.projections;

/**
 *Interface para mapear os atributos de Query personalizada
 * criada em AirportRepositories.
 * @author digma
 */
public interface AirportNearMeProjection {
    
    long getId();
    String getName();
    String getCity();
    String getIataCode();
    double getLatitude();
    double getLongitude();
    double getAltitude();
    double getDistanciaKM();
    
}
