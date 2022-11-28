/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;

import Entities.Licence;
import Entities.Moniteur;
import Tools.ConnexionBDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JComboBox;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Poste de travail
 */
public class CtrlMoniteur {
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public CtrlMoniteur() {
        cnx = ConnexionBDD.getCnx();
    }
    
    public ArrayList<Moniteur> findInstructorsByIdInLicence(int codeCategorie){
        ArrayList<Moniteur> lesMoniteurs = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("SELECT m.codeMoniteur, m.nom, prenom FROM Licence l JOIN Moniteur m ON l.codeMoniteur = m.codeMoniteur WHERE l.codeCategorie = ?");
            ps.setInt(1, codeCategorie);
            rs = ps.executeQuery();
            while(rs.next()){
                Moniteur unMoniteur = new Moniteur(rs.getInt("m.codeMoniteur"), rs.getString("m.nom"), rs.getString("m.prenom"));
                lesMoniteurs.add(unMoniteur);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlVehicule.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMoniteurs;
    }
    
    public void loadInstructorNames(JComboBox<String> uneCBox, int codeCategorie){
        for(Moniteur m : findInstructorsByIdInLicence(codeCategorie+1)){
            uneCBox.addItem(/*m.getPrenom()+" "+*/m.getNom());
        }
    }
    
    public boolean insertLicence(int idCategorie, int idMoniteur, Date dateObtention){
        boolean succes = false;
        //(date.getYear, date.getMonth, date.getDate) -> String
        // faire la modif ds les f° créées ds CtrlPlanning (et pt-ê les déplacer ds CtrlLecon)
        try {
            ps = cnx.prepareStatement("INSERT INTO Licence(codeMoniteur, codeCategorie, dateObtention) VALUES(?, ?, ?);");
            ps.setInt(1, idMoniteur);
            ps.setInt(2, idCategorie);
            //java.sql.Date.valueOf(/*String*/)
            ps.setDate(3, /*dateObtention*/);
            succes = ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMoniteur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return succes;
    }
    
    /*public ArrayList<Moniteur> findAllInstructors(){
        ArrayList<Moniteur> lesMoniteurs = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("SELECT codeMoniteur, nom, prenom FROM Moniteur");
            rs = ps.executeQuery();
            while(rs.next()){
                Moniteur unMoniteur = new Moniteur(rs.getInt("codeMoniteur"), rs.getString("nom"), rs.getString("prenom"));
                lesMoniteurs.add(unMoniteur);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlVehicule.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMoniteurs;
    }
    
    public ArrayList<Licence> findInstructorLicences(int idMoniteur){
        ArrayList<Licence> lesLicences = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("SELECT codeLicence, codeMoniteur, codeCategorie FROM Licence WHERE codeMoniteur = ?");
            ps.setInt(1, idMoniteur);
            rs = ps.executeQuery();
            while(rs.next()){
                Licence uneLicence = new Licence(rs.getInt("codeLicence"), rs.getInt("codeMoniteur"), rs.getInt("codeCategorie"));
                lesLicences.add(uneLicence);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMoniteur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesLicences;
    }
    
    public void loadInstructorNames(JComboBox<String> uneCBox, int codeCat, ArrayList<Moniteur> desMoniteurs){
        for(Moniteur m : desMoniteurs){
            for(Licence l : findInstructorLicences(m.getCodeM())){
                if(l.getCodeC() == codeCat){
                    uneCBox.addItem(m.getPrenom()+" "+m.getNom());
                }
            }
        }
    }*/
}
