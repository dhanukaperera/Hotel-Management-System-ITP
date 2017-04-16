/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.laundry_and_room_service;

import app.laundry_and_room_service.Finance_Frame;
import javax.swing.JTable;
import model.HMS;
import reports.iReportView;
import source.DBConnection;

/**
 *
 * @author User
 */
public class Finance_Model extends HMS
{
    private String startdate;
    private String enddate;
    
    public Finance_Model ()
    {
        con = DBConnection.connect();
        
        
        this.startdate = "NULL";
        this.enddate = "NULL";
        //super.colList = "`Finance ID`,`Date`,`Order No`,`Type`,`Price`";
        System.out.println(colList);
    }
    
//    private void getStartDate () { this.startdate = Finance_Frame.txtStartdate.getText(); }
//    
//    private void getEndDate () { this.startdate = Finance_Frame.txtEnddate.getText(); }
    
//    private void getall()
//    {
//        getStartDate ();
//        getEndDate ();
//    }

    @Override
    public void add(String tableName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(String tableName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    public void caltrans ()
//    {   
//        String td = getCurrentDateTime();
//        
//        String ttyea = td.substring(0, 4);
//        String ttmon = td.substring(5,7);
//        String ttday = td.substring(8,10);
//        
//        int pttday = Integer.parseInt(ttday);
//        int rpttday = pttday-1;
//        String frpttday = String.valueOf(rpttday);
//        
//        String tcfultdate = ttyea+ttmon+frpttday;
//        int cfultdate = Integer.parseInt(tcfultdate);
//        
//        //JOptionPane.showMessageDialog(null,tcfultdate);
//        //JOptionPane.showMessageDialog(null,rpttday);
//        
//        int i = Finance_Frame.tblFinance.getRowCount();
//        int j = i-1;
//        float tot = 0;
//        
//        for (int x=0; x<=j;x++)
//        {
//            String ono = (Finance_Frame.tblFinance.getValueAt(x, 1)).toString();
//            String temp = (Finance_Frame.tblFinance.getValueAt(x, 4)).toString();
//            String tyea = ono.substring(0, 4);
//            String tmon = ono.substring(5,7);
//            String tday = ono.substring(8,10);
//            String tfultdate = tyea+tmon+tday;
//        
//            int fultdate = Integer.parseInt(tfultdate);
//            
//                if(cfultdate == fultdate)
//                    {
//                    float tem = Float.parseFloat(temp);
//                    tot = tot + tem;
//                    }
//        }
//        
//        JOptionPane.showMessageDialog(null,tot);
//        
//        String fin = "INSERT INTO incomes_management "
//                + "( `Income`,`Date`,`Amount`,`Department`)"
//                + " VALUES("
//                + "'Laundry and Room Service',"
//                + "'"+getCurrentDateTime()+"',"
//                + "'"+tot+"',"
//                + "'Laundry and Room Service'"
//                + ")";  
//        
//        try 
//        {
//            pst = con.prepareStatement(fin);
//            pst.execute();  
//            //loadTable("finance", Finance_Frame.tblFinance);
//        }
//        catch (Exception e) 
//        {
//            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
//        }
//    }
//    
    public void Modelsearch()
    {
        String filters = Finance_Frame.cmbSearchBy.getSelectedItem().toString();
        String filter = "`"+filters+"`";
        String search= Finance_Frame.txtSearchBox.getText();
        String tablename = "finance";
        JTable tblName = Finance_Frame.tblFinance;
        
        search(filter,search,tablename,tblName);

    }
 
    
    public void report(){
    
        iReportView rr = new iReportView("E:\\SLIIT Projects\\ITP\\NetBeans Project\\Pavana - Hotel Management System - ITP\\src\\reports\\laundry_and_room_services\\finance.jasper");
        rr.setVisible(true);
    
    }
    
}
