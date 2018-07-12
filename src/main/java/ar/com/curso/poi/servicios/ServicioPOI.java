package ar.com.curso.poi.servicios;

import ar.com.curso.poi.modelo.POI;

import java.util.List;

public interface ServicioPOI {

    List<POI> obtenerPOIs(String nombreCapa);

}
