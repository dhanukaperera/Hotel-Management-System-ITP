/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.transport_and_tour_management;

import app.transport_and_tour_management.Airport_Pickup_Frame;
import app.transport_and_tour_management.Tour_Packages_Frame;
import static app.transport_and_tour_management.Tour_Packages_Frame.jDateChooser1;
import static app.transport_and_tour_management.Tour_Packages_Frame.jDateChooser2;
import app.transport_and_tour_management.Transport_Details_Frame;
import app.transport_and_tour_management.Vehicle_Availability_Details_Frame;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.HMS;
import net.proteanit.sql.DbUtils;
import source.DBConnection;
/**
 *
 * @author User
 */
public class Tour_Packages_Model extends HMS {
    
    private String roomno;
    private String vehicalid;
    private String selecttour;
    private String departuredate;
    private String arrivedate;
    private String returnstatus;
    private float cost;
    
    
    public Tour_Packages_Model ()
    {
        con = DBConnection.connect();
        
        this.roomno = "NULL";
        this.vehicalid = "NULL";
        this.selecttour = "NULL";
        this.departuredate = "NULL";
        this.arrivedate = "NULL";
        this.returnstatus=null;
        this.cost = 0 ;
        
        //colList = "`Customer ID`,`Date Modified`,`Vehicle ID`,`Select Tour`,`Departure Date`,`Arrive Date`,`Cost`";
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
        
    // -------------------------------------------------------------------------
    // -- BEGIN Getting Values -------------------------------------------------
    
    private void getCustomerID () { this.roomno = Tour_Packages_Frame.txtCustomerid.getText(); } 
    
    private void getVehicalID () { this.vehicalid = Tour_Packages_Frame.cmbVehicleid.getSelectedItem().toString(); }
    
    private void getSelectTour () { this.selecttour = Tour_Packages_Frame.cmbselecttour.getSelectedItem().toString(); }
    
    private void getDepartureTime () { this.departuredate = getDateFromPicker(jDateChooser2); } 
    
    private void getArriveTime () { this.arrivedate = getDateFromPicker(jDateChooser1); }
    
    private void getCost () { this.cost = Float.parseFloat(Tour_Packages_Frame.txtcost.getText()); } 
    
    private void getStatus(){ this.returnstatus = Tour_Packages_Frame.cmbAvailability.getSelectedItem().toString(); }
    
    private void getall ()
    {
        getCustomerID ();
        getVehicalID ();
        getSelectTour ();
        getDepartureTime ();
        getArriveTime ();
        getCost ();  
        getStatus();
    }
    
    // -- END SET Values -------------------------------------------------------
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    // -- BEGIN Setting Values -------------------------------------------------
   
   private void setCustomerID () { Tour_Packages_Frame.txtCustomerid.setText(Tour_Packages_Frame.tblTourpackages.getValueAt(getSelectedRow(Tour_Packages_Frame.tblTourpackages), 0).toString()); }
   
   private void setVehicalID () { Tour_Packages_Frame.cmbVehicleid.setSelectedItem(Tour_Packages_Frame.tblTourpackages.getValueAt(getSelectedRow(Tour_Packages_Frame.tblTourpackages), 2).toString()); }
   
   private void setSelectTour () { Tour_Packages_Frame.cmbselecttour.setSelectedItem(Tour_Packages_Frame.tblTourpackages.getValueAt(getSelectedRow(Tour_Packages_Frame.tblTourpackages), 3).toString()); }
   
   //private void setDepartureTime () { Tour_Packages_Frame.txtdeparturetime.setText(Tour_Packages_Frame.tblTourpackages.getValueAt(getSelectedRow(Tour_Packages_Frame.tblTourpackages), 4).toString()); }
   
   //private void setArriveTime () { Tour_Packages_Frame.txtArrivetime.setText(Tour_Packages_Frame.tblTourpackages.getValueAt(getSelectedRow(Tour_Packages_Frame.tblTourpackages), 5).toString()); }
   
   private void setCost () { Tour_Packages_Frame.txtcost.setText(Tour_Packages_Frame.tblTourpackages.getValueAt(getSelectedRow(Tour_Packages_Frame.tblTourpackages), 6).toString()); }
         
    public void setAll ()
    {
        setCustomerID ();
        setVehicalID ();
        setSelectTour ();
        //setDepartureTime ();
        //setArriveTime ();
        setCost ();
    }
        public String getPrimaryKey()
    {
        getCustomerID ();
        setCustomerID();
        return this.roomno;
    }
    
    // -- END Setting Values ---------------------------------------------------
    // -------------------------------------------------------------------------

    @Override
    public void add(String tableName) {
        getCustomerID();
       
        int rm=Integer.parseInt(this.roomno);
        
        if(rm<16)
        {
        getall ();
        String availa=null;
        
        String check = "SELECT `Availability` FROM vehicle_availability WHERE `Vehicle ID`='"+this.vehicalid+"'";
        
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
                + "(`Room No`,`Date`,`Vehicle ID`,`Select Tour`,`Departure Date`,`Arrive Date`,`Cost`)"
                + " VALUES("
                + "'"+this.roomno+"',"
                + "'"+getCurrentDateTime()+"',"
                + "'"+this.vehicalid+"',"
                + "'"+this.selecttour+"',"
                + "'"+this.departuredate+"',"
                + "'"+this.arrivedate+"',"
                + " "+this.cost+" "
                + ")";
        System.out.println(sql);
        
        try 
        {
            pst = con.prepareStatement(sql);
            pst.execute();
            loadTable("tour_package", Tour_Packages_Frame.tblTourpackages);   
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        //JOptionPane.showMessageDialog(null, "hsdfh");
        String fin = "INSERT INTO transport_details"
                + "(`Date Modified`,`Room No`,`Type`,`Vehicle Type`,`Amount`)"
                + " VALUES("
                + "'"+getCurrentDateTime()+"',"
                + "'"+this.roomno+"',"
                + "'Tour Packages',"
                 + "'"+this.vehicalid+"',"
                + " "+this.cost+" "
                + ")";
        
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
                + "WHERE `Vehicle ID` = '" + this.vehicalid + "'";
        
         //JOptionPane.showMessageDialog(null,sql);
         
        try {
                pst = con.prepareStatement(vad);
                pst.execute();
                 loadTable("vehicle_availability", Tour_Packages_Frame.tblvad); 
                 loadTable("vehicle_availability", Airport_Pickup_Frame.tblvad);

            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            } 
         }
         else
         {
             JOptionPane.showMessageDialog(null, "This Vehicle Not Available");
         }
        }
        else
         {
                 JOptionPane.showMessageDialog(null, "Invalide Room No");
                 }
        
        
    }

    @Override
    public void update(String tableName) {
        getall();
        
       // String sql = "UPDATE "+tableName+ " SET Room_Type = '" + this.roomType + "', Date_Modified= '" + getCurrentDateTime() + "',Bed_Type = '" + this.bedType + "',Current_Stautus ='" +this.currentStatus+ "',Max_Guests='" + this.maxGuest, + "' WHERE DiskId = '" + this.roomNo + "'";
//        String sql = "UPDATE "+tableName+""
//                + " SET `Date`= '" + getCurrentDateTime() + "',"
//                + "`Vehicle ID` = '" + this.vehicalid + "',"
//                + "`Select Tour`='" + this.selecttour + "',"
//                + "`Departure Date`='" + this.departuredate + "',"
//                + "`Arrive Date`='" + this.arrivedate + "',"
//                + "`Cost`= " + this.cost + " "
//                + "WHERE `Customer ID` = '" + this.roomno + "'";
//        
//         //JOptionPane.showMessageDialog(null,sql);
//         
//        try {
//                pst = con.prepareStatement(sql);
//                pst.execute();
//                 loadTable("tour_package", Tour_Packages_Frame.tblTourpackages);   
//
//            } catch (Exception e) {
//               
//                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
//            }
        
        String vad = "UPDATE vehicle_availability"
                + " SET `Date`= '" + getCurrentDateTime() + "',"
                + "`Availability`='" + this.returnstatus + "'"
                + "WHERE `Vehicle ID` = '" + this.vehicalid + "'";
        
         //JOptionPane.showMessageDialog(null,sql);
         
        try {
                pst = con.prepareStatement(vad);
                pst.execute();
                 loadTable("vehicle_availability", Tour_Packages_Frame.tblvad);
                 loadTable("vehicle_availability", Airport_Pickup_Frame.tblvad);

            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
    }

public void getTourCost()
    {
        float vcs=0;
        float tcs=0;
        getSelectTour();
        getVehicalID ();
        
        
        String sql = "SELECT `cost` FROM tour_details WHERE `tourpackage` = '"+this.selecttour+"'";
        
        try {
                pst = con.prepareStatement(sql);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String st = rst.getString("Cost");
                    tcs = Float.parseFloat(st);
                }
                
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        
        String sql2 = "SELECT `Tour Cost` FROM vehicles WHERE `Vehicle ID` = '"+this.vehicalid+"'";
        
        try {
                pst = con.prepareStatement(sql2);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String st = rst.getString("Tour Cost");
                    vcs = Float.parseFloat(st);
                }
                
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        
        this.cost=vcs+tcs;
        String cs=String.valueOf(this.cost);
        
        Tour_Packages_Frame.txtcost.setText(cs);
    }
    public void VehicleId()
   {
   try
   {
       String sql = "SELECT `Vehicle ID` FROM vehicles";
       System.out.println(sql);
       pst = con.prepareStatement(sql);
       
       rs = pst.executeQuery();
       Tour_Packages_Frame.cmbVehicleid.removeAllItems();
   while(rs.next())
   {
   String SuppID = rs.getString("Vehicle ID");
   Tour_Packages_Frame.cmbVehicleid.addItem(SuppID);
   
   }
   
   }
   catch (Exception e)
   {
   JOptionPane.showMessageDialog(null,e);
   }

   
}
    
public void loadTour()
   {
   try
   {
       String sql = "SELECT `tourpackage` FROM tour_details";
       System.out.println(sql);
       pst = con.prepareStatement(sql);
       
       rs = pst.executeQuery();
       Tour_Packages_Frame.cmbselecttour.removeAllItems();
   while(rs.next())
   {
   String tour = rs.getString("tourpackage");
   Tour_Packages_Frame.cmbselecttour.addItem(tour);
   
   }
   
   }
   catch (Exception e)
   {
   JOptionPane.showMessageDialog(null,e);
   }
   }
    
//   public void transferincometable(){
//    
//        Incomes_Management_Model incomes = new Incomes_Management_Model();
//        
//        String colname = "Income ID";
//        String tablename = "incomes_management";
//        String primaryval = "INM" ;
//        
//        try
//        {
//          String income = this.roomno+" Tour Package" ;
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
  
}