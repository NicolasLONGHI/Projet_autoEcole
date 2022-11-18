/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

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
    

}
