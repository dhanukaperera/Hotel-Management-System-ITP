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

import app.stock_management.Suppliers_Frame;
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
public class Suppliers_Model extends HMS {

    private String supplierID;
    private String firstName;
    private String lastName;
    private String companyName;
    private String productName;
    private String address;
    private int phone;
    private String productID;

    public Suppliers_Model() {
        con = DBConnection.connect();
        this.supplierID = "NULL";
        this.firstName = "NULL";
        this.lastName = "NULL";
        this.companyName = "NULL";
        this.productName = "NULL";
        this.address = "NULL";
        this.phone = 0;
        this.productID = "NULL";
        super.colList = "`Supplier ID`,`Date Modified`,`First Name`,`Last Name`,`Company Name`,`Product Name`,`Address`,`Phone`,`Product ID`";
        // System.out.println(colList);

    }
    // -------------------------------------------------------------------------
    // -- BEGIN Getting Values -------------------------------------------------

    private void getSupplierID() {
        this.supplierID = Suppliers_Frame.txtSupplierID.getText();
    }

    private void getFirstName() {
        this.firstName = Suppliers_Frame.txtFirstName.getText();
    }

    private void getLastName() {
        this.lastName = Suppliers_Frame.txtLastName.getText();
    }

    private void getCompanyName() {
        this.companyName = Suppliers_Frame.txtCompanyName.getText();
    }

    private void getAddress() {
        this.address = Suppliers_Frame.txtAddress.getText();
    }

    private void getProductName() {
        this.productName = Suppliers_Frame.txtProductName.getText();
    }

    private void getPhone() {
        this.phone = Integer.parseInt(Suppliers_Frame.txtPhone.getText());
    }

    private void getProductid() {
        this.productID = Suppliers_Frame.txtProductId.getText();
    }

    private void getAll() {

        getSupplierID();
        getFirstName();
        getLastName();
        getCompanyName();
        getAddress();
        getProductName();
        getPhone();
        getProductid();

    }

    public String getPrimaryKey() {

        setProductId();
        getProductid();
        return this.productID;

    }
    // -- END GET Values -------------------------------------------------------
    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    // -- BEGIN Setting Values -------------------------------------------------
    private void setSupplierID() {
        Suppliers_Frame.txtSupplierID.setText(Suppliers_Frame.tblSupplier.getValueAt(getSelectedRow(Suppliers_Frame.tblSupplier), 0).toString());
    }

    private void setFirstName() {
        Suppliers_Frame.txtFirstName.setText(Suppliers_Frame.tblSupplier.getValueAt(getSelectedRow(Suppliers_Frame.tblSupplier), 2).toString());
    }

    private void setLastName() {
        Suppliers_Frame.txtLastName.setText(Suppliers_Frame.tblSupplier.getValueAt(getSelectedRow(Suppliers_Frame.tblSupplier), 3).toString());
    }

    private void setCompanyName() {
        Suppliers_Frame.txtCompanyName.setText(Suppliers_Frame.tblSupplier.getValueAt(getSelectedRow(Suppliers_Frame.tblSupplier), 4).toString());
    }

    private void setProductName() {
        Suppliers_Frame.txtProductName.setText(Suppliers_Frame.tblSupplier.getValueAt(getSelectedRow(Suppliers_Frame.tblSupplier), 5).toString());
    }

    private void setAddress() {
        Suppliers_Frame.txtAddress.setText(Suppliers_Frame.tblSupplier.getValueAt(getSelectedRow(Suppliers_Frame.tblSupplier), 6).toString());
    }

    private void setPhone() {
        Suppliers_Frame.txtPhone.setText(Suppliers_Frame.tblSupplier.getValueAt(getSelectedRow(Suppliers_Frame.tblSupplier), 7).toString());
    }

    private void setProductId() {
        Suppliers_Frame.txtProductId.setText(Suppliers_Frame.tblSupplier.getValueAt(getSelectedRow(Suppliers_Frame.tblSupplier), 8).toString());
    }

    public void setALL() {
        setSupplierID();
        setFirstName();
        setLastName();
        setCompanyName();
        setAddress();
        setProductName();
        setPhone();
        setProductId();
    }
    // -- END Setting Values -------------------------------------------------------
    // -------------------------------------------------------------------------

    @Override
    public void add(String tableName) {
        getAll();
        String sql = "INSERT INTO " + tableName + ""
                + "(`Supplier ID`,`Date Modified`,`First Name`,`Last Name`,`Company Name`,`Product Name`,`Address`,`Phone`,`Product ID`)"
                + " VALUES("
                + "'" + this.supplierID + "',"
                + "'" + getCurrentDateTime() + "',"
                + "'" + this.firstName + "',"
                + "'" + this.lastName + "',"
                + "'" + this.companyName + "',"
                + "'" + this.productName + "',"
                + "'" + this.address + "',"
                + "" + this.phone + ","
                + "'" + generatePrimaryKey("Product ID", "suppliers", "PID") + "'"
                + ")";
        //System.out.println(sql);
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Record Added Succesfully");
            loadTable(tableName, Suppliers_Frame.tblSupplier);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update(String tableName) {
        getAll();
        String sql = "UPDATE " + tableName + ""
                + " SET `Supplier ID` = " + "'" + this.supplierID + "',"
                + "`First Name`='" + this.firstName + "',"
                + "`Date Modified`= '" + getCurrentDateTime() + "',"
                + "`Last Name` = '" + this.lastName + "',"
                + "`Company Name`='" + this.companyName + "',"
                + "`Address`='" + this.address + "',"
                + "`Phone`=" + this.phone + ","
                + "`Product Name`='" + this.productName + "'"
                + "WHERE `Product ID` = '" + this.productID + "'";

        System.out.println(sql);

        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Record Updated Succesfully");
            loadTable(tableName, Suppliers_Frame.tblSupplier);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Clear() {
        Suppliers_Frame.txtSupplierID.setText("");
        Suppliers_Frame.txtAddress.setText("");
        Suppliers_Frame.txtCompanyName.setText("");
        Suppliers_Frame.txtPhone.setText("");
        Suppliers_Frame.txtFirstName.setText("");
        Suppliers_Frame.txtLastName.setText("");
        Suppliers_Frame.txtProductName.setText("");
        Suppliers_Frame.txtProductId.setText("");

    }

    public void Modelsearch() {
        String filters = Suppliers_Frame.cmbSearchBy.getSelectedItem().toString();
        String filter = "`" + filters + "`";
        String search = Suppliers_Frame.txtSearch.getText();
        String tablename = "suppliers";
        JTable tblName = Suppliers_Frame.tblSupplier;

        search(filter, search, tablename, tblName);

    }

    public void report() {
        iReport z = new iReport();
        iReportView r = new iReportView(z.PROJECT_PATH + "\\stock_management\\Suppliers.jasper");

        r.setVisible(true);
    }
}
