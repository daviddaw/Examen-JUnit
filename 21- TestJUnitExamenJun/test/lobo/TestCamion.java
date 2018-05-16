package lobo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import loboPaqueteCodigo.Camion;

public class TestCamion {

	private Camion c1;
	private Camion c2;

	@Before
	public void setUp() {

		c1 = new Camion("4545DNB", 30, 40);
		c2 = new Camion("1234ABC", 50, 40);
	}

	@Test
	public void cargaFinalTest() {

		int carga = 11, decarga = 41;
		// Voy a cargar el "c2" con una carga que sobrepasa el limite de carga
		// Con lo cual la carga que lleva el "c2" pasara a ser igual al limite
		// de carga
		// Ya que no puede cargar mas unidades que lo que indica su limite de
		// carga
		c2.cargar(carga);
		assertTrue(c2.getCarga() == c2.getLimiteCarga());

		// Voy a descargar el "c1" con una carga que sobrepasa la carga que
		// lleva el camion
		// Con lo cual la carga que lleva el "c1" pasará a ser igual a 0
		// Ya que no se puede dejar un camion con una carga negativa
		c1.descargar(decarga);
		assertTrue(c1.getCarga() == 0);

		// Voy a cagar, una vez descargado, el "c1" para comprobar que se carga
		// bien el camion

		c1.cargar(carga);
		assertTrue(c1.getCarga() == 11);

		// Voy a descagar, una vez cargado hasta el limite, el "c2" para
		// comprobar que se descarga bien el camion

		c2.descargar(decarga);
		assertTrue(c2.getCarga() == 9);

		// Pruebo los casos limite, como descargar el limite de carga de ese
		// camion y descargar 0,

		c1.descargar(0);
		assertTrue(c1.getCarga() == 11);

		c1.cargar(19);
		c1.descargar(c1.getLimiteCarga());
		assertTrue(c1.getCarga() == 0);

		// Y pruebo a cargar hasta el limite y a carga 0.

		c2.cargar(41);
		c2.descargar(0);
		assertTrue(c2.getCarga() == c2.getLimiteCarga());

		c2.descargar(c2.getLimiteCarga());

		assertTrue(c2.getCarga() == 0);
	}

}
