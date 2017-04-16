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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.HMS;
import source.DBConnection;

/**
 *
 * @author frank
 */
public class Stock_Frame_Model extends HMS {

    public Stock_Frame_Model() {
        con = DBConnection.connect();

    }

    private String Stockid;
    private String StockName;
    private int level;

    @Override
    public void add(String tableName) {

    }

    @Override
    public void update(String tableName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Modelsearch() {
        String filters = Stock_Frame_Frame.cmbSearchBy.getSelectedItem().toString();
        String filter = "`" + filters + "`";
        String search = Stock_Frame_Frame.txtSearch.getText();
        String tablename = "stock";
        JTable tblName = Stock_Frame_Frame.tblStockFrame;

        search(filter, search, tablename, tblName);

    }

    public void EnterLowlvls() {

        float rowCount = Stock_Details_Frame.tblStockDetails.getRowCount();
        int val1, val2;
        String id;
        for (int i = 0; i < rowCount; i++) {

            val1 = Integer.parseInt(Stock_Details_Frame.tblStockDetails.getValueAt(i, 4).toString());
            val2 = Integer.parseInt(Stock_Details_Frame.tblStockDetails.getValueAt(i, 6).toString());
            id = this.Stockid = Stock_Details_Frame.tblStockDetails.getValueAt(i, 0).toString();
            if (val2 > val1) {
                JOptionPane.showMessageDialog(null, "If");

                this.Stockid = Stock_Details_Frame.tblStockDetails.getValueAt(i, 0).toString();
                this.StockName = Stock_Details_Frame.tblStockDetails.getValueAt(i, 2).toString();
                this.level = Integer.parseInt(Stock_Details_Frame.tblStockDetails.getValueAt(i, 4).toString());
                if (id.equals(this.Stockid)) {

                }

            }

        }
    }

}
