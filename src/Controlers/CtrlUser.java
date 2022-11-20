/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;

import Entities.User;
import Tools.ConnexionBDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nicol
 */
public class CtrlUser {
    
    private Connection maCnx;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public CtrlUser () {
        maCnx = ConnexionBDD.getCnx();
    }
    
    public void MaJInfos(User unUser) {
         try {
             //"UPDATE eleve SET eleve.Nom = ?, eleve.Prenom = ?, eleve.Sexe = ?, eleve.DateDeNaissance = ?, eleve.Adresse1 = ?, eleve.CodePostal = ?, eleve.Ville = ?, eleve.Telephone = ? WHERE eleve.CodeEleve = ?;"
            String requete;
            if (unUser.getStatut() == 0) {
                requete = "UPDATE eleve SET eleve.Nom = ?, eleve.Prenom = ?, eleve.Sexe = ?, eleve.Adresse1 = ?, eleve.CodePostal = ?, eleve.Ville = ?, eleve.Telephone = ? WHERE eleve.CodeEleve = ?;";
            }
            else if (unUser.getStatut() == 1) {
                requete = "UPDATE moniteur SET moniteur.Nom = ?, moniteur.Prenom = ?, moniteur.Sexe = ?, moniteur.Adresse1 = ?, moniteur.CodePostal = ?, moniteur.Ville = ?, moniteur.Telephone = ? WHERE moniteur.CodeMoniteur = ?;";
            }
            else {
                requete = "responsable";
            }
            ps = maCnx.prepareStatement(requete);
            ps.setString(1, unUser.getNom());
            ps.setString(2, unUser.getPrenom());
            ps.setInt(3, unUser.getSexe());
//            java.util.Date util_StartDate = format.parse( unUser.getDateDeNaissance() );
//            java.sql.Date sql_StartDate = new java.sql.Date( util_StartDate.getTime() );
//            ps.setDate(4, sql_StartDate);
            ps.setString(4, unUser.getAdresse());
            ps.setString(5, unUser.getCodePostal());
            ps.setString(6, unUser.getVille());
            ps.setString(7, unUser.getTelephone());
            ps.setInt(8, unUser.getCodeUser());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
