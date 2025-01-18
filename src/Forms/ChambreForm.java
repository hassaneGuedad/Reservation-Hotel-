/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Forms;

import Entities.Categorie;
import Entities.Chambre;
import Service.CategorieService;
import Service.ChambreService;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class ChambreForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form ChambreForm
     */
    private ChambreService chs;
    private DefaultTableModel model;
    private CategorieService cats;
    private static int id;
    private  static String tele;
    private  static Categorie Listecategorie;
    private Categorie categorie1 ;
    int size=0;
    
    public ChambreForm() {
        initComponents();
        this.setTitle("Gestion des Chambres");
        chs=new ChambreService();
        model=(DefaultTableModel) tableauCategories.getModel();
        cats=new CategorieService();
        load();
        loadCat();
    }

    public void load(){
                model.setRowCount(0);
        for(Chambre ch : chs.findAll()){
            model.addRow(new Object[]{
                ch.getId_ch(),
                ch.getTelephone(),
                ch.getCat(),
            });
        }
    }
    
    public void loadCat(){
        ListeCategorie.removeAllItems();
        for(Categorie cat:cats.findAll()){
                ListeCategorie.addItem(cat);
                size++;
        }
          
        }
    
    public void Load_content(){
        teletxt.setText(tele);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableauCategories = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jlabel = new javax.swing.JLabel();
        teletxt = new javax.swing.JTextField();
        Ajouter = new javax.swing.JButton();
        Modifier = new javax.swing.JButton();
        Supprimer = new javax.swing.JButton();
        ListeCategorie = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        tableauCategories.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Telephone", "Catégorie"
            }
        ));
        tableauCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableauCategoriesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableauCategories);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jlabel.setText("Téléphone");

        Ajouter.setBackground(new java.awt.Color(255, 255, 153));
        Ajouter.setText("Ajouter");
        Ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterActionPerformed(evt);
            }
        });

        Modifier.setBackground(new java.awt.Color(153, 255, 153));
        Modifier.setText("Modifier");
        Modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierActionPerformed(evt);
            }
        });

        Supprimer.setBackground(new java.awt.Color(255, 51, 51));
        Supprimer.setText("Supprimer");
        Supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupprimerActionPerformed(evt);
            }
        });

        ListeCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListeCategorieActionPerformed(evt);
            }
        });

        jLabel1.setText("Ctaégorie");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(teletxt, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                            .addComponent(ListeCategorie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(Ajouter)
                        .addGap(80, 80, 80)
                        .addComponent(Modifier)
                        .addGap(88, 88, 88)
                        .addComponent(Supprimer)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ListeCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel)
                    .addComponent(teletxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ajouter)
                    .addComponent(Modifier)
                    .addComponent(Supprimer))
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ListeCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListeCategorieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListeCategorieActionPerformed

    private void AjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterActionPerformed

        if (chs.Create(new Chambre(teletxt.getText(), (Categorie) ListeCategorie.getSelectedItem())))
        JOptionPane.showMessageDialog(this,"Chambre est bien enregistrée");
        load();
    }//GEN-LAST:event_AjouterActionPerformed

    private void tableauCategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableauCategoriesMouseClicked
        id = Integer.parseInt((String) model.getValueAt(tableauCategories.getSelectedRow(), 0).toString());
        tele = model.getValueAt(tableauCategories.getSelectedRow(), 1).toString();
        categorie1 =  (Categorie) model.getValueAt(tableauCategories.getSelectedRow(), 2);
        System.out.println(categorie1);
        for(int i = 0  ; i<ListeCategorie.getItemCount() ;i++){
            System.out.println(ListeCategorie.getItemAt(i));
            Categorie C = (Categorie) ListeCategorie.getItemAt(i);
            if(C.getId_cat() == categorie1.getId_cat() ){
                
               ListeCategorie.setSelectedIndex(i);
            }
        }
         Load_content();
    }//GEN-LAST:event_tableauCategoriesMouseClicked

    private void ModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifierActionPerformed
                int reponse=JOptionPane.showConfirmDialog(this, "voulez-vous vraiment modifier cette chambre");
        if(reponse==0){
            Chambre c = new Chambre(id,teletxt.getText(), (Categorie) ListeCategorie.getSelectedItem());
            if(chs.Update(c)){
                JOptionPane.showMessageDialog(this, "Chambre bien modifier");
                load();
            }
        }
    }//GEN-LAST:event_ModifierActionPerformed

    private void SupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupprimerActionPerformed
        int reponse=JOptionPane.showConfirmDialog(this, "voulez-vous vraiment supprimer cette chambre");
        if(reponse==0){
            if(chs.Delete(chs.findById(id))){
                JOptionPane.showMessageDialog(this, "Chambre est bien supprimé");
                load();
            }
        }
    }//GEN-LAST:event_SupprimerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ajouter;
    private javax.swing.JComboBox ListeCategorie;
    private javax.swing.JButton Modifier;
    private javax.swing.JButton Supprimer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel;
    private javax.swing.JTable tableauCategories;
    private javax.swing.JTextField teletxt;
    // End of variables declaration//GEN-END:variables
}
