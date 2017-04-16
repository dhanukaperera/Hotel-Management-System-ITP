/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.transport_and_tour_management;

import app.transport_and_tour_management.Airport_Pickup_Frame;
import app.transport_and_tour_management.Tour_Packages_Frame;
import app.transport_and_tour_management.Vehicles_Frames;
import javax.swing.JOptionPane;
import model.HMS;
import source.DBConnection;

/**
 *
 * @author frank
 */
public class Vehicles_Model extends HMS {

    private String vehicaltype;
    private String vehicalid;
    private String vehicalno;
    private String avaid;
    private float aircost;
    private float tourcost;
    
    public  Vehicles_Model()
    {
    con = DBConnection.connect();
    
    this.vehicaltype="NULL";
    this.vehicalid="NULL";
    this.vehicalno="NULL";
    this.avaid=null;
    this.aircost=0;
    this.tourcost=0;
         //colList = "`Vehicle Type`,`Date Modified`,`Vehicle ID`,`Vehical No`";
        //System.out.println(colList);
    }
       // -------------------------------------------------------------------------
    // -- BEGIN Getting Values -------------------------------------------------
    
   public String getPrimaryKey()
    {
        getVechicleID();
        setVehicleID();
        return this.vehicalid;
    }
    
    
    private void getVechicleType(){ this.vehicaltype = Vehicles_Frames.txtVehicletype.getText(); }
    
    private void getVechicleID () { this.vehicalid = Vehicles_Frames.txtVehicleid.getText(); } 
    
    private void getVechicleNo() { this.vehicalno = Vehicles_Frames.txtVehiclenumber.getText(); }
    
    private void getAirCost() { this.aircost = Float.parseFloat(Vehicles_Frames.txtAirCost.getText()); }
    
    private void getTourCost() { this.tourcost = Float.parseFloat(Vehicles_Frames.txtTourCost.getText()); }
     
    public void getAll()
    {
    getVechicleID();
    getVechicleType();
    getVechicleNo();
    getAirCost();
    getTourCost();
    
    }
        // -- END GET Values -------------------------------------------------------
    // -------------------------------------------------------------------------
    
     // -------------------------------------------------------------------------
    // -- BEGIN Setting Values -------------------------------------------------
    
    private void setVehicleID () { Vehicles_Frames.txtVehicleid.setText(Vehicles_Frames.tblvehicleframes.getValueAt(getSelectedRow(Vehicles_Frames.tblvehicleframes), 0).toString()); }
    
    private void setVehicleType () { Vehicles_Frames.txtVehicletype.setText(Vehicles_Frames.tblvehicleframes.getValueAt(getSelectedRow(Vehicles_Frames.tblvehicleframes), 2).toString()); }
    
    private void setVehicleNo () { Vehicles_Frames.txtVehiclenumber.setText(Vehicles_Frames.tblvehicleframes.getValueAt(getSelectedRow(Vehicles_Frames.tblvehicleframes), 3).toString()); }
    
    private void setAirCost () { Vehicles_Frames.txtAirCost.setText(Vehicles_Frames.tblvehicleframes.getValueAt(getSelectedRow(Vehicles_Frames.tblvehicleframes), 4).toString()); }
    
    private void setTourCost () { Vehicles_Frames.txtTourCost.setText(Vehicles_Frames.tblvehicleframes.getValueAt(getSelectedRow(Vehicles_Frames.tblvehicleframes), 5).toString()); }
    
    public void setAll()
    {
    setVehicleID();
    setVehicleNo();
    setVehicleType();
    setAirCost();
    setTourCost();
    }
    
    @Override
    public void add(String tableName) {
        getAll();
        
        String sql = "INSERT INTO "+tableName+""
                +"(`Vehicle ID`,`Date`,`Vehicle Type`,`Vehicle No`,`Airport Pickup Cost`,`Tour Cost`)"
                + " VALUES("
                + "'"+this.vehicalid+"',"
                + "'"+getCurrentDateTime()+"'," 
                + "'"+this.vehicaltype+"',"
                + "'"+this.vehicalno+"',"
                + ""+this.aircost+","
                + ""+this.tourcost+""
                + ")";
        System.out.println(sql);
           try 
        {
            pst = con.prepareStatement(sql);
            pst.execute();
            loadTable(tableName,Vehicles_Frames.tblvehicleframes);
            
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
           
           String ava = "INSERT INTO vehicle_availability"
                +"(`Date`,`Vehicle ID`,`Availability`)"
                + " VALUES("
                + "'"+getCurrentDateTime()+"'," 
                + "'"+this.vehicalid+"',"
                + "'Available'"
                + ")";
        System.out.println(ava);
           try 
        {
            pst = con.prepareStatement(ava);
            pst.execute();
            loadTable("vehicle_availability",Airport_Pickup_Frame.tblvad);
            loadTable("vehicle_availability",Tour_Packages_Frame.tblvad);
            
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update(String tableName) {
        getAll();
        
        //String sql = "UPDATE "+tableName+ " SET Room_Type = '" + this.roomType + "', Date_Modified= '" + getCurrentDateTime() + "',Bed_Type = '" + this.bedType + "',Current_Stautus ='" +this.currentStatus+ "',Max_Guests='" + this.maxGuest, + "' WHERE DiskId = '" + this.roomNo + "'";
        String sql = "UPDATE "+tableName+""
                + " SET `Date`= '" + getCurrentDateTime() + "',"
                + "`Vehicle Type` = '" + this.vehicaltype + "',"
                + "`Airport Pickup Cost` = "+ this.aircost +","
                + "`Tour Cost` = "+ this.tourcost +","
                + "`Vehicle No`= '" + this.vehicalno+ "' "
                + "WHERE `Vehicle ID` = '" + this.vehicalid+ "'";
        
        System.out.println(sql);
        try {
                pst = con.prepareStatement(sql);
                pst.execute();
                 loadTable("vehicles",Vehicles_Frames.tblvehicleframes);   

            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
    }


    
}

    

