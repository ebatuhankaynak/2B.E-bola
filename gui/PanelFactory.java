/**
@version 1.0
* Created: 10/20/2017 
*/
package gui;

import javax.swing.*;

public class PanelFactory{
	
	public JComponent createPanel(PanelType panelType){
		switch(panelType){
			//case PLAY: 			return new GamePanel();
			case SETTINGS : 	return new SettingsPanel();
			case EXIT :  		System.exit(0);
			default:		return new JPanel();
		}
	}
}
