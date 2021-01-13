package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class CabeceraTest {
	
	public static final String NOMBRE = "nombre";
	public static final String VALOR = "contenido";
	
	public static final String NOMBRE2 = "nombre2222222";
	public static final String CONTENIDO2 = "contenido2222";
	
	public static final Texto TEXTO1 = new Texto(NOMBRE2, CONTENIDO2);
	
	Mensaje MENSAJE = new Mensaje(TEXTO1);
	
	
///////////////////////////////////// TESTS //////////////////////////////////////////

	// Probamos que el constructor no devuelva nulo
	@Test
	public void constructorCabeceraNotNull() {
		
		Cabecera cabecera = new Cabecera(MENSAJE, NOMBRE, VALOR);
		
		assertNotNull(cabecera);
		
	}
	
	// Comprobamos que obtener tamaño devuelva el tamaño del mensaje + del propio
	//		archivo
	@Test
	public void adjuntoObtenerTamaño() {
		
		Cabecera cabecera = new Cabecera(MENSAJE, NOMBRE, VALOR);
		
		int tamañoEsperado = MENSAJE.obtenerTamaño() + NOMBRE.length() +
				VALOR.length();
		
		assertEquals(tamañoEsperado, cabecera.obtenerTamaño());
		
	}	
	
	
}
