/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

import java.util.StringTokenizer;
import javax.swing.JComboBox;

/**
 *
 * @author Dhanuka Perera
 */
public class Tests 
{
    public void setShiftTimes(String time,JComboBox to, JComboBox from)
    {
        //Shift time Should be like this --> "08:00 - 16:00"
        
        StringTokenizer stTime = new StringTokenizer(time,",");
        String[] arrTime = new String[1];
        
        int t = 0;
        while (stTime.hasMoreTokens()) 
        {
            arrTime[t] = stTime.nextToken();
            t++;
        }  
        
        to.setSelectedItem(arrTime[0]);
        from.setSelectedItem(arrTime[1]);
    }
    
    public void setDay()
    {
        // String time = ""; // get the time from the table;
        //setShiftTimes(time,cmbTo,cmbFrom);
    }
    
}
