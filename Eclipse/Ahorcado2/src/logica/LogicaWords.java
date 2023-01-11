package logica;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.crypto.spec.PSource;


/**
 * @author Mateo Ivan Peña C
 * @version 1.0
 * @Place Universidad Pedagogica y Tecnologica de Colombia
 * juego ahorcado
 */

public class LogicaWords {



	//***********ATRIBUTOS*********

	/**
	 * vector que almacena las palabras
	 */
	private String[] Words;
	/**
	 *palabra aleatoria del sistema a partir de los vetores 
	 */
	private String machineWord;
	/**
	 * vector que almacena las letras de la palabra del usuario
	 */
	private char[] wordGuessTemp;
	/**
	 *variable que almacena la palabra  del usuario
	 */
	private String UserWord="";
	/**
	 * variable que al macena la letra del usuario
	 */
	private char UserLetter;
	/**
	 * Variable que almacena la letra del usuario
	 */
	private char MachineLetter;

	/**
	 * Constante de maxima cantidad de palanbras
	 */
	private static final int MAX_PALABRAS = 131;
	/**
	 *vector que almacena las letras de la palabra 
	 */
	private char [] wordBrowseMachine;
	/**
	 * 
	 */
	private static int cantLetr= 0;		
	/**
	 * cantidad de intentos del juego
	 */
	private static final int INTENTOS = 5;
	/**
	 * otras configuraciones 
	 */
	private char letter;
	private int[] positions;
	private boolean result;
	private String total="";
	public static final int SIZE_REGISTRY = 15;
	private String name;
	private String language;
	private String fecha;
	private int puntaje;
	private int identificador;
	private int posaleat;
	private String Unique;
	private int level;
	
	/***
	 *CONSTRUCTOR
	 */
	
	public LogicaWords(){
	//para inicializar los atributos se configra el este parametro en 8
      this.level=8;
     
	}
	
