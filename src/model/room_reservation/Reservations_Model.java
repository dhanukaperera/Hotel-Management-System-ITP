
package model.room_reservation;

import app.room_reservation.Reservations_Frame;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import model.HMS;
import source.DBConnection;


public class Reservations_Model extends HMS
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
    
    int guestId;
    
    String title;
    String firstName;
    String lastName;
    String gender;
    int age;
    String contactNo;
    String email;
    int zip;
    String city;
    String state;
    String country;
    
    String totalRoomList;
    String totalMealList;
    
    public Reservations_Model()
    {
        con = DBConnection.connect();
    }
    
    // -- BEGIEN Getting Values -----------------------------------------------
    // -------------------------------------------------------------------------
    
    public void getRoomReservationId()
    {
        this.roomReservationId= generatePrimaryKey("Room Reservation ID","room_reservations","RSV");
       // System.out.println(this.roomReservationId);
    }
    
    private void getNic()
    {
        this.nic =  Reservations_Frame.txtNicPass.getText();
    }
    
    public void getRoomList()
    {
       //String roomList = r01+" "+r02+" "+r03+" "+r04+" "+r05+" "+r06+" "+r07+" "+r08+" "+r09+" "+r10+" "+r11+" "+r12+" "+r13+" "+r14+" "+r15;
       
       boolean[] arr = new boolean[]{r01,r02,r03,r04,r05,r06,r07,r08,r09,r10,r11,r12,r13,r14,r15};
       
       String RoomList= "";
       int currentRoom = 0;
       
       for(int j =0 ; j <arr.length;j++)
       {
           if(arr[j] == false)
           {
               currentRoom = j+1;
               RoomList = RoomList+ "," + currentRoom;
           }
       }
      
       if(RoomList.length()!=0)
       {
           RoomList = RoomList.substring(1,RoomList.length());
       }
       
       this.totalRoomList = RoomList;
       
       
       System.out.println(this.totalRoomList);
       
       
    }
    
    public void getArrivelDay()
    {
        this.arrivelDay = getDateFromPicker(Reservations_Frame.jdcCheckOutDate);
        System.out.println(arrivelDay);
    }
    
    private void getleavingDay()
    {
        this.leavingDay = Reservations_Frame.lblLeavingDate.getText();
    }
          
    public void getmealType()
    {
         boolean[] arr = new boolean[]{r01,r02,r03,r04,r05,r06,r07,r08,r09,r10,r11,r12,r13,r14,r15};
        
        JLabel arrMealTypes[] = new JLabel[]{
            Reservations_Frame.lblMealType_01,
            Reservations_Frame.lblMealType_02,
            Reservations_Frame.lblMealType_03,
            Reservations_Frame.lblMealType_04,
            Reservations_Frame.lblMealType_05,
            Reservations_Frame.lblMealType_06,
            Reservations_Frame.lblMealType_07,
            Reservations_Frame.lblMealType_08,
            Reservations_Frame.lblMealType_09,
            Reservations_Frame.lblMealType_10,
            Reservations_Frame.lblMealType_11,
            Reservations_Frame.lblMealType_12,
            Reservations_Frame.lblMealType_13,
            Reservations_Frame.lblMealType_14,
            Reservations_Frame.lblMealType_15
        };
        
        String mealList="";
        String currentMeal;
        
        for(int m = 0; m<arrMealTypes.length;m++)
        {
           if(arr[m] == false)
           {
                currentMeal = arrMealTypes[m].getText();
                mealList = mealList + "," + currentMeal;
           }
        }
        
        if(mealList.length()!=0)
        {
            mealList = mealList.substring(1,mealList.length());
        }
        
        this.totalMealList = mealList;
        
        System.err.println(this.totalMealList);
        
    }
    
    private void getnumOfAdults()
    {
        this.numOfAdults = Integer.parseInt(Reservations_Frame.cmbNumOfAdults.getSelectedItem().toString()) ;
    }
    
    private void getnumOfChildrent()
    {
         this.numOfChildrent = Integer.parseInt(Reservations_Frame.cmbNumOfChildren.getSelectedItem().toString()) ;
    }
    
    // *******************************************************************
    
    private void gettitle()
    {
        this.title = Reservations_Frame.cmbTitel.getSelectedItem().toString();
    }
    
    private void getfirstName()
    {
        this.firstName = Reservations_Frame.txtFirstName.getText();
    }
    
    private void getlastName()
    {
        this.lastName = Reservations_Frame.txtLastName.getText();
    }
    
    private void getgender()
    {
        this.gender = Reservations_Frame.cmbGender.getSelectedItem().toString();
    }
    
    private void getage()
    {
        this.age = Integer.parseInt(Reservations_Frame.txtAge.getText());
    }
    
    private void getcontactNo()
    {
        this.contactNo = Reservations_Frame.txtContactNo.getText();
    }
    
    private void getemail()
    {
        this.email = Reservations_Frame.txtEmail.getText();
    }
    
    private void getzip()
    {
        this.zip = Integer.parseInt(Reservations_Frame.txtZip.getText());
    }
    
    private void getcity()
    {
        this.city = Reservations_Frame.txtCity.getText();
    }
    
    private void getstate()
    {
        this.state = Reservations_Frame.txtState.getText();
    }
    
    private void getcountry()
    {
        this.country = Reservations_Frame.cmbCountry.getSelectedItem().toString();
    }
    
    
    // -- END Getting Values ---------------------------------------------------
    // -------------------------------------------------------------------------
    
    private final String reservationColList = "Room Reservation ID,Date Modified,NIC/Passport,Room No,Arrivel Day,Leaving Day,Meal Type,No of Adults,No of Children";
    private final String guestInfoColList = "NIC/Passport,Date Modified,Title,First Name,Last Name,Gender,Age,Contact No,Email,Postal/Zip Code,City,State/Province,Country";
    public void getValuesForRoomReervation()
    {
        getRoomReservationId();
        getNic();
        getRoomList();
        getArrivelDay();  
        getleavingDay();
        getmealType(); 
        getnumOfAdults();
        getnumOfChildrent();
        
        StringTokenizer stR = new StringTokenizer(this.totalRoomList,",");
        int numOfRooms = stR.countTokens();
        String[] rooms = new String[numOfRooms];
                 
        int i = 0;
        while (stR.hasMoreTokens()) 
        {
            rooms[i] = stR.nextToken();
            i++;
        }  
        
        StringTokenizer stM = new StringTokenizer(this.totalMealList,",");
        int numOfMealTypes = stM.countTokens();
        String[] meals = new String[numOfMealTypes];
        int j = 0;
        while (stM.hasMoreTokens()) 
        {
            meals[j] = stM.nextToken();
            j++;
        }  
        
        
        
        for(int r=0;r<rooms.length;r++)
        {
            String msg ="Room "+  rooms[r] + " booked Sucessfully !";
            getRoomReservationId();
            String val = this.roomReservationId + "," + getCurrentDateTime() + "," + this.nic + ","  + rooms[r] + "," + this.arrivelDay + "," + this.leavingDay + "," + meals[r] + "," + this.numOfAdults + "," + this.numOfChildrent;
            
            newAdd("room_reservations",reservationColList,val,msg);
            
            System.out.println(val);
        }
        
        //String val = this.roomReservationId + "," + getCurrentDateTime() + "," + this.nic + ","  + rooms[i] + "," + this.arrivelDay + "," + this.leavingDay + curMeal + "," + this.numOfAdults + "," + this.numOfChildrent;
       
    }
    
    public void getValuesForGuestDeatils()
    {
        getNic();
        gettitle();
        getfirstName();
        getlastName();
        getgender();
        getage();
        getcontactNo();
        getemail();
        getemail();
        getzip();
        getcity();
        getstate();
        getcountry();
        
        String vals= this.nic + "," 
                + this.getCurrentDateTime() + ","
                + this.title + "," 
                + this.firstName + ","
                + this.lastName + "," 
                + this.gender + ","
                + this.age + ","
                + this.contactNo + ","
                + this.email + ","
                + this.zip + ","
                + this.city + ","
                + this.state + ","
                + this.country;
        
       
        //vals = vals.substring(1,vals.length());
        String msg = "Guest Deatils Added Sucessfully !";
        newAdd("room_guests", guestInfoColList, vals,msg);
       
        
        System.out.println(vals);
    }
    
    public void makeReservation()
    {
        int msg = JOptionPane.showConfirmDialog(null, "Do you really want to Make this Reservation?");
        if(msg == 0)
        {
            getValuesForRoomReervation();
            getValuesForGuestDeatils();
        }
    }
    
    
    @Override
    public void add(String tableName) 
    {
     /*   System.out.println("point 1");
         getAll();
          System.out.println("point 2 ");
         // Add to Room Reservation Table
         
         String sql = "INSERT INTO "+tableName+""
                + "(`Room Guest ID`,`Date Modified`,`Room No`,`Checked In Date`,`Checked Out Date`,`Arrival Time Period`,`Leaving Time Period`,`Meal Type`,`No of Adults`,`No of Children`)"
                + " VALUES("
                + "'"+this.guestID+"',"
                + "'"+getCurrentDateTime()+"',"
                + ""+this.roomNo+","
                + "'"+this.checkInDate+"',"
                + "'"+this.checkOutDate+"',"
                + "'"+this.arrivelTimePeriod+"',"
                + "'"+this.levingTimePeriod+"',"
                + "'"+this.mealType+"',"
                + ""+this.numberOfAdults+","
                + ""+this.numberOfChilderen+""
                + ")";        

         System.out.println(sql);
         
         // Add to Guest Table
         
         String tableName2 = "room_guests";
         
         String sql2 = "INSERT INTO "+tableName2+""
                + "(`Room Guest ID`,`First Name`,`Last Name`,`Gender`,`Address`,`Contact No`,`Email`,`DOB`,`Country`)"
                + " VALUES("
                + "'"+this.guestID+"',"
                + "'"+this.firstName+"',"
                + "'"+this.lastName+"',"
                + "'"+this.gender+"',"
                + "'"+this.address+"',"
                + "'"+this.contactNo+"',"
                + "'"+this.email+"',"
                + "'"+this.dob+"',"
                + "'"+this.country+"'"
                + ")";
        
         System.out.println(sql2);
         
        try 
        {
            pst = con.prepareStatement(sql);
            pst.execute();
            try 
            {
                pst = con.prepareStatement(sql2);
                pst.execute();
                JOptionPane.showMessageDialog(null,"Recored Update Sucessfully!");
            } 
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch (Exception e) 
        {
             JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }*/
    }
    
    @Override
    public void update(String tableName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void genarateGuestID()
    {/*
         final String uuid = UUID.randomUUID().toString().replaceAll("-", "");
         
         this.guestID = "GID-"+ uuid.substring(1, 6);
         Reservations_Frame.txtGuestID.setText(this.guestID);
         JOptionPane.showMessageDialog(null,"NEW Guest ID is Generated!");
         //String cusId = 
         //System.out.println("uuid = " + uuid);
    }
    
    // Check is the dates are same
    private boolean isCheckInCheckOutSame(String pdataPickerDate)
    {
        String today = getCurrentDateTime();
        String dataPickerDate = pdataPickerDate;
        
        int todayDay = Integer.parseInt(today.substring(0, 4));
        int todayMonth =  Integer.parseInt(today.substring(5, 7));
        int todayYear =  Integer.parseInt(today.substring(8, 10));
        
        int datePickerDay = Integer.parseInt(dataPickerDate.substring(0, 4));
        int datePickerMonth = Integer.parseInt(dataPickerDate.substring(5,7));
        int datePickerYear = Integer.parseInt(dataPickerDate.substring(8,10));
        
        //if(dataPickerDate )
            
        if(todayDay ==datePickerDay && todayMonth == datePickerMonth && todayYear== datePickerYear)
        {
            JOptionPane.showMessageDialog(null,"Check in / Check out date can't be today!","Invalid Data" ,JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else
        {
             return true;
        }*/
    }
    
    public boolean isPast(String pdataPickerDate)
    {
        String today = getCurrentDateTime();
        String dataPickerDate = pdataPickerDate;
        
        int todayYear = Integer.parseInt(today.substring(0, 4));
        int todayMonth =  Integer.parseInt(today.substring(5, 7));
        int todayDay =  Integer.parseInt(today.substring(8, 10));
        
        int datePickerYear = Integer.parseInt(dataPickerDate.substring(0, 4));
        int datePickerMonth = Integer.parseInt(dataPickerDate.substring(5,7));
        int datePickerDay = Integer.parseInt(dataPickerDate.substring(8,10));
        
        if(todayDay >datePickerDay || todayMonth >  datePickerMonth || todayYear >datePickerYear )
        {
            JOptionPane.showMessageDialog(null,"Check in / Check out date can't be past date","Invalid Data" ,JOptionPane.ERROR_MESSAGE);
             return false;
           
        }
        else
        {
             return true;
        }
    }
    
    private boolean isCheckOutGreater(String pCheckinDate, String pCheckOutDate)
    {
        String checkInDay = pCheckinDate;
        String checkOutDay = pCheckOutDate;
        
        int checkInYear = Integer.parseInt(checkInDay.substring(0, 4));
        int checkInMonth =  Integer.parseInt(checkInDay.substring(5, 7));
        int xcheckInDay =  Integer.parseInt(checkInDay.substring(8, 10));
        
        int checkOutYear = Integer.parseInt(checkOutDay.substring(0, 4));
        int checkOutMonth = Integer.parseInt(checkOutDay.substring(5,7));
        int xcheckOutDay = Integer.parseInt(checkOutDay.substring(8,10));
        
        if(xcheckOutDay >= xcheckInDay )
        {
            return true;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Check out date should be grater than check in date","Invalid Data" ,JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        
    }
    
    private boolean isALongReservation(String pCheckinDate, String pCheckOutDate)
    {
        String checkInDay = pCheckinDate;
        String checkOutDay = pCheckOutDate;
        
        int checkInYear = Integer.parseInt(checkInDay.substring(0, 4));
        int checkInMonth =  Integer.parseInt(checkInDay.substring(5, 7));
        int xcheckInDay =  Integer.parseInt(checkInDay.substring(8, 10));
        
        int checkOutYear = Integer.parseInt(checkOutDay.substring(0, 4));
        int checkOutMonth = Integer.parseInt(checkOutDay.substring(5,7));
        int xcheckOutDay = Integer.parseInt(checkOutDay.substring(8,10));
        
        int reservationDuration = xcheckOutDay-xcheckInDay;
        
        if(reservationDuration >=0 && reservationDuration < 3  && checkInYear == checkOutYear && checkInMonth == checkOutMonth)
        {
            return true;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Maxmium duration guest can stay BERWEEN 0 to 3 days!","Invalid Data" ,JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    private boolean isEarlyReservation(String pCheckinDate)
    {
        String today = getCurrentDateTime();
        String checkInDay = pCheckinDate;
        
        int todayYear = Integer.parseInt(today.substring(0, 4));
        int todayMonth =  Integer.parseInt(today.substring(5, 7));
        int todayDay =  Integer.parseInt(today.substring(8, 10));
        
         int checkOutYear = Integer.parseInt(checkInDay.substring(0, 4));
        int checkOutMonth = Integer.parseInt(checkInDay.substring(5,7));
        int xcheckOutDay = Integer.parseInt(checkInDay.substring(8,10));
        
        int reservationGap = xcheckOutDay - todayDay;
        
        if(reservationGap > 3)
        {
            return true;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Room need to be booked at leaset 3 days ealier!","Invalid Data" ,JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
    }
    
    private boolean checkBirthday(String pdob)
    {
        String today = getCurrentDateTime();
        String xdob = pdob;
        
        int todayYear = Integer.parseInt(today.substring(0, 4));
        int todayMonth =  Integer.parseInt(today.substring(5, 7));
        int todayDay =  Integer.parseInt(today.substring(8, 10));
        
        int xdobYear = Integer.parseInt(xdob.substring(0, 4));
        int xdobMonth = Integer.parseInt(xdob.substring(5,7));
        int xdobDay = Integer.parseInt(xdob.substring(8,10));
        
        int yeargap = todayYear- xdobYear;
         
        if(yeargap >= 18 && yeargap <= 100)
        {
            return true;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Age should be BETEEN 18 to 100","Invalid Data" ,JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
    }
    /*
    public boolean dateValidation()
    {
        getCheckInDate();
        getCheckOutDate();
        getdob();
        if(isPast(this.checkInDate) == true && isCheckInCheckOutSame(this.checkInDate) == true && isPast(this.checkOutDate) == true  && isCheckOutGreater(this.checkInDate,this.checkOutDate) == true && isALongReservation(this.checkInDate,this.checkOutDate)== true && isEarlyReservation(this.checkInDate)== true && checkBirthday(this.dob)==true)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    /*
    private void getDate()
    {
        this.date=getDateFromPicker(Reservations_Frame.jDateChooser1);
    }
    
    public void setDate()
    {
        Reservations_Frame.jDateChooser1.setDate(StringToDate(this.date));
    }
    
    public void printDate()
    {
        getDate();
        System.out.println(this.date);
    }
    */
    
    public void defaultCountry()
    {
        Reservations_Frame.cmbCountry.setSelectedItem("Sri Lanka");
    }
    
    public void addCheckOutDate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int numOfNight = Integer.parseInt(Reservations_Frame.cmbNumOfNights.getSelectedItem().toString());
        Calendar c = Calendar.getInstance();
        
        
       c.setTime(new Date() ); // Now use today date.   
       
       Date d =Reservations_Frame.jdcCheckOutDate.getDate();
       
       c.setTime(d);
        
        c.add(Calendar.DATE,numOfNight ); // Adding 5 days
        String output = sdf.format(c.getTime());
        Reservations_Frame.lblLeavingDate.setText(output);
    }
    
    public void setCurrentDate()
    {
        Date date = new Date();
        Reservations_Frame.jdcCheckOutDate.setDate(date);
        addCheckOutDate();
    }
     /****************************************************************************************************
     * Setting Room Panels
     */
   
   
    
    public void SetRoomTiiles()
    {
        JLabel[] arrRoomTypes = new JLabel[]{
             Reservations_Frame.lblRoomType_01,
             Reservations_Frame.lblRoomType_02,
             Reservations_Frame.lblRoomType_03,
             Reservations_Frame.lblRoomType_04,
             Reservations_Frame.lblRoomType_05,
             Reservations_Frame.lblRoomType_06,
             Reservations_Frame.lblRoomType_07,
             Reservations_Frame.lblRoomType_08,
             Reservations_Frame.lblRoomType_09,
             Reservations_Frame.lblRoomType_10,
             Reservations_Frame.lblRoomType_11,
             Reservations_Frame.lblRoomType_12,
             Reservations_Frame.lblRoomType_13,
             Reservations_Frame.lblRoomType_14,
             Reservations_Frame.lblRoomType_15
         };
         
         JLabel[] arrRoomRates = new JLabel[]{
             Reservations_Frame.lblRoomRate_01,
             Reservations_Frame.lblRoomRate_02,
             Reservations_Frame.lblRoomRate_03,
             Reservations_Frame.lblRoomRate_04,
             Reservations_Frame.lblRoomRate_05,
             Reservations_Frame.lblRoomRate_06,
             Reservations_Frame.lblRoomRate_07,
             Reservations_Frame.lblRoomRate_08,
             Reservations_Frame.lblRoomRate_09,
             Reservations_Frame.lblRoomRate_10,
             Reservations_Frame.lblRoomRate_11,
             Reservations_Frame.lblRoomRate_12,
             Reservations_Frame.lblRoomRate_13,
             Reservations_Frame.lblRoomRate_14,
             Reservations_Frame.lblRoomRate_15
         };
         
          JLabel[] arrBedTypes = new JLabel[]{
              Reservations_Frame.lblBedType_01,
              Reservations_Frame.lblBedType_02,
              Reservations_Frame.lblBedType_03,
              Reservations_Frame.lblBedType_04,
              Reservations_Frame.lblBedType_05,
              Reservations_Frame.lblBedType_06,
              Reservations_Frame.lblBedType_07,
              Reservations_Frame.lblBedType_08,
              Reservations_Frame.lblBedType_09,
              Reservations_Frame.lblBedType_10,
              Reservations_Frame.lblBedType_11,
              Reservations_Frame.lblBedType_12,
              Reservations_Frame.lblBedType_13,
              Reservations_Frame.lblBedType_14,
              Reservations_Frame.lblBedType_15
          };
          
          JLabel[] arrMaxGuest = new JLabel[]{
              Reservations_Frame.lblMaxGuestCount_01,
              Reservations_Frame.lblMaxGuestCount_02,
              Reservations_Frame.lblMaxGuestCount_03,
              Reservations_Frame.lblMaxGuestCount_04,
              Reservations_Frame.lblMaxGuestCount_05,
              Reservations_Frame.lblMaxGuestCount_06,
              Reservations_Frame.lblMaxGuestCount_07,
              Reservations_Frame.lblMaxGuestCount_08,
              Reservations_Frame.lblMaxGuestCount_09,
              Reservations_Frame.lblMaxGuestCount_10,
              Reservations_Frame.lblMaxGuestCount_11,
              Reservations_Frame.lblMaxGuestCount_12,
              Reservations_Frame.lblMaxGuestCount_13,
              Reservations_Frame.lblMaxGuestCount_14,
              Reservations_Frame.lblMaxGuestCount_15
          };
        
        for (int i=0; i<arrRoomTypes.length; i++)
         {
            int r = i+1; 
            String rNo = ""+r+"";
            String curBedType = getValueFromDB("Bed Type","rooms","Room No",rNo);
            String curMaxGuest = getValueFromDB("Max Guests","rooms","Room No",rNo);
            
            arrRoomTypes[i].setText(getValueFromDB("Room Type","rooms","Room No",rNo));
            arrRoomRates[i].setText("LKR "+getValueFromDB("Rate (LKR)","room_types","Room Type",arrRoomTypes[i].getText())+".00/=");
            arrBedTypes[i].setText("Bed Types : "+curBedType);
            arrMaxGuest[i].setText("Max Guest Count : 0" +curMaxGuest  );
         }
         
    }
    
   
    //-----------------------------------------------------------------------------------------------    
    /** Setting Colors for Room Panels*/
    
    static boolean r01 = true;
    static boolean r02 = true;
    static boolean r03 = true;
    static boolean r04 = true;
    static boolean r05 = true;
    
    static boolean r06 = true;
    static boolean r07 = true;
    static boolean r08 = true;
    static boolean r09 = true;
    static boolean r10 = true;
    
    static boolean r11 = true;
    static boolean r12 = true;
    static boolean r13 = true;
    static boolean r14 = true;
    static boolean r15 = true; 
    
    private static int toatalRooms = 0;
    
    public void print()
    {
        System.out.println(r01+" "+r02+" "+r03+" "+r04+" "+r05+" "+r06+" "+r07+" "+r08+" "+r09+" "+r10+" "+r11+" "+r12+" "+r13+" "+r14+" "+r15);
    }
    
    String mealType_r01;
    String mealType_r02;
    String mealType_r03;
    String mealType_r04;
    String mealType_r05;
    String mealType_r06;
    String mealType_r07;
    String mealType_r08;
    String mealType_r09;
    String mealType_r10;
    String mealType_r11;
    String mealType_r12;
    String mealType_r13;
    String mealType_r14;
    String mealType_r15;
       
    public void setMealTypes(JRadioButton A,JRadioButton B,JRadioButton C,JRadioButton D, JLabel lblMealType)
    {
        String pCurrentType="";
         if(A.isSelected())
        {
            pCurrentType = "Room Only";
        }
        else if(B.isSelected())
        {
             pCurrentType = "Bed & Breakfast";
        }
        else if(C.isSelected())
        {
            pCurrentType = "Half Board";
        }
        else if(D.isSelected())
        {
            pCurrentType = "Full Board";
        }
        lblMealType.setText(pCurrentType);
    }
    
    public void hidePnlRoomTypes()
    {
       JPanel[] arrPnlMealTypes = new JPanel[]{
             Reservations_Frame.pnlMealType_01,
             Reservations_Frame.pnlMealType_02,
             Reservations_Frame.pnlMealType_03,
             Reservations_Frame.pnlMealType_04,
             Reservations_Frame.pnlMealType_06,
             Reservations_Frame.pnlMealType_05,
             Reservations_Frame.pnlMealType_07,
             Reservations_Frame.pnlMealType_08,
             Reservations_Frame.pnlMealType_09,
             Reservations_Frame.pnlMealType_10,
             Reservations_Frame.pnlMealType_11,
             Reservations_Frame.pnlMealType_12,
             Reservations_Frame.pnlMealType_13,
             Reservations_Frame.pnlMealType_14,
             Reservations_Frame.pnlMealType_15
         };
       
        for (JPanel arrPnlMealType : arrPnlMealTypes) {
            arrPnlMealType.setVisible(false);
        }
    }
    
    
    public void setPnlRoomNo01()
    {
        if(r01 == true)
        {
            r01 = false;
            Reservations_Frame.pnlRoom_01.setBackground(new Color(46, 204, 113));
            Reservations_Frame.rb_A_01.setEnabled(true);
            Reservations_Frame.rb_B_01.setEnabled(true);
            Reservations_Frame.rb_C_01.setEnabled(true);
            Reservations_Frame.rb_D_01.setEnabled(true);
            
            setMealTypes(Reservations_Frame.rb_A_01,Reservations_Frame.rb_B_01,Reservations_Frame.rb_C_01,Reservations_Frame.rb_D_01,Reservations_Frame.lblMealType_01);
            
            Reservations_Frame.pnlMealType_01.setVisible(true);
           
        }
        else 
        {
            r01 =  true;
            Reservations_Frame.pnlRoom_01.setBackground(new Color(255, 255, 255));
            Reservations_Frame.rb_A_01.setEnabled(false);
            Reservations_Frame.rb_B_01.setEnabled(false);
            Reservations_Frame.rb_C_01.setEnabled(false);
            Reservations_Frame.rb_D_01.setEnabled(false);
            
             Reservations_Frame.pnlMealType_01.setVisible(false);
        }
    }
    
    public void setPnlRoomNo02()
    {
        if(r02 == true)
        {
            r02 = false;
            Reservations_Frame.pnlRoom_02.setBackground(new Color(46, 204, 113));
            Reservations_Frame.rb_A_02.setEnabled(true);
            Reservations_Frame.rb_B_02.setEnabled(true);
            Reservations_Frame.rb_C_02.setEnabled(true);
            Reservations_Frame.rb_D_02.setEnabled(true);
            
            setMealTypes(Reservations_Frame.rb_A_02,Reservations_Frame.rb_B_02,Reservations_Frame.rb_C_02,Reservations_Frame.rb_D_02,Reservations_Frame.lblMealType_02);
            
            Reservations_Frame.pnlMealType_02.setVisible(true);
        }
        else 
        {
            r02 =  true;
            Reservations_Frame.pnlRoom_02.setBackground(new Color(255, 255, 255));
            Reservations_Frame.rb_A_02.setEnabled(false);
            Reservations_Frame.rb_B_02.setEnabled(false);
            Reservations_Frame.rb_C_02.setEnabled(false);
            Reservations_Frame.rb_D_02.setEnabled(false);
             
            Reservations_Frame.pnlMealType_02.setVisible(false);
        }
    }
    
    public void setPnlRoomNo03()
    {
        if(r03 == true)
        {
            r03 = false;
            Reservations_Frame.pnlRoom_03.setBackground(new Color(46, 204, 113));
            Reservations_Frame.rb_A_03.setEnabled(true);
            Reservations_Frame.rb_B_03.setEnabled(true);
            Reservations_Frame.rb_C_03.setEnabled(true);
            Reservations_Frame.rb_D_03.setEnabled(true);
            
            Reservations_Frame.pnlMealType_03.setVisible(true);
            
            setMealTypes(Reservations_Frame.rb_A_03,Reservations_Frame.rb_B_03,Reservations_Frame.rb_C_03,Reservations_Frame.rb_D_03,Reservations_Frame.lblMealType_03);
        }
        else 
        {
            r03 =  true;
            Reservations_Frame.pnlRoom_03.setBackground(new Color(255, 255, 255));
            Reservations_Frame.rb_A_03.setEnabled(false);
            Reservations_Frame.rb_B_03.setEnabled(false);
            Reservations_Frame.rb_C_03.setEnabled(false);
            Reservations_Frame.rb_D_03.setEnabled(false);
            
            Reservations_Frame.pnlMealType_03.setVisible(false);
        }
    }
    
    public void setPnlRoomNo04()
    {
        if(r04 == true)
        {
            r04 = false;
            Reservations_Frame.pnlRoom_04.setBackground(new Color(46, 204, 113));
            Reservations_Frame.rb_A_04.setEnabled(true);
            Reservations_Frame.rb_B_04.setEnabled(true);
            Reservations_Frame.rb_C_04.setEnabled(true);
            Reservations_Frame.rb_D_04.setEnabled(true);
            
             Reservations_Frame.pnlMealType_04.setVisible(true);
            
            setMealTypes(Reservations_Frame.rb_A_04,Reservations_Frame.rb_B_04,Reservations_Frame.rb_C_04,Reservations_Frame.rb_D_04,Reservations_Frame.lblMealType_04);
        }
        else 
        {
            r04 =  true;
            Reservations_Frame.pnlRoom_04.setBackground(new Color(255, 255, 255));
            Reservations_Frame.rb_A_04.setEnabled(false);
            Reservations_Frame.rb_B_04.setEnabled(false);
            Reservations_Frame.rb_C_04.setEnabled(false);
            Reservations_Frame.rb_D_04.setEnabled(false);
            
            Reservations_Frame.pnlMealType_04.setVisible(false);
            
        }
    }
    
    public void setPnlRoomNo05()
    {
        if(r05 == true)
        {
            r05 = false;
            Reservations_Frame.pnlRoom_05.setBackground(new Color(46, 204, 113));
            Reservations_Frame.rb_A_05.setEnabled(true);
            Reservations_Frame.rb_B_05.setEnabled(true);
            Reservations_Frame.rb_C_05.setEnabled(true);
            Reservations_Frame.rb_D_05.setEnabled(true);
            
            Reservations_Frame.pnlMealType_05.setVisible(true);
            
            setMealTypes(Reservations_Frame.rb_A_05,Reservations_Frame.rb_B_05,Reservations_Frame.rb_C_05,Reservations_Frame.rb_D_05,Reservations_Frame.lblMealType_05);
        }
        else 
        {
            r05 =  true;
            Reservations_Frame.pnlRoom_05.setBackground(new Color(255, 255, 255));
            Reservations_Frame.rb_A_05.setEnabled(false);
            Reservations_Frame.rb_B_05.setEnabled(false);
            Reservations_Frame.rb_C_05.setEnabled(false);
            Reservations_Frame.rb_D_05.setEnabled(false);
            
            Reservations_Frame.pnlMealType_05.setVisible(false);
        }
    }
    
    public void setPnlRoomNo06()
    {
        if(r06 == true)
        {
            r06 = false;
            Reservations_Frame.pnlRoom_06.setBackground(new Color(46, 204, 113));
            Reservations_Frame.rb_A_06.setEnabled(true);
            Reservations_Frame.rb_B_06.setEnabled(true);
            Reservations_Frame.rb_C_06.setEnabled(true);
            Reservations_Frame.rb_D_06.setEnabled(true);
            
            Reservations_Frame.pnlMealType_06.setVisible(true);
            
            setMealTypes(Reservations_Frame.rb_A_06,Reservations_Frame.rb_B_06,Reservations_Frame.rb_C_06,Reservations_Frame.rb_D_06,Reservations_Frame.lblMealType_06);
        }
        else 
        {
            r06 =  true;
            Reservations_Frame.pnlRoom_06.setBackground(new Color(255, 255, 255));
            Reservations_Frame.rb_A_06.setEnabled(false);
            Reservations_Frame.rb_B_06.setEnabled(false);
            Reservations_Frame.rb_C_06.setEnabled(false);
            Reservations_Frame.rb_D_06.setEnabled(false);
            
              Reservations_Frame.pnlMealType_06.setVisible(false);
        }
    }
    
     public void setPnlRoomNo07()
    {
        if(r07 == true)
        {
            r07 = false;
            Reservations_Frame.pnlRoom_07.setBackground(new Color(46, 204, 113));
            Reservations_Frame.rb_A_07.setEnabled(true);
            Reservations_Frame.rb_B_07.setEnabled(true);
            Reservations_Frame.rb_C_07.setEnabled(true);
            Reservations_Frame.rb_D_07.setEnabled(true);
            
              Reservations_Frame.pnlMealType_07.setVisible(true);
            
            setMealTypes(Reservations_Frame.rb_A_07,Reservations_Frame.rb_B_07,Reservations_Frame.rb_C_07,Reservations_Frame.rb_D_07,Reservations_Frame.lblMealType_07);
        }
        else 
        {
            r07 =  true;
            Reservations_Frame.pnlRoom_07.setBackground(new Color(255, 255, 255));
            Reservations_Frame.rb_A_07.setEnabled(false);
            Reservations_Frame.rb_B_07.setEnabled(false);
            Reservations_Frame.rb_C_07.setEnabled(false);
            Reservations_Frame.rb_D_07.setEnabled(false);
            
             Reservations_Frame.pnlMealType_07.setVisible(false);
            
            
        }
    }
    
     
    public void setPnlRoomNo08()
    {
        if(r08 == true)
        {
            r08 = false;
            Reservations_Frame.pnlRoom_08.setBackground(new Color(46, 204, 113));
            Reservations_Frame.rb_A_08.setEnabled(true);
            Reservations_Frame.rb_B_08.setEnabled(true);
            Reservations_Frame.rb_C_08.setEnabled(true);
            Reservations_Frame.rb_D_08.setEnabled(true);
            
             Reservations_Frame.pnlMealType_08.setVisible(true);
            
            setMealTypes(Reservations_Frame.rb_A_08,Reservations_Frame.rb_B_08,Reservations_Frame.rb_C_08,Reservations_Frame.rb_D_08,Reservations_Frame.lblMealType_08);

        }
        else 
        {
            r08 =  true;
            Reservations_Frame.pnlRoom_08.setBackground(new Color(255, 255, 255));
            Reservations_Frame.rb_A_08.setEnabled(false);
            Reservations_Frame.rb_B_08.setEnabled(false);
            Reservations_Frame.rb_C_08.setEnabled(false);
            Reservations_Frame.rb_D_08.setEnabled(false);
            
             Reservations_Frame.pnlMealType_08.setVisible(false);
        }
    }
    
     public void setPnlRoomNo09()
    {
        if(r09 == true)
        {
            r09 = false;
            Reservations_Frame.pnlRoom_09.setBackground(new Color(46, 204, 113));
            Reservations_Frame.rb_A_09.setEnabled(true);
            Reservations_Frame.rb_B_09.setEnabled(true);
            Reservations_Frame.rb_C_09.setEnabled(true);
            Reservations_Frame.rb_D_09.setEnabled(true);
            
             Reservations_Frame.pnlMealType_09.setVisible(true);
            
            setMealTypes(Reservations_Frame.rb_A_09,Reservations_Frame.rb_B_09,Reservations_Frame.rb_C_09,Reservations_Frame.rb_D_09,Reservations_Frame.lblMealType_09);
        }
        else 
        {
            r09 =  true;
            Reservations_Frame.pnlRoom_09.setBackground(new Color(255, 255, 255));
            Reservations_Frame.rb_A_09.setEnabled(false);
            Reservations_Frame.rb_B_09.setEnabled(false);
            Reservations_Frame.rb_C_09.setEnabled(false);
            Reservations_Frame.rb_D_09.setEnabled(false);
            
             Reservations_Frame.pnlMealType_09.setVisible(false);
        }
    }
     
    public void setPnlRoomNo10()
    {
        if(r10 == true)
        {
            r10 = false;
            Reservations_Frame.pnlRoom_10.setBackground(new Color(46, 204, 113));
            Reservations_Frame.rb_A_11.setEnabled(true);
            Reservations_Frame.rb_B_10.setEnabled(true);
            Reservations_Frame.rb_C_10.setEnabled(true);
            Reservations_Frame.rb_D_10.setEnabled(true);
            
             Reservations_Frame.pnlMealType_10.setVisible(true);
            
            setMealTypes(Reservations_Frame.rb_A_10,Reservations_Frame.rb_B_10,Reservations_Frame.rb_C_10,Reservations_Frame.rb_D_10,Reservations_Frame.lblMealType_10);
        }
        else 
        {
            r10 =  true;
            Reservations_Frame.pnlRoom_10.setBackground(new Color(255, 255, 255));
            Reservations_Frame.rb_A_11.setEnabled(false);
            Reservations_Frame.rb_B_10.setEnabled(false);
            Reservations_Frame.rb_C_10.setEnabled(false);
            Reservations_Frame.rb_D_10.setEnabled(false);
            
             Reservations_Frame.pnlMealType_10.setVisible(false);
        }
    }
    
    public void setPnlRoomNo11()
    {
        if(r11 == true)
        {
            r11 = false;
            Reservations_Frame.pnlRoom_11.setBackground(new Color(46, 204, 113));
            Reservations_Frame.rb_A_11.setEnabled(true);
            Reservations_Frame.rb_B_11.setEnabled(true);
            Reservations_Frame.rb_C_11.setEnabled(true);
            Reservations_Frame.rb_D_11.setEnabled(true);
            
             Reservations_Frame.pnlMealType_11.setVisible(true);
            
            setMealTypes(Reservations_Frame.rb_A_11,Reservations_Frame.rb_B_11,Reservations_Frame.rb_C_11,Reservations_Frame.rb_D_11,Reservations_Frame.lblMealType_11);
        }
        else 
        {
            r11 =  true;
            Reservations_Frame.pnlRoom_11.setBackground(new Color(255, 255, 255));
            Reservations_Frame.rb_A_11.setEnabled(false);
            Reservations_Frame.rb_B_11.setEnabled(false);
            Reservations_Frame.rb_C_11.setEnabled(false);
            Reservations_Frame.rb_D_11.setEnabled(false);
            
             Reservations_Frame.pnlMealType_11.setVisible(false);
        }
    }
    
    public void setPnlRoomNo12()
    {
        if(r12 == true)
        {
            r12 = false;
            Reservations_Frame.pnlRoom_12.setBackground(new Color(46, 204, 113));
            Reservations_Frame.rb_A_12.setEnabled(true);
            Reservations_Frame.rb_B_12.setEnabled(true);
            Reservations_Frame.rb_C_12.setEnabled(true);
            Reservations_Frame.rb_D_12.setEnabled(true);
            
             Reservations_Frame.pnlMealType_12.setVisible(true);
            
            setMealTypes(Reservations_Frame.rb_A_12,Reservations_Frame.rb_B_12,Reservations_Frame.rb_C_12,Reservations_Frame.rb_D_12,Reservations_Frame.lblMealType_12);
        }
        else 
        {
            r12 =  true;
            Reservations_Frame.pnlRoom_12.setBackground(new Color(255, 255, 255));
            Reservations_Frame.rb_A_12.setEnabled(false);
            Reservations_Frame.rb_B_12.setEnabled(false);
            Reservations_Frame.rb_C_12.setEnabled(false);
            Reservations_Frame.rb_D_12.setEnabled(false);
            
             Reservations_Frame.pnlMealType_12.setVisible(false);
        }
    }
    
    public void setPnlRoomNo13()
    {
        if(r13 == true)
        {
            r13 = false;
            Reservations_Frame.pnlRoom_13.setBackground(new Color(46, 204, 113));
            Reservations_Frame.rb_A_13.setEnabled(true);
            Reservations_Frame.rb_B_13.setEnabled(true);
            Reservations_Frame.rb_C_13.setEnabled(true);
            Reservations_Frame.rb_D_13.setEnabled(true);
            
             Reservations_Frame.pnlMealType_13.setVisible(true);
            
            setMealTypes(Reservations_Frame.rb_A_13,Reservations_Frame.rb_B_13,Reservations_Frame.rb_C_13,Reservations_Frame.rb_D_13,Reservations_Frame.lblMealType_13);
        }
        else 
        {
            r13 =  true;
            Reservations_Frame.pnlRoom_13.setBackground(new Color(255, 255, 255));
            Reservations_Frame.rb_A_13.setEnabled(false);
            Reservations_Frame.rb_B_13.setEnabled(false);
            Reservations_Frame.rb_C_13.setEnabled(false);
            Reservations_Frame.rb_D_13.setEnabled(false);
            
             Reservations_Frame.pnlMealType_13.setVisible(false);
        }
    }
    
    public void setPnlRoomNo14()
    {
        if(r14 == true)
        {
            r14 = false;
            Reservations_Frame.pnlRoom_14.setBackground(new Color(46, 204, 113));
            Reservations_Frame.rb_A_14.setEnabled(true);
            Reservations_Frame.rb_B_14.setEnabled(true);
            Reservations_Frame.rb_C_14.setEnabled(true);
            Reservations_Frame.rb_D_14.setEnabled(true);
            
             Reservations_Frame.pnlMealType_14.setVisible(true);
            
            setMealTypes(Reservations_Frame.rb_A_14,Reservations_Frame.rb_B_14,Reservations_Frame.rb_C_14,Reservations_Frame.rb_D_14,Reservations_Frame.lblMealType_14);
        }
        else 
        {
            r14 =  true;
            Reservations_Frame.pnlRoom_14.setBackground(new Color(255, 255, 255));
            Reservations_Frame.rb_A_14.setEnabled(false);
            Reservations_Frame.rb_B_14.setEnabled(false);
            Reservations_Frame.rb_C_14.setEnabled(false);
            Reservations_Frame.rb_D_14.setEnabled(false);
            
             Reservations_Frame.pnlMealType_14.setVisible(false);
        }
    }
    
    public void setPnlRoomNo15()
    {
        if(r15 == true)
        {
            r15 = false;
            Reservations_Frame.pnlRoom_15.setBackground(new Color(46, 204, 113));
            Reservations_Frame.rb_A_15.setEnabled(true);
            Reservations_Frame.rb_B_15.setEnabled(true);
            Reservations_Frame.rb_C_15.setEnabled(true);
            Reservations_Frame.rb_D_15.setEnabled(true);
            
             Reservations_Frame.pnlMealType_15.setVisible(true);
            
            setMealTypes(Reservations_Frame.rb_A_15,Reservations_Frame.rb_B_15,Reservations_Frame.rb_C_15,Reservations_Frame.rb_D_15,Reservations_Frame.lblMealType_15);
        }
        else 
        {
            r15 =  true;
            Reservations_Frame.pnlRoom_15.setBackground(new Color(255, 255, 255));
            Reservations_Frame.rb_A_15.setEnabled(false);
            Reservations_Frame.rb_B_15.setEnabled(false);
            Reservations_Frame.rb_C_15.setEnabled(false);
            Reservations_Frame.rb_D_15.setEnabled(false);
            
              Reservations_Frame.pnlMealType_15.setVisible(false);
        }
    }
    //******************************************
    
    public void getMatchingRoomNumbers()
    {
         JPanel[] arrRoomTiles = new JPanel[]{
             Reservations_Frame.pnlRoom_01,
             Reservations_Frame.pnlRoom_02,
             Reservations_Frame.pnlRoom_03,
             Reservations_Frame.pnlRoom_04,
             Reservations_Frame.pnlRoom_05,
             Reservations_Frame.pnlRoom_06,
             Reservations_Frame.pnlRoom_07,
             Reservations_Frame.pnlRoom_08,
             Reservations_Frame.pnlRoom_09,
             Reservations_Frame.pnlRoom_10,
             Reservations_Frame.pnlRoom_11,
             Reservations_Frame.pnlRoom_12,
             Reservations_Frame.pnlRoom_13,
             Reservations_Frame.pnlRoom_14,
             Reservations_Frame.pnlRoom_15
         };
          JLabel[] arrRoomTypes = new JLabel[]{
             Reservations_Frame.lblRoomType_01,
             Reservations_Frame.lblRoomType_02,
             Reservations_Frame.lblRoomType_03,
             Reservations_Frame.lblRoomType_05,
             Reservations_Frame.lblRoomType_05,
             Reservations_Frame.lblRoomType_06,
             Reservations_Frame.lblRoomType_07,
             Reservations_Frame.lblRoomType_08,
             Reservations_Frame.lblRoomType_09,
             Reservations_Frame.lblRoomType_10,
             Reservations_Frame.lblRoomType_11,
             Reservations_Frame.lblRoomType_12,
             Reservations_Frame.lblRoomType_13,
             Reservations_Frame.lblRoomType_14,
             Reservations_Frame.lblRoomType_15
         };
    
          
        
        for (JPanel arrRoomTile : arrRoomTiles) {
            arrRoomTile.setVisible(false);
        }
        
        String cmbRoomType = Reservations_Frame.cmbRoomTypes.getSelectedItem().toString();
       
        for(int i=0;i<arrRoomTiles.length;i++)
        {
            if(cmbRoomType.equalsIgnoreCase(arrRoomTypes[i].getText()))
            {
                arrRoomTiles[i].setVisible(true);
            }
            else if(cmbRoomType.equalsIgnoreCase("All"))
            {
                 for (JPanel arrRoomTile : arrRoomTiles) {
                    arrRoomTile.setVisible(true);
        }
            }
        }
      
    }
    
  
    
}
//*/