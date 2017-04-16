/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.laundry_and_room_service;

import app.laundry_and_room_service.Finance_Frame;
import app.laundry_and_room_service.Hotel_Orders_Frame;
import static app.laundry_and_room_service.Hotel_Orders_Frame.tblSelectItem;
import app.laundry_and_room_service.Room_States__Frame;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.HMS;
import net.proteanit.sql.DbUtils;
import reports.iReportView;
import source.DBConnection;


/**
 *
 * @author User
 */
public class Hotel_Orders_Model extends HMS
{
   private String orderno;
   private String section;
   private String guestid;
   private int qty;
   private String status;
   private float total;
   private String item;
   private float price;
   private String financeid;
    
    public Hotel_Orders_Model ()
    {
        con = DBConnection.connect();
        
        this.orderno = "NULL";
        this.section = "NULL";
        this.guestid = "NULL";
        this.financeid = null;
        this.qty = 0;
        this.status = "No Status";
        this.total = 0;
        this.item = "No Item";
        this.price = 0;
        //colList = "`Order No`,`Date Modified`,`Room No`,`Guest ID`,`Status`,`Item`,`QTY`,`Price`,`Total`";
        System.out.println(colList);
        
    }
    
//    public String getPrimaryKey()
//    {
//    //setGOrderNo();
//    //getGOrderNo();
//    //return this.gorderno;    
//    }
    
