package ar.com.curso.poi.kata.tdd;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class CerraduraTest {

    private Cerradura cerradura = new Cerradura(1234, 3);

    @Test
    public void crearCerraduraDeberiaEstarCerrada(){
        assertThat(cerradura.estaCerrada()).isTrue();
    }
    
    @Test
    public void crearCerraduraNoDeberiaEstarBloqueada(){
        assertThat(cerradura.fueBloqueada()).isFalse();
    }
    
    @Test
    public void abrirConClaveCorrectaDeberiaAbrirLaCerradura(){
        assertThat(cerradura.abrir(1234)).isTrue();
    }
    
    @Test
    public void abrirConClaveInCorrectaNoDeberiaAbrirLaCerradura(){
        assertThat(cerradura.abrir(4444)).isFalse();
    }
    
    @Test
    public void aperturaExitosaDeberiaIncrementarContador(){
        cerradura.abrir(1234);
        assertThat(cerradura.contarAperturasExitosas()).isEqualTo(1);
    }
    
    @Test
    public void cerrarCerraduraDeberiaCerrarla(){
        cerradura.abrir(1234);
        assertThat(cerradura.estaCerrada()).isFalse();
        cerradura.cerrar();
        assertThat(cerradura.estaCerrada()).isTrue();
    }
    
    @Test
    public void abrirMasDeNVecesConClaveInvalidaDeberiaBloqueaCerradura(){
        cerradura.abrir(444);
        assertThat(cerradura.estaCerrada()).isTrue();
        assertThat(cerradura.fueBloqueada()).isFalse();
        cerradura.abrir(444);
        assertThat(cerradura.estaCerrada()).isTrue();
        assertThat(cerradura.fueBloqueada()).isFalse();
        cerradura.abrir(444);
        assertThat(cerradura.estaCerrada()).isTrue();
        assertThat(cerradura.fueBloqueada()).isFalse();
        cerradura.abrir(444);
        assertThat(cerradura.estaCerrada()).isTrue();
        assertThat(cerradura.fueBloqueada()).isTrue();
    }
}
