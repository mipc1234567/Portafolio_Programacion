package Consola;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interfaz.AdminPersonas;
import Interfaz.AdminProcesadores;
import Interfaz.MainWindow;
import Interfaz.ParametrosGenerales;
import Interfaz.Personas;
import Interfaz.Procesadores;

public class Consola implements ActionListener {
	
	private AdminPersonas adminperson;
	
	private AdminProcesadores adminprocesadores;
	
//	private Personas personas;
	
	private Procesadores procesadores;

	
	private MainWindow mainwindow;
	
	
	private ParametrosGenerales paramegener;
	
	private static final String CALCULATE= "calculate";
	
	
	
public Consola(){
		
	
	//pendiente
	
	
	
//adminperson= new AdminPersonas();		
adminperson.setVisible(true);
		
		

//personas= new Personas();
//personas.setVisible(true);
  
  
adminprocesadores =new AdminProcesadores();
adminprocesadores.setVisible(true);

//procesadores = new Procesadores();
procesadores.setVisible(true);

//mainwindow= new MainWindow();
mainwindow.setVisible(true);


paramegener = new ParametrosGenerales();
paramegener.setVisible(true);

	}
	



/**
 * 
 * 1º
 */

ActionListener actionsButtons1 = new ActionListener() {		
	public void actionPerformed(ActionEvent a) {
		if(a.getActionCommand().equals(CALCULATE)){
		System.out.println("funciona1");
		
		}
		}
	};


	/**
	 * 2º 
	 */
ActionListener actionsButtons2 = new ActionListener() {		
public void actionPerformed(ActionEvent a) {
if(a.getActionCommand().equals(CALCULATE)){
System.out.println("funciona1");


}
}
};
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	


	
}
}
