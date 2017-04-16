/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.room_reservation;

import model.HMS;
import source.DBConnection;

/**
 *
 * @author Dhanuka Perera
 */
public class TrasferIncome_Model extends HMS
{
    public TrasferIncome_Model()
    {
        con = DBConnection.connect();
    }
    public void caltrans ()
    {   
        
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
