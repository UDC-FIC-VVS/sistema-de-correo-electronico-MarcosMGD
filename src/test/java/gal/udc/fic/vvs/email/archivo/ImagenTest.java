package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ImagenTest {
	
	// Declaramos constantes para usar en los tests
	
	public static final String NOMBRE = "nombreArchivo";
	public static final String CONTENIDO = "contenidoArchivo";
	
	
	// Probamos que el constructor no devuelve nulo
	@Test
	public void constructorImagenNotNull() {
		
		Imagen imagen = new Imagen(NOMBRE, CONTENIDO);
		
		assertNotNull(imagen);
		
	}
	
	// Probamos que el constructor define el nombre del archivo
	//	correctamente
	@Test
	public void constructorImagenNombre() {
		
		Imagen imagen = new Imagen(NOMBRE, CONTENIDO);
		
		assertEquals(NOMBRE, imagen.obtenerNombre());
		
	}
	
	// Probamos que el constructor define el contenido del archivo
	//	correctamente
	@Test
	public void constructorImagenContenido() {
		
		Imagen imagen = new Imagen(NOMBRE, CONTENIDO);
		
		assertEquals(CONTENIDO, imagen.obtenerContenido());
		
	}
	
	// Probamos que el metodo obtenerMimeType devuelve correctamente
	//    "image/png"
	@Test
	public void audioMimeType() {
		
		Imagen imagen = new Imagen(NOMBRE, CONTENIDO);
		
		assertEquals("image/png", imagen.obtenerMimeType());
		
	}


}
