/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Dhanuka Perera
 */
public class billRender extends JTextArea implements TableCellRenderer
{
    public void billRender()
    {
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(true);
        //setOpaque(true);
        setForeground(new Color(255, 255, 255));
        //setBackground(Color.red);
        // rowHeight = new rowheight;
        //setFont(new Font(se));
        //setBackground(Color.red);
        setFont( new Font("Segoe UI",Font.PLAIN,14));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String x = (String) value;
        // x = "<html><p>"+x+"</p></html>";

       setText((x == null) ? "" : x);
        //setEditable(false);
        // adjustRowHeight(table,row,column);
        //setRowHeight(table,row,column);
        //column.
        // setLineWrap(true);
        // table.setRowHeight();
        
        // -----------------------------------------------
        // -- Seting table height
 setFont( new Font("Segoe UI",Font.PLAIN,14));
    setForeground(new Color(255, 255, 255));
         table.setRowHeight(row,25);
        // ------------------------------------------------
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(true);
        //System.out.println(row + "-->" + x.length());
        //table.setAutoResizeMode(column);
       
        //JTextField editor = new JTextField();
        
      //editor.setText(value.toString());
    setBackground((row % 2 == 0) ? new Color(52, 73, 94) : new Color(44, 62, 80));
      
        //setBackground(new Color(52, 73, 94));
        
       
       
                
        return this;
        
    }
   
   
}
