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

import javax.swing.JTable;

public interface Pavana 
{
    public void loadTable(String tableName,JTable tblName); //  Updated!
    public void add(String tableName);
    public void update(String tableName);
    public void delete(String tableName,String coloumName,String primaryKey, JTable tblName);
    
    public String getCurrentDateTime();
    
    
}

/*
load table
load 

*/