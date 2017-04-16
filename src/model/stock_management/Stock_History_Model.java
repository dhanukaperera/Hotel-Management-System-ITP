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

import app.stock_management.Stock_History_Frame;
//import static app.stock_management.Stock_History_Frame.lblCost;
import app.stock_management.Taking_Stock_Frame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.HMS;
import reports.iReport;
import reports.iReportView;
import source.DBConnection;

/**
 *
 * @author frank
 */
public class Stock_History_Model extends HMS {

    String suppID;

    private String firstName;
    private String lastName;

    private String productName;

    private int phone;
    private String productID;
    private int quantity;
    private String status;
    private String status2;

    private String orderId;

    public Stock_History_Model() {
        status = "Order Not Recieved";
        status2 = "Ordered Recieved ";
        con = DBConnection.connect();
        //  colList = "`Order ID`,`Supplier ID`,`Date Modified`,`First Name`,`Last Name`,`Product Name`,`Phone`,`Product ID,`Quantity`,`Status`";
    }
    // -------------------------------------------------------------------------
    // -- BEGIN Getting Values -------------------------------------------------

    private void getSupplierID() {
        this.productID = Stock_History_Frame.cmbStockId.getSelectedItem().toString();
    }

    private void getFirstName() {
        this.firstName = Stock_History_Frame.txtFirstName.getText();
    }

    private void getLastName() {
        this.lastName = Stock_History_Frame.txtLastName.getText();
    }

    private void getPhone() {
        this.phone = Integer.parseInt(Stock_History_Frame.txtPhone.getText());
    }

    private void getProductid() {
        this.suppID = Stock_History_Frame.txtSupplierID.getText();
    }

    private void getProductName() {
        this.productName = Stock_History_Frame.txtStockName.getText();
    }

    private void getQuantity() {
        this.quantity = Integer.parseInt(Stock_History_Frame.txtQuantity.getText());
    }

    private void getOrderId() {
        this.orderId = Stock_History_Frame.txtOrderid.getText();
    }

    public void getAll() {
        getOrderId();
        getSupplierID();
        getFirstName();
        getLastName();
        getPhone();
        getProductid();
        getProductName();
        getQuantity();
    }
    // -- END GET Values -------------------------------------------------------
    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    // -- BEGIN Setting Values -------------------------------------------------
    public void setProductID() {
        Stock_History_Frame.cmbStockId.setSelectedItem(Stock_History_Frame.tblHistory.getValueAt(getSelectedRow(Stock_History_Frame.tblHistory), 6).toString());
    }

    private void setFirstName() {
        Stock_History_Frame.txtFirstName.setText(Stock_History_Frame.tblHistory.getValueAt(getSelectedRow(Stock_History_Frame.tblHistory), 3).toString());
    }

    private void setLastName() {
        Stock_History_Frame.txtLastName.setText(Stock_History_Frame.tblHistory.getValueAt(getSelectedRow(Stock_History_Frame.tblHistory), 4).toString());
    }

    private void setPhone() {
        Stock_History_Frame.txtPhone.setText(Stock_History_Frame.tblHistory.getValueAt(getSelectedRow(Stock_History_Frame.tblHistory), 5).toString());
    }

    private void setSupplierId() {
        Stock_History_Frame.txtSupplierID.setText(Stock_History_Frame.tblHistory.getValueAt(getSelectedRow(Stock_History_Frame.tblHistory), 1).toString());
    }

    private void setProductName() {
        Stock_History_Frame.txtStockName.setText(Stock_History_Frame.tblHistory.getValueAt(getSelectedRow(Stock_History_Frame.tblHistory), 7).toString());
    }

    private void setQuantity() {
        Stock_History_Frame.txtQuantity.setText(Stock_History_Frame.tblHistory.getValueAt(getSelectedRow(Stock_History_Frame.tblHistory), 8).toString());
    }

    private void setOrderId() {
        Stock_History_Frame.txtOrderid.setText(Stock_History_Frame.tblHistory.getValueAt(getSelectedRow(Stock_History_Frame.tblHistory), 0).toString());
    }

    public String getPrimaryKey() {
        getOrderId();
        setOrderId();
        return this.orderId;

    }

    public void setALL() {
        setOrderId();
        setQuantity();
        setSupplierId();
        setFirstName();
        setLastName();
        setProductName();
        setPhone();
        setProductID();
    }

