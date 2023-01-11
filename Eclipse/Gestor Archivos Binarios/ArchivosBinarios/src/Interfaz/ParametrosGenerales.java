package Interfaz;

import java.awt.Color;


import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Logica.ManagerFiles;
import Logica.Persona;
import Logica.Procesador;
import Persistencia.ControlFile;

/**
 * permite guardar los valores por defecto de los archivos a modiicar
 * @author Mateo
 * @version 1.0
 * @created 20-mar.-2015 12:12:22 p. m.
 */
public class ParametrosGenerales extends JFrame {
	
	
	
	
	static final String CALCULATE= "calculate";	
	/**
	 * 
	 */
	
	private JLabel idioma;
	/**
	 * permite elegir el archivo que entre por parametro
	 */
	private JLabel ArchivoPersona;
	
	/**
	 * permite elegir el archivo que se encuentre por paametro
	 */
	
	private JLabel ArchivoProcesador;
	
	/**
	 * permite guardar la informacion por defecto
	 */
	private JButton JButtonGuardar;
	
	private JCheckBox JchkIdioma;
	/**
	 * permite configurar el idioma de la persona
	 */
	private JTextField JTextNombrePersona;
	/**
	 * guarda el procesador
	 */
	private JTextField JtxtNombreArchivoProcesador;
	/**
	 * permite configurar los valores los idiomas
	 *  
	 */
	private JComboBox combobox;
	
	/**
	 * permite configurar los parametros generales de
	 * del archivo
	 */
	private Archivo ParametrosGenerales;
	/**
	 * llamas los metodos del archivo
	 */
	public Archivo m_Archivo;
	
	
/**
 * llamar la clase cambio
 */

	public Change change;

	
	private int cont=0;


private Persona persona;

private Procesador procesador;

private ManagerFiles managerfilesP;

private String NombreProcesador;
private  String NombrePersona;

private ControlFile controlfile;





	
//-------------------Constructor de la clase----------------
	
	
	public ParametrosGenerales(){	
	
		setSize(500,300);
		setTitle("Administador de Archivos");
		setLayout(null);
		setResizable(false);
		this.setLocationRelativeTo(null);
//		 this.getContentPane().setBackground(Color.orange);
		   
		/*	Jlbldatos= new JLabel();
			Jlbldatos.setBounds(10,250, 200, 30);
			add(Jlbldatos);*/
	
       
		idioma=new JLabel("Idioma:");
		idioma.setBounds(30, 20, 150, 30);
		add(idioma);
			
	
		
		//pendiente
	combobox = new JComboBox();
		combobox.setBounds(220,20,250, 30);
//		combobox.setBackground(Color.red);
		combobox.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		combobox.setActionCommand(CALCULATE);
	    combobox.addItem("Español");
	    combobox.addItem("Ingles");
	    
		combobox.addActionListener(actionsCombo2);
		 add(combobox);
	    
	
		 
		 
	    ArchivoPersona= new JLabel("Nombre Archivo Persona:");
	    ArchivoPersona.setBounds(30,70, 180, 30);
	    add(ArchivoPersona);
	    
	    
	    JTextNombrePersona= new JTextField();
	    JTextNombrePersona.setBounds(220, 70,210, 30);
		add(JTextNombrePersona);
	    
	    
		
		
		
	    ArchivoProcesador= new JLabel("Nombre archivo Procesadores:");
	    ArchivoProcesador.setBounds(30, 130, 180, 30);
		add(ArchivoProcesador);
	    
		
		
	    JtxtNombreArchivoProcesador= new JTextField();
	    JtxtNombreArchivoProcesador.setBounds(220, 130,210 ,30);
	    add(JtxtNombreArchivoProcesador);
	    
	    
	    JButtonGuardar= new JButton("GUARDAR");
	    
	    JButtonGuardar.setActionCommand(CALCULATE);
	    JButtonGuardar.addActionListener(actionsButtons1);
	    JButtonGuardar.setBounds(150, 240, 150, 30);
	    add(JButtonGuardar);
	    

	}
/*//pediente
	*//**
	 * 
	 * 1º
	 *//*
	ItemListener actionsCombo1 = new ItemListener() {		
		public void ItemPerformed(ItemEvent a) {
			System.out.println("inble");
			if (a.getItem().equals(CALCULATE)){
			//if(a.getItemSelectable().equals(CALCULATE)){
			System.out.println("INGLES");
			
			
			}
			}

		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		};*/
		
		
		/**
		 * 
		 * 2°
		 */
		
		
		
