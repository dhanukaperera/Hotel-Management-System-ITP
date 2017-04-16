/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.laundry_and_room_service;

import app.laundry_and_room_service.Guest_Orders_Frame;
import app.laundry_and_room_service.Hotel_Orders_Frame;
import app.laundry_and_room_service.Room_States__Frame;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.HMS;
import net.proteanit.sql.DbUtils;
import source.DBConnection;


/**
 *
 * @author User
 */
public class Room_States__Model extends HMS {
    
    private String roomno;
    private String status;
    private String orderinvoiceno;
    private String delstatus;
    private String type;
    
    public Room_States__Model ()
    {
        con = DBConnection.connect();
        
        
        this.roomno = "NULL";
        this.status = "No Status";
        this.orderinvoiceno=null;
        this.delstatus=null;
        this.type=null;
        //colList = "`Room NO`,`Date Modified`,`Status`";
        System.out.println(colList);
    }
    
    // -------------------------------------------------------------------------
    // -- BEGIN Getting Values -------------------------------------------------
    
    private void getRoomNo () { this.roomno = Room_States__Frame.txtRoomno.getText(); } 
    
    private void getStatus () { this.status = Room_States__Frame.txtstatus.getText(); } 
    
    private void getall ()
    {
        getRoomNo ();
        getStatus ();
    }
    
    private void getOrderInvoiceNo() { this.orderinvoiceno = Room_States__Frame.txtOrderInvoiceNo.getText(); }
    
    private void getDeliveryStatus() { this.delstatus = Room_States__Frame.txtdelstatus.getText(); }
    
    private void getType() { this.type = Room_States__Frame.txttype.getText(); }
    
    private void getDelivery()
    {
        getOrderInvoiceNo();
        getDeliveryStatus();
        getType();
   }
    
    // -- END SET Values -------------------------------------------------------
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    // -- BEGIN Setting Values -------------------------------------------------
   
   private void setRoomNo () { Room_States__Frame.txtRoomno.setText(Room_States__Frame.tblRoomStatus.getValueAt(getSelectedRow(Room_States__Frame.tblRoomStatus), 0).toString()); }
   
   private void setStatus () { Room_States__Frame.txtstatus.setText(Room_States__Frame.tblRoomStatus.getValueAt(getSelectedRow(Room_States__Frame.tblRoomStatus), 2).toString()); }
         
    public void setAll ()
    {
        setRoomNo ();
        setStatus ();
    }
    
    private void setOrderInvoiceNo () { Room_States__Frame.txtOrderInvoiceNo.setText(Room_States__Frame.tblDeliveryStatus.getValueAt(getSelectedRow(Room_States__Frame.tblDeliveryStatus), 0).toString()); } 
    
    private void setDeliveryStatus () { Room_States__Frame.txtdelstatus.setText(Room_States__Frame.tblDeliveryStatus.getValueAt(getSelectedRow(Room_States__Frame.tblDeliveryStatus), 3).toString()); }
    
    private void setType () { Room_States__Frame.txttype.setText(Room_States__Frame.tblDeliveryStatus.getValueAt(getSelectedRow(Room_States__Frame.tblDeliveryStatus), 2).toString()); }
    
    public void setDelivery()
    {
        setDeliveryStatus();
        setOrderInvoiceNo();
        setType();
    }
    // -- END Setting Values ---------------------------------------------------
    // -------------------------------------------------------------------------
   

