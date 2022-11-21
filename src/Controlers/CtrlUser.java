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

/**
 *
 * @author nicol
 */
public class CtrlUser {
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlUser() {
        cnx = ConnexionBDD.getCnx();
    }
    
    public User GetConnexionEleve(String unLogin, String unMdp){
        User monUser = null;
        try {
            ps = cnx.prepareStatement("select CodeEleve, Nom, Prenom, Sexe, DateDeNaissance, Adresse1, CodePostal, Ville, Telephone FROM eleve where login = ? and mdp = ?");
            ps.setString(1, unLogin);
            ps.setString(2, unMdp);
            rs = ps.executeQuery();
            if(rs.next()){
                monUser = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return monUser;
    }
        public User GetConnexionMoniteur(String unLogin, String unMdp){
        User monUser = null;
        try {
            ps = cnx.prepareStatement("select CodeMoniteur, Nom, Prenom, Sexe, DateDeNaissance, Adresse1, CodePostal, Ville, Telephone FROM moniteur where login = ? and mdp = ?");
            ps.setString(1, unLogin);
            ps.setString(2, unMdp);
            rs = ps.executeQuery();
            if(rs.next()){
                monUser = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return monUser;
    }
    
            public User GetConnexionResponsable(String unLogin, String unMdp){
        User monUser = null;
        try {
            ps = cnx.prepareStatement("select CodeResponsable, Nom, Prenom, Sexe, DateDeNaissance, Adresse1, CodePostal, Ville, Telephone FROM responsable where login = ? and mdp = ?");
            ps.setString(1, unLogin);
            ps.setString(2, unMdp);
            rs = ps.executeQuery();
            if(rs.next()){
                monUser = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return monUser;
    }
}
