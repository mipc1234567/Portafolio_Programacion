package Language;

import UI.JFrameVentanaPrincipal;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.swing.JLabel;
/**
 * Proyeto Teguaneque Productions Universidad Padaggogíca y Tecnologíca de
 * Colombia grupo 5 :
 * @author Caludia Jisell Alba Muñoz
 * @author Sindy Katherine Barón Peña
 * @author Mateo Ivan Peña Cancelado
 * @author Diana Carolina Sanchez Bautista
 * Esta clase nos permite modificar  el lenguaje de la aplicación
 */
public class ManagerLanguage {

    private JFrameVentanaPrincipal ventanprincipal;
    private Global global;
    private JLabel label;
    
    /**
     * Constructor de la clase la cual recibe por parametros una ventana  principal y  
     * una clase que permite acceder a los diferentes idiomas del sistema 
     * @param frame  jframe que genera una ventana principal 
     * @param global de tipo global que es el encargado de cambiar el idioma 
     */

    public ManagerLanguage(JFrameVentanaPrincipal frame, Global global) {
        this.ventanprincipal = frame;
        this.global = global;
    }

    /**
     * Metodo que carga el idioma a la aplicación
     * @param x recibe el valor que identifica el idioma que se desea cambiar
     */
    public void changeLeng(int x) {
        switch (x) {
            case 0:
                this.global.language = ResourceBundle.getBundle("SP");
                Change();                   
                break;

            case 1:
                this.global.language = ResourceBundle.getBundle("EN");
                    Change();                
                break;
            default:
                break;
        }
    }
   
    /**
     * Este metodo busca asigna los cambios a los diferentes componentes da las venteanas
     */
    public void Change()  {
        this.ventanprincipal.setTitle(Global.language.getString("13"));
        this.ventanprincipal.getjButton_agregar_rec().setText(Global.language.getString("2"));
        this.ventanprincipal.getjMenu_archivo().setText(Global.language.getString("1"));
        this.ventanprincipal.getjMenuItem_buscar().setText(Global.language.getString("3"));
        this.ventanprincipal.getjMenuItem_edit().setText(Global.language.getString("4"));
        this.ventanprincipal.getjMenuItem_agregar().setText(Global.language.getString("2"));
        this.ventanprincipal.getjMenuItem_ordenar().setText(Global.language.getString("6"));
        this.ventanprincipal.getjMenuItem_salir().setText(Global.language.getString("7"));
        this.ventanprincipal.getjMenuItem_elim().setText(Global.language.getString("5"));
        this.ventanprincipal.getjMenu_config().setText(Global.language.getString("8"));
        this.ventanprincipal.getjMenuItem_idioma().setText(Global.language.getString("9"));
        this.ventanprincipal.getjMenu_help().setText(Global.language.getString("24"));
        this.ventanprincipal.getjMenuItem_acerca_de().setText(Global.language.getString("12"));
       // this.ventanprincipal.getjMsetNameColummJtable(new String[]{Global.language.getString("15");
          //  Global.language.getString("17"), Global.language.getString("26"),
            //Global.language.getString("25")});
       System.out.println("el nombre del panel es"+ this.ventanprincipal.getjPanel_botones_princ().getName());
            this.ventanprincipal.getjPanel_botones_princ().setName(Global.language.getString("14"));
        System.out.println("ahora el panel es"+ this.ventanprincipal.getjPanel_botones_princ().getName());
       this.ventanprincipal.getjPanel_descripcion_elementos().setName(Global.language.getString("27"));
        //this.ventanprincipal.setNameJpanelDescriptionIngredient(Global.language.getString("16"));
        //this.ventanprincipal.setNameJpanelDescriptionPreparation(Global.language.getString("29"));;
       //this.ventanprincipal.setNameJpanelDescriptionTime(Global.language.getString("28"));
        //this.ventanprincipal.setNameColummJtableRecipe(new String[]{Global.language.getString("15"),
        // Global.language.getString("17")});
        this.ventanprincipal.getParametrosGenerales().setLanguageJComboBox(Global.language.getString("10"), 
        Global.language.getString("11"));
        this.ventanprincipal.getParametrosGenerales().getIdioma().setText(Global.language.getString("9"));
        this.ventanprincipal.getParametrosGenerales().getJButtonGuardar().setText(Global.language.getString("30"));
                
    }

}
