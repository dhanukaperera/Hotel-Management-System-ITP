
package reports;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.sf.jasperreports.engine.JasperPrint;
import javax.swing.*;
import java.util.HashMap;
import net.sf.jasperreports.view.JRViewer;
import java.awt.Container;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JRException;
import source.DBConnection;

public class iReportView extends JFrame {
    
    public iReportView (String filename)
    {
        this(filename,null);
    }
    
    public iReportView(String filename, HashMap para)
    {
     super("Pavana Hotel Management System");
        
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
     con = DBConnection.connect();
     
     try
     {    
         JasperPrint print = JasperFillManager.fillReport(filename, para,con);
         JRViewer viewer = new JRViewer(print);
         Container c = getContentPane();
         c.add(viewer);
        
         
     }
     catch(JRException jRException)
     {
         JOptionPane.showMessageDialog(null, jRException);
     }
     
        setBounds(10,10,900,700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }
    
    
}
