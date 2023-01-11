package Interfaz;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.control.ComboBox;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.rowset.internal.Row;

import Logica.Language;
import Logica.ManagerFiles;
import Logica.Persona;
import Persistencia.ControlFile;

/**
 * permite administrar las personas  ingresados en el archivo
 * @author Mateo
 * @version 1.0
 * @created 20-mar.-2015 12:12:16 p. m.
 */
public class AdminPersonas extends JDialog implements ActionListener{

	public Change m_Objetos;
	
	private JButton btnNuevo;
	
	private JButton btnCancelar;
	
	private JButton btnModificar;
	

	private JComboBox combobox;
	
	private JComboBox combobox1;

	private JScrollBar Jscroll;
	
	private JPanel panel;
	
	private JTextArea textarea;
	
	
	private MainWindow mainwindow;
	
	private Logica.Persona Persona;
	
	
	
	
	
	private  String CALCULATE= "calculate";
	private  String CALCULATE1= "calculate1";
	private  String Nombre= "NOMBRE";
	private  String Apellido= "APELLIDO";
	private  String Genero= "GENERO";
	private  String Email= "EMAIL";
	private String NumeroDoc = "NUMERO DE DOCUMENTO";
	private  String FechaNacimiento= "FECHA DE NACIMIENTO";
	private ControlFile controlFile;
	private ManagerFiles files;
	
	
	
	public AdminPersonas(){
		
		setSize(600,400);
		setTitle("Administador personas");
		setLayout(null);
		setResizable(false);
		this.setLocationRelativeTo(null);
		
		
		
		
         
       
        NombreListener n = new NombreListener();
        ApellidoListener s = new ApellidoListener();
        woeer r= new woeer();
        
        
        
		
	/*JComboBox<JMenuItem> combo = null;
	combo.addItem((combobox.addItem("NOMBRE"));	
	combobox.addItem(combo);
	*/	

		
 
        /**
         * PRIMER COMBO
         */
		combobox = new JComboBox();
		combobox.setBounds(30,20,250, 30);
//		combobox.addItemListener(r);
		combobox.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
//		combobox.addActionListener(s);
		combobox.addItem(Nombre);    
	    combobox.addItem(Apellido);
	    combobox.addItem(NumeroDoc);
	    combobox.addItem(Genero);
	    combobox.addItem(Email);
	    combobox.addItem(FechaNacimiento);
	    combobox.addActionListener(n);
	    combobox.setActionCommand(CALCULATE);
	    add(combobox);
	    

	
	    /**
	     * SEGUNDO COMBO
	     */
	    
	    combobox1 = new JComboBox();
		combobox1.setBounds(280,20,250, 30);
		combobox1.addItem(Nombre);    
	    combobox1.addItem(Apellido);
	    combobox1.addItem(NumeroDoc);
	    combobox1.addItem(Genero);
	    combobox1.addItem(Email);
	    combobox1.addItem(FechaNacimiento);
	    combobox1.addActionListener(s);
	    combobox1.setActionCommand(CALCULATE);
	    add(combobox1);
	
//	}
	
	 
	    btnNuevo= new JButton("Nuevo");
	    btnNuevo.setBounds(140, 340, 100, 30);
		
	    btnNuevo.setActionCommand(CALCULATE);
	    btnNuevo.addActionListener(actionsButtons1);
         add(btnNuevo);
		 
		
		 btnModificar= new JButton("Mostrar");
		 btnModificar.setBounds(260, 340, 100, 30);
		 btnModificar.setActionCommand(CALCULATE);
		 btnModificar.addActionListener(actionsButtons2);
		 add(btnModificar);
		 
		 
		 
		 btnCancelar= new JButton("Cancelar");
		 btnCancelar.setActionCommand(CALCULATE);
		 btnCancelar.addActionListener(actionsButtons3);
		 btnCancelar.setBounds(380, 340, 100, 30);
		 add(btnCancelar);
		 
	inicializar();
	}
	

	
	
	public void inicializar(){
		textarea= new JTextArea();
		 JScrollPane scroll = new JScrollPane(textarea);//Creamos el JTextArea y le pasamos como parametro el textArea
		 scroll.setBounds(30,60,500,270);//Posicionamos el JScrollPane "scroll"
		 add(scroll);//Agregamos el scroll a la ventana
		 repaint();
		
		 
		
        UIManager.put("Frame.background", Color.white);
//INICIALIZACION DE LAS ACCIONES DE LOS BOTONES
	}
	
