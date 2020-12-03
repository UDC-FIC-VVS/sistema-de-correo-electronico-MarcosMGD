package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import java.util.Vector;

import org.junit.Test;

import gal.udc.fic.vvs.email.correo.Carpeta;
import gal.udc.fic.vvs.email.correo.Correo;


// Test para archivador simple
public class ArchivadorSimpleTest {
	
	// Declaramos constantes para usar en los tests
	
	public static final String nombreArchivadorTest = "archivadorTest";
	public static final int espacioTest = 20;
	
	
	// Test para comprobar si funciona correctamente o constructor
		@Test
	    public void archivadorSimpleTest() {
			
			ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivadorTest, espacioTest);	
			
			Vector vector = new Vector();
			
	        assertEquals(nombreArchivadorTest, archivador.obtenerNombre());
	        assertEquals(espacioTest, archivador.obtenerEspacioDisponible());
	        assertEquals(espacioTest, archivador.obtenerEspacioTotal());
	        
	    }
	

	// Test para comprobar si o método recupera o nome posto no constructor
	@Test
    public void obtenerNombreTest() {
		
		ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivadorTest, espacioTest);	
		String nombreReal = archivador.obtenerNombre();
		
        assertEquals(nombreArchivadorTest, nombreReal);
    }
	
	// Test para comprobar si o método recupera o espacio total correctamente establecido no constructor
	@Test
    public void obtenerEspacioTotalTest() {
		
		ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivadorTest, espacioTest);	
		int espacioTotal = archivador.obtenerEspacioTotal();
		
        assertEquals(espacioTest, espacioTotal);
    }
	
	// Test para comprobar si o método recupera o espacio disponible correctamente establecido no constructor
	@Test
    public void obtenerEspacioDisponibleTest() {
		
		ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivadorTest, espacioTest);	
		int espacioDisponible = archivador.obtenerEspacioDisponible();
		
        assertEquals(espacioTest, espacioDisponible);
    }
	
	// Test para comprobar si o método obtén delegado a null
		@Test
	    public void obtenerDelegadoTest() {
			
			ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivadorTest, espacioTest);	
			Archivador nulo = archivador.obtenerDelegado();
			
	        assertEquals(null, nulo);
	    }
		
		
		// Test para comprobar si almacena correo sobre _correos vacío y actualiza correctamente
		@Test
	    public void almacenarCorreoTest() {
			
			ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivadorTest, espacioTest);	
			Correo carpeta = new Carpeta("carpeta");
			
			boolean insertado = archivador.almacenarCorreo(carpeta);
			
	        assertEquals(espacioTest - 1 , archivador.obtenerEspacioDisponible());
	        assertEquals(espacioTest , archivador.obtenerEspacioTotal());
	        assertEquals(true , insertado);
	    }		
		
		// Faltan más tests después de notificar el bug
	
}
