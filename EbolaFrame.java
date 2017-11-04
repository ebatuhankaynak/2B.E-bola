/**
* @author  Batuhan Kaynak
* @version 1.1
* Created: 10/20/2017 
*/
import javax.swing.*;
import java.util.ArrayList;

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
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void onMenuButtonClick(PanelType panelType){
		JComponent panel = panelFactory.createPanel(panelType);
		if(panelType == PanelType.PLAY){
			//GameEngine gameEngine = new GameEngine((GamePanel)panel);
			GameEngine gameEngine = new GameEngine();
			panel = gameEngine.getGamePanel();
		}
		setContentPane(panel);
		revalidate();
		repaint();
	}
}