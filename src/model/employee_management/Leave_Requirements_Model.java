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
import static app.employee_management.Leave_Requirements_Frame.txtLeavesForaMonthD;
//import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.HMS;
import reports.iReport;
import reports.iReportView;
import source.DBConnection;

/**
 *
 * @author Udeshika Ranaweera
 */
public class Leave_Requirements_Model extends HMS {
    
    private String EmployeeID;
    private String LeaveDate;
    private String LeaveRequirementNo;
    private int RequiredLeaves;
    private String CurrentDate;
    private int NoOfAbsences;
    private int LeavesForaMonthD;
    private String Approval;
    private String EventDeatails;
    private static String CancelStatus;
    
    
    public Leave_Requirements_Model()
    {
        con = DBConnection.connect();
        
        this.EmployeeID = "No Employee ID";
        this.LeaveRequirementNo = "No Leave Requirement No";
        this.LeaveDate = "NULL";
        this.RequiredLeaves = 0;
        this.CurrentDate = "NULL" ;
        this.NoOfAbsences = 0;
        this.LeavesForaMonthD = 0;
        this.Approval = "No Status";
        this.EventDeatails="No Event";
        this.CancelStatus="Cancel";
        colList = "`Leave Requirement No`,`Employee ID`,`Date Modified`,`Leave Date`,`Required Leaves`,`Current Date`,`Absences`,`Leaves For a Month`,`Approval`,`Cancel Status`";
        
    }
    
/////////////////////////////////////////////////////////////getters/////////////////////////////////////////////////////////
    
        public String getPrimaryKey()
    {
        setLeaveRequirementNo();
        getLeaveRequirementNo();
        return this.LeaveRequirementNo;
    }
        
        private void getLeaveRequirementNo()
        {
            this.LeaveRequirementNo = Leave_Requirements_Frame.txtLeaveRequirementNo.getText();
        }
        
        private void getEmployeeID()
        {
            this.EmployeeID = Leave_Requirements_Frame.cmbEmployeeID.getSelectedItem().toString();
        }
        
        private void getLeaveDate()
        {
            this.LeaveDate = getDateFromPicker(Leave_Requirements_Frame.dtpLeaveDate);
        }
        
        private void getRequiredLeaves()
        {
            this.RequiredLeaves = Integer.parseInt(Leave_Requirements_Frame.txtRequiredLeaves.getText());
        }
        
        private void getCurrentDate()
        {
             this.CurrentDate = Leave_Requirements_Frame.txtCurrentDate.getText();
        }
        
        private void getNoOfAbcences()
        {
            this.NoOfAbsences = Integer.parseInt(Leave_Requirements_Frame.txtNoOfAbsences.getText());
        }
        
        private void getLeavesForaMonth()
        {
            this.LeavesForaMonthD = Integer.parseInt(Leave_Requirements_Frame.txtLeavesForaMonthD.getText());
        }
       
        private void getApproval()
        {
             this.Approval = Leave_Requirements_Frame.txtApproval.getText();
        }

        private void getCancelStatus()
        {
            //this.CancelStatus;
            Leave_Requirements_Model.CancelStatus=Leave_Requirements_Frame.cancel;
        }
        private void getAll()
        {
            getLeaveRequirementNo();
            getEmployeeID();
            getLeaveDate();
            getRequiredLeaves();
            getCurrentDate();
            getNoOfAbcences();
            getLeavesForaMonth();
            getApproval();
            getCancelStatus();

        }
        
/////////////////////////////////////////////////////////setters/////////////////////////////////////////////////////////////        
        private void setLeaveRequirementNo()
        {
             Leave_Requirements_Frame.txtLeaveRequirementNo.setText(Leave_Requirements_Frame.tblLeaveRequirements.getValueAt(getSelectedRow(Leave_Requirements_Frame.tblLeaveRequirements), 0).toString());
        }
        
        private void setEmployeeID()
        {
            Leave_Requirements_Frame.cmbEmployeeID.setSelectedItem(Leave_Requirements_Frame.tblLeaveRequirements.getValueAt(getSelectedRow(Leave_Requirements_Frame.tblLeaveRequirements), 1).toString());
            
            
        }
        
        private void setLeaveDate()
        {
            Leave_Requirements_Frame.dtpLeaveDate.setDate(StringToDate(this.LeaveDate));
        }
        
