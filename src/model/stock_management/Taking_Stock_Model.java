/*
 * Hotel Management System for Pavana Hotel Kochchikade
 * Information Technology Project - 2016
 * Project ID   : ITP_WD_16_B1_06
 * Supervisor   : Mrs. Asanthika Imbulpitiya
 *
 * Student Name : Alwis W.O.F.V   
 * IT Number    : IT15001962
 */
package model.stock_management;

import app.stock_management.Taking_Stock_Frame;
import app.Main;
import app.finance_management.Incomes_Management_Frame;
import app.stock_management.Stock_Details_Frame;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.HMS;
import model.finance_management.Incomes_Management_Model;
import source.DBConnection;

/**
 *
 * @author frank
 */
public class Taking_Stock_Model extends HMS {

    private String userName;
    private String employeeID;
    private String employeeName;
    private String stockName;
    private int quantity;
    private float pr;
    private float price;
    private String date;
    private String todaydate;
    private int gQuantity;
    protected PreparedStatement pst2 = null;
    public int checkquatity;
    public int finalQuantity;
    String Expense;
    float expenditure;
    String department;

    protected ResultSet rs2 = null;
    protected String stname = "*";
    private int fin;
    protected String colList2 = "*";

    public Taking_Stock_Model() {
        con = DBConnection.connect();
        userName = "NULL";
        employeeID = "NULL";
        employeeName = "NULL";
        stockName = "NULL";
        quantity = 0;
        price = 0;

        stname = "`Stock Name`";
        colList2 = "`Stock Name`,`Stock ID`";
        //  colList = "`History ID`,`Date Modified`,`User Name`,`Employee Name`,`Employee ID`,`Stock Name`,`Quantity`,`Price`";
    }

    // -------------------------------------------------------------------------
    // -- BEGIN Getting Values -------------------------------------------------
    private void getUserName() {
        this.userName = Main.lblUserName.getText();
    }

    private void getEmployeeID() {
        this.employeeID = Taking_Stock_Frame.cmbEmpId.getSelectedItem().toString();
    }

    private void getEmployeeName() {
        this.employeeName = Taking_Stock_Frame.txtEmpName.getText();
    }

    private void getStockName() {
        this.stockName = Taking_Stock_Frame.cmbStockName.getSelectedItem().toString();
    }

    private void getQuantity() {
        this.quantity = Integer.parseInt(Taking_Stock_Frame.txtQuantity.getText());
    }

    public void UserName() {

        this.userName = Main.lblUserName.getText();
        Taking_Stock_Frame.txtUserName.setText(this.userName);

    }

    private void getAll() {
        getUserName();
        getEmployeeID();
        getEmployeeName();
        getStockName();
        getQuantity();
    }
    // -- END GET Values -------------------------------------------------------
    // -------------------------------------------------------------------------

