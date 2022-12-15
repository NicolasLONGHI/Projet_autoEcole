/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;


import Entities.Vehicule;
import Entities.Categorie;
import Tools.ConnexionBDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Poste de travail
 */
public class CtrlVehicule {
    
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public CtrlVehicule() {
        cnx = ConnexionBDD.getCnx();
    }
    
    
    public ArrayList<Categorie> GetToutesLesCategories(){
        ArrayList<Categorie> lesCategoriesV = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("SELECT codeCategorie, libelle, prix FROM Categorie ORDER BY codeCategorie");
            rs = ps.executeQuery();
            while(rs.next()){
                Categorie uneCategorie = new Categorie(rs.getInt("codeCategorie"), rs.getString("libelle"), rs.getDouble("prix"));
                lesCategoriesV.add(uneCategorie);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlVehicule.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesCategoriesV;
    }
    
    public void InitialiserCboCategories(JComboBox<String> uneCBox, ArrayList<Categorie> lesCategories){
        for(Categorie uneCategorie : lesCategories){
            uneCBox.addItem(uneCategorie.getLibelleCategorie());
        }
    }
    
    public ArrayList<Vehicule> GetVehiculeDispo(String uneDate, String uneHeure, int unCodeCategorie){
        ArrayList<Vehicule> lesVehicules = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("SELECT vehicule.Immatriculation, vehicule.Marque, vehicule.Modele, vehicule.Annee, vehicule.CodeCategorie FROM vehicule JOIN lecon ON lecon.Immatriculation = vehicule.Immatriculation WHERE vehicule.CodeCategorie = ? AND vehicule.Immatriculation NOT IN (SELECT lecon.Immatriculation FROM lecon WHERE lecon.Date = ? AND lecon.Heure = ?) GROUP BY lecon.Immatriculation;");
            ps.setInt(1, unCodeCategorie);
            ps.setString(2, uneDate);
            ps.setString(3, uneHeure);
            rs = ps.executeQuery();
            while(rs.next()){
                Vehicule unVehicule = new Vehicule(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
                lesVehicules.add(unVehicule);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlVehicule.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesVehicules;
    }
    
    public void InitialiserCboVehiculeDispo(JComboBox<String> uneCBox, ArrayList<Vehicule> lesVehicules){
        uneCBox.removeAllItems();
        if (lesVehicules.isEmpty()) {
            uneCBox.addItem("Aucun véhicule");
        }
        else {
            for(Vehicule unVehicule : lesVehicules){
                uneCBox.addItem(unVehicule.getMarque().toUpperCase() + " " + unVehicule.getLeModele());
            }
        }
    }
    
    public ArrayList<String> LoadImmatriculation(ArrayList<Vehicule> lesVehicules) {
        ArrayList<String> lesImmatriculations = new ArrayList<>();
        for(Vehicule unVehicule : lesVehicules){
            lesImmatriculations.add(unVehicule.getImmatriculation());
        }
        return lesImmatriculations;
    }
}
