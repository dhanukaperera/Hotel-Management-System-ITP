/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.restaurant_management;
import app.finance_management.Incomes_Management_Frame;
import app.restaurant_management.Restaurant_Bill_Frames;
import static app.restaurant_management.Restaurant_Bill_Frames.*;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.HMS;
import model.finance_management.Incomes_Management_Model;
import net.proteanit.sql.DbUtils;
import static reports.iReport.PROJECT_PATH;
import reports.iReportView;
import source.DBConnection;
import source.Validation;

/**
 *
 * @author Sachin
 */
public class Restaurant_Bill_Model extends HMS {
 
     Validation val = new Validation();
     All_Bill_Details_Model allBillDetails = new All_Bill_Details_Model();
    
    private String Type;
    private String Name;
    private int qty;
    private float price;
    private int count;
    private float Total;
    private String DiscountReason;
    private float Discount;
    private float PaidAmount;
    private float Balance;
    private float rateofFOD;
    private String tempTypeLoad; //Loading the food type to the setter method
    private int primarynumber; 
    private String gennewID; //generation a new key
    private boolean allow; //alow a new primary key to be generated
    private String FOB_ID;
    
    
      public Restaurant_Bill_Model ()
      {
        con = DBConnection.connect();
        
      this.Type=null;
      this.Name=null;
      this.qty=0;
      this.price=0;
      this.count=0;
      this.Total=0;
      this.Discount=0;
      this.PaidAmount=0;
      this.Balance=0;
      this.rateofFOD=0;
      this.gennewID = "";
      this.allow =true;
      
      
    }
      
//getting the primary key to the delete button method////////////////////////////////////////////////////////////////////////
      
