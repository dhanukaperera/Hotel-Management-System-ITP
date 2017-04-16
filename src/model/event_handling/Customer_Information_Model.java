/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.event_handling;

import app.event_handling.Customer_Information_Frame;
import static app.event_handling.Customer_Information_Frame.cmbSearchBy;
import static app.event_handling.Customer_Information_Frame.tblCustomerInformation;
import static app.event_handling.Customer_Information_Frame.txtSearchBox;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.HMS;
import source.DBConnection;

public class Customer_Information_Model extends HMS{
    
    private String customerNo;
    private String firstName;
    private String lastName;
    private String address;
    private String contactNo;
    private String email;
    private String nic;
    private String bookingno;
    
    public Customer_Information_Model()
    {
        con = DBConnection.connect();
        
        this.customerNo = "NULL";
        this.firstName = "NULL";
        this.lastName = "NULL";
        this.nic = "NULL";
        this.address = "NULL";
        this.contactNo = "NULL";
        this.email = "NULL";
        this.bookingno=null;
    }
    
    public String getPrimaryKey()
    {
        getCustomerNo();
        setCustomerNo();
        return this.customerNo;
    }
    
    private void getCustomerNo() { this.customerNo = Customer_Information_Frame.txtCustomerNo.getText(); }
    
    private void getFirstName() { this.firstName = Customer_Information_Frame.txtContactNo.getText(); }
    
    private void getLastName() { this.lastName = Customer_Information_Frame.txtLastName.getText(); }
    
    private void getNIC() { this.nic = Customer_Information_Frame.txtNIC.getText(); }
    
    private void getAddress() { this.address = Customer_Information_Frame.txtAddress.getText(); }
    
    private void getContactNo() { this.contactNo = Customer_Information_Frame.txtNIC.getText(); }
    
    private void getEmail() { this.email = Customer_Information_Frame.txtEmail.getText(); }
    
    
    private void getAll()
    {
        getCustomerNo();
        getFirstName();
        getLastName();
        getAddress();
        getEmail();
        getContactNo();
        getNIC();
    }
    
    private void setCustomerNo() { Customer_Information_Frame.txtCustomerNo.setText(Customer_Information_Frame.tblCustomerInformation.getValueAt(getSelectedRow(Customer_Information_Frame.tblCustomerInformation), 0).toString());}
    
    private void setFirstName() { Customer_Information_Frame.txtBookingNO.setText(Customer_Information_Frame.tblCustomerInformation.getValueAt(getSelectedRow(Customer_Information_Frame.tblCustomerInformation), 2).toString());}
    
    private void setLastName() { Customer_Information_Frame.txtLastName.setText(Customer_Information_Frame.tblCustomerInformation.getValueAt(getSelectedRow(Customer_Information_Frame.tblCustomerInformation), 3).toString());}
    
    private void setNIC() { Customer_Information_Frame.txtNIC.setText(Customer_Information_Frame.tblCustomerInformation.getValueAt(getSelectedRow(Customer_Information_Frame.tblCustomerInformation), 4).toString());}
    
    private void setAddress() { Customer_Information_Frame.txtAddress.setText(Customer_Information_Frame.tblCustomerInformation.getValueAt(getSelectedRow(Customer_Information_Frame.tblCustomerInformation), 5).toString());}
    
    private void setEmail() { Customer_Information_Frame.txtEmail.setText(Customer_Information_Frame.tblCustomerInformation.getValueAt(getSelectedRow(Customer_Information_Frame.tblCustomerInformation), 6).toString());}
    
    private void setContactNo() { Customer_Information_Frame.txtContactNo.setText(Customer_Information_Frame.tblCustomerInformation.getValueAt(getSelectedRow(Customer_Information_Frame.tblCustomerInformation), 7).toString());}
    
    public void setAll()
    {
        setCustomerNo();
        setFirstName();
        setLastName();
        setNIC();
        setAddress();
        setEmail();
        setContactNo();
       
    }
    
    
    
    
    @Override
    public void add(String tableName) {
        
    }

    @Override
    public void update(String tableName) {
          getAll();
           
        String sql = "UPDATE "+tableName+""
                + " SET `Date`= '"+ getCurrentDateTime() +"',"
                + "`First Name`='"+ this.firstName +"',"
                + "`Last Name`='" +this.lastName +"',"
                + "`NIC`='"+ this.nic +"',"
                + "`Address`='"+ this.address +"',"
                + "`Email`='"+ this.email +"',"
                + "`Contact No`='"+ this.contactNo +"'"
                + "WHERE `Customer ID` = '"+ this.customerNo +"'";
        
        
        
        System.out.println(sql);
        
        try 
        {
                pst = con.prepareStatement(sql);
                pst.execute();
                loadTable("event_handling_customer_info",Customer_Information_Frame.tblCustomerInformation);   
        } 
        catch (Exception e) 
        {
               
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    public void clear()
    {
        Customer_Information_Frame.txtCustomerNo.setText("");
        Customer_Information_Frame.txtBookingNO.setText("");
        Customer_Information_Frame.txtLastName.setText("");
        Customer_Information_Frame.txtAddress.setText("");
        Customer_Information_Frame.txtEmail.setText("");
        Customer_Information_Frame.txtNIC.setText("");
        Customer_Information_Frame.txtContactNo.setText("");
        
    }

    public boolean isEmpty(JTextField txtBookingNo, String booking_No_field_is_empty) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      public void Modelsearch()
    {
        String filters = cmbSearchBy.getSelectedItem().toString();
        String filter = "`"+filters+"`";
        String search=txtSearchBox.getText();
        String tablename = "event_handling_customer_info";
        JTable tblName = tblCustomerInformation;
        
        search(filter,search,tablename,tblName);

    }

    public void loadBookingDetails()
    {
        getCustomerNo();
        
        String customerinfo = "SELECT `Booking No`,`Function Type`,`Total No of Guest`,`Booking Date`,`Start Time`,`End Time` FROM view_event_booking WHERE `Customer No`='"+this.customerNo+"'";
        
        System.out.println(customerinfo);
        
        try {
                pst = con.prepareStatement(customerinfo);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String fname = rst.getString("Booking No");
                    Customer_Information_Frame.txtBookingNo.setText(fname);
                    String lname = rst.getString("Function Type");
                    Customer_Information_Frame.txtFunctionType.setText(lname);
                    String nic = rst.getString("Total No of Guest");
                    Customer_Information_Frame.txtNoofGuest.setText(nic);
                    String address = rst.getString("Booking Date");
                    Customer_Information_Frame.txtDate.setText(address);
                    String contactno = rst.getString("Start Time");
                    Customer_Information_Frame.txtStartTime.setText(contactno);
                    String email = rst.getString("End Time");
                    Customer_Information_Frame.txtEndTime.setText(email);
                }
                
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
    }
    
}
