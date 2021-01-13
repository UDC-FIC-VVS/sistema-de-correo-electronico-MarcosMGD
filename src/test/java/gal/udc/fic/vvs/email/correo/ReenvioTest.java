package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class ReenvioTest {
	
	public static final String NOMBRE1 = "nombre1";
	public static final String NOMBRE2 = "nombre2";
	public static final String CONTENIDO1 = "contenido1";
	public static final String CONTENIDO2 = "contenido2";
	
	public static final Texto TEXTO1 = new Texto(NOMBRE1, CONTENIDO1);
	public static final Texto TEXTO2 = new Texto(NOMBRE2, CONTENIDO2);
	
	Mensaje MENSAJE1 = new Mensaje(TEXTO1);
	Mensaje MENSAJE2 = new Mensaje(TEXTO2);
	
	
///////////////////////////////////// TESTS //////////////////////////////////////////	

	// Probamos que el constructor no devuelva nulo
	@Test
	public void constructorReenvioNotNull() {
		
		Reenvio reenvio = new Reenvio(MENSAJE1, MENSAJE2);
		
		assertNotNull(reenvio);
		
	}
	
	
	// Comprobamos que obtener tamaño devuelva el tamaño del mensaje + del propio
	//		correo
	@Test
	public void reenvioObtenerTamaño() {
		
		Reenvio reenvio = new Reenvio(MENSAJE1, MENSAJE2);
		
		int tamañoEsperado = MENSAJE1.obtenerTamaño() + MENSAJE2.obtenerTamaño();
		
		assertEquals(tamañoEsperado, reenvio.obtenerTamaño());
		
	}

}
