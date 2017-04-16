/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.laundry_and_room_service;

import app.finance_management.Incomes_Management_Frame;
import app.laundry_and_room_service.Finance_Frame;
import app.laundry_and_room_service.Guest_Orders_Frame;
import static app.laundry_and_room_service.Guest_Orders_Frame.tblSelectItem;
import app.laundry_and_room_service.Room_States__Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.HMS;
import model.finance_management.Incomes_Management_Model;
import net.proteanit.sql.DbUtils;
import reports.iReport;
import reports.iReportView;
import source.DBConnection;

/**
 *
 * @author User
 */
public class Guest_Orders_Model extends HMS 
{
    private String billno;
    private String invoiceno;
    private String roomno;
    private String status;
    private int qty;
    private String item;
    private float total;
    private float cost;
    private float subtotal;
    private String financeid;
    
   
   
   public Guest_Orders_Model ()
    {
        con = DBConnection.connect();
        
        
        this.billno = "NULL";
        this.invoiceno = "NULL";
        this.roomno = "NULL";
        this.qty = 0;
        this.status = "No Status";
        this.total = 0;
        this.item = "No Item";
        this.cost = 0;
        //colList = "`Hotel Order No`,`Date Modified`,`Room No`,`Status`,`Item`,`QTY`,`Cost`,`Total`";
        System.out.println(colList);
    }
   
