/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logic.GroupResource;
import logic.ListResource;
import logic.ManagerLogic;
import logic.Recipe;
import logic.Resource;
import logic.TypeResource;
import logic.UnitOfMeasure;

/**
 *
 * Teguaneque Productions Universidad Padaggogíca y Tecnologíca de Colombia
 * grupo 5 :
 *
 * @author Caludia Jisell Alba Muñoz
 * @author Sindy Katherine Barón Peña
 * @author Mateo Ivan Peña Cancelado
 * @author Diana Carolina Sanchez Bautista
 *
 * Clase que controla todas las escuchas de los botones
 */
public class Evento implements ActionListener {
    
    
    private JFrameVentanaPrincipal jframeVentanaPrincipal=null;
    private ManagerLogic manager=null;
    
    /**
     *Contructor de la clase , en el que le entra por parametro una venta principal
     * @param fv ventana principal de la aplicacion
     */
    public Evento(JFrameVentanaPrincipal fv) {
        this.jframeVentanaPrincipal= fv;
        this.manager=fv.getManagerLogic();
    }   

    /**
     * metodo que controla los escuchas de los botones y demás componentes de la aplicacion
     * @param e es la variable que maneja los eventos
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(""+e.getActionCommand());
        switch (e.getActionCommand()){
            case "jMenuItem_acerca_de": JOptionPane.showMessageDialog(jframeVentanaPrincipal, "se asdfasgdf", "Panaderia", 1); break;
            case "jMenuItem_salir": System.exit(0); break;
            case "jButton_abrir_agregar_rec":showTableRecipe(); break;
            case "jButton_agregar_rec":addTableRecetas() ;break;
            case "jButton_agregar_recurso": jframeVentanaPrincipal.getjDialogAddResources().setVisible(true);break;
            case "jButton_guardar_resour":addResources();break;
            default: break;
        }
    }
  
    /**
     *metodo que adiciona recuros en el frame principal
     */
    public void addResources(){
        ArrayList<Resource> list=jframeVentanaPrincipal.getjDialogAddResources().listResource();
        for (int i = 0; i < list.size(); i++) {
            manager.addResource(list.get(i));
        }
        jframeVentanaPrincipal.getjDialogAddResources().setVisible(false);
        jframeVentanaPrincipal.setjDialogAddResources(new JDialogAddResources(jframeVentanaPrincipal, true));
        manager.printResource();
    }
    
    /**
     *metodo que adiciona la tabla de recetas a un jdialog
     */
    public void addTableRecetas(){
//       JDialogAddRecipe mostrarRec = this.jframeVentanaPrincipal.getjDialogAddRecipe();
//        DefaultTableModel tableModel=mostrarRec.getDefaultTableModel();
////        Resource resource=
//        if(tableModel.getRowCount()>=1){
//            ListResource listRes=this.jframeVentanaPrincipal.getControlador().getListResource();
//            for (int i = 0; i < tableModel.getRowCount(); i++) {
//                Resource res=new Resource(tableModel.getValueAt(i, 0).toString(), UnitOfMeasure.CENTIMETERS, TypeResource.ELEMENT);
//                this.jframeVentanaPrincipal.getControlador().getListResource().getResources().add(res);
//            }
//            Recipe reci=new Recipe(null, mostrarRec.getjTextField_name_rec().getText(), mostrarRec.getjTextArea_preparation_recip().getText(),null);
//            this.jframeVentanaPrincipal.getControlador().getListRecipe().addRecipe(reci);
//            resource.get(tableModel);
//            mostrarRec.getjTextField_name_rec().setText(recipe.getName());
//            mostrarRec.getjTextArea_preparation_recip().setText(recipe.getPreparation());
            

            

//        }else {
//           JOptionPane.showMessageDialog(jframeVentanaPrincipal, "Ingrese almenos un recurso  por favor!!");
//       }
//        mostrarRec.setVisible(false);
//        mostrarRec.getjTextArea_preparation_recip().setText("");
//        mostrarRec.getjTextField_name_rec().setText("");
//        for (int i = 0; i < tableModel.getRowCount(); i++) {
//            tableModel.removeRow(i);
//        }
        
        
    }
    
    /**
     *metoddo que muestra la tabla de receta en la pestaña principal
     */
    public void showTableRecipe(){
        
        GroupResource groupResource=manager.getGroupResource();
        DefaultTableModel tab=this.jframeVentanaPrincipal.getjDialogAddRecipe().getDefaultTableModelResource_all();
        
        for (int i = 0; i < tab.getRowCount(); i++) {
            tab.removeRow(i);
        }
        
        for (int i = 0; i < groupResource.size(); i++) {
            Object []obj=new Object[4];
            obj[0]=groupResource.get(i).getId();
            obj[1]=groupResource.get(i).getName();
            obj[3]=groupResource.get(i).getUnitOfMeasure();
            tab.addRow(obj);
        }
        
        this.jframeVentanaPrincipal.getjDialogAddRecipe().setVisible(true);
    }
    
    private int numEditar=0;
    
}
