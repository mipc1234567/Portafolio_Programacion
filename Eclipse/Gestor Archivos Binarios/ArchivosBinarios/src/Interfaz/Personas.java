package Interfaz;

import java.awt.BorderLayout;

import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.toedter.calendar.JDateChooser;

import Logica.ManagerFiles;
import Logica.Persona;
import Persistencia.ControlFile;
import Persistencia.Genero;
import javafx.css.ParsedValue;
import sun.util.calendar.BaseCalendar.Date;

/**
 * Permite administrar las personas dentro del administrdor de personas
 * @author Mateo
 * @version 1.0
 * @created 20-mar.-2015 12:12:23 p. m.
 */
public class Personas extends JFrame{
	/**
	 * Permite realizar los calculos llamados
	 */
			
	static final String CALCULATE= "calculate";		     
		     
	/**
	 * permite devolverse al main
	 */
	private JButton JbtnCancelar;
	/**
	 * Permite modificar
	 */
	private JButton JbtnModificar;
	/**
	 * crea una nueva persona
	 */
	private JButton JbtnNuevp;


	/**
	 * tipo de documento del usuario
	 */
	private JTextField JtxtTipoDocumento ;
	private AdminPersonas Personas;
	
	private JComboBox combobox;
	
	private JTextField JtxtdatesCC;
	/**
	 * Apellido de la persona
	 */

	private JTextField Jtxtdatestipod;
	/**
	 * Guarda el nombre de la persona
	 */
	private JTextField Jtxtdatesgenero;
	/**
	 * Guarda el tipo de documeno de la persona
	 */
	private JTextField Jtxtdatesnombre;
	private JTextField Jtxtnumerodocumento;
	private JTextField Jtxtdatesapellido;
	private JTextField Jtxtdatesfecha;
	private JTextField JtxtdatesCelu;
	private JTextField JtxtdatesEmail;

	private JLabel JlbdatosCC;
	private JLabel Jlbnumerodocumento;
	private JLabel Jlbdatostipod;
	private JLabel Jlbdatosgenero;
	private JLabel Jlbdatosnombre;
	private JLabel Jlbdatosapellido;
	private JLabel Jlbdatosfecha;
	private JLabel JlbdatosCelu;
	private JLabel JlbdatosEmail;
	private JDateChooser JlbdateChooser;
private MainWindow mainwindow;
private Persona persona;
private Persona procesador;
private ManagerFiles managerFiles;
private int cont=0;
private String NombreArchivoPer;
private String NombreArchivoPro;
private int identificador=0;
private int controlaction=0;


