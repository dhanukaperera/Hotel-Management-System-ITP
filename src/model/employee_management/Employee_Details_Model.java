/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.employee_management;

import app.employee_management.Employee_Details_Frame;
import static app.employee_management.Employee_Details_Frame.cmbPosition;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.HMS;
import source.DBConnection;

/**
 *
 * @author Udeshika Ranaweera
 */
public class Employee_Details_Model extends HMS 
{
    private String FirstName;
    private String EmployeeID;
    private String LastName;
    private String Address;
    private String Email;
    private String ContactNumber;
    private String JoiningDate;
    private String Bank;
    private String Gender;
    private String DateofBirth;
    private String NIC;
    private String Position;
    private String AccountNumber;
    private Image Photo;
    private String RoleType;
    private String PositionStatus;
    //InputStream 
    
    
    public Employee_Details_Model()
    {
         con = DBConnection.connect();
         
         this.FirstName = "No First Name" ;
         this.EmployeeID = "No Employee ID" ;
         this.LastName = "No Last Name" ;
         this.Address = "No Address" ;
         this.Email = "No Email" ;
         this.ContactNumber = "NULL" ;
         this.JoiningDate = "No Joining Date" ;
         this.Bank = "NULL" ;
         this.Gender = "NULL" ;
         this.DateofBirth = "No Date of Birth" ;
         this.NIC = "NULL" ;
         this.Position = "No Position" ;
         this.AccountNumber = "No Account Number" ;
         this.RoleType="No Role Type";
         this.PositionStatus="No Position Status";
         //this.Photo = "/resources/submenu/"+name+".png";
         colList = "`Employee ID`,`Date Modified`,`First Name`,`Last Name`,`Address`,`Gender`,`Date Of Birth`,`E-mail`,`NIC`,`Contact Number`,`Position`,`Position Status`,`Role Type`,`Joining Date`,`Bank`,`Account Number`";
         // System.out.println(colList);
    }
    
////////////////////////////////////////////////////getters///////////////////////////////////////////////
    public String getPrimaryKey()
    {
        setEmployeeID();
        getEmployeeID();
        return this.EmployeeID;
    }
    
    private void getEmployeeID()
    {
        this.EmployeeID = Employee_Details_Frame.txtEmployeeID.getText();
    }
    
    private void getFirstName()
    {
        this.FirstName = Employee_Details_Frame.txtFirstName.getText();
    }
    
    private void getLastName()
    {
        this.LastName = Employee_Details_Frame.txtLastName.getText();
    }
    
    private void getAddress()
    {
        this.Address = Employee_Details_Frame.txtAddress.getText();
    }
    
    private void getEmail()
    {
        this.Email = Employee_Details_Frame.txtEmail.getText();
    }
    
    private void getJoiningDate()
    {
        this.JoiningDate = getDateFromPicker(Employee_Details_Frame.dtpJoiningDate);
    }
    
    private void getBank()
    {
        this.Bank = Employee_Details_Frame.txtBank.getText();
    }
    
    private void getGender()
    {
        this.Gender = Employee_Details_Frame.cmbGender.getSelectedItem().toString();
    }
    
    private void getDateOfBirth()
    {
        this.DateofBirth = getDateFromPicker(Employee_Details_Frame.dtpDateOfBirth);
    }
    
    private void getNIC()
    {
        this.NIC = Employee_Details_Frame.txtNIC.getText();
    }
    
    private void getPosition()
    {
        this.Position = Employee_Details_Frame.cmbPosition.getSelectedItem().toString();
    }
    
    private void getAccountNumber()
    {
        this.AccountNumber = Employee_Details_Frame.txtAccountNumber.getText();
    }
    
    private void getContactNumber()
    {
        this.ContactNumber = Employee_Details_Frame.txtContactNumber.getText();
    }
    
    private void getImage()
    {
        //this.Photo = Employee_Details_Frame.getDefaultLocale();
    }
    
    private void getRoleType()
    {
        this.RoleType = Employee_Details_Frame.txtRoleType.getText();
    }
    
    private void getPositionStatus()
    {
        this.PositionStatus=Employee_Details_Frame.cmbPositionStatus.getSelectedItem().toString();
    }
    
    private void getAll()
    {
        getEmployeeID();
        getFirstName();
        getLastName();
        getAddress();
        getEmail();
        getJoiningDate();
        getBank();
        getGender();
        getDateOfBirth();
        getNIC();
        getPosition();
        getAccountNumber();
        getContactNumber();
        getRoleType();
        getPositionStatus();
            
    }
    ///////////////////////////////////////////////////setters/////////////////////////////////////////////////////
    private void setEmployeeID()
    {
        Employee_Details_Frame.txtEmployeeID.setText(Employee_Details_Frame.tblEmployeeDetails.getValueAt(getSelectedRow(Employee_Details_Frame.tblEmployeeDetails), 0).toString());
    }
    
