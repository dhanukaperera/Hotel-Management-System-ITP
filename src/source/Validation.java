/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Dhanuka Perera
 */
public  class Validation 
{
    public static boolean isEmpty(JTextField txtFieldName, String errorMessage)
    {
        String str = txtFieldName.getText();
        if(str.equals("") || str == null)
        {
            JOptionPane.showMessageDialog(null,errorMessage,"Invalid Data" ,JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else
        {
            return true;
        }
	
    }
    private static boolean checkEmail(String email) 
    {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
    
    public static boolean isValidEmailAddress(JTextField txtFieldName)
    {
        String email = txtFieldName.getText();
        
        if(checkEmail(email) ==  true)
        {
            return true;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Not a valid Email Address","Invalid Data" ,JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    private static boolean checkLetters(String txt) 
    {
        String regx = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();
    }
    
    public static boolean isLetters(JTextField txtFieldName, String errorMessage)
    {
        String Field = txtFieldName.getText();
        if(checkLetters(Field) ==  true)
        {
            return true;
        }
        else
        {
            JOptionPane.showMessageDialog(null,errorMessage,"Invalid Data" ,JOptionPane.ERROR_MESSAGE);
            return false;
        }
            
    }
    
    private static boolean checkNumber(String numField)
    {
        String regx = "[0-9]+";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(numField);
        return matcher.find();
    }
    
    public static boolean isNumber(JTextField txtFieldName, String errorMessage)
    {
        String number = txtFieldName.getText();
        
        if ( checkNumber(number) == true)
        {
            return true;
        }
        else
        {
            JOptionPane.showMessageDialog(null,errorMessage,"Invalid Data" ,JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public static boolean isPositive(JTextField txtFieldName, String errorMessage)
    {
    float number = Float.parseFloat(txtFieldName.getText());
        if(number>=0)
        {
        return true;
        
        }
        else
        {
        
        JOptionPane.showMessageDialog(null,errorMessage,"Invalid Data" ,JOptionPane.ERROR_MESSAGE);
            return false;
        
        }
    
    
    }
    public static boolean validatePhoneNumber(JTextField txtFieldName, String errorMessage) {
		String phoneNo=txtFieldName.getText();
               
		if (phoneNo.matches("\\d{10}")) return true;
		
		else
        {
            JOptionPane.showMessageDialog(null,errorMessage,"Invalid Data" ,JOptionPane.ERROR_MESSAGE);
            return false;
        }
		 
		
	}
    
    public static boolean NoequalsToZero(JTextField txtFieldName, String errorMessage)
    {
    int no = Integer.parseInt(txtFieldName.getText());
        if(no!=0)
        {
        return true;
        
        }
        else
        {
        
        JOptionPane.showMessageDialog(null,errorMessage,"Invalid Insertion" ,JOptionPane.ERROR_MESSAGE);
            return false;
        
        }
    
    
    }
    
}
