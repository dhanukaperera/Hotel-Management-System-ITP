/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.event_handling;

import static app.event_handling.Customer_Information_Frame.cmbSearchBy;
import static app.event_handling.Customer_Information_Frame.txtSearchBox;
import app.event_handling.View_Booking_Frame;
import static app.event_handling.View_Booking_Frame.jDateChooser1;
import static app.event_handling.View_Booking_Frame.tblViewBooking;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.HMS;
import source.DBConnection;


public class View_Booking_Model extends HMS
{
    
    private String bookingNo;
    private String customerNo;
    private String functionType;
    private int totalNoOfGuest;
    private float advance;
    private String tdate;
    private String startTime;
    private String endTime;
    private String menuNo;
    
    public View_Booking_Model()
    {
        con = DBConnection.connect();
        
        this.bookingNo = "NULL";
        this.customerNo = "NULL";
        this.totalNoOfGuest = 0;
        this.advance=0;
        this.tdate = "NULL";
        this.startTime = "NULL";
        this.endTime = "NULL";
        this.menuNo = "NULL";
        this.functionType = "Null";
        
    }
    
    public String getPrimaryKey()
    {
        setBookingNo();
        getBookingNo();
        return this.bookingNo;
    }
    
    private void getBookingNo() { this.bookingNo = View_Booking_Frame.txtBookingNo.getText(); }
    
    private void getCustomerNo() { this.customerNo = View_Booking_Frame.txtCustomerNo.getText(); }
    
    private void getTotalNoofGuests() { this.totalNoOfGuest = Integer.parseInt(View_Booking_Frame.txtTotalNoOfGuest.getText()); }
    
    private void getStartTime() { this.startTime = View_Booking_Frame.txtStartTime.getText(); }
    
    private void getEndTime() { this.endTime = View_Booking_Frame.txtEndTime.getText(); }
    
    private void getFunctionType() { this.functionType = View_Booking_Frame.cmbFunctionType.getSelectedItem().toString(); }
    
    private void getAdvance() { this.advance = Float.parseFloat(View_Booking_Frame.txtAdvance.getText()); }
    
    private void getDate() { this.tdate = getDateFromPicker(jDateChooser1); }
    
    private void getMenuNo() { this.menuNo = View_Booking_Frame.cmbMenuNo.getSelectedItem().toString(); }
    
     
    private void getAll()
    {
        getBookingNo();
        getCustomerNo();
        getTotalNoofGuests();
        getStartTime();
        getEndTime();
        getFunctionType();
        getAdvance();
        getDate();
        getMenuNo();
    }
    
    
    private void setBookingNo() { View_Booking_Frame.txtBookingNo.setText(View_Booking_Frame.tblViewBooking.getValueAt(getSelectedRow(View_Booking_Frame.tblViewBooking), 0).toString());}
    
    private void setCustomerNo() { View_Booking_Frame.txtCustomerNo.setText(View_Booking_Frame.tblViewBooking.getValueAt(getSelectedRow(View_Booking_Frame.tblViewBooking), 2).toString());}
    
    private void setCustomerID() { View_Booking_Frame.txtCustomerID.setText(View_Booking_Frame.tblViewBooking.getValueAt(getSelectedRow(View_Booking_Frame.tblViewBooking), 2).toString());}
    
    private void setFunctionType() { View_Booking_Frame.cmbFunctionType.setSelectedItem(View_Booking_Frame.tblViewBooking.getValueAt(getSelectedRow(View_Booking_Frame.tblViewBooking), 3).toString());}

    private void setTotalNoOfGuest() { View_Booking_Frame.txtTotalNoOfGuest.setText(View_Booking_Frame.tblViewBooking.getValueAt(getSelectedRow(View_Booking_Frame.tblViewBooking), 4).toString());}
    
    private void setAdvance() { View_Booking_Frame.txtAdvance.setText(View_Booking_Frame.tblViewBooking.getValueAt(getSelectedRow(View_Booking_Frame.tblViewBooking), 5).toString());}
    
