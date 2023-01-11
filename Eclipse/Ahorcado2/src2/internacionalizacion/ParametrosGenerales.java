package internacionalizacion;
import enu.FormOpenFile;
import gui.GameAhorcado;
import gui.PanelGame;

import java.awt.Color;


import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import persistence.Score;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import logica.LogicaGame;
import logica.LogicaWords;


/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ 
 * Uptc(Boyaca - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Ahocado
 * Ejercicio: Parametros Generales 
 * Autor: Mateo Peña c
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
public class ParametrosGenerales extends JFrame {


	private static final String CALCULATE= "calculate";	
	/**
	 * 
	 */
	private JLabel idioma;

	/**
	 * permite guardar la informacion por defecto
	 */
	private JButton JButtonGuardar;

	/**
	 * permite configurar los valores los idiomas
	 *  
	 */
	private JComboBox<String> combobox;

	/**
	 * llamar la clase cambio y cofiguraciones de parametros e interfaz
	 */

	private PanelGame game;
	private int cont=0;
	private LogicaWords logicaWords;
	private LogicaGame logicaGame;
	private Global global;
	private ManagerLanguage managerlanguage;
	private GameAhorcado gameAhorcado;
	private PanelToolbar panelToolbar;
	private JTextField usuario;
	private JDateChooser JlbdateChooser;
	private JLabel nombreUsuario;
	private JLabel fecha;
	private int user;
	private JLabel Levels;
	private JComboBox comboLevel;
	private int level;
	private Score score;
	private static final String FILE_NAME="src\\ahorcado.bin";
	private Fonts fonts;

	private ColorChooserDemo colorChooser;
	
	//-------------------Constructor de la clase----------------

	
	public ParametrosGenerales(){	
		setSize(500,290);
		setTitle("Administador de lenguaje");
		setLayout(null);
		setResizable(false);
		this.setLocationRelativeTo(null);
		score= new Score(FILE_NAME,FormOpenFile.READ);
		idioma=new JLabel("Idioma:");
		idioma.setBounds(30, 20, 150, 30);
		add(idioma);
		combobox = new JComboBox();
		combobox.setBounds(220,20,250, 30);
		combobox.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		combobox.setActionCommand(CALCULATE);
		combobox.addItem("Español");
		combobox.addItem("Ingles");
		combobox.addItem("Portuges");
		combobox.addItem("Frances");
		combobox.addItem("Aleman");
		combobox.addActionListener(actionsCombo2);
		add(combobox);
		JButtonGuardar= new JButton("GUARDAR");
		JButtonGuardar.setActionCommand(CALCULATE);
		JButtonGuardar.addActionListener(actionsButtons1);
		JButtonGuardar.setBounds(150, 170, 150, 30);
		add(JButtonGuardar);
		JlbdateChooser= new JDateChooser();
		JlbdateChooser.setBounds(320,60, 150, 20);
		JlbdateChooser.addAncestorListener(actionsButtons);
		add(JlbdateChooser);


		nombreUsuario= new JLabel("Nombre de usuario");
		nombreUsuario.setBounds(30, 90, 150, 20);
		add(nombreUsuario);

		fecha= new JLabel("Fecha de nacimiento:");
		fecha.setBounds(30,60,150,20);
		add(fecha);

		usuario= new JTextField();
		usuario.setBounds(320, 90, 150, 20);
		this.add(usuario);


		Levels = new JLabel("Escoja Nivel:");
		Levels.setBounds(30, 120, 120, 20);
		this.add(Levels);

		comboLevel = new JComboBox();
		comboLevel.setBounds(320,120,100,30);
		comboLevel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		comboLevel.setActionCommand(CALCULATE);
		comboLevel.addItem("Principiante");
		comboLevel.addItem("Intermedio");
		comboLevel.addItem("Experto");
		comboLevel.addActionListener(actionsCombo3);
		add(comboLevel);

	}

//-------------------LAS ACCIONES DEL LA CLASE-----------------//	
	
	
	ActionListener actionsCombo2 = new ActionListener() {		
		public void actionPerformed(ActionEvent a) {	
			switch (combobox.getSelectedItem().toString()) {
			case "Español":
				System.out.println("ESPAÑOL");
				cont=0;
				System.out.println(cont);
				break;
			case "Ingles":
				System.out.println("INGLES");
				cont=1;
				System.out.println(cont);
				break;

			case "Portuges":
				System.out.println("PORTUGES");
				cont=2;
				System.out.println(cont);
				break;

			case "Frances":
				System.out.println("FRANCES");
				cont=3;
				System.out.println(cont);
				break;

			case "Aleman":
				System.out.println("ALEMAN");
				cont=4;
				System.out.println(cont);
				break;
			default:
				break;
			}

		};
	};

	ActionListener actionsCombo3 = new ActionListener() {		
		public void actionPerformed(ActionEvent a) {	
			switch (comboLevel.getSelectedItem().toString()) {
			case "Principiante":
				System.out.println("principinate");
				level=5;
				System.out.println(level);
				break;
			case "Intermedio":
				System.out.println("intermedio");
				level=4;
				System.out.println(level);
				break;
			case "Experto":
				System.out.println("expero");
				level=3;
				System.out.println(level);
				break;


			default:
				break;
			}

		};
	};
	


	ActionListener actionsButtons1 = new ActionListener() {		
		public void actionPerformed(ActionEvent a) {
			if(a.getActionCommand().equals(CALCULATE)){
				System.out.println(cont);
				logicaWords= new LogicaWords();
				String aux[]= new String[100];
				switch (cont) {
				case 0:
					if (validat()){
						System.out.println("si entro aqui en lenguajes");
						global= new Global();
						game= new PanelGame();
						gameAhorcado= new GameAhorcado(game);
						colorChooser= new ColorChooserDemo(gameAhorcado);
						fonts= new Fonts(gameAhorcado);
						panelToolbar= new PanelToolbar(game,gameAhorcado,fonts,colorChooser);
						panelToolbar.setBounds(500,20, 200 ,200);
						game.add(panelToolbar);
					
						managerlanguage= new ManagerLanguage(gameAhorcado, global);
						managerlanguage.changeLeng(cont);
						aux=managerlanguage.change_words();
						logicaWords.chargeWords(aux);
						logicaWords.initialisaze();
						setVisible(false);
						initializace();
					}
					break;


				case 1:
					System.out.println("si entro aqui en lenguajes");
					global= new Global();
					game= new PanelGame();
					gameAhorcado= new GameAhorcado(game);
					fonts= new Fonts(gameAhorcado);
					colorChooser= new ColorChooserDemo(gameAhorcado);
					panelToolbar= new PanelToolbar(game,gameAhorcado,fonts,colorChooser);
					panelToolbar.setBounds(500,20, 200 ,200);
					game.add(panelToolbar);
					managerlanguage= new ManagerLanguage(gameAhorcado, global);
					managerlanguage.changeLeng(cont);
					aux=managerlanguage.change_words();
					logicaWords.chargeWords(aux);
					logicaWords.initialisaze();
					setVisible(false);
					initializace();
					break;


				case 2:
					System.out.println("si entro aqui en lenguajes");
					global= new Global();
					game= new PanelGame();
					gameAhorcado= new GameAhorcado(game);
					colorChooser= new ColorChooserDemo(gameAhorcado);
					fonts= new Fonts(gameAhorcado);
					panelToolbar= new PanelToolbar(game,gameAhorcado,fonts,colorChooser);
					panelToolbar.setBounds(500,20, 200 ,200);
					game.add(panelToolbar);
					
					managerlanguage= new ManagerLanguage(gameAhorcado, global);
					managerlanguage.changeLeng(cont);
					aux=managerlanguage.change_words();
					logicaWords.chargeWords(aux);
					logicaWords.initialisaze();
					setVisible(false);
					initializace();
					break;


				case 3:
					System.out.println("si entro aqui en lenguajes");
					global= new Global();
					game= new PanelGame();
					gameAhorcado= new GameAhorcado(game);
					colorChooser= new ColorChooserDemo(gameAhorcado);
					fonts= new Fonts(gameAhorcado);
					panelToolbar= new PanelToolbar(game,gameAhorcado,fonts,colorChooser);
					panelToolbar.setBounds(500,20, 200 ,200);
					game.add(panelToolbar);
				
					managerlanguage= new ManagerLanguage(gameAhorcado, global);
					managerlanguage.changeLeng(cont);
					aux=managerlanguage.change_words();
					logicaWords.chargeWords(aux);
					logicaWords.initialisaze();
					setVisible(false);
					initializace();
					break;

				case 4:

					System.out.println("si entro aqui en lenguajes");
					global= new Global();
					PanelGame game= new PanelGame();
					gameAhorcado= new GameAhorcado(game);
					fonts= new Fonts(gameAhorcado);
					colorChooser= new ColorChooserDemo(gameAhorcado);
					panelToolbar= new PanelToolbar(game,gameAhorcado,fonts,colorChooser);
					panelToolbar.setBounds(500,20, 200 ,200);
					game.add(panelToolbar);
					
					managerlanguage= new ManagerLanguage(gameAhorcado, global);
					managerlanguage.changeLeng(cont);
					aux=managerlanguage.change_words();
					logicaWords.chargeWords(aux);
					logicaWords.initialisaze();
					setVisible(false);
					initializace();
					break;
				default:
					break;
				}
			};
		}
	};

	AncestorListener actionsButtons = new AncestorListener() {		
		public void actionPerformed(ActionEvent a) {	
			System.out.println("sI PASO 1");
		}

		@Override
		public void ancestorAdded(AncestorEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("sI PASO AGREGADO");
		}

		@Override
		public void ancestorMoved(AncestorEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("sI PASO MOVED");
		}

		@Override
		public void ancestorRemoved(AncestorEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("sI PASO REMOVED");
		};

	};

//-------------------METODOS DE LA CLASE--------------------------
	
	public void initializace(){
		int pos;
		int value;
		score.open();
		if (this.verificate()){
			System.out.println("si paso cero");
		pos=0;
		value=0;
		user=0;
		}else{
			System.out.println("el registro no es cero  cumple");
			score.ChargeRegitry();
			System.out.println("tamaño del array");
			System.out.println(score.getArrayLogicaWords().size());
			System.out.println("valor de la ultima poscion");
			System.out.println(score.getArrayLogicaWords().get(score.getArrayLogicaWords().size()-1).getIdentificador());
			
			pos=score.getArrayLogicaWords().size();
			System.out.println(pos);
			value=score.getArrayLogicaWords().get(pos-1).getIdentificador();
			user=value+1;
			System.out.println("VALOR DEL USUARIO");
			System.out.println(user);
			
		}
		System.out.println("cantidad de registros iniciakes");
		//System.out.println(score.getArrayLogicaWords().size());
	 
		System.out.println("valores para inicializar");
		
		
		System.out.println(user);
		System.out.printf(usuario.getText());
		System.out.println(JlbdateChooser.getDate().toString());
		System.out.println(game.getTruths());
		System.out.println(level);
		score.close();
		logicaWords= new LogicaWords(user, usuario.getText(),JlbdateChooser.getDate().toString(),game.getTruths(),level);
		String aux[]= new String[100];
		aux=managerlanguage.change_words();
		logicaWords.chargeWords(aux);
		logicaWords.initialisaze();
		PanelGame game= new PanelGame(logicaWords);
		game.setIntentos(calculaNivel());
		//String aux[]= new String[100];
		gameAhorcado= new GameAhorcado(game);
		fonts= new Fonts(gameAhorcado);
		colorChooser= new ColorChooserDemo(gameAhorcado);
		panelToolbar= new PanelToolbar(game,gameAhorcado,fonts,colorChooser);
		panelToolbar.setBounds(500,20, 200 ,200);
		game.add(panelToolbar);
		colorChooser= new ColorChooserDemo(gameAhorcado);
		managerlanguage= new ManagerLanguage(gameAhorcado, global);
		managerlanguage.changeLeng(cont);
		aux=managerlanguage.change_words();
		logicaWords.chargeWords(aux);
		gameAhorcado.setVisible(true);

	}


	public void paint (Graphics g){
		super.paint(g);
		g.drawLine (0, 240, 800, 240);
		//
	}

	public void ChargeRegistry(){
		Score s= new Score(FILE_NAME);	
		s.ReadAllSecuencial();
	}

	public boolean validat(){
		boolean result = false; 
		if( usuario.getText().length()<3){
			JOptionPane.showMessageDialog(null, "El nombre debe tener mínimo 3 caracteres");
			result=false;
	
		}else{
			result=true;
		}
		return result;

	}
	
	public boolean verificate(){
	boolean result;
		if (score.sizerecord()==0){
			result=true;
		}else{
			result=false;
		}
		return result;
		
	}


// -----------------LOS GET Y LOS SET--------------------------//

	public int calculaNivel(){
		int  value=level+3;
		return value;

	}

	public JButton getJButtonGuardar() {
		return JButtonGuardar;
	}


	public void setJButtonGuardar(JButton jButtonGuardar) {
		JButtonGuardar = jButtonGuardar;
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

	public LogicaWords getLogicaWords() {
		return logicaWords;
	}

	public void setLogicaWords(LogicaWords logicaWords) {
		this.logicaWords = logicaWords;
	}

}