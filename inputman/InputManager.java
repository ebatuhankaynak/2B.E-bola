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
	
	private void notify(int pressState, int key){
		listener.inputRecieved(pressState, key);
	}
	
	public boolean[] getKeys(){
		return keys;
	}
	
	public void keyTyped(KeyEvent e) {
        return;
    }
    
    public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println("Input Recep: " + key);
		if(key >= 37 && key <= 40){
			keys[key - 37] = true;
		}
		/*
		if (key == KeyEvent.VK_LEFT) {
			leftPressed = true;
		}
		else if (key == KeyEvent.VK_RIGHT) {
			rightPressed = true;
		}
		else if (key == KeyEvent.VK_UP) {
			upPressed = true;
		}
		else if (key == KeyEvent.VK_DOWN) {
			downPressed = true;
		}
		*/
		notify(1, key);
	} 
	
	public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
		if(key >= 37 && key <= 40){
			keys[key - 37] = false;
		}
		/*
		if (key == KeyEvent.VK_LEFT) {
			leftPressed = true;
		}
		else if (key == KeyEvent.VK_RIGHT) {
			rightPressed = true;
		}
		else if (key == KeyEvent.VK_UP) {
			upPressed = true;
		}
		else if (key == KeyEvent.VK_DOWN) {
			downPressed = true;
		}
		*/
		notify(0, key);
    }
}