	public void ChargeManagerFiles(ManagerFiles managerFiles){
	this.files=managerFiles;
	}

	
	public void paint (Graphics g){
        super.paint(g);
        g.drawLine (0, 360, 600, 360);
//
    }


	public void finalize() throws Throwable {

	}
	
	//---------------------METODOS--------------------------------------

	
			/**
			 * 
			 * 1º
			 */
			
	ActionListener actionsButtons1 = new ActionListener() {		
				public void actionPerformed(ActionEvent a) {
					if(a.getActionCommand().equals(CALCULATE)){
					System.out.println("funciona1");
					//SaveObjectPerson(parametros);
					}
					}
				};


				/**
				 * 2º 
				 */
			ActionListener actionsButtons2 = new ActionListener() {		
			public void actionPerformed(ActionEvent a) {
			String valor="";
			if(a.getActionCommand().equals(CALCULATE)){
			System.out.println("funciona1");
			try {
				files.ReadPersona();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("el tamaño del archivo es"+files.getArrayListPerson().size());
			//System.out.println("EL NOMBRE DE LA PERSONA ES"+files.getArrayListPerson().get(0).getDocumentNumber());			
			for (int i=0; i<=files.getArrayListPerson().size()-1;i++){
				valor+=("Datos del Archivo Persona:"+ "\n" 
				+"Numero de Docuemto:"+" "+ files.getArrayListPerson().get(i).getDocumentNumber()+" "+"\n"
				+"Nombre de la Persona:"+" " +files.getArrayListPerson().get(i).getName()+"\t"
                +"si pasoa"+"el valor de i:"+" "+i+"\n");
				//textarea.setText("Datos de la Persona"+ " "+files.getArrayListPerson().get(0).getDocumentNumber()+" " +files.getArrayListPerson().get(i).getName()+"\t");
				
				 //textarea.setText(files.getArrayListPerson().get(i).getName());
				 //textarea.setText(files.getArrayListPerson().get(i).getLastName());
				// textarea.setText(files.getArrayListPerson().get(i).getGenre().toString());
				 //textarea.setText(files.getArrayListPerson().get(i).getLastName());
				 //textarea.setText(files.getArrayListPerson().get(i).getBirthday().toString());
				 //textarea.setText(files.getArrayListPerson().get(i).getDocumentType().toString());
			 }
			 
		textarea.setText(valor);
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
				
				setVisible(false); 
	
			/*	mainwindow= new MainWindow();
				mainwindow.setVisible(true);*/

		}
		}
		};


	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
public class woeer implements ItemListener  {
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals(CALCULATE)){
		System.out.println(e.getActionCommand());
			}
		}

		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}
	

public class NombreListener implements ActionListener {
public void actionPerformed(ActionEvent e){
	if(e.getActionCommand().equals(CALCULATE)){
		//
	if(combobox.getSelectedItem().equals("NOMBRE")){
//	System.out.println("SI");
	
	System.out.println(combobox.getSelectedItem().toString());
	}else{
//		System.out.println("NO");
		if(combobox.getSelectedItem().equals("APELLIDO")){
//			System.out.println("SI");
			System.out.println(combobox.getSelectedItem().toString());
			
		}else{
//			System.out.println("NO");
			if(combobox.getSelectedItem().equals("NUMERO DOCUMENTO")){
//				System.out.println("SI");
				System.out.println(combobox.getSelectedItem().toString());
				
			}else{
//				System.out.println("NO");
				if(combobox.getSelectedItem().equals("GENERO")){
//					System.out.println("SI");
					System.out.println(combobox.getSelectedItem().toString());
					
				}else{
//					System.out.println("NO");
					if(combobox.getSelectedItem().equals("EMAIL")){
//						System.out.println("SI");
						System.out.println(combobox.getSelectedItem().toString());
						
					}else{
//						System.out.println("NO");
						if(combobox.getSelectedItem().equals("FECHA DE NACIMIENTO")){
//							System.out.println("SI");
							System.out.println(combobox.getSelectedItem().toString());
							
						}else{
//							System.out.println("NO");
					
					
				}
			}
		}
	
	}
//System.out.println(e.getActionCommand());
}
}
}
}
}

