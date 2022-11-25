/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;
//test

import Entities.Planning;
import Tools.ConnexionBDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicol
 */
public class CtrlPlanning {
    
    private Connection maCnx;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public CtrlPlanning () {
        maCnx = ConnexionBDD.getCnx();
    }
    
    
    public ArrayList<Planning> getPlanningByMoniteurId(int unIdMoniteur) {
        ArrayList<Planning> lesPlanning = new ArrayList<>();
        try {
            ps = maCnx.prepareStatement("SELECT categorie.Libelle, eleve.Nom, eleve.Prenom, lecon.Date, lecon.Heure, categorie.Prix, lecon.Reglee FROM lecon JOIN eleve ON eleve.CodeEleve = lecon.CodeEleve JOIN vehicule ON vehicule.Immatriculation = lecon.Immatriculation JOIN categorie ON categorie.CodeCategorie = vehicule.CodeCategorie WHERE lecon.CodeMoniteur = ?");
            ps.setInt(1, unIdMoniteur);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Planning unPlanning = new Planning(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getDouble(6), rs.getInt(7));
                lesPlanning.add(unPlanning);
                
            }
            rs.close();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CtrlPlanning.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lesPlanning;
    }
}
