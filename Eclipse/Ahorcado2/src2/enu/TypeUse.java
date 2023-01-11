package enu;

import logica.LogicaWords;
/**
 * @author Mateo Ivan Peña C
 * @version 1.0
 * @Place Universidad Pedagogica y Tecnologica de Colombia
 * juego Ahorcado
 */

public enum TypeUse {

PASSENGER("w"),PARTICULR("r");    

private TypeUse(String  mode){
		mode=mode;
	}

	private static String mode;
	public static String getMode() {
		return mode;
	}

	public static byte[] getModeChar() {
		byte[] aux =  new byte[LogicaWords.SIZE_REGISTRY];
		for (int i = 0; i < getMode().length() && i < LogicaWords.SIZE_REGISTRY; i++) {
			aux[i] = (byte) getMode().charAt(i);
		}
		for (int i = getMode().length(); i < LogicaWords.SIZE_REGISTRY; i++) {
			aux[i] =(byte) ' ';
		}
		return aux;
	}
}
