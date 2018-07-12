package ar.com.curso.poi.accept.definiciones;

import ar.com.curso.poi.modelo.POI;
import ar.com.curso.poi.servicios.ServicioPOI;
import ar.com.curso.poi.servicios.ServicioPOIImpl;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ServicioPOIStepDef{

	private String url;
	private String urlBase;
	private String port;
	private ServicioPOI servicio;
	private List<POI> puntosMasCercanos;
	private String respuestaJson;

	@Before
	public void setUp(){
		this.servicio = new ServicioPOIImpl();
		port = System.getProperty("servlet.port", "8080");
		urlBase = "http://localhost:" + port + "/pois-app";
	}

	@Dado("que estoy en cualquier locacion")
	public void estoy_en_cualquier_locacion(){

	}

	@Cuando("pido los puntos del servicio (.*)")
	public void pido_los_puntos_de_una_capa(String servicio) throws Exception {
		url = urlBase +"/pois/" + servicio;;
		respuestaJson = this.obtenerContenidoRespuesta(url);
	}

	@Entonces("el servicio devuelve una lista de puntos de interés")
	public void el_servicio_devuelve_una_listaPuntos(List<POI> puntosMasCercanosEsperados){
		for(POI cadaPOI : puntosMasCercanosEsperados){
			assertThat(respuestaJson).contains(cadaPOI.getNombre());
		}
	}

	private String obtenerContenidoRespuesta(String url) throws Exception {
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		connection.connect();
		return new BufferedReader( new InputStreamReader( connection.getInputStream() ) ).readLine();
	}

}
