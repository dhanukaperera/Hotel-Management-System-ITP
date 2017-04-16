/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Dhanuka Perera
 */
public class iReport 
{
    final public static String PROJECT_PATH="E:\\SLIIT Projects\\ITP\\NetBeans Project\\Pavana - Hotel Management System - ITP\\src\\reports";
    
    // For Non Para reports
    public void getReport(String jasperPATH)
    {
        iReportView r = new iReportView( PROJECT_PATH+jasperPATH);
        r.setVisible(true);
    }
    
    // For Non 1 Para reports
    public void getReport(String jasperPATH,String para01)
    {
        HashMap para = new HashMap();
        if(para01.length() != 0)
        {
            para.put("paraissuememberid",para01);
            
            iReportView r = new iReportView(PROJECT_PATH+jasperPATH,para);
            r.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Insert Valid Record","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
     
}
