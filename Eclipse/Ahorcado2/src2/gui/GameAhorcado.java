package gui;

import gui.PanelGame;
import internacionalizacion.ParametrosGenerales;






import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import logica.LogicaWords;

/**
 * @author Mateo Ivan Peña C
 * @version 1.0
 * @Place Universidad Pedagogica y Tecnologica de Colombia
 * Juego Ahorcado
 */
public class GameAhorcado extends JFrame implements ActionListener {

	/**
	 * Atributos de la ventana
	 *
	 */
	private JPanel jContentPane= null;
	private PanelGame panel;
	private JButton buttonAceptar;
	private JButton buttonCancelar;
	private JPanel panelimagenes;
	private String[] nombres={"Ahorcado 1","Ahorcado 2","Ahorcado 3","Ahorcado 4","Ahorcado 5,Ahorcado 6,Ahorcado 7, Ahorcado 8"};
	private JMenuBar menubar;
	private JMenuItem menuitem1;
	private JMenuItem menuitem2;
	private JMenuItem menuitem6;
	private JMenuItem menuItem8;
	private JMenuItem restart;
	private JMenu menuArchivo;
	private JMenu menuAcerca;
	private JMenu crear;
	static final String CALCULATE= "calculate";	
	private static Locale locale;
	private ParametrosGenerales parametrosgenerales;
	private int intetos;
	private LogicaWords logicawords;
	private FrameScore frameScore;


	/**
	 * Contructor de la clase que inicializa  mientras se configura la aplicion
	 */
	public GameAhorcado(){
		setSize(800, 600);
		setTitle("Juego Ahorcado");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		this.setLocationRelativeTo(null);
		this.barra_de_tareas();

		panel= new PanelGame();
		this.intetos=panel.getIntentos();
		buttonAceptar= new JButton("ACEPTAR");
		buttonAceptar.setActionCommand(CALCULATE);
		buttonAceptar.addActionListener(actionsButtons1);
		this.add(this.buttonAceptar);


		buttonCancelar= new JButton("CANCELAR");
		buttonCancelar.setActionCommand(CALCULATE);
		buttonCancelar.addActionListener(actionsButtons2);
		this.add(this.buttonCancelar);

		JPanel PanelBotones= new JPanel();
		PanelBotones.add(buttonAceptar);
		PanelBotones.add(buttonCancelar);
		add(panel,BorderLayout.CENTER);
		add(PanelBotones,BorderLayout.SOUTH);

	}
	/**
	 * Contructor del panel del juego clase que carga la logica del Juego
	 * confiugrada en los paramentros generales 
	 * @param panel
	 */
	public GameAhorcado(PanelGame panel){
		this.panel=panel;
		setSize(800, 600);
		setTitle("Juego Ahorcado");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		this.setLocationRelativeTo(null);
		this.intetos=panel.getIntentos();
		this.barra_de_tareas();

		buttonAceptar= new JButton("ACEPTAR");
		buttonAceptar.setActionCommand(CALCULATE);
		buttonAceptar.addActionListener(actionsButtons1);
		this.add(this.buttonAceptar);

		buttonCancelar= new JButton("CANCELAR");
		buttonCancelar.setActionCommand(CALCULATE);
		buttonCancelar.addActionListener(actionsButtons2);
		this.add(this.buttonCancelar);

		JPanel PanelBotones= new JPanel();
		PanelBotones.add(buttonAceptar);
		PanelBotones.add(buttonCancelar);

		add(panel,BorderLayout.CENTER);
		add(PanelBotones,BorderLayout.SOUTH);
	}

	/**
	 * metodo que carga los componentes de la ventana
	 */
	public void barra_de_tareas(){
		setTitle( "Juego Ahorcado" );
		menubar= new JMenuBar();
		menuArchivo=new JMenu("Archivo");
		menuArchivo.setMnemonic('A');
		menubar.add(menuArchivo);

		restart = menuArchivo.add(new JMenuItem("Reiniciar", 'R'));
		restart.setActionCommand(CALCULATE);
		restart.addActionListener(this);


		menuitem1= menuArchivo.add(new JMenuItem("Iniciar", 'I'));
		menuitem1.setActionCommand(CALCULATE);
		menuitem1.addActionListener(actionsButtons2);


		crear = new JMenu("Archivo");
		menuitem6= crear.add(new JMenuItem("Personas", 'e'));
		menuitem6.setActionCommand(CALCULATE);


		menuitem2= new JMenuItem("Salir");
		menuitem2.setMnemonic('S');

		menuArchivo.add(crear);	
		menuArchivo.add(menuitem2);
		menuitem2.addActionListener(new ActionListener(){


			public void actionPerformed(ActionEvent e){
				System.out.println("Exit performed");
				System.exit(0);
			}
		});

		menuItem8= new JMenuItem("Informacion");
		menuAcerca = new JMenu("Acerca de");
		menuItem8.setActionCommand(CALCULATE);
		menuItem8.addActionListener(actionsButtons3);
		menuAcerca.add( menuItem8);
		menubar.add(menuAcerca);
		setJMenuBar(menubar);
		pack();
		getContentPane( ).setLayout( new BorderLayout( ) );
		setSize(800, 600 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

	/**
	 * metodo que carga la logica a la clase y agrega el panel a la ventna
	 * @param logica
	 */
	public void initializce(LogicaWords logica){
		panel= new PanelGame(logica);
		this.add(panel,BorderLayout.CENTER);
	}

	/**
	 * Metodo que permite validar la funcion aceptar 
	 * @deprecated
	 */
	ActionListener actionsButtons1 = new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent a) {
			if(a.getActionCommand().equals(CALCULATE)){
				System.out.println("funciona");

			}
		}
	};


