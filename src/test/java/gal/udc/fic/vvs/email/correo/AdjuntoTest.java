package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class AdjuntoTest {

	public static final String NOMBRE1 = "nombre1";
	public static final String CONTENIDO1 = "contenido1";
	
	public static final Texto TEXTO1 = new Texto(NOMBRE1, CONTENIDO1);
	
	Mensaje MENSAJE = new Mensaje(TEXTO1);
	
	public static final String NOMBRE = "nombreArchivo";
	public static final String CONTENIDO = "contenidoArchivo";
	
	Texto TEXTO = new Texto(NOMBRE, CONTENIDO);
	
///////////////////////////////////// TESTS //////////////////////////////////////////	

	// Probamos que el constructor no devuelva nulo
	@Test
	public void constructorAdjuntoNotNull() {
		
		Adjunto adjunto = new Adjunto(MENSAJE, TEXTO);
		
		assertNotNull(adjunto);
		
	}
	
	// Comprobamos que obtener tamaño devuelva el tamaño del mensaje + del propio
	//		archivo
	@Test
	public void adjuntoObtenerTamaño() {
		
		Adjunto adjunto = new Adjunto(MENSAJE, TEXTO);
		
		int tamañoEsperado = MENSAJE.obtenerTamaño() + TEXTO.obtenerTamaño();
		
		assertEquals(tamañoEsperado, adjunto.obtenerTamaño());
		
	}	
}
