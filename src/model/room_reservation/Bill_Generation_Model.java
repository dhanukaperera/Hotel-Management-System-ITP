/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.room_reservation;

import app.room_reservation.Bill_Generation_Frame;
import java.awt.Font;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.HMS;
import source.DBConnection;
import source.billRender;
import source.mulitline;

/**
 *
 * @author Dhanuka Perera
 */
public final class Bill_Generation_Model extends HMS
{
    private int roomNo;
   
    
    final int A = 0;
    final int B = 500;
    final int C = 1200;
    final int D = 1800;
    
    
    
    public Bill_Generation_Model()
    {
        con = DBConnection.connect();
        
    }
    
    private void getRoomNo()
    {
       // this.roomNo = Integer.parseInt(Bill_Generation_Frame.txtRoomNo.getText()) ;
    }
    
    String roomList;
    
    private void getRoomList()
    {
        roomList = Bill_Generation_Frame.txtRoomNo.getText();
    }
    
    public void clearTable()
    {
        DefaultTableModel model = (DefaultTableModel) Bill_Generation_Frame.tblBill.getModel();
        model.setRowCount(0);
        model.setColumnCount(2);
    }
    
    public void calc()
    {
        /*
         * Find the room in the reservation table and it's checked
         * if data found FIND the reservation id, NIC, package type  and number of nights from reservation table
         * FIND the guest info form room table
         * FIND room rate FROM room types table
         * 
         * 
         * Amount for a Reservation : RoomRate + Package + Service + Tax
         * 
         **/
        DefaultTableModel model = (DefaultTableModel) Bill_Generation_Frame.tblBill.getModel();
        model.setRowCount(0);
        model.setColumnCount(2);
        
        Bill_Generation_Frame.tblBill.setDefaultRenderer(Object.class, new mulitline());
        
        JTableHeader header = Bill_Generation_Frame.tblBill.getTableHeader();
        header.setOpaque(true);
        header.setFont( new Font("Segoe UI",Font.PLAIN,15));
        header.disable();
        
        //getRoomNo();
        
        getRoomList();
        
        StringTokenizer st = new StringTokenizer(this.roomList,",");
        int numOfCols = st.countTokens();
        String[] arrList = new String[numOfCols];
                 
        int i = 0;
        while (st.hasMoreTokens()) 
        {
            arrList[i] = st.nextToken();
            i++;
        } 
        
        
        
        
        
        String v1="";
        String v2="";
        String v3="";
        String v4="";
        String v5="";
        String roomType;
        String roomRate;
        int valRoomRate = 0;
        float total = 0;
        boolean result = false;
        
        for(int r=0;r<arrList.length;r++)
        {
            
        String sql = "SELECT `Room Reservation ID`,`NIC/Passport`,`Arrivel Day`,`Leaving Day`,`Meal Type` FROM room_reservations WHERE `Room No` = '"+arrList[r]+"' AND `Checked in Status` = 'Checked'";
        
        try 
        {
            pst = con.prepareStatement(sql);
            rs =pst.executeQuery();
             
            while(rs.next())
            {
                
                 v1 = rs.getString("Room Reservation ID");
                 v2 = rs.getString("NIC/Passport");
                 v3 = rs.getString("Arrivel Day");
                 v4 = rs.getString("Leaving Day");
                 v5 = rs.getString("Meal Type");
                System.out.println(v1+","+v2+","+v3+","+v4+","+v5);
                
                System.err.println(v5);
                
                if(v5.equalsIgnoreCase("Room Only"))
                {
                     valRoomRate = A ;
                }
                else if(v5.equalsIgnoreCase("Bed & Breakfast"))
                {
                    valRoomRate = B ;
                }
                else if(v5.equalsIgnoreCase("Half Board"))
                {
                        valRoomRate = C ;
                }
                else if(v5.equalsIgnoreCase("Full Board"))
                {
                      valRoomRate =D ;
                }
                
                roomType = getValueFromDB("Room Type","rooms","Room No",arrList[r]);
                
                roomRate = getValueFromDB("Rate (LKR)","room_types","Room Type",roomType);
                
                model.setColumnIdentifiers(new Object[]{" "," "});
                model.addRow(new Object[]{"Guest Name  : ","Contact No : "});
                model.addRow(new Object[]{"Bill Date        : "+getCurrentDateTime(),""});

                model.addRow(new Object[]{"",""});
                model.addRow(new Object[]{"-----------------------------> Reservation : RSV-00001 <----------------------------","-----------------------------------------------------"});
                model.addRow(new Object[]{"     > Arrival           : "+v3,""});
                model.addRow(new Object[]{"     > Departure     : "+v4,""});
                model.addRow(new Object[]{"     > Room No      : "+arrList[r] + " ["+ roomType +"]",""});
                model.addRow(new Object[]{"     > Room Type   : "+roomType,""});
                
                 model.addRow(new Object[]{"\t-------------Description-------------","\t-------------Amount-------------"});
                
                model.addRow(new Object[]{"\t+ Room Rates","\tLKR "+roomRate});
                model.addRow(new Object[]{"\t+ Package","\tLKR "+valRoomRate});
                model.addRow(new Object[]{"\t+ Service Fees ","\tLKR 0.00"});
                
                total = Integer.parseInt(roomRate)  +valRoomRate;
                model.addRow(new Object[]{"\t+ Sub Total ","\tLKR " + total});
              
                
            }
           
        } 
        catch (SQLException | NumberFormatException e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }  
        
        if(v1 == null  || v1.equals(""))
        {
             result = false;
        } 
        else 
        {
             result = true;
        }
        System.out.println(result);
        
        if(result)
        {
              // -------- Header Formating
           
        }
        
        
        String Discount = "";
        float Discountvalue = 0;
        Discount = JOptionPane.showInputDialog("Enter Discount (%)");
        if(Discount.equals("")){}
            else
            {
                //JOptionPane.showMessageDialog(null,Discount);
                Discountvalue = Float.parseFloat(Discount);
            }
        
        // ---------- Bill 
        
       if(Discountvalue>=1)
                    total = (int) (total - (total*(Discountvalue/100)));
            
                //Displaying the Total price
                JOptionPane.showMessageDialog(null,"Total Price: "+total,"Total",JOptionPane.INFORMATION_MESSAGE);
        
        float PaidAmountValue = 0;
        boolean paid=false;
        float Balance=0;
                while(paid == false)
                {
                String paidAmount = JOptionPane.showInputDialog("Enter the Paid Amount (RS.)");

                PaidAmountValue = Float.parseFloat(paidAmount);

                if(total<=PaidAmountValue)
                {
                    Balance = total - PaidAmountValue;
                    new DecimalFormat("##.##").format(Balance); //Converting to two decimal points
                    Balance = Math.abs(Balance); //converting to a positive value
                    JOptionPane.showMessageDialog(null,"Customer Balance is : "+Balance,"Balance",JOptionPane.INFORMATION_MESSAGE);
                    paid = true;
                    
                    //Query to enter the bill details to the allbill tails form////
                    
                   

                   
            }
                
                
        }        
        // --------- Final Part
        model.addRow(new Object[]{"",""});
       // model.addRow(new Object[]{"\t\t- SUB TOTAL",""});
        model.addRow(new Object[]{"\t\t- TAX","\tLKR 0.00"});
        model.addRow(new Object[]{"\t\t- DISCOUNT","\tLKR "+Discountvalue});
        model.addRow(new Object[]{"\t\t- TOTAL","\tLKR "+total});
        model.addRow(new Object[]{"\t\t- PAID","\tLKR "+PaidAmountValue});
        model.addRow(new Object[]{"\t\t- BALANCE","\tLKR "+Balance});
        model.addRow(new Object[]{"",""});
        model.addRow(new Object[]{"",""});
        }
        
         MessageFormat headerx = new MessageFormat("Invoice");
        MessageFormat footer = new MessageFormat("Page 01");
        try 
        {
            Bill_Generation_Frame.tblBill.print(JTable.PrintMode.FIT_WIDTH, headerx, footer);
        } 
        catch (Exception e) 
        {
            
        }
    }
    
