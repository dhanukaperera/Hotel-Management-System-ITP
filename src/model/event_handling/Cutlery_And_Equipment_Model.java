/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.event_handling;

import app.event_handling.Cutlery_And_Equipment_Frame;
import app.event_handling.Venue_Booking_Frame;
import java.sql.ResultSet;
import java.util.Date;
import java.util.UUID;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.HMS;
import source.DBConnection;


public class Cutlery_And_Equipment_Model extends HMS
{
    private String id;
    private String bookingNo;
    private String customerNo;
    private String functiond;
    private int tables;
    private int chairs;
    private int tableClothes;
    private int tableMates;
    private int plates;
    private int spoons;
    private int forks;
    private int glasses;
    
     public Cutlery_And_Equipment_Model()
    {
        con = DBConnection.connect();
        
        this.id = "NULL";
        this.bookingNo = "NULL";
        this.customerNo = "NULL";
        this.functiond = "NULL";
        this.tables = 0;
        this.chairs =0;
        this.tableClothes = 0;
        this.tableMates = 0;
        this.plates = 0;
        this.spoons = 0;
        this.forks = 0;
        this.glasses = 0;
        
    }
     
     public String getPrimaryKey()
    {
        getID();
        setID();
 
        return this.id;
    }
     
    private void getID() { this.id = Cutlery_And_Equipment_Frame.txtId.getText(); }
     
    private void getBookingNo() { this.bookingNo = Cutlery_And_Equipment_Frame.txtBookingNo.getText(); }
    
    private void getCustomerNo() { this.customerNo = Cutlery_And_Equipment_Frame.txtCustomerNo.getText(); }
    
    private void getFunctionDate() { this.functiond = Cutlery_And_Equipment_Frame.txtfD.getText(); }
    
    private void getTables() { this.tables = Integer.parseInt(Cutlery_And_Equipment_Frame.txtTables.getText()); }
    
    private void getChairs() { this.chairs = Integer.parseInt(Cutlery_And_Equipment_Frame.txtChairs.getText()); }
    
    private void getTableClothes() { this.tableClothes = Integer.parseInt(Cutlery_And_Equipment_Frame.txtTableClothes.getText());}
    
    private void getTableMates() { this.tableClothes = Integer.parseInt(Cutlery_And_Equipment_Frame.txtTableMats.getText()); }
    
    private void getPlates() { this.plates = Integer.parseInt(Cutlery_And_Equipment_Frame.txtPlates.getText()); }
    
    private void getSpoons() { this.spoons = Integer.parseInt(Cutlery_And_Equipment_Frame.txtSpoons.getText()); }
    
    private void getForks() { this.forks = Integer.parseInt(Cutlery_And_Equipment_Frame.txtForks.getText()); }
    
    private void getGlasses() { this.glasses = Integer.parseInt(Cutlery_And_Equipment_Frame.txtGlasses.getText()); }
    
//     private void getDate() {
//        Date functionDate = Cutlery_And_Equipment_Frame.dtpFunctionDate.getDate();
//        this.functionDate = functionDate.toString();
//    }
     
     private void getAll()
     {
         getID();
         getBookingNo();
         getCustomerNo();
         getFunctionDate();
         getTables();
         getChairs();
         getTableClothes();
         getTableMates();
         getPlates();
         getSpoons();
         getForks();
         getGlasses();
         //getdate();
     }
     
     private void setID() { Cutlery_And_Equipment_Frame.txtId.setText(Cutlery_And_Equipment_Frame.tblCutleryAndEquipment.getValueAt(getSelectedRow(Cutlery_And_Equipment_Frame.tblCutleryAndEquipment), 0).toString());}
     
     private void setBookingNo() { Cutlery_And_Equipment_Frame.txtBookingNo.setText(Cutlery_And_Equipment_Frame.tblCutleryAndEquipment.getValueAt(getSelectedRow(Cutlery_And_Equipment_Frame.tblCutleryAndEquipment), 1).toString());}
     
     private void setCustomerNo() { Cutlery_And_Equipment_Frame.txtCustomerNo.setText(Cutlery_And_Equipment_Frame.tblCutleryAndEquipment.getValueAt(getSelectedRow(Cutlery_And_Equipment_Frame.tblCutleryAndEquipment), 2).toString());}

     private void setTables() { Cutlery_And_Equipment_Frame.txtTables.setText(Cutlery_And_Equipment_Frame.tblCutleryAndEquipment.getValueAt(getSelectedRow(Cutlery_And_Equipment_Frame.tblCutleryAndEquipment), 3).toString());}
     