	public String[]initializace_Words(String [] words){
		
		Words= new String[MAX_PALABRAS];
		Words[21] = "NICOLAS";			Words[22] = "PIERRE";				Words[23] = "INGO";
		Words[24] = "PROYECTO";		Words[25] = "PUTA";					Words[26] = "YOGURT";
		Words[27] = "MADITO";			Words[28] = "EDITOR";				Words[29] = "PRIMERA";
		Words[30] = "VIEJO";			Words[31] = "FIGURAS";			Words[32] = "ULTIMA";
		Words[33] = "PIZARRA";		Words[34] = "COCODRILO";			Words[35] = "BORRACHO";
		Words[36] = "AGUSTIN";		Words[37] = "DINOSAURIO";		Words[38] = "DORMIR";
		Words[39] = "OBJETO";			Words[40] = "ELEFANTE";			Words[41] = "MICRO";
		Words[42] = "JAVA";			Words[43] = "GALLO";				Words[44] = "CERRO";
		Words[45] = "GRASP";			Words[46] = "CONDOR";				Words[47] = "ALEGRE";
		Words[48] = "FRAME";			Words[49] = "HUEMUL";				Words[50] = "PLACERES";
		Words[51] = "PALABRA";		Words[52] = "AGUILA";				Words[53] = "SANTA";
		Words[54] = "EJEMPLO";		Words[55] = "RANA";				Words[56] = "MARIA";
		Words[57] = "ALEMANIA";		Words[58] = "LINUX";				Words[59] = "TECNICA";
		Words[60] = "FRANCIA";		Words[61] = "COMIDA";				Words[62] = "COMPUTADOR";
		Words[63] = "CHILE";			Words[64] = "HAMBRE";				Words[65] = "PLANETA";
		Words[66] = "TAREA";			Words[67] = "PAN";					Words[68] = "TELEFONO";
		Words[69] = "FINALMENTE";	Words[70] = "VENTANA";			Words[71] = "CARRETE";
		Words[72] = "ELECTRONICA";	Words[73] = "REFRIGERADOR";		Words[74] = "OCEANO";
		Words[75] = "VALPARAISO";	Words[76] = "CERVEZA";			Words[77] = "PLEGARIA";
		Words[78] = "ROBOTICA";		Words[79] = "LASER";				Words[80] = "ORBITA";
		Words[81] = "VENTILADOR";	Words[82] = "CARRETERA";			Words[83] = "ALERGIA";
		Words[84] = "PLAYA";			Words[85] = "BALLENA";			Words[86] = "GUERRA";
		Words[87] = "TORRE";			Words[88] = "LOCOMOTORA";		Words[89] = "PASTEL";
		Words[90] = "LLUVIA";			Words[91] = "COMPILADOR";		Words[92] = "LASTRE";
		Words[93] = "MANZANA";		Words[94] = "PLATANO";			Words[95] = "CHIRIMOYA";
		Words[96] = "BICICLETA";		Words[97] = "RUEDA";				Words[98] = "CAMION";
		Words[99] = "TOMATE";			Words[100] = "ZANAHORIA";			Words[101] = "LECHUGA";
		Words[102] = "TOMATE";			Words[103] = "ZANAHORIA";			Words[104] = "LECHUGA";
		Words[105] = "ETIQUETA";		Words[106] = "PANAL";				Words[107] = "CARBONO";
		Words[108] = "CADMIO";			Words[109] = "NIQUEL";				Words[110] = "COBRE";
		Words[111] = "ESTABLO";			Words[112] = "QUIMICO";			Words[113] = "TOXICO";
		Words[114] = "DIAMANTE";		Words[115] = "FRAMBUEZA";			Words[116] = "MUERTE";
		Words[117] = "VOLCAN";			Words[118] = "FRUTILLA";			Words[119] = "COHETE";	Words[120] = "MATEO";

		//this.randPalabra();
		return Words;
		
	}
	
	
	public String[]initializace_Words2(){
		
		Words= new String[MAX_PALABRAS];
		Words[21] = "NICOLAS";			Words[22] = "PIERRE";				Words[23] = "INGO";
		Words[24] = "PROYECTO";		Words[25] = "PUTA";					Words[26] = "YOGURT";
		Words[27] = "MADITO";			Words[28] = "EDITOR";				Words[29] = "PRIMERA";
		Words[30] = "VIEJO";			Words[31] = "FIGURAS";			Words[32] = "ULTIMA";
		Words[33] = "PIZARRA";		Words[34] = "COCODRILO";			Words[35] = "BORRACHO";
		Words[36] = "AGUSTIN";		Words[37] = "DINOSAURIO";		Words[38] = "DORMIR";
		Words[39] = "OBJETO";			Words[40] = "ELEFANTE";			Words[41] = "MICRO";
		Words[42] = "JAVA";			Words[43] = "GALLO";				Words[44] = "CERRO";
		Words[45] = "GRASP";			Words[46] = "CONDOR";				Words[47] = "ALEGRE";
		Words[48] = "FRAME";			Words[49] = "HUEMUL";				Words[50] = "PLACERES";
		Words[51] = "PALABRA";		Words[52] = "AGUILA";				Words[53] = "SANTA";
		Words[54] = "EJEMPLO";		Words[55] = "RANA";				Words[56] = "MARIA";
		Words[57] = "ALEMANIA";		Words[58] = "LINUX";				Words[59] = "TECNICA";
		Words[60] = "FRANCIA";		Words[61] = "COMIDA";				Words[62] = "COMPUTADOR";
		Words[63] = "CHILE";			Words[64] = "HAMBRE";				Words[65] = "PLANETA";
		Words[66] = "TAREA";			Words[67] = "PAN";					Words[68] = "TELEFONO";
		Words[69] = "FINALMENTE";	Words[70] = "VENTANA";			Words[71] = "CARRETE";
		Words[72] = "ELECTRONICA";	Words[73] = "REFRIGERADOR";		Words[74] = "OCEANO";
		Words[75] = "VALPARAISO";	Words[76] = "CERVEZA";			Words[77] = "PLEGARIA";
		Words[78] = "ROBOTICA";		Words[79] = "LASER";				Words[80] = "ORBITA";
		Words[81] = "VENTILADOR";	Words[82] = "CARRETERA";			Words[83] = "ALERGIA";
		Words[84] = "PLAYA";			Words[85] = "BALLENA";			Words[86] = "GUERRA";
		Words[87] = "TORRE";			Words[88] = "LOCOMOTORA";		Words[89] = "PASTEL";
		Words[90] = "LLUVIA";			Words[91] = "COMPILADOR";		Words[92] = "LASTRE";
		Words[93] = "MANZANA";		Words[94] = "PLATANO";			Words[95] = "CHIRIMOYA";
		Words[96] = "BICICLETA";		Words[97] = "RUEDA";				Words[98] = "CAMION";
		Words[99] = "TOMATE";			Words[100] = "ZANAHORIA";			Words[101] = "LECHUGA";
		Words[102] = "TOMATE";			Words[103] = "ZANAHORIA";			Words[104] = "LECHUGA";
		Words[105] = "ETIQUETA";		Words[106] = "PANAL";				Words[107] = "CARBONO";
		Words[108] = "CADMIO";			Words[109] = "NIQUEL";				Words[110] = "COBRE";
		Words[111] = "ESTABLO";			Words[112] = "QUIMICO";			Words[113] = "TOXICO";
		Words[114] = "DIAMANTE";		Words[115] = "FRAMBUEZA";			Words[116] = "MUERTE";
		Words[117] = "VOLCAN";			Words[118] = "FRUTILLA";			Words[119] = "COHETE";	Words[120] = "MATEO";

		this.randPalabra();
		return Words;
		
	}
	public  String []chargeWords(String values[]){
		Words= new String[MAX_PALABRAS];
		for (int i = 0; i < values.length; i++) {
		Words[i]=values[i];	
		}
		this.randPalabra();
		return Words;
	}
	
