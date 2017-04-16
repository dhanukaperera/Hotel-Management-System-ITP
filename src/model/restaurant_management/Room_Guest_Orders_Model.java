/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.restaurant_management;
import app.restaurant_management.Room_Guest_Orders_Frames;
import static app.restaurant_management.Room_Guest_Orders_Frames.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.HMS;
import source.DBConnection;

/**
 *
 * @author Sachin
 */
public class Room_Guest_Orders_Model extends HMS {
    
    private String RoomNo;
    private String GuestID;
    private String Type;
    private String Name;
    private int qty;
    private float price;
    private String FOBID;
    private float rateofFOD;
    
     public Room_Guest_Orders_Model ()
    {
    
    con = DBConnection.connect();
        
    this.RoomNo = null;
    this.GuestID = null;
    this.Type = null;
    this.Name = null;
    this.qty = 0;
    this.price = 0;
    this.rateofFOD = 0;
    
    }

//parsing the primary key to the delete method///////////////////////////////////////////////////////////////////////////////////
      public String getPrimaryKey()
    {
        String number = Room_Guest_Orders_Frames.tblRoomGuestOrders.getValueAt(getSelectedRow(Room_Guest_Orders_Frames.tblRoomGuestOrders), 0).toString();

        return number;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
//getters//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
    private void getRoomNo() {this.RoomNo = Room_Guest_Orders_Frames.cmbRoomNo.getSelectedItem().toString();}
    
    private void getGuestID() {this.GuestID = Room_Guest_Orders_Frames.txtGuestID.getText();}
    
    private void getType() {this.Type = Room_Guest_Orders_Frames.cmbType.getSelectedItem().toString();}

    private void getName() {this.Name = Room_Guest_Orders_Frames.cmbName.getSelectedItem().toString();}
    
    private void getqty() {this.qty = Integer.parseInt(Room_Guest_Orders_Frames.txtQty.getText());}
    
    private void getprice() {this.price = Float.parseFloat(Room_Guest_Orders_Frames.txtPrice.getText()) ;}

     private void getAll()
    {
     getRoomNo();
     getGuestID();
     getType();
     getName();
     getqty();
     getprice();
     
    }
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Setters//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
   
   private void setGuestID() { Room_Guest_Orders_Frames.txtGuestID.setText(Room_Guest_Orders_Frames.tblRoomGuestOrders.getValueAt(getSelectedRow(Room_Guest_Orders_Frames.tblRoomGuestOrders), 2).toString());}

   private void setRoomNo() { Room_Guest_Orders_Frames.cmbRoomNo.setSelectedItem(Room_Guest_Orders_Frames.tblRoomGuestOrders.getValueAt(getSelectedRow(Room_Guest_Orders_Frames.tblRoomGuestOrders), 3).toString());}

   private void setType() { Room_Guest_Orders_Frames.cmbType.setSelectedItem(Room_Guest_Orders_Frames.tblRoomGuestOrders.getValueAt(getSelectedRow(Room_Guest_Orders_Frames.tblRoomGuestOrders), 5).toString());}

   private void setName() { Room_Guest_Orders_Frames.cmbName.setSelectedItem(Room_Guest_Orders_Frames.tblRoomGuestOrders.getValueAt(getSelectedRow(Room_Guest_Orders_Frames.tblRoomGuestOrders), 6).toString());}
   
   private void setqty() { Room_Guest_Orders_Frames.txtQty.setText(Room_Guest_Orders_Frames.tblRoomGuestOrders.getValueAt(getSelectedRow(Room_Guest_Orders_Frames.tblRoomGuestOrders), 7).toString());}

   private void setprice() { Room_Guest_Orders_Frames.txtPrice.setText(Room_Guest_Orders_Frames.tblRoomGuestOrders.getValueAt(getSelectedRow(Room_Guest_Orders_Frames.tblRoomGuestOrders), 9).toString());}

    public void setAll()
     {
         setGuestID();
         setRoomNo();
         setType();
         setName();
         setqty();
         setprice();
     }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
//Loading Available Room No////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void LoadRoomNo()
    {
        String room="";
        try 
        {
            String sql = "SELECT `Room No` FROM `room_reservations` WHERE `Checked in Status`='Checked'";
            
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            Room_Guest_Orders_Frames.cmbRoomNo.removeAllItems(); 
            
            while(rs.next())
            {
                int roomno =  rs.getInt("Room No");
                 room = Integer.toString(roomno);
                Room_Guest_Orders_Frames.cmbRoomNo.addItem(room); 
            }
                   
        } 
        catch (Exception e) 
        {
             JOptionPane.showMessageDialog(null,e);
        }
        if(room.equals(null) || room.equals(""))
        { 
        String t="No Rooms";
        Room_Guest_Orders_Frames.cmbRoomNo.addItem(t);
        }
        
    }
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
//Load GuestID when RoomNo is selected//////////////////////////////////////////////////////////////////////////////////////////
    
     public void LoadGuestID()
    {
        getRoomNo();
        
        try {
            
            String sql = "SELECT `NIC/Passport` FROM `room_reservations` where `Room No`="+this.RoomNo+"";
            
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            
            
            Room_Guest_Orders_Frames.txtGuestID.setText("");
            
            if(rs.next())
            {
                String name =  rs.getString("NIC/Passport");
                Room_Guest_Orders_Frames.txtGuestID.setText(name);
            }
                   
        } catch (Exception e) 
        {
             JOptionPane.showMessageDialog(null,e);
        }
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
//Load Names when Type is selected//////////////////////////////////////////////////////////////////////////////////////////////
    
    public void LoadName()
    {
        getType();
        
         try {
            
            String sql = "SELECT `Name` FROM `food_drink_info` WHERE Type='"+this.Type+"' AND `Available`='YES'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
           
            Room_Guest_Orders_Frames.cmbName.removeAllItems(); 
           
            while(rs.next())
            {
                String name =  rs.getString("Name"); 
                Room_Guest_Orders_Frames.cmbName.addItem(name);
            }           
        } 
         
         catch (Exception e) 
        {
             JOptionPane.showMessageDialog(null,e);
        }
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
//Load Price when Food name is selected///////////////////////////////////////////////////////////////////////////////////////
    
     public void LoadPrice()
    {
        getType();
        getName();
        getqty();
        
         try {
            
            String sql = "SELECT `Price` FROM `food_drink_info` WHERE Type='"+this.Type+"' AND Name='"+this.Name+"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
           
            Room_Guest_Orders_Frames.txtPrice.setText("");
           
            if(rs.next())
            {
                Float price =  rs.getFloat("Price"); 
                this.price = this.qty * price;
                
                float TotalPrice = this.price;
                String FinalPrice  = String.valueOf(TotalPrice);
                
                Room_Guest_Orders_Frames.txtPrice.setText(FinalPrice);
            }           
        } 
         
         catch (Exception e) 
        {
             JOptionPane.showMessageDialog(null,e);
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Load the rate of a Food or Drink///////////////////////////////////////////////////////////////////////////////////////////

     public void loadrate()
     {
         getType();
         getName();
         
          try {
            
            String sql = "SELECT `Price` FROM `food_drink_info` WHERE Type='"+this.Type+"' AND Name='"+this.Name+"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if(rs.next())
            {
                this.rateofFOD =  rs.getFloat("Price"); 
            }           
        } 
         
         catch (Exception e) 
        {
             JOptionPane.showMessageDialog(null,e);
        }
     }
     
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
     
     
//Add data to the datbase table//////////////////////////////////////////////////////////////////////////////////////////////// 
    @Override
    public void add(String tableName) {
             
        getAll();
        loadrate();
        
         try 
        {
            String find = "Select `FOB ID` from `food_drink_info` where Type='"+this.Type+"' and Name='"+this.Name+"'";
            
            pst = con.prepareStatement(find);
            rs = pst.executeQuery();
           
            if(rs.next())
            {
                   this.FOBID = rs.getString("FOB ID");
            }
            
        }
         
         catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }
                
        String sql = "INSERT INTO "+tableName+""
                + "(`Date Modified`,`Guest ID`, `Room No`, `FOB ID`, `Type`, `Name`, `Qty`,`Rate`,`Price`)"
                + " VALUES("
                + "'"+getCurrentDateTime()+"',"
                + "'"+this.GuestID+"',"
                + "'"+this.RoomNo+"',"
                + "'"+this.FOBID+"',"
                + "'"+this.Type+"',"
                + "'"+this.Name+"',"
                + ""+this.qty+","
                + ""+this.rateofFOD+","
                + ""+this.price+""
                + ")";
               
        try 
        {
            pst = con.prepareStatement(sql);
            pst.execute();
            loadTable(tableName,Room_Guest_Orders_Frames.tblRoomGuestOrders);   
            JOptionPane.showMessageDialog(null,"Added Successfully","Successful Message",JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //update database table/////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void update(String tableName) {
        
        getAll();
        loadrate();
        
        String number = Room_Guest_Orders_Frames.tblRoomGuestOrders.getValueAt(getSelectedRow(Room_Guest_Orders_Frames.tblRoomGuestOrders), 0).toString();
        String FOBID = Room_Guest_Orders_Frames.tblRoomGuestOrders.getValueAt(getSelectedRow(Room_Guest_Orders_Frames.tblRoomGuestOrders), 4).toString();
        
        try 
        {
            String sql = "UPDATE "+tableName+""
                + " SET `Date Modified`= "+"'" + getCurrentDateTime() + "',"
                + "`Guest ID` = '" + this.GuestID + "',"
                + "`Room No`='" + this.RoomNo + "',"
                + "`FOB ID`='" + FOBID + "',"
                + "`Type`='" + this.Type + "',"
                + "`Name`='" + this.Name + "',"
                + "`Qty`=" + this.qty + ","
                + "`Rate`=" + this.rateofFOD + ","
                + "`Price`=" + this.price + ""
                + "WHERE `Number` = '"+number+"'";
            
                pst = con.prepareStatement(sql);
                pst.execute();
                loadTable("room_guest_orders",Room_Guest_Orders_Frames.tblRoomGuestOrders);  
                JOptionPane.showMessageDialog(null,"Updated Successfully","Successful Message",JOptionPane.INFORMATION_MESSAGE);

        } 
        catch (Exception e) 
        {
               
            JOptionPane.showMessageDialog(null,e);
        }
        
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //clear the frame/////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void clear()
    {
        txtGuestID.setText("");
        txtQty.setText("");
        txtPrice.setText("");
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void Modelsearch()
    {
        String filters = cmbSearchBy.getSelectedItem().toString();
        String filter = "`"+filters+"`";
        String search=txtSearch.getText();
        String tablename = "room_guest_orders" ;
        JTable tblName = tblRoomGuestOrders;
        
        search(filter,search,tablename,tblName);

    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //ispositive validation////////////////////////////////////////////////////////////////////////////////////////////
    
//if checking a float//////////////////////////////////////////////////////////////////////////////////////////////
    
    public static boolean isPositiveint(JTextField txtFieldName, String errorMessage)
    {
        
    int number = Integer.parseInt(txtFieldName.getText());
        if(number>=0)
        {
        return true;
        
        }
        else
        {
        
        JOptionPane.showMessageDialog(null,errorMessage,"Insert valid numbers" ,JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    
    
}

