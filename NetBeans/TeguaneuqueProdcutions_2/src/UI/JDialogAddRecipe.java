/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import logic.TypeResource;
import logic.UnitOfMeasure;

/**
 *
 * @author Mateo
 */
public class JDialogAddRecipe extends javax.swing.JDialog {

    private JFrameVentanaPrincipal parents = null;
    
    private DefaultTableModel defaultTableModelResource_all;
    private DefaultTableModel defaultTableModelResource_select;
    private boolean DEBUG = false;
    private boolean ALLOW_COLUMN_SELECTION = false;
    private boolean ALLOW_ROW_SELECTION = true;
    
    /**
     * Creates new form JDialogAddRecipe
     */
    public JDialogAddRecipe(java.awt.Frame parents, boolean modal) {
        super(parents, modal);
        this.parents = (JFrameVentanaPrincipal) parents;
        initComponents();
        
        jTable_resource_all.setFillsViewportHeight(true);

        jTable_resource_all.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (ALLOW_ROW_SELECTION) { // true by default
            ListSelectionModel rowSM = jTable_resource_all.getSelectionModel();
            rowSM.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    //Ignore extra messages.
                    if (e.getValueIsAdjusting()) return;

                    ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                    if (lsm.isSelectionEmpty()) {
                        System.out.println("No rows are selected.");
                    } else {
                        int selectedRow = lsm.getMinSelectionIndex();
                        System.out.println("Row " + selectedRow
                                           + " is now selected.");
                    }
                }
            });
        } else {
            jTable_resource_all.setRowSelectionAllowed(false);
        }

        if (ALLOW_COLUMN_SELECTION) { // false by default
            if (ALLOW_ROW_SELECTION) {
                //We allow both row and column selection, which
                //implies that we *really* want to allow individual
                //cell selection.
                jTable_resource_all.setCellSelectionEnabled(true);
            }
            jTable_resource_all.setColumnSelectionAllowed(true);
            ListSelectionModel colSM =
                jTable_resource_all.getColumnModel().getSelectionModel();
            colSM.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    //Ignore extra messages.
                    if (e.getValueIsAdjusting()) return;

                    ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                    if (lsm.isSelectionEmpty()) {
                        System.out.println("No columns are selected.");
                    } else {
                        int selectedCol = lsm.getMinSelectionIndex();
                        System.out.println("Column " + selectedCol
                                           + " is now selected.");
                    }
                }
            });
        }

        if (DEBUG) {
            jTable_resource_all.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
//                    printDebugData(jTable_resource_all);
                }
            });
        }

        
        setLocationRelativeTo(null);
        this.defaultTableModelResource_all=(DefaultTableModel)this.jTable_resource_all.getModel();
        this.defaultTableModelResource_select=(DefaultTableModel)this.jTable_resource_select.getModel();

        jButton_guarda_rec.addActionListener(this.parents.getEvento());
        jButton_guarda_rec.setActionCommand("jButton_agregar_rec");
        jButton_agregar_recurso.addActionListener(this.parents.getEvento());
        jButton_agregar_recurso.setActionCommand("jButton_agregar_recurso");
        
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_add_rect = new javax.swing.JPanel();
        jLabel_agregar_rec = new javax.swing.JLabel();
        jLabel_name_recip = new javax.swing.JLabel();
        jTextField_name_rec = new javax.swing.JTextField();
        jLabel_preparation_rec = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_preparation_recip = new javax.swing.JTextArea();
        jPanel_resource = new javax.swing.JPanel();
        jButton_Add = new javax.swing.JButton();
        jButton_Remove = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_resource_all = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_resource_select = new javax.swing.JTable();
        jLabel_lsita_todos_recursos = new javax.swing.JLabel();
        jLabel_lista_recursos_seleccionados = new javax.swing.JLabel();
        jButton_agregar_recurso = new javax.swing.JButton();
        jPanel_botones = new javax.swing.JPanel();
        jButton_guarda_rec = new javax.swing.JButton();
        jButton_cancelar_rec = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel_agregar_rec.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_agregar_rec.setText("Agregar Receta");

        jLabel_name_recip.setText("Nombre:");

        jLabel_preparation_rec.setText("Preparacion:");

        jTextArea_preparation_recip.setColumns(20);
        jTextArea_preparation_recip.setRows(5);
        jScrollPane1.setViewportView(jTextArea_preparation_recip);

        javax.swing.GroupLayout jPanel_add_rectLayout = new javax.swing.GroupLayout(jPanel_add_rect);
        jPanel_add_rect.setLayout(jPanel_add_rectLayout);
        jPanel_add_rectLayout.setHorizontalGroup(
            jPanel_add_rectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_add_rectLayout.createSequentialGroup()
                .addGroup(jPanel_add_rectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel_add_rectLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel_agregar_rec)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_add_rectLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel_add_rectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_preparation_rec)
                            .addGroup(jPanel_add_rectLayout.createSequentialGroup()
                                .addComponent(jLabel_name_recip)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_name_rec, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_add_rectLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel_add_rectLayout.setVerticalGroup(
            jPanel_add_rectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_add_rectLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_agregar_rec)
                .addGap(18, 18, 18)
                .addGroup(jPanel_add_rectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_name_recip)
                    .addComponent(jTextField_name_rec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel_preparation_rec)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addContainerGap())
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

        jTable_resource_all.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Numero", "Nombre", "Cantidad", "Unidad De Medida"
            }
        ));
        jScrollPane2.setViewportView(jTable_resource_all);

        jTable_resource_select.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Numero", "Nombre", "Cantidad", "Unidad De Medida"
            }
        ));
        jScrollPane3.setViewportView(jTable_resource_select);

        jLabel_lsita_todos_recursos.setText("Lista de recursos");

        jLabel_lista_recursos_seleccionados.setText("Lista de recursos seleccionados para la receta");

        jButton_agregar_recurso.setText("Crear Recurso");

        javax.swing.GroupLayout jPanel_resourceLayout = new javax.swing.GroupLayout(jPanel_resource);
        jPanel_resource.setLayout(jPanel_resourceLayout);
        jPanel_resourceLayout.setHorizontalGroup(
            jPanel_resourceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_resourceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_resourceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_resourceLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton_agregar_recurso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Remove)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_resourceLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_lista_recursos_seleccionados)
                .addGap(153, 153, 153))
            .addGroup(jPanel_resourceLayout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(jLabel_lsita_todos_recursos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_resourceLayout.setVerticalGroup(
            jPanel_resourceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_resourceLayout.createSequentialGroup()
                .addComponent(jLabel_lsita_todos_recursos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_lista_recursos_seleccionados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_resourceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_agregar_recurso)))
        );

        jButton_guarda_rec.setText("Guardar");

        jButton_cancelar_rec.setText("Cancelar");
        jButton_cancelar_rec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelar_recActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_botonesLayout = new javax.swing.GroupLayout(jPanel_botones);
        jPanel_botones.setLayout(jPanel_botonesLayout);
        jPanel_botonesLayout.setHorizontalGroup(
            jPanel_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_botonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_guarda_rec)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_cancelar_rec)
                .addContainerGap())
        );
        jPanel_botonesLayout.setVerticalGroup(
            jPanel_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_botonesLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_guarda_rec)
                    .addComponent(jButton_cancelar_rec))
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel_add_rect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel_resource, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_add_rect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_resource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel_botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_cancelar_recActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelar_recActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        this.jTextArea_preparation_recip.setText("");
        this.jTextField_name_rec.setText("");
    }//GEN-LAST:event_jButton_cancelar_recActionPerformed

    private void jButton_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddActionPerformed
        // TODO add your handling code here:
        int i=jTable_resource_all.getSelectedRow();
        Object []obj=new Object[4];
                    obj[0]=defaultTableModelResource_all.getValueAt(i, 0);
                    obj[1]=defaultTableModelResource_all.getValueAt(i, 1);
                    obj[3]=defaultTableModelResource_all.getValueAt(i, 3);
            this.defaultTableModelResource_select.addRow(obj);
    }//GEN-LAST:event_jButton_AddActionPerformed

    private void jButton_RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RemoveActionPerformed
        // TODO add your handling code here:
        int []ident=jTable_resource_select.getSelectedRows();
        if(ident.length>1){
            for (int i = 0; i < ident.length; i++) {
                System.out.println("asdfadf"+(ident[i]-1));
//                ident=jTable_resource_select.getSelectedRows();
                  defaultTableModelResource_select.removeRow(ident[i]-1);
            }
        }else{
            if((defaultTableModelResource_select.getRowCount()-1)!=-1){
                defaultTableModelResource_select.removeRow(defaultTableModelResource_select.getRowCount()-1);
            }
        }
    }//GEN-LAST:event_jButton_RemoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Add;
    private javax.swing.JButton jButton_Remove;
    private javax.swing.JButton jButton_agregar_recurso;
    private javax.swing.JButton jButton_cancelar_rec;
    private javax.swing.JButton jButton_guarda_rec;
    private javax.swing.JLabel jLabel_agregar_rec;
    private javax.swing.JLabel jLabel_lista_recursos_seleccionados;
    private javax.swing.JLabel jLabel_lsita_todos_recursos;
    private javax.swing.JLabel jLabel_name_recip;
    private javax.swing.JLabel jLabel_preparation_rec;
    private javax.swing.JPanel jPanel_add_rect;
    private javax.swing.JPanel jPanel_botones;
    private javax.swing.JPanel jPanel_resource;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable_resource_all;
    private javax.swing.JTable jTable_resource_select;
    private javax.swing.JTextArea jTextArea_preparation_recip;
    private javax.swing.JTextField jTextField_name_rec;
    // End of variables declaration//GEN-END:variables

    public JFrameVentanaPrincipal getParents() {
        return parents;
    }

    public void setParents(JFrameVentanaPrincipal parents) {
        this.parents = parents;
    }

    public JButton getjButton_cancelar_rec() {
        return jButton_cancelar_rec;
    }

    public void setjButton_cancelar_rec(JButton jButton_cancelar_rec) {
        this.jButton_cancelar_rec = jButton_cancelar_rec;
    }

    public JButton getjButton_guarda_rec() {
        return jButton_guarda_rec;
    }

    public void setjButton_guarda_rec(JButton jButton_guarda_rec) {
        this.jButton_guarda_rec = jButton_guarda_rec;
    }

    public JLabel getjLabel_agregar_rec() {
        return jLabel_agregar_rec;
    }

    public void setjLabel_agregar_rec(JLabel jLabel_agregar_rec) {
        this.jLabel_agregar_rec = jLabel_agregar_rec;
    }

    public JLabel getjLabel_name_recip() {
        return jLabel_name_recip;
    }

    public void setjLabel_name_recip(JLabel jLabel_name_recip) {
        this.jLabel_name_recip = jLabel_name_recip;
    }

    public JLabel getjLabel_preparation_rec() {
        return jLabel_preparation_rec;
    }

    public void setjLabel_preparation_rec(JLabel jLabel_preparation_rec) {
        this.jLabel_preparation_rec = jLabel_preparation_rec;
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

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTextArea getjTextArea_preparation_recip() {
        return jTextArea_preparation_recip;
    }

    public void setjTextArea_preparation_recip(JTextArea jTextArea_preparation_recip) {
        this.jTextArea_preparation_recip = jTextArea_preparation_recip;
    }

    public JTextField getjTextField_name_rec() {
        return jTextField_name_rec;
    }

    public void setjTextField_name_rec(JTextField jTextField_name_rec) {
        this.jTextField_name_rec = jTextField_name_rec;
    }

    public DefaultTableModel getDefaultTableModelResource_all() {
        return defaultTableModelResource_all;
    }

    public DefaultTableModel getDefaultTableModelResource_select() {
        return defaultTableModelResource_select;
    }

}