    public void pricelist()
   {
      String sql = "SELECT `Item Name` FROM laundry_price_list WHERE `Type` = 'Hotel'";
      System.out.println(sql);
        try 
        {
              
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery(); 
            tblSelectItem.setModel(DbUtils.resultSetToTableModel(rs));
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
   }
    
    public void financeload()
   {
      String finl = "SELECT * FROM finance";
      System.out.println(finl);
        try 
        {
              
            pst = con.prepareStatement(finl);
            rs = pst.executeQuery(); 
            Finance_Frame.tblFinance.setModel(DbUtils.resultSetToTableModel(rs));
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
   }
    
    
   // -------------------------------------------------------------------------
   // -- BEGIN Getting Values -------------------------------------------------
    
   private void getOrderNo () { this.orderno = Hotel_Orders_Frame.txtOrderNo.getText(); }
   
   private void getSection () { this.section = Hotel_Orders_Frame.cmbSection.getSelectedItem().toString(); }
   
   //private void getGuestID () { this.guestid = Hotel_Orders_Frame.txtGuestID.getText(); }
   
   private void getQTY () { this.qty = Integer.parseInt(Hotel_Orders_Frame.txtQty.getText()); }
   
   private void getStatus (){ this.status = Hotel_Orders_Frame.txtStatus.getText();}
   
   //private void getTotal (){ this.total = Float.parseFloat(Hotel_Orders_Frame.txtTotal.getText()); }
   
   private void getItem () { this.item = Hotel_Orders_Frame.txtItemName.getText() ; }
   
   //private void getPrice () { this.price = Float.parseFloat(Hotel_Orders_Frame.txtPrice.getText()); }
   
   private void getAll ()
   {
       getOrderNo ();
       getSection ();
       //getGuestID ();
       getQTY ();
       getStatus ();
       //getTotal ();
       getItem ();
       //getPrice ();
   }
   
   
   
    // -- END Get Values -------------------------------------------------------
    // -------------------------------------------------------------------------
   
   // -------------------------------------------------------------------------
   // -- BEGIN Setting Values -------------------------------------------------
   
   private void setOrderNo () { Hotel_Orders_Frame.txtOrderNo.setText(Hotel_Orders_Frame.tblHotelOrders.getValueAt(getSelectedRow(Hotel_Orders_Frame.tblHotelOrders), 0).toString()); }
   
   private void setSection () { Hotel_Orders_Frame.cmbSection.setSelectedItem(Hotel_Orders_Frame.tblHotelOrders.getValueAt(getSelectedRow(Hotel_Orders_Frame.tblHotelOrders), 2).toString()); }
   
   //private void setGuestID () { Hotel_Orders_Frame.txtGuestID.setText(Hotel_Orders_Frame.tblHotelOrders.getValueAt(getSelectedRow(Hotel_Orders_Frame.tblHotelOrders), 3).toString()); }
   
   private void setStatus () { Hotel_Orders_Frame.txtStatus.setText(Hotel_Orders_Frame.tblHotelOrders.getValueAt(getSelectedRow(Hotel_Orders_Frame.tblHotelOrders), 3).toString()); }
   
   private void setQTY () { Hotel_Orders_Frame.txtQty.setText(Hotel_Orders_Frame.tblHotelOrders.getValueAt(getSelectedRow(Hotel_Orders_Frame.tblHotelOrders), 5).toString()); }
   
   //private void setTotal () { Hotel_Orders_Frame.txtTotal.setText(Hotel_Orders_Frame.tblHotelOrders.getValueAt(getSelectedRow(Hotel_Orders_Frame.tblHotelOrders), 8).toString()); }
   
   private void setItem () { Hotel_Orders_Frame.txtItemName.setText(Hotel_Orders_Frame.tblHotelOrders.getValueAt(getSelectedRow(Hotel_Orders_Frame.tblHotelOrders), 4).toString()); }
   
   //private void setPrice () { Hotel_Orders_Frame.txtPrice.setText(Hotel_Orders_Frame.tblHotelOrders.getValueAt(getSelectedRow(Hotel_Orders_Frame.tblHotelOrders), 7).toString()); }
   
   public void setAll ()
   {
       setOrderNo ();
       setSection ();
       //setGuestID ();
       setStatus ();
       setQTY ();
       //setTotal ();
       setItem ();
       //setPrice ();
   }
   
   private void setItemselect () { Hotel_Orders_Frame.txtItemName.setText(Hotel_Orders_Frame.tblSelectItem.getValueAt(getSelectedRow(Hotel_Orders_Frame.tblSelectItem), 0).toString()); }
   
   //private void setCostselect () { Hotel_Orders_Frame.txtPrice.setText(Hotel_Orders_Frame.tblSelectItem.getValueAt(getSelectedRow(Hotel_Orders_Frame.tblSelectItem), 1).toString()); }
   
   public void setAllselect ()
   {
       setItemselect ();
   }
   
    // -- END Setting Values ---------------------------------------------------
    // -------------------------------------------------------------------------

   
   
    @Override
    public void add(String tableName) {
        Hotel_Orders_Frame.txtStatus.setText("In Progress");
        
        String hotel="SELECT MAX(`Order No`) FROM hotel_order";
            System.out.println(hotel);
            
            try {
                pst = con.prepareStatement(hotel);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String st = rst.getString("MAX(`Order No`)");
                    if(null==st)
                    {
                        Hotel_Orders_Frame.txtOrderNo.setText("HO-00001");
                    }
                    else
                    {
                        String temp = st.substring(3,8);
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
                    
                    String inno = "HO-"+temp;
                    
                    Hotel_Orders_Frame.txtOrderNo.setText(inno);
                    
                    }
                }
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        
        getAll ();
        //this.orderno=generatePrimaryKey("Order No", "hotel_order", "HO");
        
        String sql = "INSERT INTO "+tableName+""
                + "(`Order No`,`Date`,`Section`,`Status`,`Item`,`Qty`)"
                + " VALUES("
                + "'"+this.orderno+"',"
                + "'"+getCurrentDateTime()+"',"
                + "'"+this.section+"',"
                + "'"+this.status+"',"
                + "'"+this.item+"',"
                + ""+this.qty+""
                + ")";  
        
        System.out.println(sql);
        
        try 
        {
            pst = con.prepareStatement(sql);
            pst.execute();
                loadTable("hotel_order", Hotel_Orders_Frame.tblHotelOrders);   
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
        String s="SELECT MAX(`Finance ID`) FROM finance";
            System.out.println(s);
            
            try {
                pst = con.prepareStatement(s);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String st = rst.getString("MAX(`Finance ID`)");
                    if(null==st)
                    {
                        this.financeid="FI-00001";
                    }
                    else
                    {
                        String temp = st.substring(3,8);
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
                    
                    String inno = "FI-"+temp;
                    
                    this.financeid=inno;
                    
                    }
                }
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            } 
        
            this.price=0;
        String fin = "INSERT INTO finance"
                + "(`Finance ID`,`Date`,`Order NO`,`Item Name`,`Type`,`Qty`,`Cost`,Total)"
                + " VALUES("
                + "'"+this.financeid+"',"
                + "'"+getCurrentDateTime()+"',"
                + "'"+this.orderno+"',"
                + "'"+this.item+"',"
                + "'Hotel',"
                + ""+this.qty+","
                + ""+this.price+","
                + "0"
                + ")";  
        
        System.out.println(fin);
        
        try 
        {
            pst = con.prepareStatement(fin);
            pst.execute();
                loadTable("finance", Finance_Frame.tblFinance); 
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
        JOptionPane.showMessageDialog(null, "Record Add Successfully");
        clear();
    }

    @Override
    public void update(String tableName) {
        
//        getQTY();
//        getCost();
//        
//        float tot = this.cost*this.qty;
//        
//        String totf = String.valueOf(tot);
//        Hotel_Orders_Frame.txtTotal.setText(totf);
//        
////        getAll();
//        //String sql = "UPDATE "+tableName+ " SET Room_Type = '" + this.roomType + "', Date_Modified= '" + getCurrentDateTime() + "',Bed_Type = '" + this.bedType + "',Current_Stautus ='" +this.currentStatus+ "',Max_Guests='" + this.maxGuest, + "' WHERE DiskId = '" + this.roomNo + "'";
//        String sql = "UPDATE "+tableName+""
//                
//                + " SET `Date Modified`= '" + getCurrentDateTime() + "',"
//                + "`Room No` = '" + this.roomno + "',"
//                + "`Status`= '" + this.status + "',"
//                + "`Item`= '" + this.item + "',"
//                + "`Qty`= " + this.qty + ","
//                + "`Cost`= " + this.cost + ","
//                + "`Total`= " + this.total + " "
//                + "WHERE `Hotel Order No` = '" + this.invoiceno + "'";
//        
//        System.out.println(sql);
//        try {
//                pst = con.prepareStatement(sql);
//                pst.execute();
//                 loadTable("hotel_order", Hotel_Orders_Frame.tblHotelOrders);   
//
//            } catch (Exception e) {
//               
//                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
//            }
//        
//        String fin = "UPDATE finance"
//                + " SET `Date Modified`= '" + getCurrentDateTime() + "',"
//                + "`Type` = ' Hotel ' ,"
//                + "`Price` = '" +this.total+ "'"
//                + "WHERE `Order No` = '" +this.invoiceno+ "'";
//                
//                try {
//                pst = con.prepareStatement(fin);
//                pst.execute();
//                //loadTable("finance", Finance_Frame.tblFinance);
//
//            } catch (Exception e) {
//               
//                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
//            }
        
      
    }
    
    public void completeOrder (String tableName)
    {   
        getStatus ();
        //JOptionPane.showMessageDialog(null, this.status);
        if ("In Progress".equals(this.status))
        {
            getOrderNo();
            String sql = "UPDATE "+tableName+""
                    + " SET `Date`= '" + getCurrentDateTime() + "',"
                    + "`Status`= 'Complete'"
                    + "WHERE `Order No` = '" + this.orderno + "'";

            System.out.println(sql);
            try {
                    pst = con.prepareStatement(sql);
                    pst.execute();
                     loadTable("hotel_order", Hotel_Orders_Frame.tblHotelOrders); 

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
                }
            
            JOptionPane.showMessageDialog(null, "Marked As Complete");
        }
        else if("Complete".equals(this.status))
        {
            JOptionPane.showMessageDialog(null, "Already Completed This Order");
        }
        
        else if("Deliverd".equals(this.status))
        {
            JOptionPane.showMessageDialog(null, "Already Deliverd This Order");
        }
    }
    
    public void deliverOrder (String tableName)
    {
        getStatus ();
        
        if("Complete".equals(this.status))
        {
            getOrderNo();
        String sql = "UPDATE "+tableName+""
                + " SET `Date`= '" + getCurrentDateTime() + "',"
                + "`Status`= 'Transit'"
                + "WHERE `Order No` = '" + this.orderno + "'";
        
        System.out.println(sql);
        try {
                pst = con.prepareStatement(sql);
                pst.execute();
                 loadTable("hotel_order", Hotel_Orders_Frame.tblHotelOrders); 

            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        JOptionPane.showMessageDialog(null, "Marked As Complete");
        
        String deli = "INSERT INTO delivery_status"
                + "(`Order/Invoice No`,`Date`,`Type`,`Status`)"
                + " VALUES("
                + "'"+this.orderno+"',"
                + "'"+getCurrentDateTime()+"',"
                + "'Hotel',"
                + "'Transit'"
                + ")";  
        
        System.out.println(deli);
        
        try 
        {
            pst = con.prepareStatement(deli);
            pst.execute();
                loadTable("delivery_status", Room_States__Frame.tblDeliveryStatus); 
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, "Marked As Transit");
        }
        else if("Transit".equals(this.status))
        {
            JOptionPane.showMessageDialog(null, "Already Transit This Order");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "This Order Not Completed");
        }
        
        clear();
    }
    
    public void clear()
    {
        
        Hotel_Orders_Frame.txtStatus.setText("");
        Hotel_Orders_Frame.txtQty.setText("");
        Hotel_Orders_Frame.txtItemName.setText("");
        Hotel_Orders_Frame.txtOrderNo.setText("");
//        Hotel_Orders_Frame.txtCost.setText("");
//        Hotel_Orders_Frame.txtTotal.setText("");
        
    }
    
    public void Modelsearch()
    {
        String filters = Hotel_Orders_Frame.cmbsearchby.getSelectedItem().toString();
        String filter = "`"+filters+"`";
        String search= Hotel_Orders_Frame.txtSearchBox.getText();
        String tablename = "hotel_order";
        JTable tblName = Hotel_Orders_Frame.tblHotelOrders;
        
        search(filter,search,tablename,tblName);

    }
    public void loadType()
    {
    
    try
   {
       String sql = "SELECT `Room Type` FROM room_types";
       System.out.println(sql);
       pst = con.prepareStatement(sql);
       
       rs = pst.executeQuery();
       Hotel_Orders_Frame.cmbSection.removeAllItems();
   while(rs.next())
   {
   String SuppID = rs.getString("Room Type");
   Hotel_Orders_Frame.cmbSection.addItem(SuppID);
   
   }
   
   }
   catch (Exception e)
   {
   JOptionPane.showMessageDialog(null,e);
   }
    
    }
    
    public void report(){
    
        iReportView rr = new iReportView("C:\\Users\\User\\Desktop\\pro\\Pavana - Hotel Management System - ITP\\src\\reports\\laundry_and_room_services\\hotelorder.jasper");
        rr.setVisible(true);
    
    
    }

    public void deliveryload() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
