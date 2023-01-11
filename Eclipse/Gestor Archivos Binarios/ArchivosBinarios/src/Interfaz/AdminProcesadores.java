package Interfaz;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import Interfaz.AdminPersonas.NombreListener;
import Interfaz.MainWindow.ConfigPersListener;
import Logica.ManagerFiles;
import Persistencia.ControlFile;

/**
 * Adminstrara los procesdores del archivo
 * @author Mateo
 * @version 1.0
 * @created 20-mar.-2015 12:12:16 p. m.
 */
public class AdminProcesadores extends JDialog {

	public Change m_Objetos;

	
	private JButton btnNuevo;
	
	private JButton btnCancelar;
	
	private JButton btnModificar;
	
	
	private JLabel Jlbldatos;
	
	private JComboBox combobox;
	private JComboBox combobox1;

	private JScrollBar Jscroll;
	
	private JPanel panel;
	
	private JTextArea textarea;
	
	private static final String CALCULATE= "calculate";
	
	private MainWindow mainwindow;

	
	
	private  String Marca= "MARCA";
	private   String NumeroNuc= "NUMERO DE NUCLEOS";
	private  String FrecuenciaReloj= "FRECUENCIA DE RELOJ";
	private   String Cache= "CACHE";
	private  String ConjuntoInstrucciones = "CONJUNTO INSTRUCCIONES";
	private ManagerFiles files;
	private ControlFile controlfile;
	

public AdminProcesadores(){

setSize(600,400);
			setTitle("Administador procesadores");
			setLayout(null);

			setResizable(false);
			this.setLocationRelativeTo(null);
//			 this.getContentPane().setBackground(Color.orange);
			   
			/*	Jlbldatos= new JLabel();
				Jlbldatos.setBounds(10,250, 200, 30);
				add(Jlbldatos);*/
			
			
			
			  textarea= new JTextArea();
			 JScrollPane scroll = new JScrollPane(textarea);//Creamos el JTextArea y le pasamos como parametro el textArea
			 scroll.setBounds(30,60,500,270);//Posicionamos el JScrollPane "scroll"
			 add(scroll);//Agregamos el scroll a la ventana
			 repaint();
			 
			
	         UIManager.put("Frame.background", Color.white);
	       
	       
	         NombreListener n = new NombreListener();
	         ApellidoListener s= new ApellidoListener();
			 
			 
			 /**
		         * PRIMER COMBO
		         */
				combobox = new JComboBox();
				combobox.setBounds(30,20,250, 30);
				combobox.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
//				combobox.addActionListener(s);
				combobox.addItem(Marca);    
			    combobox.addItem(NumeroNuc);
			    combobox.addItem(FrecuenciaReloj);
			    combobox.addItem(Cache);
			    combobox.addItem(ConjuntoInstrucciones);
			    combobox.addActionListener(n);
			    combobox.setActionCommand(CALCULATE);
			    add(combobox);
			    

			
			    /**
			     * SEGUNDO COMBO
			     */
			    
			    combobox1 = new JComboBox();
				combobox1.setBounds(280,20,250, 30);
			    combobox1.addItem(Marca);    
			    combobox1.addItem(NumeroNuc);
			    combobox1.addItem(FrecuenciaReloj);
			    combobox1.addItem(Cache);
			    combobox1.addItem(ConjuntoInstrucciones);
			    combobox1.addActionListener(n);
			    combobox1.setActionCommand(CALCULATE);
			    add(combobox1);
			    
			    
			    
			    
			    
		   
			 btnNuevo= new JButton("Nuevo");
			 btnNuevo.setBounds(140, 340, 100, 30);
			 btnNuevo.setActionCommand(CALCULATE);
			 btnNuevo.addActionListener(actionsButtons3);
			 add(btnNuevo);
			
			 btnModificar= new JButton("Modificar");
			 btnModificar.setBounds(260, 340, 100, 30);
			 btnModificar.setActionCommand(CALCULATE);
			 btnModificar.addActionListener(actionsButtons3);
			 add(btnModificar);
			 
			 btnCancelar= new JButton("Cancelar");
			 btnCancelar.setBounds(380, 340, 100, 30);
			 btnCancelar.setActionCommand(CALCULATE);
			 btnCancelar.addActionListener(actionsButtons3);
			 add( btnCancelar);
			 inicializar();
		
			 }
	


public void inicializar(){
	textarea= new JTextArea();
	 JScrollPane scroll = new JScrollPane(textarea);//Creamos el JTextArea y le pasamos como parametro el textArea
	 scroll.setBounds(30,60,500,270);//Posicionamos el JScrollPane "scroll"
	 add(scroll);//Agregamos el scroll a la ventana
	 repaint();
	 //controlfile= new ControlFile();
	 
	
    UIManager.put("Frame.background", Color.white);
//INICIALIZACION DE LAS ACCIONES DE LOS BOTONES
}



		
		public void paint (Graphics g){
	        super.paint(g);
	        g.drawLine (0, 360, 600, 360);
	//
	    }
		
		
		public void readObjetProce(){
			String valor="";
			try {
				files.ReadProcesador();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("el tamaño del archivo es"+files.getArrayListProcesa().size());
			System.out.println("EL NOMBRE DEl cache es"+files.getArrayListProcesa().get(0).getCache());			
			for (int i=0; i<=files.getArrayListProcesa().size()-1;i++){
				valor+=("Datos del Archivo Procesador:"+ "\n" 
				+"Nombre de Marca:"+" "+ files.getArrayListProcesa().get(i).getMarca()+" "+"\n"
				+"Instruccciones del Producto:"+" " +files.getArrayListProcesa().get(i).getInstrucciones()+"\t"
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
		public void ChargeManagerFiles(ManagerFiles managerFiles){
			this.files=managerFiles;
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
			
			//setVisible(false); 
			readObjetProce();
		/*	mainwindow= new MainWindow();
			mainwindow.setVisible(true);
			try {
				this.finalize();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/

	}
	}
	};
	
	public class NombreListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand().equals(CALCULATE)){
				//
			if(combobox.getSelectedItem().equals("MARCA")){
//			System.out.println("SI");
			
			System.out.println(combobox.getSelectedItem().toString());
			}else{
//				System.out.println("NO");
				if(combobox.getSelectedItem().equals("NUMERO DE NUCLEOS")){
//					System.out.println("SI");
					System.out.println(combobox.getSelectedItem().toString());
					
				}else{
//					System.out.println("NO");
					if(combobox.getSelectedItem().equals("FRECUENCIA RELOJ")){
//						System.out.println("SI");
						System.out.println(combobox.getSelectedItem().toString());
						
					}else{
//						System.out.println("NO");
						if(combobox.getSelectedItem().equals("CACHE")){
//							System.out.println("SI");
							System.out.println(combobox.getSelectedItem().toString());
							
						}else{
//							System.out.println("NO");
							if(combobox.getSelectedItem().equals("CONJUNTO INSTRUCCIONES")){
//								System.out.println("SI");
								System.out.println(combobox.getSelectedItem().toString());
								
							}else{
//								System.out.println("NO");
			
					}
				}
			
			}
		//System.out.println(e.getActionCommand());
		}
		}
		}
		}
		}
	public class 	ApellidoListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand().equals(CALCULATE)){
				//
			if(combobox1.getSelectedItem().equals("MARCA")){
//			System.out.println("SI");
			
			System.out.println(combobox1.getSelectedItem().toString());
			}else{
//				System.out.println("NO");
				if(combobox1.getSelectedItem().equals("NUMERO DE NUCLEOS")){
//					System.out.println("SI");
					System.out.println(combobox1.getSelectedItem().toString());
					
				}else{
//					System.out.println("NO");
					if(combobox1.getSelectedItem().equals("FRECUENCIA RELOJ")){
//						System.out.println("SI");
						System.out.println(combobox1.getSelectedItem().toString());
						
					}else{
//						System.out.println("NO");
						if(combobox1.getSelectedItem().equals("CACHE")){
//							System.out.println("SI");
							System.out.println(combobox1.getSelectedItem().toString());
							
						}else{
//							System.out.println("NO");
							if(combobox1.getSelectedItem().equals("CONJUNTO INSTRUCCIONES")){
//								System.out.println("SI");
								System.out.println(combobox1.getSelectedItem().toString());
								
							}else{
//								System.out.println("NO");
			
					}
				}
			
			}
		//System.out.println(e.getActionCommand());
		}
		}
		}
		}
		}



	public JLabel getJlbldatos() {
		return Jlbldatos;
	}




	public void setJlbldatos(JLabel jlbldatos) {
		Jlbldatos = jlbldatos;
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




	public JPanel getPanel() {
		return panel;
	}




	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	



	public String getMarca() {
		return Marca;
	}




	public void setMarca(String marca) {
		Marca = marca;
	}




	public String getNumeroNuc() {
		return NumeroNuc;
	}




	public void setNumeroNuc(String numeroNuc) {
		NumeroNuc = numeroNuc;
	}




	public String getFrecuenciaReloj() {
		return FrecuenciaReloj;
	}




	public void setFrecuenciaReloj(String frecuenciaReloj) {
		FrecuenciaReloj = frecuenciaReloj;
	}




	public String getCache() {
		return Cache;
	}




	public void setCache(String cache) {
		Cache = cache;
	}




	public String getConjuntoInstrucciones() {
		return ConjuntoInstrucciones;
	}




	public void setConjuntoInstrucciones(String conjuntoInstrucciones) {
		ConjuntoInstrucciones = conjuntoInstrucciones;
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




	public void finalize() throws Throwable {

	}
}//end AdminProcesadores