    float p1 = 0;
    float p2 = 500;
    float p3 = 1300;
    float p4 = 2100;
    
    
    float roomcharges=0;
    float restcharges=0;
    float langargcharges=0;
    float airpotcharges=0;
        
    public void addToBill()
    {
        DefaultTableModel model = (DefaultTableModel) Bill_Generation_Frame.tblBill.getModel();
        Bill_Generation_Frame.tblBill.setDefaultRenderer(Object.class, new billRender());
        //model.addRow(new Object[]{x,""});
        
        getRoomList();
        
        String v1="";
        String v2="";
        String v3="";
        String v4="";
        String v5="";
        String roomType;
        String roomRate;
        float valRoomRate = 0;
        float total = 0;
        
        
        StringTokenizer st = new StringTokenizer(this.roomList,",");
        int numOfCols = st.countTokens();
        String[] arrRoomList = new String[numOfCols];
                 
        int i = 0;
        while (st.hasMoreTokens()) 
        {
            arrRoomList[i] = st.nextToken();
            i++;
        } 
        
        
        
        for (int r = 0; r < arrRoomList.length; r++) 
        {
            // ------------------------------------------------------------------------
            // ---- >>>> BEGIN Room Chargeres  <<<< -----------------------------------------
            String sql = "SELECT `Room Reservation ID`,`NIC/Passport`,`Arrivel Day`,`Leaving Day`,`Meal Type` FROM room_reservations WHERE `Room No` = '" + arrRoomList[r] + "' AND `Checked in Status` = 'Checked'";

            try 
            {
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                
                while (rs.next()) 
                {
                    total = 0;
                    
                    v1 = rs.getString("Room Reservation ID");
                    v2 = rs.getString("NIC/Passport");
                    v3 = rs.getString("Arrivel Day");
                    v4 = rs.getString("Leaving Day");
                    v5 = rs.getString("Meal Type");
                    System.out.println(v1 + "," + v2 + "," + v3 + "," + v4 + "," + v5);

                    System.err.println(v5);

                    if (v5.equalsIgnoreCase("Room Only")) 
                    {
                        valRoomRate = p1;
                    } 
                    else if (v5.equalsIgnoreCase("Bed & Breakfast")) 
                    {
                        valRoomRate = p2;
                    } 
                    else if (v5.equalsIgnoreCase("Half Board")) 
                    {
                        valRoomRate = p3;
                    } 
                    else if (v5.equalsIgnoreCase("Full Board")) 
                    {
                        valRoomRate = p4;
                    }
                    
                    roomType = getValueFromDB("Room Type","rooms","Room No",arrRoomList[r]);
                
                    roomRate = getValueFromDB("Rate (LKR)","room_types","Room Type",roomType);
                    
                    model.addRow(new Object[]{"",""});
                    //model.addRow(new Object[]{"-----------------------------> Reservation : RSV-00001 <----------------------------","-----------------------------------------------------"});
                    model.addRow(new Object[]{"     > Arrival     : "+v3,""});
                    model.addRow(new Object[]{"     > Departure   : "+v4,""});
                    model.addRow(new Object[]{"     > Room No     : "+arrRoomList[r],""});
                    model.addRow(new Object[]{"     > Room Type   : "+roomType,""});
                    
                    model.addRow(new Object[]{"",""});
                    model.addRow(new Object[]{"----- | Room Chargers | -------------------------------------------------------------------------------",""});
                    model.addRow(new Object[]{"\t\t\tDescription","\t\t\tAmount (LKR)"});

                    model.addRow(new Object[]{"\t+ Room Rates","\tLKR "+roomRate});
                    model.addRow(new Object[]{"\t+ Package" + " ["+v5+"]","\tLKR "+valRoomRate});
                    model.addRow(new Object[]{"\t+ Service Fees ","\tLKR 0.00"});

                    total = Integer.parseInt(roomRate)  +valRoomRate;
                    model.addRow(new Object[]{"\t+ Sub Total ","\tLKR " + total});
                    
                    this.totoalAmount = this.totoalAmount + total;
                      roomcharges = this.totoalAmount;     
                }
            } 
            catch (SQLException | NumberFormatException e) 
            {

            }
            // ---- >>>> END Room Chargeres  <<<< -----------------------------------------
            // ---------------------------------------------------------------------------'
            
            // -------------------------------------------------------------------------
            // ---->>>> BEGIN Resturent Charges ------------------------------------------------
            
            String r1 = "";
            String r2 = "";
            String r3 = "";
            String r4 = "";
            String r5 = "";
            String r6 = "";
            String itemPrice="";
            int lr=0;
            String Lr ="";
            String sqlFoodBills = "SELECT `Date Modified`,`Name` ,`Type`,`Qty`,`Rate`,`Price` FROM `room_guest_orders` WHERE `Room No` = "+ arrRoomList[r]+" AND `Checked` = 'Checked'";
            System.err.println(sqlFoodBills);
            try 
            {
                pst = con.prepareStatement(sqlFoodBills);
                rs = pst.executeQuery();
                
                System.err.println(sqlFoodBills);
                
                model.addRow(new Object[]{"",""});
                model.addRow(new Object[]{"----- | Restaurant Chargers | ------------------------------------------------------------------------",""});
                model.addRow(new Object[]{"\t\tBill Date \t\tItem \tType","\tQty \tPrice \tTotal"});
                
                while(rs.next())
                {
                   
                    r1 = rs.getString("Date Modified");
                    r2 = rs.getString("Name");
                    r3 = rs.getString("Type");
                    r4 = rs.getString("Qty");
                    r5 = rs.getString("Rate");
                    r6 = rs.getString("Price");
                     model.addRow(new Object[]{"\t\t"+r1+" \t\t"+r2+" \t"+r3+"","\t"+r4+" \t"+r5+" \t"+r6+""});
                    
                    
                        //System.err.println("r6 =" + r6);
                    
                   
                    
                    r1 = r1.substring(0,19);
                   
                    //model.addRow(new Object[]{"\t\t"+r1+" \t"+r2+" \t"+r3+"","\t"+r4+" \t"+itemPrice+" \t"+r5+""});
                   
                    
                     /*
                    model.addRow(new Object[]{"\t+ Bill Date","\tLKR "+r1});
                    model.addRow(new Object[]{"\t+ Item","\tLKR "+r2});
                    model.addRow(new Object[]{"\t+ Type","\tLKR "+r3});
                    model.addRow(new Object[]{"\t+ Qty","\tLKR "+r4});
                    model.addRow(new Object[]{"\t+ Price","\tLKR "+r5});*/
                     
                          this.totoalAmount = this.totoalAmount + Integer.parseInt(r6) ;
                          restcharges= this.totoalAmount;
                          
                }       
            } 
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,"Error Adding Resturent Bill !","Error",JOptionPane.ERROR_MESSAGE);
            }
            
            
             // ---->>>> END Resturent Charges ------------------------------------------------
            // -------------------------------------------------------------------------
            
            
            // ---->>>> BEGIN Resturent Charges ------------------------------------------------
            String LinvoiceNo = "";
            int LsubTotal = 0;
            String LDate = "";
            String LitemName = "";
            String LType = "";
            String LQty = "";
            String LCost = "";
            String LTotal = "";
            
