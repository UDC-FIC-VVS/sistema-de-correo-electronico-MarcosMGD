package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TextoTest {
	
	// Declaramos constantes para usar en los tests
	
		public static final String NOMBRE = "nombreArchivo";
		public static final String CONTENIDO = "contenidoArchivo";
		
		
		// Probamos que el constructor no devuelve nulo
		@Test
		public void constructorTextoNotNull() {
			
			Texto texto = new Texto(NOMBRE, CONTENIDO);
			
			assertNotNull(texto);
			
		}
		
		// Probamos que el constructor define el nombre del archivo
		//	correctamente
		@Test
		public void constructorTextoNombre() {
			
			Texto texto = new Texto(NOMBRE, CONTENIDO);
			
			assertEquals(NOMBRE, texto.obtenerNombre());
			
		}
		
		// Probamos que el constructor define el contenido del archivo
		//	correctamente
		@Test
		public void constructorTextoContenido() {
			
			Texto texto = new Texto(NOMBRE, CONTENIDO);
			
			assertEquals(CONTENIDO, texto.obtenerContenido());
			
		}
		
		// Probamos que el metodo obtenerMimeType devuelve correctamente
		//    "text/plain"
		@Test
		public void textoMimeType() {
			
			Texto texto = new Texto(NOMBRE, CONTENIDO);
			
			assertEquals("text/plain", texto.obtenerMimeType());
			
		}

}
