/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.event_handling;

import app.event_handling.Bill_Frame;
import app.finance_management.Incomes_Management_Frame;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.HMS;
import source.DBConnection;

public class Bill_Model extends HMS
{
    private String bookingNo;
    private String customerNo;
    private String invoiceNo;
    private float mealCharge;
    private float serviceCharge;
    private float extraCharge;
    private float discount;
    private float totalCharge;
    private float totalPayable;
    private float amountPaid;
    private float balance;
    private String fin;
    private float bill;
    private float totp;
    private float advanced;
    
    public Bill_Model()
    {
        con = DBConnection.connect();
        
        this.bookingNo = "NULL";
        this.customerNo = "NULL";
        this.invoiceNo = "NULL";
        this.mealCharge = 0;
        this.serviceCharge = 0;
        this.extraCharge = 0;
        this.discount = 0;
        this.totalCharge = 0;
        this.totalPayable = 0;
        this.amountPaid = 0;
        this.balance = 0;
        this.advanced=0;
      // colList ="`Booking No`,`Date Modified`,`Customer No`,`Invoice No`,`Meal Charges`,`Service Charges`,`Extra Charges`,`Discount`,`Total Charges`,`Total Payable`,`Amount paid`,`Balance`";
        // System.out.println(colList);
    }
    
    public void test()
    {
        
    }
    
    public String getPrimaryKey()
    {
        setInvoiceNo();
        getInvoiceNo();
        return this.invoiceNo;
    }
    // -------------------------------------------------------------------------
    // -- BEGIN Getting Values -------------------------------------------------
    
   private void getInvoiceNo() { this.invoiceNo = Bill_Frame.txtInvoiceNo.getText(); } 
   
   private void getBookingNo() { this.bookingNo = Bill_Frame.txtBookingNo.getText();}
   
   private void getCustomerNo() { this.customerNo = Bill_Frame.txtCustomerNo.getText();}
   
   private void getMealCharges() { this.mealCharge = Float.parseFloat(Bill_Frame.txtMealCharges.getText());}
   
   private void getServiceCharges() { this.serviceCharge = Float.parseFloat(Bill_Frame.txtServiceCharges.getText());}
   
   private void getExtraCharges() { this.extraCharge = Float.parseFloat(Bill_Frame.txtExtraCharges.getText());}
   
   private void getDiscount() { this.discount = Float.parseFloat(Bill_Frame.txtDiscount.getText());}
   
   private void getToalCharges() { this.totalCharge = Float.parseFloat(Bill_Frame.txtTotalCharges.getText());}
   
   private void getTotalPayable() { this.totalPayable = Float.parseFloat(Bill_Frame.txtTotalPayable.getText());}
   
   private void getAmountPaid() { this.amountPaid = Float.parseFloat(Bill_Frame.txtAmountPaid.getText());}
   
   private void getBalance() { this.balance = Float.parseFloat(Bill_Frame.txtBalance.getText());}
   
   private void getAdvanced() { this.advanced = Float.parseFloat(Bill_Frame.txtAdvanced.getText());}
   
   public void getAll()
   {
       getInvoiceNo();
       getBookingNo();
       getCustomerNo();
       getMealCharges();
       getServiceCharges();
       getExtraCharges();
       getDiscount();
       getToalCharges();
       getTotalPayable();
       getAmountPaid();
       getBalance();
       getAdvanced();
   }
    // -- END GET Values -------------------------------------------------------
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    // -- BEGIN Setting Values -------------------------------------------------
   
   private void setInvoiceNo() { Bill_Frame.txtInvoiceNo.setText(Bill_Frame.tblBill.getValueAt(getSelectedRow(Bill_Frame.tblBill), 0).toString());}
   
   private void setBookingNo() { Bill_Frame.txtBookingNo.setText(Bill_Frame.tblBill.getValueAt(getSelectedRow(Bill_Frame.tblBill), 2).toString());}
   
   private void setCustomerNo() { Bill_Frame.txtCustomerNo.setText(Bill_Frame.tblBill.getValueAt(getSelectedRow(Bill_Frame.tblBill), 3).toString());}
   
   private void setMealCharges() { Bill_Frame.txtMealCharges.setText(Bill_Frame.tblBill.getValueAt(getSelectedRow(Bill_Frame.tblBill),4).toString());}
   
   private void setServiceCharges() { Bill_Frame.txtServiceCharges.setText(Bill_Frame.tblBill.getValueAt(getSelectedRow(Bill_Frame.tblBill), 5).toString());}
   
   private void setExtraCharges() { Bill_Frame.txtExtraCharges.setText(Bill_Frame.tblBill.getValueAt(getSelectedRow(Bill_Frame.tblBill), 6).toString());}
   
   private void setDiscount() { Bill_Frame.txtDiscount.setText(Bill_Frame.tblBill.getValueAt(getSelectedRow(Bill_Frame.tblBill), 7).toString());}
   