            String LROOM = "room"+arrRoomList[r];
             //Lr = Lr.substring(4,Lr.length());
             //lr = Integer.parseInt(Lr);
             //System.err.println("R--- "+ lr);
             
             LROOM = "room0"+arrRoomList[r];
             
            System.err.println(LROOM);
            String sqlLundary = "SELECT `Invoice No`,`Sub Total` FROM `guest_order` WHERE `Room No`= '"+ LROOM+"'";
            
            
              // ---->>>> BEGIN Laundary Charges ------------------------------------------------
            model.addRow(new Object[]{"",""});
            model.addRow(new Object[]{"----- | Laundary Chargers | ------------------------------------------------------------------------",""});
            model.addRow(new Object[]{"\t\tBill Date \t\tItem Name","\tQty \tPrice \tTotal"});
            
            System.out.println(sqlLundary);
            
            try 
            {
                pst = con.prepareStatement(sqlLundary);
                rs = pst.executeQuery();
                
                if(rs.next())
                {
                    LinvoiceNo = rs.getString("Invoice No");
                    LsubTotal = rs.getInt("Sub Total");
                    
                    
                    System.out.println(LinvoiceNo);
                    System.out.println(LsubTotal);
                    
                    //LinvoiceNo.substring(4, LinvoiceNo.length());
                    
                    
                //   model.addRow(new Object[]{"\t\tBill Date \t\tItem Name \tType","\tQty \tPrice \t"+LsubTotal+""});
            
                }
                
                     
                
            } 
            catch (Exception e) 
            {
               
            }
            String sqlGetLaudaryBills = "SELECT `Date`,`Item Name`,`Qty`,`Cost`,`Total` FROM finance WHERE `Order NO` = '"+LinvoiceNo+"'";
             System.err.println("xxx"+sqlGetLaudaryBills);
            try 
            {
                pst = con.prepareStatement(sqlGetLaudaryBills);
                rs = pst.executeQuery();
                
               
                
                while(rs.next())
                {
                    
                LDate = rs.getString("Date");
                LitemName = rs.getString("Item Name");
                //LType = rs.getString(LitemName);
                LQty = rs.getString("Qty");
                LCost = rs.getString("Cost");
                LTotal = rs.getString("Total");
                    
                model.addRow(new Object[]{"\t\t"+LDate+" \t"+LitemName+"","\t"+LQty+" \t"+LCost+" \t"+LTotal+""});
                  
                this.totoalAmount = this.totoalAmount + Integer.parseInt(LTotal) ;
                langargcharges = this.totoalAmount;
                
                }
            } 
            catch (Exception e) 
            {
                
            }
                        
