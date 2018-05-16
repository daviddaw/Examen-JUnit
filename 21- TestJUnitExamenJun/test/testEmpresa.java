import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import paqueteCodigo.Camion;
import paqueteCodigo.Empresa;


public class testEmpresa {

	private Empresa empresa;
	private Camion c1;
	private Camion c2;
	private Camion c3;
	private Camion c4;
	
	@Before
	public void setUp() {
		empresa=new Empresa("1234567", 3);
		c1=new Camion("1234561", 100, 50);
		c2=new Camion("1234562", 100, 50);
		c3=new Camion("1234563", 100, 50);
		c4=new Camion("1234564", 100, 50);
	}

	@Test
	public void testBuscarCamion() {
		empresa.insertarCamion(c1);
		assertTrue(empresa.buscarCamion("1234561").equals(c1));
		//assertTrue(empresa.buscarCamion(m2).equals(c1));
		empresa.insertarCamion(c2);
		empresa.insertarCamion(c3);
		assertTrue(empresa.buscarCamion("1234563").equals(c3));
		//empresa.insertarCamion(c4);
	}

}
