/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.restaurant_management;

import static app.restaurant_management.All_Bill_Details_Details_Frame.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.HMS;
import source.DBConnection;
import net.proteanit.sql.DbUtils;
import source.DBConnection;

/**
 *
 * @author Sachin
 */
public class All_Bill_Details_Model extends HMS {
    
    public All_Bill_Details_Model()
    {
     con = DBConnection.connect();
     
    }
    
    
    //table load method for takeout orders//////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void takeoutorderstableloadmethod()
    {
        String sql = "SELECT * FROM `takeoutorders_bill_info`";
        
        try 
        {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery(); 
            tbltakeoutorders.setModel(DbUtils.resultSetToTableModel(rs));
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

//table load method for Restaurant bill orders/////////////////////////////////////////////////////////////////////////////
    
    public void restaurantorderstableloadmethod()
    {
        String sql = "SELECT * FROM `restaurant_bill`";
        
        try 
        {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery(); 
            tblRestaurantBill.setModel(DbUtils.resultSetToTableModel(rs));
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    //////searching takeout orders////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void Modelsearchtakout()
    {
        String filters = cmbSearchByTakeout.getSelectedItem().toString();
        String filter = "`"+filters+"`";
        String search=txtSearchtakeoutorders.getText();
        String tablename = "takeoutorders_bill_info";
        JTable tblName = tbltakeoutorders;
        
        search(filter,search,tablename,tblName);

    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

     
    //////searching takeout orders////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void Modelsearchdinein()
    {
        String filters = cmbSearchByDineIn.getSelectedItem().toString();
        String filter = "`"+filters+"`";
        String search=txtSearchRestaurantOrders.getText();
        String tablename = "restaurant_bill";
        JTable tblName = tblRestaurantBill;
        
        search(filter,search,tablename,tblName);

    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    
    
    
    @Override
    public void add(String tableName) {
        
    }

    @Override
    public void update(String tableName) {
       
    }
}
