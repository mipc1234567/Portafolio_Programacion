package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import Logica.Language;
import Logica.ManagerFiles;


/**
 * Maneja todas las ventanas
 * @author Mateo
 * @version 1.0
 * @created 20-mar.-2015 12:12:20 p. m.
 */
/**
 * @author Mateo
 *
 */
public class MainWindow extends JFrame implements ActionListener{

    private Acercade acercade;
    private Archivo m_Archivo;
    private ParametrosGenerales m_ParametrosGenerales;
    private AdminPersonas m_AdminPersonas;
    private AdminProcesadores m_AdminProcesadores;
    private Change  m_Objetos;
  
private ManagerFiles manager;
	private Personas personas;
    private Procesadores procesadores;
    
    
//	
		/**
		* Asociacion de la ventana  de la persona
		* 
		*/

			
		private AdminPersonas ventanaAdmtospersona;	
			

	
		/**
		 * Asociacion  con la ventana procesador
		 */
		 private AdminProcesadores ventanaAdmprocesador;

		/**
		 * 
		 * asociaicno con el archivo
		 */

		 private Archivo Ventanaarchivo;

		 
		 /**
		  *permite confgurar el about 
		  */
		 
		 private Acercade about;
		 
		 
		 /**
		  * permite manar los  parametros generales
		  */
		 
		 
		
         /**
          * permite configurar parametros generales
          */

		final String CALCULATE="calculate";

		
		
		/**
		 * 
		 *permite manipular los parametros del procesador 
		 */
	
		final String CALCULATE1="Calculateperson"; 
	
		
		/**
		 * permite manipular los parametro del al persona
		 */
		
		final String CALCULATE2="Calculateproce";
		
		/**
		 * Creacion de un boton
		 */
		private JButton buttonVolver;

		/**
		 * creacion de un boton
		 */
		private JButton buttonSalir;