    private void setStartTime() { View_Booking_Frame.txtStartTime.setText(View_Booking_Frame.tblViewBooking.getValueAt(getSelectedRow(View_Booking_Frame.tblViewBooking), 8).toString());}
    
    private void setEndTime() { View_Booking_Frame.txtEndTime.setText(View_Booking_Frame.tblViewBooking.getValueAt(getSelectedRow(View_Booking_Frame.tblViewBooking), 9).toString());}
    
    private void setMenuNo() { View_Booking_Frame.cmbMenuNo.setSelectedItem(View_Booking_Frame.tblViewBooking.getValueAt(getSelectedRow(View_Booking_Frame.tblViewBooking), 10).toString());}
    
    public void setAll()
    {
        setBookingNo();
        setCustomerNo();
        //setFunctionType();
        setTotalNoOfGuest();
        setAdvance();
        setStartTime();
        setEndTime();
        setCustomerID();
        //setMenuNo();
        
    }
            
    
           
            
    @Override
    public void add(String tableName) {
        
    }

    @Override
    public void update(String tableName) {
         getAll();
     
        String sql = "UPDATE "+tableName+""
                + " SET `Date`= "+"'" + getCurrentDateTime() + "',"
                + "`Function Type`='" + this.functionType + "',"
                + "`Total No Of Guest`=" + this.totalNoOfGuest + ", "
                + "`Advance`=" + this.advance + ", "
                //+ "`Booking Date`='" + this.tdate + "', "
                + "`Start Time`='" + this.startTime + "', "
                + "`End Time`='" + this.endTime + "', "
                + "`Menu No`='" + this.menuNo + "'"
                + "WHERE `Booking No` = '" + this.bookingNo + "'";
        
       //JOptionPane.showMessageDialog(null,sql);
        
        try 
        {
                pst = con.prepareStatement(sql);
                pst.execute();
                loadTable("view_event_booking",View_Booking_Frame.tblViewBooking);   
        } 
        catch (Exception e) 
        {
               
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void clear()
    {
        View_Booking_Frame.txtBookingNo.setText("");
        View_Booking_Frame.txtCustomerNo.setText("");
        View_Booking_Frame.txtStartTime.setText("");
        View_Booking_Frame.txtEndTime.setText("");
        View_Booking_Frame.txtTotalNoOfGuest.setText("");
        View_Booking_Frame.txtAdvance.setText("");
    }

    public boolean isEmpty(JTextField txtBookingNo, String booking_No_field_is_empty) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isEmpty(JComboBox<String> cmbFunctionType, String function_Type_field_is_empty) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//      public void Modelsearch()
//    {
//        String filters = cmbSearchBy.getSelectedItem().toString();
//        String filter = "`"+filters+"`";
//        String search=txtSearchBox.getText();
//        String tablename = "view_event_booking";
//        JTable tblName = tblViewBooking;
//        
//        search(filter,search,tablename,tblName);
//
//    }

    
    public void loadCustomerInfo()
    {
        getCustomerNo();
        
        String customerinfo = "SELECT `First Name`,`Last Name`,`NIC`,`Address`,`Contact No`,`Email` FROM event_handling_customer_info WHERE `Customer ID`='"+this.customerNo+"'";
        
        System.out.println(customerinfo);
        
        try {
                pst = con.prepareStatement(customerinfo);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String fname = rst.getString("First Name");
                    View_Booking_Frame.txtFirstName.setText(fname);
                    String lname = rst.getString("Last Name");
                    View_Booking_Frame.txtLastName.setText(lname);
                    String nic = rst.getString("NIC");
                    View_Booking_Frame.txtNIC.setText(nic);
                    String address = rst.getString("Address");
                    View_Booking_Frame.txtAddress.setText(address);
                    String contactno = rst.getString("Contact No");
                    View_Booking_Frame.txtContactNO.setText(contactno);
                    String email = rst.getString("Email");
                    View_Booking_Frame.txtEmail.setText(email);
                }
                
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
    }
}
    
    
    

   
    


