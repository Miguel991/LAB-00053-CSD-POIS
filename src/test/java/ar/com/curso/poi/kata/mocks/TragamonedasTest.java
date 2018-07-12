package ar.com.curso.poi.kata.mocks;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class TragamonedasTest {

	@Test
	public void siLosTresTamboresTienenElMismoValorDeberiaDarPremio(){
		
		Tambor tambor1Mock = mock(Tambor.class);
		Tambor tambor2Mock = mock(Tambor.class);
		Tambor tambor3Mock = mock(Tambor.class);
		
		when(tambor1Mock.obtenerPosicion()).thenReturn(3);
		when(tambor2Mock.obtenerPosicion()).thenReturn(3);
		when(tambor3Mock.obtenerPosicion()).thenReturn(3);
		
		Tragamonedas maquinita = new Tragamonedas(tambor1Mock, tambor2Mock, tambor3Mock);
		maquinita.activar();
		assertThat(maquinita.entregaPremio()).isTrue();
	}
	
	@Test
	public void siLosTresTamboresTienenDistintoValorNoDeberiaDarPremio(){
		
		Tambor tambor1Mock = mock(Tambor.class);
		Tambor tambor2Mock = mock(Tambor.class);
		Tambor tambor3Mock = mock(Tambor.class);
		
		when(tambor1Mock.obtenerPosicion()).thenReturn(3);
		when(tambor2Mock.obtenerPosicion()).thenReturn(4);
		when(tambor3Mock.obtenerPosicion()).thenReturn(1);

		Tragamonedas maquinita = new Tragamonedas(tambor1Mock, tambor2Mock, tambor3Mock);
		maquinita.activar();
		assertThat(maquinita.entregaPremio()).isFalse();
	}
	
	@Test
	public void verificarQueAlActivarElTragamonedasGirenLosTresTambores(){
		
		Tambor tambor1Mock = mock(Tambor.class);
		Tambor tambor2Mock = mock(Tambor.class);
		Tambor tambor3Mock = mock(Tambor.class);
		
		when(tambor1Mock.obtenerPosicion()).thenReturn(3);
		when(tambor2Mock.obtenerPosicion()).thenReturn(3);
		when(tambor3Mock.obtenerPosicion()).thenReturn(3);

		Tragamonedas maquinita = new Tragamonedas(tambor1Mock, tambor2Mock, tambor3Mock);
		maquinita.activar();
		
        verify(tambor1Mock, times(1)).girar();
		verify(tambor2Mock, times(1)).girar();
		verify(tambor3Mock, times(1)).girar();
	}
	
	@Test
	@SuppressWarnings("unused")
	public void verificarQueSiNoSeActivaElTragamonedasNoGirenLosTambores(){
		
		Tambor tambor1Mock = mock(Tambor.class);
		Tambor tambor2Mock = mock(Tambor.class);
		Tambor tambor3Mock = mock(Tambor.class);
		
		when(tambor1Mock.obtenerPosicion()).thenReturn(3);
		when(tambor2Mock.obtenerPosicion()).thenReturn(3);
		when(tambor3Mock.obtenerPosicion()).thenReturn(3);

		Tragamonedas maquinita = new Tragamonedas(tambor1Mock, tambor2Mock, tambor3Mock);
		
		verify(tambor1Mock, never()).girar();
		verify(tambor2Mock, never()).girar();
		verify(tambor3Mock, never()).girar();
	}
}