	public Personas(String NomnbrePersona,String NombreProcesador,ManagerFiles manager){
		controlaction=1;
		this.managerFiles= manager;
		this.NombreArchivoPer= NomnbrePersona;
		this.NombreArchivoPro=NombreProcesador;
		setSize(600,400);
		setTitle("Personas");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		this.setLocationRelativeTo(null);
		
Jlbdatostipod= new JLabel("Tipo de documento:");
Jlbdatostipod.setBounds(30,10,150,50);
add(Jlbdatostipod);


combobox = new JComboBox();
combobox.setBounds(150,15,150,30);
add(combobox);
//		combobox.setBackground(Color.red);
combobox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
combobox.addItem("Selecione tipo de documento");
combobox.addItem("CC");
combobox.addItem("TI");
combobox.addItem("CE");


/*	JtxtdatesCC= new JTextField();
	JtxtdatesCC.setBounds(150,40,150,30);
	add(JtxtdatesCC);*/
Jlbnumerodocumento= new JLabel("Numero documento:");
Jlbnumerodocumento.setBounds(30,50, 150, 50);
add(Jlbnumerodocumento);

Jtxtnumerodocumento= new JTextField();
Jtxtnumerodocumento.setBounds(150,60, 150, 30);
add(Jtxtnumerodocumento);
Jtxtnumerodocumento.addKeyListener(new KeyAdapter() {
    public void keyReleased(KeyEvent e) {
    	
    	char validar= e.getKeyChar();
		if (Character.isLetter(validar)){
			JOptionPane.showMessageDialog(rootPane, "Ingrese Solo Numeros");
			Jtxtnumerodocumento.setText(null);
			getToolkit().beep();
			e.consume();
			
    }   }}
);


Jlbdatosnombre= new JLabel("Nombres:");	
Jlbdatosnombre.setBounds(30,100,150, 50);
add(Jlbdatosnombre);
		
		
Jtxtdatesnombre= new JTextField();
Jtxtdatesnombre.setBounds(150,110,300,30);
add(Jtxtdatesnombre);

		
		
Jlbdatosapellido= new JLabel("Apellido:");	
Jlbdatosapellido.setBounds(30,150,80, 50);
add(Jlbdatosapellido);
		

		
Jtxtdatesapellido= new JTextField();
Jtxtdatesapellido.setBounds(150,160,300,30);
add(Jtxtdatesapellido);



Jlbdatosgenero= new JLabel("Genero:");	
Jlbdatosgenero.setBounds(30,200,50, 50);
add(Jlbdatosgenero);


combobox = new JComboBox();
combobox.setBounds(150,210,150,30);
add(combobox);
//combobox.setBackground(Color.red);
combobox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
combobox.addItem("Selecione genero");
combobox.addItem("Masculino");
combobox.addItem("Femenino");


		
Jlbdatosfecha= new JLabel("Fecha nacimiento:");	
Jlbdatosfecha.setBounds(30,240, 150, 50);
add(Jlbdatosfecha);
		
		
/*Jtxtdatesfecha= new JTextField();
Jtxtdatesfecha.setBounds(150,160,150,30);
add(Jtxtdatesfecha);*/
		
		
JlbdateChooser= new JDateChooser();
JlbdateChooser.setBounds(150,260, 150, 20);
add(JlbdateChooser);

JlbdatosEmail= new JLabel("E-mail:");
JlbdatosEmail.setBounds(30,290, 100, 50);
add(JlbdatosEmail);
		
		
JtxtdatesEmail= new JTextField();
JtxtdatesEmail.setBounds(150,300,150, 30);
add(JtxtdatesEmail);
	
	
		

JbtnCancelar= new JButton("CANCELAR");
JbtnCancelar.setActionCommand(CALCULATE);
JbtnCancelar.addActionListener(actionsButtons2);
JbtnCancelar.setBounds(110,340, 150, 30);
add(JbtnCancelar);
		
		
		

JbtnNuevp= new JButton("GUARDAR");
JbtnNuevp.setActionCommand(CALCULATE);
JbtnNuevp.addActionListener(actionsButtons1);
JbtnNuevp.setBounds(360,340, 150, 30);
add(JbtnNuevp);
		
	 }
	
	
	
