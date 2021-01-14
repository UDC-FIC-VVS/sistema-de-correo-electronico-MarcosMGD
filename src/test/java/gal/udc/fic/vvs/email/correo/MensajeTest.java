package gal.udc.fic.vvs.email.correo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Vector;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;

@RunWith(JUnitQuickcheck.class)
public class MensajeTest {
	
	public static final Texto TEXTO = new Texto("nombre","contenido");
	public static final Texto TEXTO_GRANDE =
			new Texto("nombre","CONTENIDOMAYORQUE32MAYORQUE32MAYOR");
	public static final boolean LEIDO = true;
	public static final boolean NO_LEIDO = false;

///////////////////////////////////// TESTS //////////////////////////////////////////	

	// Comprobar que el constructor no devuelva nulo
	@Test
	public void constructorMensajeNotNull() {
		
		Mensaje mensaje = new Mensaje(TEXTO);
		
		assertNotNull(mensaje);
		
	}
	
	// Comprobar que el constructor determine correctamente el
	//  contenido, con la operación obtenerTamaño
	@Test
	public void constructorMensajeContenido() {
		
		Mensaje mensaje = new Mensaje(TEXTO);
		
		assertEquals(TEXTO.obtenerTamaño(), mensaje.obtenerTamaño());
		
	}
	
	
	// Comprobar que el constructor determine correctamente el
	//  boolean _leido a false, con la operación obtenerNoLeidos
	@Test
	public void constructorMensajeLeido() {
		
		Mensaje mensaje = new Mensaje(TEXTO);
		
		assertEquals(1, mensaje.obtenerNoLeidos());
		
	}
	
	// Comprobar la funcion establecerLeido, que actualice el boolean
	//  a true
	@Test
	public void mensajeEstablecerLeido() {
		
		Mensaje mensaje = new Mensaje(TEXTO);
		mensaje.establecerLeido(LEIDO);
		
		assertEquals(0, mensaje.obtenerNoLeidos());
		
	}
	
	// Comprobar la funcion establecerLeido, que actualice el boolean
	//  a false
	@Test
	public void mensajeEstablecerNoLeido() {
		
		Mensaje mensaje = new Mensaje(TEXTO);
		mensaje.establecerLeido(NO_LEIDO);
		
		assertEquals(1, mensaje.obtenerNoLeidos());
		
	}
	
	
	// Comprobar la función obtenerNoLeidos, que deveria devolver 0 si
	// esta leido el mensaje
	@Test
	public void obtenerNoLeidosLeido() {
		
		Mensaje mensaje = new Mensaje(TEXTO);
		mensaje.establecerLeido(LEIDO);
		
		assertEquals(0, mensaje.obtenerNoLeidos());
		
	}
	
	// Comprobar la función obtenerNoLeidos, que deveria devolver 1 si
	// no esta leido el mensaje
	@Test
	public void obtenerNoLeidosNoLeido() {
		
		Mensaje mensaje = new Mensaje(TEXTO);
		mensaje.establecerLeido(NO_LEIDO);
		
		assertEquals(1, mensaje.obtenerNoLeidos());
		
	}
	
	// Comprobar obtenerTamaño, que coincida con el tamaño del texto del
	//	mensaje
	@Property
	public void obtenerTamaño( String nombreTexto, String contenido) {
		
		Texto texto = new Texto(nombreTexto, contenido);
		Mensaje mensaje = new Mensaje(texto);
		
		assertEquals(texto.obtenerTamaño(), mensaje.obtenerTamaño());
		
	}
	
	// Comprobar obtenerIcono en el caso de que esté leido
	@SuppressWarnings("deprecation")
	@Test
	public void obtenerIconoLeido() {
		
		Mensaje mensaje = new Mensaje(TEXTO);
		mensaje.establecerLeido(LEIDO);
		
		assertEquals(new Integer(2), mensaje.obtenerIcono());
		
	}
	
	// Comprobar obtenerIcono en el caso de que no esté leido
	@SuppressWarnings("deprecation")
	@Test
	public void obtenerIconoNoLeido() {
		
		Mensaje mensaje = new Mensaje(TEXTO);
		mensaje.establecerLeido(NO_LEIDO);
		
		assertEquals(new Integer(3), mensaje.obtenerIcono());
		
	}
	
	// Comprobar que el metodo obtenerPreVisualización devuelva el String
	//	según lo esperado
	@Test
	public void obtenerPreVisualización() {
		
		Mensaje mensaje = new Mensaje(TEXTO);		
		
		assertEquals("contenido...", mensaje.obtenerPreVisualizacion());
		
	}
	
	// Comprobar que el metodo obtenerPreVisualización devuelva el String
	//	según lo esperado si es mayor que 32 el contenido
	@Test
	public void obtenerPreVisualizaciónMayor32() {
		
		Mensaje mensaje = new Mensaje(TEXTO_GRANDE);		
		
		assertEquals("CONTENIDOMAYORQUE32MAYORQUE32MAY", mensaje.obtenerPreVisualizacion());
		
	}
	
	// Comprobar que el metodo obtenerPreVisualización devuelva el String
	//	sin pasar la longitud máxima permitida (TAMAÑO_PREVISUALIZACIÓN)
	@Test
	public void obtenerPreVisualizaciónMayor32MenorIgualTamañoPrevisualizacion() {
		
		Mensaje mensaje = new Mensaje(TEXTO_GRANDE);		
		
		assertTrue(mensaje.obtenerPreVisualizacion().length() <= 32);
		
	}
	
	// Comprobar que el metodo obtenerVisualización devuelva el String esperado
	@Test
	public void obtenerVisualización() {
		
		Mensaje mensaje = new Mensaje(TEXTO_GRANDE);		
		
		assertEquals(TEXTO_GRANDE.obtenerContenido(), mensaje.obtenerVisualizacion());
		
	}
	
	// Comprobar que buscar devuelve el mensaje si la visualización coincide
	@Test
	public void buscarMensaje() {
		
		Mensaje mensaje = new Mensaje(TEXTO_GRANDE);		
		
		Collection resultado = mensaje.buscar(TEXTO_GRANDE.obtenerContenido());
		
		assertTrue(!resultado.isEmpty());
		
	}
	
	// Comprobar que buscar devuelve el mensaje conteniendo una parte
	@Test
	public void buscarMensajeIncompleto() {
		
		Mensaje mensaje = new Mensaje(TEXTO_GRANDE);		
		
		String textoGrandeIncompleto = TEXTO_GRANDE.obtenerContenido().substring(5, 10);
		Collection resultado = mensaje.buscar(textoGrandeIncompleto);
		
		assertTrue(!resultado.isEmpty());
		
	}
	
	// Comprobar que buscar no devuelve el mensaje si la visualización no coincide
	@Test
	public void buscarMensajeErroneo() {
		
		Mensaje mensaje = new Mensaje(TEXTO_GRANDE);		
		
		Collection resultado = mensaje.buscar("NOEXISTE");
		
		assertTrue(resultado.isEmpty());
		
	}	
}
