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

import app.employee_management.Manage_Employee_Roles_Frames;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.HMS;
import source.DBConnection;

/**
 *
 * @author Udeshika Ranaweera
 */
public class Manage_Employee_Roles_Model extends HMS{
    
    private String EmployeeRole;
    private int LeavesForaMonth;
    private double BasicSalary;
    private String RoleType;
   // private double IncrementPersentage;
    private String RecordID;
    private String PositionStatus;
    //private int AllocatedMonthlyHours;
    
    public Manage_Employee_Roles_Model()
    {
        con = DBConnection.connect();
        
        this.EmployeeRole = "NULL";
        this.LeavesForaMonth = 0;
        this.BasicSalary = 0;
        this.RoleType="NULL";
       // this.IncrementPersentage=0;
        this.RecordID="No Record ID";
        
        
        //this.AllocatedMonthlyHours = 0;
        colList = "`Record ID`,`Date Modified`,`Employee Role`,`Position Status`,`Basic Salary`,`Role Type`,`Leaves For a Month`";
         // System.out.println(colList);
    }
    
////////////////////////////////////////////////////////getter use to get details from user inputs///////////////////////////  
    
    public String getPrimaryKey()
    {
//        setEmployeeRole();
        getRecordID();
        return this.RecordID;
    }
    
    private void getRecordID()
    {
        this.RecordID=Manage_Employee_Roles_Frames.txtRecordID.getText();
    }
    private void getEmployeeRole()
    {
         this.EmployeeRole = Manage_Employee_Roles_Frames.txtEmployeeRole.getText();
    }
    
    private void getLeavesForaMonth()
    {
        this.LeavesForaMonth = Integer.parseInt(Manage_Employee_Roles_Frames.txtLeavesForaMonth.getText());
    }
    
    private void getBasicSalary()
    {
        this.BasicSalary = Double.parseDouble(Manage_Employee_Roles_Frames.txtBasicSalary.getText());
    }
    
    private void getRoleType()
    {
        this.RoleType=Manage_Employee_Roles_Frames.cmbRoleType.getSelectedItem().toString();
    }
    
    private void getPositionStatus()
    {
        this.PositionStatus=Manage_Employee_Roles_Frames.cmbPositionStatus.getSelectedItem().toString();
    }
    

    
    private void getAll()
    {
        getEmployeeRole();
        getLeavesForaMonth();
        getBasicSalary();
        getRoleType();
        getPositionStatus();
        getRecordID();

    }
//////////////////////////////////////////////////////setter for set values when click the table row/////////////////////////    
    private void setEmployeeRole()
    {
        Manage_Employee_Roles_Frames.txtEmployeeRole.setText(Manage_Employee_Roles_Frames.tblManageEmployeeRoles.getValueAt(getSelectedRow(Manage_Employee_Roles_Frames.tblManageEmployeeRoles), 2).toString());
    }
    
    private void setLeavesForaMonth()
    {
        Manage_Employee_Roles_Frames.txtLeavesForaMonth.setText(Manage_Employee_Roles_Frames.tblManageEmployeeRoles.getValueAt(getSelectedRow(Manage_Employee_Roles_Frames.tblManageEmployeeRoles), 6).toString());
    }
    
    private void setBasicSalary()
    {
        Manage_Employee_Roles_Frames.txtBasicSalary.setText(Manage_Employee_Roles_Frames.tblManageEmployeeRoles.getValueAt(getSelectedRow(Manage_Employee_Roles_Frames.tblManageEmployeeRoles), 4).toString());
    }
    
    private void setRoleType()
    {
        Manage_Employee_Roles_Frames.cmbRoleType.setSelectedItem(Manage_Employee_Roles_Frames.tblManageEmployeeRoles.getValueAt(getSelectedRow(Manage_Employee_Roles_Frames.tblManageEmployeeRoles), 5).toString());
    }
//     private void setIncrementPercentage()
//     {
//          Manage_Employee_Roles_Frames.txtIncrementPercentage.setText(Manage_Employee_Roles_Frames.tblManageEmployeeRoles.getValueAt(getSelectedRow(Manage_Employee_Roles_Frames.tblManageEmployeeRoles), 5).toString());
//     }
     
