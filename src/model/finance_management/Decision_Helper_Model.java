/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.finance_management;

import app.finance_management.Decision_Helper_Frame;
import app.finance_management.Incomes_Management_Frame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.HMS;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import source.DBConnection;

/**
 *
 * @author Chamod Ratnayaka
 */
public class Decision_Helper_Model  {
    
    Connection con = null; 
    PreparedStatement pst = null; 
    
    
    
    private String GoalId ;
    private int dailyprofitgoal ;
    private int monthlyprofitgoal ;
    private int annualprofitgoal ;
    private String TimePeriod ;
    
    public Decision_Helper_Model() {
    
         con = DBConnection.connect();

         this.GoalId = "NULL" ;
         this.dailyprofitgoal = 0 ;
         this.monthlyprofitgoal = 0 ;
         this.annualprofitgoal = 0 ;
       
         this.TimePeriod = "NO TimePeriod" ;
         
       
    }
    
     public String getPrimaryKey()
    {
       // setincomeNo();
        getGoalId();
        return this.GoalId;
    }
     
     
    private void getGoalId() 
    { 
        this.GoalId = Decision_Helper_Frame.txtGoadId.getText();
    }
    
    private void getDailyProfitGoal(){
        this.dailyprofitgoal = Integer.parseInt(Decision_Helper_Frame.txtDailyProfitGoal.getText());
    }
    
    private void getMonthlyProfitGoal(){
    
     this.monthlyprofitgoal = Integer.parseInt(Decision_Helper_Frame.txtMonthlyProfitGoal.getText()) ;
     
    }
    
    private void getAnnualProfitGoal(){
    
     this.annualprofitgoal = Integer.parseInt(Decision_Helper_Frame.txtAnnualProfitGoal.getText()) ;
    
    }
    
   
    
    private void getTimePeriod(){
        this.TimePeriod = Decision_Helper_Frame.cmbTimePeriod.getSelectedItem().toString();
    }
    
