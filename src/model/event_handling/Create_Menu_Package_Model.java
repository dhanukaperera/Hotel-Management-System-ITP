/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.event_handling;

import app.event_handling.Create_Menu_Package_Frame;
import static app.event_handling.Create_Menu_Package_Frame.tblCreateMenuPackage;
import java.sql.ResultSet;
//import static app.event_handling.Create_Menu_Package_Frame.cmbSearchBy;
//import static app.event_handling.Create_Menu_Package_Frame.txtSearchBox;
import java.util.Date;
import java.util.UUID;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.HMS;
import source.DBConnection;


public class Create_Menu_Package_Model extends HMS {
    private String menuPackageNo;
    private String foodType;
    private String name;
    private String itemId;
    private float price;
    
    
    public Create_Menu_Package_Model()
    {
        con = DBConnection.connect();
        
        this.menuPackageNo = "NULL";
        this.foodType = "NULL";
        this.name = "NULL";
        this.itemId = "NULL";
        this.price = 0;
    }
    
    public String getPrimaryKey()
    {
        getItemID();
        return this.itemId;
    }
    
    private void getItemID(){this.itemId = Create_Menu_Package_Frame.txtItemID.getText(); }
    
    public String getMenuPackegeNo(){
        this.menuPackageNo = Create_Menu_Package_Frame.txtMenuPackegeNo.getText();
        return this.menuPackageNo;
    }
    
    private void getName(){this.name = Create_Menu_Package_Frame.txtName.getText();}
    
    private void getFoodType(){this.foodType = Create_Menu_Package_Frame.cmbFoodType.getSelectedItem().toString();}
    
    private void getPrice(){this.price = Float.parseFloat(Create_Menu_Package_Frame.txtPrice.getText());}
    
    
    public void getAll(){
        getItemID();
        getMenuPackegeNo();
        getFoodType();
        getName();
        getPrice();
    }
    
    
    private void setItemID(){Create_Menu_Package_Frame.txtItemID.setText(Create_Menu_Package_Frame.tblCreateMenuPackage.getValueAt(getSelectedRow(Create_Menu_Package_Frame.tblCreateMenuPackage), 0).toString());}
    
    private void setMenuPackegeNo()
    {   
        //JOptionPane.showMessageDialog(null, "uvh");
        Create_Menu_Package_Frame.txtMenuPackegeNo.setText(Create_Menu_Package_Frame.tblCreateMenuPackage.getValueAt(getSelectedRow(Create_Menu_Package_Frame.tblCreateMenuPackage), 1).toString());
        String x = Create_Menu_Package_Frame.tblCreateMenuPackage.getValueAt(getSelectedRow(Create_Menu_Package_Frame.tblCreateMenuPackage), 1).toString();
       // JOptionPane.showMessageDialog(null, x);
    }
    
    private void setFoodType(){Create_Menu_Package_Frame.cmbFoodType.setSelectedItem(Create_Menu_Package_Frame.tblCreateMenuPackage.getValueAt(getSelectedRow(Create_Menu_Package_Frame.tblCreateMenuPackage), 2).toString());}
    
    private void setName(){Create_Menu_Package_Frame.txtName.setText(Create_Menu_Package_Frame.tblCreateMenuPackage.getValueAt(getSelectedRow(Create_Menu_Package_Frame.tblCreateMenuPackage), 3).toString());}
    
    private void setPrice(){Create_Menu_Package_Frame.txtPrice.setText(Create_Menu_Package_Frame.tblCreateMenuPackage.getValueAt(getSelectedRow(Create_Menu_Package_Frame.tblCreateMenuPackage), 4).toString());}
    
    public void setAll()
    {
       // JOptionPane.showMessageDialog(null, "lll");
        setItemID();
        setMenuPackegeNo();
        setFoodType();
        setName();
        setPrice();
    }
    
    public void generateNewMenu()
    {
      String s="SELECT MAX(`Menu No`) FROM event_menu";
            System.out.println(s);
            
            try {
                pst = con.prepareStatement(s);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String st = rst.getString("MAX(`Menu No`)");
                    if(st==null)
                    {
                        Create_Menu_Package_Frame.txtMenuPackegeNo.setText("MPNO-00001");
                    }
                    else
                    {
                        
                        String temp = st.substring(5,10);
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
                    
                    String inno = "MPNO-"+temp;
                    
                    Create_Menu_Package_Frame.txtMenuPackegeNo.setText(inno);
                    
                    }
                }
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            } 
        
    }

    @Override
    public void add(String tableName) {
        String s="SELECT MAX(`ID`) FROM event_menu";
            System.out.println(s);
            
            try {
                pst = con.prepareStatement(s);
                ResultSet rst = pst.executeQuery();
                if(rst.next())
                {
                    String st = rst.getString("MAX(`ID`)");
                    if(st==null)
                    {
                        Create_Menu_Package_Frame.txtItemID.setText("ID-00001");
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
                    
                    String inno = "ID-"+temp;
                    
                    Create_Menu_Package_Frame.txtItemID.setText(inno);
                    
                    }
                }
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            } 
        
        getAll();
        
        String sql = "INSERT INTO "+tableName+""
                +"(`ID`,`Menu No`,`Food Type`,`Name`,`Price`)"
                +"VALUES("
                +"'"+this.itemId+"',"
                +"'"+this.menuPackageNo+"',"
                +"'"+this.foodType+"',"
                +"'"+this.name+"',"
                +""+this.price+""
                +")";
        
        JOptionPane.showMessageDialog(null,sql);
     
            try 
            {
                pst = con.prepareStatement(sql);
                pst.execute();
            } 
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
            
            loadTable("event_menu",app.event_handling.Create_Menu_Package_Frame.tblCreateMenuPackage);
      
       
    }

    @Override
    public void update(String tableName) {
         
        getAll();
       // this.itemId = Create_Menu_Package_Frame.tblCreateMenuPackage.getValueAt(getSelectedRow(Create_Menu_Package_Frame.tblCreateMenuPackage), 0).toString();
        String sql = " UPDATE "+tableName+""
                //+"'"+this.menuPackageNo+"',"
                + " SET`Food Type` ='"+this.foodType+"',"
                + "`Name` ='"+this.name+"',"
                + "`Price` ="+this.price+""
                + " WHERE `ID` = '"+ this.itemId +"' AND `Menu No` = '"+ this.menuPackageNo +"'";
                
        JOptionPane.showMessageDialog(null, sql);
        
        try 
        {
                pst = con.prepareStatement(sql);
                pst.execute();
                loadTable("event_menu",Create_Menu_Package_Frame.tblCreateMenuPackage);   
        } 
        catch (Exception e) 
        {
               
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void Clear()
    {
        Create_Menu_Package_Frame.txtItemID.setText("");
        Create_Menu_Package_Frame.txtMenuPackegeNo.setText("");
        Create_Menu_Package_Frame.txtName.setText("");
        Create_Menu_Package_Frame.txtPrice.setText("");
    }
    
//        public void Modelsearch()
//    {
//        String filters = cmbSearchBy.getSelectedItem().toString();
//        String filter = "`"+filters+"`";
//        String search=txtSearchBox.getText();
//        String tablename = "event_menu";
//        JTable tblName = tblCreateMenuPackage;
//        
//        search(filter,search,tablename,tblName);
//
//    }

    
    
}
