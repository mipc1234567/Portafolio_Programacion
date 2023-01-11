package gui;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import utilities.ValidateTextfield;

public class JPanelnumber extends JPanel implements ActionListener,KeyListener{
public static final int NUMBER_WIDTH=10;	
private final static String CALCULATE="CALCULATE";
private JTextField jTextField;
private JLabel label;
private static final String NAME="Parametros";
private double value;
private JFormattedTextField textField;
private JButton botton;
private ValidateTextfield validate;




public JPanelnumber(){
super();
this.jTextField= new JTextField(NUMBER_WIDTH);
this.botton= new JButton("VALIDAR");
init();

}


public JPanelnumber(String label, String text){
super();

this.jTextField= new JTextField(text,NUMBER_WIDTH);
this.label= new JLabel(label, NUMBER_WIDTH);
this.textField = new JFormattedTextField(new Integer(334343434));
this.textField.setFocusLostBehavior(WHEN_IN_FOCUSED_WINDOW);
this.textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
this.textField.setColumns(10);
textField.addKeyListener(new KeyAdapter()
{
   public void keyTyped(KeyEvent e)
   {
      char caracter = e.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         e.consume();  // ignorar el evento de teclado
      }
   }
});

/*this.textField.addFocusListener(new FocusListener() {
	
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		String cadena= textField.getText();
		validate= new ValidateTextfield();
		System.out.println(validate.validate(cadena));
	
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
});*/


setTextField(textField);

textField.addActionListener(new ActionListener()
{

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            textField.commitEdit();
           
           
        } catch (Exception e2)
        {
            e2.printStackTrace();
        }
    }

});
init();
}

private void init(){
setBorder(BorderFactory.createTitledBorder(NAME));
/*this.jTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
this.add(jTextField);
this.add(label);*/
this.add(textField);
}



//-----------METODOS DE ACCION--------------------	
public void actionPerformed1(ActionEvent e) {
if(e.getActionCommand().equals(CALCULATE)){
System.out.println("funciona");
			
		}
							
		}	
		/**
		 * 1º
		 */
		ActionListener actionsButtons1 = new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent a) {
				if(a.getActionCommand().equals(CALCULATE)){
				System.out.println("funciona");
				
				}
				}
			};


public JTextField getjTextField() {
	return jTextField;
}


public void setjTextField(JTextField jTextField) {
	this.jTextField = jTextField;
}



public double getValue() {
	return value;
}


public void setValue(double value) {
	this.value = value;
}


public JFormattedTextField getTextField() {
	return textField;
}


public void setTextField(JFormattedTextField textField) {
	this.textField = textField;
}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}




}


