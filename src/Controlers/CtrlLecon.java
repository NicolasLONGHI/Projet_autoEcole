/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;

import Tools.ConnexionBDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Poste de travail
 */
public class CtrlLecon {
    
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public CtrlLecon(){
        cnx = ConnexionBDD.getCnx();
    }
    
    public int findTotalAmountOfLessons(int idEleve){
        int nbLecons = 0;
        try {
            ps = cnx.prepareStatement("SELECT COUNT(codeLecon) AS nbLeconsTotal FROM Lecon WHERE codeEleve = ?;");
            ps.setInt(1, idEleve);
            rs = ps.executeQuery();
            if(rs.next()){
                nbLecons = rs.getInt("nbLeconsTotal");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlLecon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nbLecons;
    }
    
    public int findAmountOfLessonsDone(int idEleve){
        int leconsTerminees = 0;
        try {
            ps = cnx.prepareStatement("SELECT COUNT(codeLecon) AS nbLeconsTerminees FROM Lecon WHERE codeEleve = ? AND date < SYSDATE();");
            ps.setInt(1, idEleve);
            rs = ps.executeQuery();
            if(rs.next()){
                leconsTerminees = rs.getInt("nbLeconsTerminees");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlLecon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return leconsTerminees;
    }
    
    public int findAmountOfLessonsLeft(int idEleve){
        int leconsPasFaites = 0;
        try {
            ps = cnx.prepareStatement("SELECT COUNT(codeLecon) AS nbLeconsPasFaites FROM Lecon WHERE codeEleve = ? AND date > SYSDATE();");
            ps.setInt(1, idEleve);
            rs = ps.executeQuery();
            if(rs.next()){
                leconsPasFaites = rs.getInt("nbLeconsPasFaites");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlLecon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return leconsPasFaites;
    }
    
    public double findTotalPrice(int idEleve){
        double prixTotal = 0.00;
        try {
            ps = cnx.prepareStatement("SELECT COUNT(l.codeLecon)*c.prix AS prixParType FROM Lecon l JOIN Vehicule v ON l.immatriculation = v.immatriculation JOIN Categorie c ON v.codeCategorie = c.codeCategorie WHERE CodeEleve = ? GROUP BY v.codeCategorie;");
            ps.setInt(1, idEleve);
            rs = ps.executeQuery();
            while(rs.next()){
                prixTotal += rs.getDouble("prixParType");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlLecon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prixTotal;
    }
    
    public double findPricePaid(int idEleve){
        double prixPaye = 0.00;
        try {
            ps = cnx.prepareStatement("SELECT COUNT(l.codeLecon)*c.prix AS prixParType FROM Lecon l JOIN Vehicule v ON l.immatriculation = v.immatriculation JOIN Categorie c ON v.codeCategorie = c.codeCategorie WHERE CodeEleve = ? AND l.reglee = 1 GROUP BY v.codeCategorie;");
            ps.setInt(1, idEleve);
            rs = ps.executeQuery();
            while(rs.next()){
                prixPaye += rs.getDouble("prixParType");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlLecon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prixPaye;
    }
    
    public double findPriceLeftToPay(int idEleve){
        double prixAPayer = 0.00;
        try {
            ps = cnx.prepareStatement("SELECT COUNT(l.codeLecon)*c.prix AS prixParType FROM Lecon l JOIN Vehicule v ON l.immatriculation = v.immatriculation JOIN Categorie c ON v.codeCategorie = c.codeCategorie WHERE CodeEleve = ? AND l.reglee = 0 GROUP BY v.codeCategorie;");
            ps.setInt(1, idEleve);
            rs = ps.executeQuery();
            while(rs.next()){
                prixAPayer += rs.getDouble("prixParType");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlLecon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prixAPayer;
    }
    /*
    public ArrayList<String> findOccupiedHours(String date, String nomMoniteur, String nomVehicule){
        ArrayList<String> heuresPrises = new ArrayList<>();
        try {
            ps = maCnx.prepareStatement("SELECT heure FROM Lecon WHERE date = ? AND codeMoniteur = (SELECT codeMoniteur FROM Moniteur WHERE nom = ?) AND immatriculation = (SELECT immatriculation FROM Vehicule WHERE modele = ?)");
            ps.setString(1, date);
            ps.setString(2, nomMoniteur);
            ps.setString(3, nomVehicule);
            rs = ps.executeQuery();
            while(rs.next()){
                //heuresPrises.add(rs.getString("heure"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlPlanning.class.getName()).log(Level.SEVERE, null, ex);
        }
        return heuresPrises;
    }
    
    public void removeOccupiedHours(JComboBox<String> uneCBox, String date, String nomMoniteur, String nomVehicule){
        String[] heuresTotales = new String[]{"08:00:00", "09:00:00", "10:00:00", "11:00:00", "13:00:00", "14:00:00", "15:00:00", "16:00:00", "17:00:00", "18:00:00"};
        ArrayList<String> heuresPrises = findOccupiedHours(date, nomMoniteur, nomVehicule);
        
        for(String hT : heuresTotales){
            for(String hP : heuresPrises){
                if(!hT.equals(hP)){
                    //uneCBox.removeItem(hT);
                    uneCBox.addItem(hT);
                }
            }
        }
    }
*/
}