    private void setFirstName()
    {
        Employee_Details_Frame.txtFirstName.setText(Employee_Details_Frame.tblEmployeeDetails.getValueAt(getSelectedRow(Employee_Details_Frame.tblEmployeeDetails), 2).toString());
    }
    
    private void setLastName()
    {
        Employee_Details_Frame.txtLastName.setText(Employee_Details_Frame.tblEmployeeDetails.getValueAt(getSelectedRow(Employee_Details_Frame.tblEmployeeDetails), 3).toString());
    }
    
    private void setAddress()
    {
        Employee_Details_Frame.txtAddress.setText(Employee_Details_Frame.tblEmployeeDetails.getValueAt(getSelectedRow(Employee_Details_Frame.tblEmployeeDetails), 4).toString());
    }
    
    private void setEmail()
    {
        Employee_Details_Frame.txtEmail.setText(Employee_Details_Frame.tblEmployeeDetails.getValueAt(getSelectedRow(Employee_Details_Frame.tblEmployeeDetails), 7).toString());
    }
    
    private void setJoiningDate()
    {
        Employee_Details_Frame.dtpJoiningDate.setDate(StringToDate(this.JoiningDate));
    }
    
    private void setBank()
    {
        Employee_Details_Frame.txtBank.setText(Employee_Details_Frame.tblEmployeeDetails.getValueAt(getSelectedRow(Employee_Details_Frame.tblEmployeeDetails), 14).toString());
    }
    
    private void setGender()
    {
        Employee_Details_Frame.cmbGender.setSelectedItem(Employee_Details_Frame.tblEmployeeDetails.getValueAt(getSelectedRow(Employee_Details_Frame.tblEmployeeDetails), 5).toString());
    }
    
    private void setDateOfBirth()
    {
         Employee_Details_Frame.dtpDateOfBirth.setDate(StringToDate(this.DateofBirth));
    }
    
    private void setNIC()
    {
         Employee_Details_Frame.txtNIC.setText(Employee_Details_Frame.tblEmployeeDetails.getValueAt(getSelectedRow(Employee_Details_Frame.tblEmployeeDetails), 8).toString());
    }
    
    private void setPosition()
    {
         Employee_Details_Frame.cmbPosition.setSelectedItem(Employee_Details_Frame.tblEmployeeDetails.getValueAt(getSelectedRow(Employee_Details_Frame.tblEmployeeDetails), 10).toString());
    }
    
    private void setAccountNumber()
    {
         Employee_Details_Frame.txtAccountNumber.setText(Employee_Details_Frame.tblEmployeeDetails.getValueAt(getSelectedRow(Employee_Details_Frame.tblEmployeeDetails), 15).toString());
    }
    
    private void setContactNumber()
    {
        Employee_Details_Frame.txtContactNumber.setText(Employee_Details_Frame.tblEmployeeDetails.getValueAt(getSelectedRow(Employee_Details_Frame.tblEmployeeDetails), 9).toString());
    }
    
    private void setRoleType()
    {
        Employee_Details_Frame.txtRoleType.setText(Employee_Details_Frame.tblEmployeeDetails.getValueAt(getSelectedRow(Employee_Details_Frame.tblEmployeeDetails), 12).toString());
    }
    