   public void pricelist()
   {
      String sql = "SELECT `Item Name`,`Price` FROM laundry_price_list WHERE `Type` = 'Guest'";
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
   
   public String getPrimaryKey()
    {
    setBillNo();
    getBillNo();
    return this.billno;
    
    }
   
    
    public void billload()
   {
      getRoomNo ();
       
      String bill = "SELECT * FROM "+this.roomno+"";
      System.out.println(bill);
        try 
        {
              
            pst = con.prepareStatement(bill);
            rs = pst.executeQuery(); 
            Guest_Orders_Frame.tblbill.setModel(DbUtils.resultSetToTableModel(rs));
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
   }
   
   // -------------------------------------------------------------------------
   // -- BEGIN Getting Values -------------------------------------------------
   
   private void getInvoiceNo () { this.invoiceno = Guest_Orders_Frame.txtInvoiceNo.getText(); }
   
   private void getBillNo () { this.billno = Guest_Orders_Frame.txtBillNo.getText(); }
   
   private void getRoomNo () { this.roomno = Guest_Orders_Frame.txtRoomNo.getText(); }
   
   private void getQTY () { this.qty = Integer.parseInt(Guest_Orders_Frame.txtQty.getText()); } 
   
   private void getStatus (){ this.status = Guest_Orders_Frame.txtStatus.getText();}
   
   private void getTotal (){ this.total = Float.parseFloat(Guest_Orders_Frame.txtTotal.getText()); }
   
   private void getItem () { this.item = Guest_Orders_Frame.txtItmeName.getText();}
   
   private void getCost () { this.cost  = Float.parseFloat(Guest_Orders_Frame.txtCost.getText()); }
   
   private void getSubTotal () { this.subtotal  = Float.parseFloat(Guest_Orders_Frame.txtSubTotal.getText()); }
   
   private void getItemAdd ()
   {
       getInvoiceNo ();
       getBillNo ();
       getRoomNo ();
       getQTY ();
       getStatus ();
       getTotal ();
       getItem ();
       getCost ();
//       getSubTotal ();
       
      
   }
   
    // -- END SET Values -------------------------------------------------------
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    // -- BEGIN Setting Values -------------------------------------------------
   
   private void setInvoiceNo () { Guest_Orders_Frame.txtInvoiceNo.setText(Guest_Orders_Frame.tbGuestOrders.getValueAt(getSelectedRow(Guest_Orders_Frame.tbGuestOrders), 2).toString()); }
   
   private void setRoomNo () { Guest_Orders_Frame.txtRoomNo.setText(Guest_Orders_Frame.tbGuestOrders.getValueAt(getSelectedRow(Guest_Orders_Frame.tbGuestOrders), 0).toString()); }
   
   private void setStatus () { Guest_Orders_Frame.txtStatus.setText(Guest_Orders_Frame.tbGuestOrders.getValueAt(getSelectedRow(Guest_Orders_Frame.tbGuestOrders), 3).toString()); }
   
   private void setSubTotal () { Guest_Orders_Frame.txtSubTotal.setText(Guest_Orders_Frame.tbGuestOrders.getValueAt(getSelectedRow(Guest_Orders_Frame.tbGuestOrders), 4).toString()); }
   
   
   public void setguestorders ()
   {
       setInvoiceNo ();
       setRoomNo ();
       setStatus ();
       setSubTotal ();
   }
   
   private void setItemselect () { Guest_Orders_Frame.txtItmeName.setText(Guest_Orders_Frame.tblSelectItem.getValueAt(getSelectedRow(Guest_Orders_Frame.tblSelectItem), 0).toString()); }
   
   private void setCostselect () { Guest_Orders_Frame.txtCost.setText(Guest_Orders_Frame.tblSelectItem.getValueAt(getSelectedRow(Guest_Orders_Frame.tblSelectItem), 1).toString()); }
   
   public void setAllselect ()
   {
       setItemselect ();
       setCostselect ();
   }
   
   private void setBillNo () { Guest_Orders_Frame.txtBillNo.setText(Guest_Orders_Frame.tblbill.getValueAt(getSelectedRow(Guest_Orders_Frame.tblbill), 0).toString()); }
   
   private void setBillStatus () { Guest_Orders_Frame.txtStatus.setText(Guest_Orders_Frame.tblbill.getValueAt(getSelectedRow(Guest_Orders_Frame.tblbill), 2).toString()); }
   
   private void setBillItem () { Guest_Orders_Frame.txtItmeName.setText(Guest_Orders_Frame.tblbill.getValueAt(getSelectedRow(Guest_Orders_Frame.tblbill), 3).toString()); }
   
   private void setBillQty () { Guest_Orders_Frame.txtQty.setText(Guest_Orders_Frame.tblbill.getValueAt(getSelectedRow(Guest_Orders_Frame.tblbill), 4).toString()); }
   
   private void setBillCost () { Guest_Orders_Frame.txtCost.setText(Guest_Orders_Frame.tblbill.getValueAt(getSelectedRow(Guest_Orders_Frame.tblbill), 5).toString()); }
   
   private void setBillTotal () { Guest_Orders_Frame.txtTotal.setText(Guest_Orders_Frame.tblbill.getValueAt(getSelectedRow(Guest_Orders_Frame.tblbill), 6).toString()); }
   
   public void setAllBill ()
   {
       setBillNo ();
       setBillStatus ();
       setBillItem ();
       setBillQty ();
       setBillCost ();
       setBillTotal ();
   }
   
   
   
    // -- END Setting Values ---------------------------------------------------
    // -------------------------------------------------------------------------
   
   public void iadd()
   {
       getQTY();
       getCost();
       getRoomNo();
       
       int size= Guest_Orders_Frame.tblbill.getRowCount();
       
       if(size==0)
       {
           String s="SELECT MAX(`Invoice No`) FROM guest_Order";
            System.out.println(s);
            
            try {
                pst = con.prepareStatement(s);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String st = rst.getString("MAX(`Invoice No`)");
                    if("".equals(st))
                    {
                        Guest_Orders_Frame.txtInvoiceNo.setText("IN-00001");
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
                    
                    String inno = "IN-"+temp;
                    
                    Guest_Orders_Frame.txtInvoiceNo.setText(inno);
                    
                    }
                }
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            } 
       }
       
       float tot = this.cost*this.qty;
        
       String totf = String.valueOf(tot);
       Guest_Orders_Frame.txtTotal.setText(totf);

       getItemAdd ();
       
       String sql = "INSERT INTO "+this.roomno+""
                + "(`Date`,`Status`,`Item Name`,`Qty`,`Cost`,`Total`)"
                + " VALUES("
                + "'"+getCurrentDateTime()+"',"
                + "'In Progress',"
                + "'"+this.item+"',"
                + ""+this.qty+","
                + ""+this.cost+","
                + ""+this.total+""
                + ")";  
        
        System.out.println(sql);
        
        try 
        {
            pst = con.prepareStatement(sql);
            pst.execute();
                billload();   
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
        String sum = "SELECT SUM(Total) FROM "+this.roomno+"";
        
        try {
                pst = con.prepareStatement(sum);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String st = rst.getString("SUM(Total)");
                    Guest_Orders_Frame.txtSubTotal.setText(st);
                }
                
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        
        getSubTotal ();
        getInvoiceNo();
        
        String up = "UPDATE guest_order"
                
                + " SET `Date`= '" + getCurrentDateTime() + "',"
                + "`Invoice No`= '" + this.invoiceno + "',"
                + "`Status`= 'Updating..',"
                + "`Sub Total`= " + this.subtotal + " "
                + "WHERE `Room No` = '" + this.roomno + "'";
        
        System.out.println(up);
        try {
                pst = con.prepareStatement(up);
                pst.execute();
                 loadTable("guest_order", Guest_Orders_Frame.tbGuestOrders);   

            } catch (Exception e) {
               
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
        
        String fin = "INSERT INTO finance"
                + "(`Finance ID`,`Date`,`Order NO`,`Item Name`,`Type`,`Qty`,`Cost`,`Total`)"
                + " VALUES("
                + "'"+this.financeid+"',"
                + "'"+getCurrentDateTime()+"',"
                + "'"+this.invoiceno+"',"
                + "'"+this.item+"',"
                + "'Guest',"
                + ""+this.qty+","
                + ""+this.cost+","
                + ""+this.total+""
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
        JOptionPane.showMessageDialog(null, "Item Added successfully");
        clear();
   }
   
   public void order()
   {
        getRoomNo();
        
        String up = "UPDATE guest_order"
                
                + " SET `Date`= '" + getCurrentDateTime() + "',"
                + "`Status`= 'In Progress'"
                + "WHERE `Room No` = '" + this.roomno + "'";
        
        System.out.println(up);
        try {
                pst = con.prepareStatement(up);
                pst.execute();
                 loadTable("guest_order", Guest_Orders_Frame.tbGuestOrders);   

            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        JOptionPane.showMessageDialog(null, "Order Added successfully");
        clear();
   }
   
   public void up ()
   {
        getQTY();
        getCost();
        getRoomNo();
        getStatus();
        getBillNo();
        getItem();
        
        
        float tot = this.cost*this.qty;
        
        String totf = String.valueOf(tot);
        Guest_Orders_Frame.txtTotal.setText(totf);
        
        getTotal();
        
        //String sql = "UPDATE "+tableName+ " SET Room_Type = '" + this.roomType + "', Date_Modified= '" + getCurrentDateTime() + "',Bed_Type = '" + this.bedType + "',Current_Stautus ='" +this.currentStatus+ "',Max_Guests='" + this.maxGuest, + "' WHERE DiskId = '" + this.roomNo + "'";
        String sql = "UPDATE "+this.roomno+""
                
                + " SET `Date`= '" + getCurrentDateTime() + "',"
                + "`Status`= 'In Progress [Updated]',"
                + "`Item Name`= '" + this.item + "',"
                + "`Qty`= " + this.qty + ","
                + "`Cost`= " + this.cost + ","
                + "`Total`= " + this.total + ""
                + "WHERE `Item No` = '" + this.billno + "'";
        
        System.out.println(sql);
        try {
                pst = con.prepareStatement(sql);
                pst.execute();
                 billload();   

            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        
        String sum = "SELECT SUM(Total) FROM "+this.roomno+"";
        
        try {
                pst = con.prepareStatement(sum);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String st = rst.getString("SUM(Total)");
                    Guest_Orders_Frame.txtSubTotal.setText(st);
                }
                
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        
        getSubTotal ();
        
        String up = "UPDATE guest_order"
                
                + " SET `Date`= '" + getCurrentDateTime() + "',"
                + "`Status`= 'In Progress [Updated]',"
                + "`Sub Total`= " + this.subtotal + " "
                + "WHERE `Room No` = '" + this.roomno + "'";
        
        System.out.println(up);
        try {
                pst = con.prepareStatement(up);
                pst.execute();
                 loadTable("guest_order", Guest_Orders_Frame.tbGuestOrders);   

            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
   }
   
   public void del ()
   {
       getRoomNo ();
       
       delete(this.roomno, "Item No", getPrimaryKey(), Guest_Orders_Frame.tblbill);
       
       String sum = "SELECT SUM(Total) FROM "+this.roomno+"";
        
        try {
                pst = con.prepareStatement(sum);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String st = rst.getString("SUM(Total)");
                    Guest_Orders_Frame.txtSubTotal.setText(st);
                }
                
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        
        getSubTotal ();
        
        String up = "UPDATE guest_order"
                
                + " SET `Date`= '" + getCurrentDateTime() + "',"
                + "`Status`= 'In Progress [Updated]',"
                + "`Sub Total`= " + this.subtotal + " "
                + "WHERE `Room No` = '" + this.roomno + "'";
        
        System.out.println(up);
        try {
                pst = con.prepareStatement(up);
                pst.execute();
                 loadTable("guest_order", Guest_Orders_Frame.tbGuestOrders);   

            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
   }
    @Override
    public void add(String tableName) 
    {   
        
    }

    @Override
    public void update(String tableName) {
        

    }
    
    public void completeOrder ()
    {
        //Mark as completed
        Guest_Orders_Frame.txtStatus.setText("Complete");
        getBillNo ();
        
        String sql = "UPDATE "+this.roomno+""
                + " SET `Date`= '" + getCurrentDateTime() + "',"
                + "`Status`= 'Complete'"
                + "WHERE `Item No` = '" + this.billno + "'";
        
        System.out.println(sql);
        try {
                pst = con.prepareStatement(sql);
                pst.execute();
                 loadTable(this.roomno, Guest_Orders_Frame.tblbill); 

            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        ///////////////////////////////////////////////
        
        //Check all items complete
        getRoomNo();
        int size = Guest_Orders_Frame.tblbill.getRowCount();
        String ncom="";
        int com=0;
        
        for(int i=1;i<=size;i++)
        {
            String s="SELECT Status FROM "+this.roomno+" WHERE `Item No`="+i+"";
            System.out.println(s);
            
            try {
                pst = con.prepareStatement(s);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String st = rst.getString("Status");
                    if("Complete".equals(st))
                    {
                        com++;
                    }
                }
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        ////////////////////////////////////
        
        //if all items complete order marked complete
        if(size==com)
        {
            String de = "UPDATE guest_order"
                + " SET `Date`= '" + getCurrentDateTime() + "',"
                + "`Status`= 'Complete'"
                + "WHERE `Room No` = '" + this.roomno + "'";
        
        System.out.println(sql);
        try {
                pst = con.prepareStatement(de);
                pst.execute();
                 loadTable("guest_order", Guest_Orders_Frame.tbGuestOrders);   

            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        ////////////////////////////////////////////
    }
    
    public void deliverOrder (String tableName)
    {
        getStatus();
        getRoomNo();
        getInvoiceNo();
        getSubTotal();
        
        int size = Guest_Orders_Frame.tblbill.getRowCount();
        
        if("In Progress".equals(this.status))
        {
            getRoomNo();
        
        String ncom="";
        
        for(int i=1;i<=size;i++)
        {
            String s="SELECT Status FROM "+this.roomno+" WHERE `Item No`="+i+"";
            System.out.println(s);
            
            try {
                pst = con.prepareStatement(s);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String st = rst.getString("Status");
                    if("In Progress".equals(st))
                    {
                        String forstring = String.valueOf(i);
                        ncom=ncom+forstring+" ";
                        //JOptionPane.showMessageDialog(null, st);
                    }
                }
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        
        JOptionPane.showMessageDialog(null, "These Items not Completed '"+ncom+"'");
        }
        else if("Complete".equals(this.status))
        {
            String sql = "UPDATE "+tableName+""
                + " SET `Date`= '" + getCurrentDateTime() + "',"
                + "`Status`= 'Transit'"
                + "WHERE `Room No` = '" + this.roomno + "'";
        
        System.out.println(sql);
        try {
                pst = con.prepareStatement(sql);
                pst.execute();
                 loadTable("guest_order", Guest_Orders_Frame.tbGuestOrders);   

            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        
        String del = "TRUNCATE TABLE `"+this.roomno+"`";
        System.out.println(del);
        try 
        {
             pst = con.prepareStatement(del);
             pst.execute();
             loadTable(this.roomno, Guest_Orders_Frame.tblbill);
        } 
        catch (Exception e) 
        {
             JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
        String deli = "INSERT INTO delivery_status"
                + "(`Order/Invoice No`,`Date`,`Type`,`Status`)"
                + " VALUES("
                + "'"+this.invoiceno+"',"
                + "'"+getCurrentDateTime()+"',"
                + "'Guest',"
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
        
        }
        
//        String fin = "INSERT INTO incomes_management "
//                + "( `Income`,`Date`,`Amount`,`Department`)"
//                + " VALUES("
//                + "'"+this.invoiceno+"',"
//                + "'"+getCurrentDateTime()+"',"
//                + ""+this.subtotal+","
//                + "'Laundry and Room Service'"
//                + ")";  
//        
//        try 
//        {
//            pst = con.prepareStatement(fin);
//            pst.execute();  
//            //loadTable("finance", Finance_Frame.tblFinance);
//        }
//        catch (Exception e) 
//        {
//            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
//        }
    }
    
    public void clear()
    {
        Guest_Orders_Frame.txtInvoiceNo.setText("");
        Guest_Orders_Frame.txtBillNo.setText("");
        Guest_Orders_Frame.txtRoomNo.setText("");
        Guest_Orders_Frame.txtQty.setText("");
        Guest_Orders_Frame.txtStatus.setText("");
        Guest_Orders_Frame.txtItmeName.setText("");
        Guest_Orders_Frame.txtCost.setText("");
        Guest_Orders_Frame.txtTotal.setText("");
        Guest_Orders_Frame.txtSubTotal.setText("");
        
    }
    
    public void Modelsearch()
    {
        String filters = Guest_Orders_Frame.cmbSearchBy.getSelectedItem().toString();
        String filter = "`"+filters+"`";
        String search=Guest_Orders_Frame.txtSearchBox.getText();
        String tablename = "guest_order";
        JTable tblName = Guest_Orders_Frame.tbGuestOrders;
        
        search(filter,search,tablename,tblName);

    }
    
    
    public void report(){
    
        iReportView re = new iReportView("C:\\Users\\User\\Desktop\\pro\\Pavana - Hotel Management System - ITP\\src\\reports\\laundry_and_room_services\\guestorder.jasper");
        re.setVisible(true);
    
    }
    
    
    public void transferincometable(){
    
        Incomes_Management_Model incomes = new Incomes_Management_Model();
        
        String colname = "Income ID";
        String tablename = "incomes_management";
        String primaryval = "INM" ;
        
        try
        {
          String income = this.invoiceno+" Guest Orders" ;
          String Department = "Laundry and Room Service" ;
          String sql = "INSERT INTO incomes_management "
                + "(`Income ID`, `Income`,`Date Modified`,`Amount`,`Department`)"
                + " VALUES("
                + "'"+generatePrimaryKey(colname, tablename, primaryval)+"',"
                + "'"+income+"',"
                + "'"+getCurrentDateTime()+"',"
                + ""+this.subtotal+","
                + "'"+Department+"'"
                + ")";  
             
                pst = con.prepareStatement(sql);
                pst.execute();
                
        
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e,"null",JOptionPane.ERROR_MESSAGE);
        }
        
        incomes.loadTable(tablename,Incomes_Management_Frame.tblIncomes);
        
    
    
    }
}
