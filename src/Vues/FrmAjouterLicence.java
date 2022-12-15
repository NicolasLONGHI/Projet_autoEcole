/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vues;

import Controlers.CtrlLicence;
import Controlers.CtrlVehicule;
import Entities.Categorie;
import Entities.User;
import Tools.ConnexionBDD;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Poste de travail
 */
public class FrmAjouterLicence extends javax.swing.JFrame {

    static User unUser;
    private CtrlVehicule ctrlVehicule;
    private CtrlLicence ctrlLicence;
    SimpleDateFormat sdf;
    
    /**
     * Creates new form FrmAjouterLicence
     */
    public FrmAjouterLicence(User unUser) {
        this.unUser = unUser;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCategorieV = new javax.swing.JLabel();
        cboCategorieV = new javax.swing.JComboBox<>();
        lblDateObtention = new javax.swing.JLabel();
        dcDateObtention = new com.toedter.calendar.JDateChooser();
        lblTitre = new javax.swing.JLabel();
        lblRetour = new javax.swing.JLabel();
        lblAjouter = new javax.swing.JLabel();
        lblLogoValider = new javax.swing.JLabel();
        lblLogoRetour = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Auto NMN");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblCategorieV.setText("Catégorie");

        lblDateObtention.setText("Date d'obtention");

        lblTitre.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        lblTitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitre.setText("Ajouter une licence");

        lblRetour.setForeground(new java.awt.Color(0, 51, 255));
        lblRetour.setText("Retour");
        lblRetour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRetour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRetourMouseClicked(evt);
            }
        });

        lblAjouter.setForeground(new java.awt.Color(0, 51, 255));
        lblAjouter.setText("Ajouter");
        lblAjouter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAjouter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAjouterMouseClicked(evt);
            }
        });

        lblLogoValider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogoValider.setPreferredSize(new java.awt.Dimension(25, 25));
        lblLogoValider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoValiderMouseClicked(evt);
            }
        });

        lblLogoRetour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogoRetour.setPreferredSize(new java.awt.Dimension(25, 25));
        lblLogoRetour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoRetourMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(lblTitre))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDateObtention)
                                    .addComponent(lblCategorieV))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboCategorieV, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dcDateObtention, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 80, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblLogoRetour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRetour)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAjouter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLogoValider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(lblLogoRetour, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategorieV)
                            .addComponent(cboCategorieV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDateObtention)
                            .addComponent(dcDateObtention, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblLogoValider, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblAjouter)
                                .addComponent(lblRetour)))
                        .addGap(14, 14, 14))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ctrlVehicule = new CtrlVehicule();
        ctrlLicence = new CtrlLicence();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        dcDateObtention.setDateFormatString("dd/MM/yyyy");
        java.util.Date date = new java.util.Date();
        dcDateObtention.setDate(date);
        
        ArrayList<Categorie> lesCategories = new ArrayList<>();
        lesCategories = ctrlVehicule.GetToutesLesCategories();
        ctrlVehicule.InitialiserCboCategories(cboCategorieV, lesCategories);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/valider.png"));
        Image img = icon.getImage();
        img = img.getScaledInstance(lblLogoValider.getWidth(), lblLogoValider.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ic = new ImageIcon(img);
        lblLogoValider.setIcon(ic);
        
        icon = new ImageIcon(getClass().getResource("/Images/retour.png"));
        img = icon.getImage();
        img = img.getScaledInstance(lblLogoRetour.getWidth(), lblLogoRetour.getHeight(), Image.SCALE_SMOOTH);
        ic = new ImageIcon(img);
        lblLogoRetour.setIcon(ic);
    }//GEN-LAST:event_formWindowOpened

    private void lblRetourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRetourMouseClicked
        retour();
    }//GEN-LAST:event_lblRetourMouseClicked

    private void lblAjouterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAjouterMouseClicked
        validerAjoutLicence();
    }//GEN-LAST:event_lblAjouterMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        retour();
    }//GEN-LAST:event_formWindowClosing

    private void lblLogoRetourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoRetourMouseClicked
        retour();
    }//GEN-LAST:event_lblLogoRetourMouseClicked

    private void lblLogoValiderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoValiderMouseClicked
        validerAjoutLicence();
    }//GEN-LAST:event_lblLogoValiderMouseClicked
    
    
    public void validerAjoutLicence() {
        if (dcDateObtention.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Veuillez séléctionner une date", "Erreur", JOptionPane.WARNING_MESSAGE);
        }
        else {
            String dateObtention = sdf.format(dcDateObtention.getDate());
            int nomCategorie = ctrlLicence.GetIdCategorieByName(cboCategorieV.getSelectedItem().toString());
            boolean licenceExiste = ctrlLicence.VerifLicenceExiste(unUser.getCodeUser(), nomCategorie);
            if (licenceExiste == true) {
                JOptionPane.showMessageDialog(this, "Impossible d'ajouter la licence car elle existe déjà", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            else {
                ctrlLicence.AjouterLicence(unUser.getCodeUser(), nomCategorie, dateObtention);
                JOptionPane.showMessageDialog(this, "La licence a bien été ajouté", "Ajouté", JOptionPane.INFORMATION_MESSAGE);
                retour();
            }
        }
    }
    
    private void retour() {
        FrmInterfacePrincipale frm = new FrmInterfacePrincipale(unUser);
        this.setVisible(false);
        frm.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAjouterLicence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAjouterLicence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAjouterLicence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAjouterLicence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAjouterLicence(unUser).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboCategorieV;
    private com.toedter.calendar.JDateChooser dcDateObtention;
    private javax.swing.JLabel lblAjouter;
    private javax.swing.JLabel lblCategorieV;
    private javax.swing.JLabel lblDateObtention;
    private javax.swing.JLabel lblLogoRetour;
    private javax.swing.JLabel lblLogoValider;
    private javax.swing.JLabel lblRetour;
    private javax.swing.JLabel lblTitre;
    // End of variables declaration//GEN-END:variables
}