/*
 * Hotel Management System for Pavana Hotel Kochchikade
 * Information Technology Project - 2016
 * Project ID   : ITP_WD_16_B1_06
 * Supervisor   : Mrs. Asanthika Imbulpitiya
 *
 * Student Name : Kaushalya R.U
 * IT Number    : IT14087202
 */
package model.employee_management;

import app.employee_management.System_Users_Frame;
//import static app.employee_management.System_Users_Frame.cmbAccountType;
import static app.employee_management.System_Users_Frame.txtName;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.HMS;
import source.DBConnection;

/**
 *
 * @author Udeshika Ranaweera
 */
public class System_Users_Model extends HMS{
    
    private String EmployeeID;
    private String Name;
    private String AccountType;
    private String AccountID;
    private String Username;
    private String Password;
    private String DefaultPassword;
    
    
    public System_Users_Model()
    {
        con = DBConnection.connect();
        this.AccountID = "NULL";
        this.EmployeeID = "NULL";
        this.Name = "No Name";
        this.AccountType = "No Account Type";
        this.Username = "No Username";
       
        colList = "`Account ID`,`Employee ID`,`Date Modified`,`Name`,`Account Type`,`Username`";
        // System.out.println(colList);
        
    }
    
//////////////////////////////////////////////////////////getters////////////////////////////////////////////////////////////    
    
     public String getPrimaryKey()
    {
        setAccountID();
        getAccountID();
        return this.AccountID;
    }
    
    private void getAccountID()
    {
        this.AccountID = System_Users_Frame.txtAccountID.getText();
    }
    
    private void getEmployeeID()
    {
        this.EmployeeID = System_Users_Frame.cmbEmployeeID.getSelectedItem().toString();
    }
    
    private void getName()
    {
        this.Name = System_Users_Frame.txtName.getText();
    }
    
    private void getUsername()
    {
        this.Username = System_Users_Frame.txtUsername.getText();
    }
    
  
    
    private void getAccountType()
    {
        //this.AccountType = System_Users_Frame.cmbAccountType.getSelectedItem().toString();
        this.AccountType=System_Users_Frame.txtAccountType.getText();
    }
    
 
    
    
    private void getAll()
    {
        getAccountID();
        getEmployeeID();
        getName();
        getUsername();
        
        getAccountType();
        
    }
////////////////////////////////////////////////////////////////setters///////////////////////////////////////////////////////   
    private void setAccountID()
    {
         System_Users_Frame.txtAccountID.setText(System_Users_Frame.tblSystemUsers.getValueAt(getSelectedRow(System_Users_Frame.tblSystemUsers), 0).toString());
    
    }
    
    private void setEmployeeID()
    {
        System_Users_Frame.cmbEmployeeID.setSelectedItem(System_Users_Frame.tblSystemUsers.getValueAt(getSelectedRow(System_Users_Frame.tblSystemUsers), 1).toString());
    }
    
    private void setName()
    {
        System_Users_Frame.txtName.setText(System_Users_Frame.tblSystemUsers.getValueAt(getSelectedRow(System_Users_Frame.tblSystemUsers), 3).toString());
    }
    
    private void setUsername()
    {
        System_Users_Frame.txtUsername.setText(System_Users_Frame.tblSystemUsers.getValueAt(getSelectedRow(System_Users_Frame.tblSystemUsers), 5).toString());
    }

    private void setAccountType()
    {
        //System_Users_Frame.cmbAccountType.setSelectedItem(System_Users_Frame.tblSystemUsers.getValueAt(getSelectedRow(System_Users_Frame.tblSystemUsers), 4).toString());
         System_Users_Frame.txtAccountType.setText(System_Users_Frame.tblSystemUsers.getValueAt(getSelectedRow(System_Users_Frame.tblSystemUsers), 4).toString());
    }
    
  
    
   
    
    public void setAll()
    {
        setAccountID();
        setEmployeeID();
        setName();
        setUsername();
        setAccountType();
      
    }
    
    
///////////////////////////////////////////////////////////Add Query/////////////////////////////////////////////////////////    
    