	public LogicaWords(int indentificad,String user,String fecha,int puntaje,int level){
	initializace_Words2();
	this.name=user;
	this.fecha=fecha;
	this.puntaje=puntaje;
	this.identificador=indentificad;
	this.level=level;
	}


	//inicializar los atributos de la apliacion
	public void initialisaze(){
		initializace_Words(Words);
		cantLetr=getMachineWord().length();
		Unique=getMachineWord();
		wordBrowseMachine =new char [cantLetr];
		positions= new int[cantLetr];
		//se crea un vector de caracteres
		for (int j=0; j<=cantLetr-1;j++){
			wordBrowseMachine[j]=getMachineWord().charAt(j);
			System.out.println(wordBrowseMachine[j]);
			//System.out.println(positions[j]);
		}
		System.out.println(machineWord);
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void ChargeWords(String []values){
		for (int i = 21; i <=values.length-1; i++) {
			Words[i]=values[i];
		}
		Unique=values[posaleat];
		cantLetr=getUnique().length();
		wordBrowseMachine =new char [cantLetr];
		positions= new int[cantLetr];
		//se crea un vector de caracteres
		for (int j=0; j<=cantLetr-1;j++){
			wordBrowseMachine[j]=getUnique().charAt(j);
			System.out.println(wordBrowseMachine[j]);
			//System.out.println(positions[j]);
		}
		System.out.println(Unique);
	}
		
	

	//devuelve una palabra aleatoria de las almacenadas

	public String randPalabra(){
		Random index = new Random();
		int valorEntero = (int) Math.floor(Math.random()*(21-120+1)+120);  // Valor entre M y N, ambos incluidos.
		 posaleat=(int)(index.nextDouble()*MAX_PALABRAS);
		 System.out.println("el valor aleatorio");
		 System.out.println(posaleat);
		System.out.println("valor del numero aleatorio");
	  System.out.println(posaleat);
		posaleat=valorEntero;
	  System.out.println("nuevo aleatori");
	  System.out.println(valorEntero);
		// (int)(rnd.nextDouble() * 100);
		machineWord = Words[valorEntero];
		return (machineWord);
	}


	//maneja la vista de adivinar una letra por consola

	public boolean  showLetterAdvinate(String letter){  
		int cont=0;
		String temp="";
		char fractionletter;
		temp= letter.toUpperCase();
		fractionletter=temp.charAt(0);
		wordGuessTemp = new char[Unique.length()];
		for (int i = 0; i <=wordBrowseMachine.length-1; i++) {
			wordGuessTemp[i]=Unique.charAt(i);
		}
		System.out.println("letra generada");
    System.out.println(Unique);
	System.out.println("tamaño de la palabra generada");
	System.out.println(Unique.length());
	System.out.println("la letra del usuario es");
	System.out.println(temp);
	System.out.println("fraccion de la letra");
	System.out.println(fractionletter);
	

		for(int j=0;j<=Unique.length()-1;j++){
			MachineLetter=Unique.charAt(j);
			System.out.println("valor del la letra"+Unique.charAt(j));
			if(MachineLetter==fractionletter){
				System.out.println("si ´paso por aie");
				cont++;
			positions[j]=1;
				//*se asigna la letra al la palabra del usuario
				//*se asigna la letra al vector del usuario
				wordGuessTemp[j]=fractionletter;
				System.out.println(positions[j]);
				//System.out.println(wordGuessTemp[j]);
				total+=temp;
				//System.out.println(total);

			}else{
				//System.out.println("_");
				total+="_"+" ";
				wordGuessTemp[j]='_';
				positions[j]=0;
				//System.out.println(total);
				System.out.println(UserWord);
			}}
		UserWord=total;
		//System.out.println(UserWord);
		if (cont>0){
			result=true;
		}else{
			result=false;
			System.out.println(total);
		}
		return result;
	}


	//muetra por consola si la palabra ingresada existe

	public boolean showWordAdivinate(String word){  

		UserWord=word;
		wordGuessTemp = new char[UserWord.length()];
		//do{
		for(int j=0;j<UserWord.length();j++){
			wordGuessTemp[j]=UserWord.charAt(j);
		}
		if (UserWord.equalsIgnoreCase(Unique)){
			System.out.println("dsssssssssssssssszi etro");
			return result=true;
		}else{
			return result=false;
		}

	}

	public boolean ComparateWords(String WordIngresate,String palabra){
		boolean result;
		if (palabra.equalsIgnoreCase(WordIngresate)){
			result=true;
		}else{
			result=false;
		}
		return result;

	}

	public boolean validation(String Readpalabra){
		boolean result= false;
		int cont=0;
		wordGuessTemp = new char[Readpalabra.length()];
		for (int i=0; i<=wordGuessTemp.length-1;i++){
			if(wordGuessTemp[i]==wordBrowseMachine[i]){
				result= true;
				cont++;
			}else{
				if(wordGuessTemp[i]!=wordBrowseMachine[i]){
					result= false;
				}
			}
		}
		//if cont>0{


		return result;
	}
	
	 public byte[] getNameChar() {
	        byte[] aux =  new byte[this.SIZE_REGISTRY];
	        for (int i = 0; i < this.name.length() && i < SIZE_REGISTRY; i++) {
	            aux[i] = (byte)this.name.charAt(i);
	        }
	        for (int i = this.name.length(); i < this.SIZE_REGISTRY; i++) {
	            aux[i] =(byte) ' ';
	        }
	        return aux;
	    }
	 
	 public byte[] getDateChar() {
		// recore_fecha();
		 //System.out.println(fecha);
	        byte[] aux =  new byte[this.SIZE_REGISTRY];
	        for (int i = 0; i < this.fecha.length() && i < SIZE_REGISTRY; i++) {
	            aux[i] = (byte)this.fecha.charAt(i);
	        }
	        for (int i = this.fecha.length() ; i < this.SIZE_REGISTRY; i++) {
	            aux[i] =(byte) ' ';
	        }
	        return aux;
	    }
	

	 
	/* public void recore_fecha(){
		 this.fecha=fecha_juego.getTime().getDay()+"/"+fecha_juego.getTime().getMonth()+"/"+fecha_juego.getTime().getYear();

	 }
	 */
	
	
	//------------------------------LOS GET Y LOS SET------------------------------------------//

	public void setWords(String Word, int index){
		Words[index] = Word;
	}

	public char[] getWordGuessTemp() {
		return wordGuessTemp;
	}

	public void setWordGuessTemp(char[] wordGuessTemp) {
		this.wordGuessTemp = wordGuessTemp;
	}
	public static int getCantLetr() {
		return cantLetr;
	}
	public static void setCantLetr(int cantLetr) {
		LogicaWords.cantLetr = cantLetr;
	}
	public static int getIntentos() {
		return INTENTOS;
	}

	public String getMachineWord() {
		return machineWord;
	}

	public void setMachineWord(String machineWord) {
		this.machineWord = machineWord;
	}
	public String getUserWord() {
		return UserWord;
	}
	public void setUserWord(String userWord) {
		UserWord = userWord;
	}
	public int[] getPositions() {
		return positions;
	}
	public void setPositions(int[] positions) {
		this.positions = positions;
	}

	public char[] getWordBrowseMachine() {
		return wordBrowseMachine;
	}

	public void setWordBrowseMachine(char[] wordBrowseMachine) {
		this.wordBrowseMachine = wordBrowseMachine;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}



	

/*	public GregorianCalendar getFecha_juego() {
		return fecha_juego;
	}

	public void setFecha_juego(GregorianCalendar fecha_juego) {
		this.fecha_juego = fecha_juego;
	}*/

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String[] getWords() {
		return Words;
	}

	public void setWords(String[] words) {
		Words = words;
	}

	public int getPosaleat() {
		return posaleat;
	}

	public void setPosaleat(int posaleat) {
		this.posaleat = posaleat;
	}

	public String getUnique() {
		return Unique;
	}

	public void setUnique(String unique) {
		Unique = unique;
	}
	




}