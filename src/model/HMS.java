/*
 * Hotel Management System for Pavana Hotel Kochchikade
 * Information Technology Project - 2016
 * Project ID   : ITP_WD_16_B1_06
 * Supervisor   : Mrs. Asanthika Imbulpitiya
 *
 * Student Name : Perera P.D.S   
 * IT Number    : IT14031380
*/

package model;

import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;
import source.mulitline;

/**
 *
 * @author Dhanuka Perera
 */
public abstract class HMS implements Pavana
{
   protected Connection con = null; 
   protected PreparedStatement pst = null;  
   protected ResultSet rs = null;
   
   protected int getSelectedRow = 0; 
   String currentDateTime = "";
   
   protected  String colList = "*";
  
   @Override
   public void loadTable(String tableName,JTable tblName)
   {      
      String sql = "SELECT "+colList+" "
              + "FROM "+tableName+"";
     
        try 
        {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery(); 
            tblName.setModel(DbUtils.resultSetToTableModel(rs));   
       
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
   }
   
   @Override
   public String getCurrentDateTime()
   {
       DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       java.util.Date dateobj = new java.util.Date();
       return currentDateTime= df.format(dateobj);
   }
   
   @Override
   public void delete(String tableName,String coloumName,String primaryKey, JTable tblName)
   {
        String sql = "DELETE FROM "+tableName+" "
                + "WHERE `"+coloumName+"` ='"+primaryKey+"'";
        //System.out.println(sql);
        try 
        {   
            pst = con.prepareStatement(sql);
            pst.execute();
            loadTable(tableName,tblName);
            JOptionPane.showMessageDialog(null,"Record DELETED Sucessfully");    
        } 
        catch (SQLException | HeadlessException e) 
        {
             JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
   }
            
    protected int getSelectedRow(JTable myTable) { return getSelectedRow = myTable.getSelectedRow(); }
  
    public String getDateFromPicker(JDateChooser jDateChooerName)
    {   
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(jDateChooerName.getDate());
        return  date;
    }
   
    protected Date StringToDate(String dateString)
    {
       Date newFormatedDate = null; 
       DateFormat formatter; 
       try 
       {
            formatter = new SimpleDateFormat("MMM d, yyyy");
            newFormatedDate = (Date)formatter.parse(dateString);  
       } 
       catch (Exception e) 
       {
           System.err.println(e);
       }
       return newFormatedDate;
    }
     public void search(String filter,String Search,String tablename,JTable tblname)
    {
        String sql=null;
        
        try 
        {
         
         sql ="SELECT * from "+tablename+" where "+filter+" LIKE '%"+Search+"%'";
     
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            tblname.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
     //******************************************************************************************************************
     // --- >>> NEW UPDATES *********************************************************************************************
     // -----------------------------------------------------------------------------------------------------------------
     
    // ** NEW!
     
    public void newDelete(String tableName,String coloumName,String primaryKey, JTable tblName)
   {
        String sql = "DELETE FROM "+tableName+" "
                + "WHERE `"+coloumName+"` ='"+primaryKey+"'";
        //System.out.println(sql);
        try 
        {   
            pst = con.prepareStatement(sql);
            pst.execute();
           // loadTable(tableName,tblName);
            JOptionPane.showMessageDialog(null,"Record DELETED Sucessfully");    
        } 
        catch (SQLException | HeadlessException e) 
        {
            JOptionPane.showMessageDialog(null,"Can't Delete this Record !","Error",JOptionPane.ERROR_MESSAGE);
             //JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
   }
    public void loadListFromDB(String colName,String tableName, JComboBox cmbName)
    {
        cmbName.removeAllItems();
        String value;
        String sql = "SELECT " + "`" 
                + colName 
                + "`" + "FROM " 
                +tableName;
        try 
        {
            pst = con.prepareStatement(sql);
            rs =pst.executeQuery();
            
            while(rs.next())
            {
                value = rs.getString(colName);
                cmbName.addItem(value);
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }              
    }
    
    public String getValueFromDB(String colName,String tableName, String primaryKeyCol,String primaryKey)
    {
        String value = "";
        String sql = "SELECT " + "`" 
                + colName 
                + "`" + " FROM " 
                +tableName + " WHERE `" +primaryKeyCol+"` = '"+ primaryKey +"' ";
        try 
        {
            pst = con.prepareStatement(sql);
            rs =pst.executeQuery();
            
            if(rs.next())
            {
                value = rs.getString(colName);
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }  
        return value;
    }
    
    // For table don't have a search box 
    public void tableLoad(JTable tableName,String dbTableName,String columnList,JLabel updatedTime,JLabel lblRowCount)
    {
        String sql = "SELECT * FROM " + dbTableName ;
              
        refreshTable(sql,tableName,dbTableName,columnList,updatedTime,lblRowCount);
    }
    
    // For tables with search BOX
    public void tableLoad(JTable tableName,String dbTableName,String columnList,JLabel updatedTime,JLabel lblRowCount,JComboBox cmbSearchBy)
    {
        String sql = "SELECT * FROM " + dbTableName ;
              
        refreshTable(sql,tableName,dbTableName,columnList,updatedTime,lblRowCount);
        
        StringTokenizer st = new StringTokenizer(columnList,",");
        int numOfCols = st.countTokens();
        String[] arrList = new String[numOfCols];
                 
        int i = 0;
        while (st.hasMoreTokens()) 
        {
            arrList[i] = st.nextToken();
            i++;
        }  
        
       for (String arrList1 : arrList) {
           cmbSearchBy.addItem(arrList1);
       }
    }
    
    public void orderBy(JTable tableName,String dbTableName,String columnList,JLabel updatedTime,JLabel lblRowCount,JComboBox cmbSearchBy,JComboBox cmbOrderBy)
    {
        String field = "`"+cmbSearchBy.getSelectedItem().toString()+"`";
        int index = cmbOrderBy.getSelectedIndex() ;
        
        if(index == 0)
        {
              String sql = "SELECT * FROM " + dbTableName + " ORDER BY "+field+" ASC";
               refreshTable(sql,tableName,dbTableName,columnList,updatedTime,lblRowCount);
        }
        else
        {
             String sql = "SELECT * FROM " + dbTableName + " ORDER BY "+field+" DESC";
              refreshTable(sql,tableName,dbTableName,columnList,updatedTime,lblRowCount);
        }
    }
    
    public void search(JTable tableName,String dbTableName,String columnList,JLabel updatedTime,JLabel lblRowCount,JComboBox cmbSearchBy, String searchItem)
    {
        String searchby = "`" + cmbSearchBy.getSelectedItem().toString() + "`";
        
        String sql = "SELECT * FROM " + dbTableName +" where " + searchby+ " LIKE '%" + searchItem +"%'";
        
        refreshTable(sql,tableName,dbTableName,columnList,updatedTime,lblRowCount);
    }
    
    public void refreshTable(String sql,JTable tableName,String dbTableName,String columnList,JLabel updatedTime,JLabel lblRowCount)
    {
        StringTokenizer st = new StringTokenizer(columnList,",");
        int numOfCols = st.countTokens();
        String[] arrList = new String[numOfCols];
                 
        int i = 0;
        while (st.hasMoreTokens()) 
        {
            arrList[i] = st.nextToken();
            i++;
        }  
        
        DefaultTableModel model = (DefaultTableModel) tableName.getModel();
        
        model.setRowCount(0);
        model.setColumnCount(numOfCols);
                    
        String col00 = null;
        String col01 = ""; 
        String col02 = null;
        String col03 = null;
        String col04 = null;
        String col05 = null;
        String col06 = null;
        String col07 = null;   
        String col08 = null;   
        String col09 = null;   
        String col10 = null;   
        String col11 = null;   
        String col12 = null;   
        String col13 = null;   
        String col14 = null;   
        String col15 = null;   
        String col16 = null;   
        String col17 = null;   
        
        if(numOfCols <=9)
        { // 1,2,3,4,5,6,7,8,9
            if(numOfCols <= 4)
            { //1,2,3,4
                if(numOfCols <= 2)
                { //1,2
                    if(numOfCols == 1)
                    { 
                      // --> 1 
                         model.setColumnIdentifiers(new Object[]{arrList[0]});
                    }
                    else
                    { 
                      // --> 2  
                        model.setColumnIdentifiers(new Object[]{arrList[0],arrList[1]});
                    }
                }
                else
                { // 3,4
                    if(numOfCols == 3)
                    { 
                        // --> 3
                        model.setColumnIdentifiers(new Object[]{arrList[0],arrList[1],arrList[2]});
                    }
                    else
                    {
                        // --> 4
                        model.setColumnIdentifiers(new Object[]{arrList[0],arrList[1],arrList[2],arrList[3]});
                    }
                }
            }
            else
            { // 5,6,7,8,9
                if(numOfCols <=7)
                { // 5,6,7
                    if(numOfCols <=6)
                    { // 5,6
                        if(numOfCols == 5)
                        {
                            // --> 5
                            model.setColumnIdentifiers(new Object[]{arrList[0],arrList[1],arrList[2],arrList[3],arrList[4]});
                        }
                        else
                        {
                            // --> 6
                            model.setColumnIdentifiers(new Object[]{arrList[0],arrList[1],arrList[2],arrList[3],arrList[4],arrList[5]});
                        }
                    }
                    else
                    {
                        // -- > 7
                        model.setColumnIdentifiers(new Object[]{arrList[0],arrList[1],arrList[2],arrList[3],arrList[4],arrList[5],arrList[6]});
                    }
                }
                else
                { // 8,9
                    if(numOfCols == 8)
                    {
                        // --> 8
                        model.setColumnIdentifiers(new Object[]{arrList[0],arrList[1],arrList[2],arrList[3],arrList[4],arrList[5],arrList[6],arrList[7]});
                    }
                    else
                    {
                        // --> 9
                        model.setColumnIdentifiers(new Object[]{arrList[0],arrList[1],arrList[2],arrList[3],arrList[4],arrList[5],arrList[6],arrList[7],arrList[8]});
                    }
                }
            }
        }
        else
        { // 10.11.12.13,14,15,16,17,18
            if(numOfCols <=13)
            { // 10.11.12.13
                if(numOfCols <=12)
                { //10,11,12
                    if(numOfCols <=11)
                    { // 10.11
                        if(numOfCols == 10)
                        {
                            // --> 10
                            model.setColumnIdentifiers(new Object[]{arrList[0],arrList[1],arrList[2],arrList[3],arrList[4],arrList[5],arrList[6],arrList[7],arrList[8],arrList[9]});
                        }
                        else
                        {
                            // --> 11
                            model.setColumnIdentifiers(new Object[]{arrList[0],arrList[1],arrList[2],arrList[3],arrList[4],arrList[5],arrList[6],arrList[7],arrList[8],arrList[9],arrList[10]});
                        }    
                    }
                    else
                    {
                        // --> 12
                        model.setColumnIdentifiers(new Object[]{arrList[0],arrList[1],arrList[2],arrList[3],arrList[4],arrList[5],arrList[6],arrList[7],arrList[8],arrList[9],arrList[10],arrList[11]});
                    }
                }
                else
                {
                    // --> 13
                    model.setColumnIdentifiers(new Object[]{arrList[0],arrList[1],arrList[2],arrList[3],arrList[4],arrList[5],arrList[6],arrList[7],arrList[8],arrList[9],arrList[10],arrList[11],arrList[12]});
                }
            }
            else
            { // 14.15.16,17,18
                if(numOfCols <=16)
                { //14,15,16
                    if(numOfCols <= 15)
                    { //14,15
                        if(numOfCols == 14)
                        {
                            // --> 14
                            model.setColumnIdentifiers(new Object[]{arrList[0],arrList[1],arrList[2],arrList[3],arrList[4],arrList[5],arrList[6],arrList[7],arrList[8],arrList[9],arrList[10],arrList[11],arrList[12],arrList[13]});
                        }
                        else
                        {
                            // --> 15
                            model.setColumnIdentifiers(new Object[]{arrList[0],arrList[1],arrList[2],arrList[3],arrList[4],arrList[5],arrList[6],arrList[7],arrList[8],arrList[9],arrList[10],arrList[11],arrList[12],arrList[13],arrList[14]});
                        }
                    }
                    else
                    {
                        // --> 16
                        model.setColumnIdentifiers(new Object[]{arrList[0],arrList[1],arrList[2],arrList[3],arrList[4],arrList[5],arrList[6],arrList[7],arrList[8],arrList[9],arrList[10],arrList[11],arrList[12],arrList[13],arrList[14],arrList[15]});
                    }
                }
                else
                { //17,18
                    if(numOfCols == 17)
                    {
                        // --> 17
                        model.setColumnIdentifiers(new Object[]{arrList[0],arrList[1],arrList[2],arrList[3],arrList[4],arrList[5],arrList[6],arrList[7],arrList[8],arrList[9],arrList[10],arrList[11],arrList[12],arrList[13],arrList[14],arrList[15],arrList[16]});
                    }
                    else
                    {
                        // --> 18
                        model.setColumnIdentifiers(new Object[]{arrList[0],arrList[1],arrList[2],arrList[3],arrList[4],arrList[5],arrList[6],arrList[7],arrList[8],arrList[9],arrList[10],arrList[11],arrList[12],arrList[13],arrList[14],arrList[15],arrList[16],arrList[17]});
                    }
                }
            }
        } 
        
        try 
        {
            pst = con.prepareStatement(sql);
            rs =pst.executeQuery();
           
            while(rs.next())
            {
                if(numOfCols>=1)
                {
                    col00 =  rs.getString(arrList[0]);
                    if(numOfCols >=2)
                    {
                         col01 =  rs.getString(arrList[1]);
                        if(numOfCols >=3)
                        {
                            col02 =  rs.getString(arrList[2]);
                            if(numOfCols >=4)
                            {
                                col03 =  rs.getString(arrList[3]);
                                if(numOfCols >=5)
                                {
                                    col04 =  rs.getString(arrList[4]);
                                    if(numOfCols >=6)
                                    {
                                         col05 =  rs.getString(arrList[5]);
                                        if(numOfCols >=7)
                                        {
                                            col06 =  rs.getString(arrList[6]);
                                            if(numOfCols >= 8)
                                            {
                                                col07 =  rs.getString(arrList[7]);
                                                if(numOfCols >=9)
                                                {
                                                    col08 =  rs.getString(arrList[8]);
                                                    if(numOfCols >= 10)
                                                    {
                                                        col09 =  rs.getString(arrList[9]);
                                                        if(numOfCols >= 11)
                                                        {
                                                            col10 =  rs.getString(arrList[10]);
                                                            if(numOfCols >=12)
                                                            {
                                                                col11 =  rs.getString(arrList[11]);
                                                                if(numOfCols >=13)
                                                                {
                                                                    col12 =  rs.getString(arrList[12]);
                                                                    if(numOfCols >=14)
                                                                    {
                                                                        col13 =  rs.getString(arrList[13]);
                                                                        if(numOfCols >=15)
                                                                        {
                                                                            col14 =  rs.getString(arrList[14]);
                                                                            if(numOfCols >= 16)
                                                                            {
                                                                                col15 =  rs.getString(arrList[15]);
                                                                                if(numOfCols >= 17)
                                                                                {
                                                                                    col16 =  rs.getString(arrList[16]);
                                                                                    if(numOfCols >= 18)
                                                                                    {
                                                                                        col17 =  rs.getString(arrList[17]);
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }   
       
        if(numOfCols <=9)
        { // 1,2,3,4,5,6,7,8,9
            if(numOfCols <= 4)
            { //1,2,3,4
                if(numOfCols <= 2)
                { //1,2
                    if(numOfCols == 1)
                    { 
                      // --> 1
                         model.addRow(new Object[]{col00});
                    }
                    else
                    { 
                      // --> 2  
                         model.addRow(new Object[]{col00,col01.substring(0, 19)});
                    }
                }
                else
                { // 3,4
                    if(numOfCols == 3)
                    { 
                        // --> 3
                         model.addRow(new Object[]{col00,col01.substring(0, 19),col02});
                    }
                    else
                    {
                        // --> 4
                         model.addRow(new Object[]{col00,col01.substring(0, 19),col02,col03});
                    }
                }
            }
            else
            { // 5,6,7,8,9
                if(numOfCols <=7)
                { // 5,6,7
                    if(numOfCols <=6)
                    { // 5,6
                        if(numOfCols == 5)
                        {
                            // --> 5
                             model.addRow(new Object[]{col00,col01.substring(0, 19),col02,col03,col04});
                        }
                        else
                        {
                            // --> 6
                             model.addRow(new Object[]{col00,col01.substring(0, 19),col02,col03,col04,col05});
                        }
                    }
                    else
                    {
                        // -- > 7
                         model.addRow(new Object[]{col00,col01.substring(0, 19),col02,col03,col04,col05,col06});
                    }
                }
                else
                { // 8,9
                    if(numOfCols == 8)
                    {
                        // --> 8
                         model.addRow(new Object[]{col00,col01.substring(0, 19),col02,col03,col04,col05,col06,col07});
                    }
                    else
                    {
                        // --> 9
                        model.addRow(new Object[]{col00,col01.substring(0, 19),col02,col03,col04,col05,col06,col07,col08});
                    }
                }
            }
        }
        else
        { // 10.11.12.13,14,15,16,17,18
            if(numOfCols <=13)
            { // 10.11.12.13
                if(numOfCols <=12)
                { //10,11,12
                    if(numOfCols <=11)
                    { // 10.11
                        if(numOfCols == 10)
                        {
                            // --> 10
                            model.addRow(new Object[]{col00,col01.substring(0, 19),col02,col03,col04,col05,col06,col07,col08,col09});
                        }
                        else
                        {
                            // --> 11
                            model.addRow(new Object[]{col00,col01.substring(0, 19),col02,col03,col04,col05,col06,col07,col08,col09,col10});
                        }
                            
                    }
                    else
                    {
                        // --> 12
                        model.addRow(new Object[]{col00,col01.substring(0, 19),col02,col03,col04,col05,col06,col07,col08,col09,col10,col11});
                    }
                }
                else
                {
                    // --> 13
                    model.addRow(new Object[]{col00,col01.substring(0, 19),col02,col03,col04,col05,col06,col07,col08,col09,col10,col11,col12});
                }
            }
            else
            { // 14.15.16,17,18
                if(numOfCols <=16)
                { //14,15,16
                    if(numOfCols <= 15)
                    { //14,15
                        if(numOfCols == 14)
                        {
                            // --> 14
                            model.addRow(new Object[]{col00,col01.substring(0, 19),col02,col03,col04,col05,col06,col07,col08,col09,col10,col11,col12,col13});
                        }
                        else
                        {
                            // --> 15
                            model.addRow(new Object[]{col00,col01.substring(0, 19),col02,col03,col04,col05,col06,col07,col08,col09,col10,col11,col12,col13,col14});
                        }
                    }
                    else
                    {
                        // --> 16
                        model.addRow(new Object[]{col00,col01.substring(0, 19),col02,col03,col04,col05,col06,col07,col08,col09,col10,col11,col12,col13,col14,col15});
                    }
                }
                else
                { //17,18
                    if(numOfCols == 17)
                    {
                        // --> 17
                        model.addRow(new Object[]{col00,col01.substring(0, 19),col02,col03,col04,col05,col06,col07,col08,col09,col10,col11,col12,col13,col14,col15,col16});
                    }
                    else
                    {
                        // --> 18
                        model.addRow(new Object[]{col00,col01.substring(0, 19),col02,col03,col04,col05,col06,col07,col08,col09,col10,col11,col12,col13,col14,col15,col16,col17});
                    }
                }
            }
        }                         
        }
            
        tableName.setDefaultRenderer(Object.class, new mulitline());
        
        JTableHeader header = tableName.getTableHeader();
        header.setOpaque(true);
        header.setFont( new Font("Segoe UI",Font.PLAIN,15));
        header.disable();
        
        updatedTime.setText("Last Updated " + getCurrentDateTime());
        lblRowCount.setText(tableName.getRowCount() + " Records");
        
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateRowCount(JTable tableName, JLabel lblRowCount)
    {
        lblRowCount.setText(tableName.getRowCount() + " Records");
    }
    
    public void newAdd(String tableName,String cols, String vals,String msg)
    {
       
        
         StringTokenizer stCols = new StringTokenizer(cols,",");
        int numOfCols = stCols.countTokens();
        String[] arrColList = new String[numOfCols];
        
        StringTokenizer stVals = new StringTokenizer(vals,",");
        int numOfVals = stVals.countTokens();
        String[] arrValList = new String[numOfVals];
         
        int c = 0;
        while (stCols.hasMoreTokens()) 
        {
            arrColList[c] = stCols.nextToken();
            c++;
        }  
        
        String totCol = "";
        String curCol;
        for (String arrColList1 : arrColList) {
           curCol = "`" + arrColList1 + "`";
           totCol = totCol + "," + curCol;
       }
        
       totCol = totCol.substring(1,totCol.length());
               
       //System.out.println(totCol);
       
        int i = 0;
        while (stVals.hasMoreTokens()) 
        {
            arrValList[i] = stVals.nextToken();
            i++;
        }  
        
        String curVal="";
        String totVal="";
        
        for (String arrList1 : arrValList) 
        {
          // System.err.println(arrList1.charAt(0));
           if (arrList1.charAt(0) == 'i') 
           {
               curVal = arrList1.substring(1, arrList1.length());
           } 
           else 
           {
               curVal = "\'" + arrList1 + "\'";
           }
              totVal= totVal + "," + curVal;                             // // addtional , is coming, remove that at the end using substring 0 to legth-1
       }
        totVal = totVal.substring(1, totVal.length());
        //System.out.println(x);
        
       // String cols ="(`Room Type`,`Date Modified`,`Bed Type`,`Current Stautus`,`Max Guests`,`Rate for Day`,`Rate for Night`,`Description`)";
        
        String sql = "INSERT INTO "+tableName+ " (" 
                + totCol + ") VALUES("
                + totVal
                + " )";
        //System.err.println(sql);
        
        try 
        {
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,msg);
        } 
        catch (SQLException | HeadlessException e) 
        {
             //JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
             JOptionPane.showMessageDialog(null,"Can't Add this Record !","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void newAdd(String tableName,String cols, String vals)
    {   
        StringTokenizer stCols = new StringTokenizer(cols,",");
        int numOfCols = stCols.countTokens();
        String[] arrColList = new String[numOfCols];
        
        StringTokenizer stVals = new StringTokenizer(vals,",");
        int numOfVals = stVals.countTokens();
        String[] arrValList = new String[numOfVals];
         
        int c = 0;
        while (stCols.hasMoreTokens()) 
        {
            arrColList[c] = stCols.nextToken();
            c++;
        }  
        
        String totCol = "";
        String curCol;
        for (String arrColList1 : arrColList) {
           curCol = "`" + arrColList1 + "`";
           totCol = totCol + "," + curCol;
       }
        
       totCol = totCol.substring(1,totCol.length());
               
       //System.out.println(totCol);
       
        int i = 0;
        while (stVals.hasMoreTokens()) 
        {
            arrValList[i] = stVals.nextToken();
            i++;
        }  
        
        String curVal="";
        String totVal="";
        
        for (String arrList1 : arrValList) 
        {
          // System.err.println(arrList1.charAt(0));
           if (arrList1.charAt(0) == 'i') 
           {
               curVal = arrList1.substring(1, arrList1.length());
           } 
           else 
           {
               curVal = "\'" + arrList1 + "\'";
           }
              totVal= totVal + "," + curVal;                             // // addtional , is coming, remove that at the end using substring 0 to legth-1
       }
        totVal = totVal.substring(1, totVal.length());
        //System.out.println(x);
        
       // String cols ="(`Room Type`,`Date Modified`,`Bed Type`,`Current Stautus`,`Max Guests`,`Rate for Day`,`Rate for Night`,`Description`)";
        
        String sql = "INSERT INTO "+tableName+ " (" 
                + totCol + ") VALUES("
                + totVal
                + " )";
        //System.err.println(sql);
        
        try 
        {
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Record Added Sucessfully");
        } 
        catch (SQLException | HeadlessException e) 
        {
             //JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
             JOptionPane.showMessageDialog(null,"Can't Add this Record !","Error",JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public void newUpdate(String tableName,String tbCols,String tbVals,String txtPriKeyCol,String txtPriKeyVal)
    {  
        StringTokenizer st = new StringTokenizer(tbCols,",");
        int numOfCols = st.countTokens();
        String[] arrList = new String[numOfCols];
        
        StringTokenizer stC = new StringTokenizer(tbVals,",");
        String[] arrVals = new String[numOfCols];
        
        int i = 0;
        while (st.hasMoreTokens()) 
        {
            arrList[i] = st.nextToken();
            i++;
        }  
        
        int j = 0;
        while (stC.hasMoreTokens()) 
        {
            arrVals[j] = stC.nextToken();
            j++;
        }  
        
        String curCol;
        String curVal;
        String totCol = "";
        
        for(int c=0; c<arrList.length;c++)
        {
            curCol ="`"+arrList[c]+"`";
            curVal = "'"+arrVals[c]+"'";
            totCol = totCol+","+curCol + " = " + curVal;
        }
        
        totCol =totCol.substring(1, totCol.length());
        txtPriKeyCol = "`" + txtPriKeyCol + "`";
      
        String sql = "UPDATE "+tableName+" SET " + totCol +" WHERE `"+tableName+"`."+ txtPriKeyCol + " = '"+txtPriKeyVal+"'";
        System.out.println(sql);
        
        try 
        {
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Record Updated Sucessfully");
        } 
        catch (SQLException | HeadlessException e) 
        {
            JOptionPane.showMessageDialog(null,"Can't UPDATE this Record","Error",JOptionPane.ERROR_MESSAGE); 
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    
    
    public void setToText(JTable tableName, JTextField txtName,int colNum)
    {
        txtName.setText(tableName.getValueAt(getSelectedRow(tableName), colNum).toString());
    }
    
    public void setToCmb(JTable tableName, JComboBox cmbName, int colNum)
    {
        cmbName.setSelectedItem(tableName.getValueAt(getSelectedRow(tableName), colNum).toString());
    }

    public String generatePrimaryKey(String primaryKeyCol,String dbTableName,String prefix)
    {
        String pKey = null;
        int id = 0;
        String pid="";
        String sql = "SELECT `"+primaryKeyCol+"` FROM "+dbTableName+" ORDER BY `"+primaryKeyCol+"` DESC LIMIT 1";
        
        try 
        {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next())
            {
                    pid = rs.getString(primaryKeyCol);
                    
            }
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e);
            
        }
        
        if(pid == null || pid == "")
        {
            pid="00-00000";
        }
        
        StringTokenizer st = new StringTokenizer(pid,"-");
        int numOfCols = st.countTokens();
        String[] arrList = new String[numOfCols];
        
        int i = 0;
        while (st.hasMoreTokens()) 
        {
            arrList[i] = st.nextToken();
            i++;
        }
        
        id  = Integer.parseInt(arrList[1]);
        
        id++;
        
        String formattedKey = String.format("%05d", id);
        pKey = prefix+"-"+formattedKey;
        
        return pKey;
    }
    
}