     private void setPositionStatus()
     {
         Manage_Employee_Roles_Frames.cmbPositionStatus.setSelectedItem(Manage_Employee_Roles_Frames.tblManageEmployeeRoles.getValueAt(getSelectedRow(Manage_Employee_Roles_Frames.tblManageEmployeeRoles), 3).toString());
     }
    
     
     private void setRecordID()
     {
          Manage_Employee_Roles_Frames.txtRecordID.setText(Manage_Employee_Roles_Frames.tblManageEmployeeRoles.getValueAt(getSelectedRow(Manage_Employee_Roles_Frames.tblManageEmployeeRoles), 0).toString());
     }
    
    public void setAll()
    {
        setEmployeeRole();
        setLeavesForaMonth();
        setBasicSalary();
        setRoleType();
        setPositionStatus();
        setRecordID();

    }
    
    
//////////////////////////////////////////////////////////////Add Query/////////////////////////////////////////////////////   

    @Override
    public void add(String tableName) {
    
       
        System.out.println("1");  
        getAll();
        System.out.println("2");
        String sql = "INSERT INTO "+tableName+""
                + "(`Record ID`,`Date Modified`,`Employee Role`,`Position Status`,`Basic Salary`,`Role Type`,`Leaves For a Month`)"
                + " VALUES("
                + "'"+generatePrimaryKey("Record ID", "manage_employee_roles", "ME")+"',"
                + "'"+getCurrentDateTime()+"',"
                + "'"+this.EmployeeRole+"',"
                + "'"+this.PositionStatus+"',"
                + ""+this.BasicSalary+","
                //+ ""+this.IncrementPersentage+","
                + "'"+this.RoleType+"',"
                + ""+this.LeavesForaMonth+""
                + ")";
        System.out.println(sql);
        
        try 
        {
            pst = con.prepareStatement(sql);
            pst.execute();
            loadTable(tableName,Manage_Employee_Roles_Frames.tblManageEmployeeRoles);   
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
       
       
    }
//////////////////////////////////////////////////////////////////////update Query//////////////////////////////////////////
    @Override
    public void update(String tableName) {
        
          getAll();
     
        String sql = "UPDATE "+tableName+""
                + " SET `Date Modified`= '" + getCurrentDateTime() + "',"
                + "`Employee Role`= '" + this.EmployeeRole + "',"
                + "`Position Status` = '" + this.PositionStatus + "',"
                + "`Basic Salary` = " + this.BasicSalary + ","
//                + "`Increment Percentage` = " + this.IncrementPersentage + ","
                + "`Role Type` = '" + this.RoleType + "'"
//                + "`Leaves For a Month`= " + this.LeavesForaMonth + " "
                + "WHERE `Record ID` = '" + this.RecordID + "' ";
        
        //JOptionPane.showMessageDialog(null, sql);
        
        try 
        {
                pst = con.prepareStatement(sql);
                pst.execute();
                loadTable(tableName,Manage_Employee_Roles_Frames.tblManageEmployeeRoles);   
        } 
        catch (Exception e) 
        {
               
            JOptionPane.showMessageDialog(null,e);
            //,"Error",JOptionPane.ERROR_MESSAGE
        }
    }
    
/////////////////////////////////////////////////Clear Method////////////////////////////////////////////////////////////////
    public void clear()
    {
        //Manage_Employee_Roles_Frames.txtAllocatedMonthlyHours.setText("");
        Manage_Employee_Roles_Frames.txtEmployeeRole.setText("");
        Manage_Employee_Roles_Frames.txtBasicSalary.setText("");
        Manage_Employee_Roles_Frames.txtLeavesForaMonth.setText("");
        Manage_Employee_Roles_Frames.txtSearchBox.setText("");
    }
///////////////////////////////////////////////////Search///////////////////////////////////////////////////////////////////    
      public void Modelsearch()
    {
        String filters = Manage_Employee_Roles_Frames.cmbSearchBy.getSelectedItem().toString();
        String filter = "`"+filters+"`";
        String search=Manage_Employee_Roles_Frames.txtSearchBox.getText();
        String tablename = "manage_employee_roles";
        JTable tblName = Manage_Employee_Roles_Frames.tblManageEmployeeRoles;
        
        search(filter,search,tablename,tblName);

    }
     
    
}
