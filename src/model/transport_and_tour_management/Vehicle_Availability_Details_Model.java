/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.transport_and_tour_management;

import app.transport_and_tour_management.Vehicle_Availability_Details_Frame;
import javax.swing.JOptionPane;
import model.HMS;
import source.DBConnection;

/**
 *
 * @author _AI_
 */
public class Vehicle_Availability_Details_Model extends HMS{
    
  
    private String tourid;
    private String detail;
    private int noofdate;
    private float cost;
    
    public Vehicle_Availability_Details_Model()
    {
    con = DBConnection.connect();
    
    this.tourid=null;
    this.detail=null;
    this.noofdate=0;
    this.cost=0;
    }
    private void getTourID() { this.tourid= Vehicle_Availability_Details_Frame.txtTourpackageID.getText();}
    
    private void getDetail() { this.detail=Vehicle_Availability_Details_Frame.txtDetails.getText();}
    
    private void getNoofDate() { this.noofdate=Integer.parseInt(Vehicle_Availability_Details_Frame.txtNoofDays.getText()); }
    
    private void getCost(){ this.cost=Float.parseFloat(Vehicle_Availability_Details_Frame.txtCost.getText()); }

    public void getAll()
    {
        getTourID();
        getDetail();
        getNoofDate();
        getCost();
   }
    
    

    @Override
    public void update(String tableName) {
        
    }

    @Override
    public void add(String tableName) {
        getAll();
        
        String sql = "INSERT INTO "+tableName+""
                + "( `tourpackage`,`Date`,`details`,`noofdays`,`cost`)"
                + " VALUES("
                + "'"+this.tourid+"',"
                + "'"+getCurrentDateTime()+"',"
                + "'"+this.detail+"',"
                + "'"+this.noofdate+"',"
                + ""+this.cost+""
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
            
            loadTable("tour_details",Vehicle_Availability_Details_Frame.tblvad1);
    }
    
}
