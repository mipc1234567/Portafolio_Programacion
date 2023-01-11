package Interfaz;

import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import Logica.ManagerFiles;
import Logica.Procesador;

/**
 * Permite administradar los procesadores
 * @author Mateo
 * @version 1.0
 * @created 20-mar.-2015 12:12:25 p. m.
 */
public class Procesadores  extends JFrame {

	
	/**
	 * Permite realizar los calculos llamados
	 */
			
	static final String CALCULATE= "calculate";
	/**
	 * develve al main
	 */
	private JButton JbtnCancelar;
	/**
	 * j
	 */
	private JButton JbtnModificar;
	/**
	 * crea un nuevo procesador
	 */
	private JButton JbtnGuardar;
	/**
	 * Guarda la memoria cahe del procesador
	 */
	private JTextField JtxtCache;
	/**
	 * Guarda las instrucciones
	 */
	private JTextField JTxtConjuntodeInstrucciones;
	/**
	 * guarda la frecuencia
	 */
	private JTextField JtxtFrecuenciaDeRelog;
	/**
	 * guarda la marca
	 */
	private JTextField JtxtMarca;
	/**
	 * guarada el numero de nucleos
	 */
	private JTextField JtxtNumeroNucleos;
	/**
	 * asociacion con los porcesadores
	 */
	private AdminProcesadores Procesadores;