     private void setChairs() { Cutlery_And_Equipment_Frame.txtChairs.setText(Cutlery_And_Equipment_Frame.tblCutleryAndEquipment.getValueAt(getSelectedRow(Cutlery_And_Equipment_Frame.tblCutleryAndEquipment), 4).toString());}
     
     private void setTableClothes() { Cutlery_And_Equipment_Frame.txtTableClothes.setText(Cutlery_And_Equipment_Frame.tblCutleryAndEquipment.getValueAt(getSelectedRow(Cutlery_And_Equipment_Frame.tblCutleryAndEquipment), 5).toString());}
     
     private void setTableMats() { Cutlery_And_Equipment_Frame.txtTableMats.setText(Cutlery_And_Equipment_Frame.tblCutleryAndEquipment.getValueAt(getSelectedRow(Cutlery_And_Equipment_Frame.tblCutleryAndEquipment), 6).toString());}
     
     private void setPlates() { Cutlery_And_Equipment_Frame.txtPlates.setText(Cutlery_And_Equipment_Frame.tblCutleryAndEquipment.getValueAt(getSelectedRow(Cutlery_And_Equipment_Frame.tblCutleryAndEquipment), 7).toString());}
     
     private void setSpoons() { Cutlery_And_Equipment_Frame.txtSpoons.setText(Cutlery_And_Equipment_Frame.tblCutleryAndEquipment.getValueAt(getSelectedRow(Cutlery_And_Equipment_Frame.tblCutleryAndEquipment), 8).toString());}
     
     private void setForks() { Cutlery_And_Equipment_Frame.txtForks.setText(Cutlery_And_Equipment_Frame.tblCutleryAndEquipment.getValueAt(getSelectedRow(Cutlery_And_Equipment_Frame.tblCutleryAndEquipment), 9).toString());}
     
     private void setGlasses() { Cutlery_And_Equipment_Frame.txtGlasses.setText(Cutlery_And_Equipment_Frame.tblCutleryAndEquipment.getValueAt(getSelectedRow(Cutlery_And_Equipment_Frame.tblCutleryAndEquipment), 10).toString());}
     
     public void setAll()
     {
         setID();
         setBookingNo();
         setCustomerNo();
         setTables();
         setChairs();
         setTableClothes();
         setTableMats();
         setPlates();
         setSpoons();
         setForks();
         setGlasses();
     }
     
      public void add(String tableName) {
           String s="SELECT MAX(`ID`) FROM cutlery_equipment";
            System.out.println(s);
            
            try {
                pst = con.prepareStatement(s);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String st = rst.getString("MAX(`ID`)");
                    if(st==null)
                    {
                        Cutlery_And_Equipment_Frame.txtId.setText("CE-00001");
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
                    
                    String inno = "CE-"+temp;
                    
                    Cutlery_And_Equipment_Frame.txtId.setText(inno);
                    
                    }
                }
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
          
        getAll();
        
        String sql = "INSERT INTO " + tableName + ""
                + "(`ID`,`Booking No`,`Customer No`,`Function Date`,`No of Tables`,`No of Chairs`,`No of Table Mates`,`No of Table Clothes`,`No of plates`,`No of Forks`,`No of Spoons`,`No of Glasess`)"
                + "VALUES("
                + "'"+this.id+"',"
                + "'" + this.bookingNo + "',"
                + "'" + this.customerNo + "',"
                + "'" + this.functiond + "',"
                + "" + this.tables + ","
                + "" + this.chairs + ","
                + "" + this.tableMates + ","
                + "" + this.tableClothes + ","
                + "" + this.plates + ","
                + "" + this.forks + ","
                + "" + this.spoons + ","
                + "" + this.glasses + ""
                + ")";

        JOptionPane.showMessageDialog(null, sql);

        try {
            pst = con.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }

        loadTable("cutlery_equipment", app.event_handling.Cutlery_And_Equipment_Frame.tblCutleryAndEquipment);

    }

