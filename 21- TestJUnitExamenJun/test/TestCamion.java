import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import paqueteCodigo.Camion;


public class TestCamion {
	private	 Camion c1;
	private Camion c2;
		
	@Before
	public void setUp() {
		c1= new Camion("1234", 100, 50);
		c2=new Camion ("1234",100,150);
	}

	@Test
	public void cargaFinalTest() {
		
		//Carga inicial voy a llenar dos cargas de 40
		//pero auna de ellas le ponemos limite de peso inferior a la carga y a otr uno superior ala carga
		//si hacemos  eso el limite inferior a la carga da error
		assertTrue(c1.getCarga()==50);
		
		c1.cargar(50);
		
		assertTrue(45==c2.getCarga());
		c2.cargar(5);
		assertTrue(c2.getCarga()==95);
		System.out.println("hola");
		//subimos la carga hsta sobrepasar el limite de carga 
		c2.cargar(5);
		assertTrue(50==c2.getCarga());
		//Pero la carga se mantiene al mismo nivel que el limite de carga
		//descargamos
		c2.descargar(10);
		assertTrue(40==c2.getCarga());
		c2.descargar(50);
		assertTrue(0==c2.getCarga());
		
		
		
	}

}
