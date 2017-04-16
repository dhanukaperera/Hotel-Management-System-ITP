/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Dhanuka Perera
 */
public class ImageProcessing 
{
    public void loadImage(JLabel label, String name)
    {
        
        try {
              ImageIcon changeIcon = new ImageIcon(getClass().getResource("/resources/submenu/" +  name + ".png"));
              label.setIcon(changeIcon);
        } 
        catch (Exception e) 
        {
            System.err.println("Can't find "+ name );
        }
    }
    
    public void loadMenuImage (JLabel label, String name)
    {
        
        try {
              ImageIcon changeIcon = new ImageIcon(getClass().getResource("/resources/mainmenu/" +  name + ".png"));
              label.setIcon(changeIcon);
        } 
        catch (Exception e) 
        {
            System.err.println("Can't find "+ name );
        }
    }
   
    
    public void buttonState (JLabel label, String name)
    {
        
        try {
              ImageIcon changeIcon = new ImageIcon(getClass().getResource("/resources/buttons/" +  name + ".png"));
              label.setIcon(changeIcon);
        } 
        catch (Exception e) 
        {
            System.err.println("Can't find "+ name );
        }
    }
}
