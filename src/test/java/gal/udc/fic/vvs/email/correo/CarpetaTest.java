package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Vector;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class CarpetaTest {
	
	public static final String NOMBRE = "carpeta";
	
	public static final Texto TEXTO1 = new Texto("nombreuno","contenidouno");
	public static final Texto TEXTO2 = new Texto("nombre_dos","contenido_dos");
	public static final Texto TEXTO3 = new Texto("nombre_tres","contenido_tres");
	
	Mensaje MENSAJE1 = new Mensaje(TEXTO1);
	Mensaje MENSAJE2 = new Mensaje(TEXTO2);
	Mensaje MENSAJE3 = new Mensaje(TEXTO3);
	
///////////////////////////////////// TESTS //////////////////////////////////////////	

	// Comprobamos que el constructor no devuelva null
	@Test
	public void carpetaConstructorNotNull() {
		
		Carpeta carpeta = new Carpeta(NOMBRE);
		
		assertNotNull(carpeta);
		
	}
	
	// Comprobamos que el constructor inicialice hijos sin nada
	@Test
	public void carpetaConstructorHijos() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(NOMBRE);
		
		Collection hijo = carpeta.explorar();
		

		assertTrue(hijo.isEmpty());
		
	}
	
	// Comprobamos establecer leido a true
	@Test
	public void establecerLeidoTrue() throws OperacionInvalida {
		
		// Creamos una carpeta y le añadimos 3 hijos (Correos)		
		Carpeta carpeta = new Carpeta(NOMBRE);
		carpeta.añadir(MENSAJE1);
		carpeta.añadir(MENSAJE2);
		carpeta.añadir(MENSAJE3);
		///////////////////////////////////////////////////////
		
		carpeta.establecerLeido(true);
		
		assertEquals(0, carpeta.obtenerNoLeidos());
		
	}
	
	
	// Comprobamos establecer leido a false
	@Test
	public void establecerLeidoFalse() throws OperacionInvalida {
		
		// Creamos una carpeta y le añadimos 3 hijos (Correos)		
		Carpeta carpeta = new Carpeta(NOMBRE);
		carpeta.añadir(MENSAJE1);
		carpeta.añadir(MENSAJE2);
		carpeta.añadir(MENSAJE3);
		///////////////////////////////////////////////////////
		
		carpeta.establecerLeido(false);
		
		assertEquals(3, carpeta.obtenerNoLeidos());
		
	}
	
	// Comprobamos obtenerNoLeidos y que devuelva 0 si están
	//	todos leídos
	@Test
	public void obtenerNoLeidosTrue() throws OperacionInvalida {
		
		// Creamos una carpeta y le añadimos 3 hijos (Correos)		
		Carpeta carpeta = new Carpeta(NOMBRE);
		carpeta.añadir(MENSAJE1);
		carpeta.añadir(MENSAJE2);
		carpeta.añadir(MENSAJE3);
		///////////////////////////////////////////////////////
		
		carpeta.establecerLeido(true);
		
		assertEquals(0, carpeta.obtenerNoLeidos());
		
	}
	
	
	// Comprobamos obtenerNoLeidos y que devuelva el numero de
	//	mensajes dentro de carpeta
	@Test
	public void obtenerNoLeidosFalse() throws OperacionInvalida {
		
		// Creamos una carpeta y le añadimos 3 hijos (Correos)		
		Carpeta carpeta = new Carpeta(NOMBRE);
		carpeta.añadir(MENSAJE1);
		carpeta.añadir(MENSAJE2);
		carpeta.añadir(MENSAJE3);
		///////////////////////////////////////////////////////
		
		carpeta.establecerLeido(false);
		
		assertEquals(3, carpeta.obtenerNoLeidos());
		
	}
	
	// Comprobamos obtener tamaño para varios mensajes dentro de
	//  un archivo
	@Test
	public void obtenerTamaño() throws OperacionInvalida {
		
		// Creamos una carpeta y le añadimos 3 hijos (Correos)		
		Carpeta carpeta = new Carpeta(NOMBRE);
		carpeta.añadir(MENSAJE1);
		carpeta.añadir(MENSAJE2);
		carpeta.añadir(MENSAJE3);
		///////////////////////////////////////////////////////
		
		int tamañoEsperado = MENSAJE1.obtenerTamaño() +
				MENSAJE2.obtenerTamaño() + MENSAJE3.obtenerTamaño();
		
		assertEquals(tamañoEsperado, carpeta.obtenerTamaño());
		
	}	
	
	// Comprobamos obtener tamaño para archivo vacio
	@Test
	public void obtenerTamañoVacio() {
		
		// Creamos una carpeta y le añadimos 3 hijos (Correos)		
		Carpeta carpeta = new Carpeta(NOMBRE);
	
		assertEquals(0, carpeta.obtenerTamaño());
		
	}	
	
	// Comprobar qeu obtener Icono devuelva 1 (Integer)
	@Test
	public void obtenerIcono() throws OperacionInvalida {
		
		// Creamos una carpeta y le añadimos 3 hijos (Correos)		
		Carpeta carpeta = new Carpeta(NOMBRE);
		carpeta.añadir(MENSAJE1);
		carpeta.añadir(MENSAJE2);
		carpeta.añadir(MENSAJE3);
		///////////////////////////////////////////////////////
		
		Integer icono = 1;
		
		assertEquals(icono, carpeta.obtenerIcono());
		
	}	
	
	// Comparar preVisualización
	@Test
	public void obtenerPreVisualizacion() throws OperacionInvalida {
		
		// Creamos una carpeta y le añadimos 3 hijos (Correos)		
		Carpeta carpeta = new Carpeta(NOMBRE);
		carpeta.añadir(MENSAJE1);
		carpeta.añadir(MENSAJE2);
		carpeta.añadir(MENSAJE3);
		///////////////////////////////////////////////////////
		
		String visualizacionEsperada = NOMBRE + " (3)";
		
		assertEquals(visualizacionEsperada, carpeta.obtenerPreVisualizacion());
		
	}
	
	
	// Comparar obtenerVisualización con el mensaje esperado
	@Test
	public void obtenerVisualizacion() throws OperacionInvalida {
		
		// Creamos una carpeta y le añadimos 3 hijos (Correos)		
		Carpeta carpeta = new Carpeta(NOMBRE);
		carpeta.añadir(MENSAJE1);
		carpeta.añadir(MENSAJE2);
		carpeta.añadir(MENSAJE3);
		///////////////////////////////////////////////////////
		
		String visualizacionEsperada = NOMBRE + " (3)";
		
		assertEquals(visualizacionEsperada, carpeta.obtenerVisualizacion());
		
	}
	
	// Explorar deberia devolver un Collection con el número de 
	//	mensajes dentro de la Carpeta
	@Test
	public void explorar() throws OperacionInvalida {
		
		// Creamos una carpeta y le añadimos 3 hijos (Correos)		
		Carpeta carpeta = new Carpeta(NOMBRE);
		carpeta.añadir(MENSAJE1);
		carpeta.añadir(MENSAJE2);
		carpeta.añadir(MENSAJE3);
		///////////////////////////////////////////////////////
		
		Collection hijos = carpeta.explorar();
	
		assertEquals(3, hijos.size());
		
	}
	
	// Explorar deberia devolver un Collection con el número de 
	//	mensajes dentro de la Carpeta, que sería ninguno
	@Test
	public void explorarVacio() throws OperacionInvalida {
		
		// Creamos una carpeta y le añadimos 3 hijos (Correos)		
		Carpeta carpeta = new Carpeta(NOMBRE);
		///////////////////////////////////////////////////////
		
		Collection hijos = carpeta.explorar();
	
		assertEquals(0, hijos.size());
		
	}
	
	// Buscar (comprobar que devuelve 1 si solo coincide 1)
	@Test
	public void buscarExitosamente() throws OperacionInvalida {
		
		// Creamos una carpeta y le añadimos 3 hijos (Correos)		
		Carpeta carpeta = new Carpeta(NOMBRE);
		carpeta.añadir(MENSAJE1);
		carpeta.añadir(MENSAJE2);
		carpeta.añadir(MENSAJE3);
		///////////////////////////////////////////////////////
		
		Collection result = carpeta.buscar("contenidouno");
		
		assertEquals(1, result.size());
	
	}
	
	// Buscar (comprobar que no devuelve ninguno si ninguno coincide)
	@Test
	public void buscarErroneamente() throws OperacionInvalida {
		
		// Creamos una carpeta y le añadimos 3 hijos (Correos)		
		Carpeta carpeta = new Carpeta(NOMBRE);
		carpeta.añadir(MENSAJE1);
		carpeta.añadir(MENSAJE2);
		carpeta.añadir(MENSAJE3);
		///////////////////////////////////////////////////////
		
		Collection result = carpeta.buscar("contenidouno");
		
		assertEquals(1, result.size());
	
	}
	
	
	// Añadir Correo, comprobar que el número de hijos aumentó 1
	@Test
	public void añadirUnCorreo() throws OperacionInvalida {
		
		// Creamos una carpeta y le añadimos 1 hijo (Correo)			
		Carpeta carpeta = new Carpeta(NOMBRE);
		carpeta.añadir(MENSAJE1);
		///////////////////////////////////////////////////////
		
		Collection hijos = carpeta.explorar();
		
		assertEquals(1, hijos.size());
		
	}
	
	
	// Añadir Correo, comprobar que el padre sea el archivo
	@Test
	public void añadirUnCorreoPadre() throws OperacionInvalida {
		
		// Creamos una carpeta y le añadimos 1 hijo (Correo)		
		Carpeta carpeta = new Carpeta(NOMBRE);
		carpeta.añadir(MENSAJE1);
		///////////////////////////////////////////////////////
		
		Correo padre = MENSAJE1.obtenerPadre();
		
		assertEquals(padre, carpeta);
		
	}
	
	// Eliminar Correo, comprobar que los hijos disminuyeran a 1
	@Test
	public void añadirUnCorreoYBorrarlo() throws OperacionInvalida {
		
		// Creamos una carpeta y le añadimos 1 hijo (Correo)		
		Carpeta carpeta = new Carpeta(NOMBRE);
		carpeta.añadir(MENSAJE1);
		///////////////////////////////////////////////////////
		
		carpeta.eliminar(MENSAJE1);
		
		Collection hijos = carpeta.explorar();
		
		assertTrue(hijos.isEmpty());

		
	}
	
	// Eliminar correo que no existe
	@Test
	public void borrarCorreoNoExistente() throws OperacionInvalida {
		
		// Creamos una carpeta y le añadimos 1 hijo (Correo)		
		Carpeta carpeta = new Carpeta(NOMBRE);
		carpeta.añadir(MENSAJE1);
		///////////////////////////////////////////////////////
		
		carpeta.eliminar(MENSAJE2);
		
		Collection hijos = carpeta.explorar();
		
		assertEquals(1, hijos.size());

		
	}
	
	
	// Eliminar correo, comprobar que el padre sea null
	@Test
	public void eliminarCorreoComprobarPadreNull() throws OperacionInvalida {
		
		// Creamos una carpeta y le añadimos 1 hijo (Correo)		
		Carpeta carpeta = new Carpeta(NOMBRE);
		carpeta.añadir(MENSAJE1);
		///////////////////////////////////////////////////////
		
		carpeta.eliminar(MENSAJE1);
		
		Correo mensaje = MENSAJE1.obtenerPadre();
		
		assertNull(mensaje);
		
	}
	
	
	// Comprobar que obtenerHijo devuelva el único hijo añadido
	@Test
	public void obtenerUnicoHijo() throws OperacionInvalida {
		
		// Creamos una carpeta y le añadimos 1 hijo (Correo)			
		Carpeta carpeta = new Carpeta(NOMBRE);
		carpeta.añadir(MENSAJE1);
		///////////////////////////////////////////////////////
		
		Correo hijo = carpeta.obtenerHijo(0);
		
		assertEquals(hijo, MENSAJE1);
		
	}
	
	// Comprobar que obtener hijo devuelve OperacionInvalida si
	//  no tiene un hijo en la posición pasada
	@Test
	public void obtenerUnicoHijoPosicionVacia() throws OperacionInvalida {
		
		// Creamos una carpeta y le añadimos 1 hijo (Correo)			
		Carpeta carpeta = new Carpeta(NOMBRE);
		carpeta.añadir(MENSAJE1);
		///////////////////////////////////////////////////////
		
		Correo hijo = carpeta.obtenerHijo(2);
		
		assertNull(hijo);
		
	}
	

}