    @Override
    public void update(String tableName) {

        getAll();

        String sql = "UPDATE " + tableName + ""
                + " SET `Tables`=" + this.tables + ","
                + "`Chairs`=" + this.chairs + ","
                + "`Table Clothes`=" + this.tableClothes + ","
                + "`Table Mats`=" + this.tableMates + ","
                + "`Plates`=" + this.plates + ","
                + "`Spoons`=" + this.spoons + ","
                + "`Forks`=" + this.forks + ","
                + "`Glasses`=" + this.glasses + ""
                + "WHERE `Booking No` = '" + this.bookingNo + "' and `Custmer No` = '" + this.customerNo + "' and `ID` = " + this.id + "";

        JOptionPane.showMessageDialog(null, sql);

        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            loadTable("cutlery_equipment", Cutlery_And_Equipment_Frame.tblCutleryAndEquipment);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    
    public void Clear()
    {
        Cutlery_And_Equipment_Frame.txtId.setText("");
        Cutlery_And_Equipment_Frame.txtBookingNo.setText("");
        Cutlery_And_Equipment_Frame.txtCustomerNo.setText("");
        Cutlery_And_Equipment_Frame.txtfD.setText("");
        Cutlery_And_Equipment_Frame.txtTables.setText("");
        Cutlery_And_Equipment_Frame.txtChairs.setText("");
        Cutlery_And_Equipment_Frame.txtTableClothes.setText("");
        Cutlery_And_Equipment_Frame.txtTableMats.setText("");
        Cutlery_And_Equipment_Frame.txtPlates.setText("");
        Cutlery_And_Equipment_Frame.txtSpoons.setText("");
        Cutlery_And_Equipment_Frame.txtForks.setText("");
        Cutlery_And_Equipment_Frame.txtGlasses.setText("");
    }
    
//    public void getTotalGuest()
//    {
//        getBookingNo();
//        getCustomerNo();
//        
//        String functonDate = "SELECT `Function Date` FROM view_event_booking WHERE `Booking No`='"+this.bookingNo+"' and `Customer No`='"+this.customerNo+"'";
//        String totalNoOfGuest = "SELECT `Total No Of Guest` FROM view_event_booking WHERE `Booking No`='"+this.bookingNo+"' and `Customer No`='"+this.customerNo+"'";
//        
//    }
    
    public void findCustomerNoFunctonDate()
    {
        getBookingNo();
        
        String customerNoFunctonDate = "SELECT `Customer No`,`Date` FROM view_event_booking WHERE `Booking No`='"+this.bookingNo+"'";
        
        try {
                pst = con.prepareStatement(customerNoFunctonDate);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                  String st = rst.getString("Customer No");
                  Cutlery_And_Equipment_Frame.txtCustomerNo.setText(st);
                  String fdate = rst.getString("Date");
                  Cutlery_And_Equipment_Frame.txtfD.setText(fdate);
                }
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            } 
    }
    
    public void setCutleryItems()
    {
        int noofGuest = 0;
        getBookingNo();
        
        String totalGuest = "SELECT `Total No of Guest` FROM view_event_booking WHERE `Booking No`='"+this.bookingNo+"'";
        JOptionPane.showMessageDialog(null, totalGuest);
        System.out.println(totalGuest);
          try {
                pst = con.prepareStatement(totalGuest);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String nofg = rst.getString("Total No of Guest");
                    noofGuest=Integer.parseInt(nofg);
                    
                }
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
          
          this.tables = noofGuest/10 + 1;
          String tbl = String.valueOf(this.tables);
          Cutlery_And_Equipment_Frame.txtTables.setText(tbl);
          
          this.tableClothes = this.tables;
          String tblCh = String.valueOf(this.tableClothes);
          Cutlery_And_Equipment_Frame.txtTableClothes.setText(tblCh);
          
          this.tableMates = noofGuest+10;
          String tblMts = String.valueOf(this.tableMates);
          Cutlery_And_Equipment_Frame.txtTableMats.setText(tblMts);
          
          this.plates = noofGuest+10;
          String plts = String.valueOf(this.plates);
          Cutlery_And_Equipment_Frame.txtPlates.setText(plts);
          
          this.chairs = noofGuest+10;
          String chs = String.valueOf(this.chairs);
          Cutlery_And_Equipment_Frame.txtChairs.setText(chs);
        
          this.spoons = noofGuest+10;
          String spn = String.valueOf(this.spoons);
          Cutlery_And_Equipment_Frame.txtSpoons.setText(spn);
          
          this.forks = noofGuest+10;
          String fks = String.valueOf(this.forks);
          Cutlery_And_Equipment_Frame.txtForks.setText(fks);
          
          this.glasses =noofGuest+10;
          String gls = String.valueOf(this.glasses);
          Cutlery_And_Equipment_Frame.txtGlasses.setText(gls);
    }
    

    
}