		ActionListener actionsCombo2 = new ActionListener() {		
			public void actionPerformed(ActionEvent a) {
//				change= new Change();
				
				if(a.getActionCommand().equals(CALCULATE))
					if(combobox.getSelectedItem().equals("Español")){
				System.out.println("ESPAÑOL");
				cont=1;
//				change.Change();
				}else{
					
					if(combobox.getSelectedItem().equals("Ingles")){
						System.out.println("INGLES");
						cont=0;
//						change.Change();
					}
				}
			}		
			};
		

				
				/**
				 * 
				 * 4°
				 */
				
				ActionListener actionsButtons1 = new ActionListener() {		
					public void actionPerformed(ActionEvent a) {
						if(a.getActionCommand().equals(CALCULATE)){
							
							if(JTextNombrePersona.equals("  ") || JTextNombrePersona.equals("  ") || JTextNombrePersona.equals(",")|| JtxtNombreArchivoProcesador.equals("  ") || JtxtNombreArchivoProcesador.equals(",") ){
								JOptionPane.showMessageDialog(null, "Ingrese correctamente la persona o procesador");
							}else{
								setNombreProcesador(JtxtNombreArchivoProcesador.getText());
								setNombrePersona(JTextNombrePersona.getText().toString());
								
							managerfilesP= new ManagerFiles(JTextNombrePersona.getText().toString());
							managerfilesP.initializacePersona();
							
							
							managerfilesP= new ManagerFiles(JtxtNombreArchivoProcesador.getText().toString());
							managerfilesP.initializaceProcesador();
							//managerfilesP= new ManagerFiles();
							//change.AsignateManager(managerfilesP);
							
							System.out.println(cont);
							try {
								change= new Change(JTextNombrePersona.getText(),JtxtNombreArchivoProcesador.getText(),managerfilesP);
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							//mainwindow.getVentanaAdmtospersona().getControlFile()
							
						if(cont==0){
							change.ChangeEnglish();
							setVisible(false);
						}else{
							if(cont==1){
								change.ChangeEspañol();
								setVisible(false);
							}
						}
							System.out.println("Nuevo");
						
						
						}
						}
					}
					};
					
				
	public void paint (Graphics g){
       super.paint(g);
       g.drawLine (0, 230, 600, 230);
//
   }
	
public JButton getJButtonGuardar() {
		return JButtonGuardar;
	}


	public void setJButtonGuardar(JButton jButtonGuardar) {
		JButtonGuardar = jButtonGuardar;
	}


	public JCheckBox getJchkIdioma() {
		return JchkIdioma;
	}


	public void setJchkIdioma(JCheckBox jchkIdioma) {
		JchkIdioma = jchkIdioma;
	}


	public JComboBox getCombobox() {
		return combobox;
	}


	public void setCombobox(JComboBox combobox) {
		this.combobox = combobox;
	}

	public JLabel getIdioma() {
		return idioma;
	}

	public void setIdioma(JLabel idioma) {
		this.idioma = idioma;
	}

	public JLabel getArchivoPersona() {
		return ArchivoPersona;
	}

	public void setArchivoPersona(JLabel archivoPersona) {
		ArchivoPersona = archivoPersona;
	}

	public JLabel getArchivoProcesador() {
		return ArchivoProcesador;
	}

	public void setArchivoProcesador(JLabel archivoProcesador) {
		ArchivoProcesador = archivoProcesador;
	}

	public JTextField getJTextNombrePersona() {
		return JTextNombrePersona;
	}

	public void setJTextNombrePersona(JTextField jTextNombrePersona) {
		JTextNombrePersona = jTextNombrePersona;
	}

	public JTextField getJtxtNombreArchivoProcesador() {
		return JtxtNombreArchivoProcesador;
	}

	public void setJtxtNombreArchivoProcesador(
			JTextField jtxtNombreArchivoProcesador) {
		JtxtNombreArchivoProcesador = jtxtNombreArchivoProcesador;
	}


public ManagerFiles getManagerfilesP() {
	return managerfilesP;
}

public void setManagerfilesP(ManagerFiles managerfilesP) {
	this.managerfilesP = managerfilesP;
}public String getNombreProcesador() {
	return NombreProcesador;
}

public void setNombreProcesador(String nombreProcesador) {
	NombreProcesador = nombreProcesador;
}

public String getNombrePersona() {
	return NombrePersona;
}

public void setNombrePersona(String nombrePersona) {
	NombrePersona = nombrePersona;
}


	
}//end ParametrosGenerales