       public void getPrimaryKey()
    {
        String number = Restaurant_Bill_Frames.tblTempBill.getValueAt(getSelectedRow(Restaurant_Bill_Frames.tblTempBill), 0).toString();
        this.primarynumber = Integer.parseInt(number);
       
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////      

//table load method//////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void tableloadmethod()
    {
        String sql = "SELECT * FROM `restaurant_customer_issue_bill`";
        
        try 
        {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery(); 
            tblTempBill.setModel(DbUtils.resultSetToTableModel(rs));
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
//getters//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
    private void getType() {this.Type = Restaurant_Bill_Frames.cmbType.getSelectedItem().toString();}
    
    private void getName() {this.Name = Restaurant_Bill_Frames.cmbName.getSelectedItem().toString();}
    
    private void getqty() {this.qty = Integer.parseInt(Restaurant_Bill_Frames.txtQTY.getText());}
    
    private void getprice() {this.price = Float.parseFloat(Restaurant_Bill_Frames.txtPrice.getText()) ;}
    
    private void getTotal() 
    {  
        this.Total = Float.parseFloat(Restaurant_Bill_Frames.txtTotal.getText()) ;
    }
    
    private void getDiscount() {this.DiscountReason = Restaurant_Bill_Frames.cmbDiscount.getSelectedItem().toString();}

    private void getpaidamount() {this.PaidAmount = Float.parseFloat(Restaurant_Bill_Frames.txtPaidAmount.getText()) ;}

    private void getbalance() {this.Balance = Float.parseFloat(Restaurant_Bill_Frames.txtBalance.getText()) ;}
 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
//setter//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
 // private void setType() { Restaurant_Bill_Frames.cmbType.setSelectedItem(Restaurant_Bill_Frames.tblRestaurantBill.getValueAt(getSelectedRow(Restaurant_Bill_Frames.tblRestaurantBill), 4).toString());}
   
   public void setname() { Restaurant_Bill_Frames.cmbName.setSelectedItem(Restaurant_Bill_Frames.tblTempBill.getValueAt(getSelectedRow(Restaurant_Bill_Frames.tblTempBill), 1).toString());}

   private void setqty() { Restaurant_Bill_Frames.txtQTY.setText(Restaurant_Bill_Frames.tblTempBill.getValueAt(getSelectedRow(Restaurant_Bill_Frames.tblTempBill), 2).toString());}

   private void setprice() { Restaurant_Bill_Frames.txtPrice.setText(Restaurant_Bill_Frames.tblTempBill.getValueAt(getSelectedRow(Restaurant_Bill_Frames.tblTempBill), 4).toString());}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
    //Loading the type of the food/Drink//
   
    public void loadtype()
     {
          this.Name = Restaurant_Bill_Frames.tblTempBill.getValueAt(getSelectedRow(Restaurant_Bill_Frames.tblTempBill), 1).toString();
         
          try {
            
            String sql = "SELECT `Type` FROM `food_drink_info` WHERE Name='"+this.Name+"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next())
            {
                this.tempTypeLoad =  rs.getString("Type"); 
            }           
        } 
         
         catch (Exception e) 
        {
             JOptionPane.showMessageDialog(null,e);
        }
          
          //setting the combox value
          Restaurant_Bill_Frames.cmbType.setSelectedItem(this.tempTypeLoad);
     
     }
   
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   public void setAll()
     {
         setname();
         setqty();
         setprice();
         loadtype();
     }
    
   
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   

//Load Names when Type is selected//////////////////////////////////////////////////////////////////////////////////////////////
    
    public void LoadName()
    {
        getType();
        
         try {
            
            String sql = "SELECT `Name` FROM `food_drink_info` WHERE Type='"+this.Type+"' AND `Available`='YES'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
           
            Restaurant_Bill_Frames.cmbName.removeAllItems(); 
           
            while(rs.next())
            {
                String name =  rs.getString("Name"); 
                Restaurant_Bill_Frames.cmbName.addItem(name);
            }           
        } 
         
         catch (Exception e) 
        {
             JOptionPane.showMessageDialog(null,e);
        }
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Load Price when Food name is selected and calulate the value///////////////////////////////////////////////////////////////////////////////////////
    
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
                
                Restaurant_Bill_Frames.txtPrice.setText(FinalPrice);
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
     
     
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
/////Generate Primary key////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void genprimarykey()
    {
        int count=0;

          String getcount = "SELECT Number FROM takeoutorders_bill_info ORDER BY Number DESC LIMIT 1";
        
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
       
     
//Add method////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
    @Override
    public void add(String tableName) {
    
            //Add food & Drink details to the bill//////////////////////////////////////
            try 
            {
            getName();
            getqty();
            loadrate();
            
            this.count++; //passing the number to add in the all bill details form
            this.price = Float.parseFloat(txtPrice.getText());

            String sql = "INSERT INTO "+tableName+""
                    + "(`Number`,`ITEM`,`QTY`, `RATE`, `Value`)"
                    + " VALUES("
                    + ""+this.count+","
                    + "'"+this.Name+"',"
                    + "'"+this.qty+"',"
                    + ""+this.rateofFOD+","
                    + ""+this.price+""
                    + ")";

                pst = con.prepareStatement(sql);
                pst.execute();
                tableloadmethod();  
                JOptionPane.showMessageDialog(null,"Added Successfully","Successful Message",JOptionPane.INFORMATION_MESSAGE);
                
                
                
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
 
        this.Total = this.Total + this.price;
        txtTotal.setText(String.valueOf(this.Total));
        
        
         addtoallbills();
         allBillDetails.takeoutorderstableloadmethod();
         clearbeforegenerate();
       
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
//Add food & Drink Details to All bill details when add button pressed//////////////////////////////////////////////////////////////////////////////
    public void addtoallbills()
    {
        try 
            { 
                
             if(this.allow == true)
             {
                    genprimarykey();
             }
              
              loadFOBID();
              getType();
              getName();
              getqty();
            
              
            this.price = Float.parseFloat(txtPrice.getText());
            
            String sql2 = "INSERT INTO takeoutorders_bill_info"
                    + "(`Modified Date`,`Bill ID`,`Count`, `FOB ID`, `Type`, `Name`, `QTY`, `Rate`, `Value`)"
                    + " VALUES("
                    + "'"+getCurrentDateTime()+"',"
                    + "'"+this.gennewID+"',"
                    + "'"+this.count+"',"
                    + "'"+this.FOB_ID+"',"
                    + "'"+this.Type+"',"
                    + "'"+this.Name+"',"
                    + ""+this.qty+","
                    + ""+this.rateofFOD+","
                    + ""+this.price+""
                    + ")";

                pst = con.prepareStatement(sql2);
                pst.execute();
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
         
         //changing the total price/////////////////
        
        String Valueupdate = Restaurant_Bill_Frames.tblTempBill.getValueAt(getSelectedRow(Restaurant_Bill_Frames.tblTempBill), 4).toString();
        float valueintupdate = Float.parseFloat(Valueupdate);
        this.Total = this.Total - valueintupdate;
        this.Total = this.Total + this.price;
        txtTotal.setText(String.valueOf(this.Total));
         
         //////////////////////////////////////////
         
        
        String Number = Restaurant_Bill_Frames.tblTempBill.getValueAt(getSelectedRow(Restaurant_Bill_Frames.tblTempBill), 0).toString();
        primarykey = Integer.parseInt(Number);
        
        String sql = "UPDATE "+tableName+""
                + " SET `ITEM` = "+"'" + this.Name + "',"
                + "`QTY` = '" + this.qty + "',"
                + "`RATE`=" + this.rateofFOD + ","
                + "`Value`='" + this.price + "'"
                + "WHERE `Number` = '" +primarykey+ "'";
               
                pst = con.prepareStatement(sql);
                pst.execute();
                tableloadmethod(); 
        } 
        catch (Exception e) 
        {
               
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
          
//Update Allbills table////////////////////////////////////////////////////////////////////////////////////////////////      
            try 
        {  
         loadFOBID();
         getType();
       
        String sql = "UPDATE takeoutorders_bill_info"
                + " SET `Modified Date` ='" + getCurrentDateTime() + "',"
                + "`FOB ID` = '" + this.FOB_ID + "',"
                + "`Type`='"+ this.Type + "',"
                + "`Name`='" + this.Name + "',"
                + "`QTY`=" + this.qty + ","
                + "`Rate`=" + this.rateofFOD + ","
                + "`Value`=" + this.price + ""
                + "WHERE `Count` = '" +primarykey+ "' and `Bill ID`= '"+this.gennewID+"' ";
        
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
         allBillDetails.takeoutorderstableloadmethod();
         
          ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    }
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
    
 //Delete Method////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void deleterow(String tableName) {
        
        getPrimaryKey();
        
        try {
            
            String sql = "SELECT `Value` FROM `restaurant_customer_issue_bill` WHERE `Number` ='"+this.primarynumber+"'";
          
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
                + "WHERE `Number` ='"+this.primarynumber+"'";
        
       
        try 
        {
             pst = con.prepareStatement(sql);
             pst.execute();
             
             Deleteallbills();
             JOptionPane.showMessageDialog(null,"Record DELETED Successfully");
        } 
        catch (SQLException | HeadlessException e) 
        {
             JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        clearbeforegenerate();
                
                
    }  
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
//Delete Allbills table////////////////////////////////////////////////////////////////////////////////////////////////
    public void Deleteallbills()
    {
        String sql = "DELETE FROM takeoutorders_bill_info"
                + " WHERE `Count` ='"+this.primarynumber+"' and `Bill ID` ='"+this.gennewID+"'";
       
        try 
        {
             pst = con.prepareStatement(sql);
             pst.execute();

        } 
        catch (SQLException | HeadlessException e) 
        {
             JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
        allBillDetails.takeoutorderstableloadmethod();
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
//clear method begore bill generate/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
    public void clearbeforegenerate()
    {
        txtQTY.setText("");
        txtPrice.setText("");
       
   }
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Clear method after bill generate/////////////////////////////////////////////////////////////////////////////////////
    
    public void clearaftergenerate()
    {
        txtQTY.setText("");
        txtPrice.setText("");
        txtTotal.setText("");
        txtBalance.setText("");
        txtPaidAmount.setText("");
                
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
//Load Discount////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void loadDiscount()
    {
         try {
            
            String sql = "SELECT `Type` FROM `discount_details`";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
           
            Restaurant_Bill_Frames.cmbDiscount.removeAllItems(); 
           
            while(rs.next())
            {
                String discount =  rs.getString("Type"); 
                Restaurant_Bill_Frames.cmbDiscount.addItem(discount);
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
        float PaidAmountValue,Balance;
        boolean paid = false;
       // boolean discountvalidation = false;
        
        if(txtTotal.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Add Items to the Bill","Bill Generation Error",JOptionPane.ERROR_MESSAGE);
        }
        
        else
        {
                    if(checkadddiscount.isSelected())
                    {
                        getdiscountamount();
                        
                        this.Total = this.Total - (this.Total*(this.Discount/100));
                        JOptionPane.showMessageDialog(null,"Discount : "+this.Discount+" %");
                        
                    }
                    
                    
                    
                    //Displaying the Total price
                    JOptionPane.showMessageDialog(null,"Total Price: "+this.Total,"Total",JOptionPane.INFORMATION_MESSAGE);


                    //loop to enter values until the crrect paid amount is enetered
                    while(paid == false)
                    {
                    String paidAmount = JOptionPane.showInputDialog("Enter the Paid Amount (RS.)");
                    
                    
                    if (!paidAmount.matches("[0-9]+")) 
                    {   
                        JOptionPane.showMessageDialog(null,"Input Valid Numbers(%)","ERROR",JOptionPane.ERROR_MESSAGE);
                        paid = false;
                        continue;   
                    }
                    
                    txtPaidAmount.setText(paidAmount);
                        
                    PaidAmountValue = Float.parseFloat(paidAmount);
//                    
//                    float bal = this.Total - PaidAmountValue;
//                    
//                    new DecimalFormat("##.##").format(bal); //Converting to two decimal points
//                    Balance = Math.abs(bal); //converting to a positive value
//
//                    if(bal<=5000.0)
//                    {
//                        JOptionPane.showMessageDialog(null,"Insert a valid number");
//                        paid=false;
//                        continue;
//                    }
                    
                    if(this.Total<=PaidAmountValue)
                    {
                        Balance = this.Total - PaidAmountValue;
                        
                        new DecimalFormat("##.##").format(Balance); //Converting to two decimal points
                        Balance = Math.abs(Balance); //converting to a positive value
                        
                        txtBalance.setText(Float.toString(Balance));
                        
                        JOptionPane.showMessageDialog(null,"Customer Balance is : "+Balance,"Balance",JOptionPane.INFORMATION_MESSAGE);
                        paid = true;

                        //Query to enter the bill details to the allbill tails form////

                           try 
                           { 

                                   getTotal();

                                   String sql = "INSERT INTO takeoutorders_bill_info"
                                   + "(`Modified Date`, `Bill ID`,`Total`,`Discount Reason`, `Discount`, `Paid Amount`, `Balance`)"
                                   + " VALUES("
                                   + "'"+getCurrentDateTime()+"',"
                                   + "'"+this.gennewID+"',"
                                   + ""+this.Total+","
                                   + "'"+this.DiscountReason+"',"        
                                   + ""+this.Discount+","
                                   + ""+PaidAmountValue+","
                                   + ""+Balance+""
                                   + ")";

                                    pst = con.prepareStatement(sql);
                                    pst.execute();
                                    
                                    insertdiscount(); //inserting the discount values to the customer issue table
                                    inserttotal(); //insertin the total to the customer issue table
                                    insertpaidamount(PaidAmountValue);
                                    insertbalance(Balance); //Inserting the balance amount to the customer table

                                     String takediscount = this.gennewID;
                                     
                                     iReportView r = new iReportView(PROJECT_PATH+"\\restaurant_management\\TakeoutOrderBill.jasper");
                                     r.setVisible(true);

                                   DeleteCustomerIssueBill();
                                   this.allow = true;
                                   this.count=0;

                                   transferincometable(); //transfer the income
                                   clearaftergenerate();
                           }
                           catch (Exception e) 
                           {
                               JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
                           }

                           allBillDetails.takeoutorderstableloadmethod();


                        ////////////////////////////////////////////////////////////////

                    }

                        else
                        {
                            JOptionPane.showMessageDialog(null,"Please enter an appropiate amount!","Error",JOptionPane.ERROR_MESSAGE);
                            paid=false;
                        }
                }
              } 
      
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Delete all the details formt the customer Bill//////////////////////////////////////////////////////////////////////
    
    public void DeleteCustomerIssueBill()
    {
        try 
        { 
            String sql = "DELETE FROM restaurant_customer_issue_bill";        
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

//Delete all the details from the allbilldetails table///////////////////////////////////////////////////////////////
    
    public void cancelallbilldetails()
    {
        try 
        { 
            String sql = "DELETE FROM  takeoutorders_bill_info where `Bill ID` = '"+this.gennewID+"'";   
            
            pst = con.prepareStatement(sql);
            pst.execute();           
            
         }
        
             catch (Exception e) 
             {
               JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
             }      
        this.count=0;
        tableloadmethod();
        
        clearaftergenerate();
        allBillDetails.takeoutorderstableloadmethod();
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    

//Transfer income to the financial department///////////////////////////////////////////////////////////////////////////
    
    public void transferincometable()
    {
       
        Incomes_Management_Model incomes = new Incomes_Management_Model();
      
        String colname = "Income ID";
        String tablename = "incomes_management";
        String primaryval = "INM";
 
        try 
        { 
            String income = this.gennewID+" Take out Orders";
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

//insert discount/////////////////////////////////////////////////////////////////////////////////////////////////////
  
    public void insertdiscount()
   {
    try 
    { 
        this.count++;
        this.Name="Discount (%)";

       String sql = "INSERT INTO restaurant_customer_issue_bill"
                    + "(`Number`,`ITEM`,`Value`)"
                    + " VALUES("
                    + ""+this.count+","
                    + "'"+this.Name+"',"
                    + ""+this.Discount+""
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
    
//insert total to the customer issue table///////////////////////////////////////////////////////////////////////////
    public void inserttotal()
   {
    try 
    { 
        this.count++;
        this.Name="Total (RS.)";

       String sql = "INSERT INTO restaurant_customer_issue_bill"
                    + "(`Number`,`ITEM`,`Value`)"
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

       String sql = "INSERT INTO restaurant_customer_issue_bill"
                    + "(`Number`,`ITEM`,`Value`)"
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

       String sql = "INSERT INTO restaurant_customer_issue_bill"
                    + "(`Number`,`ITEM`,`Value`)"
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
      
 //////searching////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void Modelsearch()
    {
        String filters = cmbSearchBy.getSelectedItem().toString();
        String filter = "`"+filters+"`";
        String search=txtSearch.getText();
        String tablename = "restaurant_customer_issue_bill";
        JTable tblName = tblTempBill;
        
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


