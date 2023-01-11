package gui;

import javax.swing.JPanel;

public class JPanelWorkArea extends JPanel {
	
private static final String NUMBER_ONE="Primer Numero";
private static final String NUMBER_TWO="Segundo Numero";
private static final String NUMBER_THREE="Resultado";

	
private JPanelnumber panel1;
private JPanelnumber panel2;
private JPanelnumber panel3;


private double valueone;
private double valuetwo;
private double valueresult;

public JPanelWorkArea(int one, int two,  int result){
super();
setValueone(one);
setValuetwo(two);
panel1= new JPanelnumber(NUMBER_ONE,"0.0");
panel2= new JPanelnumber(NUMBER_TWO,"0.0");
panel3= new JPanelnumber(NUMBER_THREE, "0.0");
init();
	
}

public void init(){

this.add(panel1);
this.add(panel2);
this.add(panel3);
	
}


public JPanelnumber getPanel1() {
	return panel1;
}

public void setPanel1(JPanelnumber panel1) {
	this.panel1 = panel1;
}

public JPanelnumber getPanel2() {
	return panel2;
}

public void setPanel2(JPanelnumber panel2) {
	this.panel2 = panel2;
}

public double getValueone() {
	return valueone;
}

public void setValueone(double valueone) {
	this.valueone = valueone;
}

public double getValuetwo() {
	return valuetwo;
}

public void setValuetwo(double valuetwo) {
	this.valuetwo = valuetwo;
}

public double getValueresult() {
	return valueresult;
}

public void setValueresult(double valueresult) {
	this.valueresult = valueresult;
}

}
