/**
* @author  Batuhan Kaynak
* @version 1.1
* Created: 11/02/2017 
*/
import java.awt.event.*;

public class InputManager implements KeyListener{

	InputListener listener;
	
	public void addListener(InputListener listener){
		this.listener = listener;
	}
	
	private void notify(int pressState, int key){
		listener.inputRecieved(pressState, key);
	}
	
	public void keyTyped(KeyEvent e) {
        return;
    }
    
    public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		notify(1, key);
	} 
	
	public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
		notify(0, key);
    }
}