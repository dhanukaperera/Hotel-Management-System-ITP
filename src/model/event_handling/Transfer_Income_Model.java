/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.event_handling;

import app.event_handling.Transfer_Income_Frame;
import javax.swing.JOptionPane;
import model.HMS;
import source.DBConnection;

public class Transfer_Income_Model extends HMS{
    
    private String invoiceNo;
    private String amount;
   // private String time;
   // private String userID;

     public Transfer_Income_Model()
    {
        con = DBConnection.connect();
        
        this.invoiceNo = "NULL";
        this.amount = "NULL";
       // this.time = "NULL";
       // this.userID = "NULL";
    }
    
     public String getPrimaryKey()
    {
        getInvoiceNo();
        //setCustomerNo();
        return this.invoiceNo;
    }
     
    private void getInvoiceNo() { this.invoiceNo = Transfer_Income_Frame.txtInvoiceNo.getText(); }
    
    private void getAmount() { this.amount = Transfer_Income_Frame.txtTotalAmount.getText(); }
    
    public void getAll()
    {
        getInvoiceNo();
        getAmount();
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
