/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.room_reservation;

import model.HMS;
import source.DBConnection;

/**
 *
 * @author Dhanuka Perera
 */
public class Guest_Details_Model extends HMS
{
    private String reservationId;
    private String checkInDate;
    private String checkOutDate;
    
    private String arrivelTimePeriod;
    private String levingTimePeriod;
    private int numberOfAdults;
    
    private int numberOfChilderen;
    private int roomNo;
    
    

//      Guest_Details_Frame
    
    public Guest_Details_Model ()
    {
        con = DBConnection.connect();
    }
    
    
    
    /*
    public String getPrimaryKey()
    {
        setreservationId();
        geteservationId();
        return this.reservationId;
    }
    
    
    
    */
    
    
    
    
    
    
    ///////////////////////////////////////////////////////////
    /*
    private void geteservationId() 
    { 
        this.reservationId = Guest_Details_Frame.txtReservationId.getText();
    }
    
    private void getcheckInDate()
    {
        this.checkInDate = getDateFromPicker(Guest_Details_Frame.jdcCheckInDate);
        
    }
    
    private void getcheckOutDate()
    {
        this.checkInDate = getDateFromPicker(Guest_Details_Frame.jdcCheckOutDate);
    }
    
    private void getarrivelTimePeriod()
    {
        this.arrivelTimePeriod = Guest_Details_Frame.cmbArrivalTimePeriod.getSelectedItem().toString();
    }
    
    private void getlevingTimePeriod()
    {
        this.levingTimePeriod = Guest_Details_Frame.cmbLeavingTimePeriod.getSelectedItem().toString();
    }
    
    private void getnumberOfAdults()
    {
        this.numberOfAdults = Integer.parseInt(  Guest_Details_Frame.cmbNofAdults.getSelectedItem().toString());
    }
    
    private void getnumberOfChilderen()
    {
        this.numberOfChilderen = Integer.parseInt(  Guest_Details_Frame.cmbNoOfChildren.getSelectedItem().toString());
    }
    
    private void getroomNo()
    {
        this.roomNo = Integer.parseInt (Guest_Details_Frame.txtReservationId.getText());
    }
    */
    /*
    private void getAll()
    {
         geteservationId() ;
         getcheckInDate();
         getcheckOutDate();
         getarrivelTimePeriod();
         getlevingTimePeriod();
         getnumberOfAdults();
         getnumberOfChilderen();
         getroomNo();
    }
    
    //////////////////////////////////////////////////////////////
    
    private void setreservationId()
    {
         Guest_Details_Frame.txtReservationId.setText(Guest_Details_Frame.tblRerservations.getValueAt(getSelectedRow(Guest_Details_Frame.tblRerservations), 0).toString());
    }
    
    private void setcheckInDate()
    {
        // Guest_Details_Frame.txtReservationId.setText(Guest_Details_Frame.tblRerservations.getValueAt(getSelectedRow(Guest_Details_Frame.tblRerservations), 0).toString());
    }
    
    private void setcheckOutDate()
    {
        
    }
    
    private void setarrivelTimePeriod()
    {
         Guest_Details_Frame.cmbArrivalTimePeriod.setSelectedItem(Guest_Details_Frame.tblRerservations.getValueAt(getSelectedRow(Guest_Details_Frame.tblRerservations), 6).toString());
    }
    
    private void setlevingTimePeriod()
    {
         Guest_Details_Frame.cmbLeavingTimePeriod.setSelectedItem(Guest_Details_Frame.tblRerservations.getValueAt(getSelectedRow(Guest_Details_Frame.tblRerservations), 7).toString());
    }
    
    private void setnumberOfAdults()
    {
         Guest_Details_Frame.cmbNofAdults.setSelectedItem(Guest_Details_Frame.tblRerservations.getValueAt(getSelectedRow(Guest_Details_Frame.tblRerservations), 12).toString());
    }
    
    private void setnumberOfChilderen()
    {
        Guest_Details_Frame.cmbNoOfChildren.setSelectedItem(Guest_Details_Frame.tblRerservations.getValueAt(getSelectedRow(Guest_Details_Frame.tblRerservations), 13).toString());
    }
    
    private void setroomNo()
    {
         Guest_Details_Frame.cmbRoomNo.setSelectedItem(Guest_Details_Frame.tblRerservations.getValueAt(getSelectedRow(Guest_Details_Frame.tblRerservations), 3).toString());
    }
    
    public void setAll()
    {
        setreservationId();
        setcheckInDate();
        setcheckOutDate();
        setarrivelTimePeriod();
        setlevingTimePeriod();
        setnumberOfAdults();
        setnumberOfChilderen();
        setroomNo();
    }
    */
    ////////////////////////////////////////////////////////
    @Override
    public void add(String tableName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(String tableName) 
    {
       // getAll();
    // geteservationId() ;
    // getcheckInDate();
    // getcheckOutDate();
        
        //getAll();
        
        //getcheckInDate();
       // getcheckOutDate();
       // geteservationId();
        //getroomNo();
        
        String sql = "UPDATE "+tableName+""
                + " SET `Room No` = "+ "" + this.roomNo + ","
               
                + "`Checked In Date` = '" + this.checkInDate + "',"
                + "`Checked Out Date`= '" + this.checkOutDate + "'"
              
               
               
                + "WHERE `Room Reservation ID` = '" + this.reservationId + "'";
        
        System.out.println(sql);
        /*
        try 
        {
             pst = con.prepareStatement(sql);
            pst.execute();
            loadTable(tableName,Guest_Details_Frame.tblRerservations); // Updated! 
            JOptionPane.showMessageDialog(null,"Recorde Updated Sucessfully");
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }*/
    }
    /*
    @Override
    public void loadTable(String tableName,JTable tblName)
    {     
      String sql = "SELECT * FROM room_reservations r, room_guests g\n" +
    "where r.`Room Guest ID` = g.`Room Guest ID`";
      System.out.println(sql);
        try 
        {
           
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery(); 
            tblName.setModel(DbUtils.resultSetToTableModel(rs));
            
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            //System.err.println("Connection Fail !");
           // lblConnectionType.setText("Connection Fail!");
        }
    }
*/
    /*
    public void Modelsearch()
    {
        String filters = Guest_Details_Frame.cmbFilters.toString();
        String filter = "`"+filters+"`";
        String search=Guest_Details_Frame.txtSearch.getText();
        String tablename = "room_reservations";
        JTable tblName = Guest_Details_Frame.tblRerservations;
        
        search(filter,search,tablename,tblName);

    }*/
}
