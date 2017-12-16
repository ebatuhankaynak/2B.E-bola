/**
* @author  Batuhan Kaynak
* @version 1.1
* Created: 11/02/2017 
*/
package inputman;

import java.awt.event.*;

public class InputManager implements KeyListener{

	InputListener listener;
	
	private boolean leftPressed;
	private boolean rightPressed;
	private boolean upPressed;
	private boolean downPressed;
	
	private boolean[] keys;
	/*
	37 - Left
	38 - Up
	39 - Right
	40 - Down
	*/
	
	public InputManager(){
		keys = new boolean[4];
	}
	
	public void addListener(InputListener listener){
		this.listener = listener;
	}
	
	private void notify(boolean[] keys){
		listener.inputRecieved(keys);
	}
	
	public boolean[] getKeys(){
		return keys;
	}
	
	public void keyTyped(KeyEvent e) {
        return;
    }
    
    public void keyPressed(KeyEvent e) {
		changeKeys(e, true);
	} 
	
	public void keyReleased(KeyEvent e) {
		changeKeys(e, false);
    }
	
	private void changeKeys(KeyEvent e, boolean flag){
		int key = e.getKeyCode();
		if(key >= 37 && key <= 40){
			keys[key - 37] = flag;
		}
		notify(keys);
	}
}