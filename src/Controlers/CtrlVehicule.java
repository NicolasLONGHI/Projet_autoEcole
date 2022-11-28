/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;


import Entities.Vehicule;
import Entities.CatV;
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
    
    //public Vehicule findVehicule(){}
    
    public ArrayList<Vehicule> findAllVehicles(){
        ArrayList<Vehicule> lesVehicules = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("SELECT immatriculation, marque, modele, annee, codeCategorie FROM Vehicule");
            rs = ps.executeQuery();
            while(rs.next()){
                Vehicule unVehicule = new Vehicule(rs.getString("immatriculation"), rs.getString("marque"), rs.getString("modele"), rs.getInt("annee"), rs.getInt("codeCategorie"));
                lesVehicules.add(unVehicule);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlVehicule.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesVehicules;
    }
    
    public void loadVehicleNames(JComboBox<String> uneCBox, int codeCategorie, ArrayList<Vehicule> desVehicules){
        for(Vehicule v : desVehicules){
            if(v.getCodeCategorie() == codeCategorie+1){
                uneCBox.addItem(/*v.getMarque()+" "+*/v.getLeModele());
            }
        }
    }
    
    public ArrayList<CatV> findAllVehicleCategories(){
        ArrayList<CatV> lesCategoriesV = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("SELECT codeCategorie, libelle, prix FROM Categorie ORDER BY codeCategorie");
            rs = ps.executeQuery();
            while(rs.next()){
                CatV uneCategorie = new CatV(rs.getInt("codeCategorie"), rs.getString("libelle"), rs.getDouble("prix"));
                lesCategoriesV.add(uneCategorie);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlVehicule.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesCategoriesV;
    }
    
    public void loadCategoryNames(JComboBox<String> uneCBox){
        for(CatV c : findAllVehicleCategories()){
            uneCBox.addItem(c.getLibelleCat());
        }
    }
}
