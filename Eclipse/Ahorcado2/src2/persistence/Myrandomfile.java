package persistence;

import java.awt.Color;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.GregorianCalendar;
import java.util.RandomAccess;
import java.io.ObjectInputStream;
import logica.LogicaWords;
import enu.FormOpenFile;
import enu.FormSaveFile;

import java.io.ObjectOutputStream;

/**
 * @author Mateo Ivan Peña C
 * @version 1.0
 * @Place Universidad Pedagogica y Tecnologica de Colombia
 */
public class Myrandomfile {
	
	protected File file;
	private RandomAccessFile randomaccesfile;
	private FormOpenFile openfile;
	private FormSaveFile savefile;
	private final int TAM=42;
	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;
	private FileInputStream fileInputStream;
	private FileOutputStream  fileOutputStream;
	
private FileChannel  chanel;
	
	public Myrandomfile(String filename,FormOpenFile formopen){
	this.openfile=formopen;
	file= new File(filename); 
	
	}
	
	
	public Myrandomfile(String filename) {
		// TODO Auto-generated constructor stub
		file= new File(filename); 
	}
	
	public Myrandomfile(String filename, FormSaveFile formsave){
		this.savefile=formsave;
		file=new File(filename);
	}
	
	public boolean open(){
		try {
			randomaccesfile= new RandomAccessFile(file,openfile.getMode());
		return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return false;
		
	}
	
	  public byte[] readByteInt(int length) {
	        byte[] aux = new byte[length];
	        try {
				this.randomaccesfile.readInt();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        /*try {
	            this.randomaccesfile.read(aux, 0, length);
	            return aux;
	        } catch (IOException ex) {*/
	           return null;
	      //  }
	    }

	 public byte[] readByteString(int size) {		 
	        byte[] aux = new byte[size];
	        String result = null;  
	        for (int i = 0; i < aux.length; i++) {
				try {
					aux[i]=randomaccesfile.readByte();
					//System.out.println((char)aux[i]);
				result+=(char)aux[i]+" ";
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	        System.out.println(result);
	        // this.randomaccesfile.read(aux,0,15);
	         return aux;
			}
	 
	 public byte[] readByteDouble(int size) {		 
	        byte[] aux = new byte[size];
	        String result = null;  
	        try {
				double va=randomaccesfile.readDouble();
				System.out.println(va);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	  
	        // this.randomaccesfile.read(aux,0,15);
	         return aux;
			}
	 
	 public byte[] readByteSecu(int size) {		 
	        byte[] aux = new byte[size];
	        String result = "";  
	       /* try {
				int va=randomaccesfile.readInt();
				System.out.println(va);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
	        for (int i = 0; i <aux.length; i++) {
				try {
					
					aux[i]=randomaccesfile.readByte();
					//System.out.println((char)aux[i]);
				result+=(char)aux[i]+" ";
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	        /*for (int i = 0; i < aux.length; i++) {
				try {
					aux[i]=randomaccesfile.readByte();
					//System.out.println((char)aux[i]);
				result+=(char)aux[i]+" ";
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
	   /*     try {
				int va=randomaccesfile.readInt();
				System.out.println(va);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
	       System.out.println(result);
	        // this.randomaccesfile.read(aux,0,15);
	         return aux;
			}
	 
	 
	 
	 public String readByteSecuString(int size) {		 
	        byte[] aux = new byte[size];
	        String result = "";  
	       /* try {
				int va=randomaccesfile.readInt();
				System.out.println(va);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
	        for (int i = 0; i <aux.length; i++) {
				try {
					
					aux[i]=randomaccesfile.readByte();
					//System.out.println((char)aux[i]);
				result+=(char)aux[i]+" ";
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	        /*for (int i = 0; i < aux.length; i++) {
				try {
					aux[i]=randomaccesfile.readByte();
					//System.out.println((char)aux[i]);
				result+=(char)aux[i]+" ";
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
	   /*     try {
				int va=randomaccesfile.readInt();
				System.out.println(va);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
	       System.out.println(result);
	        // this.randomaccesfile.read(aux,0,15);
	         return result;
			}
	
	 
	 public byte[] readByte(int length) {
	        byte[] aux = new byte[length];
	        try {
				this.randomaccesfile.readInt();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
	            this.randomaccesfile.read(aux, 0, length);
	            return aux;
	        } catch (IOException ex) {
	           return null;
	        }
	    }
	 

public boolean close(){
	try {
		this.randomaccesfile.close();
		return true;
	
		
	} catch ( IOException e) {
		// TODO Auto-generated catch block
		return false;
	}			
	
	
}




public boolean write(int value){
	try {
	
		this.randomaccesfile.writeInt(value);
		return true;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

		return false;
	}
	
	
	
}

public boolean write1( int value,String valor){
	try {
	
		this.randomaccesfile.writeInt(value);
		this.randomaccesfile.writeUTF(valor);
		return true;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

		return false;
	}
	
	
	
}
public boolean writeString(String value){
	try {
		this.randomaccesfile.writeUTF(value);
		return true;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

		return false;
	}
	
	
	
}

public boolean write(byte[] value) {
    try {
        this.randomaccesfile.write(value);
        return true;
    } catch (IOException ex) {
        return false;
    }
}


public void writePosInt(int pos,LogicaWords v){
	if(randomaccesfile!=null){
		try {
		long s=((pos)*TAM);
		System.out.println("la posicion s");
		System.out.println(s);
		this.randomaccesfile.seek(s);
		this.randomaccesfile.writeInt(v.getIdentificador());
		this.randomaccesfile.write(v.getNameChar());
        this.randomaccesfile.write(v.getDateChar());
    	this.randomaccesfile.writeInt(v.getPuntaje());
    	this.randomaccesfile.writeInt(v.getLevel());
			//this.openFileObjet();
			//this.put(v.getFecha_juego());
			//this.closefileObject();

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}






public String readpositionDirect(int pos){
	int valor=0;
	int puntaje=0;
	String nombre="";
	//GregorianCalendar gregorianCalendar;
	String fecha="";
	String total="";
	
	if(randomaccesfile!=null){
		try {
			long n=((pos-1)*TAM);
			long x=361-(361-pos);
			//this.randomaccesfile.seek((pos-1)*361);
			this.randomaccesfile.seek(x);
			System.out.println("el valor de la posicion con el archivo:");
			System.out.println(x);
		    valor=this.readint();
            nombre=this.readString();
//			gregorianCalendar=this.Todate();
            fecha= this.readString();
			puntaje=this.readint();
			total+=valor+" "+nombre+" "+fecha+puntaje;
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
	return total;
}





public boolean writeDouble(double value){
	try {
		this.randomaccesfile.writeDouble(value);
		return true;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}

public long size(){
return  this.file.length();
}


public int readint(){
	try {
		return this.randomaccesfile.readInt();
	
	} catch (Exception e) {
		// TODO: handle exception
return 0;
	}
	
}

public double readdouble(){
	try {
		return this.randomaccesfile.readDouble();
	
	} catch (Exception e) {
		// TODO: handle exception
		return 0;
	}
	
}

public String readString(){
	try {

		return this.randomaccesfile.readUTF();
	
	} catch (Exception e) {
		// TODO: handle exception
		return null;
	}
	
}
public boolean seek(long pos){
	try {
		this.randomaccesfile.seek(pos);
		return true;
		//return true;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
	
}

public GregorianCalendar Todate(){
try {

return (GregorianCalendar)objectInputStream.readObject();

} catch (FileNotFoundException e) {
System.out.println("el archivo no existe");		
} catch (Exception e1) {
System.out.println(e1);
System.out.println("hay un error");
// TODO: handle exception
}
return null;	
}


public GregorianCalendar put(GregorianCalendar gregorianCalendar){
	System.out.println(gregorianCalendar.SATURDAY);
try{
objectOutputStream.writeObject(gregorianCalendar);	
return gregorianCalendar;
}catch(IOException s){
System.out.println("no se puede escribir");
return null;
}
}

public int getTAM() {
	return TAM;
}


public boolean openFileObjet(){
try{
	//el orden de cracion es estricto
fileOutputStream= new FileOutputStream(file);
fileInputStream= new FileInputStream(file);
objectOutputStream= new  ObjectOutputStream(fileOutputStream);
objectInputStream= new ObjectInputStream(fileInputStream);

}catch(FileNotFoundException ex){
return false;
}catch(IOException c){
return false;
}
return false;
}



public boolean closefileObject(){
try {
	fileInputStream.close();
		fileOutputStream.close();
		objectOutputStream.close();
		objectInputStream.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	return false;
	
}
public boolean openObject1(){
try{
//el orden de cracion es estricto
fileInputStream= new FileInputStream(file);
objectInputStream= new ObjectInputStream(fileInputStream);
}catch(FileNotFoundException ex){
	return false;
}catch(IOException c){
	return false;

}
return false;
}


public RandomAccessFile getRandomaccesfile() {
	return randomaccesfile;
}


public void setRandomaccesfile(RandomAccessFile randomaccesfile) {
	this.randomaccesfile = randomaccesfile;
}


}