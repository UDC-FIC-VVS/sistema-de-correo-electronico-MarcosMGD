package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class LogTest {
	
	// Declaramos constantes para usar en los tests
	
	public static final String NOMBREARCHIVADOR = "archivadorTest";	
	public static final String NOMBREARCHIVADORDELEGADO ="archivadorDelegadoTest";
	public static final String NOMBRE_TEXTO = "nombre";	
	public static final String CONTENIDO_TEXTO = "contenido";	
	public static final int ESPACIO = 20;
	public static final int SIN_ESPACIO = 0;
	
	
///////////////////////////////////// TESTS //////////////////////////////////////////	
	
	
	// Comprobamos que o constructor non devolva nulo
	@Test
    public void logNonNuloTest() {
		
		ArchivadorSimple archivador = 
				new ArchivadorSimple(NOMBREARCHIVADOR, 
						ESPACIO);		
		
		Log log = new Log(archivador);
		
        assertNotNull(log);
        
    }
	
	// Comprobamos que o constructor establece o decorado correctamente
	//   comprobando que o nome coincida
	@Test
    public void logDecoradoTest() {
		
		ArchivadorSimple archivador = 
				new ArchivadorSimple(NOMBREARCHIVADOR, 
						ESPACIO);		
		
		DecoradorArchivador log = new Log(archivador);
		
        assertEquals(archivador.obtenerNombre(), log.obtenerNombre());
        
    }
	
	// Comprobamos que devolve true ao añadir se ten espacio suficiente
	@Test
    public void almacenarCorreoLogTrueTest() {
		
		ArchivadorSimple archivador = 
				new ArchivadorSimple(NOMBREARCHIVADOR, 
						ESPACIO);		
		
		DecoradorArchivador log = new Log(archivador);
		
		// Creamos el Correo para almacenar
		Texto texto = new Texto("nombre","contenido");
		Correo correo = new Mensaje(texto);

		boolean almacenado = log.almacenarCorreo(correo);
		
		assertTrue(almacenado);
        
    }
	
	// Comprobamos que devolve false ao añadir se non ten espacio suficiente
	@Test
    public void almacenarCorreoLogFalseTest() {
		
		ArchivadorSimple archivador = 
				new ArchivadorSimple(NOMBREARCHIVADOR, 
						SIN_ESPACIO);		
		
		DecoradorArchivador log = new Log(archivador);
		
		// Creamos el Correo para almacenar
		Texto texto = new Texto("nombre","contenido");
		Correo correo = new Mensaje(texto);

		boolean almacenado = log.almacenarCorreo(correo);
		
		assertTrue(!almacenado);
        
    }
	
	
	// Comprobamos que devolve true ao añadir se ten o espacio xusto
	@Test
    public void almacenarCorreoLogTamañoXustoTest() {
		
		// Creamos el Correo para almacenar
		Texto texto = new Texto("nombre","contenido");
		Correo correo = new Mensaje(texto);
		
		ArchivadorSimple archivador = 
				new ArchivadorSimple(NOMBREARCHIVADOR, 
						correo.obtenerTamaño());		
		
		DecoradorArchivador log = new Log(archivador);		

		boolean almacenado = log.almacenarCorreo(correo);
		
		assertTrue(almacenado);
        
    }
	
	
	

}
