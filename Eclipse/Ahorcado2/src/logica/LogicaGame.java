package logica;

import java.io.Serializable;
import javax.swing.JLabel;

/**
 * @author Mateo Ivan Peña C
 * @version 1.0
 * @Place Universidad Pedagogica y Tecnologica de Colombia
 * juego ahorcado
 */


public class LogicaGame implements Serializable{

	
	private LogicaWords logica;
	private char [] wordBrowse;
	private char [] wordGuess;
	private static int cantLetr= 0;					
	private static final int INTENTOS = 8;
	private char[] Guess;
	private char [] wordGuessTemp;
	private String  palabra;
	private char letter;
	private String GuessWord=null;
	private boolean result;
	private static final String parametrer="_";
	

/**
 * Contructor que asigna un alogica al juego para realizar validaciones de 
 * la clase LogicaWords  es una calse de prebas
 * @param logica
 */
	public LogicaGame(LogicaWords logica){
		this.logica=logica;
		initiali();
	}

	public void initiali(){
		cantLetr= logica.getUnique().length();
		wordBrowse =new char [cantLetr];
		//se crea un vector de caracteres
		for (int j=0; j<=cantLetr-1;j++){
			wordBrowse[j]=logica.getUnique().charAt(j);
		}

	}
	public boolean ComparateWords(String WordIngresate,String palabra){
		boolean result=false;
		if (palabra.equalsIgnoreCase(WordIngresate)){
			result=true;
		}else{
			result=false;
		}
		return result;

	}


	public void print(){
		String result="";
		int i=0;
		while(i<getCantLetr()){
			for(i=0; i<=getCantLetr();i++){
				if(Guess[i]==0){
					logica.getWordGuessTemp()[i]=Guess[i];
				}else{
					if(Guess[i]!=0){
						Guess[i]=Guess[i];
					}
				}}}
		i++;
		result= GuessWord.toString();

		System.out.println(result);		
	}


	public boolean validation(){
		boolean result= false;
		for (int i=0; i<=Guess.length;i++){
			if(Guess[i]==wordBrowse[i]){
				result= true;
			}else{
				if(Guess[i]!=wordBrowse[i]){
					result= false;
				}
			}


		}
		return result;
	}
	//************los get y los set*************

	public static int getCantLetr() {
		return cantLetr;
	}


	public static void setCantLetr(int cantLetr) {
		LogicaGame.cantLetr = cantLetr;
	}
	public char[] getWordBrowse() {
		return wordBrowse;
	}

	public void setWordBrowse(char[] wordBrowse) {
		this.wordBrowse = wordBrowse;
	}

	public char[] getWordGuess() {
		return wordGuess;
	}

	public void setWordGuess(char[] wordGuess) {
		this.wordGuess = wordGuess;
	}
	public static int getIntentos() {
		return INTENTOS;
	}
	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}


	public char[] getWordGuessTemp() {
		return wordGuessTemp;
	}

	public void setWordGuessTemp(char[] wordGuessTemp) {
		this.wordGuessTemp = wordGuessTemp;
	}
}






