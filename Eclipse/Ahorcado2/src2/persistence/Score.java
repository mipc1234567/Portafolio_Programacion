package persistence;

import java.io.RandomAccessFile;
import java.io.ObjectInputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Parser;

import logica.LogicaWords;
import enu.FormOpenFile;
import enu.FormSaveFile;
import persistence.Myrandomfile;
import sun.rmi.runtime.Log;
/**
 * @author Mateo Ivan Peña C
 * @version 1.0
 * @Place Universidad Pedagogica y Tecnologica de Colombia
 */
public class Score extends Myrandomfile {
	private static final String FILE_NAME="src\\Binarifile.bin";
	private static ArrayList<LogicaWords> autocarros;
	public static final int SIZE_RECORD = 15;
	private Date Fechajuego;
	private int Identificador;
	private ArrayList<LogicaWords> ArrayLogicaWords;


	public Score(String filename, FormOpenFile formopen) {
		super(filename, formopen.UPDATE);
	}

	public Score(String filename){
		super(filename);
	}


	//version mejorar a paritr de un estring de tamaño definodo
	public void addSecuencial2(LogicaWords logicaWords){
		System.out.println("si paso secuencial");
		this.seek(logicaWords.getIdentificador());
		this.write(logicaWords.getIdentificador());
		this.write(logicaWords.getNameChar());
		this.write(logicaWords.getDateChar());
		this.write(logicaWords.getPuntaje());
	}

	public String[]  ReadToCharge(){
		String result="";
		this.seek(0);
		String[] aux= new String[(int)this.sizerecord()];
		for (int i = 0; i <(int)this.sizerecord(); i++) {
			result+=this.readint()+" ";
			result+=(this.readByteSecuString(SIZE_RECORD))+" ";
			result+=this.readByteSecuString(SIZE_RECORD);
			result+=this.readint()+" ";
			result+=this.readint()+" ";
			aux[i]=result;
			result+="\n";
			System.out.println("valores leidos");
			//System.out.println(aux[i]);
			System.out.println((String)result);
		}

		return aux;

	}

	public String  ReadToCharge2(int pos){
		String result="";
		this.seek(pos);
		String[] aux= new String[(int)this.sizerecord()];
		for (int i = 0; i <(int)this.sizerecord(); i++) {
			result+=this.readint()+" ";
			result+=this.readByteSecu(SIZE_RECORD)+" ";
			result+=this.readint()+" ";
			result+=this.readint()+" ";
			aux[i]=result;
			result+="\n";
			System.out.println("valores leidos");
			//	System.out.println(aux[i]);
			System.out.println(result);
		}

		return result;

	}



	public void addDirect(LogicaWords logicaWords){
		System.out.println("si paso directo");
		this.writePosInt(logicaWords.getIdentificador(), logicaWords);
	}


	public String  ReadAllSecuencial(){
		String result="";
		this.seek(0);
		System.out.println("el tamaño del registro");
		System.out.println(this.sizerecord());
		for (int i = 0; i <(int)this.sizerecord(); i++) {
			System.out.println(this.readint());
			this.readByteSecu(SIZE_RECORD);
			this.readByteSecu(SIZE_RECORD);
			System.out.println(this.readint());
			System.out.println(this.readint());

		}
		return result;

	}


	public String ReadDirect(int pos){
		String result=this.readpositionDirect(pos);
		System.out.println(result);
		return result;
	}

	public LogicaWords Charge(int cont){
		return	this.get(cont);

	}
	public void ChargeRegitry(){
		System.out.println("el valor del resitro");
		System.out.println((int)this.sizerecord());
		ArrayLogicaWords= new ArrayList<LogicaWords>();
		for (int i = 0; i <(int)this.sizerecord(); i++){
			ArrayLogicaWords.add(this.Charge(i));
			System.out.println(ArrayLogicaWords.get(i).getName());		
		}
		System.out.println("valor de la ultima posicion del aray");
	}




	public LogicaWords get(int code){
		byte[]name;
		byte[]date;	
		int auxode;
		String auxname = "";
		String fecha = "";
		int score;
		int level;
		auxode=this.readint();
		name=this.readByteSecu(SIZE_RECORD);
		date=this.readByteSecu(SIZE_RECORD);
		score=this.readint();
		level=this.readint();

		for (int i=0; i<SIZE_RECORD; i++) {
			auxname+=(char)name[i];
			fecha+=(char)date[i];
		}

		if(auxode==code){	
			System.out.println(code);
			LogicaWords logicaWords= new LogicaWords(auxode,auxname,fecha,score,level);
			return (logicaWords);
		}

		return null;
	}