   private void setTotalCharges() { Bill_Frame.txtTotalCharges.setText(Bill_Frame.tblBill.getValueAt(getSelectedRow(Bill_Frame.tblBill), 8).toString());}
   
   private void setTotalpayable() { Bill_Frame.txtTotalPayable.setText(Bill_Frame.tblBill.getValueAt(getSelectedRow(Bill_Frame.tblBill), 10).toString());}
   
   private void setAmountPaid() { Bill_Frame.txtAmountPaid.setText(Bill_Frame.tblBill.getValueAt(getSelectedRow(Bill_Frame.tblBill), 11).toString());}
   
   private void setBalance() { Bill_Frame.txtBalance.setText(Bill_Frame.tblBill.getValueAt(getSelectedRow(Bill_Frame.tblBill), 12).toString());}
   
   private void setAdvanced() { Bill_Frame.txtAdvanced.setText(Bill_Frame.tblBill.getValueAt(getSelectedRow(Bill_Frame.tblBill), 9).toString());}
   
   public void setAll()
   {
       
       setBookingNo();
       setCustomerNo();
       setInvoiceNo();
       setMealCharges();
       setServiceCharges();
       setExtraCharges();
       setTotalCharges();
       setDiscount();
       setTotalpayable();
       setAmountPaid();
       setBalance();
       setAdvanced();
       
   }
    // -- END Setting Values ---------------------------------------------------
    // -------------------------------------------------------------------------
   
   @Override
    public void add(String tableName)
    {
        String s="SELECT MAX(`Invoice No`) FROM event_bills";
            System.out.println(s);
            
            try {
                pst = con.prepareStatement(s);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String st = rst.getString("MAX(`Invoice No`)");
                    if("".equals(st))
                    {
                        Bill_Frame.txtInvoiceNo.setText("EB-00001");
                    }
                    else
                    {
                        String temp = st.substring(3,8);
                        int temp1 = Integer.parseInt(temp);
                        temp1++;
                        temp = String.valueOf(temp1);
                        if(temp1<10)
                        {
                            temp="0000"+temp;
                        }
                        else if(temp1<100)
                        {
                            temp="000"+temp;
                        }
                        else if(temp1<1000)
                        {
                            temp="00"+temp;
                        }
                        else if(temp1<10000)
                        {
                            temp="0"+temp;
                        }

                        String inno = "EB-"+temp;

                        Bill_Frame.txtInvoiceNo.setText(inno);
                    
                    }
                }
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            } 
        
       getAll();
       
        //this.totalCharge= generateBill();
        //JOptionPane.showMessageDialog(null, totalCharge);
        String sql = "INSERT INTO "+tableName+""
                + "(`Invoice No`,`Date Modified`,`Booking No`,`Customer No`,`Meal Charges`,`Service Charges`,`Extra Charges`,`Total Charges`,`Discount`,`Advanced`,`Total Payable`, `Amount Paid`, `Balance`)"
                + " VALUES("
                + "'"+this.invoiceNo+"',"
                + "'"+getCurrentDateTime()+"',"
                + "'"+this.bookingNo+"',"
                + "'"+this.customerNo+"',"
                + ""+this.mealCharge+","
                + ""+this.serviceCharge+","
                + ""+this.extraCharge+","
                + ""+this.totalCharge+","
                + ""+this.discount+","
                + ""+this.advanced+","
                + ""+this.totalPayable+","
                + ""+this.amountPaid+","
                + ""+this.balance+""
                + ")";
        
       System.out.println(sql);
        
