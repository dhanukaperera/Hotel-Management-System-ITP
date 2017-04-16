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

import app.stock_management.Stock_Details_Frame;
import app.stock_management.Stock_Frame_Frame;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.HMS;
import net.proteanit.sql.DbUtils;
import reports.iReport;
import reports.iReportView;
import source.DBConnection;

/**
 *
 * @author frank
 */
public class Stock_Details_Model extends HMS {

    private String stockID;
    private String stockName;
    private String stockType;
    private int quantity;
    private float price;
    private int increasequantity;
    private int newQuantity;
    private int upQuantity;
    private int reorder;
    protected String colList2 = "*";
    private String lvl;

    public Stock_Details_Model() {
        con = DBConnection.connect();
        this.reorder = 0;
        this.stockID = "NULL";
        this.stockName = "NULL";
        this.stockType = "No Stock Type";
        lvl = "Sufficent";
        this.price = 15;
        this.quantity = 0;
        colList2 = "`Product Name`,`Product ID`";
        //colList = "`Stock ID`,`Date Modified`,`Stock Name`,`Type`,`Quantity`,`Price`,`Reorder`";
    }

    public String getPrimaryKey() {

        setStockID();
        getStockID();
        return this.stockID;
    }
    // -------------------------------------------------------------------------
    // -- BEGIN Getting Values -------------------------------------------------

    private void getStockID() {
        this.stockID = Stock_Details_Frame.txtStockID.getText();
    }

    private void getStockName() {
        this.stockName = Stock_Details_Frame.txtStockName.getText();
    }

    private void getStockType() {
        this.stockType = Stock_Details_Frame.cmbStockType.getSelectedItem().toString();
    }

    private void getQuantity() {
        this.quantity = Integer.parseInt(Stock_Details_Frame.txtQuantity.getText());
    }

    private void getPrice() {
        this.price = Float.parseFloat(Stock_Details_Frame.txtPrice.getText());
    }

    private void getReoderLvl() {
        this.reorder = Integer.parseInt(Stock_Details_Frame.txtReoder.getText());
    }

    private void getAll() {
        getStockID();
        getStockName();
        getStockType();
        getPrice();
        getQuantity();
        getReoderLvl();

    }

    // -- END GET Values -------------------------------------------------------
    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    // -- BEGIN Setting Values -------------------------------------------------
    private void setStockID() {
        Stock_Details_Frame.txtStockID.setText(Stock_Details_Frame.tblStockDetails.getValueAt(getSelectedRow(Stock_Details_Frame.tblStockDetails), 0).toString());
    }

    private void setStockName() {
        Stock_Details_Frame.txtStockName.setText(Stock_Details_Frame.tblStockDetails.getValueAt(getSelectedRow(Stock_Details_Frame.tblStockDetails), 2).toString());
    }

    private void setStockType() {
        Stock_Details_Frame.cmbStockType.setSelectedItem(Stock_Details_Frame.tblStockDetails.getValueAt(getSelectedRow(Stock_Details_Frame.tblStockDetails), 3).toString());
    }

    private void setPrice() {
        Stock_Details_Frame.txtPrice.setText(Stock_Details_Frame.tblStockDetails.getValueAt(getSelectedRow(Stock_Details_Frame.tblStockDetails), 5).toString());
    }

    private void setQuantity() {
        Stock_Details_Frame.txtQuantity.setText(Stock_Details_Frame.tblStockDetails.getValueAt(getSelectedRow(Stock_Details_Frame.tblStockDetails), 4).toString());
    }

    private void setReorderLvl() {
        Stock_Details_Frame.txtReoder.setText(Stock_Details_Frame.tblStockDetails.getValueAt(getSelectedRow(Stock_Details_Frame.tblStockDetails), 6).toString());
    }

    public void setProductID() {
        Stock_Details_Frame.txtStockID.setText(Stock_Details_Frame.tblSupplier2.getValueAt(getSelectedRow(Stock_Details_Frame.tblSupplier2), 1).toString());
    }

    public void setProductName() {
        Stock_Details_Frame.txtStockName.setText(Stock_Details_Frame.tblSupplier2.getValueAt(getSelectedRow(Stock_Details_Frame.tblSupplier2), 0).toString());
    }

    public void setAll() {
        setStockID();
        setStockName();
        setStockType();
        setPrice();
        setReorderLvl();
        setQuantity();
    }
    // -- END Setting Values ---------------------------------------------------
    // -------------------------------------------------------------------------

    @Override

    public void add(String tableName) {
        getAll();

        String sql = "INSERT INTO " + tableName + ""
                + "(`Stock ID`,`Stock Name`,`Date Modified`,`Type`,`Quantity`,`Price`,`Reorder`,`Level`)"
                + " VALUES("
                + "'" + this.stockID + "',"
                + "'" + this.stockName + "',"
                + "'" + getCurrentDateTime() + "',"
                + "'" + this.stockType + "',"
                + "" + this.quantity + ","
                + "" + this.price + ","
                + "" + this.reorder + ","
                + "'" + this.lvl + "'"
                + ")";
        System.out.println(sql);
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Record Added Succesfully");
            loadTable(tableName, Stock_Details_Frame.tblStockDetails);
            loadTable(tableName, Stock_Frame_Frame.tblStockFrame);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update(String tableName) {
        getAll();

        upQuantity = increasequantity();
        String sql = "UPDATE " + tableName + ""
                + " SET `Stock Name` = " + "'" + this.stockName + "',"
                + "`Date Modified`= '" + getCurrentDateTime() + "',"
                + "`Type` = '" + this.stockType + "',"
                + "`Quantity`= " + this.upQuantity + ","
                + "`Price`= " + this.price + ","
                + "`Reorder`= " + this.reorder + ","
                + "`Level`='" + this.lvl + "' "
                + "WHERE `Stock ID` = '" + this.stockID + "'";

        System.out.println(sql);

        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Record Updated Succesfully");
            System.out.println(sql);
            loadTable(tableName, Stock_Details_Frame.tblStockDetails);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Clear() {
        Stock_Details_Frame.txtStockID.setText("");
        Stock_Details_Frame.txtStockName.setText("");
        Stock_Details_Frame.txtPrice.setText("");
        Stock_Details_Frame.txtQuantity.setText("");
        Stock_Details_Frame.cmbStockType.setSelectedIndex(0);
        Stock_Details_Frame.txtReoder.setText("");
    }

    public void Modelsearch() {
        String filters = Stock_Details_Frame.cmbSearchBy.getSelectedItem().toString();
        String filter = "`" + filters + "`";
        String search = Stock_Details_Frame.txtSearch.getText();
        String tablename = "stock";
        JTable tblName = Stock_Details_Frame.tblStockDetails;

        search(filter, search, tablename, tblName);

    }

    private int increasequantity() {
        String qt = "SELECT `Quantity` FROM stock WHERE `Stock ID` = '" + this.stockID + "'";
        try {
            pst = con.prepareStatement(qt);
            rs = pst.executeQuery();
            if (rs.next()) {

            }

            this.increasequantity = rs.getInt("Quantity");
            newQuantity = this.increasequantity + this.quantity;

        } catch (SQLException ex) {
            Logger.getLogger(Taking_Stock_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newQuantity;

    }

    public void loadTable2(String tableName, JTable tblName) {
        String sql = "SELECT " + colList2 + " "
                + "FROM " + tableName + "";
        System.out.println(sql);
        try {

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            tblName.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void report() {
        iReport z = new iReport();
        iReportView r = new iReportView(z.PROJECT_PATH + "\\stock_management\\Stock.jasper");

        r.setVisible(true);
    }

}
