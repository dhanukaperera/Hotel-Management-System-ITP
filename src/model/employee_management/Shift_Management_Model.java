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

import app.employee_management.Leave_Requirements_Frame;
import app.employee_management.Shift_Management_Frame;
import static app.employee_management.Shift_Management_Frame.jCalShiftDate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.HMS;
import source.DBConnection;

/**
 *
 * @author Udeshika Ranaweera
 */
public class Shift_Management_Model extends HMS{
    
    private String ShiftRecordID;
    private String EmployeeID;
    private String Name;
    private String Department;
    private String LeaveDetails;
    private String EventDetails;
    private String Month;
    private String ShiftTime; 
    
    private String ShiftDate;
    

    

    
    
    public Shift_Management_Model()
    {
        con = DBConnection.connect();
        
     this.EmployeeID="No EmloyeeID";
     this.ShiftRecordID="No shiftId";
     this.Name="No Name";
     this.Department="No Department";
     this.LeaveDetails="No LeaveDetails";
     this.EventDetails="No Events";
     this.ShiftDate="NULL";
     this.Month="NULL";
     this.ShiftTime="NULL";

     
     colList="`Shift Record No`,`Employee ID`,`Date Modified`,`Name`,`Department`,`Shift Date`,`Shift Time`,`Event Details`,`Leave Details`";    
    }
/////////////////////////////////////////////////getters//////////////////////////////////////////////////////////////////////    
        public String getPrimaryKey()
    {
        setShiftRecordID();
        getShiftRecordID();
        return this.ShiftRecordID;
    }
     
        private void getShiftRecordID()
        {
             this.ShiftRecordID = Shift_Management_Frame.txtShiftRecordID.getText();
        }
        private void getEmployeeID()
        {
            this.EmployeeID = Shift_Management_Frame.cmbEmployeeID.getSelectedItem().toString();
        }
        
        private void getName()
        {
            this.Name = Shift_Management_Frame.txtName.getText();
        }
        
        private void getDepartment()
        {
            this.Department = Shift_Management_Frame.cmbDepartment.getSelectedItem().toString();
        }
        
        private void getLeaveDetails()
        {
            this.LeaveDetails = Shift_Management_Frame.txtLeaveDetails.getText();
        }
        
        private void getEventDetail()
        {
            this.EventDetails=Shift_Management_Frame.txtEventDetails.getText();
        }
        

        
        private void getShiftTime()
        {
            this.ShiftTime=Shift_Management_Frame.cmbShiftTime.getSelectedItem().toString();
        }
        
        public String getDate1()
        {
             DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateobj =jCalShiftDate.getDate();
        String dd=(df.format(dateobj));
        return dd;
        }

               
         public void getAll()
         {
           getShiftRecordID();
           getEmployeeID();
           getName();
           getDepartment();
           getLeaveDetails();
           getEventDetail();
           getShiftTime();

          
         }
         
////////////////////////////////////////////////////////////Setters///////////////////////////////////////////////////////////         
         private void setShiftRecordID()
         {
              Shift_Management_Frame.txtShiftRecordID.setText(Shift_Management_Frame.tblShiftManagement.getValueAt(getSelectedRow(Shift_Management_Frame.tblShiftManagement), 0).toString());
         }
    
         public void setEmployeeID()
         {
             Shift_Management_Frame.cmbEmployeeID.setSelectedItem(Shift_Management_Frame.tblShiftManagement.getValueAt(getSelectedRow(Shift_Management_Frame.tblShiftManagement), 2).toString());
         }
         
         private void setName()
         {
            Shift_Management_Frame.txtName.setText(Shift_Management_Frame.tblShiftManagement.getValueAt(getSelectedRow(Shift_Management_Frame.tblShiftManagement), 3).toString()); 
         }
         
         private void setDepartment()
         {
             Shift_Management_Frame.cmbDepartment.setSelectedItem(Shift_Management_Frame.tblShiftManagement.getValueAt(getSelectedRow(Shift_Management_Frame.tblShiftManagement), 4).toString());
         }
         
         private void setShiftDate()
         {
             
         }
         private void setShiftTime()
         {
             Shift_Management_Frame.cmbShiftTime.setSelectedItem(Shift_Management_Frame.tblShiftManagement.getValueAt(getSelectedRow(Shift_Management_Frame.tblShiftManagement), 6).toString());
         }
         
