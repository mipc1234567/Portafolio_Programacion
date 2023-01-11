package utilities;

public class ValidateTextfield {

	
	
public ValidateTextfield(){
super();

}

public void init(){
	
}

public boolean validate(String value){	
boolean result=false;
int cont=0;
String number=value;
		int p = 0;
		int val = number.length();
		for (int i = 0; i < number.length(); i++) {
			if(number.charAt(i)>=48&&number.charAt(i)<=57){
			//System.out.println(number.charAt(i));
				p++;
			}
		}
		if(p==val){
			result= true;
			
		}else{
			System.out.println( "Solo números en el espacio del ingreso de datos");
			result=false;
			System.out.println(result);
		}
		return result;

}


}
