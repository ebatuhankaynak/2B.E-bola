/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 10/20/2017 
*/
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.util.ArrayList;

public class MenuPanel extends JPanel{
	
	ArrayList<MenuButton> menuButtons;
	
	public MenuPanel(){
		menuButtons = new ArrayList<>();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.GREEN);	
		setPreferredSize(new Dimension(600, 600));
		
		addButton("Play", PanelType.PLAY);
		addButton("Settings", PanelType.SETTINGS);
	}
	
	public ArrayList<MenuButton> getButtons(){
		return menuButtons;
	}
	
	private void addButton(String text, PanelType panelType){
		add(Box.createRigidArea(new Dimension(0, 10)));
		
		MenuButton button = new MenuButton(text, panelType);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		menuButtons.add(button);
		add(button);
	}
}