         private void setEventDetails()
         {
              Shift_Management_Frame.txtEventDetails.setText(Shift_Management_Frame.tblShiftManagement.getValueAt(getSelectedRow(Shift_Management_Frame.tblShiftManagement), 8).toString()); 
         }
         
         private void setLeaveDetails()
         {
              Shift_Management_Frame.txtLeaveDetails.setText(Shift_Management_Frame.tblShiftManagement.getValueAt(getSelectedRow(Shift_Management_Frame.tblShiftManagement), 8).toString()); 
         }
         
         
         
         public void setAll()
         {
             setShiftRecordID();
             //setEmployeeID();
             setName();
             setDepartment();
             setShiftDate();
             setEventDetails();
             setLeaveDetails();
             setShiftTime();
             
         }
       
         public void setShiftTimes(String time,JComboBox to, JComboBox from)
        {
        //Shift time Should be like this --> "08:00 - 16:00"
        
        StringTokenizer stTime = new StringTokenizer(time,"-");
        String[] arrTime = new String[1];
        
        int t = 0;
        while (stTime.hasMoreTokens()) 
        {
            arrTime[t] = stTime.nextToken();
            t++;
        }  
        
        to.setSelectedItem(arrTime[0]);
        from.setSelectedItem(arrTime[1]);
        
        }
        
         
//////////////////////////////////////////////////Get Leave Detaols//////////////////////////////////////////////////////////
          
    public void gettingLeaveDetails()
    {
        getEmployeeID();
//        JOptionPane.showMessageDialog(null,this.EmployeeID);
      
        String Approval="Approved";
        String LeaveDate="SELECT `Leave Date` FROM `leave_requirement` WHERE `Employee ID`='"+this.EmployeeID+"' and `Approval`='"+Approval+"'";
        String RequiredDates ="SELECT `Required Leaves` FROM `leave_requirement` WHERE `Employee ID`='"+this.EmployeeID+"' and `Approval`='"+Approval+"'";

        
       
        try {
            
        pst = con.prepareStatement(LeaveDate);
        rs = pst.executeQuery();
        String x;
        String Find_new1="",Find_new2="";
        if(rs.next())
                {
                   Find_new1 = rs.getString("Leave Date");  
                  // JOptionPane.showMessageDialog(null, Find_new1);
               //    JOptionPane.showMessageDialog(null, Find_new2);
               
                }
        
         pst = con.prepareStatement(RequiredDates);
        rs = pst.executeQuery();
//       
              if(rs.next())
                {
              //     String Find_new1 = rs.getString("Leave Date");
                   Find_new2 = rs.getString("Required Leaves");
                  // JOptionPane.showMessageDialog(null, Find_new2);        
                }
              
            x = "Leave Date ="+Find_new1+"   "+"Required Leaves ="+Find_new2;
           Shift_Management_Frame.txtLeaveDetails.setText(x);
                  
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
                  
    }
///////////////////////////////////////////////////Loading Leaves According To Employee ID////////////////////////////////////   
    public void LoadLeaves()
    {
        String current=getCurrentDateTime();
        String cur=current.substring(0,10);
        String next=current.substring(0,7);
        String nextmonth=next+01;
        String newweek=nextmonth+05;
        String FunctionType="SELECT `Function Type` FROM view_event_booking";
        String Date="SELECT `Date` FROM `view_event_booking` WHERE `Date` between '"+cur+"' and '"+newweek+"'";
        //String Time="";
        //String StartTime="SELECT `Function Type` FROM view_event_booking";
        
        try {
             pst = con.prepareStatement(FunctionType);
        rs = pst.executeQuery();
        String x;
        String Find_new1="",Find_new2="";
        if(rs.next())
                {
                   Find_new1 = rs.getString("Function Type");  
         
                }
        
         pst = con.prepareStatement(Date);
        rs = pst.executeQuery();
//       
              if(rs.next())
                {
              //     String Find_new1 = rs.getString("Leave Date");
                   Find_new2 = rs.getString("Date");
                  // JOptionPane.showMessageDialog(null, Find_new2);        
                }
              String dd=Date;
              String currentmonth=getCurrentDateTime().substring(6, 7);
        
              
            x = "Function Type ="+Find_new1+"   "+"Date ="+Find_new2;
           Shift_Management_Frame.txtEventDetails.setText(x);
                  
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
////////////////////////////////////////Load EmployeeID to ComboBox///////////////////////////////////////////////////////////
               public void LoadEmployeeID2()
       {
           try {
               String sql="SELECT `Employee ID` FROM employee_details";
               pst=con.prepareStatement(sql);
               rs=pst.executeQuery();
               Shift_Management_Frame.cmbEmployeeID.removeAllItems();
               while(rs.next())
               {
                   String id=rs.getString("Employee ID");
                   Shift_Management_Frame.cmbEmployeeID.addItem(id);
               }
           } 
           catch (Exception e) 
           {
               JOptionPane.showMessageDialog(null,"error","error", JOptionPane.ERROR_MESSAGE);
           }
       }
////////////////////////////////////////////////Find Employee Name According to Employee ID////////////////////////////////////    
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
                   Shift_Management_Frame.txtName.setText(searched_Name);
               }
               
           } catch (Exception e) 
           {
                JOptionPane.showMessageDialog(null, e);
           }
       }
        
      
///////////////////////////////////////////////////////Add Query/////////////////////////////////////////////////////////////   
         
