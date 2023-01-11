package Language;

import UI.JFrameVentanaPrincipal;
import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Proyeto Teguaneque Productions Universidad Padaggogíca y Tecnologíca de
 * Colombia grupo 5 :
 *
 * @author Caludia Jisell Alba Muñoz
 * @author Sindy Katherine Barón Peña
 * @author Mateo Ivan Peña Cancelado
 * @author Diana Carolina Sanchez Bautista
 *
 * Esta clase es la encargada de cargar el idioma a la aplicación
 */
public class ParametrosGenerales extends JFrame {

    static final String CALCULATE = "calculate";
    private JLabel idioma;
    private JButton JButtonGuardar;
    private JComboBox combobox;
    private int cont = 0;
    private Global global;
    private ManagerLanguage managerlanguage;
    private JFrameVentanaPrincipal ventana;

    /**
     * Constructor de la clase, le entra como prametro una ventana principal
     *
     * @param interfaz esta es la ventana en la que se visualiza la aplicaion
     */
    public ParametrosGenerales(JFrameVentanaPrincipal interfaz) {
        setSize(270, 200);
        setTitle("Administador de lenguaje");
        setLayout(null);
        setResizable(false);
        this.setLocationRelativeTo(null);
        this.ventana = interfaz;

        idioma = new JLabel("Idioma:");
        idioma.setBounds(20, 10, 100, 30);
        add(idioma);

        combobox = new JComboBox();
        combobox.setBounds(100, 10, 120, 30);
        combobox.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        combobox.setActionCommand(CALCULATE);
        char n = '\u00f1';
        combobox.addItem("Espa" + n + "ol");
        combobox.addItem("Ingles");
        combobox.addActionListener(actionsCombo2);
        add(combobox);

        JButtonGuardar = new JButton("Guardar");
        JButtonGuardar.setActionCommand(CALCULATE);
        JButtonGuardar.addActionListener(actionsButtons1);
        JButtonGuardar.setBounds(120, 70, 100, 30);
        add(JButtonGuardar);
    }
    
    ActionListener actionsCombo2 = new ActionListener() {
        /**
     * metodo que escucha los eventod de los idiomas
     * @param a variable encargada de escuchar los eventos de los botones
     */
        public void actionPerformed(ActionEvent a) {
            //;		
            switch (combobox.getSelectedIndex()) {
                case 0:
                    cont = 0;
                    break;
                case 1:
                    cont = 1;
                    System.out.println(cont);
                    break;

                default:
                    break;
            }

        }
    ;
    };
		
  
    ActionListener actionsButtons1 = new ActionListener() {
        /**
         * metodo que escucha los eventod de los idiomas
         *
         * @param a variable encargada de escuchar los eventos de los botones
         */
        public void actionPerformed(ActionEvent a) {
            if (a.getActionCommand().equals(CALCULATE)) {

                System.out.println(cont);
                managerlanguage = new ManagerLanguage(ventana, global);
                switch (cont) {
                    case 0:
                        managerlanguage.changeLeng(cont);
                        setVisible(false);
                        break;

                    case 1:
                        managerlanguage.changeLeng(cont);
                        setVisible(false);
                        break;

                    default:
                        break;
                }
            };
        }
    };

    /**
     * obtiene un boton que guarda los cambios del idioma
     * @return retorna el boton que permite guardar los cambios de preferencia del idioma
     */
    public JButton getJButtonGuardar() {
        return JButtonGuardar;
    }


    /**
     * Metodo que nos da el combo box de los idiomas a cambiar
     * @return el combo box de los idiomas disponibles
     */
    public JComboBox getCombobox() {
        return combobox;
    }

    /**
     * Este metodo retorna el label que señala el las opciones existentes de idioma
     * @return el jlabel de que señala los idiomas
     */
    public JLabel getIdioma() {
        return idioma;
    }


    /**
     * este metodo permite reemplazar los item del combo de isiomas disponobles
     * @param language1 es el primer idioma disponoble siendo el español
     * @param language2 es el segundo idioma disponoble siendo el ingles
     */
    public void setLanguageJComboBox(String language1, String language2) {
        combobox.removeAllItems();
        combobox.addItem(language1);
        combobox.addItem(language2);
    }

}
