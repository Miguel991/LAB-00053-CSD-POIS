package curso.esfera.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import curso.esfera.modelo.POI;
import curso.esfera.utils.CalculadorDeDistancia;

public class CalcularDistanciaEntreDosPOITest {

	@Before
	public void before() {

	}

	@After
	public void after() {

	}

	@Test
	public void calcularDistanciaEntreDosPuntosTest() {

		// when then should
		// grupo esfera

		double latitudActual = -34.609499;
		double longitudActual = -58.396711;

		POI poi = new POI(-34.607915, -58.394529, "Sagrado Corazón", "Hospital");

		POI ubicacionActual = new POI(latitudActual, longitudActual, "Grupo Esfera", "Consultora");

		double distancia = CalculadorDeDistancia.calcularDistancia(ubicacionActual, poi);

		Assert.assertEquals(2.69d, distancia, 0.5);

	}

}
