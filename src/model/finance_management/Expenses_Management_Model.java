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

import app.finance_management.Expenses_Management_Frame;
import app.finance_management.Expenses_Management_Frame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class Expenses_Management_Model extends HMS {
    
    private String expenseNo ;
    private String expense ;
    private String department ;
    private int amount ;
    
    public Expenses_Management_Model ()
    {
        con = DBConnection.connect();
        this.expenseNo = "NULL" ;
        this.expense = "No Expense" ;
        this.department = "No Department";
        this.amount = 0 ;
        super.colList = "`Exp Mang ID`,`Date Modified`,`Expense`,`Amount`,`Department`";
        // System.out.println(colList);
        
    }
    
    public void test()
    {
        
    }
    
    public String getPrimaryKey()
    {
        setexpenseNo();
        getexpenseNo();
        return this.expenseNo;
    }
    // -------------------------------------------------------------------------
    // -- BEGIN Getting Values -------------------------------------------------
      
     private void getexpenseNo() 
    { 
        this.expenseNo = Expenses_Management_Frame.txtExpenseNo.getText();
    }
     
      private void getexpense() 
    { 
        this.expense = Expenses_Management_Frame.txtExpense.getText();
    }
      
        private void getdepartment() 
    { 
        this.department = Expenses_Management_Frame.cmbDepartment.getSelectedItem().toString();
    }
      
      private void getamount() 
    { 
        this.amount = Integer.parseInt(Expenses_Management_Frame.txtAmount.getText()) ;
    }
      
     private void getAll()
    {
        getexpenseNo();
        getexpense();
        getdepartment();
        getamount();
    }
    
    // -- END SET Values -------------------------------------------------------
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    // -- BEGIN Setting Values -------------------------------------------------
   
       private void setexpenseNo() 
       { 
         Expenses_Management_Frame.txtExpenseNo.setText(Expenses_Management_Frame.tblExpenses.getValueAt(getSelectedRow(Expenses_Management_Frame.tblExpenses), 0).toString());
       }
       
       private void setexpense() 
       { 
         Expenses_Management_Frame.txtExpense.setText(Expenses_Management_Frame.tblExpenses.getValueAt(getSelectedRow(Expenses_Management_Frame.tblExpenses), 2).toString());
       }
       
        private void setdepartment() 
       { 
         Expenses_Management_Frame.cmbDepartment.setSelectedItem(Expenses_Management_Frame.tblExpenses.getValueAt(getSelectedRow(Expenses_Management_Frame.tblExpenses), 4).toString());
       }
     
       private void setamount() 
       { 
         Expenses_Management_Frame.txtAmount.setText(Expenses_Management_Frame.tblExpenses.getValueAt(getSelectedRow(Expenses_Management_Frame.tblExpenses), 3).toString());
       }
       
        public void setAll()
     {
         setexpenseNo();
         setexpense();
         setdepartment();
         setamount();
                    
     }
        
    // -- END Setting Values ---------------------------------------------------
    // -------------------------------------------------------------------------
        
    @Override
    public void add(String tableName)
    {             
        getAll();
        String primaryval = "EXM";
        String sql = "INSERT INTO "+tableName+""
                + "(`Exp Mang ID`,`Expense`,`Date Modified`,`Amount`,`Department`)"
                + " VALUES("
                + "'"+generatePrimaryKey("Exp Mang ID",tableName,primaryval)+"',"
                + "'"+this.expense+"',"
                + "'"+getCurrentDateTime()+"',"
                + "'"+this.amount+"',"
                + "'"+this.department+"'"
                + ")";
        System.out.println(sql);
        
        try 
        {
            pst = con.prepareStatement(sql);
            pst.execute();
            loadTable(tableName,Expenses_Management_Frame.tblExpenses);   
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
    } 
    
      public void barchart(String Department){
         DefaultCategoryDataset expensedata = new DefaultCategoryDataset();
       String sqlrrday = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,10) FROM expenses_management WHERE Department='"+Department+"' GROUP BY SUBSTRING(`Date Modified`,1,10)";
       String sqlrrmonth = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,7) FROM expenses_management WHERE Department='"+Department+"' GROUP BY SUBSTRING(`Date Modified`,1,7)";
       String sqlrryear = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,4) FROM expenses_management WHERE Department='"+Department+"' GROUP BY SUBSTRING(`Date Modified`,1,4)";
       
       if(Expenses_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Daily")){
            try 
            {
               pst = con.prepareStatement(sqlrrday);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String date = rst.getString("SUBSTRING(`Date Modified`,1,10)");
                  float value = Float.parseFloat(amounts);    
                  expensedata.setValue(value,"Expense Per Day",date);
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           }
           else if(Expenses_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Monthly")){
            try 
            {
               pst = con.prepareStatement(sqlrrmonth);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String month = rst.getString("SUBSTRING(`Date Modified`,1,7)");
                  float value = Float.parseFloat(amounts);    
                  expensedata.setValue(value,"Expense Per Month",month);
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           
           }
           else if(Expenses_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Annualy")){
           try 
            {
               pst = con.prepareStatement(sqlrryear);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String year = rst.getString("SUBSTRING(`Date Modified`,1,4)");
                  float value = Float.parseFloat(amounts);    
                  expensedata.setValue(value,"Expense Per year",year);
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           
           }
          
        JFreeChart expensedatabarchart = ChartFactory.createBarChart("Expense Management","Time period","Expense",expensedata ,PlotOrientation.VERTICAL,false,true,false);
        CategoryPlot expensedatabarchrt = expensedatabarchart.getCategoryPlot();
        expensedatabarchrt.setRangeGridlinePaint(Color.BLUE);
        
        ChartPanel barpanel = new ChartPanel(expensedatabarchart);
        Expenses_Management_Frame.panelchart.removeAll();
        Expenses_Management_Frame.panelchart.add(barpanel,BorderLayout.CENTER);
        Expenses_Management_Frame.panelchart.validate();  
      }
      
     public void piechart(String Department){
        DefaultPieDataset piedataset = new DefaultPieDataset() ;
        String sqlrrday = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,10) FROM expenses_management WHERE Department='"+Department+"' GROUP BY SUBSTRING(`Date Modified`,1,10)";
        String sqlrrmonth = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,7) FROM expenses_management WHERE Department='"+Department+"' GROUP BY SUBSTRING(`Date Modified`,1,7)";
        String sqlrryear = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,4) FROM expenses_management WHERE Department='"+Department+"' GROUP BY SUBSTRING(`Date Modified`,1,4)";        
           
           if(Expenses_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Daily")){
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
           else if(Expenses_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Monthly")){
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
           else if(Expenses_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Annualy")){
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
         
             JFreeChart chart = ChartFactory.createPieChart("Expense Management", piedataset, true, true, true);
             PiePlot P = (PiePlot)chart.getPlot();
             
             ChartPanel barpanel = new ChartPanel(chart);
             Expenses_Management_Frame.panelchart.removeAll();
             Expenses_Management_Frame.panelchart.add(barpanel,BorderLayout.CENTER);
             Expenses_Management_Frame.panelchart.validate();
       
     } 
     
     public void linechart(String Department){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String sqlrrday = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,10) FROM expenses_management WHERE Department='"+Department+"' GROUP BY SUBSTRING(`Date Modified`,1,10)";
        String sqlrrmonth = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,7) FROM expenses_management WHERE Department='"+Department+"' GROUP BY SUBSTRING(`Date Modified`,1,7)";
        String sqlrryear = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,4) FROM expenses_management WHERE Department='"+Department+"' GROUP BY SUBSTRING(`Date Modified`,1,4)";                  
           
           if(Expenses_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Daily")){
            try 
            {
               pst = con.prepareStatement(sqlrrday);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String date = rst.getString("SUBSTRING(`Date Modified`,1,10)");
                  float value = Float.parseFloat(amounts);    
                  dataset.setValue(new Double(value), "Expenses",date );
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           }
           else if(Expenses_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Monthly")){
            try 
            {
               pst = con.prepareStatement(sqlrrmonth);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String month = rst.getString("SUBSTRING(`Date Modified`,1,7)");
                  float value = Float.parseFloat(amounts);    
                  dataset.setValue(new Double(value), "Expenses",month );
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           
           }
           else if(Expenses_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Annualy")){
           try 
            {
               pst = con.prepareStatement(sqlrryear);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String year = rst.getString("SUBSTRING(`Date Modified`,1,4)");
                  float value = Float.parseFloat(amounts);    
                  dataset.setValue(new Double(value), "Expenses",year );
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
                 
             }
                    
             JFreeChart chart = ChartFactory.createLineChart("Expense Management","Day","Expenses",dataset, PlotOrientation.VERTICAL,false,true,true);
             chart.setBackgroundPaint(Color.YELLOW);
             chart.getTitle().setPaint(Color.RED);
             CategoryPlot P = chart.getCategoryPlot();
             P.setRangeGridlinePaint(Color.BLUE);
             
             ChartPanel barpanel = new ChartPanel(chart);
             Expenses_Management_Frame.panelchart.removeAll();
             Expenses_Management_Frame.panelchart.add(barpanel,BorderLayout.CENTER);
             Expenses_Management_Frame.panelchart.validate(); 
     
     }
      
    
    
   
    
    public void charts(){
        
    if(Expenses_Management_Frame.cmbBarchart.getSelectedItem().equals("Bar chart") && Expenses_Management_Frame.cmbDepartment.getSelectedItem().equals("Stock") ){
        barchart("Stock");
       
    }
    else if(Expenses_Management_Frame.cmbBarchart.getSelectedItem().equals("Bar chart") && Expenses_Management_Frame.cmbDepartment.getSelectedItem().equals("Employee Management")){
        barchart("Employee Management");
    }
    
    else if(Expenses_Management_Frame.cmbBarchart.getSelectedItem().equals("Bar chart") && Expenses_Management_Frame.cmbDepartment.getSelectedItem().equals("Laundry and Room Service")){
         barchart("Laundry and Room Service");
    }
    else if(Expenses_Management_Frame.cmbBarchart.getSelectedItem().equals("Bar chart") && Expenses_Management_Frame.cmbDepartment.getSelectedItem().equals("Other")){
          barchart("Other");
    }
    else if(Expenses_Management_Frame.cmbBarchart.getSelectedItem().equals("Bar chart") && Expenses_Management_Frame.cmbDepartment.getSelectedItem().equals("Transport and Tour Management")){
           barchart("Transport and Tour Management");
    }
    else if(Expenses_Management_Frame.cmbBarchart.getSelectedItem().equals("Bar chart") && Expenses_Management_Frame.cmbDepartment.getSelectedItem().equals("All")){
        DefaultCategoryDataset expensedata = new DefaultCategoryDataset();
        String sqlday = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,10)  FROM expenses_management GROUP BY SUBSTRING(`Date Modified`,1,10)" ;
        String sqlmonth = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,7) FROM expenses_management GROUP BY SUBSTRING(`Date Modified`,1,7)" ;
        String sqlyear = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,4) FROM expenses_management GROUP BY SUBSTRING(`Date Modified`,1,4)" ;     
           
           if(Expenses_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Daily")){
            try 
            {
               pst = con.prepareStatement(sqlday);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String date = rst.getString("SUBSTRING(`Date Modified`,1,10)");
                  float value = Float.parseFloat(amounts);    
                  expensedata.setValue(value,"Expense Per Day",date);
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           }
           else if(Expenses_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Monthly")){
            try 
            {
               pst = con.prepareStatement(sqlmonth);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String month = rst.getString("SUBSTRING(`Date Modified`,1,7)");
                  float value = Float.parseFloat(amounts);    
                  expensedata.setValue(value,"Expense Per year",month);
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           
           }
           else if(Expenses_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Annualy")){
           try 
            {
               pst = con.prepareStatement(sqlyear);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String year = rst.getString("SUBSTRING(`Date Modified`,1,4)");
                  float value = Float.parseFloat(amounts);    
                  expensedata.setValue(value,"Expense Per month",year);
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           
           }
          
        JFreeChart expensedatabarchart = ChartFactory.createBarChart("Expense Management","Day","Expense",expensedata ,PlotOrientation.VERTICAL,false,true,false);
        CategoryPlot expensedatabarchrt = expensedatabarchart.getCategoryPlot();
        expensedatabarchrt.setRangeGridlinePaint(Color.BLUE);
        
        ChartPanel barpanel = new ChartPanel(expensedatabarchart);
        Expenses_Management_Frame.panelchart.removeAll();
        Expenses_Management_Frame.panelchart.add(barpanel,BorderLayout.CENTER);
        Expenses_Management_Frame.panelchart.validate(); 
         //barchart("All");
    }
    else if(Expenses_Management_Frame.cmbBarchart.getSelectedItem().equals("Pie chart") && Expenses_Management_Frame.cmbDepartment.getSelectedItem().equals("Stock")){
        piechart("Stock");
    }
    else if(Expenses_Management_Frame.cmbBarchart.getSelectedItem().equals("Pie chart") && Expenses_Management_Frame.cmbDepartment.getSelectedItem().equals("Employee Management")){
        piechart("Employee Management"); 
    }
   
    else if(Expenses_Management_Frame.cmbBarchart.getSelectedItem().equals("Pie chart") && Expenses_Management_Frame.cmbDepartment.getSelectedItem().equals("Laundry and Room Service")){
       piechart("Laundry and Room Service");    
    }
    else if(Expenses_Management_Frame.cmbBarchart.getSelectedItem().equals("Pie chart") && Expenses_Management_Frame.cmbDepartment.getSelectedItem().equals("Transport and Tour Management")){
         piechart("Transport and Tour Management"); 
    }
    else if(Expenses_Management_Frame.cmbBarchart.getSelectedItem().equals("Pie chart") && Expenses_Management_Frame.cmbDepartment.getSelectedItem().equals("Other")){
          piechart("Other");   
    }
    else if(Expenses_Management_Frame.cmbBarchart.getSelectedItem().equals("Pie chart") && Expenses_Management_Frame.cmbDepartment.getSelectedItem().equals("All")){
        DefaultPieDataset piedataset = new DefaultPieDataset() ;
        String sqlday = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,10)  FROM expenses_management GROUP BY SUBSTRING(`Date Modified`,1,10)" ;
        String sqlmonth = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,7) FROM expenses_management GROUP BY SUBSTRING(`Date Modified`,1,7)" ;
        String sqlyear = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,4) FROM expenses_management GROUP BY SUBSTRING(`Date Modified`,1,4)" ;     
           
           if(Expenses_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Daily")){
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
           else if(Expenses_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Monthly")){
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
           else if(Expenses_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Annualy")){
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
         
             JFreeChart chart = ChartFactory.createPieChart("Expense Management", piedataset, true, true, true);
             PiePlot P = (PiePlot)chart.getPlot();
             
             ChartPanel barpanel = new ChartPanel(chart);
             Expenses_Management_Frame.panelchart.removeAll();
             Expenses_Management_Frame.panelchart.add(barpanel,BorderLayout.CENTER);
             Expenses_Management_Frame.panelchart.validate(); 
        
    }
    else if(Expenses_Management_Frame.cmbBarchart.getSelectedItem().equals("Line chart") && Expenses_Management_Frame.cmbDepartment.getSelectedItem().equals("Stock")){
        linechart("Stock");
    }
    else if(Expenses_Management_Frame.cmbBarchart.getSelectedItem().equals("Line chart") && Expenses_Management_Frame.cmbDepartment.getSelectedItem().equals("Employee Management")){
        linechart("Employee Management");
    }
    
    else if(Expenses_Management_Frame.cmbBarchart.getSelectedItem().equals("Line chart") && Expenses_Management_Frame.cmbDepartment.getSelectedItem().equals("Laundry and Room Service")){
         linechart("Laundry and Room Service");
    }
    else if(Expenses_Management_Frame.cmbBarchart.getSelectedItem().equals("Line chart") && Expenses_Management_Frame.cmbDepartment.getSelectedItem().equals("Other")){
       linechart("Other");
    }
     else if(Expenses_Management_Frame.cmbBarchart.getSelectedItem().equals("Line chart") && Expenses_Management_Frame.cmbDepartment.getSelectedItem().equals("Tour and Transport Management")){
        linechart("Tour and Transport Management");  
    }
    
    else if(Expenses_Management_Frame.cmbBarchart.getSelectedItem().equals("Line chart") && Expenses_Management_Frame.cmbDepartment.getSelectedItem().equals("All")){
           DefaultCategoryDataset dataset = new DefaultCategoryDataset();
           String sqlday = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,10)  FROM expenses_management GROUP BY SUBSTRING(`Date Modified`,1,10)" ;
           String sqlmonth = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,7) FROM expenses_management GROUP BY SUBSTRING(`Date Modified`,1,7)" ;
           String sqlyear = "SELECT SUM(Amount), SUBSTRING(`Date Modified`,1,4) FROM expenses_management GROUP BY SUBSTRING(`Date Modified`,1,4)" ;     
           
           if(Expenses_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Daily")){
            try 
            {
               pst = con.prepareStatement(sqlday);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String date = rst.getString("SUBSTRING(`Date Modified`,1,10)");
                  float value = Float.parseFloat(amounts);    
                  dataset.setValue(new Double(value), "Expenses",date );
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           }
           else if(Expenses_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Monthly")){
            try 
            {
               pst = con.prepareStatement(sqlmonth);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String month = rst.getString("SUBSTRING(`Date Modified`,1,7)");
                  float value = Float.parseFloat(amounts);    
                  dataset.setValue(new Double(value), "Expenses",month );
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
           
           }
           else if(Expenses_Management_Frame.cmbTimePeriod.getSelectedItem().equals("Annualy")){
           try 
            {
               pst = con.prepareStatement(sqlyear);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String amounts = rst.getString("SUM(Amount)");
                  String year = rst.getString("SUBSTRING(`Date Modified`,1,4)");
                  float value = Float.parseFloat(amounts);    
                  dataset.setValue(new Double(value), "Expenses",year );
                  System.out.println(amounts);  
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
                 
             }
                    
             JFreeChart chart = ChartFactory.createLineChart("Expense Management","Day","Expenses",dataset, PlotOrientation.VERTICAL,false,true,true);
             chart.setBackgroundPaint(Color.YELLOW);
             chart.getTitle().setPaint(Color.RED);
             CategoryPlot P = chart.getCategoryPlot();
             P.setRangeGridlinePaint(Color.BLUE);
             
             ChartPanel barpanel = new ChartPanel(chart);
             Expenses_Management_Frame.panelchart.removeAll();
             Expenses_Management_Frame.panelchart.add(barpanel,BorderLayout.CENTER);
             Expenses_Management_Frame.panelchart.validate();
       
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
                + " SET `Expense` = "+ "'" + this.expense + "',"
                + "`Date Modified`= '" + getCurrentDateTime() + "',"
                + "`Amount` = " + this.amount + ","
                + "`Department`='" + this.department + "' "
                + "WHERE `Exp Mang ID` = '" + this.expenseNo + "'";
        
        //System.out.println(sql);
        
        try 
        {
                pst = con.prepareStatement(sql);
                pst.execute();
                loadTable(tableName,Expenses_Management_Frame.tblExpenses);   
        } 
        catch (Exception e) 
        {
               
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
     public void Modelsearch()
    {
        String filters = Expenses_Management_Frame.cmbSearchBy.getSelectedItem().toString();
        String filter = "`"+filters+"`";
        String search=Expenses_Management_Frame.txtSearch.getText();
        
        String tablename = "expenses_management";
        JTable tblName = Expenses_Management_Frame.tblExpenses;
        
        search(filter,search,tablename,tblName);
        
    }
     
//    public void zeroexpense(){
//    
//    String checkdate = "SELECT SUBSTRING(incomes_management.`Date Modified`,1,10) FROM incomes_management LEFT JOIN expenses_management ON (SUBSTRING(incomes_management.`Date Modified`,1,10)=SUBSTRING(expenses_management.`Date Modified`,1,10)) WHERE SUBSTRING(expenses_management.`Date Modified`,1,10) IS NULL" ;
//    try 
//            {
//               pst = con.prepareStatement(checkdate);
//               
//               ResultSet rst = pst.executeQuery();
//               while(rst.next()){
//                  String incomeday = rst.getString("SUBSTRING(incomes_management.`Date Modified`,1,10)");
//                  System.out.println(incomeday);  
//                  String zero = "Insert into expenses_management(`Exp Mang ID`,`Expense`,`Date Modified`,`Amount`,`Department`)VALUES('NO ID','NO EXPENSE','"+incomeday+"',0,'NO DEPARTMENT')";
//                  try
//                  {
//                      pst = con.prepareStatement(zero);
//                      pst.execute();
//                  }
//                  catch (Exception e) 
//                  {
//                    JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
//                  }   
//                 // System.out.println(incomeday);  
//               }
//            }
//            catch (SQLException | NumberFormatException e) 
//            {
//            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
//            }
//    
//    
//    }
    
      public void report()
    {
        iReportView r = new iReportView(iReport.PROJECT_PATH+"\\finance_management\\Expenses.jasper");
        
        r.setVisible(true);
    }
    
  
    
   
    
    
    
    
    
    
}
