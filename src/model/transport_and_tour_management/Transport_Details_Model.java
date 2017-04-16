/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.transport_and_tour_management;

import app.transport_and_tour_management.Transport_Details_Frame;
import javax.swing.JOptionPane;
import model.HMS;
import source.DBConnection;

/**
 *
 * @author _AI_
 */
public class Transport_Details_Model extends HMS{

    public Transport_Details_Model()
    {
    con = DBConnection.connect();
    //colList="`Transport ID`,`Date Modified`,`Customer ID`,`Type`,`Vehicle Type`,`Amount`";
    
    
    }
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
//        //JOptionPane.showMessageDialog(null,cfultdate);
//        //JOptionPane.showMessageDialog(null,rpttday);
//        
//        int i = Transport_Details_Frame.tblTrasport_Details_Frame.getRowCount();
//        int j = i-1;
//        float tot = 0;
//        
//        //JOptionPane.showMessageDialog(null,j);
//        
//        for (int x=0; x<=j;x++)
//        {
//            String ono = (Transport_Details_Frame.tblTrasport_Details_Frame.getValueAt(x, 1)).toString();
//            String temp = (Transport_Details_Frame.tblTrasport_Details_Frame.getValueAt(x, 5)).toString();
//            String tyea = ono.substring(0, 4);
//            String tmon = ono.substring(5,7);
//            String tday = ono.substring(8,10);
//            String tfultdate = tyea+tmon+tday;
//            
//            
//            //JOptionPane.showMessageDialog(null,temp);
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
//        //JOptionPane.showMessageDialog(null,tot);
//        
//        String fin = "INSERT INTO incomes_management "
//                + "( `Income`,`Date Modified`,`Amount`,`Department`)"
//                + " VALUES("
//                + "'Transport And Tour Managemnt',"
//                + "'"+getCurrentDateTime()+"',"
//                + "'"+tot+"',"
//                + "'Transport And Tour Managemnt'"
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
    
    
    
}
