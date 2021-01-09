package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;


// Test para archivador simple
public class ArchivadorSimpleTest {
	
	// Declaramos constantes para usar en los tests
	
	public static final String nombreArchivadorTest = 
			"archivadorTest";
	public static final int espacioTest = 20;
	public static final int espacioVacioTest = 0;
	public static final int espacioUnicoTest = 1;
	
///////////////////////////////////// TESTS //////////////////////////////////////////	
	
	
	
	// Comprobamos que o constructor non devolva nulo
	@Test
    public void archivadorSimpleNonNuloTest() {
		
		ArchivadorSimple archivador = 
				new ArchivadorSimple(nombreArchivadorTest, 
						espacioTest);			
		
        assertTrue(archivador != null);
        
    }

		
	// Comprobamos que o constructor determina correctamente o
		// nome do archivador pasado por parámetros
	@Test
    public void archivadorSimpleNombreTest() {
		
		ArchivadorSimple archivador = 
				new ArchivadorSimple(nombreArchivadorTest, 
						espacioTest);	
		
		String nombreObj = archivador.obtenerNombre();
		
        assertEquals(nombreArchivadorTest, nombreObj);
    }
	

	// Test para comprobar si o constructor determina o espazo total
		//   correctamente pasado por parámetros
	@Test
    public void archivadorSimpleEspazoTotalTest() {
		
		ArchivadorSimple archivador = 
				new ArchivadorSimple(nombreArchivadorTest, 
						espacioTest);	
		int espacioTotal = archivador.obtenerEspacioTotal();
		
        assertEquals(espacioTest, espacioTotal);
    }
	
	// Test para comprobar si o constructor determina o espazo
		//   disponible, que deberá ser igual ao espazo inicial
		// xa que non é posible que se ocupara con ningún mensaxe
		// no momento actual
	@Test
    public void archivadorSimpleEspazoDisponibleTest() {
		
		ArchivadorSimple archivador = 
				new ArchivadorSimple(nombreArchivadorTest, 
						espacioTest);	
		int espacioDisponible = 
				archivador.obtenerEspacioDisponible();
		
        assertEquals(espacioTest, espacioDisponible);
    }
	
	// Comprobamos que o método obtenerNombre devolve correctamente o
	// nome do archivador pasado por parámetros ao constructor
	@Test
	public void archivadorSimpleObtenerNombreTest() {
		
		ArchivadorSimple archivador = 
				new ArchivadorSimple(nombreArchivadorTest, 
						espacioTest);	
		
		String nombreObj = archivador.obtenerNombre();
		
	    assertEquals(nombreArchivadorTest, nombreObj);
	}
	
	// Test que comprueba que co espacio dispoñible suficiente
	//   o método devolve true
	@Test
    public void almacenarCorreoConSuficienteEspacioDevuelveTrueTest() {
		
		ArchivadorSimple archivador = new ArchivadorSimple(
				nombreArchivadorTest, espacioTest);	
		
		// Creamos el Correo para almacenar
		Texto texto = new Texto("nombre","contenido");
		Correo mensaje = new Mensaje(texto);
		
		boolean insertado = archivador.almacenarCorreo(mensaje);

        assertEquals(true , insertado);
    }	
	
	
	// Test que comprueba que sin espacio dispoñible suficiente
	//   o método devolve false
	@Test
    public void almacenarCorreoSinSuficienteEspacioDevuelveTrueTest() {
		
		ArchivadorSimple archivador = new ArchivadorSimple(
				nombreArchivadorTest, espacioVacioTest);	
		
		// Creamos el Correo para almacenar
		Texto texto = new Texto("nombre","contenido");
		Correo mensaje = new Mensaje(texto);
		
		boolean insertado = archivador.almacenarCorreo(mensaje);

        assertEquals(false , insertado);
    }		
	
	// Test que comprueba que cun só espacio dispoñible suficiente
	//   o método devolve true a primeira vez lanzado
	@Test
    public void almacenarCorreoCunEspacioUnicoDevuelveTrueTest() {
		
		ArchivadorSimple archivador = new ArchivadorSimple(
				nombreArchivadorTest, espacioUnicoTest);	
		
		// Creamos el Correo para almacenar (1)
		Texto texto1 = new Texto("nombre 1","contenido 1");
		Correo mensaje1 = new Mensaje(texto1);
		
		boolean insertado1 = archivador.almacenarCorreo(mensaje1);

        assertEquals(true , insertado1);
    }	
	
	// Test que comprueba que cun só espacio dispoñible suficiente
	//   o método devolve false na segunda inserción
	@Test
    public void almacenarCorreoCunEspacioUnicoDosVecesDevuelveFalseTest() {
		
		ArchivadorSimple archivador = new ArchivadorSimple(
				nombreArchivadorTest, espacioUnicoTest);	
		
		// Creamos el Correo para almacenar (1)
		Texto texto1 = new Texto("nombre 1","contenido 1");
		Correo mensaje1 = new Mensaje(texto1);
		
		// Creamos el Correo para almacenar (2)
		Texto texto2 = new Texto("nombre 2","contenido 2");
		Correo mensaje2 = new Mensaje(texto2);
		
		archivador.almacenarCorreo(mensaje1);
		boolean insertado = archivador.almacenarCorreo(mensaje2);

        assertEquals(false , insertado);
    }	
	
