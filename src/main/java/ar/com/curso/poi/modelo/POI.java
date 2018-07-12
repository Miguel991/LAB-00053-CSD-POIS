package ar.com.curso.poi.modelo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class POI implements Serializable {
	
	private Double latitud;
	private Double longitud;
	private String nombre;
	private String descripcion;
	private String url;
	
	public POI() {
		
	}
	
	public POI(Double latitud, Double longitud, String nombre,String descripcion) {
		this.latitud = latitud;
		this.longitud = longitud;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = generarURL();
	}
	
	public POI(String latitud, String longitud) {
		
		try {
			this.latitud = Double.valueOf(latitud);
			this.longitud = Double.valueOf(longitud);
			
		}
		catch (NumberFormatException nfe) {
			this.latitud=0D;
			this.longitud=0D;
		}
		this.url = generarURL();
	}

	private String generarURL() {
		return "http://www.gorissen.info/Pierre/maps/googleMapLocation.php?lat="+ latitud + "&lon=" + longitud;
	}

	@XmlElement
	public Double getLatitud() {
		return latitud;
	}
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}
	
	@XmlElement
	public Double getLongitud() {
		return longitud;
	}
	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}
	
	@XmlElement
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@XmlElement
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "POI [latitud=" + latitud + ", longitud=" + longitud
				+ ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@XmlElement
	public String getUrl() {
		return url;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		POI poi = (POI) o;

		return nombre.equals(poi.nombre);
	}

	@Override
	public int hashCode() {
		return nombre.hashCode();
	}
}
