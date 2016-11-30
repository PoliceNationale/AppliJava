/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionsessions;

/**
 *
 * @author Valoo22
 */
import javax.swing.table.AbstractTableModel;

public class  ModeleJTableListeSession extends AbstractTableModel
{
	private String[] columnNames = {"Numéro Session","Libellé Session","Niveau","Type","Description","Dîplome ?","Date Début","Durée","Nombre Place Restante","Marge actuelle"};
	private Object[][] data=new Object[10][8];
        @Override
	public int getColumnCount()
	{
		return columnNames.length;
	}
        @Override
	public int getRowCount()
	{
		return data.length;
	}
        @Override
	public String getColumnName(int col)
	{
		return columnNames[col];
	}
        @Override
	public Object getValueAt(int row, int col)
	{
		return data[row][col];
	}
	
        @Override
	public boolean isCellEditable(int row, int col)
	{
		return (col < 2);
	}
        @Override
	public void setValueAt(Object value, int row, int col)
	{
		data[row][col] = value;
		fireTableCellUpdated(row,col);
		//fireTableDataChanged();
	}
}