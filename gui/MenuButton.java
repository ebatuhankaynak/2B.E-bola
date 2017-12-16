/**
* @author  Deniz Sipahioglu
* @version 1.2
* Created: 10/20/2017 
*/

package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class MenuButton extends JButton implements ActionListener{

 MenuButtonListener listener;
 PanelType panelType;

 Image buttonOffImage;
 Image buttonOnImage;
 
 public MenuButton(PanelType panelType){
  super();
  String text = panelType.name();
  try{
    buttonOnImage = ImageIO.read(new File("../Images/" + "on" + text + ".png"));
    buttonOffImage = ImageIO.read(new File("../Images/" + "off" + text + ".png"));
  }catch(IOException ex){System.out.println("not found");}
 
  buttonOffImage = buttonOffImage.getScaledInstance( 250, 100,  java.awt.Image.SCALE_SMOOTH ) ;
  buttonOnImage = buttonOnImage.getScaledInstance( 250, 100,  java.awt.Image.SCALE_SMOOTH ) ;
  
  setIcon(new ImageIcon(buttonOffImage));
  this.panelType = panelType;
  addActionListener(this);
  
  addMouseListener(new MouseAdapter() {
    public void mouseEntered(MouseEvent evt) {
        setIcon(new ImageIcon(buttonOnImage));
    }
    public void mouseExited(MouseEvent evt) {
        setIcon(new ImageIcon(buttonOffImage));
    }
});
  
  
 }
 
 public void registerListener(MenuButtonListener mp){
  listener = mp;
 }
 
 public void actionPerformed(ActionEvent e) {
  listener.onMenuButtonClick(panelType);
 }
 
}
