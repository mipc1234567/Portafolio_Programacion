/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import logic.Resource;
import logic.TypeResource;
import logic.UnitOfMeasure;

/**
 *
 * @author Mateo
 */
public class JDialogAddResources extends javax.swing.JDialog {

    private JFrameVentanaPrincipal parents = null;
    
    
    private DefaultTableModel defaultTableModel;

    /**
     * Creates new form JDialogAddRecipe
     */
    public JDialogAddResources(java.awt.Frame parents, boolean modal) {
        super(parents, modal);
        this.parents = (JFrameVentanaPrincipal) parents;
        initComponents();
        jButton_guardar_resour.setActionCommand("jButton_guardar_resour");
        jButton_guardar_resour.addActionListener(this.parents.getEvento());
        setLocationRelativeTo(null);
        this.defaultTableModel=this.jPanelTableResource2.getDefaultTableModel();
        
    }

    public ArrayList<Resource> listResource(){
        ArrayList<Resource> list=new ArrayList<>();
        String name="";
        UnitOfMeasure measure=null;
        TypeResource resource=null;
        for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
            for (int j = 0; j < defaultTableModel.getColumnCount(); j++) {
                if(j==0){
                    name=defaultTableModel.getValueAt(i, j).toString();
                }else if(j==1){
                    TypeResource typeResource=(TypeResource)defaultTableModel.getValueAt(i, j);
                    resource=typeResource;
                }else if(j==2){
                    UnitOfMeasure uitOfMeasure=(UnitOfMeasure)defaultTableModel.getValueAt(i, j);
                    measure=uitOfMeasure;
                }
            }
            list.add(new Resource(name, measure, resource));
        }
        return list;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_add_rect = new javax.swing.JPanel();
        jLabel_agregar_rec = new javax.swing.JLabel();
        jPanel_resource = new javax.swing.JPanel();
        jButton_Add = new javax.swing.JButton();
        jButton_Remove = new javax.swing.JButton();
        jPanelTableResource2 = new UI.JPanelTableResource();
        jPanel_botones = new javax.swing.JPanel();
        jButton_cancelar_resource = new javax.swing.JButton();
        jButton_guardar_resour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel_agregar_rec.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_agregar_rec.setText("Agregar Recursos");

        javax.swing.GroupLayout jPanel_add_rectLayout = new javax.swing.GroupLayout(jPanel_add_rect);
        jPanel_add_rect.setLayout(jPanel_add_rectLayout);
        jPanel_add_rectLayout.setHorizontalGroup(
            jPanel_add_rectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_add_rectLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_agregar_rec)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_add_rectLayout.setVerticalGroup(
            jPanel_add_rectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_add_rectLayout.createSequentialGroup()
                .addComponent(jLabel_agregar_rec)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel_resource.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recursos", 2, 0));

        jButton_Add.setText("+");
        jButton_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddActionPerformed(evt);
            }
        });

        jButton_Remove.setText("-");
        jButton_Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_resourceLayout = new javax.swing.GroupLayout(jPanel_resource);
        jPanel_resource.setLayout(jPanel_resourceLayout);
        jPanel_resourceLayout.setHorizontalGroup(
            jPanel_resourceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_resourceLayout.createSequentialGroup()
                .addGroup(jPanel_resourceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_resourceLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Remove))
                    .addComponent(jPanelTableResource2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel_resourceLayout.setVerticalGroup(
            jPanel_resourceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_resourceLayout.createSequentialGroup()
                .addComponent(jPanelTableResource2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_resourceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButton_cancelar_resource.setText("Cancelar");
        jButton_cancelar_resource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelar_resourceActionPerformed(evt);
            }
        });

        jButton_guardar_resour.setText("Guardar");

        javax.swing.GroupLayout jPanel_botonesLayout = new javax.swing.GroupLayout(jPanel_botones);
        jPanel_botones.setLayout(jPanel_botonesLayout);
        jPanel_botonesLayout.setHorizontalGroup(
            jPanel_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_botonesLayout.createSequentialGroup()
                .addGap(342, 342, 342)
                .addComponent(jButton_guardar_resour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_cancelar_resource)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_botonesLayout.setVerticalGroup(
            jPanel_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_botonesLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_cancelar_resource)
                    .addComponent(jButton_guardar_resour))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_botones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_resource, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jPanel_add_rect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_add_rect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_resource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel_botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_cancelar_resourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelar_resourceActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton_cancelar_resourceActionPerformed

    private void jButton_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddActionPerformed
        // TODO add your handling code here:
        Object obj[]={"",TypeResource.ELEMENT,UnitOfMeasure.CENTIMETERS};
        this.defaultTableModel.addRow(obj);
    }//GEN-LAST:event_jButton_AddActionPerformed

    private void jButton_RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RemoveActionPerformed
        // TODO add your handling code here:
        int i=this.jPanelTableResource2.getjTable1().getSelectedRow();
        if(i==-1){
            if((defaultTableModel.getRowCount()-1)!=-1){
                defaultTableModel.removeRow(defaultTableModel.getRowCount()-1);
            }
        }else{
            defaultTableModel.removeRow(i);    
        }
    }//GEN-LAST:event_jButton_RemoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Add;
    private javax.swing.JButton jButton_Remove;
    private javax.swing.JButton jButton_cancelar_resource;
    private javax.swing.JButton jButton_guardar_resour;
    private javax.swing.JLabel jLabel_agregar_rec;
    private UI.JPanelTableResource jPanelTableResource2;
    private javax.swing.JPanel jPanel_add_rect;
    private javax.swing.JPanel jPanel_botones;
    private javax.swing.JPanel jPanel_resource;
    // End of variables declaration//GEN-END:variables

    public JFrameVentanaPrincipal getParents() {
        return parents;
    }

    public void setParents(JFrameVentanaPrincipal parents) {
        this.parents = parents;
    }

    public JButton getjButton_cancelar_rec() {
        return jButton_cancelar_resource;
    }

    public void setjButton_cancelar_rec(JButton jButton_cancelar_rec) {
        this.jButton_cancelar_resource = jButton_cancelar_rec;
    }

    public JLabel getjLabel_agregar_rec() {
        return jLabel_agregar_rec;
    }

    public void setjLabel_agregar_rec(JLabel jLabel_agregar_rec) {
        this.jLabel_agregar_rec = jLabel_agregar_rec;
    }

    public JPanel getjPanel_add_rect() {
        return jPanel_add_rect;
    }

    public void setjPanel_add_rect(JPanel jPanel_add_rect) {
        this.jPanel_add_rect = jPanel_add_rect;
    }

    public JPanel getjPanel_botones() {
        return jPanel_botones;
    }

    public void setjPanel_botones(JPanel jPanel_botones) {
        this.jPanel_botones = jPanel_botones;
    }

    public JPanel getjPanel_resource() {
        return jPanel_resource;
    }

    public void setjPanel_resource(JPanel jPanel_resource) {
        this.jPanel_resource = jPanel_resource;
    }

    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }
    
}