	public void Personas_Show(){
		Show_Selected_Person();
		System.out.println("PASO POR LA PARTE 1");
		controlaction=1;
	    Persona p = new Persona(persona);
		setSize(600,400);
		setTitle("Personas");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		this.setLocationRelativeTo(null);
		
Jlbdatostipod= new JLabel("Tipo de documento:");
Jlbdatostipod.setBounds(30,10,150,50);
add(Jlbdatostipod);


combobox = new JComboBox();
combobox.setBounds(150,15,150,30);
add(combobox);
combobox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
combobox.addItem("Selecione tipo de documento");
combobox.addItem("CC");
combobox.addItem("TI");
combobox.addItem("CE");


Jlbnumerodocumento= new JLabel("Numero documento:");
Jlbnumerodocumento.setBounds(30,50, 150, 50);
add(Jlbnumerodocumento);

Jtxtnumerodocumento= new JTextField();
Jtxtnumerodocumento.setBounds(100,60, 150, 30);
int numero= p.getDocumentNumber();
System.out.println("EL NUMERO SELECCIONADO ES:");
System.out.println(p.getDocumentNumber());
Jtxtnumerodocumento.setText(Integer.toString(numero));
add(Jtxtnumerodocumento);



Jlbdatosnombre= new JLabel("Nombres:");	
Jlbdatosnombre.setBounds(30,100,150, 50);
add(Jlbdatosnombre);
		
		
Jtxtdatesnombre= new JTextField();
Jtxtdatesnombre.setBounds(150,110,300,30);
Jtxtdatesnombre.setText(p.getName());
add(Jtxtdatesnombre);

		
		
Jlbdatosapellido= new JLabel("Apellidos:");	
Jlbdatosapellido.setBounds(30,150,80, 50);
add(Jlbdatosapellido);
		

		
Jtxtdatesapellido= new JTextField();
Jtxtdatesapellido.setBounds(150,160,300,30);
Jtxtdatesapellido.setText(p.getLastName());
add(Jtxtdatesapellido);




Jlbdatosgenero= new JLabel("Genero:");	
Jlbdatosgenero.setBounds(30,200,50, 50);
add(Jlbdatosgenero);


combobox = new JComboBox();
combobox.setBounds(150,210,150,30);

combobox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
combobox.addItem("Selecione genero");
combobox.addItem("Masculino");
combobox.addItem("Femenino");
Genero genero= persona.getGenero();

/**
 * pendiente de programar
 */
/*int contador=0;
if (genero.toString()=="M"){
	cont=1;
}else{
	if (genero.toString()=="F"){
	cont=2;
}
}
combobox.setSelectedIndex(contador);
*/
add(combobox);
		
Jlbdatosfecha= new JLabel("Fecha nacimiento:");	
Jlbdatosfecha.setBounds(30,240, 150, 50);
add(Jlbdatosfecha);
		
		
JlbdateChooser= new JDateChooser();
JlbdateChooser.setBounds(150,260, 150, 20);
//java.util.Date cumpleaños =persona.getBirthday();
//JlbdateChooser.setDate(cumpleaños);
add(JlbdateChooser);



JlbdatosEmail= new JLabel("E-mail:");
JlbdatosEmail.setBounds(30,290, 100, 50);
add(JlbdatosEmail);
		
		
JtxtdatesEmail= new JTextField();
JtxtdatesEmail.setBounds(150,300,150, 30);
JtxtdatesEmail.setText(p.getEmail());
add(JtxtdatesEmail);

	
		

JbtnCancelar= new JButton("CANCELAR");
JbtnCancelar.setActionCommand(CALCULATE);
JbtnCancelar.addActionListener(actionsButtons2);
JbtnCancelar.setBounds(110,340, 150, 30);
add(JbtnCancelar);
		
		
		

JbtnNuevp= new JButton("GUARDAR");
JbtnNuevp.setActionCommand(CALCULATE);
JbtnNuevp.addActionListener(actionsButtons1);
JbtnNuevp.setBounds(360,340, 150, 30);
add(JbtnNuevp);
repaint();
		
	 }


	
	public void paint (Graphics g){
	       super.paint(g);
	       g.drawLine (0, 360, 600, 360);
	//
	   }
	
	
public void SaveObjectPersona(){
int numero=Integer.parseInt(Jtxtnumerodocumento.getText());
String Nombre=Jtxtdatesnombre.getText();
String Apellido= Jtxtdatesapellido.getText();
java.util.Date Cumpleaños= JlbdateChooser.getDate();
String Email= JlbdatosEmail.getText();
String Genero=combobox.getSelectedItem().toString();

System.out.println("¡¡¡¡¡¡¡¡¡¡¡LOS DATOS DE LA PERSONA SON!!!!!!!!!!"+numero);

System.out.println("el valor del numero es"+numero);
System.out.println("el valor del nombre es"+Nombre);


persona = new Logica.Persona(numero,Nombre ,Apellido, Cumpleaños, Email);
//persona.validarPersona(numero, Genero,Nombre, Apellido, Cumpleaños, Email);
//procesador= new Logica.Procesador(jt, cache, frecuencia, numeroNucleos, conjuntoInstrucciones);
//managerFiles= new ManagerFiles(NombreArchivoPer);
managerFiles.setParametro(NombreArchivoPer);
System.out.println("el valor del parametros es"+managerFiles.getParametro());
System.out.println(Integer.toString(cont));
try {
	managerFiles.SavePersona(persona,cont);
	cont++;

 
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
Jtxtnumerodocumento.setText(null);
Jtxtdatesnombre.setText(null);
Jtxtdatesapellido.setText(null); 
JtxtdatesEmail.setText(null);
		}
	

	public void Show_Selected_Person(){
		System.out.println("PASO POR LA PARTE 2");
		String aux= JOptionPane.showInputDialog("ingrese el numero de la persona a modificar");
		identificador= Integer.parseInt(aux);
		managerFiles.setParametro(NombreArchivoPer);
		try {
			persona=new Persona(managerFiles.getArrayListPerson().get(identificador));
		   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * se debe dar la posicion de la person que se quiere editar
		 */
		
	}

	/**
	 * 
	 * 1º
	 */
	
ActionListener actionsButtons1 = new ActionListener() {		
		public void actionPerformed(ActionEvent a) {
			if(a.getActionCommand().equals(CALCULATE)){
			System.out.println("Nuevo");
			setVisible(false);
			SaveObjectPersona();	
				if (controlaction==1){
					try {
						managerFiles.EditPersona(managerFiles.getArrayListPerson().get(identificador),identificador);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	     		
				}
			
	
			}
			}
		};


		/**
		 * 2º 
		 */
	ActionListener actionsButtons2 = new ActionListener() {		
	public void actionPerformed(ActionEvent a) {
	if(a.getActionCommand().equals(CALCULATE)){
	System.out.println("Cancelar");
	mainwindow= new MainWindow(NombreArchivoPer,NombreArchivoPro,managerFiles);
	setVisible(false);
	mainwindow.setVisible(true);



	}
	}
	};

	public void actionPerformed11(ActionEvent c ) {
	//imagenes  = new Imagenes();
	//imagenes.cargarImagen(panel.getGraphics());
	if(c.getActionCommand().equals(CALCULATE)){
	System.out.println("funciona2");
	}

	}
	/**
	 * 2º 
	 */
ActionListener actionsButtons3 = new ActionListener() {		
public void actionPerformed(ActionEvent a) {

	if(a.getActionCommand().equals(CALCULATE)){
		System.out.println("funciona3");
		mainwindow= new MainWindow(NombreArchivoPer,NombreArchivoPro,managerFiles);
		mainwindow.setVisible(true);

}
}
};
	



	public JButton getJbtnCancelar() {
		return JbtnCancelar;
	}


	public void setJbtnCancelar(JButton jbtnCancelar) {
		JbtnCancelar = jbtnCancelar;
	}


	public JButton getJbtnModificar() {
		return JbtnModificar;
	}


	public void setJbtnModificar(JButton jbtnModificar) {
		JbtnModificar = jbtnModificar;
	}


	public JButton getJbtnNuevp() {
		return JbtnNuevp;
	}


	public void setJbtnNuevp(JButton jbtnNuevp) {
		JbtnNuevp = jbtnNuevp;
	}


	public AdminPersonas getPersonas() {
		return Personas;
	}


	public void setPersonas(AdminPersonas personas) {
		Personas = personas;
	}


	public JComboBox getCombobox() {
		return combobox;
	}


	public void setCombobox(JComboBox combobox) {
		this.combobox = combobox;
	}


	public JLabel getJlbdatosCC() {
		return JlbdatosCC;
	}


	public void setJlbdatosCC(JLabel jlbdatosCC) {
		JlbdatosCC = jlbdatosCC;
	}


	public JLabel getJlbnumerodocumento() {
		return Jlbnumerodocumento;
	}


	public void setJlbnumerodocumento(JLabel jlbnumerodocumento) {
		Jlbnumerodocumento = jlbnumerodocumento;
	}


	public JLabel getJlbdatostipod() {
		return Jlbdatostipod;
	}


	public void setJlbdatostipod(JLabel jlbdatostipod) {
		Jlbdatostipod = jlbdatostipod;
	}


	public JLabel getJlbdatosgenero() {
		return Jlbdatosgenero;
	}


	public void setJlbdatosgenero(JLabel jlbdatosgenero) {
		Jlbdatosgenero = jlbdatosgenero;
	}


	public JLabel getJlbdatosnombre() {
		return Jlbdatosnombre;
	}


	public void setJlbdatosnombre(JLabel jlbdatosnombre) {
		Jlbdatosnombre = jlbdatosnombre;
	}


	public JLabel getJlbdatosapellido() {
		return Jlbdatosapellido;
	}


	public void setJlbdatosapellido(JLabel jlbdatosapellido) {
		Jlbdatosapellido = jlbdatosapellido;
	}


	public JLabel getJlbdatosfecha() {
		return Jlbdatosfecha;
	}


	public void setJlbdatosfecha(JLabel jlbdatosfecha) {
		Jlbdatosfecha = jlbdatosfecha;
	}


	public JLabel getJlbdatosCelu() {
		return JlbdatosCelu;
	}


	public void setJlbdatosCelu(JLabel jlbdatosCelu) {
		JlbdatosCelu = jlbdatosCelu;
	}


	public JLabel getJlbdatosEmail() {
		return JlbdatosEmail;
	}


	public void setJlbdatosEmail(JLabel jlbdatosEmail) {
		JlbdatosEmail = jlbdatosEmail;
	}


	public void finalize() throws Throwable {

	}
	//-----------los txt field
	




	public JTextField getJtxtTipoDocumento() {
		return JtxtTipoDocumento;
	}


	public JDateChooser getJlbdateChooser() {
		return JlbdateChooser;
	}


	public void setJlbdateChooser(JDateChooser jlbdateChooser) {
		JlbdateChooser = jlbdateChooser;
	}


	public void setJtxtTipoDocumento(JTextField jtxtTipoDocumento) {
		JtxtTipoDocumento = jtxtTipoDocumento;
	}


	public JTextField getJtxtdatesCC() {
		return JtxtdatesCC;
	}


	public void setJtxtdatesCC(JTextField jtxtdatesCC) {
		JtxtdatesCC = jtxtdatesCC;
	}


	public JTextField getJtxtdatestipod() {
		return Jtxtdatestipod;
	}


	public void setJtxtdatestipod(JTextField jtxtdatestipod) {
		Jtxtdatestipod = jtxtdatestipod;
	}


	public JTextField getJtxtdatesgenero() {
		return Jtxtdatesgenero;
	}


	public void setJtxtdatesgenero(JTextField jtxtdatesgenero) {
		Jtxtdatesgenero = jtxtdatesgenero;
	}


	public JTextField getJtxtdatesnombre() {
		return Jtxtdatesnombre;
	}


	public void setJtxtdatesnombre(JTextField jtxtdatesnombre) {
		Jtxtdatesnombre = jtxtdatesnombre;
	}


	public JTextField getJtxtnumerodocumento() {
		return Jtxtnumerodocumento;
	}


	public void setJtxtnumerodocumento(JTextField jtxtnumerodocumento) {
		Jtxtnumerodocumento = jtxtnumerodocumento;
	}


	public JTextField getJtxtdatesapellido() {
		return Jtxtdatesapellido;
	}


	public void setJtxtdatesapellido(JTextField jtxtdatesapellido) {
		Jtxtdatesapellido = jtxtdatesapellido;
	}


	public JTextField getJtxtdatesfecha() {
		return Jtxtdatesfecha;
	}


	public void setJtxtdatesfecha(JTextField jtxtdatesfecha) {
		Jtxtdatesfecha = jtxtdatesfecha;
	}


	public JTextField getJtxtdatesCelu() {
		return JtxtdatesCelu;
	}


	public void setJtxtdatesCelu(JTextField jtxtdatesCelu) {
		JtxtdatesCelu = jtxtdatesCelu;
	}


	public JTextField getJtxtdatesEmail() {
		return JtxtdatesEmail;
	}


	public void setJtxtdatesEmail(JTextField jtxtdatesEmail) {
		JtxtdatesEmail = jtxtdatesEmail;
	}


	public ManagerFiles getManagerFiles() {
		return managerFiles;
	}


	public void setManagerFiles(ManagerFiles managerFiles) {
		this.managerFiles = managerFiles;
	}
	public Persona getProcesador() {
		return procesador;
	}


	public void setProcesador(Persona procesador) {
		this.procesador = procesador;
	}
	

	
}//end Personas