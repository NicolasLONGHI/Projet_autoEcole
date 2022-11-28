/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import Entities.Planning;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author jacqu
 */
public class ModelJTable  extends AbstractTableModel 
{

    private String[] nomsColonnes;
    private Object[][] rows;
    
    
    @Override
    public int getRowCount() {
        return rows.length;
    }

    @Override
    public int getColumnCount() {
        return nomsColonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows[rowIndex][columnIndex];
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return nomsColonnes[columnIndex];
    }
    
    public void LoadDataPLanning(ArrayList<Planning> uneListe) {
        nomsColonnes = new String[]{"Catégorie", "Nom", "Prénom", "Date", "Heure", "Prix", "Réglée"};
        rows = new Object[uneListe.size()][7];
        int i = 0;
        for (Planning unPlanning : uneListe) {
            rows[i][0] = unPlanning.getLibelle();
            rows[i][1] = unPlanning.getNom();
            rows[i][2] = unPlanning.getPrenom();
            rows[i][3] = unPlanning.getDate();
            rows[i][4] = unPlanning.getHeure();
            rows[i][5] = unPlanning.getPrix();
            rows[i][6] = unPlanning.getReglee();
            i++;
        }
        fireTableChanged(null);
    }
    

}
