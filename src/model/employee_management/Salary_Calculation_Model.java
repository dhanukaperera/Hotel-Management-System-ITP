/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.employee_management;

import app.employee_management.Salary_Calculation_Frame;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static jdk.nashorn.internal.parser.DateParser.DAY;
import model.HMS;
import reports.iReport;
import reports.iReportView;
import source.DBConnection;
import static reports.iReport.PROJECT_PATH;

/**
 *
 * @author Udeshika Ranaweera
 */
public class Salary_Calculation_Model extends HMS {

    private String SalaryFromDate;
    private String SalaryToDate;
    private String SalaryRecordNumber;
    //private int ScheduledHours;
    private int Attendance;
    private int Leaves;
    private double OTHourlyRate;
    private String EmployeeID;
    private String Role;
    private double BasicSalary;
    private int OTHours;
    private double Bonus;
    private double EPF;
    private double EPF12;
    private double ETF;
    private double TotalSalary;
    private String Month;
    private int WorkedHours;
    private String Bank;
    private String AccountNumber;
    private String BonusType;
    private String PositionType;

    public Salary_Calculation_Model() {
        con = DBConnection.connect();
        
        this.SalaryRecordNumber = "NULL";       
        this.EmployeeID = "No Employee ID";
        this.Attendance = 0;
        this.Bonus = 0;
        this.EPF = 0;
        this.ETF = 0;
        this.BasicSalary = 0;
        this.Leaves = 0;
        this.OTHourlyRate = 0;
        this.OTHours = 0;
       // this.ScheduledHours = 0;
        this.WorkedHours = 0;
        this.Month="NULL";
        this.Role = "No Role";
        this.SalaryFromDate = "NULL";
       this.SalaryToDate = "NULL";
        this.TotalSalary = 0;
        this.EPF12=0;
       this.BonusType="No Bonus";
       this.PositionType="No Position";
        

        colList="`SalaryRecordNumber`,`Date Modified`,`Salary From Date`,`Salary To Date`,`Employee ID`,`Bank`,`AccountNumber`,`Role`,`Attendance`,`Leaves`,`BasicSalary`,`WorkedHours`,`EPF`,`EPF12`,`ETF`,`OTHours`,`OTHourlyRate`,`Bonus Type`,`Bonus`,`TotalSalary`,`Position Type`";
    }
////////////////////////////////////////////////////////getters/////////////////////////////////////////////////////////////
    public String getPrimaryKey() {
        setSalaryRecordNumber();
        getSalaryRecordNumber();
        return this.SalaryRecordNumber;
    }

    private void getEmployeeID() {
        this.EmployeeID = Salary_Calculation_Frame.cmbEmployeeID.getSelectedItem().toString();
    }

    private void getSalaryRecordNumber() {
        this.SalaryRecordNumber = Salary_Calculation_Frame.txtSalaryRecordNumber.getText();
    }

    private void getAttendance() {
        this.Attendance = Integer.parseInt(Salary_Calculation_Frame.txtAttendance.getText());
    }

    private void getLeaves() {
        this.Leaves = Integer.parseInt(Salary_Calculation_Frame.txtLeaves.getText());
    }

    private void getBasicSalary() {
        this.BasicSalary = Double.parseDouble(Salary_Calculation_Frame.txtBasicSalary.getText());
    }

    private void getSalaryFromDate() {
        this.SalaryFromDate = getDateFromPicker(Salary_Calculation_Frame.dtpSalaryFromDate);
    }

    private void getSalaryToDate() {
        this.SalaryToDate = getDateFromPicker(Salary_Calculation_Frame.dtpSalaryToDate);
    }

    private void getRole() {
        this.Role = Salary_Calculation_Frame.txtRole.getText();
    }

    private void getWorkedHours() {
        this.WorkedHours = Integer.parseInt(Salary_Calculation_Frame.txtWorkedHours.getText());
    }

    private void getOTHours() {
        this.OTHours = Integer.parseInt(Salary_Calculation_Frame.txtOTHours.getText());
    }

    private void getOTHourlyRate() {
        this.OTHourlyRate = Double.parseDouble(Salary_Calculation_Frame.txtOTHourslyRate.getText());
    }

    private void getBonus() {
        this.Bonus = Double.parseDouble(Salary_Calculation_Frame.txtBonus.getText());
    }
    private void getBank()
    {
        this.Bank=Salary_Calculation_Frame.txtBank.getText();
    }
    private void getAccountNumber()
    {
        this.AccountNumber=Salary_Calculation_Frame.txtAccountNumber.getText();
    }

    private void getEPF()
    {
        this.EPF=Double.parseDouble(Salary_Calculation_Frame.txtEPF.getText());
    }
    
    private void getETF()
    {
        this.ETF=Double.parseDouble(Salary_Calculation_Frame.txtETF.getText());
    }
    
    private void getEPF12()
    {
        this.EPF12=Double.parseDouble(Salary_Calculation_Frame.txtEPF12.getText());
    }

        private void getBonusType()
    {
        this.BonusType=Salary_Calculation_Frame.txtBonusType.getText();
    }
    
    private void getTotal()
    {
        this.TotalSalary=Double.parseDouble(Salary_Calculation_Frame.txtTotal.getText());
    }
    private void getPositionType()
    {
        this.PositionType=Salary_Calculation_Frame.txtPositionType.getText();
    }
    private void getAll() {
        getEmployeeID();
        getBonus();
        getOTHourlyRate();
        getOTHours();
        getWorkedHours();
        getRole();
        getSalaryToDate();
        getBasicSalary();
        getLeaves();
        getAttendance();
        getSalaryRecordNumber();
        //getScheduledHours();
        getSalaryFromDate();
        getETF();
        getEPF();
        getEPF12();
        getBonusType();
        //getMonth();
        getBank();
        getAccountNumber();
        getTotal();
        getPositionType();
               
    }
////////////////////////////////////////////////////Getters/////////////////////////////////////////////////////////////////
    private void setSalaryRecordNumber() {
        Salary_Calculation_Frame.txtSalaryRecordNumber.setText(Salary_Calculation_Frame.tblSalaryCalculations.getValueAt(getSelectedRow(Salary_Calculation_Frame.tblSalaryCalculations), 0).toString());
    }