		/**
		 * se crea un menubar para inciar la aplicacion;
		 * 
		 */
	     int Size=100;
	     
	     
private JMenuBar menubar;
private JMenuItem menuitem1;
private JMenuItem menuitem2;
private JMenuItem menuitem3;
private JMenuItem menuitem4;
private JMenuItem menuitem5;
private JMenuItem menuitem6;
private JMenuItem menuitem7;
private JMenuItem menuitem8;
private JMenuItem menuitem9;
private JMenuItem menuitem10;
private JMenuItem menuitem11;
private JMenu menuArchivo;	
private JMenu menuObjetos;
private JMenu menuAcerca;
private Logica.Language  language;
private JMenu crear;
private JMenu mi;
private JMenu mo;
private String persona;
private String procesador;
	     
//-------------- CONSTRUCTOR----------------------

public MainWindow(String Persona, String Procesador, ManagerFiles managerFil){
		
//********************ATRIBUTOS*******************
this.persona=Persona;
this.procesador=Procesador;
this.manager=managerFil;		
language= new Language();
setSize(300,200);
setTitle("Main Window");
setLayout(null);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setResizable(true);
this.setLocationRelativeTo(null);



Ventanaarchivo= new Archivo();
ventanaAdmtospersona= new AdminPersonas();
ventanaAdmprocesador= new AdminProcesadores();
personas=new Personas(persona,procesador,managerFil) ;
procesadores=new Procesadores(persona,procesador,managerFil);

about= new Acercade();
m_ParametrosGenerales= new ParametrosGenerales();



menubar= new JMenuBar();
menuArchivo=new JMenu("Archivo");
menuArchivo.setMnemonic('A');
menubar.add(menuArchivo);

//no........
/*JMenuBar bar = new JMenuBar();
JMenu menu = new JMenu("Archivo");
menu.setMnemonic('A');
bar.add(menu);
*/EditListener l = new EditListener();
ConfigPersListener per= new ConfigPersListener();
ConfigProcListener pro= new ConfigProcListener();

menuitem1= menuArchivo.add(new JMenuItem("Generales", 'G'));
menuitem1.setActionCommand(CALCULATE);
menuitem1.addActionListener(l);


crear = new JMenu("Crear");
menuitem6= crear.add(new JMenuItem("Personas", 'e'));
menuitem6.setActionCommand(CALCULATE);
menuitem6.addActionListener(per);
menuitem7= crear.add(new JMenuItem("Procesadores", 'o'));
menuitem7.setActionCommand(CALCULATE);
menuitem7.addActionListener(pro);
menuArchivo.add(crear);
//crear.addActionListener(l1);


//actualiza los registros del archivo

ActulizaListener o = new ActulizaListener();
 mi= new JMenu("Actualzar Registro");;
menuitem8= (JMenuItem) mi.add(new JMenuItem("Personas", 'e'));
menuitem8.setActionCommand(CALCULATE);
menuitem8.addActionListener(l);
menuitem9= mi.add(new JMenuItem("Procesadores", 'o'));
menuitem9.setActionCommand(CALCULATE);
menuitem9.addActionListener(l);
menuArchivo.add(mi);
//mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));
mi.addActionListener(o);


//borrar datos de los archivos
BorrarListener q = new BorrarListener();
 mo= new JMenu("Borrar Registro");
menuitem10= mo.add(new JMenuItem("Personas", 'e'));
menuitem10.setActionCommand(CALCULATE);
menuitem10.addActionListener(per);
menuitem11= mo.add(new JMenuItem("Procesadores", 'o'));
menuitem11.setActionCommand(CALCULATE);
menuitem11.addActionListener(pro);
menuArchivo.add(mo);
//mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));
mi.addActionListener(q);

menuitem2= new JMenuItem("Salir");
menuitem2.setMnemonic('S');
menuitem2.addActionListener(new ActionListener(){

/*JMenuItem exit = new JMenuItem("Salir");
exit.setMnemonic('S');	
exit.addActionListener(new ActionListener() {
		*/
	
public void actionPerformed(ActionEvent e){
System.out.println("Exit performed");
//Ventana.this.dispose();
System.exit(0);
}
});



menuArchivo.add(menuitem2);
menuObjetos= new JMenu("Objetos");
menuObjetos.setMnemonic('0');
menubar.add(menuObjetos);




PersonListener p= new PersonListener();
ProceListener s= new ProceListener();
AboutListener a= new AboutListener();

menuitem3= menuObjetos.add(new JMenuItem("AdmPersonas", 'e'));
menuitem3.setActionCommand(CALCULATE1);
menuitem3.addActionListener(p);

menuitem5=menuObjetos.add(new JMenuItem("AdmProcesadores",'0'));
menuitem5.setActionCommand(CALCULATE2);
menuitem5.addActionListener(s);




/*JMenuItem conf;
conf = menu.add(new JMenuItem("Personas", 'e'));
conf.setActionCommand(CALCULATE1);
//conf.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CAPS_LOCK));
conf.addActionListener(p);


conf = menu.add(new JMenuItem("Procesadores",'0'));
conf.setActionCommand(CALCULATE2);
//conf.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK));

conf.addActionListener(s);*/


menuAcerca = new JMenu("Acerca de");
menubar.add(menuAcerca);


menuitem4=menuAcerca.add(new JMenuItem("Version",'V'));
/*JMenuItem abot;
abot=menu.add(new JMenuItem("Version",'V'));*/
menuitem4.setActionCommand(CALCULATE);
menuitem4.addActionListener(a);



/*HelpListener help= new HelpListener();
JMenuItem h;
h = menu.add(new JMenuItem("Intructions", 't'));
// h.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));
h.addActionListener(help);
h = menu.add(new JMenuItem("Dinamic", 'c'));
// h.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK));
h.addActionListener(help);
h = menu.add(new JMenuItem("History", 'h'));
// h.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK));
h.addActionListener(help);

*/

setJMenuBar(menubar);
// getContentPane().add(new JLabel("A placeholder"));
pack();
setSize(800, 800);
setVisible(true);
}

public void initialiceObjectsPer(){
ventanaAdmtospersona.ChargeManagerFiles(personas.getManagerFiles());

}

public void initialiceObjecsPro(){
ventanaAdmprocesador.ChargeManagerFiles(procesadores.getManagerFiles());
}

public JMenu getCrear() {
	return crear;
}



public void setCrear(JMenu crear) {
	this.crear = crear;
}

public class EditListener implements ActionListener {
public void actionPerformed(ActionEvent e) {
if(e.getActionCommand().equals(CALCULATE)){
	System.out.println("SI INGRESSO AL CONTROL");
	personas.Personas_Show();
	personas.setVisible(true);
	//m_ParametrosGenerales.setVisible(true);	
	}	
System.out.println(e.getActionCommand());
}

}

public class ActulizaListener implements ActionListener {
public void actionPerformed(ActionEvent e) {
if(e.getActionCommand().equals(CALCULATE)){
	
	//m_ParametrosGenerales.setVisible(true);	
	}	
System.out.println(e.getActionCommand());
}

}


public class BorrarListener implements ActionListener {
public void actionPerformed(ActionEvent e) {
if(e.getActionCommand().equals(CALCULATE)){
	
	//m_ParametrosGenerales.setVisible(true);	
	}	
System.out.println(e.getActionCommand());
}

}

public  class ConfigProcListener implements ActionListener {
public void actionPerformed(ActionEvent e) {
	
	if(e.getActionCommand().equals(CALCULATE)){
	procesadores.setVisible(true);	
	initialiceObjecsPro();
		}	
	System.out.println(e.getActionCommand());
}

	
}

public  class ConfigPersListener implements ActionListener {
public void actionPerformed(ActionEvent e) {
	
	if(e.getActionCommand().equals(CALCULATE)){
	
		personas.setVisible(true);	
		
		initialiceObjectsPer();
		
		}	
	System.out.println(e.getActionCommand());
}

	
}

public class PersonListener implements ActionListener{

