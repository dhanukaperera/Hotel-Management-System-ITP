/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.event_handling;

import app.event_handling.Venue_Booking_Frame;
import static app.event_handling.Venue_Booking_Frame.jDateChooser1;
import static app.event_handling.Venue_Booking_Frame.tblmenu;
import app.event_handling.View_Booking_Frame;
import java.sql.ResultSet;
import java.util.Date;
import java.util.UUID;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.HMS;
import net.proteanit.sql.DbUtils;
import source.DBConnection;


public class Venue_Booking_Model extends HMS
{
    private String customerNo;
    private String firstName;
    private String lastName;
    private String address;
    private String contactNo;
    private String email;
    private String nic;
    private String bookingNo;
    private String functionType;
    private int totalNoOfGuest;
    private float advance;
    private String functiondate;
    private String startTime;
    private String endTime;
    private String menuNo;
    
 
    public Venue_Booking_Model()
    {
        con = DBConnection.connect();
        
        this.customerNo = "NULL";
        this.firstName = "NULL";
        this.lastName = "NULL";
        this.nic = "NULL";
        this.address = "NULL";
        this.contactNo = "NULL";
        this.email = "NULL";
        this.bookingNo = "NULL";
        this.totalNoOfGuest = 0;
        this.advance = 0;
        this.functiondate = "NULL";
        this.startTime = "NULL";
        this.endTime = "NULL";
        this.menuNo = "NULL";
        this.functionType = "Null";
        
    }
    
    public String getPrimaryKey()
    {
        getBookingNo();
        //setBookingNo();
        return this.bookingNo;
    }
    
    private void getCustomerNo() { this.customerNo = Venue_Booking_Frame.txtCustomerNo.getText(); }
    
    private void getFirstName() { this.firstName = Venue_Booking_Frame.txtFirstName.getText(); }
    
    private void getLastName() { this.lastName = Venue_Booking_Frame.txtLastName.getText(); }
    
    private void getNIC() { this.nic = Venue_Booking_Frame.txtNIC.getText(); }
    
    private void getAddress() { this.address = Venue_Booking_Frame.txtAddress.getText(); }
    
    private void getContactNo() { this.contactNo = Venue_Booking_Frame.txtContactNo.getText(); }
    
    private void getEmail() { this.email = Venue_Booking_Frame.txtEmail.getText(); }
    
    private void getBookingNo() { this.bookingNo = Venue_Booking_Frame.txtBookingNo.getText(); }
    
    private void getTotalNoofGuests() { this.totalNoOfGuest = Integer.parseInt(Venue_Booking_Frame.txtTotalNoOfGuest.getText()); }
    
    private void getStartTime() { this.startTime = Venue_Booking_Frame.cmbStartTime.getSelectedItem().toString(); }
    
    private void getEndTime() { this.endTime = Venue_Booking_Frame.cmbEndTime.getSelectedItem().toString(); }
    
    private void getFunctionType() { this.functionType = Venue_Booking_Frame.cmbFunctionType.getSelectedItem().toString(); }
    
    private void getAdvance() { this.advance = Float.parseFloat(Venue_Booking_Frame.txtAdvance.getText()); }
    
    private void getfunctionDate() {this.functiondate = getDateFromPicker(jDateChooser1);}
    
    private void getMenuNo() { this.menuNo = Venue_Booking_Frame.cmbMenuNo.getSelectedItem().toString(); }
    

   public void getAll()
    {
        getCustomerNo();
        getFirstName();
        getLastName();
        getAddress();
        getEmail();
        getContactNo();
        getNIC();
        getTotalNoofGuests();
        getStartTime();
        getEndTime();
        getFunctionType();
        getAdvance();
        getfunctionDate();
        getMenuNo();
        getBookingNo();
    }
   
    @Override
    public void add(String tableName) {
        
        String s="SELECT MAX(`Booking No`) FROM view_event_booking";
            System.out.println(s);
            
            try {
                pst = con.prepareStatement(s);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String st = rst.getString("MAX(`Booking No`)");
                    
                    if(st==null)
                    {
                        Venue_Booking_Frame.txtBookingNo.setText("EBID-00001");
                        
                    }
                    else
                    {
                        String temp = st.substring(5,10);
                    int temp1 = Integer.parseInt(temp);
                    temp1++;
                    temp = String.valueOf(temp1);
                    if(temp1<10)
                    {
                        temp="0000"+temp;
                    }
                    else if(temp1<100)
                    {
                        temp="000"+temp;
                    }
                    else if(temp1<1000)
                    {
                        temp="00"+temp;
                    }
                    else if(temp1<10000)
                    {
                        temp="0"+temp;
                    }
                    
                    String inno = "EBID-"+temp;
                    
                    Venue_Booking_Frame.txtBookingNo.setText(inno);
                    
                    }
                }
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            } 
            getAll();
       
        String sql = "INSERT INTO "+tableName+""
                + "( `Booking No`,`Date`,`Customer No`, `Function Type`, `Total No of Guest`, `Advance`,`Booking Date`,`Start Time`,`End Time`,`Menu No`)"
                + " VALUES("
                + "'"+this.bookingNo+"',"
                + "'"+getCurrentDateTime()+"',"
                + "'"+this.customerNo+"',"
                + "'"+this.functionType+"',"
                + ""+this.totalNoOfGuest+","
                + ""+this.advance+","
                + "'"+this.functiondate+"',"
                + "'"+this.startTime+"',"
                + "'"+this.endTime+"',"
                + "'"+this.menuNo+"'"
                + ")";
        System.out.println(sql);
            try 
            {
                pst = con.prepareStatement(sql);
                pst.execute();
            } 
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
            