    private void getAll(){
      getGoalId();
      getDailyProfitGoal();
      getMonthlyProfitGoal();
      getAnnualProfitGoal();
      getTimePeriod();
    }
    
    
    
   
    public void add(){
    
    getAll();
    String sql = "INSERT INTO decision_helper"
                + "(`Daily Profit Goal`,`Monthly Profit Goal`,`Annual Profit Goal`)"
                + " VALUES("
               + "'"+this.dailyprofitgoal+"',"
                + "'"+this.monthlyprofitgoal+"',"
                + "'"+this.annualprofitgoal+"'"       
                + ")";
        System.out.println(sql);
       
        
        try 
        {
            pst = con.prepareStatement(sql);
            pst.execute();
         
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    
    
    }
    
    
     public void update()
    {   
        
         getAll();
        String sql = "UPDATE decision_helper"
                + " SET `Daily Profit Goal` = "+ "'" + this.dailyprofitgoal + "',"
                + " SET `Monthly Profit Goal` = "+ "'" + this.monthlyprofitgoal + "',"   
                + "`Annual Profit Goal` = " + this.annualprofitgoal + " "
                + "WHERE `Decision Helper ID` = '" + this.GoalId + "'";
        
        System.out.println(sql);
        
        try 
        {
                pst = con.prepareStatement(sql);
                pst.execute();
               
        } 
        catch (Exception e) 
        {
               
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
     
     
   
    public void getGoal(){
       
             String sql ="SELECT `Monthly Profit Goal` FROM decision_helper ";
             String sql1 ="SELECT `Annual Profit Goal` FROM decision_helper ";
             String sql2 ="SELECT `Daily Profit Goal` FROM decision_helper  ";
             
             try 
            {
               pst = con.prepareStatement(sql);
               ResultSet rs = pst.executeQuery();
               if(rs.next()){
                  String RoomReservationMGoal = rs.getString("Monthly Profit Goal");
                  Decision_Helper_Frame.txtMonthlyProfitGoal.setText(RoomReservationMGoal);    
               }
            }
            catch (Exception e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
             
              try 
            {
               pst = con.prepareStatement(sql1);
               ResultSet rs = pst.executeQuery();
               if(rs.next()){
                  String RoomReservationAGoal = rs.getString("Annual Profit Goal");
                  Decision_Helper_Frame.txtAnnualProfitGoal.setText(RoomReservationAGoal);    
               }
            }
            catch (Exception e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
              
                 try 
            {
               pst = con.prepareStatement(sql2);
               ResultSet rs = pst.executeQuery();
               if(rs.next()){
                  String RoomReservationDGoal = rs.getString("Daily Profit Goal");
                  Decision_Helper_Frame.txtDailyProfitGoal.setText(RoomReservationDGoal);    
               }
            }
            catch (Exception e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
    }
      
          private CategoryDataset createDataset(){
    
            
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            String series1 = "Profit" ;
            String series2 = "Goal" ;
            
            String daily = "SELECT SUM(incomes_management.Amount), SUM(expenses_management.Amount),SUBSTRING(incomes_management.`Date Modified`,1,10) FROM incomes_management,expenses_management WHERE SUBSTRING(incomes_management.`Date Modified`,1,10)=SUBSTRING(expenses_management.`Date Modified`,1,10) GROUP BY SUBSTRING(incomes_management.`Date Modified`,1,10)";
            String monthly = "SELECT SUM(incomes_management.Amount), SUM(expenses_management.Amount),SUBSTRING(incomes_management.`Date Modified`,1,7) FROM incomes_management,expenses_management WHERE SUBSTRING(incomes_management.`Date Modified`,1,7)=SUBSTRING(expenses_management.`Date Modified`,1,7) GROUP BY SUBSTRING(incomes_management.`Date Modified`,1,7)";
            String annually = "SELECT SUM(incomes_management.Amount), SUM(expenses_management.Amount),SUBSTRING(incomes_management.`Date Modified`,1,4) FROM incomes_management,expenses_management WHERE SUBSTRING(incomes_management.`Date Modified`,1,4)=SUBSTRING(expenses_management.`Date Modified`,1,4) GROUP BY SUBSTRING(incomes_management.`Date Modified`,1,4)";
            int DayGoal = Integer.parseInt(Decision_Helper_Frame.txtDailyProfitGoal.getText()) ;
            int MonthGoal = Integer.parseInt(Decision_Helper_Frame.txtMonthlyProfitGoal.getText()) ;
            int AnnualGoal = Integer.parseInt(Decision_Helper_Frame.txtAnnualProfitGoal.getText()) ;
            
            if(Decision_Helper_Frame.cmbTimePeriod.getSelectedItem().equals("Daily")){
               try 
               {
               pst = con.prepareStatement(daily);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String incomeamounts = rst.getString("SUM(incomes_management.Amount)");
                  String expenseamounts = rst.getString("SUM(expenses_management.Amount)");
                  String day = rst.getString("SUBSTRING(incomes_management.`Date Modified`,1,10)");
                  float incomevalue = Float.parseFloat(incomeamounts);   
                  float expensevalue = Float.parseFloat(expenseamounts);
                  float profit = incomevalue - expensevalue ;
                
                  dataset.addValue(profit,series1 ,day );
                  dataset.addValue(DayGoal,series2, day);
                  
                 
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
            
              
            }
            
          
           else if(Decision_Helper_Frame.cmbTimePeriod.getSelectedItem().equals("Monthly")){
           try 
               {
               pst = con.prepareStatement(monthly);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String incomeamounts = rst.getString("SUM(incomes_management.Amount)");
                  String expenseamounts = rst.getString("SUM(expenses_management.Amount)");
                  String month = rst.getString("SUBSTRING(incomes_management.`Date Modified`,1,7)");
                  float incomevalue = Float.parseFloat(incomeamounts);   
                  float expensevalue = Float.parseFloat(expenseamounts);
                  float profit = incomevalue - expensevalue ;
                
                  dataset.addValue(profit,series1 ,month );
                  dataset.addValue(MonthGoal,series2, month);
                  
                 
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
            
              
            }
            
          
          
          else if(Decision_Helper_Frame.cmbTimePeriod.getSelectedItem().equals("Annually")){
           try 
               {
               pst = con.prepareStatement(annually);
               
               ResultSet rst = pst.executeQuery();
               while(rst.next()){
                  String incomeamounts = rst.getString("SUM(incomes_management.Amount)");
                  String expenseamounts = rst.getString("SUM(expenses_management.Amount)");
                  String year = rst.getString("SUBSTRING(incomes_management.`Date Modified`,1,4)");
                  float incomevalue = Float.parseFloat(incomeamounts);   
                  float expensevalue = Float.parseFloat(expenseamounts);
                  float profit = incomevalue - expensevalue ;
                
                  dataset.addValue(profit,series1 ,year );
                  dataset.addValue(AnnualGoal,series2, year);
                  
                 
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
            
               
           
            
          } 
             return dataset ;
          }
                     
          private JPanel createChartPanel() {
                
            String chartTitle = "Decision Helper";
            String categoryAxisLabel = "Day";
            String valueAxisLabel = "Profit";
            CategoryDataset dataset = createDataset();
          
            
            JFreeChart chart = ChartFactory.createLineChart(chartTitle,categoryAxisLabel, valueAxisLabel, dataset);
             return new ChartPanel(chart);
          }
          
          
         public void chart(){
         JPanel chartPanel = createChartPanel();
         Decision_Helper_Frame.panelchart.removeAll();
         Decision_Helper_Frame.panelchart.add(chartPanel,BorderLayout.CENTER);
         Decision_Helper_Frame.panelchart.validate();
         
         }
            
        
      
}
             
            
            
            
    
            
            
            
            
            
         
              
              
           
    
    
       
       
              
          
        
        
        
    
       
    
    
   
    
    
    
    
            
         
              
            
                
                
                
           
           
    
 
    
    

    
    
    
    
    
    
