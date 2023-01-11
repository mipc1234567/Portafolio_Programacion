package gui;

import internacionalizacion.PanelToolbar;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import persistence.Score;
import enu.FormOpenFile;
import logica.LogicaGame;
import logica.LogicaWords;

/**
 * @author Mateo Ivan Peña C
 * @version 1.0
 * @Place Universidad Pedagogica y Tecnologica de Colombia
 */

public class PanelGame extends  JPanel implements ActionListener,ItemListener{
/**
 * Atributos de la clase
 */
private static final String FILE_NAME="src\\ahorcado.bin";
private final static String IMAGE="/images/España/Historia-de-la-Bandera-de-España.png";
private static final long serialVersionUID = 1L;
private String[] nombres={"Ahorcado 1","Ahorcado 2","Ahorcado 3","Ahorcado 4","Ahorcado 5","Ahorcado 6", "Ahorcado 7", "Ahorcado 8"};
private static   LogicaGame Game;
private static final String parametrer="_";
private String palabra="";
/**
 * Atributo que permite almacenar las posiciones en las cuales la letra si corresponde almacena
 * 1 y 0
 */
private int[] positions;
/**
 * Atributo que permite establecer si la cadena ingresada si correaponde o no
 */
private int[] definitivo;

/**
 * controla que la cantida de letras que se ingresa correspondan a la palabra del juego
 * 
 */
private int aux;
/**
 * Atibuto que cuenta el numero de intentos segun la ejecucion del juego 
 */
private int cont=0;
private boolean value=true;
private int control=1;
/**
 * variable que permite asignar valores de un puntaje segun el numero de intentos y e nivel
 */
private int truths;
/**
 * varible qe permite controlar la aparicion o desaparcion de la persistencia
 */
private boolean controlScore=false;
private persistence.Score Score;
private JLabel jlabelNombres;
private JRadioButton jradword;
private JRadioButton jradletter;
private ButtonGroup buttongroup;
private  JLabel jlabelINTENTOS;
private JTextField jtxtWORD;
private JTextField jtxtLETTER;
private JButton  jbtnSALIR;
private JButton jbtnValidar;
private JLabel jlblValidation;
private static final String CALCULATE= "calculate";
private JLabel jlblpalabra;
private JLabel personalitation;
private JLabel validacion;
private JLabel labelIMAGEN;
private  LogicaWords Words;
private int intentos;

/**
 * Contrictor que permite cargar la logica para poder crear la dinamica del juego
 * @param Words
 */
public PanelGame(LogicaWords Words){
this.Words=Words;
this.definitivo= new int[Words.getUnique().length()];
this.intentos=Words.getLevel();
setLayout(null);
this.setSize(500, 800);
initializace(Words.getUnique().length());
JOptionPane.showMessageDialog(null,"bienvenido a la apliacion");
System.out.println("el valor de la longuitud es");

jlblpalabra= new JLabel();
jlblpalabra.setFont(new Font("arial", 34, 43));
jlblpalabra.setBounds(200,10, 400, 200);

jlblpalabra.setText(getPalabra());
this.add(jlblpalabra);


jtxtWORD= new JTextField("ingrese la palabra");
jtxtWORD.setBounds(200, 150,130, 30);
this.add(this.jtxtWORD);


jtxtLETTER= new JTextField("ingrese la letra");
jtxtLETTER.setBounds(400,150 ,130, 30);
this.add(this.jtxtLETTER);


jlblValidation= new JLabel("la palabra es:");
jlblValidation.setBounds((getWidth()/2)+40, 20, 200,40 );
this.add(this.jlblValidation);



jbtnSALIR= new JButton();
jbtnSALIR.setActionCommand(CALCULATE);
jbtnSALIR.addActionListener(actionsButtons1);
jbtnSALIR.setText("SALIR");
jbtnSALIR.setBounds((getWidth()/2),200, 100, 30);
add(jbtnSALIR);
this.add(this.jbtnSALIR);

jbtnValidar= new JButton();
jbtnValidar.setActionCommand(CALCULATE);
jbtnValidar.addActionListener(actionsButtons2);
this.add(this.jbtnValidar);
jbtnValidar.setText("VALIDAR");
jbtnValidar.setBounds((getWidth()/2)+110,200, 100, 30);
add(jbtnValidar);


jlabelINTENTOS= new JLabel("los intentos restantes son:");
this.add(this.jlabelINTENTOS);

jlabelINTENTOS.setBounds(0,10, 300, 50);
jlabelINTENTOS.setText("los intentos son: "+intentos);
add(jlabelINTENTOS);
setBorder(new TitledBorder("Juego Ahorcado"));


labelIMAGEN= new JLabel("la imagen es");
labelIMAGEN.setIcon(new ImageIcon(getClass().getResource("Nulo.png")));
labelIMAGEN.setBounds(10,240, 770, 290);
add(labelIMAGEN);

this.personalitation= new JLabel();
this.personalitation.setBounds(550, 100, 200, 100);
this.personalitation.setIcon(new ImageIcon(getClass().getResource((IMAGE))));
this.add(personalitation);

jradword= new JRadioButton("palabra",true);
jradletter= new JRadioButton("letra",false);
validacion= new JLabel("validar por:");
validacion.setBounds(100, 100, 200, 100);
this.add(validacion);
jradletter.setBounds(100, 170, 100, 15);
jradletter.addItemListener(actionsCheck);
jradword.setBounds(100, 190, 100, 15);
add(jradword);
jradword.addItemListener(actionsCheck2);

add(jradletter);

buttongroup= new ButtonGroup();
buttongroup.add(jradword);
buttongroup.add(jradletter);
Score= new Score(FILE_NAME,FormOpenFile.READ);


}

/**
 * Constructor para inicializar el panel antes de cargarlo con la logica
 */
public PanelGame() {
	this.Words=Words;
	setLayout(null);
	this.setSize(500, 800);
	initializace(0);
	JOptionPane.showMessageDialog(null,"bienvenido a la apliacion");
	jlblpalabra= new JLabel();
	jlblpalabra.setFont(new Font("arial", 34, 43));
	jlblpalabra.setBounds(200,10, 400, 200);

	jlblpalabra.setText(getPalabra());
	this.add(jlblpalabra);


	jtxtWORD= new JTextField("ingrese la palabra");
	jtxtWORD.setBounds(200, 150,130, 30);
	this.add(this.jtxtWORD);


	jtxtLETTER= new JTextField("ingrese la letra");
	jtxtLETTER.setBounds(400,150 ,130, 30);
	this.add(this.jtxtLETTER);


	jlblValidation= new JLabel("la palabra es:");
	jlblValidation.setBounds((getWidth()/2)+40, 20, 200,40 );
	this.add(this.jlblValidation);


	jbtnSALIR= new JButton();
	jbtnSALIR.setActionCommand(CALCULATE);
	jbtnSALIR.addActionListener(actionsButtons1);
	jbtnSALIR.setText("SALIR");
	jbtnSALIR.setBounds((getWidth()/2),200, 100, 30);
	add(jbtnSALIR);
	this.add(this.jbtnSALIR);

	jbtnValidar= new JButton();
	jbtnValidar.setActionCommand(CALCULATE);
	jbtnValidar.addActionListener(actionsButtons2);
	this.add(this.jbtnValidar);
	jbtnValidar.setText("VALIDAR");
	jbtnValidar.setBounds((getWidth()/2)+110,200, 100, 30);
	add(jbtnValidar);


	jlabelINTENTOS= new JLabel("los intentos restantes son:");
	jlabelINTENTOS.setBounds(0,10, 300, 50);
	jlabelINTENTOS.setText("los intentos son: "+intentos);
	
	this.add(this.jlabelINTENTOS);
	setBorder(new TitledBorder("Juego Ahorcado"));


	labelIMAGEN= new JLabel("la imagen es");
	labelIMAGEN.setIcon(new ImageIcon(getClass().getResource("Nulo.png")));
	labelIMAGEN.setBounds(10,240, 770, 290);
	add(labelIMAGEN);

	this.personalitation= new JLabel();
	this.personalitation.setBounds(550, 100, 200, 100);
	this.personalitation.setIcon(new ImageIcon(getClass().getResource((IMAGE))));
	this.add(personalitation);

	jradword= new JRadioButton("palabra",true);
	jradletter= new JRadioButton("letra",false);
	validacion= new JLabel("validar por:");
	validacion.setBounds(100, 100, 200, 100);
	this.add(validacion);
	jradletter.setBounds(100, 170, 100, 15);
	jradletter.addItemListener(actionsCheck);
	jradword.setBounds(100, 190, 100, 15);
	add(jradword);
	jradword.addItemListener(actionsCheck2);

	add(jradletter);

	buttongroup= new ButtonGroup();
	buttongroup.add(jradword);
	buttongroup.add(jradletter);

}
/**
 * inicializa la palabra buscada con "_" para empezar el juego
 * @param value
 */
public void initializace(int value){
	for (int i = 0; i <value; i++) {
		System.out.println(i);
		palabra+="_"+" ";
	}
}
/**
 * Calcula el puntaje obtenido
 * @return
 */
public int calculateScore(){
	return truths;
	
}
/**
 * actualiza los valores de las images segun la cantidad de intentos 
 */
public void actualiza(){
System.out.println("valor de los intentos:");
System.out.println(intentos);
System.out.println("tamaño de los nombres");
System.out.println(nombres.length);
System.out.println("noombre del archivo");
System.out.println(nombres[cont]+".png");
System.out.println(cont);
		labelIMAGEN.setIcon(new ImageIcon(getClass().getResource(nombres[cont]+".png")));
		add(labelIMAGEN);
		cont++;
}
/**
 * Sale de la aplicacion en caso de perder
 */

public void add1(){
System.exit (0);
}
/**
 * carga toda la dinamica del juego realizando las validaciones y comparaciones de la clase
 */
public void add2(){
boolean result;
int cont;
cont=intentos;
String contador= Integer.toString(cont);
String opcion;
int dato = 0;
int [] auxiliar= new int[Words.getUnique().length()];
positions= new int[Words.getUnique().length()];
System.out.println(jtxtLETTER.getText());
if (control==0 ){
	JOptionPane.showMessageDialog(null, "debe seleccionar un parametro/nletra/n palabra");
}

if(value==true){
	System.out.println("se validara por palabra");
dato=1;
}else{
	if(value==false){
		System.out.println("se validara por letra");
	dato=2;
	System.out.println("el valor del dato");
	System.out.println(dato);
	}
}
 	switch(dato){
 		case 1:		
	if(dato==1){
		System.out.println(jtxtWORD.getText());
		System.out.println(Words.getUnique());
			result=Words.ComparateWords(jtxtWORD.getText(),Words.getUnique());
			if(result==true){
				jlblValidation.setText("las cadenas son iguales");
				jlblpalabra.setText(Words.getUnique());
				jlabelINTENTOS.setText("los intentos son: "+intentos);
				 JOptionPane.showMessageDialog(null,"!!!!!!!!!!!!!!ha acertado gano!!!!!!!!!!!!!!!");
				 labelIMAGEN.setIcon(new ImageIcon(getClass().getResource("ganar"+".png")));
				 truths=getIntentos()*100;
				// Ordenar();
			    	Save();
			    	Read();
			    	controlScore=true;
			    	
			}else{
				intentos--;
				actualiza();
				jlabelINTENTOS.setText("los intentos son: "+" " +intentos);
				jlblValidation.setText("las cadenas son diferentes");
				jlblpalabra.setText(palabra);	
					 
			}
	}
	  break;
	  
	    case 2:
	    	if(dato==2){
	    		String parcial="";
	  result=Words.showLetterAdvinate(jtxtLETTER.getText());
	 System.out.println("el valor del resulado es" + result);
	  if(result==true){
	    	    jlblValidation.setText("la letra es correcta ");
	    	    truths=getIntentos()*10;
	    	   initialiceCorrdenates();
	    		aux++;
	    	    auxiliar=saveCorrdenates();
	    	    for (int i = 0; i <=auxiliar.length-1; i++) {
	    			if (auxiliar[i]==1){
	    				System.out.println("esta es la poscion de la letra");
	    				parcial+=Words.getUnique().charAt(i);
	    			System.out.println(definitivo[i]);
	    		}else{
	    			if (auxiliar[i]==0){
	    		parcial+=parametrer+" ";
	    			
	    		}
	    		}	
	    	}
	  		
	    			System.out.println(parcial);
	    			jlblpalabra.setText(parcial); 
	    
	   }else{
	    	intentos--;
	    	jlabelINTENTOS.setText("los intentos son: "+" "+intentos);	
	    	System.out.println("si es este");
	    	actualiza();
	    	}
	   
	    	}
	    	if(intentos!=0 && aux==Words.getUnique().length() )
	    		 labelIMAGEN.setIcon(new ImageIcon(getClass().getResource("ganar"+".png")));
	    //	Ordenar();
	    	Save();
	    	Read();
	    	controlScore=true;
	    	break;
	    default:
	    	break;


}while(intentos==0){
JOptionPane.showMessageDialog(null," perdio");
System.exit (0);
}
}
/**
 * permite guadar las conrdenadas segun la posicion en la que se encuetren las letras
 * que hallan sido ingresadas con las que se ingresan retornando las letras que se deben mostrar
 * @return
 */
public int[]saveCorrdenates(){
for (int m = 0; m <=positions.length-1; m++) {
        if(positions[m]==0 && definitivo[m]!=1){
        	definitivo[m]=0;
	}else{
		if(positions[m]==1){
			definitivo[m]=1;
		}
	}
	}
	return definitivo;
}

/**
 * metodo que carga las posiciones de las letras segun la lectura que se haga del vector
 */
public void initialiceCorrdenates(){
	for (int m = 0; m <=Words.getUnique().length()-1; m++) {
        if(Words.getPositions()[m]==0){
        	positions[m]=0;
	}else{
		if(Words.getPositions()[m]==1){
			positions[m]=1;
	
		}
	}
	}
}
/**
 * Implemetacion de las clases de persitencia para poder almacernar los datos del usurio 
 * en el momento de su sesion
 */
	public void Save(){
	Score= new persistence.Score(FILE_NAME,FormOpenFile.WRITE);
	Score.open();
	if(Words.getIdentificador()==0){
		System.out.println("si es cero");
		Score.addDirect(Words);
	}else{
	Score.ChargeRegitry();
	Score.addDirect(Words);
	Score.close();
	}
	}
	
/**
 * 	metodo que permite leer el contenido del archivo
 */
	public void Read(){
		Score= new Score(FILE_NAME,FormOpenFile.READ);
		Score.open();
		Score.ReadAllSecuencial();
		Score.close();
	}
	public void Ordenar(){
		Score.sortselection();
	
	}


//*************************** Otros Metodos *********************
public void actionPerformed1(ActionEvent e) {
	if(e.getActionCommand().equals(CALCULATE)){
	System.out.println("funciona");
	
}
					
}	
/**
 * Accion que iniciliza la salida del programa
 */
ActionListener actionsButtons1 = new ActionListener() {		
	public void actionPerformed(ActionEvent action) {
		if (action.getActionCommand().equals(CALCULATE)) {
			add1();
			
		}
			
		}
};

/**
 *Accion que permite ejecutar la dinamica de la aplicacion 
 */
ActionListener actionsButtons2 = new ActionListener() {
	public void actionPerformed(ActionEvent action){
		if (action.getActionCommand().equals(CALCULATE)) {
			add2();
		
			
		}
	}
};



@Override
public void itemStateChanged(ItemEvent e) {
	// TODO Auto-generated method stub
	
			
	}
		

/**
 * Accion que escuha los parametros del Raduio button de la clase
 * en este caso letra
 */

ItemListener actionsCheck2 = new ItemListener() {
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(jradword.getActionCommand().equalsIgnoreCase("palabra")){
	System.out.println("si escvuha palabra");
		value=true;
		System.out.println(value);
	control=1;	
	System.out.println("el valor del control es" + control);
		}
		
	}
	
};

