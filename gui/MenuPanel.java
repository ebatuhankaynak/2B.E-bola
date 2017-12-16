/**
* @author  Deniz Sipahioglu
* @version 1.0
* Created: 10/20/2017 
*/
import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.util.ArrayList; 
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class MenuPanel extends JPanel{
 Image image;
 ArrayList<MenuButton> menuButtons;
 
 public MenuPanel(){
  menuButtons = new ArrayList<>();
  setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  setPreferredSize(new Dimension(600, 600));
  try{
  image = ImageIO.read(new File("../Images/bg.png"));
  }catch(IOException ex){System.out.println("not found");}
  add(Box.createRigidArea(new Dimension(0, 120)));
  addButton(PanelType.PLAY);
  addButton(PanelType.SETTINGS);
  addButton(PanelType.EXIT);
 }
 
 public ArrayList<MenuButton> getButtons(){
  return menuButtons;
 }
 
 private void addButton(PanelType panelType){
  add(Box.createRigidArea(new Dimension(0, 25)));
  MenuButton button = new MenuButton(panelType);
  button.setAlignmentX(Component.CENTER_ALIGNMENT);
  menuButtons.add(button);
  add(button);
 }
 public void paintComponent(Graphics g)
 {
     g.drawImage(image, 0, 0, null);
 }
}
