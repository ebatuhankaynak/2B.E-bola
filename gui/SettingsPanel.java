import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.util.ArrayList; 
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class SettingsPanel extends JPanel
{
   Image image;
  public SettingsPanel()
  {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setPreferredSize(new Dimension(600, 600));
    try{
      image = ImageIO.read(new File("C:\\Users\\Deniz\\Desktop\\Proje\\Images\\bg.png"));
    }catch(IOException ex){System.out.println("not found");}
    add(Box.createRigidArea(new Dimension(0, 120)));
    addButton(PanelType.MUTE);
    addButton(PanelType.BACK);
  }
  protected void addButton(PanelType panelType){
  add(Box.createRigidArea(new Dimension(0, 25)));
  MenuButton button = new MenuButton(panelType);
  button.setAlignmentX(Component.CENTER_ALIGNMENT);
  add(button);
 }
  public void paintComponent(Graphics g)
  {
     g.drawImage(image, 0, 0, null);
  }
  
}