            loadTable("view_event_booking",app.event_handling.View_Booking_Frame.tblViewBooking);
      
       String sql2 = "INSERT INTO event_handling_customer_info"
               + "( `Customer ID`,`Date`, `First Name`,`Last Name`,`NIC`, `Address`, `Email`, `Contact No`)"
               + " VALUES("
               + "'"+this.customerNo+"',"
               + "'"+getCurrentDateTime()+"',"
               + "'"+this.firstName+"',"
               + "'"+this.lastName+"',"
               + "'"+this.nic+"',"
               + "'"+this.address+"',"
               + "'"+this.email+"',"
               + "'"+this.contactNo+"'"
               + ")";
               
      //JOptionPane.showMessageDialog(null,sql2);
        
            try 
            {
                pst = con.prepareStatement(sql2);
                pst.execute();
            } 
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,e);
            }
            loadTable("event_handling_customer_info",app.event_handling.Customer_Information_Frame.tblCustomerInformation);

        } 
    

    @Override
    public void update(String tableName) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void clear()
    {
        Venue_Booking_Frame.txtAddress.setText("");
        Venue_Booking_Frame.txtCustomerNo.setText("");
        Venue_Booking_Frame.txtContactNo.setText("");
        Venue_Booking_Frame.txtEmail.setText("");
        Venue_Booking_Frame.txtFirstName.setText("");
        Venue_Booking_Frame.txtLastName.setText("");
        Venue_Booking_Frame.txtNIC.setText("");
        Venue_Booking_Frame.txtBookingNo.setText("");
        //Venue_Booking_Frame.txtStartTime.setText("");
        //Venue_Booking_Frame.txtEndTime.setText("");
        Venue_Booking_Frame.txtTotalNoOfGuest.setText("");
        Venue_Booking_Frame.txtAdvance.setText("");
        
        
        
    }
    
    public void generateCustomerNo()
    {
        
         String s="SELECT MAX(`Customer ID`) FROM event_handling_customer_info";
            System.out.println(s);
            
            try {
                pst = con.prepareStatement(s);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String st = rst.getString("MAX(`Customer ID`)");
                    if(st==null)
                    {
                        Venue_Booking_Frame.txtCustomerNo.setText("CNO-00001");
                    }
                    else
                    {
                        String temp = st.substring(4,9);
                    int temp1 = Integer.parseInt(temp);
                    temp1++;
                    temp = String.valueOf(temp1);
                    if(temp1<10)
                    {
                        temp="0000"+temp;
                    }
                    else if(temp1<100)
                    {
                        temp="000"+temp;
                    }
                    else if(temp1<1000)
                    {
                        temp="00"+temp;
                    }
                    else if(temp1<10000)
                    {
                        temp="0"+temp;
                    }
                    
                    String inno = "CNO-"+temp;
                    
                    Venue_Booking_Frame.txtCustomerNo.setText(inno);
                    
                    }
                }
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
    }
    
    public void selectMenu()
    {
        getMenuNo();
        
        String sql = "SELECT `Food Type`,`Name` FROM event_menu WHERE `Menu No` = '"+this.menuNo+"'";
      System.out.println(sql);
        try 
        {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery(); 
            tblmenu.setModel(DbUtils.resultSetToTableModel(rs));
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void MenuNo()
    {  
     try
     {
       String sql = "SELECT `Menu No` FROM  event_menu";
       System.out.println(sql);
       pst = con.prepareStatement(sql);
       
       rs = pst.executeQuery();
       Venue_Booking_Frame.cmbMenuNo.removeAllItems();
       while(rs.next())
       {
            String MenuNo = rs.getString("Menu No");
            Venue_Booking_Frame.cmbMenuNo.addItem(MenuNo);
   
       }
   
     }
     catch (Exception e)
     {
         JOptionPane.showMessageDialog(null,e);
     }
       
   }
    
    public void isSameDate()
    {
        getfunctionDate();
        getStartTime();
        String temp="";
        String billno="";
        String fdate = "";
        String StartTime = "";
        String bd="";
        String stt="";
        int block=0;
            
        int ro = View_Booking_Frame.tblViewBooking.getRowCount();
        for(int x=1;x<=ro;x++)
        {
            temp=String.valueOf(x);
            if(x<10)
            {
                temp="0000"+temp;
            }
            else if(x<100)
            {
                temp="000"+temp;
            }
            else if(x<1000)
            {
                temp="00"+temp;
            }
            else if(x<10000)
            {
                temp="0"+temp;
            }
            
            billno="EBID-"+temp;
            
            fdate = "SELECT `Booking Date`,`Start Time` FROM view_event_booking WHERE `Booking No` = '"+billno+"'";
            
            try {
                pst = con.prepareStatement(fdate);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    bd = rst.getString("Booking Date");
                    stt = rst.getString("Start Time");
                }
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            } 
        
            String fd =this.functiondate;
        String st = this.startTime;
        //JOptionPane.showMessageDialog(null, x);
        
        
        if(fd.equals(bd) && st.equals(stt))
        {
            JOptionPane.showMessageDialog(null, "Date and Time is Booked");
            x=ro;
            block=1;
        }
        }
        if(block == 0)
        {
            add("view_event_booking");
        }
    }
    
 }


  //  @Override
  //  public void update(String tableName) {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 //   }
                                                                                                                                                                                                    
    
    
    
