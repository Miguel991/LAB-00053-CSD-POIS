package ar.com.curso.poi.modelo;

import java.util.ArrayList;
import java.util.List;

public class Capa {
	
	protected	List <POI> POIs;
	private String nombre;
	
	public Capa (String unNombre) {
		
		this.POIs = new ArrayList<POI>();
		this.nombre = unNombre;

	}
	
	public List <POI> getPOIs() {
		
		return this.POIs;
	}

	public void agregar(POI unPOI) {
			POIs.add(unPOI);
	}

	public String getNombre() {
		return nombre;
	}

	public void setPOIs(List<POI> POIs) {
		this.POIs = POIs;
	}
}
