package model.restaurant_management;

/**
 *
 * @author Sachin
 */

import app.finance_management.Incomes_Management_Frame;
import app.restaurant_management.Dine_In_Bill_Frame;
import static app.restaurant_management.Dine_In_Bill_Frame.*;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import model.HMS;
import source.DBConnection;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.finance_management.Incomes_Management_Model;
import net.proteanit.sql.DbUtils;
import static reports.iReport.PROJECT_PATH;
import reports.iReportView;
import source.Validation;


public class Dine_In_Bill_Model extends HMS{
    
    All_Bill_Details_Model allBillDetails = new All_Bill_Details_Model();
    
    Validation val = new Validation();
    
    private String Type;
    private String Name;
    private int qty;
    private float price;
   // private String pool;
    private String Person;
    private int count;
   // private String Dinein;
    private float ServiceCharges;
    private float Total;
    private float Discount;
    private float PaidAmount;
    private float Balance;
    private float rateofFOD;
    private String tempTypeLoad; //Loading the food type to the setter method
    private int primarynumber;
    private int Tablenumber;
    private String gennewID;
    private String FOB_ID;
    private boolean allow; //alow a new primary key to be generated
    private int primarykeynumber;
   private String DiscountReason;
    
      public Dine_In_Bill_Model ()
      {
        con = DBConnection.connect();
        
      this.Type=null;
      this.Name=null;
      this.qty=0;
      this.price=0;
     // this.pool=null;
      this.Person=null;
      this.count=1;
   //   this.Dinein=null;
      this.ServiceCharges=0;
      this.Total=0;
      this.Discount=0;
      this.PaidAmount=0;
      this.Balance=0;
      this.rateofFOD=0;
      this.allow =true;
      this.primarykeynumber = 0;
      this.DiscountReason = "";
      
    }
      
//getting the primary key to the delete button method////////////////////////////////////////////////////////////////////////
      
