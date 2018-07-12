package ar.com.curso.poi.servicios;

import ar.com.curso.poi.modelo.POI;

import java.util.List;

public class ServicioPOIImpl implements ServicioPOI {

    public List<POI> obtenerPOIs(String nombreCapa) {
        return CapaEjemplo.getInstance().getPOIs(nombreCapa);
    }

}