             // ---->>>> END Resturent Charges ------------------------------------------------
             
            // ---->>>> BEGIN Airport Charges ------------------------------------------------
            model.addRow(new Object[]{"",""});
            model.addRow(new Object[]{"----- | Tour And Airport Pickup Chargers | ------------------------------------------------------------------------",""});
            model.addRow(new Object[]{"\t\tBill Date \t\tType","\tVehicle Type \tAmount"});
            
            String Adatemod="";
            String AType = "";
            String AVechicalType = "";
            float Aamount = 0;
            
            String sqlAirportBill = "Select `Date Modified`,`Type`,`Vehicle Type`,`Amount` from transport_details where `Room No` = '"+arrRoomList[r]+"' AND `Status` = 'Checked'";
            
            try 
            {
                pst = con.prepareStatement(sqlAirportBill);
                rs = pst.executeQuery();
                
                while(rs.next())
                {
                    Adatemod = rs.getString("Date Modified");
                    AType = rs.getString("Type");
                    AVechicalType = rs.getString("Vehicle Type");
                    Aamount = rs.getInt("Amount");
                    
                     model.addRow(new Object[]{"\t\t"+Adatemod+" \t"+AType+"","\t"+AVechicalType+" \t"+Aamount+""});
                      this.totoalAmount = this.totoalAmount + Aamount ;
                      airpotcharges = this.totoalAmount ;
                }
                
            }
            catch (Exception e) 
            {
                
            }
            
            
            // ---->>>> END Airport Charges ------------------------------------------------
        }
        
            

    }
    
    
    public void resturentCharges()
    {
        DefaultTableModel model = (DefaultTableModel) Bill_Generation_Frame.tblBill.getModel();
        Bill_Generation_Frame.tblBill.setDefaultRenderer(Object.class, new mulitline());
        
        
      
          
        
        
    }
    
    
    public void genBill()
    {
        DefaultTableModel model = (DefaultTableModel) Bill_Generation_Frame.tblBill.getModel();
        Bill_Generation_Frame.tblBill.setDefaultRenderer(Object.class, new mulitline());
        
        String Discount = "";
            float Discountvalue = 0;
            Discount = JOptionPane.showInputDialog("Enter Discount (%)");
            if(Discount.equals("")){}
            else
            {
                //JOptionPane.showMessageDialog(null,Discount);
                Discountvalue = Float.parseFloat(Discount);
            }
            if(Discountvalue>=1)
            {
                this.totoalAmount =  (this.totoalAmount - (this.totoalAmount*(Discountvalue/100)));
            }
                //Displaying the Total price
            JOptionPane.showMessageDialog(null,"Total Price: "+this.totoalAmount,"Total",JOptionPane.INFORMATION_MESSAGE);
        
            float PaidAmountValue = 0;
            boolean paid=false;
            float Balance=0;
            
            while (paid == false) 
            {
                String paidAmount = JOptionPane.showInputDialog("Enter the Paid Amount (RS.)");

                PaidAmountValue = Float.parseFloat(paidAmount);

                if (this.totoalAmount <= PaidAmountValue) 
                {
                    Balance = this.totoalAmount - PaidAmountValue;
                    new DecimalFormat("##.##").format(Balance); //Converting to two decimal points
                    Balance = Math.abs(Balance); //converting to a positive value
                    JOptionPane.showMessageDialog(null, "Customer Balance is : " + Balance, "Balance", JOptionPane.INFORMATION_MESSAGE);
                    paid = true;

                    //Query to enter the bill details to the allbill tails form////
                }

            }
            
            
             model.addRow(new Object[]{"",""});
            // model.addRow(new Object[]{"\t\t- SUB TOTAL",""});
             model.addRow(new Object[]{"\t\t- TAX","\tLKR 0.00"});
             model.addRow(new Object[]{"\t\t- DISCOUNT","\tLKR "+Discountvalue});
             model.addRow(new Object[]{"\t\t- TOTAL","\tLKR "+this.totoalAmount});
             model.addRow(new Object[]{"\t\t- PAID","\tLKR "+PaidAmountValue});
             model.addRow(new Object[]{"\t\t- BALANCE","\tLKR "+Balance});
             model.addRow(new Object[]{"",""});
             model.addRow(new Object[]{"",""});
             
            String colList="Room Charges,Restaurant Charges,Lauder Charges,Tour Management Charges,Total";
            
     
            
            float f1=totoalAmount-roomcharges;
            float f2 = totoalAmount- restcharges;
            float f3 = totoalAmount-langargcharges;
            float f4=totoalAmount-airpotcharges;
            
            
            new DecimalFormat("##.##").format(f1); //Converting to two decimal points
            f1 = Math.abs(f1); 
            
             new DecimalFormat("##.##").format(f2); //Converting to two decimal points
            f2 = Math.abs(f2); 
            
             new DecimalFormat("##.##").format(f3); //Converting to two decimal points
            f3 = Math.abs(f3); 
            
              new DecimalFormat("##.##").format(f4); //Converting to two decimal points
            f4 = Math.abs(f4); 
            
            String vals = f1+","+f2+","+f3+","+f4+","+totoalAmount;
            
            newAdd("room_bills", colList, vals);
             
             //new
    }
    
    
    public void settable()
    {
        DefaultTableModel model = (DefaultTableModel) Bill_Generation_Frame.tblBill.getModel();
        model.setRowCount(0);
        model.setColumnCount(2);
        
        Bill_Generation_Frame.tblBill.setDefaultRenderer(Object.class, new mulitline());
        
        JTableHeader header = Bill_Generation_Frame.tblBill.getTableHeader();
        header.setOpaque(true);
        header.setFont( new Font("Segoe UI",Font.PLAIN,15));
        header.disable();
        model.setColumnIdentifiers(new Object[]{" "," "});
        
        
        
       
        
        
    }
    
    private float totoalAmount;
    
    @Override
    public void add(String tableName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(String tableName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
