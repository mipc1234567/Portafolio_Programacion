package internacionalizacion;

import gui.GameAhorcado;
import gui.PanelGame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

/**
 * @author Mateo Ivan Peña C
 * @version 1.0
 * @Place Universidad Pedagogica y Tecnologica de Colombia
 * juego ahorcado
 */


	public class Fonts extends JFrame implements ActionListener {
		
	
		private JButton bottonaplicar;
		private JButton bottoncancelar;
		private JButton bottonaceptar;
		private final static String CALCULATE="Calculate";
		private GameAhorcado Panelgame;    
		private int control;
		private Font font;
		    
		/**
		 * Clase quer permite configurar la fuente y el tamaño de letra de la apliacion
		 * @param panel
		 */
		public Fonts(GameAhorcado panel){
			 super();
			 init();
		this.Panelgame=panel;     
		        
		}
	
	 JComboBox comboFuentes,comboTamaño;
	 String nombreFuentes[],tamaños[];
	 JLabel texto;
	 /**
	  * inicializa los componentes
	  */
	 public void init(){
		 setSize(300, 200);
		 bottonaplicar= new JButton("Aplicar");
	        bottonaplicar.setActionCommand("CALCULATE");
	        bottonaplicar.addActionListener(actionsButtons1); 
	        
	        bottonaceptar= new JButton("Aceptar");
	        bottonaceptar.setActionCommand(CALCULATE);
	        bottonaceptar.addActionListener(actionsButtons2);
	     
	  
	        bottoncancelar= new JButton("Cancelar");
	        bottoncancelar.setActionCommand(CALCULATE);
	       bottoncancelar.addActionListener(actionsButtons3);
	
	        JPanel panelBotones= new JPanel();
	        panelBotones.add(bottonaplicar);
	        panelBotones.add(bottoncancelar);
	        panelBotones.add(bottonaceptar);    

			 
	  JPanel pabajo=new JPanel();
	  nombreFuentes=Toolkit.getDefaultToolkit().getFontList();
	  comboFuentes=new JComboBox(nombreFuentes);
	  comboFuentes.addItem("Arial");
	  comboFuentes.addItem("Verdana");
	  comboFuentes.addItem("Calibri");
	  comboFuentes.addItemListener(new ItemListener(){
	   /**
	    * permite escuhar los componentes graficos y realiza los cambios correspondiente de fuentes
	    */
		  @Override
	   public void itemStateChanged(ItemEvent e) {
		font= new Font(""+comboFuentes.getItemAt(comboFuentes.getSelectedIndex()),Font.PLAIN,Integer.parseInt(tamaños[comboTamaño.getSelectedIndex()]));
		   texto.setFont(font);
		   System.out.println(font.getSize());
			  System.out.println(font.getName());
	  if(comboFuentes.getItemAt(comboFuentes.getSelectedIndex()).equals("Arial")){
		  control=0;
		  System.out.println(control);
	  }else{
		  if(comboFuentes.getItemAt(comboFuentes.getSelectedIndex()).equals("Calibri")){
			  
			  control=1;
			  System.out.println(control);
		  }else{
			  if(comboFuentes.getItemAt(comboFuentes.getSelectedIndex()).equals("Verdana")){
				  control=2;
				  System.out.println(control);
		  }
	  }
	    	
	   }
	  try {
		ChangeFont();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
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
	    font= new Font(""+comboFuentes.getItemAt(comboFuentes.getSelectedIndex()),Font.PLAIN,Integer.parseInt(tamaños[comboTamaño.getSelectedIndex()]));
	  System.out.println(font.getSize());
	  System.out.println(font.getName());
	  try {
		ChangeFont();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	   
	   }
	   
	  });
	  
	  pabajo.add(comboFuentes);
	  pabajo.add(comboTamaño);
	  
	  texto=new JLabel("Tipo letra");
	  JPanel pcentro=new JPanel();
	  pcentro.add(texto);
	  
	  add(pcentro,BorderLayout.NORTH);
	  add(pabajo,BorderLayout.CENTER);
	  add(panelBotones, BorderLayout.SOUTH);
	  
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
	  setJMenuBar(barra);
	  
	 }
	 
	 
	 public void ChangeFont() throws IOException{
			
			this.Panelgame.setTitle(Global.language.getString("1"));
			this.Panelgame.getButtonAceptar().setFont(font);
			this.Panelgame.getButtonCancelar().setFont(font);
			this.Panelgame.getMenuAcerca().setFont(font);
			
			this.Panelgame.getPanel().getJbtnSALIR().setFont(font);
			this.Panelgame.getPanel().getJbtnValidar().setFont(font);
			this.Panelgame.getPanel().getJlabelINTENTOS().setFont(font);
				this.Panelgame.getPanel().getJlblpalabra().setFont(font);;
			
			this.Panelgame.getPanel().getJlblValidation().setFont(font);
			this.Panelgame.getPanel().getJtxtLETTER().setFont(font);
			this.Panelgame.getPanel().getJtxtWORD().setFont(font);
			
			this.Panelgame.getMenuArchivo().setFont(font);
			this.Panelgame.getMenuitem1().setFont(font);
			this.Panelgame.getMenuitem2().setFont(font);
			this.Panelgame.getMenuitem6().setFont(font);
			this.Panelgame.getMenuItem8().setFont(font);
			this.Panelgame.getMenuAcerca().setFont(font);
			this.Panelgame.getCrear().setFont(font);		
		}
	 
	 /**
	  * acciones de los botones segun el nombre de su tarea para las fuentes
	  */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 
	 * 1º
	 */
	
ActionListener actionsButtons1 = new ActionListener() {		
		public void actionPerformed(ActionEvent a) {
			if(a.getActionCommand().equals(CALCULATE)){
				System.out.println("funciona2");
				try {
					ChangeFont();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e);
				}
				}
			setVisible(false);
					}
		};


		/**
		 * 2º 
		 */
	ActionListener actionsButtons2 = new ActionListener() {		
	public void actionPerformed(ActionEvent a) {
		if(a.getActionCommand().equals(CALCULATE)){
			System.out.println("funciona2");
			try {
				ChangeFont();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
			}
			}
		setVisible(false);
	}
	
	};

	public void actionPerformed11(ActionEvent c ) {

	}
	/**
	 * 2º 
	 */
ActionListener actionsButtons3 = new ActionListener() {		
public void actionPerformed(ActionEvent a) {
if(a.getActionCommand().equals(CALCULATE)){
		System.out.println("funciona3");
		
		setVisible(false); 
}
}
};

/**
 * ----------------- LOS GET Y LOS SET------------------
 * @return
 */
	public JButton getBottonaplicar() {
		return bottonaplicar;
	}


	public void setBottonaplicar(JButton bottonaplicar) {
		this.bottonaplicar = bottonaplicar;
	}


	public JButton getBottoncancelar() {
		return bottoncancelar;
	}


	public void setBottoncancelar(JButton bottoncancelar) {
		this.bottoncancelar = bottoncancelar;
	}


	public JButton getBottonaceptar() {
		return bottonaceptar;
	}


	public void setBottonaceptar(JButton bottonaceptar) {
		this.bottonaceptar = bottonaceptar;
	}


	public GameAhorcado getPanelgame() {
		return Panelgame;
	}


	public void setPanelgame(GameAhorcado panelgame) {
		Panelgame = panelgame;
	}


	public int getControl() {
		return control;
	}


	public void setControl(int control) {
		this.control = control;
	}


	public Font getFont() {
		return font;
	}


	public void setFont(Font font) {
		this.font = font;
	}


	public JComboBox getComboFuentes() {
		return comboFuentes;
	}


	public void setComboFuentes(JComboBox comboFuentes) {
		this.comboFuentes = comboFuentes;
	}


	public JComboBox getComboTamaño() {
		return comboTamaño;
	}


	public void setComboTamaño(JComboBox comboTamaño) {
		this.comboTamaño = comboTamaño;
	}


	public static String getCalculate() {
		return CALCULATE;
	}
	


	}
	
	


