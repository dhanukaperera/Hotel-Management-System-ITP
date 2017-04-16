/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.transport_and_tour_management;

import app.transport_and_tour_management.Revenue_Report_Frame;
import javax.swing.JOptionPane;
import model.HMS;
import source.DBConnection;
/**
 *
 * @author User
 */
public class Revenue_Report_Model extends HMS{
    
    private String vehicleid;
    private String costtype;
    private float Cost;
    
    public Revenue_Report_Model()
            {
                con = DBConnection.connect();
                
               this.vehicleid=null; 
               this.costtype=null;
               this.Cost=0;
            }

    private void getVehicleID() { this.vehicleid = Revenue_Report_Frame.cmbvehicleID.getSelectedItem().toString(); }
    
    private void getCostType() { this.costtype = Revenue_Report_Frame.cmbCostType.getSelectedItem().toString(); }
    
    private void getCost() { this.Cost = Float.parseFloat(Revenue_Report_Frame.txtCost.getText()); }
    
    public void getAll()
    {
        getVehicleID();
        getCostType();
        getCost();
    }
    
    @Override
    public void add(String tableName) {
        getAll();
        
        String ava = "INSERT INTO "+tableName+""
                +"(`Date`,`Vehicle ID`,`Cost Type`,`Cost`)"
                + " VALUES("
                + "'"+getCurrentDateTime()+"'," 
                + "'"+this.vehicleid+"',"
                + "'"+this.costtype+"',"
                + ""+this.Cost+""
                + ")";
        System.out.println(ava);
           try 
        {
            pst = con.prepareStatement(ava);
            pst.execute();
            loadTable("revenue_report",Revenue_Report_Frame.tblvad);
            
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update(String tableName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void VehicleId()
   {
   try
   {
       String sql = "SELECT `Vehicle ID` FROM vehicles";
       System.out.println(sql);
       pst = con.prepareStatement(sql);
       
       rs = pst.executeQuery();
       Revenue_Report_Frame.cmbvehicleID.removeAllItems();
   while(rs.next())
   {
   String SuppID = rs.getString("Vehicle ID");
   Revenue_Report_Frame.cmbvehicleID.addItem(SuppID);
   
   }
   
   }
   catch (Exception e)
   {
   JOptionPane.showMessageDialog(null,e);
   }

            
   
   }
    
//    public void transferexpensetable(){
//    
//        Incomes_Management_Model incomes = new Incomes_Management_Model();
//        
//        String colname = "EXP Mang ID";
//        String tablename = "expenses_management";
//        String primaryval = "EXM" ;
//        
//        try
//        {
//          String income = this.vehicleid+""+this.costtype ;
//          String Department = "Transport and Tour Management" ;
//          String sql = "INSERT INTO expenses_management "
//                + "( `EXP Mang ID`,`Date`,`Amount`,`Department`)"
//                + " VALUES("
//                + "'"+generatePrimaryKey(colname, tablename, primaryval)+"',"
//                + "'"+income+"',"
//                + "'"+getCurrentDateTime()+"',"
//                + ""+this.Cost+","
//                + "'"+Department+"'"
//                + ")";  
//             
//                pst = con.prepareStatement(sql);
//                pst.execute();
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
