/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestioninscription;

import javax.swing.table.AbstractTableModel;

public class  ModeleJTableRenta2 extends AbstractTableModel
{
	private String[] columnNames = {"Participants","Taux horaire"};
	private Object[][] data=new Object[50][2];
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
                System.out.println(col);
                System.out.println(row);
		fireTableCellUpdated(row,col);
		//fireTableDataChanged();
	}
}