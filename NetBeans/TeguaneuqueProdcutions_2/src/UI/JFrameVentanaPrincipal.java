/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Language.ParametrosGenerales;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import logic.Controller;
import logic.ManagerLogic;
import logic.Order;
import logic.Recipe;

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
 * Clase que  crea la ventana principal de la aplicación
 */
public class JFrameVentanaPrincipal extends javax.swing.JFrame implements ActionListener {

    private ManagerLogic managerLogic;
    private Evento evento = null;
    private JDialogAddResources jDialogAddResources = null;

    private ParametrosGenerales parametrosGenerales;
    private static final String Calculate = "calculate";
    private int cont;
    private JDialogAddRecipe jDialogAddRecipe = null;
    private DefaultTableModel modelListRecipe = null;
    private Controller controlador = null;

    /**
     *constructor de la clase, en la que se inicializan unos atributos
     */

    public JFrameVentanaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);//centrar ventana
        managerLogic = new ManagerLogic();
        this.evento = new Evento(this);
        jDialogAddResources = new JDialogAddResources(this, true);

        this.controlador = new Controller();

        this.jDialogAddRecipe = new JDialogAddRecipe(this, true);

        jMenuItem_idioma.setActionCommand(Calculate);
        jMenuItem_idioma.addActionListener(actionsButtons1);
        parametrosGenerales = new ParametrosGenerales(this);

        jMenuItem_acerca_de.addActionListener(evento);
        jMenuItem_acerca_de.setActionCommand("jMenuItem_acerca_de");

        jButton_abrir_agregar_rec.addActionListener(evento);
        jButton_abrir_agregar_rec.setActionCommand("jButton_abrir_agregar_rec");

        jButton_agregar_recurso.addActionListener(evento);
        jButton_agregar_recurso.setActionCommand("jButton_agregar_recurso");

        modelListRecipe = (DefaultTableModel) jTable_recetas.getModel();

    }

    /**
     *metodo que carga en la ventana la tabla de recetas
     */
    public void cargarTableRecipe() {
        ArrayList<Recipe> list = this.controlador.getListRecipe().getListRecipes();
        for (int i = 0; i < modelListRecipe.getRowCount(); i++) {
            modelListRecipe.removeRow(i);
        }
        Object[] dato = new Object[modelListRecipe.getColumnCount()];
        for (int i = 0; i < list.size(); i++) {
            dato[1] = list.get(i).getName();
            modelListRecipe.addRow(dato);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_recetas = new javax.swing.JTable();
        jPanel_img_ingredientes = new javax.swing.JPanel();
        jPanel_descripcion_elementos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_descripcion_elementos = new javax.swing.JTable();
        jPanel_descripcion_recet = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_descrp_ingredientes = new javax.swing.JTable();
        jPanel_descripcion_tiempo = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_descripcion_tiempos = new javax.swing.JTable();
        jPanel_preparacion = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea_preparacion = new javax.swing.JTextArea();
        jPanel_botones_princ = new javax.swing.JPanel();
        jButton_abrir_agregar_rec = new javax.swing.JButton();
        jButton_agregar_recurso = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_archivo = new javax.swing.JMenu();
        jMenuItem_agregar = new javax.swing.JMenuItem();
        jMenuItem_buscar = new javax.swing.JMenuItem();
        jMenuItem_edit = new javax.swing.JMenuItem();
        jMenuItem_elim = new javax.swing.JMenuItem();
        jMenuItem_ordenar = new javax.swing.JMenuItem();
        jMenuItem_salir = new javax.swing.JMenuItem();
        jMenu_config = new javax.swing.JMenu();
        jMenuItem_idioma = new javax.swing.JMenuItem();
        jMenu_Ayuda = new javax.swing.JMenu();
        jMenuItem_acerca_de = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setText("jTextField1");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recetas", 2, 0));

        jTable_recetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Numero", "Nombre De La Receta"
            }
        ));
        jScrollPane1.setViewportView(jTable_recetas);

        jPanel_img_ingredientes.setBorder(new javax.swing.border.SoftBevelBorder(0));

        javax.swing.GroupLayout jPanel_img_ingredientesLayout = new javax.swing.GroupLayout(jPanel_img_ingredientes);
        jPanel_img_ingredientes.setLayout(jPanel_img_ingredientesLayout);
        jPanel_img_ingredientesLayout.setHorizontalGroup(
            jPanel_img_ingredientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel_img_ingredientesLayout.setVerticalGroup(
            jPanel_img_ingredientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
            .addComponent(jPanel_img_ingredientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel_img_ingredientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel_descripcion_elementos.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripcion De Elementos"));

        jTable_descripcion_elementos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Número", "Nombre", "Cantidad", "Unidad De Medida"
            }
        ));
        jScrollPane3.setViewportView(jTable_descripcion_elementos);

        javax.swing.GroupLayout jPanel_descripcion_elementosLayout = new javax.swing.GroupLayout(jPanel_descripcion_elementos);
        jPanel_descripcion_elementos.setLayout(jPanel_descripcion_elementosLayout);
        jPanel_descripcion_elementosLayout.setHorizontalGroup(
            jPanel_descripcion_elementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_descripcion_elementosLayout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel_descripcion_elementosLayout.setVerticalGroup(
            jPanel_descripcion_elementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_descripcion_elementosLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel_descripcion_recet.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripcion De Los Ingredientes", 2, 0));

        jTable_descrp_ingredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Número", "Nombre", "Cantidad", "Unidad De Medida"
            }
        ));
        jScrollPane2.setViewportView(jTable_descrp_ingredientes);

        javax.swing.GroupLayout jPanel_descripcion_recetLayout = new javax.swing.GroupLayout(jPanel_descripcion_recet);
        jPanel_descripcion_recet.setLayout(jPanel_descripcion_recetLayout);
        jPanel_descripcion_recetLayout.setHorizontalGroup(
            jPanel_descripcion_recetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_descripcion_recetLayout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel_descripcion_recetLayout.setVerticalGroup(
            jPanel_descripcion_recetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
        );

        jPanel_descripcion_tiempo.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripción De Tiempos"));

        jTable_descripcion_tiempos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Número", "Nombre", "Cantidad", "Unidad De Medida"
            }
        ));
        jScrollPane4.setViewportView(jTable_descripcion_tiempos);

        javax.swing.GroupLayout jPanel_descripcion_tiempoLayout = new javax.swing.GroupLayout(jPanel_descripcion_tiempo);
        jPanel_descripcion_tiempo.setLayout(jPanel_descripcion_tiempoLayout);
        jPanel_descripcion_tiempoLayout.setHorizontalGroup(
            jPanel_descripcion_tiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_descripcion_tiempoLayout.createSequentialGroup()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel_descripcion_tiempoLayout.setVerticalGroup(
            jPanel_descripcion_tiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_descripcion_tiempoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel_preparacion.setBorder(javax.swing.BorderFactory.createTitledBorder("Preparación"));

        jTextArea_preparacion.setColumns(20);
        jTextArea_preparacion.setRows(5);
        jScrollPane5.setViewportView(jTextArea_preparacion);

        javax.swing.GroupLayout jPanel_preparacionLayout = new javax.swing.GroupLayout(jPanel_preparacion);
        jPanel_preparacion.setLayout(jPanel_preparacionLayout);
        jPanel_preparacionLayout.setHorizontalGroup(
            jPanel_preparacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_preparacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel_preparacionLayout.setVerticalGroup(
            jPanel_preparacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_preparacionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel_botones_princ.setBorder(new javax.swing.border.SoftBevelBorder(0));

        jButton_abrir_agregar_rec.setText("Agregar Receta");
        jButton_abrir_agregar_rec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_abrir_agregar_recActionPerformed(evt);
            }
        });

        jButton_agregar_recurso.setText("Agregar Recurso");

        javax.swing.GroupLayout jPanel_botones_princLayout = new javax.swing.GroupLayout(jPanel_botones_princ);
        jPanel_botones_princ.setLayout(jPanel_botones_princLayout);
        jPanel_botones_princLayout.setHorizontalGroup(
            jPanel_botones_princLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_botones_princLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_botones_princLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_agregar_recurso, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_abrir_agregar_rec, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
        );
        jPanel_botones_princLayout.setVerticalGroup(
            jPanel_botones_princLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_botones_princLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButton_abrir_agregar_rec, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_agregar_recurso, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu_archivo.setText("Archivo");

        jMenuItem_agregar.setText("Agregar");
        jMenu_archivo.add(jMenuItem_agregar);

        jMenuItem_buscar.setText("Buscar");
        jMenu_archivo.add(jMenuItem_buscar);

        jMenuItem_edit.setText("Editar");
        jMenuItem_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_editActionPerformed(evt);
            }
        });
        jMenu_archivo.add(jMenuItem_edit);

        jMenuItem_elim.setText("Eliminar");
        jMenu_archivo.add(jMenuItem_elim);

        jMenuItem_ordenar.setText("Ordenar");
        jMenuItem_ordenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ordenarActionPerformed(evt);
            }
        });
        jMenu_archivo.add(jMenuItem_ordenar);

        jMenuItem_salir.setText("Salir");
        jMenuItem_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_salirActionPerformed(evt);
            }
        });
        jMenu_archivo.add(jMenuItem_salir);

        jMenuBar1.add(jMenu_archivo);

        jMenu_config.setText("Configuracion");

        jMenuItem_idioma.setText("Idioma");
        jMenu_config.add(jMenuItem_idioma);

        jMenuBar1.add(jMenu_config);

        jMenu_Ayuda.setText("Ayuda");

        jMenuItem_acerca_de.setText("Acerca De");
        jMenu_Ayuda.add(jMenuItem_acerca_de);

        jMenuBar1.add(jMenu_Ayuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel_botones_princ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel_descripcion_tiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel_descripcion_recet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel_descripcion_elementos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel_preparacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel_descripcion_recet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel_descripcion_elementos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel_descripcion_tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel_preparacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel_botones_princ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel_descripcion_elementos.getAccessibleContext().setAccessibleDescription("");
        jPanel_descripcion_tiempo.getAccessibleContext().setAccessibleName("Descripcion De Elementos");

        getAccessibleContext().setAccessibleName("Recetas");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_editActionPerformed

    }//GEN-LAST:event_jMenuItem_editActionPerformed

    private void jMenuItem_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_salirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem_salirActionPerformed

    private void jMenuItem_ordenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ordenarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem_ordenarActionPerformed

    private void jButton_abrir_agregar_recActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_abrir_agregar_recActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_abrir_agregar_recActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton_abrir_agregar_rec;
    private javax.swing.JButton jButton_agregar_recurso;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem_acerca_de;
    private javax.swing.JMenuItem jMenuItem_agregar;
    private javax.swing.JMenuItem jMenuItem_buscar;
    private javax.swing.JMenuItem jMenuItem_edit;
    private javax.swing.JMenuItem jMenuItem_elim;
    private javax.swing.JMenuItem jMenuItem_idioma;
    private javax.swing.JMenuItem jMenuItem_ordenar;
    private javax.swing.JMenuItem jMenuItem_salir;
    private javax.swing.JMenu jMenu_Ayuda;
    private javax.swing.JMenu jMenu_archivo;
    private javax.swing.JMenu jMenu_config;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_botones_princ;
    private javax.swing.JPanel jPanel_descripcion_elementos;
    private javax.swing.JPanel jPanel_descripcion_recet;
    private javax.swing.JPanel jPanel_descripcion_tiempo;
    private javax.swing.JPanel jPanel_img_ingredientes;
    private javax.swing.JPanel jPanel_preparacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable_descripcion_elementos;
    private javax.swing.JTable jTable_descripcion_tiempos;
    private javax.swing.JTable jTable_descrp_ingredientes;
    private javax.swing.JTable jTable_recetas;
    private javax.swing.JTextArea jTextArea_preparacion;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    /**
     *metodo que obtiene un evento
     * @return  retorna un evento
     */
    public Evento getEvento() {
        return evento;
    }

    /**
     *metodo que asigna una venta de agregar receta
     * @param jDialogAddRecipe una ventana de jdialog agregar receta
     */
    public void setjDialogAddRecipe(JDialogAddRecipe jDialogAddRecipe) {
        this.jDialogAddRecipe = jDialogAddRecipe;
    }

    /**
     *metodo que obtienen una ventada en el que se agrega una receta
     * @return
     */
    public JDialogAddRecipe getjDialogAddRecipe() {
        return jDialogAddRecipe;
    }

    /**
     *metodo que obtiene una venta con parametros generales para cambiar el idioma de la aplicaación
     * @return retorna una ventana con unas parametros determinaados
     */
    public ParametrosGenerales getParametrosGenerales() {
        return parametrosGenerales;
    }

    /**
     *metodo que asigna una ventana de parametros generales de la aplicación
     * @param parametrosGenerales parametro de la aplcicacion en la cual se le cambia el idioma
     */
    public void setParametrosGenerales(ParametrosGenerales parametrosGenerales) {
        this.parametrosGenerales = parametrosGenerales;
    }

    /**
     *metodo que obtienen un dato de tiipo entero que hace referencia a cantidad de recurso
     * @return devuelve un valor entero que hace referencia a la cantidad de recurso
     */
    public int getCont() {
        return cont;
    }

    /**
     *metodo al que se le asigna un valor entero que hace referencia ala cantidad del recurso
     * @param cont dato de tipo entero 
     */
    public void setCont(int cont) {
        this.cont = cont;
    }

    /**
     *metodo que obtiene los datos de las primera filla que hace referencia alos ingredient es de la receta
     * @return una filla de ingredietes
     */
    public Box.Filler getFiller1() {
        return filler1;
    }

    /**
     *metodo que asigna a una file unos ingredientes
     * @param filler1
     */
    public void setFiller1(Box.Filler filler1) {
        this.filler1 = filler1;
    }

    /**
     *metodo que obtiene un boton que agrega la receta 
     * @return  devuelve un boton que agrega una receta 
     */
    public JButton getjButton_agregar_rec() {
        return jButton_abrir_agregar_rec;
    }

    /**
     *metodo que asigna un boton en el cual se puede agregar una receta
     * @param jButton_agregar_rec boton que agrega una receta
     */
    public void setjButton_agregar_rec(JButton jButton_agregar_rec) {
        this.jButton_abrir_agregar_rec = jButton_agregar_rec;
    }

    /**
     *metodo qque obtiene un menu en el que hay diferentes items
     * @return un menu bar
     */
    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    /**
     *metodo que asigna un jmenubar a la ventana principal
     * @param jMenuBar1 recibe como parametro un jmenubar
     */
    public void setjMenuBar1(JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }

    /**
     *metodo que obtiene de un jmenu bar un jmeni item que le da al usuario diversas opciones
     * @return es un jmenuItem
     */
    public JMenuItem getjMenuItem_acerca_de() {
        return jMenuItem_acerca_de;
    }

    /**
     *metodo que asigna  un jmenuItem  a el jenu de la pantalla principal
     * @param jMenuItem_acerca_de es el parametro que permite asignar el jmenuitem
     */
    public void setjMenuItem_acerca_de(JMenuItem jMenuItem_acerca_de) {
        this.jMenuItem_acerca_de = jMenuItem_acerca_de;
    }

    /**
     *metodo que obtiene el jmenuitem
     * @return un jmenuitem
     */
    public JMenuItem getjMenuItem_agregar() {
        return jMenuItem_agregar;
    }

    /**
     * metodo que asigna un menu que permite agregar una nueva receta 
     * @param jMenuItem_agregar es el parametro necesario para poder agregar una receta
     */
    public void setjMenuItem_agregar(JMenuItem jMenuItem_agregar) {
        this.jMenuItem_agregar = jMenuItem_agregar;
    }

    /**
     *metodo que obtienen u menu buscar 
     * @returnel jmenuitem buscar
     */
    public JMenuItem getjMenuItem_buscar() {
        return jMenuItem_buscar;
    }

    /**
     *metodo que asina u jmen que se encargara de buscar una receta
     * @param jMenuItem_buscar es el menu que busca la receta
     */
    public void setjMenuItem_buscar(JMenuItem jMenuItem_buscar) {
        this.jMenuItem_buscar = jMenuItem_buscar;
    }

    /**
     *metodo que obtiene un menu que permite editar la receta 
     * @return un jmenuedit
     */
    public JMenuItem getjMenuItem_edit() {
        return jMenuItem_edit;
    }

    /**
     * metodo  que asigna un jmenu iten para editar
     * @param jMenuItem_edit entra como parametro un jmenuitem
     */
    public void setjMenuItem_edit(JMenuItem jMenuItem_edit) {
        this.jMenuItem_edit = jMenuItem_edit;
    }

    /**
     * metodo que obtienen un jmenuitem que elimina
     * @ devuelve u jmenuitem elimnar
     */
    public JMenuItem getjMenuItem_elim() {
        return jMenuItem_elim;
    }

    /**
     * metodo que asigna un jmenuitem
     * @param jMenuItem_elimentra como parametro un jmenuitem
     */
    public void setjMenuItem_elim(JMenuItem jMenuItem_elim) {
        this.jMenuItem_elim = jMenuItem_elim;
    }

    /**
     * metodo que obtiene un jemenu item
     * @return un jmenuitem
     */
    public JMenuItem getjMenuItem_idioma() {
        return jMenuItem_idioma;
    }

    /**
     *metodo que asigna u jmenuiten , al cual se le entra por parametro un jmenu item
     * @param jMenuItem_idioma  variable de tipo menuitem
     */
    public void setjMenuItem_idioma(JMenuItem jMenuItem_idioma) {
        this.jMenuItem_idioma = jMenuItem_idioma;
    }

    /**
     *metodo que obtiene un jmenuiten
     * @return n jmenuitem
     */
    public JMenuItem getjMenuItem_ordenar() {
        return jMenuItem_ordenar;
    }

    /**
     *metodo que le asigna a la ventana un jmenuitem
     * @param jMenuItem_ordenar variable de tipo jmenuitem
     */
    public void setjMenuItem_ordenar(JMenuItem jMenuItem_ordenar) {
        this.jMenuItem_ordenar = jMenuItem_ordenar;
    }

    /**
     *metodo que obtiene un jmenuitem
     * @return un atributo de tipo jmenuitem
     */
    public JMenuItem getjMenuItem_salir() {
        return jMenuItem_salir;
    }

    /**
     *metodo que asigna valores a un jmenuitem
     * @param jMenuItem_salir atributo de tipo jmenuitem
     */
    public void setjMenuItem_salir(JMenuItem jMenuItem_salir) {
        this.jMenuItem_salir = jMenuItem_salir;
    }

    /**
     *metodo que obtiene unjmenu de archio
     * @return un jmenu
     */
    public JMenu getjMenu_archivo() {
        return jMenu_archivo;
    }

    /**
     * metodo en el que se asigna un jmenu
     * @param jMenu_archivo recibe por parametro un jmenu de tipo jmenu
     */
    public void setjMenu_archivo(JMenu jMenu_archivo) {
        this.jMenu_archivo = jMenu_archivo;
    }

    /**
     * metodo que obtienen un jmenu
     * @return devuelve un jmenu
     */
    public JMenu getjMenu_help() {
        return jMenu_Ayuda;
    }

    /**
     *metodo que asigna  un jmenu
     * @param jMenu_helpn entra como parametro una variable de tipo jmenu
     */
    public void setjMenu_help(JMenu jMenu_help) {
        this.jMenu_Ayuda = jMenu_help;
    }

    /**
     *metodo que btiene un jmenu
     * @return devuelve un jmenu
     */
    public JMenu getjMenu_referencias() {
        return jMenu_config;
    }

    /**
     * metodo que asigna  un jmenu
     * @param jMenu_referencias recibe como parametro una variable de tipo jmenu
     */
    public void setjMenu_referencias(JMenu jMenu_referencias) {
        this.jMenu_config = jMenu_referencias;
    }

    /**
     *metodo que obtiene un pane en el cual esta la tabla para adicionar los recursos
     * @returnretorna  un panel 
     */
    public JPanel getjPanel1() {
        return jPanel1;
    }

    /**
     * metodo que asigna  un panel 
     * @param jPanel1 recibe como parametro un jpanle
     */
    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    /**
     * metodo que obtiene un jpanel
     * @return un jpanel
     */
    public JPanel getjPanel_descripcion_recet() {
        return jPanel_descripcion_recet;
    }

    /**
     *metodo que asigna un jpanel
     * @param jPanel_descripcion_recet recibe como parametro un jpanel
     */
    public void setjPanel_descripcion_recet(JPanel jPanel_descripcion_recet) {
        this.jPanel_descripcion_recet = jPanel_descripcion_recet;
    }

    /**
     *metodo que obtienen un controlador
     * @return un controlador
     */
    public Controller getControlador() {
        return controlador;
    }

    /**
     *metodo que asigna e instancia un controloador
     * @param controlador recibe como parametro u controlador 
     */
    public void setControlador(Controller controlador) {
        this.controlador = controlador;
    }

    /**
     * metodo que obtiene un scrollpanel
     * @return un scrollpanel
     */
    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    /**
     *metodo que  asigna un jscrollpanel
     * @param jScrollPane1 recibe como parametro u scrollpanel
     */
    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    /**
     * metodo que obtiene un jscrollpanel
     * @return devuelve un jscrollpanel
     */
    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    /**
     *metodo que signa un scrollpanel
     * @param jScrollPane2 recibe como parametro un jsrollpanel
     */
    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    /**
     * metodo que obtiene un jsrollepanel
     * @return devuelve un jscrollepanel
     */
    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    /**
     * metodo que asigna un jscrollpanel
     * @param jScrollPane3 recibe como parametro un jsrollpanel
     */
    public void setjScrollPane3(JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
    }

    /**
     * metodo que obtiene un jscrollpanel
     * @return devuelve un jscrollpanel
     */
    public JScrollPane getjScrollPane4() {
        return jScrollPane4;
    }

    /**
     *metodo que asigna un jscrollpanel
     * @param jScrollPane4 recibe como parametro un jscrollpanel
     */
    public void setjScrollPane4(JScrollPane jScrollPane4) {
        this.jScrollPane4 = jScrollPane4;
    }

    /**
     * metodo que obtiene una tabla de descripcion
     * @return devuelve un tabla de descripcion de ingrediente
     */
    public JTable getjTable_descrp_ingredientes() {
        return jTable_descrp_ingredientes;
    }

    /**
     * metodo que asigna una tabla para describir una imagenes 
     * @param jTable_descrp_ingredientes recibe como patrametro una jtable
     */
    public void setjTable_descrp_ingredientes(JTable jTable_descrp_ingredientes) {
        this.jTable_descrp_ingredientes = jTable_descrp_ingredientes;
    }

    /**
     * metodo dque obtiene un jtable que guarda recetas
     * @return devuelve un jtable de recetas
     */
    public JTable getjTable_recetas() {
        return jTable_recetas;
    }

    /**
     * metood que asigna una jtable de recetas
     * @param jTable_recetas recibe como parametro un jtable
     */
    public void setjTable_recetas(JTable jTable_recetas) {
        this.jTable_recetas = jTable_recetas;
    }

    /**
     *
     * @return
     */
    public JTextField getjTextField1() {
        return jTextField1;
    }

    /**
     *
     * @param jTextField1
     */
    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    /**
     *
     * @return
     */
    public ActionListener getActionsButtons1() {
        return actionsButtons1;
    }

    /**
     *
     * @param actionsButtons1
     */
    public void setActionsButtons1(ActionListener actionsButtons1) {
        this.actionsButtons1 = actionsButtons1;
    }

    /**
     *
     * @return
     */
    public JMenu getjMenu_mas() {
        return jMenu_Ayuda;
    }

    /**
     *
     * @param jMenu_mas
     */
    public void setjMenu_mas(JMenu jMenu_mas) {
        this.jMenu_Ayuda = jMenu_mas;
    }

    /**
     *
     * @return
     */
    public JPanel getjPanel_botones_princ() {
        return jPanel_botones_princ;
    }

    /**
     *
     * @param jPanel_botones_princ
     */
    public void setjPanel_botones_princ(JPanel jPanel_botones_princ) {
        this.jPanel_botones_princ = jPanel_botones_princ;
    }

    /**
     *
     * @return
     */
    public JPanel getjPanel_descripcion_elementos() {
        return jPanel_descripcion_elementos;
    }

    /**
     *
     * @param jPanel_descripcion_elementos
     */
    public void setjPanel_descripcion_elementos(JPanel jPanel_descripcion_elementos) {
        this.jPanel_descripcion_elementos = jPanel_descripcion_elementos;
    }

    /**
     *
     * @return
     */
    public JPanel getjPanel_descripcion_tiempo() {
        return jPanel_descripcion_tiempo;
    }

    /**
     *
     * @param jPanel_descripcion_tiempo
     */
    public void setjPanel_descripcion_tiempo(JPanel jPanel_descripcion_tiempo) {
        this.jPanel_descripcion_tiempo = jPanel_descripcion_tiempo;
    }

    /**
     *
     * @return
     */
    public JPanel getjPanel_img_ingredientes() {
        return jPanel_img_ingredientes;
    }

    /**
     *
     * @param jPanel_img_ingredientes
     */
    public void setjPanel_img_ingredientes(JPanel jPanel_img_ingredientes) {
        this.jPanel_img_ingredientes = jPanel_img_ingredientes;
    }

    /**
     *
     * @return
     */
    public JPanel getjPanel_preparacion() {
        return jPanel_preparacion;
    }

    /**
     *
     * @param jPanel_preparacion
     */
    public void setjPanel_preparacion(JPanel jPanel_preparacion) {
        this.jPanel_preparacion = jPanel_preparacion;
    }

    /**
     *
     * @return
     */
    public JScrollPane getjScrollPane5() {
        return jScrollPane5;
    }

    /**
     *
     * @param jScrollPane5
     */
    public void setjScrollPane5(JScrollPane jScrollPane5) {
        this.jScrollPane5 = jScrollPane5;
    }

    /**
     *
     * @return
     */
    public JTable getjTable_descripcion_elementos() {
        return jTable_descripcion_elementos;
    }

    /**
     *
     * @param jTable_descripcion_elementos
     */
    public void setjTable_descripcion_elementos(JTable jTable_descripcion_elementos) {
        this.jTable_descripcion_elementos = jTable_descripcion_elementos;
    }

    /**
     *
     * @return
     */
    public JTable getjTable_descripcion_tiempos() {
        return jTable_descripcion_tiempos;
    }

    /**
     *
     * @param jTable_descripcion_tiempos
     */
    public void setjTable_descripcion_tiempos(JTable jTable_descripcion_tiempos) {
        this.jTable_descripcion_tiempos = jTable_descripcion_tiempos;
    }

    /**
     *
     * @return
     */
    public JTextArea getjTextArea_preparacion() {
        return jTextArea_preparacion;
    }

    /**
     *
     * @param jTextArea_preparacion
     */
    public void setjTextArea_preparacion(JTextArea jTextArea_preparacion) {
        this.jTextArea_preparacion = jTextArea_preparacion;
    }

    /**
     *
     * @return
     */
    public DefaultTableModel getModelListRecipe() {
        return modelListRecipe;
    }

    /**
     *
     * @param modelListRecipe
     */
    public void setModelListRecipe(DefaultTableModel modelListRecipe) {
        this.modelListRecipe = modelListRecipe;
    }

    /**
     *
     * @return
     */
    public JMenu getjMenu_Ayuda() {
        return jMenu_Ayuda;
    }

    /**
     *
     * @return
     */
    public JMenu getjMenu_config() {
        return jMenu_config;
    }

    /**
     *
     * @return
     */
    public ManagerLogic getManagerLogic() {
        return managerLogic;
    }

    /**
     *
     * @return
     */
    public JDialogAddResources getjDialogAddResources() {
        return jDialogAddResources;
    }

    /**
     *
     * @param jDialogAddResources
     */
    public void setjDialogAddResources(JDialogAddResources jDialogAddResources) {
        this.jDialogAddResources = jDialogAddResources;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    ActionListener actionsButtons1 = new ActionListener() {
        public void actionPerformed(ActionEvent a) {
            if (a.getActionCommand().equals(Calculate)) {
                parametrosGenerales.setVisible(true);
            }
        }

    };

}
