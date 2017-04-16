/*
 * Hotel Management System for Pavana Hotel Kochchikade
 * Information Technology Project - 2016
 * Project ID   : ITP_WD_16_B1_06
 * Supervisor   : Mrs. Asanthika Imbulpitiya
 *
 * Student Name : Perera P.D.S   
 * IT Number    : IT14031380
*/

package model.room_reservation;

import app.room_reservation.Room_Details_Frame;
import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.HMS;
import reports.iReportView;
import source.DBConnection;

public class Room_Details_Model extends HMS
{
    private String roomNo;
    private String roomType;
    private String bedType;
    private int maxGuest;
    private String serviceStatus;
    private String description;
    
    private String addRoomType;
    private int rateForADay;
   
    public Room_Details_Model ()
    {
        con = DBConnection.connect();
        
        this.roomNo = "NULL";
        this.roomType = "No Room Type";
        this.bedType = "No Bed Type";
        this.maxGuest = 0;
        this.serviceStatus = "No Status";
        this.description = "No Description";
        
        this.addRoomType = "No Type";
        this.rateForADay = 0;
        
       //colList = "`Room No`,`Date Modified`,`Room Type`,`Bed Type`,`Max Guests`,`Max Guests`,`Rate for Day`,`Rate for Night`,`Current Stautus`,`Description`";
       // System.out.println(colList);
    }
          
    public String getPrimaryKey()
    {
        setRoomNo();
        getRoomNo();
        return this.roomNo;
    }
    
    public String getRoomTypePrimaryKey()
    {
        setAddRoomType();
        getAddRoomType();
        return this.addRoomType;
    }
    // -------------------------------------------------------------------------
    // -- BEGIN Getting Values -------------------------------------------------
    
    private void getRoomNo() { this.roomNo = Room_Details_Frame.txtRoomNo.getText();}
    
    private void getRoomType() { this.roomType = Room_Details_Frame.cmbRoomType.getSelectedItem().toString();}
    
    private void getBedType() { this.bedType = Room_Details_Frame.cmbBedType.getSelectedItem().toString();}
    
    private void getMaxGuest() { this.maxGuest = Integer.parseInt(Room_Details_Frame.cmbMaxGuests.getSelectedItem().toString());}

    private void getServiceStatus() { this.serviceStatus = Room_Details_Frame.cmbServiceStatus.getSelectedItem().toString();}
    
     private void getDescription() 
     {
       // For the cols comes null vals
        this.description = Room_Details_Frame.txtDescription.getText();
        if(this.description.length() == 0 )
        {
            this.description = " ";
        }
     }
     
    private void getAddRoomType() { this.addRoomType = Room_Details_Frame.txtAddRoomType.getText();}

    private void getRateForDay() { this.rateForADay = Integer.parseInt(Room_Details_Frame.txtRateForADay.getText());}

    public void getRoomDeatils()
    {
        getRoomNo();
        getRoomType();
        getBedType();
        getMaxGuest();
        getServiceStatus();
        getDescription();
    }
    
    public void getRoomTypeDeatils()
    {
        getAddRoomType();
        getRateForDay();
    }
    
    // -- END Getting Values -------------------------------------------------------
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    // -- BEGIN Setting Values -------------------------------------------------
     
    public void setRoomNo() { Room_Details_Frame.txtRoomNo.setText(Room_Details_Frame.tblRoomDeatils.getValueAt(getSelectedRow(Room_Details_Frame.tblRoomDeatils), 0).toString());}
     
    private void setRoomType() { Room_Details_Frame.cmbRoomType.setSelectedItem(Room_Details_Frame.tblRoomDeatils.getValueAt(getSelectedRow(Room_Details_Frame.tblRoomDeatils), 2).toString());}
     
    private void setBedType() { Room_Details_Frame.cmbBedType.setSelectedItem(Room_Details_Frame.tblRoomDeatils.getValueAt(getSelectedRow(Room_Details_Frame.tblRoomDeatils), 3).toString());}
     
    private void maxGuest() { Room_Details_Frame.cmbMaxGuests.setSelectedItem(Room_Details_Frame.tblRoomDeatils.getValueAt(getSelectedRow(Room_Details_Frame.tblRoomDeatils), 4).toString());}
    
    private void setServiceStatus() { Room_Details_Frame.cmbServiceStatus.setSelectedItem(Room_Details_Frame.tblRoomDeatils.getValueAt(getSelectedRow(Room_Details_Frame.tblRoomDeatils),6).toString());}
   
    private void setDescription() { Room_Details_Frame.txtDescription.setText(Room_Details_Frame.tblRoomDeatils.getValueAt(getSelectedRow(Room_Details_Frame.tblRoomDeatils), 8).toString());}
    
    private void setAddRoomType() { Room_Details_Frame.txtAddRoomType.setText(Room_Details_Frame.tblRoomTypes.getValueAt(getSelectedRow(Room_Details_Frame.tblRoomTypes), 0).toString());}

