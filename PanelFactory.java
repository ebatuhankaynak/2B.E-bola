/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 10/20/2017 
*/
import javax.swing.*;

public class PanelFactory{

	public PanelFactory(){
		
	}
	
	public JComponent createPanel(PanelType panelType){
		switch(panelType){
			//case PLAY: 			return new GamePanel();
			case SETTINGS : 	return new JPanel();
			default:			return new JPanel();
		}
	}
}