    @Override
    public void add(String tableName) {
        getAll();
        this.checkquatity = Gquantity();
        this.finalQuantity = checkquatity - this.quantity;
        if (this.finalQuantity >= 0) {
            try {
                String prices = "SELECT `Price` FROM stock WHERE `Stock Name` = '" + this.stockName + "'";

                pst = con.prepareStatement(prices);
                rs = pst.executeQuery();

                if (rs.next()) {

                }

                this.pr = rs.getFloat("Price");
                this.price = this.pr * this.quantity;

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
                Logger.getLogger(Taking_Stock_Model.class.getName()).log(Level.SEVERE, null, ex);
            }

            String sql = "INSERT INTO " + tableName + ""
                    + "(`History ID`,`Date Modified`,`User Name`,`Employee Name`,`Employee ID`,`Stock Name`,`Quantity`,`Price`)"
                    + " VALUES("
                    + "'" + generatePrimaryKey("History ID", "stock_history", "HS") + "',"
                    + "'" + getCurrentDateTime() + "',"
                    + "'" + this.userName + "',"
                    + "'" + this.employeeName + "',"
                    + "'" + this.employeeID + "',"
                    + "'" + this.stockName + "',"
                    + "" + this.quantity + ","
                    + "'" + this.price + "'"
                    + ")";
            System.out.println(sql);
            reduceQuantity();

            try {
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Record Added Succesfully");
                loadTable(tableName, Taking_Stock_Frame.tblTakingStock);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            getAll();
            this.checkquatity = Gquantity();
            this.finalQuantity = checkquatity - this.quantity;
            if (this.finalQuantity == 0) {

            }
            JOptionPane.showMessageDialog(null, "Required Quantity Is  Not Available");

        }
    }

    @Override
    public void update(String tableName) {
        String a = "stock";
        String b = "Insufficent";
        int q = 0;
        int r = 0;
        String qqt = "SELECT `Quantity`,`Reorder` FROM stock WHERE `Stock Name` = '" + this.stockName + "'";
        try {

            pst = con.prepareStatement(qqt);
            rs = pst.executeQuery();
            while (rs.next()) {

                q = rs.getInt("Quantity");
                r = rs.getInt("Reorder");

                if (r >= q) {
                    String sql = "UPDATE " + a + ""
                            + " SET `Stock Name` = " + "'" + this.stockName + "',"
                            + "`Level` = '" + b + "' "
                            + "WHERE `Stock Name` = '" + this.stockName + "'";
                    System.out.println(sql);

                    pst = con.prepareStatement(sql);
                    pst.execute();
                    loadTable("stock", Stock_Details_Frame.tblStockDetails);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Taking_Stock_Model.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void reduceQuantity() {
        String qt = "SELECT `Quantity` FROM stock WHERE `Stock Name` = '" + this.stockName + "'";
        String x = "stock";
        try {

            pst = con.prepareStatement(qt);
            rs = pst.executeQuery();
            if (rs.next()) {

            }

            this.gQuantity = rs.getInt("Quantity");

            int y = Gquantity();
            this.fin = y - quantity;
            String fdasasr = "UPDATE " + x + ""
                    + " SET `Stock Name` = " + "'" + this.stockName + "',"
                    + "`Quantity`= " + this.fin + " "
                    + "WHERE `Stock Name` = '" + this.stockName + "'";

            try {
                pst = con.prepareStatement(fdasasr);
                pst.executeUpdate();
                System.out.println(pst);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error", "error", JOptionPane.ERROR_MESSAGE);

        }
    }

    private int Gquantity() {
        String qt = "SELECT `Quantity` FROM stock WHERE `Stock Name` = '" + this.stockName + "'";
        try {
            pst = con.prepareStatement(qt);
            rs = pst.executeQuery();
            if (rs.next()) {

            }

            this.gQuantity = rs.getInt("Quantity");
            this.checkquatity = this.gQuantity;
        } catch (SQLException ex) {
            Logger.getLogger(Taking_Stock_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gQuantity;

    }

    public void Clear() {

        Taking_Stock_Frame.txtQuantity.setText("");

        Taking_Stock_Frame.lblCost.setText("00.00");
        Taking_Stock_Frame.cmbStockName.setSelectedIndex(0);
    }

    public void Modelsearch() {
        String filters = Taking_Stock_Frame.cmbSearchBy.getSelectedItem().toString();
        String filter = "`" + filters + "`";
        String search = Taking_Stock_Frame.txtSearch.getText();
        String tablename = "stock_history";
        JTable tblName = Taking_Stock_Frame.tblTakingStock;
        search(filter, search, tablename, tblName);

    }

    public void GetTotalCost() {

        float rowCount = Taking_Stock_Frame.tblTakingStock.getRowCount();
        float sum = 0;
        for (int i = 0; i < rowCount; i++) {
            sum = sum + Float.parseFloat(Taking_Stock_Frame.tblTakingStock.getValueAt(i, 7).toString());

        }

        Taking_Stock_Frame.lblCost.setText(Float.toString(sum));
    }

    public void submitExpenditure() {

        this.Expense = "Stock_Sector";

        this.expenditure = Float.parseFloat(Taking_Stock_Frame.lblCost.getText());
        this.department = "Stock";
        String sql = "INSERT INTO " + "`expenses_management`" + ""
                + "(`Expense`,`Date Modified`,`Amount`,`Department`)"
                + " VALUES("
                + "'" + this.Expense + "',"
                + "'" + getCurrentDateTime() + "',"
                + "" + this.expenditure + ","
                + "'" + this.department + "'"
                + ")";
        System.out.println(sql);
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Expenditure Sumbimtted  Succesfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void LoadempID() {
        String empID = "";

        try {

            this.todaydate = getCurrentDate();

            String sql = "SELECT `Employee ID` FROM attendance where `Date`='" + this.todaydate + "' AND `Attendance Status`='Attend'";

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            Taking_Stock_Frame.cmbEmpId.removeAllItems();
            while (rs.next()) {
                empID = rs.getString("Employee ID");
                Taking_Stock_Frame.cmbEmpId.addItem(empID);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error", "error", JOptionPane.ERROR_MESSAGE);

            LoadempID();
        }
        if (empID == null || empID == "") {
            empID = "No Employess Are in the Data Base";
            Taking_Stock_Frame.cmbEmpId.addItem(empID);

        }

    }

    public void getEmpName(String EmpId) {
        this.employeeID = EmpId;

        try {
            String sql = "SELECT `First Name` FROM employee_details where `Employee ID` ='" + this.employeeID + "'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            System.out.println(sql);
            while (rs.next()) {
                String fname = rs.getString("First Name");
                Taking_Stock_Frame.txtEmpName.setText(fname);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    public void getRole(String EmpId) {
        String fname = null;
        this.employeeID = EmpId;

        try {
            String sql = "SELECT `Role Type` FROM employee_details where `Employee ID` ='" + this.employeeID + "'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                fname = rs.getString("Role Type");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        try {
            String b = fname;

            System.out.println(b);
            Taking_Stock_Frame.cmbStockName.removeAllItems();
            if ("Kitchen".equals(b) || "kitchen".equals(b)) {

                String sql = "SELECT `Stock Name` FROM stock";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                while (rs.next()) {

                    Taking_Stock_Frame.cmbStockName.enable();
                    fname = rs.getString("Stock Name");
                    System.out.println(fname);
                    Taking_Stock_Frame.cmbStockName.addItem(fname);

                }

            } else if ("Events ".equals(b) || "Events ".equals(b)) {
                String sql2 = "SELECT `Stock Name` FROM stock where `Type` ='Drinking' ";
                pst = con.prepareStatement(sql2);
                rs = pst.executeQuery();

                while (rs.next()) {

                    Taking_Stock_Frame.cmbStockName.enable();
                    fname = rs.getString("Stock Name");
                    System.out.println(fname);
                    Taking_Stock_Frame.cmbStockName.addItem(fname);

                }

            } else if ("Touring".equals(b) || "touring".equals(b)) {
                String sql3 = "SELECT `Stock Name` FROM stock where `Type` ='Cleaning' ";
                pst = con.prepareStatement(sql3);
                rs = pst.executeQuery();

                while (rs.next()) {

                    Taking_Stock_Frame.cmbStockName.enable();
                    fname = rs.getString("Stock Name");
                    System.out.println(fname);
                    Taking_Stock_Frame.cmbStockName.addItem(fname);

                }

            } else if ("Adimistration".equals(b) || "adimistration".equals(b)) {
                Taking_Stock_Frame.cmbStockName.disable();

            } else if ("Laundry".equals(b) || "laundry".equals(b)) {
                String sql3 = "SELECT `Stock Name` FROM stock where `Type`='Cleaning'";
                pst = con.prepareStatement(sql3);
                rs = pst.executeQuery();

                while (rs.next()) {

                    Taking_Stock_Frame.cmbStockName.enable();
                    fname = rs.getString("Stock Name");
                    System.out.println(fname);
                    Taking_Stock_Frame.cmbStockName.addItem(fname);

                }

            }
        } catch (Exception e) {

        }
    }

    public String getCurrentDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateobj = new java.util.Date();
        return this.date = df.format(dateobj);
    }

 
}