       public void getPrimaryKey()
    {
        String number = Dine_In_Bill_Frame.tbltempDineIn.getValueAt(getSelectedRow(Dine_In_Bill_Frame.tbltempDineIn), 0).toString();
        this.primarynumber = Integer.parseInt(number);
       
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////      

//table load method//////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void tableloadmethod()
    {
        String sql = "SELECT * FROM dinein_customer_issuebill";
        
        try 
        {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery(); 
            
            tbltempDineIn.setModel(DbUtils.resultSetToTableModel(rs));
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    
    //getters//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
    private void getType() {this.Type = Dine_In_Bill_Frame.cmbType.getSelectedItem().toString();}
    
    private void getName() {this.Name = Dine_In_Bill_Frame.cmbName.getSelectedItem().toString();}
    
    private void getqty() {this.qty = Integer.parseInt(Dine_In_Bill_Frame.txtQTY.getText());}
    
    private void getprice() {this.price = Float.parseFloat(Dine_In_Bill_Frame.txtPrice.getText()) ;}
    
    private void getperson() {this.Person = Dine_In_Bill_Frame.cmbPerson.getSelectedItem().toString();}
    
    private void getcount() {this.count = Integer.parseInt(Dine_In_Bill_Frame.txtcount.getText());}
    
    private void gettablenumber() {this.Tablenumber = Integer.parseInt(Dine_In_Bill_Frame.cmbTableNO.getSelectedItem().toString());}
    
    private void getServicecharges() {this.ServiceCharges = Float.parseFloat(Dine_In_Bill_Frame.txtServiceCharges.getText()) ;}
    
    private void getTotal() {this.Total = Float.parseFloat(Dine_In_Bill_Frame.txtTotal.getText()) ;}
    
    private void getDiscount() {this.DiscountReason = Dine_In_Bill_Frame.cmbDiscount.getSelectedItem().toString();}

    private void getpaidamount() {this.PaidAmount = Float.parseFloat(Dine_In_Bill_Frame.txtPaidAmount.getText()) ;}

    private void getbalance() {this.Balance = Float.parseFloat(Dine_In_Bill_Frame.txtBalance.getText()) ;}
 
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

    
 //setter//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
   public void setTableNo() { Dine_In_Bill_Frame.cmbTableNO.setSelectedItem(Dine_In_Bill_Frame.tbltempDineIn.getValueAt(getSelectedRow(Dine_In_Bill_Frame.tbltempDineIn), 1).toString());}
  
   public void setname() { Dine_In_Bill_Frame.cmbName.setSelectedItem(Dine_In_Bill_Frame.tbltempDineIn.getValueAt(getSelectedRow(Dine_In_Bill_Frame.tbltempDineIn), 2).toString());}

   private void setqty() { Dine_In_Bill_Frame.txtQTY.setText(Dine_In_Bill_Frame.tbltempDineIn.getValueAt(getSelectedRow(Dine_In_Bill_Frame.tbltempDineIn), 3).toString());}

   private void setprice() { Dine_In_Bill_Frame.txtPrice.setText(Dine_In_Bill_Frame.tbltempDineIn.getValueAt(getSelectedRow(Dine_In_Bill_Frame.tbltempDineIn), 5).toString());}
   
   private void setpool()
   {       
       
       try{
        checkPool.setSelected(false);
        String check = Dine_In_Bill_Frame.tbltempDineIn.getValueAt(getSelectedRow(Dine_In_Bill_Frame.tbltempDineIn), 2).toString();
       
        if(check.equals("Pool - Adult")||check.equals("Pool - Child"))
        {   
            clearbeforegenerate();
            checkPool.setEnabled(false);
            checkPool.setSelected(true);
            txtQTY.setEnabled(false);
            cmbType.setEnabled(false);
            cmbName.setEnabled(false);
            
             String poolname = Dine_In_Bill_Frame.tbltempDineIn.getValueAt(getSelectedRow(Dine_In_Bill_Frame.tbltempDineIn), 2).toString();
             
            cmbPerson.setEnabled(true);
            txtcount.setEnabled(true);
             
            cmbPerson.setSelectedItem(poolname);
        }
        else
        {
            checkPool.setEnabled(true);
            checkPool.setSelected(false);
            cmbType.setEnabled(true);
            cmbName.setEnabled(true);
            txtQTY.setEnabled(true);
            
            cmbPerson.setEnabled(false);
            txtcount.setEnabled(false);
        }
   }
   
   catch(Exception e)
   {
       JOptionPane.showMessageDialog(null,e);
   }
        
       
   }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   //Loading the type of the food/Drink//
   
    public void loadtype()
     {
         try 
        {
        this.Name = Dine_In_Bill_Frame.tbltempDineIn.getValueAt(getSelectedRow(Dine_In_Bill_Frame.tbltempDineIn), 2).toString();
         
        
            if(this.Name.equals("Pool - Adult")||this.Name.equals("Pool - Child"))    
            {}
            else
            {
                String sql = "SELECT `Type` FROM `food_drink_info` WHERE `Name`='"+this.Name+"'";
                
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                if(rs.next())
                {
                    this.tempTypeLoad =  rs.getString("Type"); 
                    
                }           

            } 
        }
         catch (Exception e) 
        {
             JOptionPane.showMessageDialog(null,e);
        }
          
          //setting the combox value
          Dine_In_Bill_Frame.cmbType.setSelectedItem(this.tempTypeLoad);
        
     }
   
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
  //loading table numbers/////////////////////////////////////////////////////////////////////////////////////
    
    public void loadtablenumbers()
    {
        try {
            
            String sql = "SELECT `Table No` from restaurant_settings";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
           
            Dine_In_Bill_Frame.cmbTableNO.removeAllItems(); 
           
            while(rs.next())
            {
                int tableno =  rs.getInt("Table No"); 
                Dine_In_Bill_Frame.cmbTableNO.addItem(tableno);
            }           
        } 
         
         catch (Exception e) 
        {
             JOptionPane.showMessageDialog(null,e);
        }
    }
    
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////  
   
   public void setAll()
     {
         setTableNo();
         setname();
         setqty();
         setprice();
         loadtype();
         setpool();
     }
    
   //Load Names when Type is selected//////////////////////////////////////////////////////////////////////////////////////////////
    
    public void LoadName()
    {
        getType();
        
         try {
            
            String sql = "SELECT `Name` FROM `food_drink_info` WHERE Type='"+this.Type+"' AND `Available`='YES'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
           
            Dine_In_Bill_Frame.cmbName.removeAllItems(); 
           
            while(rs.next())
            {
                String name =  rs.getString("Name"); 
                Dine_In_Bill_Frame.cmbName.addItem(name);
            }           
        } 
         
         catch (Exception e) 
        {
             JOptionPane.showMessageDialog(null,e);
        }
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Load Price when Food name is selected and claculate the value///////////////////////////////////////////////////////////////////////////////////////
     public void LoadPrice()
    {
        getType();
        getName();
        getqty();
        
         try {
            
            String sql = "SELECT `Price` FROM `food_drink_info` WHERE Type='"+this.Type+"' AND Name='"+this.Name+"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
           
            if(rs.next())
            {
                Float price =  rs.getFloat("Price"); 
                this.price = this.qty * price;
                
                float TotalPrice = this.price;
                String FinalPrice  = String.valueOf(TotalPrice);
                
                Dine_In_Bill_Frame.txtPrice.setText(FinalPrice);
            }           
        } 
         
         catch (Exception e) 
        {
             JOptionPane.showMessageDialog(null,e);
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Load the rate of a Food or Drink///////////////////////////////////////////////////////////////////////////////////////////

     public void loadrate()
     {
         getType();
         getName();
         
          try {
            
            String sql = "SELECT `Price` FROM `food_drink_info` WHERE Type='"+this.Type+"' AND Name='"+this.Name+"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if(rs.next())
            {
                this.rateofFOD =  rs.getFloat("Price"); 
            }           
        } 
         
         catch (Exception e) 
        {
             JOptionPane.showMessageDialog(null,e);
        }
     }
     
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     

//Loding the FOB ID when sending to the all bill details///////////////////////////////////////////////////////////////////
     
      public void loadFOBID()
     {
         getType();
         getName();
         
          try {
            
            String sql = "SELECT `FOB ID` FROM `food_drink_info` WHERE Type='"+this.Type+"' AND Name='"+this.Name+"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if(rs.next())
            {
                this.FOB_ID =  rs.getString("FOB ID"); 
            }           
        } 
         
         catch (Exception e) 
        {
             JOptionPane.showMessageDialog(null,e);
        }
     } 
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          
 /////Generate Primary key////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void genprimarykey()
    {
        int count=0;

          String getcount = "SELECT Number FROM restaurant_bill ORDER BY Number DESC LIMIT 1";
        
        try 
        {
            pst = con.prepareStatement(getcount);
            rs = pst.executeQuery();
            
            if(rs.next())
            {
                    count = rs.getInt("Number");
            }
        }
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        //adding a 1 and adding 0 value infront
        count = count+1;
        String formatted = String.format("%03d", count);
        
        //Creating the final ID
        this.gennewID = "BILL-"+formatted;
        
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
     
//Calculate the totlal///////////////////////////////////////////////////////////////////////////////////////////////////
    public void calctotal(int tableno)
    {
        
          String getcount = "SELECT SUM(Value) FROM dinein_customer_issuebill where `Table No` ='"+tableno+"'";
        
        try 
        {
            pst = con.prepareStatement(getcount);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                    this.Total = rs.getFloat("SUM(Value)");
                    
            }
        }
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        Dine_In_Bill_Frame.txtTotal.setText(Float.toString(this.Total));
    }

//get the pool details/////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void pooldetails()
    {
        getcount();
        
        if(cmbPerson.getSelectedItem()=="Pool - Adult")
        {
          String getcount = "SELECT `Pool Charges` FROM restaurant_settings where `Number` =1";
        
        try 
        {
            pst = con.prepareStatement(getcount);
            rs = pst.executeQuery();
            
            if(rs.next())
            {
                    this.rateofFOD = rs.getFloat("Pool Charges");
                    
            }
        }
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }
        }
        
        if(cmbPerson.getSelectedItem()=="Pool - Child")
        {
                 String getcount = "SELECT `Pool Charges` FROM restaurant_settings where `Number` =2";

               try 
               {
                   pst = con.prepareStatement(getcount);
                   rs = pst.executeQuery();

                   if(rs.next())
                   {
                           this.rateofFOD = rs.getFloat("Pool Charges");

                   }
               }

               catch (Exception e) 
               {
                   JOptionPane.showMessageDialog(null,e);
               }
               
        }
        
        this.price = this.rateofFOD * this.count;
    }
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
     
    @Override
    public void add(String tableName) {
       
         //Add food & Drink details to the bill//////////////////////////////////////
        this.primarykeynumber++;
        
        if(checkPool.isSelected()==false)
        {
            try 
            {
            gettablenumber();
            getName();
            getqty();
            loadrate();

            this.price = Float.parseFloat(txtPrice.getText());

            String sql = "INSERT INTO "+tableName+""
                    + "(`Number`,`Table No`,`Name`, `QTY`,`Rate`,`Value`)"
                    + " VALUES("
                    + ""+this.primarykeynumber+","
                    + ""+this.Tablenumber+","
                    +"'"+this.Name+"',"
                    + "'"+this.qty+"',"
                    + ""+this.rateofFOD+","
                    + ""+this.price+""
                    + ")";

                pst = con.prepareStatement(sql);
                pst.execute();
                tableloadmethod();  
                JOptionPane.showMessageDialog(null,"Added Successfully","Successful Message",JOptionPane.INFORMATION_MESSAGE);
                
                 calctotal(this.Tablenumber);

                
                //inserting bill information to the all bill forms
                addtoallbills(this.Name,this.qty);
                allBillDetails.restaurantorderstableloadmethod();
                
                this.count++; //passing the number to add in the all bill details form

            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        
       
        else
        {
            try 
            {
                
            gettablenumber();
            
            this.Name = cmbPerson.getSelectedItem().toString();
            this.qty = Integer.parseInt(txtcount.getText());
            
            //getting the pool prices from the settings table/////
            pooldetails();

            String sql = "INSERT INTO "+tableName+""
                    + "(`Number`,`Table No`,`Name`, `QTY`,`Rate`,`Value`)"
                    + " VALUES("
                    + ""+this.primarykeynumber+","
                    + ""+this.Tablenumber+","
                    +"'"+this.Name+"',"
                    + "'"+this.qty+"',"
                    + ""+this.rateofFOD+","
                    + ""+this.price+""
                    + ")";

                pst = con.prepareStatement(sql);
                pst.execute();
                tableloadmethod();  
                JOptionPane.showMessageDialog(null,"Added Successfully","Successful Message",JOptionPane.INFORMATION_MESSAGE);
                
                 calctotal(this.Tablenumber);
                 
//                 this.Total = this.Total + this.price;
//                    txtTotal.setText(String.valueOf(this.Total));
                
                 addtoallbills(this.Name,this.qty);
                 allBillDetails.restaurantorderstableloadmethod();
                
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        
         clearbeforegenerate();
        

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
    
//Add food & Drink Details to All bill details when add button pressed//////////////////////////////////////////////////////////////////////////////
    public void addtoallbills(String name, int count)
    {
        try 
            { 
                
               if(this.allow == true)
             { 
                 genprimarykey();
             }
              
              if(checkPool.isSelected()==false)
              {
                loadFOBID();
                getType();
                getName();
                getqty();
              }
              else
              {
                  this.FOB_ID = "-";
                  this.Type = "-";
                  this.Name = name;
                  this.qty = count;
              }
              
            gettablenumber();

            String sql = "INSERT INTO restaurant_bill"
                    + "(`Date Modified`,`Bill ID`,`Count`, `FOB ID`, `Type`, `Name`, `Qty`, `Rate`, `Value`,`Table NO`)"
                    + " VALUES("
                    + "'"+getCurrentDateTime()+"',"
                    + "'"+this.gennewID+"',"
                    + ""+this.primarykeynumber+","
                    + "'"+this.FOB_ID+"',"
                    + "'"+this.Type+"',"
                    + "'"+this.Name+"',"
                    + ""+this.qty+","
                    + ""+this.rateofFOD+","
                    + ""+this.price+","
                    + ""+this.Tablenumber+""
                    + ")";
            
                
                pst = con.prepareStatement(sql);
                pst.execute();
                
                
                allBillDetails.restaurantorderstableloadmethod();
    
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        
        this.allow = false;
    }
        
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    

    @Override
    public void update(String tableName) {
        
      int primarykey=0;
     
          try 
        {
         getName();
         getqty();
         loadrate();
         getprice();
         gettablenumber();
         
        //changing the total price/////////////////
        
        String Valueupdate = Dine_In_Bill_Frame.tbltempDineIn.getValueAt(getSelectedRow(Dine_In_Bill_Frame.tbltempDineIn), 5).toString();
        float valueintupdate = Float.parseFloat(Valueupdate);
        this.Total = this.Total - valueintupdate;
        
         //////////////////////////////////////////
         
         
        
        String Number = Dine_In_Bill_Frame.tbltempDineIn.getValueAt(getSelectedRow(Dine_In_Bill_Frame.tbltempDineIn), 0).toString();
        primarykey = Integer.parseInt(Number);
        
        String sql = "UPDATE "+tableName+""
                + " SET `Table No` = "+"" + this.Tablenumber + ","
                + "`Name` = '" + this.Name + "',"
                + "`QTY` = '" + this.qty + "',"
                + "`RATE`=" + this.rateofFOD + ","
                + "`Value`='" + this.price + "'"
                + "WHERE `Number` = '" +primarykey+ "'";
        
                pst = con.prepareStatement(sql);
                pst.execute();
               tableloadmethod(); 
               
               calctotal(this.Tablenumber);
                
               
        } 
          
        catch (Exception e) 
        {
               
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }

           try 
        {
        
         loadFOBID();
         getType();
         gettablenumber();

        String sql = "UPDATE restaurant_bill"
                + " SET `Date Modified` ='" + getCurrentDateTime() + "',"
                + "`FOB ID` = '" + this.FOB_ID + "',"
                + "`Type`='"+ this.Type + "',"
                + "`Name`='" + this.Name + "',"
                + "`QTY`=" + this.qty + ","
                + "`Rate`=" + this.rateofFOD + ","
                + "`Value`=" + this.price + ","
                + "`Table NO`=" + this.Tablenumber + ""
                + " WHERE `Count` = '" +primarykey+ "' and `Table NO`= "+this.Tablenumber+" and `Bill ID` = '"+this.gennewID+"'";
    
                pst = con.prepareStatement(sql);
                pst.execute();
                tableloadmethod(); 
                JOptionPane.showMessageDialog(null,"Updated","Successful Message",JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (Exception e) 
        {
               
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
          
           clearbeforegenerate();
          allBillDetails.restaurantorderstableloadmethod();
          
          
    }
    
    //update only pool details/////////////////////////////////////////////////////////////////////////////////////////
    
    public void updatetype2()
    {
      
        int primarykey=0;
           try 
        {
         
         gettablenumber();
            
            this.Name = cmbPerson.getSelectedItem().toString();
            this.qty = Integer.parseInt(txtcount.getText());
            
            //getting the pool prices from the settings table/////
            pooldetails();
            
              
        //changing the total price/////////////////
        
        String Valueupdate = Dine_In_Bill_Frame.tbltempDineIn.getValueAt(getSelectedRow(Dine_In_Bill_Frame.tbltempDineIn), 5).toString();
        float valueintupdate = Float.parseFloat(Valueupdate);
        this.Total = this.Total - valueintupdate;
        
         //////////////////////////////////////////

        
        String Number = Dine_In_Bill_Frame.tbltempDineIn.getValueAt(getSelectedRow(Dine_In_Bill_Frame.tbltempDineIn), 0).toString();
        primarykey = Integer.parseInt(Number);
        
        String sql = "UPDATE dinein_customer_issuebill"
                + " SET `Table No` = "+"" + this.Tablenumber + ","
                + "`Name` = '" + this.Name + "',"
                + "`QTY` = '" + this.qty + "',"
                + "`RATE`=" + this.rateofFOD + ","
                + "`Value`='" + this.price + "'"
                + "WHERE `Number` = '" +primarykey+ "'";
        
                pst = con.prepareStatement(sql);
                pst.execute();
               tableloadmethod(); 
               
               calctotal(this.Tablenumber);
               
        } 
        catch (Exception e) 
        {
               
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
           
           
              try 
        {
            
       
                  this.FOB_ID = "-";
                  this.Type = "-";

        String sql = "UPDATE restaurant_bill"
                + " SET `Date Modified` ='" + getCurrentDateTime() + "',"
                + "`FOB ID` = '" + this.FOB_ID + "',"
                + "`Type`='"+ this.Type + "',"
                + "`Name`='" + this.Name + "',"
                + "`QTY`=" + this.qty + ","
                + "`Rate`=" + this.rateofFOD + ","
                + "`Value`=" + this.price + ","
                + "`Table NO`=" + this.Tablenumber + ""
                + " WHERE `Count` = '" +primarykey+ "' and `Table NO`= "+this.Tablenumber+" and `Bill ID` = '"+this.gennewID+"'";
        
                pst = con.prepareStatement(sql);
                pst.execute();
                tableloadmethod(); 
                JOptionPane.showMessageDialog(null,"Updated Successfully","Successful Message",JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (Exception e) 
        {
               
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
          clearbeforegenerate();
          allBillDetails.restaurantorderstableloadmethod();
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //Delete Method////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void deleterow(String tableName) {
        
        getPrimaryKey();
        
        try {
            
            String sql = "SELECT `Value` FROM `dinein_customer_issuebill` WHERE Number='"+this.primarynumber+"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if(rs.next())
            {
                this.price =  rs.getFloat("Value"); 
            }           
        } 
         
         catch (Exception e) 
        {
             JOptionPane.showMessageDialog(null,e);
        }
        
        this.Total = this.Total - this.price;
        txtTotal.setText(String.valueOf(this.Total));
        
        
        String sql = "DELETE FROM "+tableName+" "
                + "WHERE Number ='"+this.primarynumber+"'";
       
        try 
        {
             pst = con.prepareStatement(sql);
             pst.execute();
             JOptionPane.showMessageDialog(null,"Record DELETED Successfully");
        } 
        catch (SQLException | HeadlessException e) 
        {
             JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
        clearbeforegenerate();
    }  
    
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    

    
//clear method begore bill generate/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
    public void clearbeforegenerate()
    {
        txtQTY.setText("");
        //checkPool.setSelected(false);
        txtPrice.setText("");
        txtcount.setText("");
   }
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Clear method after bill generate/////////////////////////////////////////////////////////////////////////////////////
    
    public void clearaftergenerate()
    {
        txtQTY.setText("");
        checkPool.setSelected(false);
        txtPrice.setText("");
        txtcount.setText("");
        txtServiceCharges.setText("");
        txtTotal.setText("");
        txtPaidAmount.setText("");
        txtBalance.setText("");
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
//calculate service charges////////////////////////////////////////////////////////////////////////////////////////////
    
    public void calcservicecharges()
    {
        getTotal();
        this.ServiceCharges = ((this.Total*10)/100);
    }
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

 //Delete all the details formt the customer Bill//////////////////////////////////////////////////////////////////////
    
    public void DeleteCustomerIssueBill()
    {
//        gettablenumber();
        
//        try 
//        { 
//            String sql = "DELETE FROM dinein_customer_issuebill where `Table No`="+this.Tablenumber+"";        
//            pst = con.prepareStatement(sql);
//            pst.execute();                  
//            }
//        
//             catch (Exception e) 
//             {
//               JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
//             }      
        
          try 
        { 
            String sql = "Truncate table dinein_customer_issuebill";        
            pst = con.prepareStatement(sql);
            pst.execute();                  
            }
        
             catch (Exception e) 
             {
               JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
             }      
        
        
  
        tableloadmethod();
    }
   
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    

//Load Discount////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void loadDiscount()
    {
         try {
            
            String sql = "SELECT `Type` FROM `discount_details`";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
           
            Dine_In_Bill_Frame.cmbDiscount.removeAllItems(); 
           
            while(rs.next())
            {
                String discount =  rs.getString("Type"); 
                Dine_In_Bill_Frame.cmbDiscount.addItem(discount);
            }           
        } 
         
         catch (Exception e) 
        {
             JOptionPane.showMessageDialog(null,e);
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
    
//get the discount amount//////////////////////////////////////////////////////////////////////////////////////////////
    
    public void getdiscountamount()
    {
        getDiscount();
        
        try {
            
            String sql = "SELECT `Percentage` FROM `discount_details` where Type ='"+this.DiscountReason+"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
           
            if(rs.next())
            {
                this.Discount =  rs.getFloat("Percentage"); 
            }           
            
        } 
         
         catch (Exception e) 
        {
             JOptionPane.showMessageDialog(null,e);
        }
        
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
        
    
    
//Generate Bill Method/////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void generateBill()
    {
        float Discountvalue = 0, PaidAmountValue,Balance;
        boolean paid = false;
        
        if(txtTotal.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Add Items to the Bill","Bill Generation Error",JOptionPane.ERROR_MESSAGE);
        }
        
        else
        {
            calcservicecharges();
            this.Total = this.Total + this.ServiceCharges;
        
                    if(checkadddiscount.isSelected())
                    {
                        getdiscountamount();
                        this.Total = this.Total - (this.Total*(this.Discount/100));
                        JOptionPane.showMessageDialog(null,"Discount : "+this.Discount+" %");
                    }    
                
                    txtServiceCharges.setText(Float.toString(this.ServiceCharges));
                   
                //Displaying the Total price
                JOptionPane.showMessageDialog(null,"Total Price: "+this.Total,"Total",JOptionPane.INFORMATION_MESSAGE);
                
                //loop to enter values until the crrect paid amount is enetered
                while(paid == false)
                {
                String paidAmount = JOptionPane.showInputDialog("Enter the Paid Amount (RS.)");

                if (!paidAmount.matches("[0-9]+")) 
                    {   
                        JOptionPane.showMessageDialog(null,"Input Valid Numbers(%)");
                        paid = false;
                        continue;   
                    }
                
                txtPaidAmount.setText(paidAmount);
                
                PaidAmountValue = Float.parseFloat(paidAmount);
                
                 float bal = this.Total - PaidAmountValue;
  
                    

                if(this.Total<=PaidAmountValue)
                {
                    Balance = this.Total - PaidAmountValue;
                    new DecimalFormat("##.##").format(Balance); //Converting to two decimal points
                    Balance = Math.abs(Balance); //converting to a positive value
                    
                    txtBalance.setText(Float.toString(Balance));
                    
                    JOptionPane.showMessageDialog(null,"Customer Balance is : "+Balance,"Balance",JOptionPane.INFORMATION_MESSAGE);
                    paid = true; // to stop the while loop
                    
                     try{
                         
                    getTotal();
                    gettablenumber();

                               String sql = "INSERT INTO restaurant_bill"
                               + "(`Date Modified`, `Bill ID`,`Table NO`,`Service Charges`,`Total`, `Discount`, `Paid Amount`, `Balance`)"
                               + " VALUES("
                               + "'"+getCurrentDateTime()+"',"
                               + "'"+this.gennewID+"',"
                               + "'"+this.Tablenumber+"',"        
                               + "'"+this.ServiceCharges+"',"       
                               + ""+this.Total+","
                               + ""+Discountvalue+","
                               + ""+PaidAmountValue+","
                               + ""+Balance+""
                               + ")";
                               
                                pst = con.prepareStatement(sql);
                                pst.execute();
                                
                                insertdiscount(Discountvalue); //inserting the discount values to the customer issue table
                                insertservicecharge(); //inserting the service charge value tot he customer issue table
                                inserttotal(); //insertin the total to the customer issue table
                                insertpaidamount(PaidAmountValue);
                                insertbalance(Balance); //Inserting the balance amount to the customer table
                           
                             //  transferincometable();
                               
                               iReportView r = new iReportView(PROJECT_PATH+"\\restaurant_management\\DineInCustomerBill.jasper");
                               r.setVisible(true);
                                
                                
                               allBillDetails.restaurantorderstableloadmethod();
                               DeleteCustomerIssueBill();
                               this.allow = true;
                               
                               this.primarykeynumber=0;
                               clearaftergenerate();
                       }
                       catch (Exception e) 
                       {
                           JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
                       }
 
                }

                    else
                    {
                        JOptionPane.showMessageDialog(null,"Please enter an appropiate amount!","Error",JOptionPane.ERROR_MESSAGE);
                        paid=false; //to go on the while loop
                    }

            }
        }
    }
    
//Delete all the details from the allbilldetails table///////////////////////////////////////////////////////////////
    
    public void cancelallbilldetails()
    {
        try 
        { 
            String sql = "DELETE FROM  restaurant_bill where `Bill ID`='"+this.gennewID+"'";   
         
            pst = con.prepareStatement(sql);
            pst.execute();           
            
         }
        
             catch (Exception e) 
             {
               JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
             }      
        
         this.primarykeynumber=0;
        
        tableloadmethod();
        
        clearaftergenerate();
        allBillDetails.restaurantorderstableloadmethod();
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    
//insert discount/////////////////////////////////////////////////////////////////////////////////////////////////////
  
    public void insertdiscount(float Discountvalue)
   {
    try 
    { 
        this.count++;
        this.Name="Discount (%)";

       String sql = "INSERT INTO dinein_customer_issuebill"
                    + "(`Number`,`Name`,`Value`)"
                    + " VALUES("
                    + ""+this.count+","
                    + "'"+this.Name+"',"
                    + ""+Discountvalue+""
                    + ")";
       
            pst = con.prepareStatement(sql);
            pst.execute();
                           
     }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
   }
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
 
//inserting the service charge value to the customer issue bill/////////////////////////////////////////////////////
    
    public void insertservicecharge()
    {
         this.count++;
        this.Name="Service Charge (RS.)";
        try{
       String sql = "INSERT INTO dinein_customer_issuebill"
                    + "(`Number`,`Name`,`Value`)"
                    + " VALUES("
                    + ""+this.count+","
                    + "'"+this.Name+"',"
                    + ""+this.ServiceCharges+""
                    + ")";
       
            pst = con.prepareStatement(sql);
            pst.execute();
                           
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
    //insert total to the customer issue table///////////////////////////////////////////////////////////////////////////
    public void inserttotal()
   {
    try 
    { 
        this.count++;
        this.Name="Total (RS.)";

       String sql = "INSERT INTO dinein_customer_issuebill"
                    + "(`Number`,`Name`,`Value`)"
                    + " VALUES("
                    + ""+this.count+","
                    + "'"+this.Name+"',"
                    + ""+this.Total+""
                    + ")";
       
            pst = con.prepareStatement(sql);
            pst.execute();
                           
     }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
   }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
    //Inserting the paid amount to the cusotmer issue bill////////////////////////////////////////////////////////////////////
    
      public void insertpaidamount(float paidamount)
   {
    try 
    { 
        this.count++;
        this.Name="Paid Amount (RS.)";

       String sql = "INSERT INTO dinein_customer_issuebill"
                    + "(`Number`,`Name`,`Value`)"
                    + " VALUES("
                    + ""+this.count+","
                    + "'"+this.Name+"',"
                    + ""+paidamount+""
                    + ")";
       
            pst = con.prepareStatement(sql);
            pst.execute();
                           
     }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
   }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    

//inserting the Balance amount to the customer isse table//////////////////////////////////////////////////////////////////
       public void insertbalance(float balance)
   {
    try 
    { 
        this.count++;
        this.Name="Balance (RS.)";

       String sql = "INSERT INTO dinein_customer_issuebill"
                    + "(`Number`,`Name`,`Value`)"
                    + " VALUES("
                    + ""+this.count+","
                    + "'"+this.Name+"',"
                    + ""+balance+""
                    + ")";
       
            pst = con.prepareStatement(sql);
            pst.execute();
                           
     }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
   }
      
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
 
//    public void gentransferincomeprimarykey()
//    {
//        int count=0;
//
//          String getcount = "SELECT Number FROM incomes_management ORDER BY Number DESC LIMIT 1";
//        
//        try 
//        {
//            pst = con.prepareStatement(getcount);
//            rs = pst.executeQuery();
//            
//            if(rs.next())
//            {
//                    count = rs.getInt("Number");
//            }
//        }
//        
//        catch (Exception e) 
//        {
//            JOptionPane.showMessageDialog(null,e);
//        }
//        
//        //adding a 1 and adding 0 value infront
//        count = count+1;
//        String formatted = String.format("%03d", count);
//        
//        //Creating the final ID
//        this.gennewID = "BILL-"+formatted;
//        
//    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
//Transfer income to the financial department///////////////////////////////////////////////////////////////////////////
    
    public void transferincometable()
    {
       
        Incomes_Management_Model incomes = new Incomes_Management_Model();
      
        String colname = "Income ID";
        String tablename = "incomes_management";
        String primaryval = "INM";
 
        try 
        { 
            String income = this.gennewID+" Dine In Orders";
            String Department = "Restaurant";

            String sql = "INSERT INTO `incomes_management`"
            + "(`Income ID`,`Income`,`Date Modified`,`Amount`,`Department`)"
            + " VALUES("
            + "'"+generatePrimaryKey(colname,tablename,primaryval)+"',"
            + "'"+income+"',"
            + "'"+getCurrentDateTime()+"',"
            + ""+this.Total+","
            + "'"+Department+"'"
            + ")";
            
            pst = con.prepareStatement(sql);
            pst.execute();
        }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        
        incomes.loadTable(tablename,Incomes_Management_Frame.tblIncomes);
        
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
 
    
    /////searching////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void Modelsearch()
    {
        String filters = cmbSearchBy.getSelectedItem().toString();
        String filter = "`"+filters+"`";
        String search=txtSearch.getText();
        String tablename = "dinein_customer_issuebill";
        JTable tblName = tbltempDineIn;
        
        search(filter,search,tablename,tblName);

    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    
    //ispositive validation////////////////////////////////////////////////////////////////////////////////////////////
    
//if checking a float//////////////////////////////////////////////////////////////////////////////////////////////
    
    public static boolean isPositiveint(JTextField txtFieldName, String errorMessage)
    {
        
    int number = Integer.parseInt(txtFieldName.getText());
        if(number>=0)
        {
        return true;
        
        }
        else
        {
        
        JOptionPane.showMessageDialog(null,errorMessage,"Insert valid numbers" ,JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    
}