public class ApellidoListener implements ActionListener {
	public void actionPerformed(ActionEvent e){
	if(e.getActionCommand().equals(CALCULATE)){
		//
	if(combobox1.getSelectedItem().equals("NOMBRE")){
//	System.out.println("SI");
	
	System.out.println(combobox1.getSelectedItem().toString());
	}else{
//		System.out.println("NO");
		if(combobox1.getSelectedItem().equals("APELLIDO")){
//			System.out.println("SI");
			System.out.println(combobox1.getSelectedItem().toString());
			
		}else{
//			System.out.println("NO");
			if(combobox1.getSelectedItem().equals("NUMERO DOCUMENTO")){
//				System.out.println("SI");
				System.out.println(combobox1.getSelectedItem().toString());
				
			}else{
//				System.out.println("NO");
				if(combobox1.getSelectedItem().equals("GENERO")){
//					System.out.println("SI");
					System.out.println(combobox1.getSelectedItem().toString());
					
				}else{
//					System.out.println("NO");
					if(combobox1.getSelectedItem().equals("EMAIL")){
//						System.out.println("SI");
						System.out.println(combobox1.getSelectedItem().toString());
						
					}else{
//						System.out.println("NO");
						if(combobox1.getSelectedItem().equals("FECHA DE NACIMIENTO")){
//							System.out.println("SI");
							System.out.println(combobox1.getSelectedItem().toString());
							
						}else{
//							System.out.println("NO");
					
					
				}
			}
		}
	
	}
//System.out.println(e.getActionCommand());
}
}
}
}

}

public class TipoListener implements ActionListener {
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals(CALCULATE)){
		if(combobox.getSelectedItem().equals("TIPO")){
		System.out.println(combobox.getSelectedItem().toString());
		}
	System.out.println(e.getActionCommand());
	}
	}
	}


public class NumeroListener implements ActionListener {
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals(CALCULATE)){
		if(combobox.getSelectedItem().equals("NUMERO")){
		System.out.println(combobox.getSelectedItem().toString());
		}
	System.out.println(e.getActionCommand());
	}
	}
	}

public class GeneroListener implements ActionListener {
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals(CALCULATE)){
		if(combobox.getSelectedItem().equals("GENERO")){
		System.out.println(combobox.getSelectedItem().toString());
		}
	System.out.println(e.getActionCommand());
	}
	}
	}

public class EmailListener implements ActionListener {
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals(CALCULATE)){
		if(combobox.getSelectedItem().equals("EMAIL")){
		System.out.println(combobox.getSelectedItem().toString());
		}
	System.out.println(e.getActionCommand());
	}
	}
	}




public JButton getBtnNuevo() {
	return btnNuevo;
}


public void setBtnNuevo(JButton btnNuevo) {
	this.btnNuevo = btnNuevo;
}


public JButton getBtnCancelar() {
	return btnCancelar;
}


public void setBtnCancelar(JButton btnCancelar) {
	this.btnCancelar = btnCancelar;
}


public JButton getBtnModificar() {
	return btnModificar;
}


public void setBtnModificar(JButton btnModificar) {
	this.btnModificar = btnModificar;
}




public JComboBox getCombobox() {
	return combobox;
}


public void setCombobox(JComboBox combobox) {
	this.combobox = combobox;
}


public JComboBox getCombobox1() {
	return combobox1;
}


public void setCombobox1(JComboBox combobox1) {
	this.combobox1 = combobox1;
}




public String getNombre() {
	return Nombre;
}


public void setNombre(String nombre) {
	Nombre = nombre;
}


public String getApellido() {
	return Apellido;
}


public void setApellido(String apellido) {
	Apellido = apellido;
}


public String getGenero() {
	return Genero;
}


public void setGenero(String genero) {
	Genero = genero;
}


public String getEmail() {
	return Email;
}


public void setEmail(String email) {
	Email = email;
}


public String getNumeroDoc() {
	return NumeroDoc;
}


public void setNumeroDoc(String numeroDoc) {
	NumeroDoc = numeroDoc;
}


public String getFechaNacimiento() {
	return FechaNacimiento;
}


public void setFechaNacimiento(String fechaNacimiento) {
	FechaNacimiento = fechaNacimiento;
}


public void itemStateChanged(ItemEvent arg0) {
	// TODO Auto-generated method stub
	
}

public ControlFile getControlFile() {
	return controlFile;
}

public void setControlFile(ControlFile controlFile) {
	this.controlFile = controlFile;
}
public ManagerFiles getFiles() {
	return files;
}

public void setFiles(ManagerFiles files) {
	this.files = files;
}

//los get y los set











	
}




	
	
//end AdminPersonas