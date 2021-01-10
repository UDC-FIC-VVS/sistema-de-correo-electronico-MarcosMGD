package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AudioTest {
	
	// Declaramos constantes para usar en los tests
	
	public static final String NOMBRE = "nombreArchivo";
	public static final String CONTENIDO = "contenidoArchivo";
	
	
	// Probamos que el constructor no devuelve nulo
	@Test
	public void constructorAudioNotNull() {
		
		Audio audio = new Audio(NOMBRE, CONTENIDO);
		
		assertNotNull(audio);
		
	}
	
	// Probamos que el constructor define el nombre del archivo
	//	correctamente
	@Test
	public void constructorAudioNombre() {
		
		Audio audio = new Audio(NOMBRE, CONTENIDO);
		
		assertEquals(NOMBRE, audio.obtenerNombre());
		
	}
	
	// Probamos que el constructor define el contenido del archivo
	//	correctamente
	@Test
	public void constructorAudioContenido() {
		
		Audio audio = new Audio(NOMBRE, CONTENIDO);
		
		assertEquals(CONTENIDO, audio.obtenerContenido());
		
	}
	
	// Probamos que el metodo obtenerMimeType devuelve correctamente
	//    audio/ogg
	@Test
	public void audioMimeType() {
		
		Audio audio = new Audio(NOMBRE, CONTENIDO);
		
		assertEquals("audio/ogg", audio.obtenerMimeType());
		
	}
	
	
	
	

}
