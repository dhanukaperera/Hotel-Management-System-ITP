/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.transport_and_tour_management;
import app.transport_and_tour_management.Airport_Pickup_Frame;
import static app.transport_and_tour_management.Airport_Pickup_Frame.jDateChooser1;
import app.transport_and_tour_management.Tour_Packages_Frame;
import app.transport_and_tour_management.Transport_Details_Frame;
import app.transport_and_tour_management.Vehicle_Availability_Details_Frame;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.HMS;
import net.proteanit.sql.DbUtils;
import source.DBConnection;
/**
 *
 * @author _AI_
 */
   public class Airport_Pickup_Model extends HMS{
    private String roomno;
    private String Vehicalid;
    private String pickupdate;
    private String returnstatus;
    private float cost;
    
    public Airport_Pickup_Model ()
    {
        con = DBConnection.connect();
        
        this.roomno = "NULL";
        this.Vehicalid = "NULL";
        this.pickupdate ="NULL";
        this.returnstatus=null;
        this.cost =0;
         // = "`Customer ID`,`Date Modified`,`Vehicle ID`,`Pickup Date`,`Waiting Time`,`Cost`";
        //System.out.println(colList);
    
        
    }
     public void finload()
    {
        String fin = "SELECT * FROM vehicle_availability";
        //System.out.println(fin);
        try {
                pst = con.prepareStatement(fin);
                rs = pst.executeQuery();
                Vehicle_Availability_Details_Frame.tblvad1.setModel(DbUtils.resultSetToTableModel(rs));

            } 
        catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
    }
    
    public String getPrimaryKey()
    {
        getCustomerid();
        setCustomerid();
        return this.roomno;
    }
    
     private void getCustomerid() {this.roomno= Airport_Pickup_Frame.txtCustomerid.getText();}
     
     private void getVehicalid() {this.Vehicalid= Airport_Pickup_Frame .cmbVehicalid.getSelectedItem().toString();}
     
     private void getpickupdate() {this.pickupdate= getDateFromPicker(jDateChooser1);}
     
     private void getReturnStatus() {this.returnstatus= Airport_Pickup_Frame.cmbVehicalReturn.getSelectedItem().toString();}
     
     private void getCost() {this.cost = Integer.parseInt(Airport_Pickup_Frame.txtCost.getText());}
     
   
     
     private void getAll()
    {   
        getCustomerid();
        getVehicalid();
        getpickupdate();
        getReturnStatus();
        getCost();
      
    }
       private void setCustomerid() { Airport_Pickup_Frame.txtCustomerid.setText(Airport_Pickup_Frame.tblairportpickup.getValueAt(getSelectedRow(Airport_Pickup_Frame.tblairportpickup), 0).toString());}
       
       //private void setVehicalid() { Airport_Pickup_Frame.cmbVehicalid.setSelectedItem(Airport_Pickup_Frame.tblairportpickup.getValueAt(getSelectedRow(Airport_Pickup_Frame.tblairportpickup), 2).toString());}
       private void setCost() { Airport_Pickup_Frame.txtCost.setText(Airport_Pickup_Frame.tblairportpickup.getValueAt(getSelectedRow(Airport_Pickup_Frame.tblairportpickup), 5).toString());}
       
       //private void setWaitingtime() { Airport_Pickup_Frame.txtWaitingtime.setText(Airport_Pickup_Frame.tblairportpickup.getValueAt(getSelectedRow(Airport_Pickup_Frame.tblairportpickup), 4).toString());}
       //private void setPickupDate() { Airport_Pickup_Frame.txtPickupdate.setText(Airport_Pickup_Frame.tblairportpickup.getValueAt(getSelectedRow(Airport_Pickup_Frame.tblairportpickup), 4).toString());}
        
       public void setAll()
     {
         setCustomerid();
         setCost();
         //setPickupDate();         
     }
   
    @Override
   public void add(String tableName) {
       
       getCustomerid();
       
        int rm=Integer.parseInt(this.roomno);
        
        if(rm<16)
        {
            getAll ();
            String availa=null;
        
            String check = "SELECT `Availability` FROM vehicle_availability WHERE `Vehicle ID`='"+this.Vehicalid+"'";
        
         try {
                pst = con.prepareStatement(check);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    availa = rst.getString("Availability");
                }  

            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
         if("Available".equals(availa))
         {
            String sql = "INSERT INTO "+tableName+""
                + "(`Room No`,`Date`,`Vehicle ID`,`Pickup Date`,`Cost`)"
                + " VALUES("
                + "'"+this.roomno+"',"
                + "'"+getCurrentDateTime()+"',"
                + "'"+this.Vehicalid+"',"
                + "'"+this.pickupdate+"',"
                + " "+this.cost+" "
                + ")";
            System.out.println(sql);
        
        try 
        {
            pst = con.prepareStatement(sql);
            pst.execute();
            loadTable("airport_pickup", Airport_Pickup_Frame.tblairportpickup);   
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
            String fin = "INSERT INTO transport_details"
                + "(`Date Modified`,`Room No`,`Type`,`Vehicle Type`,`Amount`)"
                + " VALUES("
                + "'"+getCurrentDateTime()+"',"
                + "'"+this.roomno+"',"
                + "'Airport Pickup',"
                 + "'"+this.Vehicalid+"',"
                + " "+this.cost+" "
                + ")";
            System.out.println(sql);
        
        try 
        {
            pst = con.prepareStatement(fin);
            pst.execute();
            loadTable("transport_details", Transport_Details_Frame.tblTrasport_Details_Frame);   
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
            String vad = "UPDATE vehicle_availability"
                + " SET `Date`= '" + getCurrentDateTime() + "',"
                + "`Availability`='Not Availabale'"
                + "WHERE `Vehicle ID` = '" + this.Vehicalid + "'";
        
         //JOptionPane.showMessageDialog(null,sql);
         
        try {
                pst = con.prepareStatement(vad);
                pst.execute();
                 loadTable("vehicle_availability", Airport_Pickup_Frame.tblvad);
                 loadTable("vehicle_availability", Tour_Packages_Frame.tblvad);

            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            } 
         }
         else
         {
             JOptionPane.showMessageDialog(null, "This Vehicle Not Available");
         }
         JOptionPane.showMessageDialog(null,"Record succesfully added");
        }
        else
         {
                 JOptionPane.showMessageDialog(null, "Invalide Room No");
                 }
        
        
   }
 
    @Override
    public void update(String tableName)
    {
           getAll ();
        
        //String sql = "UPDATE "+tableName+ " SET Room_Type = '" + this.roomType + "', Date_Modified= '" + getCurrentDateTime() + "',Bed_Type = '" + this.bedType + "',Current_Stautus ='" +this.currentStatus+ "',Max_Guests='" + this.maxGuest, + "' WHERE DiskId = '" + this.roomNo + "'";
//          String sql = "UPDATE "+tableName+""
//                + " SET `Date`= '" + getCurrentDateTime() + "',"
//                + "`Vehicle ID` = '" + this.Vehicalid + "',"
//                + "`Pickup date`='" + this.pickupdate + "',"
//                + "`Cost`= " + this.cost + " "
//                + "WHERE `Customer ID` = '" + this.Customerid + "'";
//        
//        System.out.println(sql);
//        try {
//                pst = con.prepareStatement(sql);
//                pst.execute();
//                 loadTable("airport_pickup", Airport_Pickup_Frame.tblairportpickup);   
//
//            } catch (Exception e) {
//               
//                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
//            }
        
        String vad = "UPDATE vehicle_availability"
                + " SET `Date`= '" + getCurrentDateTime() + "',"
                + "`Availability`='" + this.returnstatus + "'"
                + "WHERE `Vehicle ID` = '" + this.Vehicalid + "'";
        
         //JOptionPane.showMessageDialog(null,sql);
         
        try {
                pst = con.prepareStatement(vad);
                pst.execute();
                 loadTable("vehicle_availability", Airport_Pickup_Frame.tblvad);
                 loadTable("vehicle_availability", Tour_Packages_Frame.tblvad);

            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
   }
    
    public void getAirCost()
    {
        getVehicalid();
        
        String sql = "SELECT `Airport Pickup Cost` FROM vehicles WHERE `Vehicle ID` = '"+this.Vehicalid+"'";
        
        try {
                pst = con.prepareStatement(sql);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String st = rst.getString("Airport Pickup Cost");
                    Airport_Pickup_Frame.txtCost.setText(st);
                }
                
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
    }
    public void VehicleId()
   {
   try
   {
       String sql = "SELECT `Vehicle ID` FROM vehicles";
       System.out.println(sql);
       pst = con.prepareStatement(sql);
       
       rs = pst.executeQuery();
       Airport_Pickup_Frame.cmbVehicalid.removeAllItems();
   while(rs.next())
   {
   String SuppID = rs.getString("Vehicle ID");
   Airport_Pickup_Frame.cmbVehicalid.addItem(SuppID);
   
   }
   
   }
   catch (Exception e)
   {
   JOptionPane.showMessageDialog(null,e);
   }

            
   
   }
    
//    public void transferincometable(){
//    
//        Incomes_Management_Model incomes = new Incomes_Management_Model();
//        
//        String colname = "Income ID";
//        String tablename = "incomes_management";
//        String primaryval = "INM" ;
//        
//        try
//        {
//          String income = this.roomno+"Airport Pickup" ;
//          String Department = "Transport and Tour Management" ;
//          String sql = "INSERT INTO incomes_management "
//                + "( `Income`,`Date`,`Amount`,`Department`)"
//                + " VALUES("
//                + "'"+generatePrimaryKey(colname, tablename, primaryval)+"',"
//                + "'"+income+"',"
//                + "'"+getCurrentDateTime()+"',"
//                + ""+this.cost+","
//                + "'"+Department+"'"
//                + ")";  
//             
//                pst = con.prepareStatement(sql);
//                pst.execute();
//                
//        
//        
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,e,"null",JOptionPane.ERROR_MESSAGE);
//        }
//        
//        incomes.loadTable(tablename,Incomes_Management_Frame.tbIncomes);
//        
//    
//    
//    }
//  
   }



    

  

   



  
        
      