        private void setRequiredLeaves()
        {
             Leave_Requirements_Frame.txtRequiredLeaves.setText(Leave_Requirements_Frame.tblLeaveRequirements.getValueAt(getSelectedRow(Leave_Requirements_Frame.tblLeaveRequirements), 4).toString());
             //integer to string
        }
        
        private void setCurrentDate()
        {
                    
        }
        
        
        private void setNoOfAbcences()
        {
            
             Leave_Requirements_Frame.txtNoOfAbsences.setText(Leave_Requirements_Frame.tblLeaveRequirements.getValueAt(getSelectedRow(Leave_Requirements_Frame.tblLeaveRequirements), 6).toString());
        }
        
        private void setLeavesForaMonth()
        {
            Leave_Requirements_Frame.txtLeavesForaMonthD.setText(Leave_Requirements_Frame.tblLeaveRequirements.getValueAt(getSelectedRow(Leave_Requirements_Frame.tblLeaveRequirements), 7).toString());
            
        }
        
        private void setApproval()
        {
           Leave_Requirements_Frame.txtApproval.setText(Leave_Requirements_Frame.tblLeaveRequirements.getValueAt(getSelectedRow(Leave_Requirements_Frame.tblLeaveRequirements), 8).toString());
        }
          

        public void setAll()
        {
            setLeaveRequirementNo();
            setEmployeeID();
            setLeaveDate();
            setRequiredLeaves();
            setCurrentDate();
            setNoOfAbcences();
            setLeavesForaMonth();
            setApproval();
        }
//////////////////////////////////////////////////////////Add Method/////////////////////////////////////////////////////////
    @Override
    public void add(String tableName) {
//        System.out.println(7);
           getAll();
//           System.out.println(8);
        String sql = "INSERT INTO "+tableName+""
                + "(`Leave Requirement No`,`Employee ID`,`Date Modified`,`Leave Date`,`Required Leaves`,`Current Date`,`Absences`,`Leaves For a Month`,`Approval`,`Cancel Status`)"
                + " VALUES('"+generatePrimaryKey("Leave Requirement No","leave_requirement","LR")+"',"
                + "'"+this.EmployeeID+"',"
                + "'"+getCurrentDateTime()+"',"
                + "'"+this.LeaveDate+"',"
                + ""+this.RequiredLeaves+","
                + "'"+this.CurrentDate+"',"
                + ""+this.NoOfAbsences+","
                + ""+this.LeavesForaMonthD+","
                + "'"+this.Approval+"',"
                + "'"+this.CancelStatus+"'"
               
                + ")";
        System.out.println(sql);
        


                
//        String d1 =this.LeaveDate;
//        String fdate=d1.substring(0,8);
//        String first="01";
//        String firstdatemonth=d1.substring(6,7);
//        int fmonth=Integer.parseInt(firstdatemonth);
//         String d = getCurrentDateTime();
//         String currentMonth=d.substring(6,7);
//         int cmonth=Integer.parseInt(currentMonth);
//          System.out.println(fmonth);
//          System.out.println(currentMonth);
      
        
        
        
          try 
        {
            pst = con.prepareStatement(sql);
            pst.execute();
            loadTable(tableName,Leave_Requirements_Frame.tblLeaveRequirements);   
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
//////////////////////////////////////////////////////////////Update Query////////////////////////////////////////////////////
    @Override
    public void update(String tableName) {
        
          getAll();
     
        String sql = "UPDATE "+tableName+""
                + " SET `Employee ID`= '" + this.EmployeeID + "',"
               // + "`Employee ID`= '" + this.EmployeeID + "',"
//                + "`Date Modified`= '" + getCurrentDateTime() + "',"
                + "`Leave Date` = '" + this.LeaveDate + "',"
                + "`Required Leaves`= " + this.RequiredLeaves + ", "
//                + "`Current Date`= '" + this.CurrentDate + "', "
//                + "`Absences`= " + this.NoOfAbsences + " ,"
//                + "`Leaves For a Month`= " + this.LeavesForaMonthD + " ,"
//                + "`Approval`='" + this.Approval + "' "
                + "`Cancel Status`='" + this.CancelStatus + "' "
                + "WHERE `Leave Requirement No` = '" + this.LeaveRequirementNo + "'";
        System.out.println(sql);
        try 
        {
                pst = con.prepareStatement(sql);
                pst.execute();
                loadTable(tableName,Leave_Requirements_Frame.tblLeaveRequirements);   
        } 
        catch (Exception e) 
        {
               
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
        
//////////////////////////////////////////////////////////Find Number Of Leaves///////////////////////////////////////////////    
     public void findNoOfLeaves(String EmployeeID)
       {
               this.EmployeeID= EmployeeID;
               
               
           try 
           {
           
              String LeaveNosql="SELECT `Leaves For a Month` FROM manage_employee_roles , employee_details WHERE `Employee ID`='"+this.EmployeeID+"' AND `Employee Role`=`Position`";
               
              //JOptionPane.showMessageDialog(null,LeaveNosql);
              
                pst = con.prepareStatement(LeaveNosql);
                rs = pst.executeQuery();
                
                if(rs.next())
                {
                   String searched_LeaveNo = rs.getString("Leaves For a Month");                  
                   txtLeavesForaMonthD.setText(searched_LeaveNo);
               }
               
           } catch (Exception e) 
           {
                JOptionPane.showMessageDialog(null, e);
           }
       }
///////////////////////////////////////////////////////Find Abcenses//////////////////////////////////////////////////////////    
       public void FindAbsences(String EmployeeID)
        {
            this.EmployeeID=EmployeeID;
            String AttendanceState="Absence";
            String dd=getCurrentDateTime();
            String newdd=dd.substring(0,10);
            String Year=dd.substring(0,5);
            
            String newmonth=dd.substring(0,8);
            String no="01";
            String Firstday=Year+"01"+"31";
            String Lastday=Year+"12"+"31";
            String Cancel="Not Cancel";
          
            
            try {
                
                String count="SELECT count(`Attendance Status`) FROM `attendance` WHERE `Employee ID`='"+this.EmployeeID+"' AND `Attendance Status`='"+AttendanceState+"' AND `Date` between '"+Firstday+"' and '"+Lastday+"'";
                   System.out.println(count);
                pst = con.prepareStatement(count);
                rs = pst.executeQuery();
                String searched_Name="";
               
                if(rs.next())
                {
                  searched_Name = rs.getString("count(`Attendance Status`)");
                  //JOptionPane.showMessageDialog(null, searched_Name);
                   Leave_Requirements_Frame.txtNoOfAbsences.setText(searched_Name);
                   
               }
               
            } catch (Exception e) {
            }
        }
     
////////////////////////////////////////////////////        
//       public void LeaveForaMonth()
//       {
//           
//           //String EmployeeID
//          // JOptionPane.showMessageDialog(null, Position);
//          // JOptionPane.showMessageDialog(null, EmployeeID);
//           try {
//               String Position="SELECT `Employee Role` FROM `manage_employee_roles`";
//                pst = con.prepareStatement(Position);
//                rs = pst.executeQuery();
//                String searched_Name2="";
//                if(rs.next())
//                {
//                  searched_Name2 = rs.getString("Employee Role");
//                    System.out.println(searched_Name2);
//                   //Leave_Requirements_Frame.txtLeavesForaMonthD.setText(searched_Name);
//                   
//               }
//                
//               
//               String leave="SELECT `Leave for a Month` FROM `manage_employee_roles`,`employee_details` WHERE `Employee ID`='"+this.EmployeeID+"' AND `Employee Role`='"+searched_Name2+"' AND `Position`=`Employee Role`";
//                pst = con.prepareStatement(leave);
//                rs = pst.executeQuery();
//                String searched_Name="";
//                
//                if(rs.next())
//                {
//                  searched_Name = rs.getString("Leave for a Month");
//                    System.out.println(searched_Name);
//                   Leave_Requirements_Frame.txtLeavesForaMonthD.setText(searched_Name);
//                   
//               }
//           } catch (Exception e) {
//           }
//       }

////////////////////////////////////////////////////////////////Clear Method//////////////////////////////////////////////////
       public void clear()
    {
       
        Leave_Requirements_Frame.txtNoOfAbsences.setText("");
        //Leave_Requirements_Frame.txtLeaveRequirementNo.setText("");
        Leave_Requirements_Frame.txtLeavesForaMonthD.setText("");
        //Leave_Requirements_Frame.txtCurrentDate.setText("");
        Leave_Requirements_Frame.txtApproval.setText("");
        Leave_Requirements_Frame.txtRequiredLeaves.setText("");
        Leave_Requirements_Frame.txtSearchBox.setText("");
    }
///////////////////////////////////////////////////////////Search Method//////////////////////////////////////////////////////
       public void Modelsearch()
    {
        String filters = Leave_Requirements_Frame.cmbSearchBy.getSelectedItem().toString();
        String filter = "`"+filters+"`";
        String search=Leave_Requirements_Frame.txtSearchBox.getText();
        String tablename = "leave_requirement";
        JTable tblName = Leave_Requirements_Frame.tblLeaveRequirements;
        
        search(filter,search,tablename,tblName);

    }
/////////////////////////////////////////////////////////////////Load Employee ID to ComboBox///////////////////////////////       
       public void LoadEmployeeID()
       {
           
           try {
               String sql="SELECT `Employee ID` FROM employee_details";
               pst=con.prepareStatement(sql);
               rs=pst.executeQuery();
               Leave_Requirements_Frame.cmbEmployeeID.removeAllItems();
               while(rs.next())
               {
                   String id=rs.getString("Employee ID");
                   Leave_Requirements_Frame.cmbEmployeeID.addItem(id);
               }
           } 
           catch (Exception e) 
           {
               JOptionPane.showMessageDialog(null,"error","error", JOptionPane.ERROR_MESSAGE);
           }
       }
       
///////////////////////////////////////////////  Find Leave Approval////////////////////////////////////////////////////////////////       
         public void FindApproval()
         { int RequiredLeaves1;
             String ab="Absence";
             String Employeeid=Leave_Requirements_Frame.cmbEmployeeID.getSelectedItem().toString();
             String cur=getCurrentDateTime();
             String current=cur.substring(0,5);
             //String newday=cur.substring(0,8);
             String newFirst=current+"01"+"01";
             String end=current+"12"+"31";
            
             String Approval="Not Approved and no pay";
             String Cancel="Not Cancel";
          
             RequiredLeaves1=Integer.parseInt(Leave_Requirements_Frame.txtRequiredLeaves.getText());
            
             //JOptionPane.showMessageDialog(null, RequiredLeaves1);
             
            
             String Absence="SELECT COUNT(`Approval`) FROM `leave_requirement` WHERE `Employee ID`='"+this.EmployeeID+"' AND `Approval`='"+Approval+"' AND `Cancel Status`='"+Cancel+"' AND `Date Modified` between '"+newFirst+"' AND '"+end+"'";
            // JOptionPane.showMessageDialog(null, Absence);
             
             String Leave="SELECT `Leaves For a Month` FROM `manage_employee_roles`,`employee_details` WHERE `Employee ID`='"+Employeeid+"' AND `Position`=`Employee Role`";
            // JOptionPane.showMessageDialog(null, Leave);

             String find="";
             String Find="";
               int f2=0;
               int f1=0;
               
               try {
                 
                  pst = con.prepareStatement(Absence);
                  rs = pst.executeQuery();
                  while(rs.next())
                  {
                      find=rs.getString("COUNT(`Approval`)");
                     // JOptionPane.showMessageDialog(null, find);
                      f2=Integer.parseInt(find);
                     // JOptionPane.showMessageDialog(null, f2);
                  }
               }
               catch(Exception e)
               {
                   JOptionPane.showMessageDialog(null, e);
               }
                  
                try{  
                  pst = con.prepareStatement(Leave);
                  rs = pst.executeQuery();
                  while(rs.next())
                  {
                      Find=rs.getString("Leaves For a Month");
                      //JOptionPane.showMessageDialog(null, Find);
                       f1=Integer.parseInt(Find);
                   //JOptionPane.showMessageDialog(null, f1);
                  }
                  
                }
                catch(Exception e)
                {
                }
                  
                  if(f1<f2)
                  {
                      Leave_Requirements_Frame.txtApproval.setText("Not Approved and No Pay");
                  }
                  else if(f2<f1)
                  {
                      int val=f1-f2;
                      if(RequiredLeaves1==val||RequiredLeaves1<val)
                      {
                          Leave_Requirements_Frame.txtApproval.setText("Can Apply");
                      }
                      else
                      {
                          Leave_Requirements_Frame.txtApproval.setText("Not Approved and No Pay");
                      }
                  }
                  
                   
           
             
             
             
             
             
         }
/////////////////////////////////////////////////iReport///////////////////////////////////////////////////
         public void report()
         {
             iReport z=new iReport();
             iReportView r=new iReportView(z.PROJECT_PATH+"\\employee_management\\Leave_Requirements.jasper");
             r.setVisible(true);
         }
       
}
