package lobo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import paqueteCodigo.Camion;
import paqueteCodigo.Empresa;

public class TestEmpresa {

	private Empresa empresa;
	private Camion c1;
	private Camion c2;
	private Camion c3;
	private Camion c4;

	@Before
	public void setUp() {

		empresa = new Empresa("Parque Central", 3);
		c1 = new Camion("1234abc", 50, 30);
		c2 = new Camion("2345abc", 50, 49);
		c3 = new Camion("3456abc", 50, 0);
		c4 = new Camion("4567abc", 50, 20);
	}

	@Test
	public void testBuscarCamion() {

		// Intento buscar un camion en la empresa pero el arraylist aun está
		// vacio
		// Por lo tanto devolver null

		String mInventada = "1234pot";
		assertTrue(empresa.buscarCamion(mInventada) == null);// Camino 2, caja
																// Blanca

		// Inserto el camion c1 en la lista para buscarlo
		// Creo dos matriculas ya que es el parametro de entrada,m1 es erronea y
		// m2 es correcta
		// Al meter m1, deberia devolvernos el camion como null, ya que la
		// matricula es menos de 7 chars.
		// Al meter m2, nos devuelve el camion c1 ya que comprueba y encuentra
		// su matricula

		String m1 = "124abc", m2 = "1234abc";
		empresa.insertarCamion(c1);
		assertTrue(empresa.buscarCamion(m1) == null);// Camino 1, caja Blanca
		assertTrue(empresa.buscarCamion(m2).equals(c1));// Camino 3, caja Blanca

		// Voy a probar a buscar el camion que esta en la ultima posicion del
		// arrayList
		empresa.insertarCamion(c2);
		empresa.insertarCamion(c3);
		assertTrue(empresa.buscarCamion("3456abc").equals(c3));// Camino 4, caja
																// Blanca
	}

	@Test
	public void testInsertarCamion() {

		// Inserto un camion c1 e intentar meter el mismo camion
		// repetido para ver si salta y no lo inserta

		assertTrue(empresa.insertarCamion(c1));
		assertTrue(!empresa.insertarCamion(c1));

		// Lleno el arrayList con los tres primeros camiones e intento meter uno
		// mas para que falle, con lo cual devolvera un false

		assertTrue(empresa.insertarCamion(c2));
		assertTrue(empresa.insertarCamion(c3));
		assertTrue(!empresa.insertarCamion(c4));
	}

	@Test
	public void testBorrarCamion() {

		// Inserto el camion c2, e intento borrar el camion c4 que no existe
		// y no coincide con el c2.

		empresa.insertarCamion(c2);
		assertTrue(!empresa.borrarCamion(c4));

		// Borro el camion c2, para comprobar que funciona el metodo borrar

		assertTrue(empresa.borrarCamion(c2));
	}

}
