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

import app.employee_management.Attendance_Frame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.HMS;
import org.codehaus.groovy.ast.stmt.CatchStatement;
import source.DBConnection;

/**
 *
 * @author Udeshika Ranaweera
 */
public class Attendance_Model extends HMS{
    
    private String AttendanceRecordNo;
    private String EmployeeID;
    private String Date;
    private String InTime;
    private String OutTime;
    private int WorkedHours;
    private int OTHours;
    private String AttendanceStatus;
    private String DayStatus;
    private String Month;
    private String RecordID;
    private int AttendanceCount;
    
    
    
    public Attendance_Model()
    {
        con = DBConnection.connect();
        
        this.AttendanceRecordNo="No Record No";
        this.EmployeeID="NULL";
        this.Date="Not Selected";
        this.InTime="NULL";
        this.OutTime="NULL";
        this.OTHours=0;
        this.WorkedHours=0;
        this.AttendanceStatus="No Attendance";
        this.DayStatus="NULL";
        this.Month="No Month";
        this.RecordID="No ID";
        this. AttendanceCount=0;
    }
    
    

    
///////////////////////////////////////////////////////Clear///////////////////////////////////////////////////////////////
    public void Clear()
    {
        Attendance_Frame.txtSearchBox.setText("");
    }
/////////////////////////////////////////////////////////////////Search////////////////////////////////////////////////////   
     public void Modelsearch()
    {
        String filters = Attendance_Frame.cmbSearchBy.getSelectedItem().toString();
        String filter = "`"+filters+"`";
        String search=Attendance_Frame.txtSearchBox.getText();
        String tablename = "employee_details";
        JTable tblName = Attendance_Frame.tblAttendance;
        
        search(filter,search,tablename,tblName);

    }
    
    @Override
    public void add(String tableName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(String tableName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
/////////////////////////////////////////////////////Pass Attendance Employee wise//////////////////////////////////////////

     public void passattendance()
   { //String sq="SELECT count(`Attendance Status`) FROM `attendance` WHERE `Employee ID`=\"EID-00027\" AND `Date` between \"2016-08-28\" AND \"2016-09-16\" AND `Attendance Status`=\"Attend\"";
       String Employeeid="";
       String sql="SELECT `Employee ID` FROM `employee_details`";
       
       JOptionPane.showMessageDialog(null, sql);
       try {
           pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           while(rs.next())
           {
              Employeeid=rs.getString("Employee ID");
              JOptionPane.showMessageDialog(null,Employeeid );
              String sq = "SELECT COUNT(SUBSTRING(`Date Modified`,6,2)),SUBSTRING(`Date Modified`,6,2),`Employee ID` FROM attendance WHERE `Employee ID`='"+Employeeid+"' GROUP BY SUBSTRING(`Date Modified`,6,2)  ";
              JOptionPane.showMessageDialog(null, sq);
              try {
                pst=con.prepareStatement(sq);
                rs=pst.executeQuery();
                while(rs.next())
                {           
                String nomonth=rs.getString("COUNT(SUBSTRING(`Date Modified`,6,2))");  
                JOptionPane.showMessageDialog(null, nomonth);
                String Month=rs.getString("SUBSTRING(`Date Modified`,6,2)");
                JOptionPane.showMessageDialog(null, Month);
                String Employee=rs.getString("Employee ID");
                JOptionPane.showMessageDialog(null, Employee);
                String SQ = "INSERT INTO `monthly_attendance` (`Employee ID`,`Month`,`TotalAttendance`)VALUES('"+Employee+"','"+Month+"','"+nomonth+"')";
                try {
                    pst=con.prepareStatement(SQ);
                    
                    pst.execute();
                    JOptionPane.showMessageDialog(null, SQ);
                    JOptionPane.showMessageDialog(null, pst);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                        }
        }
    
     catch (Exception e) 
           {
               // JOptionPane.showMessageDialog(null, e);
           }
           }
       } catch (Exception e) {
       }
   loadTable("monthly_attendance", Attendance_Frame.tblMonthAttendance);
    }
    
    
    
}
