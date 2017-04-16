/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.finance_management;

import app.finance_management.Expenses_Management_Frame;
import app.finance_management.Incomes_Management_Frame;
import app.finance_management.Profit_And_Loss_Comparison_Frame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import source.DBConnection;

/**
 *
 * @author Chamod Ratnayaka
 */
public class Profit_And_Loss_Comparison_Model extends HMS {
    
    Connection con = null; 
    PreparedStatement pst = null; 
    
    public void calculate(){
        
      float totincome = 0 ;
      float totexpense = 0 ;
      float incomeperrow ;
      float expenseperrow ;
      float profit_loss ;
 
      
  
      
      int NoofincomeRows = Incomes_Management_Frame.tblIncomes.getRowCount();
      int NoofexpenseRows = Expenses_Management_Frame.tblExpenses.getRowCount();
      
      
      for(int a=0; a<=NoofincomeRows-1; a++){
           
             incomeperrow  =   (float) Incomes_Management_Frame.tblIncomes.getValueAt(a, 3);  
             totincome =  totincome + incomeperrow ;
             
     
             
      }
       for(int a=1; a<=NoofexpenseRows-1; a++){
               
             expenseperrow  =   (float) Expenses_Management_Frame.tblExpenses.getValueAt(a, 3);
             totexpense =  totexpense + expenseperrow ;
             
      }
        profit_loss = totincome - totexpense ;
        String totincomes = String.valueOf(totincome);
        String totexpenses = String.valueOf(totexpense);
        String profit_losses = String.valueOf(profit_loss);


        Profit_And_Loss_Comparison_Frame.lblTotalIncome.setText(totincomes);
        Profit_And_Loss_Comparison_Frame.lblTotalExpense.setText(totexpenses);
        
        if(totincome-totexpense<0){
        Profit_And_Loss_Comparison_Frame.lblProfit_Loss.setText(profit_losses+" Loss");
        }
        
        else{
        Profit_And_Loss_Comparison_Frame.lblProfit_Loss.setText(profit_losses+" Profit");
        }

        System.out.println(totincome);
        System.out.println(totexpense);
        System.out.println(profit_loss);
    
    }
    
    
     private CategoryDataset createDataset(){
     
      con = DBConnection.connect();
      DefaultCategoryDataset dataset = new DefaultCategoryDataset();
      String series1 = "Income" ;
      String series2 = "Expense" ;
      String series3 = "Profit" ;
      
      String daily = "SELECT SUM(incomes_management.Amount), SUM(expenses_management.Amount),SUBSTRING(incomes_management.`Date Modified`,1,10) FROM incomes_management,expenses_management WHERE SUBSTRING(incomes_management.`Date Modified`,1,10)=SUBSTRING(expenses_management.`Date Modified`,1,10) GROUP BY SUBSTRING(incomes_management.`Date Modified`,1,10)";
      String monthly = "SELECT SUM(incomes_management.Amount), SUM(expenses_management.Amount),SUBSTRING(incomes_management.`Date Modified`,1,7) FROM incomes_management,expenses_management WHERE SUBSTRING(incomes_management.`Date Modified`,1,7)=SUBSTRING(expenses_management.`Date Modified`,1,7) GROUP BY SUBSTRING(incomes_management.`Date Modified`,1,7)";
      String annually = "SELECT SUM(incomes_management.Amount), SUM(expenses_management.Amount),SUBSTRING(incomes_management.`Date Modified`,1,4) FROM incomes_management,expenses_management WHERE SUBSTRING(incomes_management.`Date Modified`,1,4)=SUBSTRING(expenses_management.`Date Modified`,1,4) GROUP BY SUBSTRING(incomes_management.`Date Modified`,1,4)";
     
      if(Profit_And_Loss_Comparison_Frame.cmbTimePeriod.getSelectedItem().equals("Daily")){
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
                
                  dataset.addValue(incomevalue,series1 ,day );
                  dataset.addValue(expensevalue,series2, day);
                  dataset.addValue(profit, series3, day);
                 
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
            
              
            }
        else if(Profit_And_Loss_Comparison_Frame.cmbTimePeriod.getSelectedItem().equals("Monthly")){
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
                
                  dataset.addValue(incomevalue,series1 ,month );
                  dataset.addValue(expensevalue,series2, month);
                  dataset.addValue(profit, series3, month);
                 
               }
            }
            catch (SQLException | NumberFormatException e) 
            {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        
        }
      
         else if(Profit_And_Loss_Comparison_Frame.cmbTimePeriod.getSelectedItem().equals("Annually")){
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
                
                  dataset.addValue(incomevalue,series1 ,year );
                  dataset.addValue(expensevalue,series2, year);
                  dataset.addValue(profit, series3, year);
                 
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
                
            String chartTitle = "Profit Loss Comparison";
            String categoryAxisLabel = "Day";
            String valueAxisLabel = "Amount";
            CategoryDataset dataset = createDataset();
          
            
            JFreeChart chart = ChartFactory.createLineChart(chartTitle,categoryAxisLabel, valueAxisLabel, dataset);
             return new ChartPanel(chart);
          }
    
    
     public void charts(){
         JPanel chartPanel = createChartPanel();
         Profit_And_Loss_Comparison_Frame.panelchart.removeAll();
         Profit_And_Loss_Comparison_Frame.panelchart.add(chartPanel,BorderLayout.CENTER);
         Profit_And_Loss_Comparison_Frame.panelchart.validate();
         
    
   
         
           
     
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
    