        try 
        {
            pst = con.prepareStatement(sql);
            pst.execute();
            loadTable("event_bills",Bill_Frame.tblBill);   
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
      @Override
    public void update(String tableName)
    {   
       /* getAll();
     
        String sql = "UPDATE "+tableName+""
                + " SET `Booking No` = "+ "'" + this.bookingNo + "',"
                + "`Date Modified`= '" + getCurrentDateTime() + "',"
                + "`Customer No` = '" + this.customerNo + "',"
                + "`Meal Charges`=" + this.mealCharge + ","
                + "`Service Charges`=" + this.serviceCharge + ", "
                + "`Extra Charges`=" + this.extraCharge + ", "
                + "`Discount`=" + this.discount + ", "
                + "`Total Charges`=" + this.totalCharge + ", "
                + "`Total Payable`=" + this.totalPayable + ", "
                + "`Amount Paid`=" + this.amountPaid + ", "
                + "`Balance`=" + this.balance + ", "
                + "WHERE `Invoice No` = '" + this.invoiceNo + "'";
        
        //System.out.println(sql);
        
        try 
        {
                pst = con.prepareStatement(sql);
                pst.execute();
                loadTable("event_bills",Bill_Frame.tblBill);   
        } 
        catch (Exception e) 
        {
               
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }*/
        
        
    }
      
    public void genBill ()
    {
        getMealCharges();
        getExtraCharges();
        getServiceCharges();
        getDiscount();
        getAmountPaid();
        
        
       float tot = this.extraCharge+this.mealCharge+this.serviceCharge;
       String to = String.valueOf(tot);
       Bill_Frame.txtTotalCharges.setText(to);
       
      this.totp = tot-this.discount;
      //JOptionPane.showMessageDialog(null,this.totalCharge );
      String dis = String.valueOf(totp);
      Bill_Frame.txtAdvanced.setText(dis);
       

      
      float bala = this.amountPaid-this.totp;
      String bal = String.valueOf(bala);
      Bill_Frame.txtAmountPaid.setText(bal);
      
      
    }
    
    public void clear()
    {
        Bill_Frame.txtBookingNo.setText("");
        Bill_Frame.txtCustomerNo.setText("");
        Bill_Frame.txtInvoiceNo.setText("");
        Bill_Frame.txtMealCharges.setText("");
        Bill_Frame.txtServiceCharges.setText("");
        Bill_Frame.txtExtraCharges.setText("");
        Bill_Frame.txtTotalCharges.setText("");
        Bill_Frame.txtDiscount.setText("");
        Bill_Frame.txtAdvanced.setText("");
        Bill_Frame.txtTotalPayable.setText("");
        Bill_Frame.txtAmountPaid.setText("");
        
    }

    public void getBill() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void findCustomer()
    {
        getBookingNo();
        String customer = "SELECT `Customer No` FROM view_event_booking WHERE `Booking No`='"+this.bookingNo+"'";
        
        try {
                pst = con.prepareStatement(customer);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                  String st = rst.getString("Customer No");
                  Bill_Frame.txtCustomerNo.setText(st);
                }
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            } 
    }
    
    public void genMealCharge()
    {
        float noofguest=0,menuprice=0;
        String mno=null;
        getBookingNo();
        
        String guest="SELECT `Total No of Guest`,`Menu No` FROM view_event_booking WHERE `Booking No`='"+this.bookingNo+"'";
            System.out.println(guest);
            
            try {
                pst = con.prepareStatement(guest);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String nofg = rst.getString("Total No of Guest");
                    noofguest=Float.parseFloat(nofg);
                    mno = rst.getString("Menu No");
                }
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            } 
      
      String menup="SELECT SUM(`Price`) FROM event_menu WHERE `Menu No`='"+mno+"'";
            System.out.println(menup);
            
            try {
                pst = con.prepareStatement(menup);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String mn = rst.getString("SUM(`Price`)");
                    menuprice=Float.parseFloat(mn);
                }
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            } 
           
            float mealc = menuprice*noofguest;
            String mealcharg = String.valueOf(mealc);
            Bill_Frame.txtMealCharges.setText(mealcharg);
    }
    
    public void genTotalCharges()
    {
        getMealCharges();
        getServiceCharges();
        getExtraCharges();
        
        float temp = this.mealCharge+this.serviceCharge+this.extraCharge;
        String total = String.valueOf(temp);
        Bill_Frame.txtTotalCharges.setText(total);
    }
    
    public void genTotalPayable()
    {
        String st=Bill_Frame.txtAdvanced.getText();
        if("".equals(st))
        {
        }
        else
        {
            getToalCharges();
            getDiscount();
            getAdvanced();

            float totpay = this.totalCharge-this.advanced-this.discount;
            String totalpay = String.valueOf(totpay);
            Bill_Frame.txtTotalPayable.setText(totalpay);
        }
        
    }
    
    public void genBalance()
    {
        String st=Bill_Frame.txtAmountPaid.getText();
        if("".equals(st))
        {
        }
        else
        {
        getAmountPaid();
        getTotalPayable();
        
        float temp = this.amountPaid-this.totalPayable;
        String balance = String.valueOf(temp);
        Bill_Frame.txtBalance.setText(balance);
        }
    }
    
    public void transferincometable(){
    
//        Incomes_Management_Model incomes = new Incomes_Management_Model();
//        
//        String colname = "Income ID";
//        String tablename = "incomes_management";
//        String primaryval = "INM" ;
//        
//        try
//        {
//          String income = this.invoiceNo+" Event" ;
//          String Department = "Events" ;
//          String sql = "INSERT INTO incomes_management "
//                + "( `Income`,`Date`,`Amount`,`Department`)"
//                + " VALUES("
//                + "'"+generatePrimaryKey(colname, tablename, primaryval)+"',"
//                + "'"+income+"',"
//                + "'"+getCurrentDateTime()+"',"
//                + ""+this.totalPayable+","
//                + "'"+Department+"'"
//                + ")";  
//             
//                pst = con.prepareStatement(sql);
//                pst.execute();
//                
//        
//        
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,e,"null",JOptionPane.ERROR_MESSAGE);
//        }
//        
//        incomes.loadTable(tablename,Incomes_Management_Frame.tbIncomes);
        
    
    
    }
  
}
