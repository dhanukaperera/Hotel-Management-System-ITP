/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.room_reservation;

import app.room_reservation.Room_Availability_Frame;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.HMS;
import source.DBConnection;

/**
 *
 * @author Dhanuka Perera
 */
public class Room_Availability_Model extends HMS
{
    String roomReservationId;
    
    String nic;
    int roomNo;
    String arrivelDay;
    String leavingDay;
    String checkedInStatus;
    String mealType;
    int numOfAdults;
    int numOfChildrent;
    
    String CheckedInDateTime;
    
    int guestId;
    
    String title;
    String firstName;
    String lastName;
    String gender;
    String age;
    String contactNo;
    String email;
    String zip;
    String city;
    String state;
    String country;
    
    String totalRoomList;
    String totalMealList;
    
    String roomType;
    
     public Room_Availability_Model ()
    {
        con = DBConnection.connect();
        
       roomReservationId = "";
    
     nic= "";
    roomNo= 0;
    arrivelDay= "";
    leavingDay= "";
    checkedInStatus= "";
   mealType= "";
    numOfAdults= 0;
    numOfChildrent = 0;
    
    CheckedInDateTime = "";
    
     guestId =0;
    
    title= "";
    firstName= "";
    lastName= "";
    gender= "";
    age= "";
    contactNo= "";
    email= "";
   zip= "";
    city= "";
    state= "";
    country= "";
    
    totalRoomList= "";
    totalMealList= "";
    
    roomType= "";
    }
     
     
     
     String RoomReservationID;
     
     public void checkIn()
     {
         String vals = "Checked,"+getCurrentDateTime()+"";
         
        newUpdate("room_reservations", "Checked in Status,Checked In Date Time", vals, "Room Reservation ID", Room_Availability_Frame.lblRoomReservationID.getText());
        loadPendingRooms();
       clearlbls();
     }
     
     public void clearlbls()
     {
         JLabel[] lblArr = new JLabel[]{
            Room_Availability_Frame.lblRoomNo,
            Room_Availability_Frame.lblCheckInStatus,
            Room_Availability_Frame.lblRoomReservationID,
            Room_Availability_Frame.lblRoomReservationID,
            Room_Availability_Frame.lblArrivalDay,
              Room_Availability_Frame.lblRoomType,
            
            Room_Availability_Frame.lblLeavingDay,
            Room_Availability_Frame.lblNumberofNights,
            Room_Availability_Frame.lblPackage,
            Room_Availability_Frame.lblNumberOfAdults,
            Room_Availability_Frame.lblNumberOfChildren,
            Room_Availability_Frame.lblTotalGuests,
            
            Room_Availability_Frame.lblNic,
            Room_Availability_Frame.lblGuestName,
            Room_Availability_Frame.lblAge,
            Room_Availability_Frame.lblEmail,
            Room_Availability_Frame.lblPostal_ZipCode,
            Room_Availability_Frame.lblCity,
            
             Room_Availability_Frame.lblContactNo,
            Room_Availability_Frame.lblStateProvince,
            Room_Availability_Frame.lblCountry,
            Room_Availability_Frame.lblCheckInDateTime,
            
              
         };
         
         for(int i = 0; i<lblArr.length;i++)
         {
             lblArr[i].setText(": ");
         }
     }
     
     public void testx()
     {
        
     }
     
