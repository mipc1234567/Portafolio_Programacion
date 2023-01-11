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
	
	 JComboBox comboFuentes,comboTama�o;
	 String nombreFuentes[],tama�os[];
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
	    texto.setFont(new Font(""+comboFuentes.getItemAt(comboFuentes.getSelectedIndex()),Font.PLAIN,Integer.parseInt(tama�os[comboTama�o.getSelectedIndex()])));
	   }
	   
	  });
	  
	  tama�os=new String[26];
	  
	  for(int i=4;i<30;i++){
	   tama�os[i-4]=""+(i+1);
	  }
	  comboTama�o=new JComboBox(tama�os);
	  comboTama�o.addItemListener(new ItemListener(){


	   @Override
	   public void itemStateChanged(ItemEvent e) {
	    texto.setFont(new Font(""+comboFuentes.getItemAt(comboFuentes.getSelectedIndex()),Font.PLAIN,Integer.parseInt(tama�os[comboTama�o.getSelectedIndex()])));
	   }
	   
	  });
	  
	  pabajo.add(comboFuentes);
	  pabajo.add(comboTama�o);
	  
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