    private void setPositionStatus()
    {
        Employee_Details_Frame.cmbPositionStatus.setSelectedItem(Employee_Details_Frame.tblEmployeeDetails.getValueAt(getSelectedRow(Employee_Details_Frame.tblEmployeeDetails), 11).toString());
    }
    public void setAll()
    {
        setEmployeeID();
        setFirstName();
        setLastName();
        setAddress();
        setEmail();
        setJoiningDate();
        setBank();
        setGender();
        setDateOfBirth();
        setNIC();
        setPosition();
        setAccountNumber();
        setContactNumber();
        setRoleType();
        setPositionStatus();
    }
    /////////////////////////////////////////Add Query///////////////////////////////////////////////////////////////
    @Override
    public void add(String tableName) {
        
         getAll();
        String sql = "INSERT INTO "+tableName+""
                + "(`Employee ID`,`Date Modified`,`First Name`,`Last Name`,`Address`,`Gender`,`Date Of Birth`,`E-mail`,`NIC`,`Contact Number`,`Position`,`Position Status`,`Role Type`,`Joining Date`,`Bank`,`Account Number`)"
                + " VALUES('"+generatePrimaryKey("Employee ID","employee_details","EID")+"',"
                + "'"+getCurrentDateTime()+"',"
                + "'"+this.FirstName+"',"
                + "'"+this.LastName+"',"
                + "'"+this.Address+"',"
                + "'"+this.Gender+"',"
                + "'"+this.DateofBirth+"',"
                + "'"+this.Email+"',"
                + "'"+this.NIC+"',"
                + "'"+this.ContactNumber+"',"
                + "'"+this.Position+"',"
                + "'"+this.PositionStatus+"',"
                + "'"+this.RoleType+"',"
                + "'"+this.JoiningDate+"',"
                + "'"+this.Bank+"',"
                + "'"+this.AccountNumber+"'"
                + ")";
        System.err.println(sql);
          try 
        {
            pst = con.prepareStatement(sql);
            pst.execute();
            loadTable(tableName,Employee_Details_Frame.tblEmployeeDetails);   
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
//////////////////////////////////////////////Update Query//////////////////////////////////////////////////////////////////
    @Override
    public void update(String tableName) {
        
        getAll();
     
        String sql = "UPDATE "+tableName+""
                + " SET `Employee ID` = "+ "'" + this.EmployeeID + "',"
                + "`Date Modified`= '" + getCurrentDateTime() + "',"
                + "`First Name` = '" + this.FirstName + "',"
                + "`Last Name`= '" + this.LastName + "',"
                + "`Address`= '" + this.Address + "',"
                + "`Gender`= '" + this.Gender + "', "
                + "`Date Of Birth`='" + this.DateofBirth + "', "
                + "`E-mail`='" + this.Email + "', "
                + "`NIC`='" + this.NIC + "', "
                + "`Contact Number`='" + this.ContactNumber + "', "
                + "`Position`='" + this.Position + "', "
                + "`Position Status`='" + this.PositionStatus + "', "
                + "`Role Type`='" + this.RoleType + "', "
                + "`Joining Date`='" + this.JoiningDate + "', "
                + "`Bank`='" + this.Bank + "', "
                + "`Account Number`='" + this.AccountNumber + "' "
                + "WHERE `Employee ID` = '" + this.EmployeeID + "'";
        
        JOptionPane.showMessageDialog(null, sql);
        
        try 
        {
                pst = con.prepareStatement(sql);
                pst.execute();
                loadTable(tableName,Employee_Details_Frame.tblEmployeeDetails);   
        } 
        catch (Exception e) 
        {
               
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
           
    }
    
//////////////////////////////////////////////////////Category Loding///////////////////////////////////////////////////////
        public void LoadCategories()
    {
        try {
            
            String sql = "SELECT `Employee Role` FROM manage_employee_roles";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
           
             
            Employee_Details_Frame.cmbPosition.removeAllItems(); 
            while(rs.next())
            {
                String currentAccountType =  rs.getString("Employee Role");
                cmbPosition.addItem(currentAccountType);
            }
            
           
            
        } catch (Exception e) 
        {
             JOptionPane.showMessageDialog(null,"Insert Valid Record","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
///////////////////////////////////////////////////////Find Position/////////////////////////////////////////////////////////             
                public void FindRole(String Position)
       {
               this.Position= Position;
           try 
           {
           
               String Namesql="SELECT `Role Type` FROM manage_employee_roles WHERE `Employee Role`='"+this.Position+"'";
               System.out.println(Namesql);
                pst = con.prepareStatement(Namesql);
                rs = pst.executeQuery();
                
                if(rs.next())
                {
                   String searched_Name = rs.getString("Role Type");
                   Employee_Details_Frame.txtRoleType.setText(searched_Name);
               }
               
           } catch (Exception e) 
           {
                JOptionPane.showMessageDialog(null, e);
           }
       }
                
/////////////////////////////////////////////////Clear Method/////////////////////////////////////////////////////////////
    
    public void clear ()
    {
        Employee_Details_Frame.txtAccountNumber.setText("");
        Employee_Details_Frame.txtFirstName.setText("");
        Employee_Details_Frame.txtLastName.setText("");
        Employee_Details_Frame.txtAddress.setText("");
        Employee_Details_Frame.txtBank.setText("");
        Employee_Details_Frame.txtContactNumber.setText("");
        Employee_Details_Frame.txtNIC.setText("");
        Employee_Details_Frame.txtEmail.setText("");
        Employee_Details_Frame.txtEmployeeID.setText("");
        Employee_Details_Frame.txtSearch.setText("");
        Employee_Details_Frame.txtRoleType.setText("");
        
        
    }
//////////////////////////////////////////////////////Search Method////////////////////////////////////////////////////////////////    
     public void Modelsearch()
    {
        String filters = Employee_Details_Frame.cmbSearchBy.getSelectedItem().toString();
        String filter = "`"+filters+"`";
        String search=Employee_Details_Frame.txtSearch.getText();
        String tablename = "employee_details";
        JTable tblName = Employee_Details_Frame.tblEmployeeDetails;
        
        search(filter,search,tablename,tblName);

    }
     
   
    

    
}
