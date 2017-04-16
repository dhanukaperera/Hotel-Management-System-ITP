package model.restaurant_management;
import app.restaurant_management.Dine_In_Bill_Frame;
import app.restaurant_management.Restaurant_Settings_Frame;
import static app.restaurant_management.Restaurant_Settings_Frame.txtDiscountType;
import static app.restaurant_management.Restaurant_Settings_Frame.*;
import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.HMS;
import net.proteanit.sql.DbUtils;
import source.DBConnection;

/**
 *
 * @author Sachin
 */
public class Restaurant_Settings_Model extends HMS{
    
    private float Adultpoolcharge;
    private String tablenumber;
    private int gettablenumber;
    
    Restaurant_Bill_Model restbill = new Restaurant_Bill_Model();
    Dine_In_Bill_Model Dinein = new Dine_In_Bill_Model();
    
    public Restaurant_Settings_Model()
    {
        con = DBConnection.connect();
        this.Adultpoolcharge = 0;
        
    }
 
 //loading pool charges to the txtboxes//////////////////////////////////////////////////////////////////////////
    
    public void loadpoolcharges()
    {
        try {
            
            String sql = "SELECT `Pool Charges` FROM `restaurant_settings` where Number=1";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next())
            {
                String Adultcharge =  rs.getString("Pool Charges"); 
                Restaurant_Settings_Frame.txtAdultpoolcharge.setText(Adultcharge);
            }         
            
           String sql2 = "SELECT `Pool Charges` FROM `restaurant_settings` where Number=2";
            pst = con.prepareStatement(sql2);
            rs = pst.executeQuery();
            
            if(rs.next())
            {
                String childcharge =  rs.getString("Pool Charges"); 
                Restaurant_Settings_Frame.txtChildpoolcharge.setText(childcharge);
            }         
            
        } 
         
         catch (Exception e) 
        {
             JOptionPane.showMessageDialog(null,e);
        }
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //update pool charges///////////////////////////////////////////////////////////////////////////////////////////////
     