	private JComboBox combobox;
	private JLabel JlbMarca;
	private JLabel JlbFrecuenciadeReloj;
	private JLabel JlbConjuntodeInstrucciones;
	private JLabel JlbNumeroNucleos;
	private JLabel JLabelCache;
	private Procesador procesador;
	private ManagerFiles managerFiles;
	private int cont=0;
	private String NombreArchivoPer;
	private String NombreArchivoPro;
	private String Marca;
	private int cache;
	private int frecuencia;
	private int nucleos;
	private String ConjuntoInstrucciones;
	

private MainWindow mainwindow;
	
public Procesadores(String Persona,String Procesador, ManagerFiles manager){
	this.managerFiles=manager;	
	this.NombreArchivoPer=Persona;
		this.NombreArchivoPro=Procesador; 
		setSize(600,400);
		setTitle("Procesadores");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		this.setLocationRelativeTo(null);
		
		
JlbMarca= new JLabel("Marca:");
JlbMarca.setBounds(30,10,100,50);
add(JlbMarca);

JtxtMarca= new JTextField();
JtxtMarca.setBounds(130,10,100,50);
add(JtxtMarca);
JtxtMarca.addKeyListener(new KeyAdapter() {
    public void keyReleased(KeyEvent e) {
    	
    	char validar= e.getKeyChar();
		if (Character.isLetter(validar)){
			JOptionPane.showMessageDialog(rootPane, "Ingrese Solo Numeros");
			JtxtMarca.setText(null);
			getToolkit().beep();
			e.consume();
			
    }   }}
);
    

combobox = new JComboBox();
combobox.setBounds(150,15,50,30);
//add(combobox);
//combobox.setBackground(Color.red);
combobox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
combobox.addItem("Selecione tipo de documento");
combobox.addItem("CC");
combobox.addItem("TI");
combobox.addItem("CE");

/*	JtxtdatesCC= new JTextField();
	JtxtdatesCC.setBounds(150,40,150,30);
	add(JtxtdatesCC);*/

JlbNumeroNucleos= new JLabel("Numero de nucleos:");
JlbNumeroNucleos.setBounds(30,60, 100, 50);
add(JlbNumeroNucleos);
JtxtNumeroNucleos= new JTextField();
JtxtNumeroNucleos.setBounds(150,60, 100, 30);
add(JtxtNumeroNucleos);
JtxtNumeroNucleos.addKeyListener(new KeyAdapter() {
    public void keyReleased(KeyEvent e) {
    	
    	char validar= e.getKeyChar();
		if (Character.isLetter(validar)){
			JOptionPane.showMessageDialog(rootPane, "Ingrese Solo Numeros");
			JtxtNumeroNucleos.setText(null);
			getToolkit().beep();
			e.consume();
			
    }   }}
);


JlbFrecuenciadeReloj= new JLabel("Frecuenacia de reloj:");	
JlbFrecuenciadeReloj.setBounds(30,100,150, 50);
add(JlbFrecuenciadeReloj);
		
JtxtFrecuenciaDeRelog= new JTextField();
JtxtFrecuenciaDeRelog.setBounds(150,100,300,30);
add( JtxtFrecuenciaDeRelog);
JtxtFrecuenciaDeRelog.addKeyListener(new KeyAdapter() {
    public void keyReleased(KeyEvent e) {
    	
    	char validar= e.getKeyChar();
		if (Character.isLetter(validar)){
			JOptionPane.showMessageDialog(rootPane, "Ingrese Solo Numeros");
			JtxtFrecuenciaDeRelog.setText(null);
			getToolkit().beep();
			e.consume();
			
    }   }}
);
		
		
JlbConjuntodeInstrucciones= new JLabel("Conjunto de Instrucciones:");	
JlbConjuntodeInstrucciones.setBounds(30,150,80, 50);
add(JlbConjuntodeInstrucciones);
		

		
JTxtConjuntodeInstrucciones= new JTextField();
JTxtConjuntodeInstrucciones.setBounds(150,150,300,30);
add(JTxtConjuntodeInstrucciones);



JLabelCache= new JLabel("Cache:");	
JLabelCache.setBounds(30,200,50, 50);
add(JLabelCache);

JtxtCache= new JTextField();
JtxtCache.setBounds(150,200, 150, 30);
add(JtxtCache);
JtxtCache.addKeyListener(new KeyAdapter() {
    public void keyReleased(KeyEvent e) {
    	
    	char validar= e.getKeyChar();
		if (Character.isLetter(validar)){
			JOptionPane.showMessageDialog(rootPane, "Ingrese Solo Numeros");
			JtxtCache.setText(null);
			getToolkit().beep();
			e.consume();
			
    }   }}
);



JbtnCancelar= new JButton("CANCELAR");
JbtnCancelar.setActionCommand(CALCULATE);
JbtnCancelar.addActionListener(actionsButtons2);
JbtnCancelar.setBounds(110,250, 150, 30);
add(JbtnCancelar);
		
		
		

JbtnGuardar= new JButton("GUARDAR");
JbtnGuardar.setActionCommand(CALCULATE);
JbtnGuardar.addActionListener(actionsButtons1);
JbtnGuardar.setBounds(360,250, 150, 30);
add(JbtnGuardar);
		
	 }

	
	public void paint (Graphics g){
       super.paint(g);
       g.drawLine (0, 360, 600, 360);
//
   }
	
	/**
	 * 
	 * 1º
	 */
	