    @Override
    public void add(String tableName) {
        getall ();
        
        
        String sql = "INSERT INTO "+tableName+""
                + "(`Date`,`Status`)"
                + " VALUES("
                + "'"+getCurrentDateTime()+"',"
                 + "'"+this.status+"'"
                + ")";
        System.out.println(sql);
        
        try 
        {
            pst = con.prepareStatement(sql);
            pst.execute();
            loadTable("room_status", Room_States__Frame.tblRoomStatus);   
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update(String tableName) {
        getall();
        
        //String sql = "UPDATE "+tableName+ " SET Room_Type = '" + this.roomType + "', Date_Modified= '" + getCurrentDateTime() + "',Bed_Type = '" + this.bedType + "',Current_Stautus ='" +this.currentStatus+ "',Max_Guests='" + this.maxGuest, + "' WHERE DiskId = '" + this.roomNo + "'";
        String sql = "UPDATE "+tableName+""
                + " SET `Date`= '" + getCurrentDateTime() + "',"
                + "`Room NO` = '" + this.roomno + "',"
                + "`Status`='Available'"
                + "WHERE `Room No` = '" + this.roomno + "'";
        
        System.out.println(sql);
        try {
                pst = con.prepareStatement(sql);
                pst.execute();
                 loadTable("room_status", Room_States__Frame.tblRoomStatus);   

            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
    }
    
    public void deliveryload()
   {
      getRoomNo ();
       
      String bill = "SELECT * FROM delivery_status";
      System.out.println(bill);
        try 
        {
              
            pst = con.prepareStatement(bill);
            rs = pst.executeQuery(); 
            Room_States__Frame.tblDeliveryStatus.setModel(DbUtils.resultSetToTableModel(rs));
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
   }
    
    public void checkstatus ()
    {
        getall();
        System.out.println(this.roomno);
        String cs = "SELECT Status FROM room_status WHERE `Room No` = '" +this.roomno+ "'";
        
        try {
                pst = con.prepareStatement(cs);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String st = rst.getString("Status");
                    Room_States__Frame.txtstatus.setText(st);
                }
                
                 loadTable("room_status", Room_States__Frame.tblRoomStatus);   

            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
    }
    
    public void delivary()
    {
        getType();
        getOrderInvoiceNo();
        
        if("Hotel".equals(this.type))
        {
            String deli = "UPDATE hotel_order"
                + " SET `Date`= '" + getCurrentDateTime() + "',"
                + "`Status`= 'Deliverd'"
                + "WHERE `Order No` = '" + this.orderinvoiceno + "'";
        
            System.out.println(deli);
            try {
                pst = con.prepareStatement(deli);
                pst.execute();
                 loadTable("hotel_order", Hotel_Orders_Frame.tblHotelOrders);   

            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
            
            String sql = "UPDATE delivery_status"
                + " SET `Date`= '" + getCurrentDateTime() + "',"
                + "`Status`= 'Deliverd'"
                + "WHERE `Order/Invoice No` = '" + this.orderinvoiceno + "'";
        
            System.out.println(sql);
            try {
                pst = con.prepareStatement(sql);
                pst.execute();
                 loadTable("delivery_status", Room_States__Frame.tblDeliveryStatus);   

            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            String deli = "UPDATE guest_order"
                + " SET `Date`= '" + getCurrentDateTime() + "',"
                + "`Status`= 'Deliverd'"
                + "WHERE `Invoice No` = '" + this.orderinvoiceno + "'";
        
            System.out.println(deli);
            try {
                pst = con.prepareStatement(deli);
                pst.execute();
                 loadTable("guest_order", Guest_Orders_Frame.tbGuestOrders);   

            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
            
            String sql = "UPDATE delivery_status"
                + " SET `Date`= '" + getCurrentDateTime() + "',"
                + "`Status`= 'Deliverd'"
                + "WHERE `Order/Invoice No` = '" + this.orderinvoiceno + "'";
        
            System.out.println(sql);
            try {
                pst = con.prepareStatement(sql);
                pst.execute();
                 loadTable("delivery_status", Room_States__Frame.tblDeliveryStatus);   

            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void clear()
    {
        Room_States__Frame.txtRoomno.setText("");
        Room_States__Frame.txtstatus.setText("");
    }
    
    public void Modelsearch()
    {
        String filters = Room_States__Frame.cmbsearchby.getSelectedItem().toString();
        String filter = "`"+filters+"`";
        String search= Room_States__Frame.txtSearchBox.getText();
        String tablename = "room_status";
        JTable tblName = Room_States__Frame.tblRoomStatus;
        
        search(filter,search,tablename,tblName);

    }
    
    public void getRoomStatus()
    {
        for(int i = 1;i<16;i++)
        {
            String getroom = "SELECT `Checked in Status` FROM room_reservations WHERE `Room No`="+i+"";
        
        try {
                pst = con.prepareStatement(getroom);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String st = rst.getString("Checked in Status");
                    
                    if("Checked".equals(st))
                    {
                        String sql = "UPDATE room_status"
                        + " SET `Date`= '" + getCurrentDateTime() + "',"
                        + "`Status`= '"+st+"'"
                        + "WHERE `Room NO` = '" + i + "'";

                    System.out.println(sql);
                    try {
                        pst = con.prepareStatement(sql);
                        pst.execute();
                        
                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
                    }
                    }
                    
                    else if ("Check Out".equals(st))
                    {
                     String sql = "UPDATE room_status"
                        + " SET `Date`= '" + getCurrentDateTime() + "',"
                        + "`Status`= 'Inprogress'"
                        + "WHERE `Room NO` = '" + i + "'";

                    System.out.println(sql);
                    try {
                        pst = con.prepareStatement(sql);
                        pst.execute();
                        
                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
                    }
                        
                    }
                }
                

            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
