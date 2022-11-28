/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Poste de travail
 */
public class Moniteur {
    private int codeM;
    private String nom;
    private String prenom;
    private int sexe;
    private String dateNaiss;
    private String adr;
    private String codePostal;
    private String ville;
    private String tel;

    public Moniteur(int unCodeM, String unNom, String unPrenom){
        this.codeM = unCodeM;
        this.nom = unNom;
        this.prenom = unPrenom;
    }
    
    public Moniteur(int unCodeM, String unNom, String unPrenom, int unSexe, String uneDateNaiss, String uneAdr, String unCP, String uneVille, String unTel){
        this.codeM = unCodeM;
        this.nom = unNom;
        this.prenom = unPrenom;
        this.sexe = unSexe;
        this.dateNaiss = uneDateNaiss;
        this.adr = uneAdr;
        this.codePostal = unCP;
        this.ville = uneVille;
        this.tel = unTel;
    }
    
    
    /**
     * @return the codeM
     */
    public int getCodeM() {
        return codeM;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @return the sexe
     */
    public int getSexe() {
        return sexe;
    }

    /**
     * @return the dateNaiss
     */
    public String getDateNaiss() {
        return dateNaiss;
    }

    /**
     * @return the adr
     */
    public String getAdr() {
        return adr;
    }

    /**
     * @return the codePostal
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     * @return the ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @param sexe the sexe to set
     */
    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    /**
     * @param dateNaiss the dateNaiss to set
     */
    public void setDateNaiss(String dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    /**
     * @param adr the adr to set
     */
    public void setAdr(String adr) {
        this.adr = adr;
    }

    /**
     * @param codePostal the codePostal to set
     */
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    /**
     * @param ville the ville to set
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }
    
}