    public void loadPendingRooms() {
        String roomNum = "";
        Room_Availability_Frame.cmbPendingList.removeAllItems();

        String sqlGetResInfo = "SELECT * FROM room_reservations WHERE `Checked in Status`='Pending' AND `Arrivel Day` = '" + getCurrentDateTime().substring(0, 10) + "' Order By `Arrivel Day` ASC";

        try {
            pst = con.prepareStatement(sqlGetResInfo);
            rs = pst.executeQuery();

            while (rs.next()) {

                roomNum = rs.getString("Room No");

                Room_Availability_Frame.cmbPendingList.addItem(roomNum);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }

        if (roomNum == "" || roomNum == null) {
            roomNum = "0";
            Room_Availability_Frame.cmbPendingList.addItem(roomNum);
        }
        System.err.println(sqlGetResInfo);

    }
     
    public void getPendingData(int proomNo) {
        String sqlGetResInfo = "SELECT * FROM room_reservations WHERE `Room No` = " + proomNo + " AND `Checked in Status`='Pending' AND  `Arrivel Day` = '" + getCurrentDateTime().substring(0, 10) + "' Order By `Arrivel Day` ASC";

        try {
            pst = con.prepareStatement(sqlGetResInfo);
            rs = pst.executeQuery();

            if (rs.next()) {
                this.roomReservationId = rs.getString("Room Reservation ID");
                this.nic = rs.getString("NIC/Passport");
                this.arrivelDay = rs.getString("Arrivel Day");
                this.leavingDay = rs.getString("Leaving Day");
                this.CheckedInDateTime = rs.getString("Checked In Date Time");
                this.checkedInStatus = rs.getString("Checked in Status");
                this.mealType = rs.getString("Meal Type");
                this.numOfAdults = rs.getInt("No of Adults");
                this.numOfChildrent = rs.getInt("No of Children");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
       
        
        String sqlGetGuestInfo = "SELECT * FROM room_guests WHERE `NIC/Passport` = " + this.nic + "";

        try {
            pst = con.prepareStatement(sqlGetGuestInfo);
            rs = pst.executeQuery();
            if (rs.next()) {
                this.title = rs.getString("Title");
                this.firstName = rs.getString("First Name");
                this.lastName = rs.getString("Last Name");
                this.gender = rs.getString("Gender");
                this.age = rs.getString("Age");
                this.contactNo = rs.getString("Contact No");
                this.email = rs.getString("Email");
                this.zip = rs.getString("Postal/Zip Code");
                this.city = rs.getString("City");
                this.state = rs.getString("State/Province");
                this.country = rs.getString("Country");
            }
        } catch (Exception e) {

        }
this.roomType = getValueFromDB("Room Type","rooms","Room No",Integer.toString(proomNo));
        // System.out.println(s1);
    }
    
    public void restColors()
    {
        JLabel arrRnumbers[] = new JLabel[]
        {
          Room_Availability_Frame.lbl_r01,
            Room_Availability_Frame.lbl_r02,
            Room_Availability_Frame.lbl_r03,
            Room_Availability_Frame.lbl_r04,
            Room_Availability_Frame.lbl_r05,
            Room_Availability_Frame.lbl_r06,
            Room_Availability_Frame.lbl_r07,
            Room_Availability_Frame.lbl_r08,
            Room_Availability_Frame.lbl_r09,
            Room_Availability_Frame.lbl_r10,
            Room_Availability_Frame.lbl_r11,
            Room_Availability_Frame.lbl_r12,
            Room_Availability_Frame.lbl_r13,
            Room_Availability_Frame.lbl_r14,
            Room_Availability_Frame.lbl_r15
            
        };
        
        for(int i=0;i<arrRnumbers.length;i++)
        {
            arrRnumbers[i].setBackground(new Color(236, 240, 241));
        }
    }
    
    public void colorCheckedIn()
    {
        int i=1;
        
        for(i=1;i<15;i++)
        {
            
       
        
         String sqlGetRoomList = "SELECT `Room No` FROM room_reservations WHERE `Room No` = " +i+ " AND `Checked in Status`='Checked' Order By `Arrivel Day` ASC";
         
         int curR=0;
        try 
        {
              pst = con.prepareStatement(sqlGetRoomList);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                curR = rs.getInt("Room No");
                
                if(curR == 1)
                {
                    Room_Availability_Frame.lbl_r01.setBackground(new Color(241, 196, 15));
                }
                
                if(curR == 2)
                {
                    Room_Availability_Frame.lbl_r02.setBackground(new Color(241, 196, 15));
                }
                
                if(curR == 3)
                {
                    Room_Availability_Frame.lbl_r03.setBackground(new Color(241, 196, 15));
                }
                
                if(curR == 4)
                {
                    Room_Availability_Frame.lbl_r04.setBackground(new Color(241, 196, 15));
                }
                
                if(curR == 5)
                {
                    Room_Availability_Frame.lbl_r05.setBackground(new Color(241, 196, 15));
                }
                
                if(curR == 6)
                {
                    Room_Availability_Frame.lbl_r06.setBackground(new Color(241, 196, 15));
                }
                
                if(curR == 7)
                {
                    Room_Availability_Frame.lbl_r07.setBackground(new Color(241, 196, 15));
                }
                
                if(curR == 8)
                {
                    Room_Availability_Frame.lbl_r08.setBackground(new Color(241, 196, 15));
                }
                
                if(curR == 9)
                {
                    Room_Availability_Frame.lbl_r09.setBackground(new Color(241, 196, 15));
                }
                
                if(curR == 10)
                {
                    Room_Availability_Frame.lbl_r10.setBackground(new Color(241, 196, 15));
                }
                
                if(curR == 11)
                {
                    Room_Availability_Frame.lbl_r11.setBackground(new Color(241, 196, 15));
                }
                
                if(curR == 12)
                {
                    Room_Availability_Frame.lbl_r12.setBackground(new Color(241, 196, 15));
                }
                
                if(curR == 13)
                {
                    Room_Availability_Frame.lbl_r13.setBackground(new Color(241, 196, 15));
                }
                
                if(curR == 14)
                {
                    Room_Availability_Frame.lbl_r14.setBackground(new Color(241, 196, 15));
                }
                
                if(curR == 15)
                {
                    Room_Availability_Frame.lbl_r15.setBackground(new Color(241, 196, 15));
                }
            }
        }
         catch (Exception e)
        {
            
        }
         }
    }
    
    public void getRoomData(int pRno)
    {
        String sqlGetResInfo = "SELECT * FROM room_reservations WHERE `Room No` = " +pRno+ " AND `Checked in Status`='Checked' Order By `Arrivel Day` ASC";

        try {
            pst = con.prepareStatement(sqlGetResInfo);
            rs = pst.executeQuery();

            if (rs.next()) {
                this.roomReservationId = rs.getString("Room Reservation ID");
                this.nic = rs.getString("NIC/Passport");
                this.arrivelDay = rs.getString("Arrivel Day");
                this.leavingDay = rs.getString("Leaving Day");
                this.CheckedInDateTime = rs.getString("Checked In Date Time");
                this.checkedInStatus = rs.getString("Checked in Status");
                this.mealType = rs.getString("Meal Type");
                this.numOfAdults = rs.getInt("No of Adults");
                this.numOfChildrent = rs.getInt("No of Children");
                 this.numOfChildrent = rs.getInt("No of Children");
                  this.roomNo = rs.getInt("Room No");
                 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }

        if(this.leavingDay == "" || this.leavingDay == "null")
        {
            clearlbls();
        }
        
        String sqlGetGuestInfo = "SELECT * FROM room_guests WHERE `NIC/Passport` = " + this.nic + "";

        try {
            pst = con.prepareStatement(sqlGetGuestInfo);
            rs = pst.executeQuery();
            if (rs.next()) {
                this.title = rs.getString("Title");
                this.firstName = rs.getString("First Name");
                this.lastName = rs.getString("Last Name");
                this.gender = rs.getString("Gender");
                this.age = rs.getString("Age");
                this.contactNo = rs.getString("Contact No");
                this.email = rs.getString("Email");
                this.zip = rs.getString("Postal/Zip Code");
                this.city = rs.getString("City");
                this.state = rs.getString("State/Province");
                this.country = rs.getString("Country");
                
            }
        } catch (Exception e) {

        }

        
        
        // System.out.println(s1);

        this.roomType = getValueFromDB("Room Type","rooms","Room No",Integer.toString(pRno));
    }
    

    public void fillPendingData(int proomNo) {
        getPendingData(proomNo);
      
         Room_Availability_Frame.lblLeavingDay.setText(": " + this.leavingDay);
        Room_Availability_Frame.lblRoomReservationID.setText(this.roomReservationId);
        Room_Availability_Frame.lblArrivalDay.setText(": " + this.arrivelDay);
        
        //Room_Availability_Frame.lblNumberofNights.setText(this.roomReservationId);
        Room_Availability_Frame.lblPackage.setText(": " + this.mealType);
        Room_Availability_Frame.lblNumberOfAdults.setText(": " + Integer.toString(this.numOfAdults));
        Room_Availability_Frame.lblNumberOfChildren.setText(": " + Integer.toString(this.numOfChildrent));
        Room_Availability_Frame.lblCheckInStatus.setText((": " + this.checkedInStatus));
        
        Room_Availability_Frame.lblNic.setText(": " + this.nic);
        Room_Availability_Frame.lblGuestName.setText(": " + this.title + " " + this.firstName + " " + this.lastName);
        Room_Availability_Frame.lblAge.setText(": " + this.age);
        Room_Availability_Frame.lblContactNo.setText(": " + this.contactNo);
        Room_Availability_Frame.lblEmail.setText(": " + this.email);
        Room_Availability_Frame.lblPostal_ZipCode.setText(": " + this.zip);
        Room_Availability_Frame.lblCity.setText(": " + this.city);
        Room_Availability_Frame.lblStateProvince.setText(": " + this.state);
        Room_Availability_Frame.lblCountry.setText(": " + this.country);
        
         Room_Availability_Frame.lblRoomNo.setText(": " + this.roomNo);
          Room_Availability_Frame.lblRoomType.setText(": " + this.roomType);
           Room_Availability_Frame.lblCheckInDateTime.setText(": " + this.CheckedInDateTime);
           Room_Availability_Frame.lblRoomNo.setText(this.roomNo+"");

    }

    @Override
    public void add(String tableName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(String tableName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
