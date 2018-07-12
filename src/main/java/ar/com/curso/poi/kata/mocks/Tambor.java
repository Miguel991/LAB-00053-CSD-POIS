package ar.com.curso.poi.kata.mocks;

import java.util.Random;

public class Tambor {
	
	private Integer valor = 0;
	
	public Integer obtenerPosicion() {
		return valor;
	}
	
	public void girar() {
		Random ramdom = new Random();
		valor = ramdom.nextInt(8) + 1;
	}

}
