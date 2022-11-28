/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Poste de travail
 */
public class CatV {
    private int codeCat;
    private String libelleCat;
    private double prix;
    
    public CatV(int unCodeCategorie, String unLibelleCategorie, double unPrix){
        this.codeCat = unCodeCategorie;
        this.libelleCat = unLibelleCategorie;
        this.prix = unPrix;
    }

    /**
     * @return the codeCat
     */
    public int getCodeCat() {
        return codeCat;
    }

    /**
     * @return the libelleCat
     */
    public String getLibelleCat() {
        return libelleCat;
    }

    /**
     * @param libelleCat the libelleCat to set
     */
    public void setLibelleCat(String libelleCat) {
        this.libelleCat = libelleCat;
    }

    /**
     * @return the prix
     */
    public double getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }
}