    private void setEmployeeID() {
        Salary_Calculation_Frame.cmbEmployeeID.setSelectedItem(Salary_Calculation_Frame.tblSalaryCalculations.getValueAt(getSelectedRow(Salary_Calculation_Frame.tblSalaryCalculations), 4).toString());
    }

    private void setBonus() {
        Salary_Calculation_Frame.txtBonus.setText(Salary_Calculation_Frame.tblSalaryCalculations.getValueAt(getSelectedRow(Salary_Calculation_Frame.tblSalaryCalculations), 18).toString());
    }

    private void setOTHourlyRate() {
        Salary_Calculation_Frame.txtOTHourslyRate.setText(Salary_Calculation_Frame.tblSalaryCalculations.getValueAt(getSelectedRow(Salary_Calculation_Frame.tblSalaryCalculations), 16).toString());
    }

    private void setOTHours() {
        Salary_Calculation_Frame.txtOTHours.setText(Salary_Calculation_Frame.tblSalaryCalculations.getValueAt(getSelectedRow(Salary_Calculation_Frame.tblSalaryCalculations), 15).toString());
    }

    private void setWorkedHours() {
        Salary_Calculation_Frame.txtWorkedHours.setText(Salary_Calculation_Frame.tblSalaryCalculations.getValueAt(getSelectedRow(Salary_Calculation_Frame.tblSalaryCalculations), 11).toString());
    }

    private void setRole() {
        Salary_Calculation_Frame.txtRole.setText(Salary_Calculation_Frame.tblSalaryCalculations.getValueAt(getSelectedRow(Salary_Calculation_Frame.tblSalaryCalculations), 7).toString());
    }

    private void setSalaryToDate() {
        Salary_Calculation_Frame.dtpSalaryToDate.setDate(StringToDate(this.SalaryToDate));
    }

    private void setSalaryFromDate() {
        Salary_Calculation_Frame.dtpSalaryFromDate.setDate(StringToDate(this.SalaryFromDate));
    }

    private void setBasicSalary() {
        Salary_Calculation_Frame.txtBasicSalary.setText(Salary_Calculation_Frame.tblSalaryCalculations.getValueAt(getSelectedRow(Salary_Calculation_Frame.tblSalaryCalculations), 10).toString());
    }

    private void setLeaves() {
        Salary_Calculation_Frame.txtLeaves.setText(Salary_Calculation_Frame.tblSalaryCalculations.getValueAt(getSelectedRow(Salary_Calculation_Frame.tblSalaryCalculations), 9).toString());
    }

    private void setAttendance() {
        Salary_Calculation_Frame.txtAttendance.setText(Salary_Calculation_Frame.tblSalaryCalculations.getValueAt(getSelectedRow(Salary_Calculation_Frame.tblSalaryCalculations), 8).toString());
    }


    
    private void setBank()
    {
        Salary_Calculation_Frame.txtBank.setText(Salary_Calculation_Frame.tblSalaryCalculations.getValueAt(getSelectedRow(Salary_Calculation_Frame.tblSalaryCalculations), 5).toString());
    }
    
    private void setAccountNumber()
    {
        Salary_Calculation_Frame.txtAccountNumber.setText(Salary_Calculation_Frame.tblSalaryCalculations.getValueAt(getSelectedRow(Salary_Calculation_Frame.tblSalaryCalculations), 6).toString());
    }
    
     
    private void setMonth()
    {
        Salary_Calculation_Frame.txtBonusType.setText(Salary_Calculation_Frame.tblSalaryCalculations.getValueAt(getSelectedRow(Salary_Calculation_Frame.tblSalaryCalculations), 6).toString());
    }
    
    private void setEPF()
    {
        Salary_Calculation_Frame.txtEPF.setText(Salary_Calculation_Frame.tblSalaryCalculations.getValueAt(getSelectedRow(Salary_Calculation_Frame.tblSalaryCalculations), 12).toString());
    }
    
    private void setETF()
    {
        Salary_Calculation_Frame.txtETF.setText(Salary_Calculation_Frame.tblSalaryCalculations.getValueAt(getSelectedRow(Salary_Calculation_Frame.tblSalaryCalculations), 14).toString());
    }
    
    private void setEPF12()
    {
       Salary_Calculation_Frame.txtEPF12.setText(Salary_Calculation_Frame.tblSalaryCalculations.getValueAt(getSelectedRow(Salary_Calculation_Frame.tblSalaryCalculations), 13).toString()); 
    }

    private void setTotal()
    {
        Salary_Calculation_Frame.txtTotal.setText(Salary_Calculation_Frame.tblSalaryCalculations.getValueAt(getSelectedRow(Salary_Calculation_Frame.tblSalaryCalculations), 19).toString()); 
    }
    
    private void setPositionType()
    {
       Salary_Calculation_Frame.txtPositionType.setText(Salary_Calculation_Frame.tblSalaryCalculations.getValueAt(getSelectedRow(Salary_Calculation_Frame.tblSalaryCalculations), 20).toString());  
    }
    
///////////////////////////////////////////////////////Setters////////////////////////////////////////////////////////////////    
    
    
    
