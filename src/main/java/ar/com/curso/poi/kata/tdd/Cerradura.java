package ar.com.curso.poi.kata.tdd;

public class Cerradura {

    private int claveDeApertura;
    private int cantidadFallos = 0;
    private int cantidadDeFallosConsecutivosQueLaBloquean;
    private boolean cerrada;
    private boolean bloqueada;
    
    public Cerradura(int claveDeApertura, 
            int cantidadDeFallosConsecutivosQueLaBloquean) {
        
        this.claveDeApertura = claveDeApertura;
        this.cantidadDeFallosConsecutivosQueLaBloquean = cantidadDeFallosConsecutivosQueLaBloquean;
        cerrada = true;
        bloqueada = false;
    }

    public boolean estaCerrada() {
        return cerrada;
    }

    public boolean fueBloqueada() {
        return bloqueada;
    }

    public boolean abrir(int clave) {
        if(clave == claveDeApertura){
            cerrada = false;    
            return true;
        }
        cantidadFallos++;
        if(cantidadFallos > cantidadDeFallosConsecutivosQueLaBloquean){
            bloqueada = true;
        }
        return false;
    }

    public Object contarAperturasExitosas() {
        return 1;
    }

    public void cerrar() {
        cerrada = true;
    }

}
