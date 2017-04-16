/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.restaurant_management;

import model.HMS;
import source.DBConnection;
import app.restaurant_management.Food_And_Drink_Details_Frame;
import static app.restaurant_management.Food_And_Drink_Details_Frame.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Sachin
 */
public class Food_And_Drink_Details_Model extends HMS {

    private String Type;
    private String Name;
    private float price; 
    private String Details;
    private String gennewID;
    private String Available;
    private String Todays_Especial;
    private String From;
    private String To;
    private String Seasonal_offers;
    
    Restaurant_Bill_Model restbill = new Restaurant_Bill_Model();
    Dine_In_Bill_Model Dinein = new Dine_In_Bill_Model();
    Room_Guest_Orders_Model roomguest = new Room_Guest_Orders_Model();

    
    public Food_And_Drink_Details_Model ()
    {
        con = DBConnection.connect();
        
        this.Type = "No Type";
        this.Name = "No Name";
        this.price = 0;
        this.Details = "";
        this.gennewID = "";
        this.Available = "-";
        this.Todays_Especial = "-";
        this.From = "-";
        this.To = "-";
        this.Seasonal_offers="-";
        
       
    }

//get the primary key to pass to the delete query//////////////////////////////////////////////////////////////////////////////    
    
    public String getPrimaryKey()
    {
        String FOBID = Food_And_Drink_Details_Frame.tblFood_drink_info.getValueAt(getSelectedRow(Food_And_Drink_Details_Frame.tblFood_drink_info), 0).toString();

        return FOBID;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//table load method//////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void tableloadmethod()
    {
        String sql = "SELECT `FOB ID`, `Date Modified`,`Type`, `Name`, `Price`, `Details`, `Available` FROM `food_drink_info`";
        
        try 
        {
              
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery(); 
            tblFood_drink_info.setModel(DbUtils.resultSetToTableModel(rs));
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
///getters//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    private void getType() {this.Type = Food_And_Drink_Details_Frame.cmbType.getSelectedItem().toString();}
    
    private void getName() {this.Name = Food_And_Drink_Details_Frame.txtName.getText();}
    
    private void getprice() {this.price = Float.parseFloat(Food_And_Drink_Details_Frame.txtPrice.getText()) ;}
    
    private void getDetails() {this.Details = Food_And_Drink_Details_Frame.txtDetails.getText();}
    
    private void getAvailable() 
    {   
        if(checkAvailable.isSelected())
            this.Available = "YES" ;
        else
            this.Available = "NO";
    }

        
    private void getAll()
    {
     getType();
     getName();
     getprice();
     getDetails();
     getAvailable();
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
//setters///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
   private void setType() { Food_And_Drink_Details_Frame.cmbType.setSelectedItem(Food_And_Drink_Details_Frame.tblFood_drink_info.getValueAt(getSelectedRow(Food_And_Drink_Details_Frame.tblFood_drink_info), 2).toString());}
   
   private void setName() { Food_And_Drink_Details_Frame.txtName.setText(Food_And_Drink_Details_Frame.tblFood_drink_info.getValueAt(getSelectedRow(Food_And_Drink_Details_Frame.tblFood_drink_info), 3).toString());}

   private void setPrice() { Food_And_Drink_Details_Frame.txtPrice.setText(Food_And_Drink_Details_Frame.tblFood_drink_info.getValueAt(getSelectedRow(Food_And_Drink_Details_Frame.tblFood_drink_info), 4).toString());}

   private void setDetails() {Food_And_Drink_Details_Frame.txtDetails.setText(Food_And_Drink_Details_Frame.tblFood_drink_info.getValueAt(getSelectedRow(Food_And_Drink_Details_Frame.tblFood_drink_info), 5).toString());}
   
   private void setAvailable()
   {
       checkAvailable.setSelected(false);
       String value = Food_And_Drink_Details_Frame.tblFood_drink_info.getValueAt(getSelectedRow(Food_And_Drink_Details_Frame.tblFood_drink_info), 6).toString();
    
        if(value.equals("YES")) {checkAvailable.setSelected(true);}
        else{checkAvailable.setSelected(false);}
   }
   
    public void setAll()
     {
         setType();
         setName();
         setPrice();
         setDetails();
         setAvailable();
         
         String seasonal_offers = Food_And_Drink_Details_Frame.tblFood_drink_info.getValueAt(getSelectedRow(Food_And_Drink_Details_Frame.tblFood_drink_info), 7).toString();
         

     }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
/////Generate Primary key////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void genprimarykey()
    {
        int count=0;

          String getcount = "SELECT Number FROM food_drink_info ORDER BY Number DESC LIMIT 1";
        
        try 
        {
            pst = con.prepareStatement(getcount);
            rs = pst.executeQuery();
            
            if(rs.next())
            {
                    count = rs.getInt("Number");
            }
        }
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        //adding a 1 and adding 0 value infront
        count = count+1;
        String formatted = String.format("%03d", count);
        
        //Creating the final ID
        this.gennewID = "FD-"+formatted;
        
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
//adding values to the Food and drink details////////////////////////////////////////////////////////////////////////////////////
    
    @Override
    public void add(String tableName) {
        
        getAll();
        genprimarykey();
                
        //if seasonal offer is not selected/////////////////////////////////////////////////////
      
            String sql = "INSERT INTO "+tableName+""
                + "(`FOB ID`,`Type`, `Date Modified`, `Name`, `Price`, `Details`,`Available`)"
                + " VALUES("
                + "'"+this.gennewID+"',"
                + "'"+this.Type+"',"
                + "'"+getCurrentDateTime()+"',"
                + "'"+this.Name+"',"
                + ""+this.price+","
                + "'"+this.Details+"',"
                + "'"+this.Available+"'"
                + ")";
             
        try 
        {
            pst = con.prepareStatement(sql);
            pst.execute();
            tableloadmethod();  
            JOptionPane.showMessageDialog(null,"Added Successfully","Successful Message",JOptionPane.INFORMATION_MESSAGE);
            
            Dinein.LoadName();
            restbill.LoadName();
            roomguest.LoadName();
            
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
            
        clear();
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////Update code of the food and drink details///////////////////////////////////////////////////////////////////////////////
    
    @Override
    public void update(String tableName) {
        
         
        getAll();
  
        
        //if seasonal offer is selected/////////////////////////////////////////////////////
       
        
            try 
        {
        
        String FOBID = Food_And_Drink_Details_Frame.tblFood_drink_info.getValueAt(getSelectedRow(Food_And_Drink_Details_Frame.tblFood_drink_info), 0).toString();
                
        String sql = "UPDATE "+tableName+""
                + " SET `Type` = "+"'" + this.Type + "',"
                + "`Date Modified`= '" + getCurrentDateTime() + "',"
                + "`Name` = '" + this.Name + "',"
                + "`Price`=" + this.price + ","
                + "`Details`='" + this.Details + "',"
                + "`Available`='"+this.Available+"'"
                + "WHERE `FOB ID` = '" +FOBID+ "'";
        
        
                pst = con.prepareStatement(sql);
                pst.execute();
                tableloadmethod(); 
                JOptionPane.showMessageDialog(null,"Updated Successfully","Successful Message",JOptionPane.INFORMATION_MESSAGE);
        
                Dinein.LoadName();
                restbill.LoadName();
                roomguest.LoadName();
        } 
         
        catch (Exception e) 
        {    
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
            
        
        
          clear();
        
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
/////////clear code/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void clear()
    {
        txtName.setText("");
        txtPrice.setText("");
        txtDetails.setText("");
        checkAvailable.setSelected(false);

    }
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
//////searching////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void Modelsearch()
    {
        String filters = cmbSearchBy.getSelectedItem().toString();
        String filter = "`"+filters+"`";
        String search=txtSearch.getText();
        String tablename = "food_drink_info";
        JTable tblName = tblFood_drink_info;
        
        search(filter,search,tablename,tblName);

    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//ispositive validation////////////////////////////////////////////////////////////////////////////////////////////
    
//if checking a float//////////////////////////////////////////////////////////////////////////////////////////////
    
    public static boolean isPositivefloat(JTextField txtFieldName, String errorMessage)
    {
        
    float number = Float.parseFloat(txtFieldName.getText());
        if(number>=0)
        {
        return true;
        
        }
        else
        {
        
        JOptionPane.showMessageDialog(null,errorMessage,"Insert valid numbers" ,JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    
    
    
}
