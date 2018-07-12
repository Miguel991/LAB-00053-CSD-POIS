package curso.esfera.utils;

import curso.esfera.modelo.POI;

public class CalculadorDeDistancia {
		
	//6378.137 * ACos( Cos( Lat1 ) * Cos( Lat2 ) * Cos( Lon2 - Lon1 ) + Sin( Lat1 ) * Sin( Lat2 ) )
	
	//a = sin²(Δlat/2) + cos(lat1) · cos(lat2) · sin²(Δlong/2)
	
	//c = 2 · atan2(√a, √(1−a))

	//		d = R · c
	
	
	public static Double calcularDistanciaHaversine(POI puntoUno , POI puntoDos){
		
		double radioTierra = 6378.137;
		
		double diferenciaUno = puntoUno.getLatitud() - puntoDos.getLatitud();
		
		double diferenciaDos = puntoUno.getLongitud() - puntoDos.getLongitud();
		
		double distancia = Math.asin(diferenciaUno/2) + Math.cos(puntoUno.getLatitud()) * Math.cos(puntoDos.getLatitud()) * Math.asin(diferenciaDos/2);
		
		double c = 2 * Math.atan2(Math.sqrt(distancia), Math.sqrt(1-distancia));
				
		double distanciaReal = radioTierra * c;
		
		return distanciaReal;
	}
	
	public static int calcularDistancia(POI poi, POI ubicacionActual) {
		
		double distancia = Math.sqrt((Math.pow((poi.getLatitud()-ubicacionActual.getLatitud()),2) 
				           + Math.pow((poi.getLongitud()-ubicacionActual.getLongitud()),2)));
		
		
		Double a = distancia/1000;
		
		return a.intValue();
		
	}
	

}
