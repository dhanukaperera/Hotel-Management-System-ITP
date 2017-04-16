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
public class mulitline extends JTextArea implements TableCellRenderer {

    public mulitline() {
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
       //setBackground(new Color(52, 73, 94));
        //setEditable(false);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {//
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

        if(x.length()> 20 && x.length() < 40)
        {
             table.setRowHeight(row,45);
        }
        else if(x.length()> 40 && x.length() < 60)
        {
             table.setRowHeight(row,65);
        }
        else if(x.length()> 60 && x.length() < 80)
        {
             table.setRowHeight(row,85);
        }
        else if(x.length()> 80 && x.length() < 100)
        {
             table.setRowHeight(row,105);
        }
        else if(x.length()> 100 && x.length() < 120)
        {
             table.setRowHeight(row,125);
        }
        else if(x.length()> 120 && x.length() < 140)
        {
             table.setRowHeight(row,145);
        }
        else if(x.length()> 140 && x.length() < 160)
        {
             table.setRowHeight(row,165);
        }
        else if(x.length()> 160 && x.length() < 180)
        {
             table.setRowHeight(row,185);
        }
        else if(x.length()> 180 && x.length() < 200)
        {
             table.setRowHeight(row,205);
        }
        else if(x.length()> 200 && x.length() < 220)
        {
             table.setRowHeight(row,225);
        }
        else if(x.length()> 220 && x.length() < 240)
        {
             table.setRowHeight(row,245);
        }
        else if(x.length()> 240 && x.length() < 260)
        {
             table.setRowHeight(row,265);
        }
        else 
        {
             table.setRowHeight(row,25);
        }
        
        // ------------------------------------------------
        
        //System.out.println(row + "-->" + x.length());
        //table.setAutoResizeMode(column);
       
        //JTextField editor = new JTextField();
        
      //editor.setText(value.toString());
    setBackground((row % 2 == 0) ? new Color(52, 73, 94) : new Color(44, 62, 80));
      
        //setBackground(new Color(52, 73, 94));
        
       
       
                
        return this;
    }

}