	public void SaveObjectProcesador(){
		this.cache=Integer.parseInt(JtxtCache.getText());
		this. frecuencia=Integer.parseInt(JtxtFrecuenciaDeRelog.getText());
		this. nucleos=Integer.parseInt(JtxtNumeroNucleos.getText());
        this.Marca=JtxtMarca.getText();
        this.ConjuntoInstrucciones=JTxtConjuntodeInstrucciones.getText();
        managerFiles.setParametro(NombreArchivoPro);
		procesador = new Logica.Procesador(JtxtMarca.getText(), cache, frecuencia, nucleos, JTxtConjuntodeInstrucciones.getText());
		
		//managerFiles= new ManagerFiles(NombreArchivoPro);
		System.out.println("el parametro actual es"+managerFiles.getParametro());
		System.out.println(Integer.toString(cont));
		try {
			managerFiles.SaveProcesador(procesador,cont);
			cont++;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JtxtMarca.setText(null);
		JtxtCache.setText(null);
		JtxtFrecuenciaDeRelog.setText(null);
	    JtxtNumeroNucleos.setText(null);
		JTxtConjuntodeInstrucciones.setText(null);
		
	}
		//
				
				


		
			
	

	
ActionListener actionsButtons1 = new ActionListener() {		
		public void actionPerformed(ActionEvent a) {
			if(a.getActionCommand().equals(CALCULATE)){
			System.out.println("Nuevo");
			setVisible(false);
			SaveObjectProcesador();
			
			
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
	mainwindow.setVisible(true);
setVisible(false);


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
		mainwindow= new MainWindow(NombreArchivoPro,NombreArchivoPro,managerFiles);
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


	public JButton getJbtnGuardar() {
		return JbtnGuardar;
	}


	public void setJbtnGuardar(JButton jbtnGuardar) {
		JbtnGuardar = jbtnGuardar;
	}


	public JComboBox getCombobox() {
		return combobox;
	}


	public void setCombobox(JComboBox combobox) {
		this.combobox = combobox;
	}


	public JLabel getJlbMarca() {
		return JlbMarca;
	}


	public void setJlbMarca(JLabel jlbMarca) {
		JlbMarca = jlbMarca;
	}


	public JLabel getJlbFrecuenciadeReloj() {
		return JlbFrecuenciadeReloj;
	}


	public void setJlbFrecuenciadeReloj(JLabel jlbFrecuenciadeReloj) {
		JlbFrecuenciadeReloj = jlbFrecuenciadeReloj;
	}


	public JLabel getJlbConjuntodeInstrucciones() {
		return JlbConjuntodeInstrucciones;
	}


	public void setJlbConjuntodeInstrucciones(JLabel jlbConjuntodeInstrucciones) {
		JlbConjuntodeInstrucciones = jlbConjuntodeInstrucciones;
	}


	public JLabel getJlbNumeroNucleos() {
		return JlbNumeroNucleos;
	}


	public void setJlbNumeroNucleos(JLabel jlbNumeroNucleos) {
		JlbNumeroNucleos = jlbNumeroNucleos;
	}


	public JLabel getJLabelCache() {
		return JLabelCache;
	}


	public void setJLabelCache(JLabel jLabelCache) {
		JLabelCache = jLabelCache;
	}


	public void finalize() throws Throwable {

	}


	public JTextField getJtxtCache() {
		return JtxtCache;
	}


	public void setJtxtCache(JTextField jtxtCache) {
		JtxtCache = jtxtCache;
	}


	public JTextField getJTxtConjuntodeInstrucciones() {
		return JTxtConjuntodeInstrucciones;
	}


	public void setJTxtConjuntodeInstrucciones(
			JTextField jTxtConjuntodeInstrucciones) {
		JTxtConjuntodeInstrucciones = jTxtConjuntodeInstrucciones;
	}


	public JTextField getJtxtFrecuenciaDeRelog() {
		return JtxtFrecuenciaDeRelog;
	}


	public void setJtxtFrecuenciaDeRelog(JTextField jtxtFrecuenciaDeRelog) {
		JtxtFrecuenciaDeRelog = jtxtFrecuenciaDeRelog;
	}


	public JTextField getJtxtMarca() {
		return JtxtMarca;
	}


	public void setJtxtMarca(JTextField jtxtMarca) {
		JtxtMarca = jtxtMarca;
	}


	public JTextField getJtxtNumeroNucleos() {
		return JtxtNumeroNucleos;
	}


	public void setJtxtNumeroNucleos(JTextField jtxtNumeroNucleos) {
		JtxtNumeroNucleos = jtxtNumeroNucleos;
	}


	public ManagerFiles getManagerFiles() {
		return managerFiles;
	}


	public void setManagerFiles(ManagerFiles managerFiles) {
		this.managerFiles = managerFiles;
	}
	
	
}//end Procesadores