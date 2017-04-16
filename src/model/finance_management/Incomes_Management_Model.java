/*
 * Hotel Management System for Pavana Hotel Kochchikade
 * Information Technology Project - 2016
 * Project ID   : ITP_WD_16_B1_06
 * Supervisor   : Mrs. Asanthika Imbulpitiya
 *
 * Student Name : Rathnayaka W.R.A.C.J   
 * IT Number    : IT14036644
*/
package model.finance_management;

import app.finance_management.Incomes_Management_Frame ;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.chart.BarChart;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.HMS;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import reports.iReport;
import reports.iReportView;
import source.DBConnection;

public class Incomes_Management_Model extends HMS 
{
    
    private String incomeNo ;
    private String income ;
    private String department ;
    private int amount ;
    
    
  
    
    public Incomes_Management_Model ()
    {
        con = DBConnection.connect();
      
        
        this.incomeNo = "NULL" ;
        this.income = "No Income" ;
        this.department = "No Department";
        this.amount = 0 ;
        colList = "`Income ID`,`Date Modified`,`Income`,`Amount`,`Department`";
        // System.out.println(colList);
        
    }
    
    public void test()
    {
        
    }
    
    public String getPrimaryKey()
    {
        setincomeNo();
        getincomeNo();
        return this.incomeNo;
    }
    // -------------------------------------------------------------------------
    // -- BEGIN Getting Values -------------------------------------------------
      
     private void getincomeNo() 
    { 
        this.incomeNo = Incomes_Management_Frame.txtIncomeNo.getText();
    }
     
      private void getincome() 
    { 
        this.income = Incomes_Management_Frame.txtIncome.getText();
    }
      
        private void getdepartment() 
    { 
        this.department = Incomes_Management_Frame.cmbDepartment.getSelectedItem().toString();
    }
      
      private void getamount() 
    { 
        this.amount = Integer.parseInt(Incomes_Management_Frame.txtAmount.getText()) ;
    }
      
    
      
     private void getAll()
    {
        getincomeNo();
        getincome();
        getdepartment();
        getamount();
    }
    
    // -- END SET Values -------------------------------------------------------
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    // -- BEGIN Setting Values -------------------------------------------------
   
       private void setincomeNo() 
       { 
         Incomes_Management_Frame.txtIncomeNo.setText(Incomes_Management_Frame.tblIncomes.getValueAt(getSelectedRow(Incomes_Management_Frame.tblIncomes), 0).toString());
       }
       
       private void setincome() 
       { 
         Incomes_Management_Frame.txtIncome.setText(Incomes_Management_Frame.tblIncomes.getValueAt(getSelectedRow(Incomes_Management_Frame.tblIncomes), 2).toString());
       }
       
        private void setdepartment() 
       { 
         Incomes_Management_Frame.cmbDepartment.setSelectedItem(Incomes_Management_Frame.tblIncomes.getValueAt(getSelectedRow(Incomes_Management_Frame.tblIncomes), 4).toString());
       }
     
       private void setamount() 
       { 
         Incomes_Management_Frame.txtAmount.setText(Incomes_Management_Frame.tblIncomes.getValueAt(getSelectedRow(Incomes_Management_Frame.tblIncomes), 3).toString());
       }
       
        public void setAll()
     {
         setincomeNo();
         setincome();
         setdepartment();
         setamount();
                    
     }
        
    // -- END Setting Values ---------------------------------------------------
    // -------------------------------------------------------------------------
        
       
   
            
    @Override
    public void add(String tableName)
    {             
        getAll();
        String primaryval = "INM";
        String sql = "INSERT INTO "+tableName+""
                + "(`Income ID`,`Income`,`Date Modified`,`Amount`,`Department`)"
                + " VALUES("
                + "'"+generatePrimaryKey("Income ID", tableName, primaryval)+"',"
                + "'"+this.income+"',"
                + "'"+getCurrentDateTime()+"',"
                + "'"+this.amount+"',"
                + "'"+this.department+"'"
                + ")";
        System.out.println(sql);
       
        
        try 
        {
            pst = con.prepareStatement(sql);
            pst.execute();
            loadTable(tableName,Incomes_Management_Frame.tblIncomes);   
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }     
    } 
    