	// Test que comproba que o metodo almacenar correo resta correctamente
	//		o espazo dispoñible	
	@Test
    public void almacenarCorreoActualizaEspazoDisponibleTest() {
		
		ArchivadorSimple archivador = new ArchivadorSimple(
				nombreArchivadorTest, espacioTest);	
		
		// Creamos el Correo para almacenar
		Texto texto = new Texto("nombre","contenido");
		Correo mensaje = new Mensaje(texto);
		
		archivador.almacenarCorreo(mensaje);
		
		int espazoCorrecto = espacioTest - mensaje.obtenerTamaño();

        assertEquals(espazoCorrecto , archivador.obtenerEspacioDisponible());
    }	
	
	// Test que comproba que o metodo almacenar correo non resta espazo
	//   si non é posible insertar o correo	
	@Test
    public void almacenarCorreoNonActualizaEspazoDisponibleTest() {
		
		ArchivadorSimple archivador = new ArchivadorSimple(
				nombreArchivadorTest, espacioVacioTest);	
		
		// Creamos el Correo para almacenar
		Texto texto = new Texto("nombre","contenido");
		Correo mensaje = new Mensaje(texto);
		
		archivador.almacenarCorreo(mensaje);
		
		int espazoCorrecto = espacioVacioTest;

        assertEquals(espazoCorrecto , archivador.obtenerEspacioDisponible());
    }	
			
			
	// Test para comprobar si metodo devolve o espazo total
	//   correctamente pasado por parámetros
	@Test
    public void archivadorSimpleObterEspazoTotalTest() {
		
		ArchivadorSimple archivador = 
				new ArchivadorSimple(nombreArchivadorTest, 
						espacioTest);	
		int espacioTotal = archivador.obtenerEspacioTotal();
		
        assertEquals(espacioTest, espacioTotal);
    }
		
	// Test para comprobar si o método devolve o espazo disponible
	//	correctamente, que será equivalente ao espazo total
	//  se non se añade nigún correo
	@Test
    public void archivadorSimpleObterEspazoDisponibleTest() {
		
		ArchivadorSimple archivador = 
				new ArchivadorSimple(nombreArchivadorTest, 
						espacioTest);	
		int espacioDisponible = 
				archivador.obtenerEspacioDisponible();
		
        assertEquals(espacioTest, espacioDisponible);
    }

	// Test para comprobar que se non se añadeu ningún delegado,
	//  o metodo obter delegado debería devolver null
	@Test
	public void archivadorSimpleObterDelegadoNullTest() {
		
		ArchivadorSimple archivador = 
				new ArchivadorSimple(nombreArchivadorTest, 
						espacioTest);	
		
		Archivador delegado = archivador.obtenerDelegado();
		
		assertEquals(null, delegado);
		
	}
	
	// Test para comprobar que si se añadeu algún delegado,
	//  o metodo obter delegado non debería devolver null
	@Test
	public void archivadorSimpleObterDelegadoAñadidoTest() {
		
		ArchivadorSimple archivador = 
				new ArchivadorSimple(nombreArchivadorTest, 
						espacioTest);	
		
		ArchivadorSimple archivadorDelegado = 
				new ArchivadorSimple(nombreArchivadorTest + "X", 
						espacioTest + 10);	
		
		archivador.establecerDelegado(archivadorDelegado);
		
		Archivador delegado = archivador.obtenerDelegado();
		
		assertTrue( null != delegado.obtenerDelegado());
		
	}
	
	
	// Test para comprobar que si se añadeu algún delegado,
	//  o metodo obter delegado non debería devolver null
	@Test
	public void archivadorSimpleObterDelegadoDistintoNullTest() {
		
		ArchivadorSimple archivador = 
				new ArchivadorSimple(nombreArchivadorTest, 
						espacioTest);	
		
		Archivador delegado = archivador.obtenerDelegado();
		
		assertEquals(null, delegado);
		
	}
	
	// Test para comprobar que si se añadeu algún delegado,
	//  o metodo obter delegado non debería devolver null
	@Test
	public void archivadorSimpleEstablecerDelegadoTest() {
		
		ArchivadorSimple archivador = 
				new ArchivadorSimple(nombreArchivadorTest, 
						espacioTest);	
		
		ArchivadorSimple archivadorDelegado = 
				new ArchivadorSimple(nombreArchivadorTest + "X", 
						espacioTest + 10);	
		
		archivador.establecerDelegado(archivadorDelegado);
		
		Archivador delegado = archivador.obtenerDelegado();
		
		assertTrue( null != delegado.obtenerDelegado());
		
	}
	
}
