/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.room_reservation;

//import static app.room_reservation.View_Re

import model.HMS;
import source.DBConnection;

/**
 *
 * @author Dhanuka Perera
 */
public class View_Reservations_Model extends HMS
{
    
    public View_Reservations_Model()
    {
        con = DBConnection.connect();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    public void getResrvationData()
    {
        String sql = "SELECT `Room No`,`Checked In Date`,`Arrival Time Period`,`Checked Out Date`,`Leaving Time Period` FROM `room_reservations`";
        
        try 
        {
            pst = con.prepareStatement(sql);
            rs =pst.executeQuery();
            while(rs.next())
            {          
                String f1 =  rs.getString("Room No");
                String f2 =  rs.getString("Checked In Date");
                String f3 =  rs.getString("Arrival Time Period");
                String f4 =  rs.getString("Checked Out Date");
                String f5 =  rs.getString("Leaving Time Period");
                //System.out.println( name2 + "," +name3+ ","+ name4 + "," + name5 + "," + name6);                
                
                this.roomNo = Integer.parseInt(f1);
                this.checkInDay = getDayFromDate(f2);
                this.arrivalTimePeriod = getFirstChar(f3);
                this.checkOutDay = getDayFromDate(f4);
                this.leavingTimePeriod = getFirstChar(f5);
                
                System.out.println(f1 + "," + f2 + "," + f3 + "," + f4 + "," + f5 );
                
                System.out.println();
                
                //System.out.println(this.roomNo+","+this.checkInDay+ ,"M",+ this.checkOutDay +","+this.leavingTimePeriod);
                setCalender(this.roomNo,this.checkInDay,this.arrivalTimePeriod,this.checkOutDay,this.leavingTimePeriod);
                //setCalender(1,22,"M",23,"D");
                
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
            
    }
    */
    /*
    private int getDayFromDate(String dateString)
    {
        String stringDay = dateString.substring(8, 10);
        int rDay = Integer.parseInt(stringDay);
        return rDay;
    }
    
    private String getFirstChar(String ptimePeriod)
    {
        String timePeriod = ptimePeriod.substring(0,1);
        return timePeriod;
    }
    */
    /*public void loadToCmb()
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
    /*public void x()
    {
        loadCalModel a = new loadCalModel();
        a.loadcmbs();
    }
    */
    /*
    public void setCalender(int roomNo,int checkInDay,String parrivalTime,int checkOutDay,String pleavingTime)
    {
       // x();
        duerationOfDays = checkOutDay-checkInDay;
        switch (roomNo) {
            case 1:
        switch (duerationOfDays) {
            case 2:
                break;
            case 1:
                // Set CheckIn Image
                System.out.println("du =1");
        switch (checkInDay) {
            case day1:
                System.out.println("ch day 1");
                setCheckInImage(r1_d1, parrivalTime);
                break;
            case day2:
                System.out.println("ch day 2");
                setCheckInImage(r1_d2, parrivalTime);
                break;
            case day3:
                System.out.println("ch day 3");
                setCheckInImage(r1_d3, parrivalTime);
                break;
            case day4:
                System.out.println("ch day 4");
                setCheckInImage(r1_d4, parrivalTime);
                break;
            case day5:
                setCheckInImage(r1_d5, parrivalTime);
                break;
            case day6:
                setCheckInImage(r1_d6, parrivalTime);
                break;
            case day7:
                setCheckInImage(r1_d7, parrivalTime);
                break;
            default:
                break;
        }
                // Set CheckOut Image
                switch (checkOutDay) {
                    case day1:
                        //System.out.println("ch day 1");
                        setCheckOutImage(r1_d1, pleavingTime);
                        break;
                    case day2:
                        //System.out.println("ch day 2");
                        setCheckOutImage(r1_d2, pleavingTime);
                        break;
                    case day3:
                        //System.out.println("ch day 3");
                        setCheckOutImage(r1_d3, pleavingTime);
                        break;
                    case day4:
                        //System.out.println("ch day 4");
                        setCheckOutImage(r1_d4, pleavingTime);
                        break;
                    case day5:
                        setCheckOutImage(r1_d5, pleavingTime);
                        break;
                    case day6:
                        setCheckOutImage(r1_d6, pleavingTime);
                        break;
                    case day7:
                        setCheckOutImage(r1_d7, pleavingTime);
                        break;
                    default:
                        break;
                }   break;
            case 0:
                break;
            default:
                break;
        }
break;
            case 2:
        switch (duerationOfDays) {
            case 2:
                break;
            case 1:
        // Set CheckIn Image
        switch (checkInDay) {
            case day1:
                setCheckInImage(r2_d1, parrivalTime);
                break;
            case day2:
                setCheckInImage(r2_d2, parrivalTime);
                break;
            case day3:
                setCheckInImage(r2_d3, parrivalTime);
                break;
            case day4:
                setCheckInImage(r2_d4, parrivalTime);
                break;
            case day5:
                setCheckInImage(r2_d5, parrivalTime);
                break;
            case day6:
                setCheckInImage(r2_d6, parrivalTime);
                break;
            case day7:
                setCheckInImage(r2_d7, parrivalTime);
                break;
            default:
                break;
        }
        // Set CheckOut Image
        switch (checkOutDay) {
            case day1:
                setCheckOutImage(r2_d1, pleavingTime);
                break;
            case day2:
                setCheckOutImage(r2_d2, pleavingTime);
                break;
            case day3:
                setCheckOutImage(r2_d3, pleavingTime);
                break;
            case day4:
                setCheckOutImage(r2_d4, pleavingTime);
                break;
            case day5:
                setCheckOutImage(r2_d5, pleavingTime);
                break;
            case day6:
                setCheckOutImage(r2_d6, pleavingTime);
                break;
            case day7:
                setCheckOutImage(r2_d7, pleavingTime);
                break;
            default:
                break;
        }
                break;
            case 0:
                break;
            default:
                break;
        }
break;
            case 3:
        switch (duerationOfDays) {
            case 2:
                break;
            case 1:
        // Set CheckIn Image
        switch (checkInDay) {
            case day1:
                setCheckInImage(r3_d1, parrivalTime);
                break;
            case day2:
                setCheckInImage(r3_d2, parrivalTime);
                break;
            case day3:
                setCheckInImage(r3_d3, parrivalTime);
                break;
            case day4:
                setCheckInImage(r3_d4, parrivalTime);
                break;
            case day5:
                setCheckInImage(r3_d5, parrivalTime);
                break;
            case day6:
                setCheckInImage(r3_d6, parrivalTime);
                break;
            case day7:
                setCheckInImage(r3_d7, parrivalTime);
                break;
            default:
                break;
        }
        // Set CheckOut Image
        switch (checkOutDay) {
            case day1:
                setCheckOutImage(r3_d1, pleavingTime);
                break;
            case day2:
                setCheckOutImage(r3_d2, pleavingTime);
                break;
            case day3:
                setCheckOutImage(r3_d3, pleavingTime);
                break;
            case day4:
                setCheckOutImage(r3_d4, pleavingTime);
                break;
            case day5:
                setCheckOutImage(r3_d5, pleavingTime);
                break;
            case day6:
                setCheckOutImage(r3_d6, pleavingTime);
                break;
            case day7:
                setCheckOutImage(r3_d7, pleavingTime);
                break;
            default:
                break;
        }
                break;
            case 0:
                break;
            default:
                break;
        }
break;
            case 4:
        switch (duerationOfDays) {
            case 2:
                break;
            case 1:
        // Set CheckIn Image
        switch (checkInDay) {
            case day1:
                setCheckInImage(r4_d1, parrivalTime);
                break;
            case day2:
                setCheckInImage(r4_d2, parrivalTime);
                break;
            case day3:
                setCheckInImage(r4_d3, parrivalTime);
                break;
            case day4:
                setCheckInImage(r4_d4, parrivalTime);
                break;
            case day5:
                setCheckInImage(r4_d5, parrivalTime);
                break;
            case day6:
                setCheckInImage(r4_d6, parrivalTime);
                break;
            case day7:
                setCheckInImage(r4_d7, parrivalTime);
                break;
            default:
                break;
        }
        // Set CheckOut Image
        switch (checkOutDay) {
            case day1:
                setCheckOutImage(r4_d1, pleavingTime);
                break;
            case day2:
                setCheckOutImage(r4_d2, pleavingTime);
                break;
            case day3:
                setCheckOutImage(r4_d3, pleavingTime);
                break;
            case day4:
                setCheckOutImage(r4_d4, pleavingTime);
                break;
            case day5:
                setCheckOutImage(r4_d5, pleavingTime);
                break;
            case day6:
                setCheckOutImage(r4_d6, pleavingTime);
                break;
            case day7:
                setCheckOutImage(r4_d7, pleavingTime);
                break;
            default:
                break;
        }
                break;
            case 0:
                break;
            default:
                break;
        }
break;
            case 5:
        switch (duerationOfDays) {
            case 2:
                break;
            case 1:
        // Set CheckIn Image
        switch (checkInDay) {
            case day1:
                setCheckInImage(r5_d1, parrivalTime);
                break;
            case day2:
                setCheckInImage(r5_d2, parrivalTime);
                break;
            case day3:
                setCheckInImage(r5_d3, parrivalTime);
                break;
            case day4:
                setCheckInImage(r5_d4, parrivalTime);
                break;
            case day5:
                setCheckInImage(r5_d5, parrivalTime);
                break;
            case day6:
                setCheckInImage(r5_d6, parrivalTime);
                break;
            case day7:
                setCheckInImage(r5_d7, parrivalTime);
                break;
            default:
                break;
        }
        // Set CheckOut Image
        switch (checkOutDay) {
            case day1:
                setCheckOutImage(r5_d1, pleavingTime);
                break;
            case day2:
                setCheckOutImage(r5_d2, pleavingTime);
                break;
            case day3:
                setCheckOutImage(r5_d3, pleavingTime);
                break;
            case day4:
                setCheckOutImage(r5_d4, pleavingTime);
                break;
            case day5:
                setCheckOutImage(r5_d5, pleavingTime);
                break;
            case day6:
                setCheckOutImage(r5_d6, pleavingTime);
                break;
            case day7:
                setCheckOutImage(r5_d7, pleavingTime);
                break;
            default:
                break;
        }
                break;
            case 0:
                break;
            default:
                break;
        }
break;
            case 6:
        switch (duerationOfDays) {
            case 2:
                break;
            case 1:
        // Set CheckIn Image
        switch (checkInDay) {
            case day1:
                setCheckInImage(r6_d1, parrivalTime);
                break;
            case day2:
                setCheckInImage(r6_d2, parrivalTime);
                break;
            case day3:
                setCheckInImage(r6_d3, parrivalTime);
                break;
            case day4:
                setCheckInImage(r6_d4, parrivalTime);
                break;
            case day5:
                setCheckInImage(r6_d5, parrivalTime);
                break;
            case day6:
                setCheckInImage(r6_d6, parrivalTime);
                break;
            case day7:
                setCheckInImage(r6_d7, parrivalTime);
                break;
            default:
                break;
        }
        // Set CheckOut Image
        switch (checkOutDay) {
            case day1:
                setCheckOutImage(r6_d1, pleavingTime);
                break;
            case day2:
                setCheckOutImage(r6_d2, pleavingTime);
                break;
            case day3:
                setCheckOutImage(r6_d3, pleavingTime);
                break;
            case day4:
                setCheckOutImage(r6_d4, pleavingTime);
                break;
            case day5:
                setCheckOutImage(r6_d5, pleavingTime);
                break;
            case day6:
                setCheckOutImage(r6_d6, pleavingTime);
                break;
            case day7:
                setCheckOutImage(r6_d7, pleavingTime);
                break;
            default:
                break;
        }
                break;
            case 0:
                break;
            default:
                break;
        }
break;
            case 7:
        switch (duerationOfDays) {
            case 2:
                break;
            case 1:
        // Set CheckIn Image
        switch (checkInDay) {
            case day1:
                setCheckInImage(r7_d1, parrivalTime);
                break;
            case day2:
                setCheckInImage(r7_d2, parrivalTime);
                break;
            case day3:
                setCheckInImage(r7_d3, parrivalTime);
                break;
            case day4:
                setCheckInImage(r7_d4, parrivalTime);
                break;
            case day5:
                setCheckInImage(r7_d5, parrivalTime);
                break;
            case day6:
                setCheckInImage(r7_d6, parrivalTime);
                break;
            case day7:
                setCheckInImage(r7_d7, parrivalTime);
                break;
            default:
                break;
        }
        // Set CheckOut Image
        switch (checkOutDay) {
            case day1:
                setCheckOutImage(r7_d1, pleavingTime);
                break;
            case day2:
                setCheckOutImage(r7_d2, pleavingTime);
                break;
            case day3:
                setCheckOutImage(r7_d3, pleavingTime);
                break;
            case day4:
                setCheckOutImage(r7_d4, pleavingTime);
                break;
            case day5:
                setCheckOutImage(r7_d5, pleavingTime);
                break;
            case day6:
                setCheckOutImage(r7_d6, pleavingTime);
                break;
            case day7:
                setCheckOutImage(r7_d7, pleavingTime);
                break;
            default:
                break;
        }
                break;
            case 0:
                break;
            default:
                break;
        }
break;
            case 8:
        switch (duerationOfDays) {
            case 2:
                break;
            case 1:
        // Set CheckIn Image
        switch (checkInDay) {
            case day1:
                setCheckInImage(r8_d1, parrivalTime);
                break;
            case day2:
                setCheckInImage(r8_d2, parrivalTime);
                break;
            case day3:
                setCheckInImage(r8_d3, parrivalTime);
                break;
            case day4:
                setCheckInImage(r8_d4, parrivalTime);
                break;
            case day5:
                setCheckInImage(r8_d5, parrivalTime);
                break;
            case day6:
                setCheckInImage(r8_d6, parrivalTime);
                break;
            case day7:
                setCheckInImage(r8_d7, parrivalTime);
                break;
            default:
                break;
        }
        // Set CheckOut Image
        switch (checkOutDay) {
            case day1:
                setCheckOutImage(r8_d1, pleavingTime);
                break;
            case day2:
                setCheckOutImage(r8_d2, pleavingTime);
                break;
            case day3:
                setCheckOutImage(r8_d3, pleavingTime);
                break;
            case day4:
                setCheckOutImage(r8_d4, pleavingTime);
                break;
            case day5:
                setCheckOutImage(r8_d5, pleavingTime);
                break;
            case day6:
                setCheckOutImage(r8_d6, pleavingTime);
                break;
            case day7:
                setCheckOutImage(r8_d7, pleavingTime);
                break;
            default:
                break;
        }
                break;
            case 0:
                break;
            default:
                break;
        }
break;
            case 9:
        switch (duerationOfDays) {
            case 2:
                break;
            case 1:
        // Set CheckIn Image
        switch (checkInDay) {
            case day1:
                setCheckInImage(r9_d1, parrivalTime);
                break;
            case day2:
                setCheckInImage(r9_d2, parrivalTime);
                break;
            case day3:
                setCheckInImage(r9_d3, parrivalTime);
                break;
            case day4:
                setCheckInImage(r9_d4, parrivalTime);
                break;
            case day5:
                setCheckInImage(r9_d5, parrivalTime);
                break;
            case day6:
                setCheckInImage(r9_d6, parrivalTime);
                break;
            case day7:
                setCheckInImage(r9_d7, parrivalTime);
                break;
            default:
                break;
        }
                // Set CheckOut Image
                switch (checkOutDay) {
                    case day1:
                        setCheckOutImage(r9_d1, pleavingTime);
                        break;
                    case day2:
                        setCheckOutImage(r9_d2, pleavingTime);
                        break;
                    case day3:
                        setCheckOutImage(r9_d3, pleavingTime);
                        break;
                    case day4:
                        setCheckOutImage(r9_d4, pleavingTime);
                        break;
                    case day5:
                        setCheckOutImage(r9_d5, pleavingTime);
                        break;
                    case day6:
                        setCheckOutImage(r9_d6, pleavingTime);
                        break;
                    case day7:
                        setCheckOutImage(r9_d7, pleavingTime);
                        break;
                    default:
                        break;
                }   break;
            case 0:
                break;
            default:
                break;
        }
break;
            case 10:
        switch (duerationOfDays) {
            case 2:
                break;
            case 1:
                JLabel r10_d7;
        // Set CheckIn Image
        switch (checkInDay) {
            case day1:
                setCheckInImage(r10_d1, parrivalTime);
                break;
            case day2:
                setCheckInImage(r10_d2, parrivalTime);
                break;
            case day3:
                setCheckInImage(r10_d3, parrivalTime);
                break;
            case day4:
                setCheckInImage(r10_d4, parrivalTime);
                break;
            case day5:
                setCheckInImage(r10_d5, parrivalTime);
                break;
            case day6:
                setCheckInImage(r10_d6, parrivalTime);
                break;
        //setCheckInImage(r10_d7, parrivalTime);
            case day7:
                break;
            default:
                break;
        }
        // Set CheckOut Image
        switch (checkOutDay) {
            case day1:
                setCheckOutImage(r10_d1, pleavingTime);
                break;
            case day2:
                setCheckOutImage(r10_d2, pleavingTime);
                break;
            case day3:
                setCheckOutImage(r10_d3, pleavingTime);
                break;
            case day4:
                setCheckOutImage(r10_d4, pleavingTime);
                break;
            case day5:
                setCheckOutImage(r10_d5, pleavingTime);
                break;
            case day6:
                setCheckOutImage(r10_d6, pleavingTime);
                break;
        // setCheckOutImage(r10_d7, pleavingTime);
            case day7:
                break;
            default:
                break;
        }
                break;
            case 0:
                break;
            default:
                break;
        }
break;
            default:
                break;
        }
        
    }
    */
    private void setRoom01()
    {
        
    }
    
    /*
    private void setCheckInImage(JLabel calImg, String arTimeP)
    {
        switch (arTimeP) {
            case "M":
                try
                {
                    ImageIcon changeIcon = new ImageIcon(getClass().getResource("/resources/cal/checkInM.png"));
                    calImg.setIcon(changeIcon);
                }
                catch (Exception e)
                {
                    System.err.println("Can't find image" );
                }   break;
            case "D":
                try
                {
                    ImageIcon changeIcon = new ImageIcon(getClass().getResource("/resources/cal/checkInD.png"));
                    calImg.setIcon(changeIcon);
                }
                catch (Exception e)
                {
                    System.err.println("Can't find image" );
                }   break;
            case "N":
                try
                {
                    ImageIcon changeIcon = new ImageIcon(getClass().getResource("/resources/cal/checkInN.png"));
                    calImg.setIcon(changeIcon);
                }
                catch (Exception e)
                {
                    System.err.println("Can't find image" );
                }   break;
            default:
                break;
        }
    }
    
    private void setCheckOutImage(JLabel calImg, String arTimeP)
    {
        switch (arTimeP) {
            case "M":
                try
                {
                    ImageIcon changeIcon = new ImageIcon(getClass().getResource("/resources/cal/checkOutM.png"));
                    calImg.setIcon(changeIcon);
                }
                catch (Exception e)
                {
                    System.err.println("Can't find image" );
                }   break;
            case "D":
                try
                {
                    ImageIcon changeIcon = new ImageIcon(getClass().getResource("/resources/cal/checkOutD.png"));
                    calImg.setIcon(changeIcon);
                }
                catch (Exception e)
                {
                    System.err.println("Can't find image" );
                }   break;
            case "N":
                try
                {
                    ImageIcon changeIcon = new ImageIcon(getClass().getResource("/resources/cal/checkOutN.png"));
                    calImg.setIcon(changeIcon);
                }
                catch (Exception e)
                {
                    System.err.println("Can't find image" );
                }   break;
            default:
                break;
        }
    }
    
    private void setCalDefImg(JLabel calImg, int day)
    {
        switch (day) {
            case 1:
                try
                {
                    ImageIcon changeIcon = new ImageIcon(getClass().getResource("/resources/cal/monbg.fw.png"));
                    calImg.setIcon(changeIcon);
                }
                catch (Exception e)
                {
                    System.err.println("Can't find image" );
                }   break;
            case 2:
                try
                {
                    ImageIcon changeIcon = new ImageIcon(getClass().getResource("/resources/cal/tuebg.fw.png"));
                    calImg.setIcon(changeIcon);
                }
                catch (Exception e)
                {
                    System.err.println("Can't find image" );
                }   break;
            case 3:
                try
                {
                    ImageIcon changeIcon = new ImageIcon(getClass().getResource("/resources/cal/wedbg.fw.png"));
                    calImg.setIcon(changeIcon);
                }
                catch (Exception e)
                {
                    System.err.println("Can't find image" );
                }   break;
            case 4:
                try
                {
                    ImageIcon changeIcon = new ImageIcon(getClass().getResource("/resources/cal/thubg.fw.png"));
                    calImg.setIcon(changeIcon);
                }
                catch (Exception e)
                {
                    System.err.println("Can't find image" );
                }   break;
            case 5:
                try
                {
                    ImageIcon changeIcon = new ImageIcon(getClass().getResource("/resources/cal/fribg.fw.png"));
                    calImg.setIcon(changeIcon);
                }
                catch (Exception e)
                {
                    System.err.println("Can't find image" );
                }   break;
            case 6:
                try
                {
                    ImageIcon changeIcon = new ImageIcon(getClass().getResource("/resources/cal/satbg.fw.png"));
                    calImg.setIcon(changeIcon);
                }
                catch (Exception e)
                {
                    System.err.println("Can't find image" );
                }   break;
            case 7:
                try
                {
                    ImageIcon changeIcon = new ImageIcon(getClass().getResource("/resources/cal/sunbg.fw.png"));
                    calImg.setIcon(changeIcon);
                }
                catch (Exception e)
                {
                    System.err.println("Can't find image" );
                }   break;
            default:
                break;
        }
        
    }
*/
    @Override
    public void add(String tableName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(String tableName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    
}