    public void barchart(String Department){
           DefaultCategoryDataset incomedata = new DefaultCategoryDataset();
           String sqlrrday = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,10) FROM incomes_management WHERE Department='"+Department+"' GROUP BY SUBSTRING(`Date Modified`,1,10)";
           String sqlrrmonth = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,7) FROM incomes_management WHERE Department='"+Department+"' GROUP BY SUBSTRING(`Date Modified`,1,7)";
           String sqlrryear = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,4) FROM incomes_management WHERE Department='"+Department+"' GROUP BY SUBSTRING(`Date Modified`,1,4)";
           
           
            if(Incomes_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Daily")){
            try 
            {
               pst = con.prepareStatement(sqlrrday);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String date = rst.getString("SUBSTRING(`Date Modified`,1,10)");
                  float value = Float.parseFloat(amounts);    
                  incomedata.setValue(value,"Income Per Day",date);
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           }
           else if(Incomes_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Monthly")){
            try 
            {
               pst = con.prepareStatement(sqlrrmonth);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String month = rst.getString("SUBSTRING(`Date Modified`,1,7)");
                  float value = Float.parseFloat(amounts);    
                  incomedata.setValue(value,"Income Per Month",month);
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           
           }
           else if(Incomes_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Annualy")){
           try 
            {
               pst = con.prepareStatement(sqlrryear);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String year = rst.getString("SUBSTRING(`Date Modified`,1,4)");
                  float value = Float.parseFloat(amounts);    
                  incomedata.setValue(value,"Income Per year",year);
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           
           }
          
        JFreeChart incomedatabarchart = ChartFactory.createBarChart("Income Management","Time period","Income",incomedata ,PlotOrientation.VERTICAL,false,true,false);
        CategoryPlot incomedatabarchrt = incomedatabarchart.getCategoryPlot();
        incomedatabarchrt.setRangeGridlinePaint(Color.BLUE);
        
        ChartPanel barpanel = new ChartPanel(incomedatabarchart);
        Incomes_Management_Frame.panelchart.removeAll();
        Incomes_Management_Frame.panelchart.add(barpanel,BorderLayout.CENTER);
        Incomes_Management_Frame.panelchart.validate(); 
       }
    
    public void piechart(String Department){
        DefaultPieDataset piedataset = new DefaultPieDataset() ;
        String sqlrrday = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,10) FROM incomes_management WHERE Department='"+Department+"' GROUP BY SUBSTRING(`Date Modified`,1,10)";
        String sqlrrmonth = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,7) FROM incomes_management WHERE Department='"+Department+"' GROUP BY SUBSTRING(`Date Modified`,1,7)";
        String sqlrryear = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,4) FROM incomes_management WHERE Department='"+Department+"' GROUP BY SUBSTRING(`Date Modified`,1,4)";        
           
           if(Incomes_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Daily")){
            try 
            {
               pst = con.prepareStatement(sqlrrday);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String date = rst.getString("SUBSTRING(`Date Modified`,1,10)");
                  float value = Float.parseFloat(amounts);    
                
                piedataset.setValue(date,new Float(value));
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           }
           else if(Incomes_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Monthly")){
            try 
            {
               pst = con.prepareStatement(sqlrrmonth);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String month = rst.getString("SUBSTRING(`Date Modified`,1,7)");
                  float value = Float.parseFloat(amounts);    
              
                piedataset.setValue(month,new Float(value));
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           
           }
           else if(Incomes_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Annualy")){
           try 
            {
               pst = con.prepareStatement(sqlrryear);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String year = rst.getString("SUBSTRING(`Date Modified`,1,4)");
                  float value = Float.parseFloat(amounts);    
               
               piedataset.setValue(year,new Float(value));
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
            
              
             
             }
         
             JFreeChart chart = ChartFactory.createPieChart("Income Management", piedataset, true, true, true);
             PiePlot P = (PiePlot)chart.getPlot();
             
             ChartPanel barpanel = new ChartPanel(chart);
             Incomes_Management_Frame.panelchart.removeAll();
             Incomes_Management_Frame.panelchart.add(barpanel,BorderLayout.CENTER);
             Incomes_Management_Frame.panelchart.validate();
    
    
    
    
    }
    
    public void linechart(String Department){
       DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String sqlrrday = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,10) FROM incomes_management WHERE Department='"+Department+"' GROUP BY SUBSTRING(`Date Modified`,1,10)";
        String sqlrrmonth = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,7) FROM incomes_management WHERE Department='"+Department+"' GROUP BY SUBSTRING(`Date Modified`,1,7)";
        String sqlrryear = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,4) FROM incomes_management WHERE Department='"+Department+"' GROUP BY SUBSTRING(`Date Modified`,1,4)";                  
           
           if(Incomes_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Daily")){
            try 
            {
               pst = con.prepareStatement(sqlrrday);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String date = rst.getString("SUBSTRING(`Date Modified`,1,10)");
                  float value = Float.parseFloat(amounts);    
                  dataset.setValue(new Double(value), "Incomes",date );
          
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           }
           else if(Incomes_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Monthly")){
            try 
            {
               pst = con.prepareStatement(sqlrrmonth);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String month = rst.getString("SUBSTRING(`Date Modified`,1,7)");
                  float value = Float.parseFloat(amounts);    
                  dataset.setValue(new Double(value), "Incomes",month );
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           
           }
           else if(Incomes_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Annualy")){
           try 
            {
               pst = con.prepareStatement(sqlrryear);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String year = rst.getString("SUBSTRING(`Date Modified`,1,4)");
                  float value = Float.parseFloat(amounts);    
                  dataset.setValue(new Double(value), "Incomes",year );
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
                 
             }
                    
             JFreeChart chart = ChartFactory.createLineChart("Income Management","Time period","Incomes",dataset, PlotOrientation.VERTICAL,false,true,true);
             chart.setBackgroundPaint(Color.YELLOW);
             chart.getTitle().setPaint(Color.RED);
             CategoryPlot P = chart.getCategoryPlot();
             P.setRangeGridlinePaint(Color.BLUE);
             
             ChartPanel barpanel = new ChartPanel(chart);
             Incomes_Management_Frame.panelchart.removeAll();
             Incomes_Management_Frame.panelchart.add(barpanel,BorderLayout.CENTER);
             Incomes_Management_Frame.panelchart.validate(); 
    
    
    }
     
    public void charts(){
             
    if(Incomes_Management_Frame.cmbBarchart.getSelectedItem().equals("Bar chart") && Incomes_Management_Frame.cmbDepartment.getSelectedItem().equals("Room Reservation") ){
        barchart("Room Reservation");
    }
    else if(Incomes_Management_Frame.cmbBarchart.getSelectedItem().equals("Bar chart") && Incomes_Management_Frame.cmbDepartment.getSelectedItem().equals("Restaurant ")){
        barchart("Restaurant ");
    }
    else if(Incomes_Management_Frame.cmbBarchart.getSelectedItem().equals("Bar chart") && Incomes_Management_Frame.cmbDepartment.getSelectedItem().equals("Events")){
        barchart("Events");
    }
    else if(Incomes_Management_Frame.cmbBarchart.getSelectedItem().equals("Bar chart") && Incomes_Management_Frame.cmbDepartment.getSelectedItem().equals("Laundry and Room Service")){
        barchart("Laundry and Room Service");
    }
    else if(Incomes_Management_Frame.cmbBarchart.getSelectedItem().equals("Bar chart") && Incomes_Management_Frame.cmbDepartment.getSelectedItem().equals("Other")){
        barchart("Other");
    }
    else if(Incomes_Management_Frame.cmbBarchart.getSelectedItem().equals("Bar chart") && Incomes_Management_Frame.cmbDepartment.getSelectedItem().equals("Transport and Tour Management")){
        barchart("Transport and Tour Management");
    }
    else if(Incomes_Management_Frame.cmbBarchart.getSelectedItem().equals("Bar chart") && Incomes_Management_Frame.cmbDepartment.getSelectedItem().equals("All")){
        DefaultCategoryDataset incomedata = new DefaultCategoryDataset();
        String sqlday = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,10)  FROM incomes_management GROUP BY SUBSTRING(`Date Modified`,1,10)" ;
        String sqlmonth = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,7) FROM incomes_management GROUP BY SUBSTRING(`Date Modified`,1,7)" ;
        String sqlyear = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,4) FROM incomes_management GROUP BY SUBSTRING(`Date Modified`,1,4)" ;     
           
           if(Incomes_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Daily")){
            try 
            {
               pst = con.prepareStatement(sqlday);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String date = rst.getString("SUBSTRING(`Date Modified`,1,10)");
                  float value = Float.parseFloat(amounts);    
                  incomedata.setValue(value,"Income Per Day",date);
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           }
           else if(Incomes_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Monthly")){
            try 
            {
               pst = con.prepareStatement(sqlmonth);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String month = rst.getString("SUBSTRING(`Date Modified`,1,7)");
                  float value = Float.parseFloat(amounts);    
                  incomedata.setValue(value,"Income Per year",month);
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           
           }
           else if(Incomes_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Annualy")){
           try 
            {
               pst = con.prepareStatement(sqlyear);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String year = rst.getString("SUBSTRING(`Date Modified`,1,4)");
                  float value = Float.parseFloat(amounts);    
                  incomedata.setValue(value,"Income Per month",year);
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           
           }
          
        JFreeChart incomedatabarchart = ChartFactory.createBarChart("Income Management","Day","Income",incomedata ,PlotOrientation.VERTICAL,false,true,false);
        CategoryPlot incomedatabarchrt = incomedatabarchart.getCategoryPlot();
        incomedatabarchrt.setRangeGridlinePaint(Color.BLUE);
        
        ChartPanel barpanel = new ChartPanel(incomedatabarchart);
        Incomes_Management_Frame.panelchart.removeAll();
        Incomes_Management_Frame.panelchart.add(barpanel,BorderLayout.CENTER);
        Incomes_Management_Frame.panelchart.validate(); 
         //barchart("All");
    }
    else if(Incomes_Management_Frame.cmbBarchart.getSelectedItem().equals("Pie chart") && Incomes_Management_Frame.cmbDepartment.getSelectedItem().equals("Room Reservation")){
        piechart("Room Reservation");
    }
    else if(Incomes_Management_Frame.cmbBarchart.getSelectedItem().equals("Pie chart") && Incomes_Management_Frame.cmbDepartment.getSelectedItem().equals("Restaurant ")){
        piechart("Restaurant ");
    }
    else if(Incomes_Management_Frame.cmbBarchart.getSelectedItem().equals("Pie chart") && Incomes_Management_Frame.cmbDepartment.getSelectedItem().equals("Events")){
        piechart("Events");
    }
    else if(Incomes_Management_Frame.cmbBarchart.getSelectedItem().equals("Pie chart") && Incomes_Management_Frame.cmbDepartment.getSelectedItem().equals("Laundry and Room Service")){
        piechart("Laundry and Room Service");
    }
    else if(Incomes_Management_Frame.cmbBarchart.getSelectedItem().equals("Pie chart") && Incomes_Management_Frame.cmbDepartment.getSelectedItem().equals("Transport and Tour Management")){
        piechart("Transport and Tour Management");
    }
    else if(Incomes_Management_Frame.cmbBarchart.getSelectedItem().equals("Pie chart") && Incomes_Management_Frame.cmbDepartment.getSelectedItem().equals("Other")){
        piechart("Other");
    }
    else if(Incomes_Management_Frame.cmbBarchart.getSelectedItem().equals("Pie chart") && Incomes_Management_Frame.cmbDepartment.getSelectedItem().equals("All")){
        DefaultPieDataset piedataset = new DefaultPieDataset() ;
        String sqlday = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,10)  FROM incomes_management GROUP BY SUBSTRING(`Date Modified`,1,10)" ;
        String sqlmonth = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,7) FROM incomes_management GROUP BY SUBSTRING(`Date Modified`,1,7)" ;
        String sqlyear = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,4) FROM incomes_management GROUP BY SUBSTRING(`Date Modified`,1,4)" ;     
           
           if(Incomes_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Daily")){
            try 
            {
               pst = con.prepareStatement(sqlday);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String date = rst.getString("SUBSTRING(`Date Modified`,1,10)");
                  float value = Float.parseFloat(amounts);    
                
                piedataset.setValue(date,new Float(value));
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           }
           else if(Incomes_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Monthly")){
            try 
            {
               pst = con.prepareStatement(sqlmonth);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String month = rst.getString("SUBSTRING(`Date Modified`,1,7)");
                  float value = Float.parseFloat(amounts);    
              
                piedataset.setValue(month,new Float(value));
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           
           }
           else if(Incomes_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Annualy")){
           try 
            {
               pst = con.prepareStatement(sqlyear);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String year = rst.getString("SUBSTRING(`Date Modified`,1,4)");
                  float value = Float.parseFloat(amounts);    
               
               piedataset.setValue(year,new Float(value));
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
            
              
             
             }
         
             JFreeChart chart = ChartFactory.createPieChart("Income Management", piedataset, true, true, true);
             PiePlot P = (PiePlot)chart.getPlot();
             
             ChartPanel barpanel = new ChartPanel(chart);
             Incomes_Management_Frame.panelchart.removeAll();
             Incomes_Management_Frame.panelchart.add(barpanel,BorderLayout.CENTER);
             Incomes_Management_Frame.panelchart.validate(); 
        
    }
    else if(Incomes_Management_Frame.cmbBarchart.getSelectedItem().equals("Line chart") && Incomes_Management_Frame.cmbDepartment.getSelectedItem().equals("Room Reservation")){
         linechart("Room Reservation");
    }
    else if(Incomes_Management_Frame.cmbBarchart.getSelectedItem().equals("Line chart") && Incomes_Management_Frame.cmbDepartment.getSelectedItem().equals("Restaurant ")){
         linechart("Restaurant ");
    }
    else if(Incomes_Management_Frame.cmbBarchart.getSelectedItem().equals("Line chart") && Incomes_Management_Frame.cmbDepartment.getSelectedItem().equals("Events")){
         linechart("Events");
    }
    else if(Incomes_Management_Frame.cmbBarchart.getSelectedItem().equals("Line chart") && Incomes_Management_Frame.cmbDepartment.getSelectedItem().equals("Laundry and Room Service")){
         linechart("Laundry and Room Service");
    }
    else if(Incomes_Management_Frame.cmbBarchart.getSelectedItem().equals("Line chart") && Incomes_Management_Frame.cmbDepartment.getSelectedItem().equals("Other")){
         linechart("Other");
    }
     else if(Incomes_Management_Frame.cmbBarchart.getSelectedItem().equals("Line chart") && Incomes_Management_Frame.cmbDepartment.getSelectedItem().equals("Tour and Transport Management")){
         linechart("Tour and Transport Management");
    }
    
    else if(Incomes_Management_Frame.cmbBarchart.getSelectedItem().equals("Line chart") && Incomes_Management_Frame.cmbDepartment.getSelectedItem().equals("All")){
           DefaultCategoryDataset dataset = new DefaultCategoryDataset();
           String sqlday = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,10)  FROM incomes_management GROUP BY SUBSTRING(`Date Modified`,1,10)" ;
           String sqlmonth = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,7) FROM incomes_management GROUP BY SUBSTRING(`Date Modified`,1,7)" ;
           String sqlyear = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,4) FROM incomes_management GROUP BY SUBSTRING(`Date Modified`,1,4)" ;     
           
           if(Incomes_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Daily")){
            try 
            {
               pst = con.prepareStatement(sqlday);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String date = rst.getString("SUBSTRING(`Date Modified`,1,10)");
                  float value = Float.parseFloat(amounts);    
                  dataset.setValue(new Double(value), "Incomes",date );
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           }
           else if(Incomes_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Monthly")){
            try 
            {
               pst = con.prepareStatement(sqlmonth);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String month = rst.getString("SUBSTRING(`Date Modified`,1,7)");
                  float value = Float.parseFloat(amounts);    
                  dataset.setValue(new Double(value), "Incomes",month );
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           
           }
           else if(Incomes_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Annualy")){
           try 
            {
               pst = con.prepareStatement(sqlyear);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String year = rst.getString("SUBSTRING(`Date Modified`,1,4)");
                  float value = Float.parseFloat(amounts);    
                  dataset.setValue(new Double(value), "Incomes",year );
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
                 
             }
                    
             JFreeChart chart = ChartFactory.createLineChart("Income Management","Day","Incomes",dataset, PlotOrientation.VERTICAL,false,true,true);
             chart.setBackgroundPaint(Color.YELLOW);
             chart.getTitle().setPaint(Color.RED);
             CategoryPlot P = chart.getCategoryPlot();
             P.setRangeGridlinePaint(Color.BLUE);
             
             ChartPanel barpanel = new ChartPanel(chart);
             Incomes_Management_Frame.panelchart.removeAll();
             Incomes_Management_Frame.panelchart.add(barpanel,BorderLayout.CENTER);
             Incomes_Management_Frame.panelchart.validate();
    }
    else {
           System.out.println("Select a Chart to View");
    }
     
    } 
    
    @Override
    public void update(String tableName)
    {   
        getAll();
     
        String sql = "UPDATE "+tableName+""
                + " SET `Income` = "+ "'" + this.income + "',"
                + "`Date Modified`= '" + getCurrentDateTime() + "',"
                + "`Amount` = " + this.amount + ","
                + "`Department`='" + this.department + "' "
                + "WHERE `Income ID` = '" + this.incomeNo + "'";
        
        System.out.println(sql);
        
        try 
        {
                pst = con.prepareStatement(sql);
                pst.execute();
                loadTable(tableName,Incomes_Management_Frame.tblIncomes);   
        } 
        catch (Exception e) 
        {
               
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void Modelsearch()
    {
        String filters = Incomes_Management_Frame.cmbSearchBy.getSelectedItem().toString();
        String filter = "`"+filters+"`";
        String search=Incomes_Management_Frame.txtSearch.getText();
        
        String tablename = "incomes_management";
        JTable tblName = Incomes_Management_Frame.tblIncomes;
        
        search(filter,search,tablename,tblName);
        
    }
    
    
    public void zeroincome(){
    
    String checkdate = "SELECT SUBSTRING(expenses_management.`Date Modified`,1,10) FROM expenses_management LEFT JOIN incomes_management ON (SUBSTRING(expenses_management.`Date Modified`,1,10)=SUBSTRING(incomes_management.`Date Modified`,1,10)) WHERE SUBSTRING(incomes_management.`Date Modified`,1,10) IS NULL" ;
    try 
            {
               pst = con.prepareStatement(checkdate);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String expenseday = rst.getString("SUBSTRING(expenses_management.`Date Modified`,1,10)");
                  System.out.println(expenseday);  
                  String zero = "Insert into incomes_management(`Income ID`,`Income`,`Date Modified`,`Amount`,`Department`)VALUES('NO ID','NO EXPENSE','"+expenseday+"',0,'NO DEPARTMENT')";
                  try
                  {
                      pst = con.prepareStatement(zero);
                      pst.execute();
                  }
                  catch (Exception e) 
                  {
                    JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
                  }   
                 // System.out.println(incomeday);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
     
    
    }
    
      public void report()
    {
        iReport z = new iReport();
        iReportView r = new iReportView(z.PROJECT_PATH +"\\finance_management\\Incomes.jasper");
        
        r.setVisible(true);
    }
      
    public void deleteother(){
    
    
    
    }
      
    
      
    
    
}