    private void setRateForDay() { Room_Details_Frame.txtRateForADay.setText(Room_Details_Frame.tblRoomTypes.getValueAt(getSelectedRow(Room_Details_Frame.tblRoomTypes), 2).toString());}
    
    public void setRoomTypes()
     {
        setToText(Room_Details_Frame.tblRoomDeatils, Room_Details_Frame.txtRoomNo, 0);
        setToCmb(Room_Details_Frame.tblRoomDeatils, Room_Details_Frame.cmbRoomType, 2);
        setToCmb(Room_Details_Frame.tblRoomDeatils, Room_Details_Frame.cmbBedType, 3);
        setToCmb(Room_Details_Frame.tblRoomDeatils, Room_Details_Frame.cmbMaxGuests, 4);
        setToCmb(Room_Details_Frame.tblRoomDeatils, Room_Details_Frame.cmbServiceStatus, 5);
        setToText(Room_Details_Frame.tblRoomDeatils, Room_Details_Frame.txtDescription, 6);
     }
    
    public void setRoomTypesDeatils()
    {
        setAddRoomType();
        setRateForDay();
    }
        
    // -- END Setting Values ---------------------------------------------------
    // -------------------------------------------------------------------------
    
    public  String sendValues()
    {
        getRoomDeatils();
       
        String x = getCurrentDateTime() + "," + this.roomType + ","+ this.bedType + ","+ this.maxGuest+ ","+this.serviceStatus+","+this.description;
        return x;
    }
    
    public String sendRoomTypesValues()
    {
        getRoomTypeDeatils();
        String info = this.addRoomType + "," + getCurrentDateTime()+ "," + this.rateForADay;
        return info;
    }
    
    @Override
    public void add(String tableName)
    {             
        getRoomDeatils();
        String sql = "INSERT INTO "+tableName+""
                + "(`Room Type`,`Date Modified`,`Bed Type`,`Current Stautus`,`Max Guests`,`Rate for Day`,`Rate for Night`,`Description`)"
                + " VALUES("
                + "'"+this.roomType+"',"
                + "'"+getCurrentDateTime()+"',"
                + "'"+this.bedType+"',"
                + "'"+this.serviceStatus+"',"
                + ""+this.maxGuest+","
                + ""+this.rateForADay+","
              
                + "'"+this.description+"'"
                + ")";
        System.out.println(sql);
        
        try 
        {
            pst = con.prepareStatement(sql);
            pst.execute();
            loadTable(tableName,Room_Details_Frame.tblRoomDeatils);   // Updated!   
             JOptionPane.showMessageDialog(null,"Recorde Added Sucessfully");
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void update(String tableName)
    {   
        getRoomDeatils();
     
        String sql = "UPDATE "+tableName+""
                + " SET `Room Type` = "+ "'" + this.roomType + "',"
                + "`Date Modified`= '" + getCurrentDateTime() + "',"
                + "`Current Stautus` = '" + this.serviceStatus + "',"
                + "`Max Guests`=" + this.maxGuest + ","
                + "`Rate for Day`=" + this.rateForADay + ", "
              
                + "`Description`='" + this.description + "' "
                + "WHERE `Room No` = '" + this.roomNo + "'";
        
        //System.out.println(sql);
        
        try 
        {
            pst = con.prepareStatement(sql);
            pst.execute();
            loadTable(tableName,Room_Details_Frame.tblRoomDeatils); // Updated! 
            JOptionPane.showMessageDialog(null,"Recorde Updated Sucessfully");
        } 
        catch (SQLException | HeadlessException e) 
        {
               
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void report()
    {
        iReportView r = new iReportView( "E:\\SLIIT Projects\\ITP\\NetBeans Project\\Pavana - Hotel Management System - ITP\\src\\reports\\room_reservation\\Room Deatils.jasper");
        //iReportView r = new iReportView( "\\src\\reports\\room_reservation\\Room Deatils.jasper");
        r.setVisible(true);
    }
    
    
 /*   
public void loadToCmb()
    {
        View_Reservations_Frame.jtest.removeAllItems();
        String sql = "SELECT `Room Reservation ID` FROM `room_reservations`";
        try 
        {
            pst = con.prepareStatement(sql);
            rs =pst.executeQuery();
            while(rs.next())
            {                
                String name =  rs.getString("Room Reservation ID");
                View_Reservations_Frame.jtest.addItem(name);
              // cmbCatorgies.addItem(name);
               System.out.println(name);                
            }
        }
        catch (Exception e) 
        {
             JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
   
   */  
    
   /*
    
    SELECT * FROM room_reservations r, room_guests g
    where r.`Room Guest ID` = g.`Room Guest ID`
    */
    
    
    public void Modelsearch()
    {
        //String filters = Room_Details_Frame.cmbSearchBy.getSelectedItem().toString();
       // String filter = "`"+filters+"`";
        String search=Room_Details_Frame.txtSearch.getText();
        String tablename = "rooms";
        JTable tblName = Room_Details_Frame.tblRoomDeatils;
        
       // search(filter,search,tablename,tblName);

    }
}