	/**
	 * * Metodo que permite validar la funcion cancelar 
	 * @deprecated
	 */
	ActionListener actionsButtons2 = new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent a) {
			if(a.getActionCommand().equals(CALCULATE)){
				System.out.println("funciona");
				//initializce(logicawords);
			}
		}
	};

	/**
	 * Metodo que permite validar la funcion de mostrar imagenes 
	 * * @deprecated
	 * @param c
	 */
	public void actionPerformed11(ActionEvent c ) {
		if(c.getActionCommand().equals(CALCULATE)){
			System.out.println("funciona");

		}
	}
	/**
	 * Accion que permite inicializar la grabacion de los datos en el archivo
	 */
	ActionListener actionsButtons3 = new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent a) {
			if(a.getActionCommand().equals(CALCULATE)){
				frameScore= new FrameScore();
				String parcial;
				String[] total = new String[(int)panel.getScore().sizerecord()];
				if (panel.isControlScore()){
					System.out.println("si es verdadero");
					panel.getScore().open();
					total=panel.getScore().ReadToCharge();
					frameScore.Actualiza(total);
					panel.getScore().close();

				}else{
					panel.getScore().open();
					total=panel.getScore().ReadToCharge();

					for (int i = 0; i < panel.getScore().sizerecord(); i++) {
						i=42*i;
						parcial =panel.getScore().ReadToCharge2(i);
					}	
				}
				frameScore.Actualiza(total);
				panel.getScore().close();
				frameScore.setVisible(true);
			}
		}
	};

	/**
	 * Accion que permite reiniciar la apliacion e iniciar un nuevo juego
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		parametrosgenerales= new ParametrosGenerales();
		parametrosgenerales.setVisible(true);
	}


	/**
	 * los--------------- GET Y LOS SET--------------------
	 * 
	 */

	public JPanel getjContentPane() {
		return jContentPane;
	}

	public void setjContentPane(JPanel jContentPane) {
		this.jContentPane = jContentPane;
	}

	public PanelGame getPanel() {
		return panel;
	}

	public void setPanel(PanelGame panel) {
		this.panel = panel;
	}

	public JButton getButtonAceptar() {
		return buttonAceptar;
	}

	public void setButtonAceptar(JButton buttonAceptar) {
		this.buttonAceptar = buttonAceptar;
	}

	public JButton getButtonCancelar() {
		return buttonCancelar;
	}

	public void setButtonCancelar(JButton buttonCancelar) {
		this.buttonCancelar = buttonCancelar;
	}

	public JPanel getPanelimagenes() {
		return panelimagenes;
	}

	public void setPanelimagenes(JPanel panelimagenes) {
		this.panelimagenes = panelimagenes;
	}

	public String[] getNombres() {
		return nombres;
	}

	public void setNombres(String[] nombres) {
		this.nombres = nombres;
	}



	public JMenuBar getMenubar() {
		return menubar;
	}

	public void setMenubar(JMenuBar menubar) {
		this.menubar = menubar;
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

	public JMenuItem getMenuitem6() {
		return menuitem6;
	}

	public void setMenuitem6(JMenuItem menuitem6) {
		this.menuitem6 = menuitem6;
	}

	public JMenuItem getRestart() {
		return restart;
	}
	public void setRestart(JMenuItem restart) {
		this.restart = restart;
	}
	public JMenu getMenuArchivo() {
		return menuArchivo;
	}

	public void setMenuArchivo(JMenu menuArchivo) {
		this.menuArchivo = menuArchivo;
	}

	public JMenu getMenuAcerca() {
		return menuAcerca;
	}

	public void setMenuAcerca(JMenu menuAcerca) {
		this.menuAcerca = menuAcerca;
	}

	public JMenu getCrear() {
		return crear;

	}


	public JMenuItem getMenuItem8() {
		return menuItem8;
	}
	public void setMenuItem8(JMenuItem menuItem8) {
		this.menuItem8 = menuItem8;
	}
	public void setCrear(JMenu crear) {
		this.crear = crear;
	}

	public ParametrosGenerales getParametrosgenerales() {
		return parametrosgenerales;
	}

	public void setParametrosgenerales(ParametrosGenerales parametrosgenerales) {
		parametrosgenerales = parametrosgenerales;
	}

	public ActionListener getActionsButtons1() {
		return actionsButtons1;
	}

	public void setActionsButtons1(ActionListener actionsButtons1) {
		this.actionsButtons1 = actionsButtons1;
	}

	public ActionListener getActionsButtons2() {
		return actionsButtons2;
	}

	public void setActionsButtons2(ActionListener actionsButtons2) {
		this.actionsButtons2 = actionsButtons2;
	}

	public int getIntetos() {
		return intetos;
	}
	public void setIntetos(int intetos) {
		this.intetos = intetos;
	}




}