    public void GetTotalCost() {

        int rowCount = Taking_Stock_Frame.tblTakingStock.getRowCount();
        int sum = 0;
        for (int i = 0; i < rowCount; i++) {
            sum = sum + Integer.parseInt(Taking_Stock_Frame.tblTakingStock.getValueAt(i, 7).toString());

        }
//    return sum;

    }

    @Override
    public void add(String tableName) {
        getAll();
        String sql = "INSERT INTO " + tableName + ""
                + "(`Order ID`,`Supplier ID`,`Date Modified`,`First Name`,`Last Name`,`Phone`,`Product ID`,`Product Name`,`Quantity`,`Status`)"
                + " VALUES("
                + "'" + generatePrimaryKey("Order ID", "orders", "OD") + "',"
                + "'" + this.suppID + "',"
                + "'" + getCurrentDateTime() + "',"
                + "'" + this.firstName + "',"
                + "'" + this.lastName + "',"
                + "" + this.phone + ","
                + "'" + this.productID + "',"
                + "'" + this.productName + "',"
                + "" + this.quantity + ","
                + "'" + this.status + "'"
                + ")";
        System.out.println(sql);
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Record Added Succesfully");
            loadTable(tableName, Stock_History_Frame.tblHistory);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update(String tableName) {
        getAll();
        String sql = "UPDATE " + tableName + ""
                + " SET `Supplier ID` = " + "'" + this.suppID + "',"
                + "`Date Modified`= '" + getCurrentDateTime() + "',"
                + "`First Name` = '" + this.firstName + "',"
                + "`Last Name` = '" + this.lastName + "',"
                + "`Phone`=" + this.phone + ","
                + "`Product ID`='" + this.productID + "',"
                + "`Product Name`='" + this.productName + "',"
                + "`Quantity`= " + this.quantity + ","
                + "`Status`='" + this.status2 + "'"
                + "WHERE `Order ID` = '" + this.orderId + "'";
        //System.out.println(sql);

        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Record Updated Succesfully");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Modelsearch() {
        String filters = Stock_History_Frame.cmbSearchBy.getSelectedItem().toString();
        String filter = "`" + filters + "`";
        String search = Stock_History_Frame.txtSearch.getText();
        String tablename = "orders";
        JTable tblName = Stock_History_Frame.tblHistory;

        search(filter, search, tablename, tblName);
    }

    public void ProductId() {
        try {
            String sql = "SELECT `Product ID` FROM suppliers";
            System.out.println(sql);
            pst = con.prepareStatement(sql);

            rs = pst.executeQuery();
            Stock_History_Frame.cmbStockId.removeAllItems();
            while (rs.next()) {
                String SuppID = rs.getString("Product ID");
                Stock_History_Frame.cmbStockId.addItem(SuppID);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void getName(String ProID) {

        this.productID = ProID;

        try {
            String sql = "SELECT `First Name` FROM suppliers where `Product ID` ='" + this.productID + "'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String fname = rs.getString("First Name");
                Stock_History_Frame.txtFirstName.setText(fname);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            String sql2 = "SELECT `Last Name` FROM suppliers where `Product ID` ='" + this.productID + "'";
            pst = con.prepareStatement(sql2);
            rs = pst.executeQuery();
            while (rs.next()) {

                String lname = rs.getString("Last Name");
                Stock_History_Frame.txtLastName.setText(lname);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            String sql3 = "SELECT `Phone` FROM suppliers where `Product ID` ='" + this.productID + "'";
            pst = con.prepareStatement(sql3);
            rs = pst.executeQuery();
            while (rs.next()) {

                String phone = rs.getString("Phone");
                Stock_History_Frame.txtPhone.setText(phone);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            String sql4 = "SELECT `Supplier ID` FROM suppliers where `Product ID` ='" + this.productID + "'";
            pst = con.prepareStatement(sql4);
            rs = pst.executeQuery();
            System.out.println(sql4);
            while (rs.next()) {

                String SupID = rs.getString("Supplier ID");
                Stock_History_Frame.txtSupplierID.setText(SupID);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            String sql5 = "SELECT `Product Name` FROM suppliers where `Product ID` ='" + this.productID + "'";
            pst = con.prepareStatement(sql5);
            rs = pst.executeQuery();

            while (rs.next()) {

                String proNm = rs.getString("Product Name");
                Stock_History_Frame.txtStockName.setText(proNm);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        if (this.productID == null || this.productID == "") {

        }
    }

    public void report() {
        iReport z = new iReport();
        iReportView r = new iReportView(z.PROJECT_PATH + "\\stock_management\\Taking.jasper");

        r.setVisible(true);
    }
    
}
