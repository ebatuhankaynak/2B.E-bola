/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 10/20/2017 
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuButton extends JButton implements ActionListener{

	MenuButtonListener listener;
	PanelType panelType;
	
	public MenuButton(String text, PanelType panelType){
		super(text);
		this.panelType = panelType;
		addActionListener(this);
		//setPreferredSize(new Dimension(200, 120));
	}
	
	public void registerListener(MenuButtonListener mp){
		listener = mp;
	}
	
	public void actionPerformed(ActionEvent e) {
		listener.onMenuButtonClick(panelType);
	}
}