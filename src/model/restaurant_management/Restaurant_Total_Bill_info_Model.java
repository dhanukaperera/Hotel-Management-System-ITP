/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.restaurant_management;

import source.DBConnection;
import model.HMS;
import app.restaurant_management.All_Bill_Details_Details_Frame;
import static app.restaurant_management.All_Bill_Details_Details_Frame.*;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Sachin
 */
public class Restaurant_Total_Bill_info_Model extends HMS {
 
    
    public Restaurant_Total_Bill_info_Model ()
    {
        con = DBConnection.connect();
        
       
        
    }

    @Override
    public void add(String tableName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(String tableName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }
    
 