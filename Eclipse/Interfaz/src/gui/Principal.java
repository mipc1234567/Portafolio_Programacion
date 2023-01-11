package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;


	public class Principal extends JFrame {
		
		
		public Principal(){
			 super();
			 init();
		}
	
	 JComboBox comboFuentes,comboTamaño;
	 String nombreFuentes[],tamaños[];
	 JLabel texto;
	 
	 public void init(){

	  setSize(300, 200);
	
	  JPanel pabajo=new JPanel();
	  nombreFuentes=Toolkit.getDefaultToolkit().getFontList();
	  comboFuentes=new JComboBox(nombreFuentes);
	  comboFuentes.addItem("Arial");
	  comboFuentes.addItem("Verdana");
	  this.add(pabajo);
	  comboFuentes.addItemListener(new ItemListener(){
		  

	   @Override
	   public void itemStateChanged(ItemEvent e) {
	    texto.setFont(new Font(""+comboFuentes.getItemAt(comboFuentes.getSelectedIndex()),Font.PLAIN,Integer.parseInt(tamaños[comboTamaño.getSelectedIndex()])));
	   }
	   
	  });
	  
	  tamaños=new String[26];
	  
	  for(int i=4;i<30;i++){
	   tamaños[i-4]=""+(i+1);
	  }
	  comboTamaño=new JComboBox(tamaños);
	  comboTamaño.addItemListener(new ItemListener(){


	   @Override
	   public void itemStateChanged(ItemEvent e) {
	    texto.setFont(new Font(""+comboFuentes.getItemAt(comboFuentes.getSelectedIndex()),Font.PLAIN,Integer.parseInt(tamaños[comboTamaño.getSelectedIndex()])));
	   }
	   
	  });
	  
	  pabajo.add(comboFuentes);
	  pabajo.add(comboTamaño);
	  
	  texto=new JLabel("Java Zone");
	  JPanel pcentro=new JPanel();
	  pcentro.add(texto);
	  
	  add(pcentro);
	  add(pabajo,BorderLayout.SOUTH);
	  
	  JMenuBar barra=new JMenuBar();
	  JMenu archivo=new JMenu("Archivo");
	  JMenuItem agregarFuente=new JMenuItem("AgregarFuente");
	  agregarFuente.addActionListener(new ActionListener(){


	   @Override
	   public void actionPerformed(ActionEvent e) {
	    String nuevaFuente=JOptionPane.showInputDialog("Digite el Nombre de la Fuente a Agregar.");
	    comboFuentes.addItem(""+nuevaFuente);
	    repaint();
	   }
	   
	  });
	  archivo.add(agregarFuente);
	  barra.add(archivo);
	 /* setJMenuBar(barra);*/
	  
	 }
	}