    public void setAll() {
        setSalaryRecordNumber();
        setEmployeeID();
        setBonus();
        setOTHourlyRate();
        setOTHours();
        //setScheduledHours();
        setAttendance();
        setLeaves();
        setBasicSalary();
        setSalaryFromDate();
        setSalaryToDate();
        setRole();
        setWorkedHours();
        setBank();
        setAccountNumber();
        //setMonth();
        setEPF();
        setETF();
        setTotal();
        setEPF12();
        setPositionType();

    }

////////////////////////////////////////////////////Add Query///////////////////////////////////////////////////////////
    @Override
    public void add(String tableName) {

        getAll();
        

        String sql = "INSERT INTO " + tableName + ""
                + "(`SalaryRecordNumber`,`Date Modified`,`Salary From Date`,`Salary To Date`,`Employee ID`,`Bank`,`AccountNumber`,`Role`,`Attendance`,`Leaves`,`BasicSalary`,`WorkedHours`,`EPF`,`EPF12`,`ETF`,`OTHours`,`OTHourlyRate`,`Bonus Type`,`Bonus`,`TotalSalary`,`Position Type`)"
                + " VALUES("
                + "'"+generatePrimaryKey("SalaryRecordNumber", "salary_calculation", "SA")+"',"
                + "'" + getCurrentDateTime() + "',"
                + "'" + this.SalaryFromDate + "',"
                + "'" + this.SalaryToDate + "',"
                + "'" + this.EmployeeID + "',"
                + "'"+this.Bank+"',"
                + "'"+this.AccountNumber+"',"
                + "'" + this.Role + "',"
               
                + "" + this.Attendance + ","
                + "" + this.Leaves + ","
                + "" + this.BasicSalary + ","
                + "" + this.WorkedHours + ","
                + "" + this.EPF + ","
                + "" + this.EPF12 + ","
                + "" + this.ETF + ","
                + "" + this.OTHours + ","
                + "" + this.OTHourlyRate + ","
                + "'" + this.BonusType + "',"
                + "" + this.Bonus + ","
                + "" + this.TotalSalary + ", "
                + "'" + this.PositionType + "' "
                + ")";
        System.out.println(sql);

        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            loadTable(tableName, Salary_Calculation_Frame.tblSalaryCalculations);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        /*
        String sal = this.EmployeeID+" Salary";
        
        String salary = "INSERT INTO expenses_management"
                + "(`Expense`,`Date Modified`,`Amount`,`Department`)"
                + " VALUES("
                + "'" + sal + "',"
                + "'" + getCurrentDateTime() + "',"
                + "'" + this.TotalSalary + "',"
                + "'Employee Management'"
                + ")";
        System.out.println(salary);

        try {
            pst = con.prepareStatement(salary);
            pst.execute();
            loadTable(tableName, Salary_Calculation_Frame.tblSalaryCalculations);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        String epf = this.EmployeeID+" EPF";
        
        String epff = "INSERT INTO expenses_management"
                + "(`Expense`,`Date Modified`,`Amount`,`Department`)"
                + " VALUES("
                + "'" + epf + "',"
                + "'" + getCurrentDateTime() + "',"
                + "'" + this.EPF + "',"
                + "'Employee Management'"
                + ")";
        System.out.println(epff);

        try {
            pst = con.prepareStatement(epff);
            pst.execute();
            loadTable(tableName, Salary_Calculation_Frame.tblSalaryCalculations);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        String epf12 = this.EmployeeID+" EPF12%";
        
        String epff12 = "INSERT INTO expenses_management"
                + "(`Expense`,`Date Modified`,`Amount`,`Department`)"
                + " VALUES("
                + "'" + epf12 + "',"
                + "'" + getCurrentDateTime() + "',"
                + "'" + this.EPF12 + "',"
                + "'Employee Management'"
                + ")";
        System.out.println(epff12);

        try {
            pst = con.prepareStatement(epff12);
            pst.execute();
            loadTable(tableName, Salary_Calculation_Frame.tblSalaryCalculations);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }*/
    }
/////////////////////////////////////////////////////////////////Update Query////////////////////////////////////////////////
    @Override
    public void update(String tableName) {

        getAll();

        String sql = "UPDATE " + tableName + ""
                + " SET `Salary From Date`= '" + this.SalaryFromDate + "',"
            
                + "`Salary To Date`= '" + this.SalaryToDate + "',"
                + "`Employee ID`= '" + this.EmployeeID + "'"

                + "WHERE `SalaryRecordNumber` = '" + this.SalaryRecordNumber + "'";

        //JOptionPane.showConfirmDialog(null, sql);

        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            loadTable(tableName, Salary_Calculation_Frame.tblSalaryCalculations);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
/////////////////////////////////////////////////////////////Fi9nd Bank Name//////////////////////////////////////////////////////////
    public void findBank() {
       
        
        String Employee=Salary_Calculation_Frame.cmbEmployeeID.getSelectedItem().toString();
        
        try {
             String x ="";
        //String tt = Salary_Calculation_Frame.cmbEmployeeID.getSelectedItem().toString();
            String Bank3 = "SELECT `Bank` FROM employee_details WHERE `Employee ID`='"+Employee+"'";
            //System.out.println(Bank3);
            //JOptionPane.showMessageDialog(null, Bank3 );
            pst = con.prepareStatement(Bank3);
            rs = pst.executeQuery();
            while(rs.next())
            { 
                x = rs.getString("Bank");
                Salary_Calculation_Frame.txtBank.setText(x);
            }
            
        }
       
        
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       // return x;
    }
//////////////////////////////////////////////////////Find Account Number////////////////////////////////////////////////////////
    public void findAccountNumber(String EmployeeID) {
        try {
            this.EmployeeID=EmployeeID;
            String AccountNumber = "SELECT `Account Number` FROM employee_details WHERE `Employee ID`='"+ this.EmployeeID + "'";
            pst = con.prepareStatement(AccountNumber);
            rs = pst.executeQuery();
           // JOptionPane.showMessageDialog(null, AccountNumber);
            String x="";
            while(rs.next())
            {
                 x = rs.getString("Account Number");
                Salary_Calculation_Frame.txtAccountNumber.setText(x);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
//////////////////////////////////////////////Load EmployeeID to ComboBox///////////////////////////////////////////////////    
           public void LoadEmployeeID5()
       {String id="";
           try {
               
               String sql="SELECT `Employee ID` FROM employee_details";
               pst=con.prepareStatement(sql);
               rs=pst.executeQuery();
               
               Salary_Calculation_Frame.cmbEmployeeID.removeAllItems();
               
               while(rs.next())
               {
                    id = rs.getString("Employee ID");
                  // JOptionPane.showMessageDialog(null,id);
                   Salary_Calculation_Frame.cmbEmployeeID.addItem(id);
                  
               }
               
           }
           
           catch (Exception e) 
           {
               //JOptionPane.showMessageDialog(null,"error","error", JOptionPane.ERROR_MESSAGE);
               JOptionPane.showMessageDialog(null, e);
           }
           if(id==null||id=="")
           {
               id="No Employee are in the database";
                Salary_Calculation_Frame.cmbEmployeeID.addItem(id);
           }
       }
////////////////////////////////////////////////////////Load Role According to selected Employee ID////////////////////////          
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
                   Salary_Calculation_Frame.txtRole.setText(id);
                  
               }
               
           } catch (Exception e) {
           }
               
       }
           
 
////////////////////////////////////////////////////////Count Attendance upto Selected dates////////////////////////////////
       
       public void Attendance(String EmployeeID)
       {String Find_new1="";
           this.EmployeeID=EmployeeID;
           //getBasicSalary();
           String fromdate=getDateFromPicker(Salary_Calculation_Frame.dtpSalaryFromDate);
           //JOptionPane.showMessageDialog(null, fromdate);
           String Todate=getDateFromPicker(Salary_Calculation_Frame.dtpSalaryToDate);
           //JOptionPane.showMessageDialog(null, Todate);
           String AttendanceStatus="Attend";
           String Absences="SELECT count(`Attendance Status`) FROM `attendance` WHERE `Employee ID`='"+this.EmployeeID+"' AND `Attendance Status`='"+AttendanceStatus+"' AND `Date` between '"+fromdate+"' AND '"+Todate+"'";
           //JOptionPane.showMessageDialog(null, Absences);
           try {
                pst = con.prepareStatement(Absences);
                rs = pst.executeQuery();
                String x;
                
                while(rs.next())
                {
            
                   Find_new1 = rs.getString("count(`Attendance Status`)");  
                   //JOptionPane.showMessageDialog(null,Find_new1 );
                }
//                int count =Integer.parseInt(Find_new1);
                Salary_Calculation_Frame.txtAttendance.setText(Find_new1);
           } 
           catch (Exception e) {
           }
          if(Find_new1==null||Find_new1=="")
          {
              Find_new1="No Attendance";
               Salary_Calculation_Frame.txtAttendance.setText(Find_new1);
          }
//           double basesal=WorkedHours*this.BasicSalary;
       }
       
      
/////////////////////////////////////////////////////////////Calculate OT Rate//////////////////////////////////////////////      
       
       public void OThours(String EmployeeID)
       {
            
          
           String Find_new1="";
           
           try {
               this.EmployeeID=EmployeeID;
                String fromdate=getDateFromPicker(Salary_Calculation_Frame.dtpSalaryFromDate);
            //JOptionPane.showMessageDialog(null, fromdate);
           String Todate=getDateFromPicker(Salary_Calculation_Frame.dtpSalaryToDate);
           //JOptionPane.showMessageDialog(null, Todate);
           String AttendanceStatus="Attend";
               String OTHours1="SELECT sum(`OT Hours`) FROM `attendance` WHERE `Employee ID`='"+this.EmployeeID+"' AND `Attendance Status`='"+AttendanceStatus+"' AND `Date` between '"+fromdate+"' AND '"+Todate+"'";
                pst = con.prepareStatement(OTHours1);
                rs = pst.executeQuery();
               // String x;
                
                while(rs.next())
                {
            
                   Find_new1 = rs.getString("sum(`OT Hours`)"); 
                   //JOptionPane.showMessageDialog(null, Find_new1);
                }
//                int OT =Integer.parseInt(OTHours);
                Salary_Calculation_Frame.txtOTHours.setText(Find_new1);
           } 
           catch (Exception e) {
               JOptionPane.showMessageDialog(null, e);
           }
           
           if(Find_new1==null||Find_new1=="")
           {
               Find_new1="0";
               Salary_Calculation_Frame.txtOTHours.setText(Find_new1);
           }
           
       }
/////////////////////////////////////////////////////////Calculate Basic Salary/////////////////////////////////////////////
       public void BasicSal(String Role)
       {String Find_new1="";
           this.Role=Role;
           try {
               String Basic="SELECT `Basic Salary` FROM `manage_employee_roles` WHERE `Employee Role`='"+this.Role+"'";
               
                pst = con.prepareStatement(Basic);
                rs = pst.executeQuery();
                String x;
                
                if(rs.next())
                {
            
                   Find_new1 = rs.getString("Basic Salary");  
                }
//                int OT =Integer.parseInt(OTHours);
                Salary_Calculation_Frame.txtBasicSalary.setText(Find_new1);
               
           } catch (Exception e) {
           }
           
           if(Find_new1==null||Find_new1=="")
           {
               Find_new1="No Basic Salary";
                Salary_Calculation_Frame.txtBasicSalary.setText(Find_new1);
           }
       }
////////////////////////////////////////////////////Calculate Worked Hours/////////////////////////////////////////////////      
       public void WorkedHours(String EmployeeID)
       { String Find_new1="",Find_new2="";
           this.EmployeeID=EmployeeID;
           String fromdate=getDateFromPicker(Salary_Calculation_Frame.dtpSalaryFromDate);
           //JOptionPane.showMessageDialog(null, fromdate);
           String Todate=getDateFromPicker(Salary_Calculation_Frame.dtpSalaryToDate);
           String AttendanceStatus="Attend";
      
            String WorkingHours="SELECT sum(`Worked Hours`) FROM `attendance` WHERE `Employee ID`='"+this.EmployeeID+"' AND `Attendance Status`='"+AttendanceStatus+"' AND `Date` between '"+fromdate+"' AND '"+Todate+"'";
            //JOptionPane.showMessageDialog(null,WorkingHours );
    
            
            try {
             pst = con.prepareStatement(WorkingHours);
             rs = pst.executeQuery();
             String x;
            
             if(rs.next())
                {
                   Find_new1 = rs.getString("sum(`Worked Hours`)");  
                  //JOptionPane.showMessageDialog(null, Find_new1);
               //    JOptionPane.showMessageDialog(null, Find_new2);
               
                }
             Salary_Calculation_Frame.txtWorkedHours.setText(Find_new1);
        

                  
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
            if(Find_new1==null||Find_new1=="")
            {
                Find_new1="0";
                 Salary_Calculation_Frame.txtWorkedHours.setText(Find_new1);
            }
        
           
       }

//////////////////////////////////////////////////////Find Position Status//////////////////////////////////////////////////     
       public void PositionStatus(String Role)
       {    this.Role=Role;
           try {
               String Status="SELECT `Position Status` FROM `manage_employee_roles` WHERE `Employee Role`='"+this.Role+"'";
               pst = con.prepareStatement(Status);
             rs = pst.executeQuery();
             //String x;
             String Find_new1="";
             if(rs.next())
                {
                   Find_new1 = rs.getString("Position Status");  
                  //JOptionPane.showMessageDialog(null, Find_new1);
              
               
                }
             Salary_Calculation_Frame.txtPositionType.setText(Find_new1);
             
             
           } catch (Exception e) {
           }
       }
///////////////////////////////////////////////////////count Leaves////////////////////////////////////////////////      
       public void leaves(String EmployeeID)
       { String leavecount="";
            this.EmployeeID=EmployeeID;
//            this.Role=Role;
            String Find_new2="";
            
           //getBasicSalary();
           String Role=Salary_Calculation_Frame.txtRole.getText();
           //JOptionPane.showMessageDialog(null, Role);
           String fromdate=getDateFromPicker(Salary_Calculation_Frame.dtpSalaryFromDate);
           //JOptionPane.showMessageDialog(null, fromdate);
           String Todate=getDateFromPicker(Salary_Calculation_Frame.dtpSalaryToDate);
           //JOptionPane.showMessageDialog(null, Todate);
         //  String AttendanceStatus="Absence";
           String LeaveStatus="Not Approved and no pay";
           String Cancel="cancel";
            
//           String Absences="SELECT count(`Attendance Status`) FROM `attendance` WHERE `Employee ID`='"+this.EmployeeID+"' AND `Attendance Status`='"+AttendanceStatus+"' AND `Date` between '"+fromdate+"' AND '"+Todate+"'";
//           
           try {
               

              leavecount="SELECT count(`Approval`) FROM `leave_requirement` WHERE `Employee ID`='"+this.EmployeeID+"' AND `Approval`='"+LeaveStatus+"' AND `Cancel Status`='"+Cancel+"' AND `Date Modified` between '"+fromdate+"' AND '"+Todate+"'";
               pst = con.prepareStatement(leavecount);
               rs = pst.executeQuery();
//                //JOptionPane.showMessageDialog(null, leavecount);

                 if(rs.next())
               {
                   Find_new2 = rs.getString("Leaves For a Month");                  
                  Salary_Calculation_Frame.txtLeaves.setText(Find_new2);
//               
                }
    
           } catch (Exception e) {
           }
           
           if(Find_new2==null||Find_new2=="")
           {
               String df2="0";
               Salary_Calculation_Frame.txtLeaves.setText(df2);
           }
        
       }
       
///////////////////////////////////////////////////////GET Bonus Type////////////////////////////////////////////////////////      
       
       public void BonusType()
       {
           String current=getCurrentDateTime();
           String Cur1=current.substring(6,7);
           int chrits=Integer.parseInt(Cur1);
           
           if(chrits==04)
           {
               this.BonusType="April Bonus";
           }
           else if(chrits==12)
           {
               this.BonusType="Christmas Bonus";
           }
           else if(chrits!=04||chrits!=12)
           {
               this.BonusType="No Bonus";
           }
           
            Salary_Calculation_Frame.txtBonusType.setText(this.BonusType);
           
           
       }
///////////////////////////////////////////////////////////////////////////Selecting Bonus Package//////////////////////////
       
       public void Bonuss()
       {
           String bonus="SELECT `Bonus Percentage` FROM `employee_settings`";
            try {
               
                pst = con.prepareStatement(bonus);
                rs = pst.executeQuery();
                //JOptionPane.showMessageDialog(null, leavecount);
                double x2=0;
                String Find_new2="";
                 if(rs.next())
                {
                   Find_new2 = rs.getString("Bonus Percentage");  
                 //JOptionPane.showMessageDialog(null, Find_new2);
                 
               
                }
                 
                 if("Christmas Bonus".equals(this.BonusType))
                 {
                     x2=Double.parseDouble(Find_new2);
                     String Bonus_Extra=Double.toString(x2);
                 Salary_Calculation_Frame.txtBonus.setText(this.BonusType);
                 }
                 else if("April Bonus".equals(this.BonusType))
                 {
                    x2=Double.parseDouble(Find_new2);
                     String Bonus_Extra=Double.toString(x2);
                 Salary_Calculation_Frame.txtBonus.setText(this.BonusType);
                 }
                
                 else
                 {
                     String no_bonus="0";
                     Salary_Calculation_Frame.txtBonus.setText(no_bonus);
                 }
                
              
           } catch (Exception e) {
           }
           
           
       }
//////////////////////////////////////////////////////Select OT Rate According to Permanent And Temporary////////////////////       
       public void OTHourlyRate()
       {String Find_new1="";
           String PositionStatus_1=Salary_Calculation_Frame.txtPositionType.getText();
           //JOptionPane.showMessageDialog(null, PositionStatus_1);
           String permanentotrate="SELECT `Permanent OTRate` FROM `employee_settings`";
           try {
               pst = con.prepareStatement(permanentotrate);
                rs = pst.executeQuery();
               // JOptionPane.showMessageDialog(null, permanentotrate);
                double x2=0;
                String Find_new2="";
                 if(rs.next())
                {
                   Find_new2 = rs.getString("Permanent OTRate");  
                 //JOptionPane.showMessageDialog(null, Find_new2);
                 
               
                }
            String permanentotrate_2="SELECT `Temporary OTRate` FROM `employee_settings`";   
                pst = con.prepareStatement(permanentotrate_2);
                rs = pst.executeQuery();
                //JOptionPane.showMessageDialog(null, permanentotrate_2);
                double x1=0;
                
                 if(rs.next())
                {
                   Find_new1 = rs.getString("Temporary OTRate");  
                 //JOptionPane.showMessageDialog(null, Find_new1);
                 
               
                }
                 if("Permanent".equals(PositionStatus_1)) 
                {
                    Salary_Calculation_Frame.txtOTHourslyRate.setText(Find_new2);
                
                } 
                 else 
                 {
                     Salary_Calculation_Frame.txtOTHourslyRate.setText(Find_new1);
                 }
           } 
           catch (Exception e) {
           }
           
       }
/////////////////////////////////////////////////////Calculate EPF////////////////////////////////////////////////////////       
       public void EPF()
       {
           //String Employee=Salary_Calculation_Frame.cmbEmployeeID.getSelectedItem().toString();
           Double BaseSal=Double.parseDouble(Salary_Calculation_Frame.txtBasicSalary.getText());
           //JOptionPane.showMessageDialog(null, BaseSal);
           Double Bonuss=Double.parseDouble(Salary_Calculation_Frame.txtBonus.getText());
           //JOptionPane.showMessageDialog(null, Bonuss);
           int Leave=Integer.parseInt(Salary_Calculation_Frame.txtLeaves.getText());
           //JOptionPane.showMessageDialog(null, Leave);
           int Attendance1=Integer.parseInt(Salary_Calculation_Frame.txtAttendance.getText());
           //JOptionPane.showMessageDialog(null, Attendance1);
           int OT= Integer.parseInt(Salary_Calculation_Frame.txtOTHours.getText());
           //JOptionPane.showMessageDialog(null, OT);
           double otR= Double.parseDouble(Salary_Calculation_Frame.txtOTHourslyRate.getText());
           //JOptionPane.showMessageDialog(null, otR);
    
           double FinaCal=0;
           if(Attendance1!=0)
           {
              FinaCal=((BaseSal+BaseSal*Bonuss-((BaseSal/Attendance1)*Leave)+(OT*otR))/100)*8;
             // JOptionPane.showMessageDialog(null, FinaCal);
           }
            else
           {
               FinaCal=0;
           }
            String Sal=Double.toString(FinaCal);
            Salary_Calculation_Frame.txtEPF.setText(Sal);
           
       }
//////////////////////////////////////////////Calculate EPF 12%///////////////////////////////////////////////////////////      
       public void ETF12()
       {
            Double BaseSal=Double.parseDouble(Salary_Calculation_Frame.txtBasicSalary.getText());
           //JOptionPane.showMessageDialog(null, BaseSal);
           Double Bonuss=Double.parseDouble(Salary_Calculation_Frame.txtBonus.getText());
           //JOptionPane.showMessageDialog(null, Bonuss);
           int Leave=Integer.parseInt(Salary_Calculation_Frame.txtLeaves.getText());
          // JOptionPane.showMessageDialog(null, Leave);
           int Attendance1=Integer.parseInt(Salary_Calculation_Frame.txtAttendance.getText());
          // JOptionPane.showMessageDialog(null, Attendance1);
           int OT= Integer.parseInt(Salary_Calculation_Frame.txtOTHours.getText());
          // JOptionPane.showMessageDialog(null, OT);
           double otR= Double.parseDouble(Salary_Calculation_Frame.txtOTHourslyRate.getText());
         //  JOptionPane.showMessageDialog(null, otR);
    
           double FinaCal=0;
           if(Attendance1!=0)
           {
              FinaCal=((BaseSal+BaseSal*Bonuss-((BaseSal/Attendance1)*Leave)+(OT*otR))/100)*12;
            //  JOptionPane.showMessageDialog(null, FinaCal);
           }
           else
           {
               FinaCal=0;
           }
            String Sal=Double.toString(FinaCal);
            Salary_Calculation_Frame.txtEPF12.setText(Sal);
           
       }
//////////////////////////////////////////////////////////////////Calculate ETF/////////////////////////////////////////////       
       public void ETF()
       {
             Double BaseSal=Double.parseDouble(Salary_Calculation_Frame.txtBasicSalary.getText());
          // JOptionPane.showMessageDialog(null, BaseSal);
           Double Bonuss=Double.parseDouble(Salary_Calculation_Frame.txtBonus.getText());
         //  JOptionPane.showMessageDialog(null, Bonuss);
           int Leave=Integer.parseInt(Salary_Calculation_Frame.txtLeaves.getText());
         //  JOptionPane.showMessageDialog(null, Leave);
           int Attendance1=Integer.parseInt(Salary_Calculation_Frame.txtAttendance.getText());
          // JOptionPane.showMessageDialog(null, Attendance1);
           int OT= Integer.parseInt(Salary_Calculation_Frame.txtOTHours.getText());
          // JOptionPane.showMessageDialog(null, OT);
           double otR= Double.parseDouble(Salary_Calculation_Frame.txtOTHourslyRate.getText());
         //  JOptionPane.showMessageDialog(null, otR);
    
           double FinaCal=0;
           if(Attendance1!=0)
           {
              FinaCal=((BaseSal+BaseSal*Bonuss-((BaseSal/Attendance1)*Leave)+(OT*otR))/100)*3;
             // JOptionPane.showMessageDialog(null, FinaCal);
             String Sal=Double.toString(FinaCal);
            Salary_Calculation_Frame.txtETF.setText(Sal);
           }
            else
           {
               FinaCal=0;
               String Sal=Double.toString(FinaCal);
            Salary_Calculation_Frame.txtETF.setText(Sal);
           }
            
       }
///////////////////////////////////////////////////Calculate Total Salary////////////////////////////////////////////////////      
       public void TotalSalary()
       {
           
         double BaseSal=Double.parseDouble(Salary_Calculation_Frame.txtBasicSalary.getText());
//            JOptionPane.showMessageDialog(null, BaseSal);
         double epf=Double.parseDouble(Salary_Calculation_Frame.txtEPF.getText());
//            JOptionPane.showMessageDialog(null, epf);
         double etf=Double.parseDouble(Salary_Calculation_Frame.txtETF.getText());
//            JOptionPane.showMessageDialog(null, etf);
         double epf12=Double.parseDouble(Salary_Calculation_Frame.txtEPF12.getText());
          //  JOptionPane.showMessageDialog(null, Bonuss);
          
           double Bonuss=Double.parseDouble(Salary_Calculation_Frame.txtBonus.getText());
//           JOptionPane.showMessageDialog(null, Bonuss);
           int Leave=Integer.parseInt(Salary_Calculation_Frame.txtLeaves.getText());
//           JOptionPane.showMessageDialog(null, Leave);
           int Attendance1=Integer.parseInt(Salary_Calculation_Frame.txtAttendance.getText());
//           JOptionPane.showMessageDialog(null, Attendance1);
           int OT= Integer.parseInt(Salary_Calculation_Frame.txtOTHours.getText());
//           JOptionPane.showMessageDialog(null, OT);
           double otR= Double.parseDouble(Salary_Calculation_Frame.txtOTHourslyRate.getText());
//           JOptionPane.showMessageDialog(null, otR);
          double FinaCal=0;
           if(Attendance1!=0)
           {
              FinaCal=((BaseSal+BaseSal*Bonuss-((BaseSal/Attendance1)*Leave)+(OT*otR))-epf)+etf;
             // JOptionPane.showMessageDialog(null, FinaCal);
             String Sal=Double.toString(FinaCal);
            Salary_Calculation_Frame.txtTotal.setText(Sal);
           }
            else
           {
               FinaCal=0;
               String Sal=Double.toString(FinaCal);
            Salary_Calculation_Frame.txtTotal.setText(Sal);
           }
            
       }
       
//       public void PassExpenditure()
//       {
//          // String x="";
////           String x1="";
////           String x2="";
//        String Tot="SELECT `TotalSalary` FROM `salary_calculation`";
//        JOptionPane.showMessageDialog(null, Tot);
//        try {
//            
//              pst = con.prepareStatement(Tot);
//              rs = pst.executeQuery();
//            while(rs.next())
//            { 
//              String  x = rs.getString("TotalSalary");
//                JOptionPane.showMessageDialog(null, x);
//                //Salary_Calculation_Frame.txtBank.setText(x);
////                 String Sql="insert into `expenses_management`"
////                +"(`Expense`,`Date Modified`,`Amount`,`Department`)"
////                +"values("
////                +"'Employee Managemant',"
////                +"'"+getCurrentDateTime()+"'"
////                +""+x+","
////                +"'Employee Managemant'"
////                +")";
//                    String Sql="INSERT INTO `expenses_management`(`Expense`,`Date Modified`,`Amount`,`Department`)VALUES('Employee Management','hhh','x','Employee Management')";
//                              
//                 try{
//                 
//                        pst = con.prepareStatement(Sql);
//                        rs = pst.executeQuery();
//                        JOptionPane.showMessageDialog(null, Sql);
//                        }
//                 catch (Exception e)
//                 {
//                 }
//            
//               }
//
//                 
//        }
//        catch (Exception e) 
//        {
//        }
////            try{
////            String epf="SELECT `EPF` FROM `salary_calculation`";
////            JOptionPane.showMessageDialog(null, epf);
////            pst = con.prepareStatement(epf);
////            rs = pst.executeQuery();
////            while(rs.next())
////            { 
////                x2 = rs.getString("EPF");
////                JOptionPane.showMessageDialog(null, x2);
////               
////                //Salary_Calculation_Frame.txtBank.setText(x);
////                  String Sql1="insert into `expenses_management`"
////                +"(`Expense`,`Date Modified`,`Amount`,`Department`)"
////                +"values("
////                +"'Employee Managemant',"
////                +"'"+getCurrentDateTime()+"'"
////                +""+x1+","
////                +"'Employee Managemant'"
////                +")";
////                  try{
////            pst = con.prepareStatement(Sql1);
////            rs = pst.executeQuery();
////            JOptionPane.showMessageDialog(null, Sql1);
////                    }
////                  catch (Exception e) 
////                  {
////                  }
////
////            }
////            }
////              
////        catch (Exception e) {
////        }
////        
////        try{    
////        String epf12="SELECT `EPF12` FROM `salary_calculation`";
////        JOptionPane.showMessageDialog(null, epf12);
////            pst = con.prepareStatement(epf12);
////            rs = pst.executeQuery();
////            while(rs.next())
////            { 
////                x2 = rs.getString("EPF12");
////                JOptionPane.showMessageDialog(null, x2);
////                //Salary_Calculation_Frame.txtBank.setText(x);
////                 String Sql2="insert into `expenses_management`"
////                +"(`Expense`,`Date Modified`,`Amount`,`Department`)"
////                +"values("
////                +"'Employee Managemant',"
////                +"'"+getCurrentDateTime()+"'"
////                +""+x2+","
////                +"'Employee Managemant'"
////                +")";
////                 try{
////            pst = con.prepareStatement(Sql2);
////            rs = pst.executeQuery();
////            JOptionPane.showMessageDialog(null, Sql2);
////                 }
////                  catch (Exception e) 
////                  {
////                    } 
////               
////            }
////            
////              }
////        catch (Exception e) {
////        }
//        
////            while(rs.next())
////            { 
////                x2 = rs.getString("EPF12");
////                //Salary_Calculation_Frame.txtBank.setText(x);
////            }
//       
//            
//            
////      
//        
//       }
       
/////////////////////////////////////////////////////////Clear Method/////////////////////////////////////////////////////
       public void Clear()
       {
           Salary_Calculation_Frame.txtAccountNumber.setText("");
           Salary_Calculation_Frame.txtAttendance.setText("");
           Salary_Calculation_Frame.txtBank.setText("");
           Salary_Calculation_Frame.txtBasicSalary.setText("");
           Salary_Calculation_Frame.txtBonus.setText("");
           Salary_Calculation_Frame.txtEPF.setText("");
           Salary_Calculation_Frame.txtBonusType.setText("");
           Salary_Calculation_Frame.txtEPF12.setText("");
           Salary_Calculation_Frame.txtETF.setText("");
           Salary_Calculation_Frame.txtLeaves.setText("");
           Salary_Calculation_Frame.txtOTHours.setText("");
           Salary_Calculation_Frame.txtOTHourslyRate.setText("");
           Salary_Calculation_Frame.txtPositionType.setText("");
           Salary_Calculation_Frame.txtRole.setText("");
           Salary_Calculation_Frame.txtSalaryRecordNumber.setText("");
           Salary_Calculation_Frame.txtTotal.setText("");
           Salary_Calculation_Frame.txtWorkedHours.setText("");
           Salary_Calculation_Frame.txtSearchBox.setText("");
          
       }
       
//       public void transferincometable(){
//    
//        Incomes_Management_Model incomes = new Incomes_Management_Model();
//        
//        String colname = "Income ID";
//        String tablename = "incomes_management";
//        String primaryval = "INM" ;
//        
//        try
//        {
//          String income = this.EmployeeID+" Salary" ;
//          String Department = "Events" ;
//          String sql = "INSERT INTO incomes_management "
//                + "( `Income`,`Date`,`Amount`,`Department`)"
//                + " VALUES("
//                + "'"+generatePrimaryKey(colname, tablename, primaryval)+"',"
//                + "'"+income+"',"
//                + "'"+getCurrentDateTime()+"',"
//                + ""+this.TotalSalary+","
//                + "'"+Department+"'"
//                + ")";  
//             
//                pst = con.prepareStatement(sql);
//                pst.execute();
//                
//        
//        
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,e,"null",JOptionPane.ERROR_MESSAGE);
//        }
//        
//        try
//        {
//          String income = this.EmployeeID+" EPF" ;
//          String Department = "Events" ;
//          String sql = "INSERT INTO incomes_management "
//                + "( `Income`,`Date`,`Amount`,`Department`)"
//                + " VALUES("
//                + "'"+generatePrimaryKey(colname, tablename, primaryval)+"',"
//                + "'"+income+"',"
//                + "'"+getCurrentDateTime()+"',"
//                + ""+this.EPF+","
//                + "'"+Department+"'"
//                + ")";  
//             
//                pst = con.prepareStatement(sql);
//                pst.execute();
//                
//        
//        
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,e,"null",JOptionPane.ERROR_MESSAGE);
//        }
//        
//        
//        try
//        {
//          String income = this.EmployeeID+" EPF12%" ;
//          String Department = "Events" ;
//          String sql = "INSERT INTO incomes_management "
//                + "( `Income`,`Date`,`Amount`,`Department`)"
//                + " VALUES("
//                + "'"+generatePrimaryKey(colname, tablename, primaryval)+"',"
//                + "'"+income+"',"
//                + "'"+getCurrentDateTime()+"',"
//                + ""+this.EPF12+","
//                + "'"+Department+"'"
//                + ")";  
//             
//                pst = con.prepareStatement(sql);
//                pst.execute();
//                
//        
//        
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,e,"null",JOptionPane.ERROR_MESSAGE);
//        }
//        
//        incomes.loadTable(tablename,Incomes_Management_Frame.tbIncomes);
//        
//    
//    
//    }
  
             public void Modelsearch()
    {
        String filters = Salary_Calculation_Frame.cmbSearchBy.getSelectedItem().toString();
        String filter = "`"+filters+"`";
        String search=Salary_Calculation_Frame.txtSearchBox.getText();
        String tablename = "salary_calculation";
        JTable tblName = Salary_Calculation_Frame.tblSalaryCalculations;
        
        search(filter,search,tablename,tblName);

    }   
       
///////////////////////////////////////////Report///////////////////////////////////////////////////////////////////////////       
       
     public void report()
         {
            // iReport z=new iReport();
             iReportView r = new iReportView(PROJECT_PATH+"\\employee_management\\Salary_Calculation.jasper");
             r.setVisible(true);
         }    
         
}