/**
 * Accin que escuha los parametros del Radio button de la clase
 * en este caso la palabra
 */
ItemListener actionsCheck = new ItemListener() {

@Override
public void itemStateChanged(ItemEvent e) {
	// TODO Auto-generated method stub
	if(jradletter.getActionCommand().equalsIgnoreCase("letra")){
		System.out.println("si escvuha letra");
	value=false;
	System.out.println(value);
	control=2;
	System.out.println("el valor del control es" + control);
	}
}	
};


	/**
	 * -----------------------------los GET Y LOS SET---------------------------
	 */
	
	public static LogicaGame getGame() {
		return Game;
	}

	public static void setGame(LogicaGame game) {
		Game = game;
	}



	public LogicaWords getWords() {
		return Words;
	}


	public void setWords(LogicaWords words) {
		Words = words;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}


	public JLabel getLabelIMAGEN() {
		return labelIMAGEN;
	}


	public void setLabelIMAGEN(JLabel labelIMAGEN) {
		this.labelIMAGEN = labelIMAGEN;
	}


	public String[] getNombres() {
		return nombres;
	}


	public void setNombres(String[] nombres) {
		this.nombres = nombres;
	}


	public int[] getPositions() {
		return positions;
	}


	public void setPositions(int[] positions) {
		this.positions = positions;
	}


	public int[] getDefinitivo() {
		return definitivo;
	}


	public void setDefinitivo(int[] definitivo) {
		this.definitivo = definitivo;
	}


	public int getIntentos() {
		return intentos;
	}


	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}


	public int getAux() {
		return aux;
	}


	public void setAux(int aux) {
		this.aux = aux;
	}


	public int getCont() {
		return cont;
	}


	public void setCont(int cont) {
		this.cont = cont;
	}


	public JLabel getJlabelNombres() {
		return jlabelNombres;
	}


	public void setJlabelNombres(JLabel jlabelNombres) {
		this.jlabelNombres = jlabelNombres;
	}


	public JLabel getJlabelINTENTOS() {
		return jlabelINTENTOS;
	}


	public void setJlabelINTENTOS(JLabel jlabelINTENTOS) {
		this.jlabelINTENTOS = jlabelINTENTOS;
	}


	public JTextField getJtxtWORD() {
		return jtxtWORD;
	}


	public void setJtxtWORD(JTextField jtxtWORD) {
		this.jtxtWORD = jtxtWORD;
	}


	public JTextField getJtxtLETTER() {
		return jtxtLETTER;
	}


	public void setJtxtLETTER(JTextField jtxtLETTER) {
		this.jtxtLETTER = jtxtLETTER;
	}


	public JButton getJbtnSALIR() {
		return jbtnSALIR;
	}


	public void setJbtnSALIR(JButton jbtnSALIR) {
		this.jbtnSALIR = jbtnSALIR;
	}


	public JButton getJbtnValidar() {
		return jbtnValidar;
	}


	public void setJbtnValidar(JButton jbtnValidar) {
		this.jbtnValidar = jbtnValidar;
	}


	public JLabel getJlblValidation() {
		return jlblValidation;
	}


	public void setJlblValidation(JLabel jlblValidation) {
		this.jlblValidation = jlblValidation;
	}


	public JLabel getJlblpalabra() {
		return jlblpalabra;
	}


	public void setJlblpalabra(JLabel jlblpalabra) {
		this.jlblpalabra = jlblpalabra;
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


	public static String getParametrer() {
		return parametrer;
	}


	public static String getCalculate() {
		return CALCULATE;
	}


	public JLabel getPersonalitation() {
		return personalitation;
	}


	public void setPersonalitation(JLabel personalitation) {
		this.personalitation = personalitation;
	}



public boolean isValue() {
	return value;
}


public int getTruths() {
	return truths;
}


public void setTruths(int truths) {
	this.truths = truths;
}


public void setValue(boolean value) {
	this.value = value;
}


public persistence.Score getScore() {
	return Score;
}


public void setScore(persistence.Score score) {
	Score = score;
}


public boolean isControlScore() {
	return controlScore;
}


public void setControlScore(boolean controlScore) {
	this.controlScore = controlScore;
}


}