	public void actionPerformed(ActionEvent f) {
		System.out.println(f.getActionCommand());
		// TODO Auto-generated method stub
		if(f.getActionCommand().equals(CALCULATE1)){
			
			ventanaAdmtospersona.setVisible(true);	
			}
	}
	
}

public class ProceListener implements ActionListener{

	public void actionPerformed(ActionEvent g) {
		// TODO Auto-generated method stub
		System.out.println(g.getActionCommand());
		if(g.getActionCommand().equals(CALCULATE2)){
			ventanaAdmprocesador.setVisible(true);
			}
		
		
	}
	
}


public class AboutListener implements ActionListener{
	public void actionPerformed(ActionEvent h) {
		 // TODO Auto-generated method stub
		System.out.println(h.getActionCommand());
		if(h.getActionCommand().equals(CALCULATE)){
			about.setVisible(true);
			
		}
		
		
	}
}






		//---------------------METODOS--------------------------------------


		//-----------METODOS DE ACCION--------------------	
		public void actionPerformed1(ActionEvent e) {
		if(e.getActionCommand().equals(CALCULATE)){
		System.out.println("funciona");
					
				}
									
				}	
				/**
				 * 1º
				 */
				ActionListener actionsButtons1 = new ActionListener() {		
					public void actionPerformed(ActionEvent a) {
						if(a.getActionCommand().equals(CALCULATE)){
						System.out.println("funciona");
						
						}
						}
					};


					/**
					 * 2º 
					 */
				ActionListener actionsButtons2 = new ActionListener() {		
				public void actionPerformed(ActionEvent a) {
				if(a.getActionCommand().equals(CALCULATE)){
				System.out.println("funciona");

				}
				}
				};

				public void actionPerformed11(ActionEvent c ) {
				//imagenes  = new Imagenes();
				//imagenes.cargarImagen(panel.getGraphics());
				if(c.getActionCommand().equals(CALCULATE)){
				System.out.println("funciona");

				}
				}



//---------------------LOS GET Y LOS SET-----------------------------------				
				
				
				
	public JButton getButtonVolver() {
					return buttonVolver;
				}







				public void setButtonVolver(JButton buttonVolver) {
					this.buttonVolver = buttonVolver;
				}







				public JButton getButtonSalir() {
					return buttonSalir;
				}







				public void setButtonSalir(JButton buttonSalir) {
					this.buttonSalir = buttonSalir;
				}







	public JMenuItem getMenuitem1() {
					return menuitem1;
				}







				public void setMenuitem1(JMenuItem menuitem1) {
					this.menuitem1 = menuitem1;
				}







				public JMenuItem getMenuitem2() {
					return menuitem2;
				}







				public void setMenuitem2(JMenuItem menuitem2) {
					this.menuitem2 = menuitem2;
				}







				public JMenuItem getMenuitem3() {
					return menuitem3;
				}







				public void setMenuitem3(JMenuItem menuitem3) {
					this.menuitem3 = menuitem3;
				}







				public JMenuItem getMenuitem4() {
					return menuitem4;
				}







				public void setMenuitem4(JMenuItem menuitem4) {
					this.menuitem4 = menuitem4;
				}







				public JMenu getMenuArchivo() {
					return menuArchivo;
				}







				public void setMenuArchivo(JMenu menuArchivo) {
					this.menuArchivo = menuArchivo;
				}







				public JMenu getMenuObjetos() {
					return menuObjetos;
				}







				public void setMenuObjetos(JMenu menuObjetos) {
					this.menuObjetos = menuObjetos;
				}







				public JMenu getMenuAcerca() {
					return menuAcerca;
				}







				public void setMenuAcerca(JMenu menuAcerca) {
					this.menuAcerca = menuAcerca;
				}







				public Logica.Language getLanguage() {
					return language;
				}







				public JMenuItem getMenuitem5() {
					return menuitem5;
				}



				public void setMenuitem5(JMenuItem menuitem5) {
					this.menuitem5 = menuitem5;
				}



				public void setLanguage(Logica.Language language) {
					this.language = language;
				}




public JMenuItem getMenuitem6() {
					return menuitem6;
				}



				public void setMenuitem6(JMenuItem menuitem6) {
					this.menuitem6 = menuitem6;
				}



				public JMenuItem getMenuitem7() {
					return menuitem7;
				}



				public void setMenuitem7(JMenuItem menuitem7) {
					this.menuitem7 = menuitem7;
				}
				public AdminPersonas getVentanaAdmtospersona() {
					return ventanaAdmtospersona;
				}

				public void setVentanaAdmtospersona(AdminPersonas ventanaAdmtospersona) {
					this.ventanaAdmtospersona = ventanaAdmtospersona;
				}

				public AdminProcesadores getVentanaAdmprocesador() {
					return ventanaAdmprocesador;
				}

				public void setVentanaAdmprocesador(AdminProcesadores ventanaAdmprocesador) {
					this.ventanaAdmprocesador = ventanaAdmprocesador;
				}
				
				
				public ManagerFiles getManager() {
					return manager;
				}

				public void setManager(ManagerFiles manager) {
					this.manager = manager;
				}


public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}
}//end MainWindow