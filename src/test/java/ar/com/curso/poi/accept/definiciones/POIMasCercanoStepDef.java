package ar.com.curso.poi.accept.definiciones;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import ar.com.curso.poi.modelo.POI;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

public class POIMasCercanoStepDef {
	
	List<POI> listaDePoisEsperados = null;
	
	@Before
	public void before(){
		
		listaDePoisEsperados = new ArrayList<POI>();
		
		listaDePoisEsperados.add(new POI(-34.608379,-58.395596,"Clínica AMEBPBA","Hospital"));
		listaDePoisEsperados.add(new POI(-34.608379,-58.395596,"Clínica AMEBPBA planta baja","Hospital"));
	}

	private String url;
	private String urlBase;
	private String port;
	private String respuestaJson;
	private String latitud;
	private String longitud;

	public POIMasCercanoStepDef() {
		port = System.getProperty("servlet.port", "8080");
		urlBase = "http://localhost:" + port + "/pois-app";
	}

	@Dado("que estoy en (.*) y (.*)")
	public void estoy_en_una_latitud_y_longitud(String latitud, String longitud) {
		this.latitud = latitud;
		this.longitud = longitud;

	}

	@Cuando("pido el POI mas cercano del servicio (.*)")
	public void pido_los_puntos_mas_cercanos(String servicio) throws Exception {
		url = urlBase + "/poiMasCercano/" + servicio + "/" + latitud + "/" + longitud;
		respuestaJson = this.obtenerContenidoRespuesta(url);
	}

	@Entonces("el servicio devuelve solo (.*)")
	public void el_servicio_devuelve_el_nombre_de_un_poi(String poiEsperado) {
		assertThat(respuestaJson).contains(poiEsperado);
	}

	@Entonces("^el servicio devuelve una lista de puntos de interes$")
	public void el_servicio_devuelve_una_lista_de_puntos_de_interes(DataTable arg1) throws Throwable {
		
		List<POI> lista = arg1.asList(POI.class);
		
		for (POI poi : lista) {
			
			assertThat(this.listaDePoisEsperados).contains(poi);
		}
		
	}

	private String obtenerContenidoRespuesta(String url) throws Exception {
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		connection.connect();
		return new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
	}

}
