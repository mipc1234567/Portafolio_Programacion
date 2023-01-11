package gui;

import java.awt.Color;
import java.lang.reflect.Constructor;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JpanelStatusBarMajorNumber extends JPanel{
	private JLabel jlabelMessage;
	
public 	JpanelStatusBarMajorNumber(){
	super();
	this.jlabelMessage=new JLabel("Aplicacion de numeros");
	this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	
}
public void init(){
	this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	
}

public void setMessage(String menssage){
	jlabelMessage.setText(menssage);	
}

}