    @Override
    public void add(String tableName) {
         getAll();
        String sql = "INSERT INTO "+tableName+""
                + "(`Account ID`,`Employee ID`,`Date Modified`,`Name`,`Account Type`,`Username`)"
                + " VALUES('"+generatePrimaryKey("Account ID","account","AC")+"',"
                //+ "'"+this.AccountID+"',"
                + "'"+this.EmployeeID+"',"
                + "'"+getCurrentDateTime()+"',"
                + "'"+this.Name+"',"
                + "'"+this.AccountType+"',"
                + "'"+this.Username+"'"
                + ")";
        System.out.println(sql);
        
        try 
        {
            pst = con.prepareStatement(sql);
            pst.execute();
            loadTable(tableName,System_Users_Frame.tblSystemUsers);   
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
////////////////////////////////////////////////////////Update Query//////////////////////////////////////////////////////////
    @Override
    public void update(String tableName) {
        
        getAll();
     
        String sql = "UPDATE "+tableName+""
                + " SET `Employee ID` = '" + this.EmployeeID + "',"
//                + "`Employee ID` = '" + this.EmployeeID + "',"
                + "`Date Modified`= '" + getCurrentDateTime() + "',"
                + "`Name` = '" + this.Name + "',"
                + "`Account Type`= '" + this.AccountType + "',"
                + "`Username`= '" + this.Username + "' "
                + "WHERE `Account ID` = '" + this.AccountID + "'";
        
        System.out.println(sql);
        
        try 
        {
                pst = con.prepareStatement(sql);
                pst.execute();
                loadTable(tableName,System_Users_Frame.tblSystemUsers);   
        } 
        catch (Exception e) 
        {
               
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
////////////////////////////////////////////////Finding Employee Name////////////////////////////////////////////////////////    
    public void findName(String EmployeeID)
       {
               this.EmployeeID= EmployeeID;
           try 
           {
           
               String Namesql="SELECT `First Name` FROM employee_details WHERE `Employee ID`='"+this.EmployeeID+"'";
               System.out.println(Namesql);
                pst = con.prepareStatement(Namesql);
                rs = pst.executeQuery();
                
                if(rs.next())
                {
                   String searched_Name = rs.getString("First Name");
                   txtName.setText(searched_Name);
               }
               
           } catch (Exception e) 
           {
                JOptionPane.showMessageDialog(null, e);
           }
       }
    
    
///////////////////////////////////Load Employee Role To textBox when Employee ID selected///////////////////////////////////////////////////////////
    
    public void loadRole(String EmployeeID)
       {
           this.EmployeeID=EmployeeID;
           try {
               
                String Rol="SELECT `Position` FROM `employee_details` WHERE `Employee ID`='"+this.EmployeeID+"'";
            pst=con.prepareStatement(Rol);
               rs=pst.executeQuery();
               
                 while(rs.next())
               {
                   String id = rs.getString("Position");
                  // JOptionPane.showMessageDialog(null,id);
                   System_Users_Frame.txtAccountType.setText(id);
                  
               }
               
           } catch (Exception e) {
           }
               
       }
//////////////////////////////////////////////////////////Clear Method///////////////////////////////////////////////////////    
    public void clear()
    {
       
        System_Users_Frame.txtUsername.setText("");
//      System_Users_Frame.txtEmployeeID.setText("");
        System_Users_Frame.txtName.setText("");
        System_Users_Frame.txtAccountID.setText("");
        System_Users_Frame.txtSearchBox.setText("");
        System_Users_Frame.txtAccountType.setText("");
        
    }
/////////////////////////////////////Search Method///////////////////////////////////////////////////////////////////////////    
         public void Modelsearch()
    {
        String filters = System_Users_Frame.cmbSearchBy.getSelectedItem().toString();
        String filter = "`"+filters+"`";
        String search=System_Users_Frame.txtSearchBox.getText();
        String tablename = "account";
        JTable tblName = System_Users_Frame.tblSystemUsers;
        
        search(filter,search,tablename,tblName);

    }
         
//////////////////////////////////////////////////////Load Employee IDs///////////////////////////////////////////////////////         
           public void LoadEmployeeID2()
       {
           try {
               String sql="SELECT `Employee ID` FROM employee_details";
               pst=con.prepareStatement(sql);
               rs=pst.executeQuery();
               System_Users_Frame.cmbEmployeeID.removeAllItems();
               while(rs.next())
               {
                   String id=rs.getString("Employee ID");
                   System_Users_Frame.cmbEmployeeID.addItem(id);
               }
           } 
           catch (Exception e) 
           {
               JOptionPane.showMessageDialog(null,"error","error", JOptionPane.ERROR_MESSAGE);
           }
       }
    
    
    
    
}