    @Override
    public void add(String tableName) {
        
          getAll();
        String sql = "INSERT INTO "+tableName+""
                + "(`Shift Record No`,`Date Modified`,`Employee ID`,`Name`,`Department`,`Shift Date`,`Shift Time`,`Event Details`,`Leave Details`)"
                + " VALUES('"+generatePrimaryKey("Shift Record No","shift_management","SR+")+"',"
                + "'"+getCurrentDateTime()+"',"
                + "'"+this.EmployeeID+"',"
                + "'"+this.Name+"',"
                + "'"+this.Department+"',"
                + "'"+getDate1()+"',"
                + "'"+this.ShiftTime+"',"
                + "'"+this.EventDetails+"',"
                + "'"+this.LeaveDetails+"'"
                + ")";
        System.out.println(sql);
          try 
        {
            pst = con.prepareStatement(sql);
            pst.execute();
            loadTable(tableName,Shift_Management_Frame.tblShiftManagement);   
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
//////////////////////////////////////////////////////////Update Query///////////////////////////////////////////////////////
    @Override
    public void update(String tableName) {
        
        getAll();
     
        String sql = "UPDATE "+tableName+""
                + " SET `Date Modified`= '" + getCurrentDateTime() + "',"
                //+ "`Date Modified`= '" + getCurrentDateTime() + "',"
                + "`Employee ID` = '" + this.EmployeeID + "',"
                + "`Name`= '" + this.Name + "',"
                + "`Department`= '" + this.Department + "',"
                + "`Shift Date`= '" +getDate1()  + "', "
                 + "`Shift Time`= '" + this.ShiftTime + "', "
                + "`Leave Details`='" + this.LeaveDetails + "' "
                + "WHERE `Shift Record No` = '" + this.ShiftRecordID + "'";
        
        JOptionPane.showMessageDialog(null, sql);
        
        try 
        {
                pst = con.prepareStatement(sql);
                pst.execute();
                loadTable(tableName,Shift_Management_Frame.tblShiftManagement);   
        } 
        catch (Exception e) 
        {
               
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        
        
    }
/////////////////////////////////////////////////Clear Method/////////////////////////////////////////////////////////////////    
    public void Clear()
    {
        Shift_Management_Frame.txtLeaveDetails.setText("");
        Shift_Management_Frame.txtName.setText("");
        Shift_Management_Frame.txtEventDetails.setText("");
        Shift_Management_Frame.txtSearchBox.setText("");
      
 
    }
 /////////////////////////////////////////////////////////////Search////////////////////////////////////////////////////////   
             public void Modelsearch()
    {
        String filters = Shift_Management_Frame.cmbSearchBy.getSelectedItem().toString();
        String filter = "`"+filters+"`";
        String search=Shift_Management_Frame.txtSearchBox.getText();
        String tablename = "shift_management";
        JTable tblName = Shift_Management_Frame.tblShiftManagement;
        
        search(filter,search,tablename,tblName);

    }
    
}
