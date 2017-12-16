/**
* @author  Batuhan Kaynak
* @version 1.1
* Created: 10/20/2017 
*/
package gui;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.*;

import engine.*;

public class EbolaFrame extends JFrame implements MenuButtonListener{
	
	PanelFactory panelFactory;
	
	public EbolaFrame(){
		panelFactory = new PanelFactory();
		MenuPanel menuPanel = new MenuPanel();
		ArrayList<MenuButton> menuButtons = new ArrayList<>();
		menuButtons = menuPanel.getButtons();
		
		for(MenuButton menuButton : menuButtons){
			menuButton.registerListener(this);
		}
		
		setContentPane(menuPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setMinimumSize(new Dimension(600, 800));
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void onMenuButtonClick(PanelType panelType){
		JComponent panel = panelFactory.createPanel(panelType);
		if(panelType == PanelType.PLAY){
			//GameEngine gameEngine = new GameEngine((GamePanel)panel);
			GameEngine gameEngine = new GameEngine();
			panel = gameEngine.getGamePanel();
			panel = new GameWithHud((GamePanel)panel);
		}
		setContentPane(panel);
		revalidate();
		repaint();
	}
	
	private class GameWithHud extends JPanel{
		
		public GameWithHud(GamePanel gamePanel){
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			add(gamePanel);
			add(new Hud());
		}
		private class Hud extends JPanel{
		
			public Hud(){
				setPreferredSize(new Dimension(200, 100));
				add(new JLabel("SA"));
			}
		}
	}
	
}