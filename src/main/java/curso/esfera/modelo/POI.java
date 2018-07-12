package curso.esfera.modelo;

public class POI {
	
	private Double latitud;
	private Double longitud;
	private String nombre;
	private String descripcion;
	
	public POI(Double latitud, Double longitud, String nombre, String descripcion) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public Double getLatitud() {
		return latitud;
	}
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}
	public Double getLongitud() {
		return longitud;
	}
	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