    public void updatepoolcharges()
    {
        try{
   
        float adultpoolcharge = Float.parseFloat(txtAdultpoolcharge.getText());
        
         String sql = "UPDATE `restaurant_settings`"
                + " SET `Pool Charges` = "+"" +adultpoolcharge + ""
                + "WHERE `Number` = 1";
               
                pst = con.prepareStatement(sql);
                pst.execute();
        }
        
        catch (Exception e) 
        {
               
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
        try{
   
        float childpoolcharge = Float.parseFloat(txtChildpoolcharge.getText());
        
         String sql2 = "UPDATE `restaurant_settings`"
                + " SET `Pool Charges` = "+"" +childpoolcharge + ""
                + "WHERE `Number` = 2";
         
          
                pst = con.prepareStatement(sql2);
                pst.execute();
                
                  JOptionPane.showMessageDialog(null,"Updated Successfully");
        }
        
        catch (Exception e) 
        {
               
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }

        
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
   public void loadTableNumbers()
   {
       
       String sql = "SELECT `Table No` FROM `restaurant_settings`";
        
        try 
        {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery(); 
            tblTableNumbers.setModel(DbUtils.resultSetToTableModel(rs));
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
   }
   
  
   public void settdiscountdol1() { Restaurant_Settings_Frame.txtDiscountType.setText(Restaurant_Settings_Frame.tblDiscount.getValueAt(getSelectedRow(Restaurant_Settings_Frame.tblDiscount), 0).toString());}

   public void settdiscountdol2() { Restaurant_Settings_Frame.txtPercentage.setText(Restaurant_Settings_Frame.tblDiscount.getValueAt(getSelectedRow(Restaurant_Settings_Frame.tblDiscount), 1).toString());}


   public void loaddiscount()
   {
       try 
            {
                
             String discounttype = txtDiscountType.getText();
             String Percentage = txtPercentage.getText();
             
             float percentagevalue = Float.parseFloat(Percentage);
    
            String sql = "INSERT INTO discount_details"
                    + "(`Type`,`Percentage`)"
                    + " VALUES("
                    + "'"+discounttype+"',"
                    + ""+percentagevalue+""
                    + ")";
            
          

                pst = con.prepareStatement(sql);
                pst.execute();
                tableloadmethod();  
                JOptionPane.showMessageDialog(null,"Added Successfully","Successful Message",JOptionPane.INFORMATION_MESSAGE);
                
                restbill.loadDiscount();
                Dinein.loadDiscount();
                
                txtDiscountType.setText("");
                txtPercentage.setText("");
                
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
       
       
   }
   
   
     
    public void deletediscount()
    {
        String dicounttype = txtDiscountType.getText();
        
          String sql = "DELETE FROM `discount_details`"
                + "WHERE `Type` ='"+dicounttype+"'";
        
        try 
        {   
            pst = con.prepareStatement(sql);
            pst.execute();
           tableloadmethod();
           
            txtDiscountType.setText("");
            txtPercentage.setText("");
            
            JOptionPane.showMessageDialog(null,"Record DELETED Sucessfully");    
        } 
        catch (SQLException | HeadlessException e) 
        {
             JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
        Dinein.loadDiscount();
        restbill.loadDiscount();
        
    }
    
   
   public void tableloadmethod()
   {
       String sql = "SELECT `Type`,`Percentage` FROM `discount_details`";
        
        try 
        {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery(); 
            tblDiscount.setModel(DbUtils.resultSetToTableModel(rs));
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
   }
    

    @Override
    public void add(String tableName) {
        
    }

    @Override
    public void update(String tableName) {
        
    }
    
    //load the table number table//////////////////////////////////////////////////////////////////////////////
    
    public void loadtablenumbertable()
    {
        String sql = "SELECT `Table No` FROM `restaurant_settings`";
        
        try 
        {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery(); 
            tblTableNumbers.setModel(DbUtils.resultSetToTableModel(rs));
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    
      public void settablenumebr() { Restaurant_Settings_Frame.txtAddNewTable.setText(Restaurant_Settings_Frame.tblTableNumbers.getValueAt(getSelectedRow(Restaurant_Settings_Frame.tblTableNumbers), 0).toString());}
    
    //add table numbers to the table////////////////////////////////////////////////////////////////////////////
    
    public void addtablenumbers()
    {
        
        
        int tabnum = Integer.parseInt(txtAddNewTable.getText());
        try 
            {
                  
            String sql = "INSERT INTO `restaurant_settings`"
                    + "(`Table No`)"
                    + " VALUES("
                    + "'"+tabnum+"'"
                    + ")";
            
                pst = con.prepareStatement(sql);
                pst.execute();
                loadtablenumbertable();
                Dinein.loadtablenumbers();
                JOptionPane.showMessageDialog(null,"Added Successfully","Successful Message",JOptionPane.INFORMATION_MESSAGE); 
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
            
        txtAddNewTable.setText("");
        
        Dinein.loadtablenumbers();
        
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    public void delete()
    {
        int tablenum = Integer.parseInt(txtAddNewTable.getText());
        
          String sql = "DELETE FROM `restaurant_settings`"
                + "WHERE `Table No` ='"+tablenum+"'";
        
        try 
        {   
            pst = con.prepareStatement(sql);
            pst.execute();
            loadtablenumbertable();
            txtAddNewTable.setText("");
            JOptionPane.showMessageDialog(null,"Record DELETED Sucessfully");    
        } 
        catch (SQLException | HeadlessException e) 
        {
             JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
        Dinein.loadtablenumbers();
        
    }
    
   
    
    //ispositive validation////////////////////////////////////////////////////////////////////////////////////////////
    
//if checking a float//////////////////////////////////////////////////////////////////////////////////////////////
    
    public static boolean isPositiveint(JTextField txtFieldName, String errorMessage)
    {
        
    int number = Integer.parseInt(txtFieldName.getText());
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
