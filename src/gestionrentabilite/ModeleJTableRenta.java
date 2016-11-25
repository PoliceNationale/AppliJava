/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionrentabilite;

/**
 *
 * @author Valoo22
 */
import javax.swing.table.AbstractTableModel;

public class  ModeleJTableRenta extends AbstractTableModel
{
	private String[] columnNames = {"Numéro","Nom","Date début","Nb Inscrits","Nb Places","Taux de Remplissage (%) "};
	private Object[][] data=new Object[10][6];
	public int getColumnCount()
	{
		return columnNames.length;
	}
	public int getRowCount()
	{
		return data.length;
	}
	public String getColumnName(int col)
	{
		return columnNames[col];
	}
	public Object getValueAt(int row, int col)
	{
		return data[row][col];
	}
	
	public boolean isCellEditable(int row, int col)
	{
		return (col < 0);
	}
	public void setValueAt(Object value, int row, int col)
	{
		data[row][col] = value;
		fireTableCellUpdated(row,col);
		//fireTableDataChanged();
	}
}