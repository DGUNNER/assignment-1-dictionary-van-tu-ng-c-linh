/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.learn;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Admin
 */
public class ImageSize {
    public static ImageIcon ImageSize(int Size,ImageIcon img)
    {
       Image image = img.getImage();
        Image newImg =  image.getScaledInstance(Size,Size,Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }
    
}
