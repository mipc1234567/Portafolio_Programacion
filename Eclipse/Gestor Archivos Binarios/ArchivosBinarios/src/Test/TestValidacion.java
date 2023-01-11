package Test;

import java.util.Date;
import java.util.GregorianCalendar;

import Logica.Persona;
import Logica.Procesador;

public class TestValidacion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
	//Persona p = new Persona(1052338678,"F","mateo","Pena",new Date(19, 9, 2014),"maiu234@gmail.com");
//	p.validarPersona(1052338678,"F","mateo","pena",new Date(19, 9, 2014),"maiu234@gmail.com");
  //  p.asignarTipoDocumento();	
	Procesador s= new Procesador("Atlon",63,560,3,"none");
	s.validarProcesador("Atlon",63,560,3,"none");
	
	
	
} 
}