	public LogicaWords Search(int code){
		seek(code);
		LogicaWords logica = null;
		int auxode;
		String auxname;
		int score;
		//GregorianCalendar date;
		String fecha="";
		auxode=this.readint();
		auxname=this.readString();
		fecha=this.readString();
		score=this.readint();

		if(auxode==code){	
			System.out.println(code);
			LogicaWords logicaWords= new LogicaWords(code,auxname,fecha,score,0);
			logica=logicaWords;
			return (logicaWords);
		}else{
			logica=null;
		}
		return logica;


	}
	public LogicaWords getdirect(int index) {
		this.seek(index * SIZE_RECORD);
		String fecha;
		byte[] aux = this.readByte(LogicaWords.SIZE_REGISTRY);
		int auxCode  = this.readint();
		int score;
		GregorianCalendar gregorian;
		String auxName = "";
		for (int i = 0; i < aux.length; i++) {
			auxName += (char)aux[i];      
		}
		fecha=this.readString();
		//gregorian=this.Todate();
		score=this.readint();
		return new LogicaWords(auxCode,auxName,fecha,score,0);
	} 

	public void ChangeScore(LogicaWords vehiculo,String mark){
		Scanner sc= new Scanner(System.in);
		System.out.println("Nombre Presona:");
		mark=sc.nextLine();
		System.out.println("la marca que ingreso  es" +"  " +mark);

	}

	/**
	 * ordenamiento por medo de seleccion
	 */

	public  LogicaWords[] sortselection(){
		LogicaWords aux,aux1;
		LogicaWords[]original=null;
		String min="";
		LogicaWords[]result4=null;
		original=new  LogicaWords[(int)this.size()];
		result4=new  LogicaWords[(int)this.size()];
		String temporal=" ";


		for (int i = 0; i < original.length-1; i++) {	
			original[i]=this.getdirect(i);
			result4[i]=this.getdirect(i);
		}
		for (int i = 0; i < (int)this.size()-1; i++) {
			min =this.getdirect(i).getName();	


			for (int j=i+1; j<(int)this.size()-1; j++){
				aux=this.getdirect(i);

				aux1=this.getdirect(j);



				if(aux1.getName().compareTo(aux.getName())<0){

					result4[i]=aux1;
					min =(aux1.getName());	
				}

				if(original[i].getName()!=result4[i].getName()){
					original[i]=original[j];
					original[j]=this.getdirect(i);
				}
			}
		}
		for (int j2 = 0; j2 < original.length-1; j2++){	
		}
		return original;


	}
	public  LogicaWords[] sortburble(){
		System.out.println("si entro");
		LogicaWords aux ,aux1;
		boolean flagchande=false;
		flagchande=false;	
		LogicaWords result[];
		System.out.println("tamaño");
		System.out.println(this.size());
		result= new LogicaWords[(int) size()];
		for (int i = 0; i < result.length-1; i++) {
			result[i]=this.getdirect(i);
		}
		for (int i=(int)size()-1; i>=0; i--){ 
			System.out.println("valor de i");
			System.out.println(i);
			for (int j=0; j<i-1; j++) {
				System.out.println("valor de j");
				System.out.println(j);
				aux=this.getdirect(j);
				aux1=this.getdirect(j+1);
				System.out.println("valor1");
				System.out.println(aux.getName());
				System.out.println("valo2");
				System.out.println(aux1.getName());
				if(aux.getName().compareTo(aux1.getName())>0){
					//System.out.println(i);
					System.out.println("el menor es");
					//System.out.println(aux.getName());
					result[j]=aux1;
					result[j+1]=aux; 
					System.out.println("valor nuevo");
					System.out.println(result[j].getName());
					System.out.println("valor antiguo");
					System.out.println(result[j+1].getName());
				}


			}}

		for (int j2 = 0; j2 < result.length-1; j2++) {
			System.out.println("el valor del vector es:");
			System.out.println(result[j2].getName());
		}
		return result;

	}

	public long sizerecord(){
		return this.size();	
	}

	public long size(){
		//sobre carga de metodos porque se herra de una clase extendia que se herada
		return super.size()/42;


	}

	public ArrayList<LogicaWords> getArrayLogicaWords() {
		return ArrayLogicaWords;
	}


	public int getIdentificador() {
		return Identificador;
	}

	public void setIdentificador(int identificador) {
		Identificador = identificador;
	}

	public void setArrayLogicaWords(ArrayList<LogicaWords> arrayLogicaWords) {
		ArrayLogicaWords = arrayLogicaWords;
	}





}
