/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 11/03/2017 
*/
package entityman;

import java.awt.event.*;
import java.awt.Rectangle;

import entity.*;

public class CellyManager{
	
	private Celly celly;
	private EntityManager entityManager;
	
	public CellyManager(EntityManager entityManager, Celly celly){
		this.entityManager = entityManager;
		this.celly = celly;
	}
	
	public void update(){
		
	}
	
	/*
	37 - Left
	38 - Up
	39 - Right
	40 - Down
	*/
	
	//stuck when one axis is zero
	public void evaluateInput(boolean[] keys){
		if(keys[0]){
			celly.setVelocityX(-5);
		}else if(keys[2]){
			celly.setVelocityX(5);
		}else{
			celly.setVelocityX(0);
		}
		
		if(keys[1]){
			celly.setVelocityY(-5);
		}else if(keys[3]){
			celly.setVelocityY(5);
		}else{
			celly.setVelocityY(0);
		}
		
		Point cp = celly.getPoint();
		Point point = new Point(cp.getX() + celly.getVelocityX(), cp.getY() + celly.getVelocityY());

		if(checkIfValidMove(point)){
			celly.setPoint(point);
			//System.out.println(point);
		}
	}
	
	public boolean checkInteraction(EffectWindow effectWindow){
		return effectWindow.contains(celly.getPoint());
	}
	
	public void evaluateInput(int pressState, int key){
		if (pressState == 1){
			if (key == KeyEvent.VK_LEFT) {
				celly.setVelocityX(-5);
			}
			else if (key == KeyEvent.VK_RIGHT) {
				celly.setVelocityX(5);
			}
			else if (key == KeyEvent.VK_UP) {
				celly.setVelocityY(-5);
			}
			else if (key == KeyEvent.VK_DOWN) {
				celly.setVelocityY(5);
			}
			
		}else{
			if (key == KeyEvent.VK_LEFT) {
				celly.setVelocityX(0);
			}
			else if (key == KeyEvent.VK_RIGHT) {
				celly.setVelocityX(0);
			}
			else if (key == KeyEvent.VK_UP) {
				celly.setVelocityY(0);
			}
			else if (key == KeyEvent.VK_DOWN) {
				celly.setVelocityY(0);
			}
		}
		
		Point cp = celly.getPoint();
		Point point = new Point(cp.getX() + celly.getVelocityX(), cp.getY() + celly.getVelocityY());
		
		//Point point = calculateNewCoordinates(key);
		if(checkIfValidMove(point)){
			celly.setPoint(point);
			System.out.println(point);
		}
	}
	
	
	public boolean checkIfValidMove(Point point){
		boolean withinMap = entityManager.checkCoordsWithinMap(point);
		//boolean noObstacle = checkNoObstacle(point);
		return withinMap;// && noObstacle;
	}
	
	public Point calculateNewCoordinates(int keyCode){
		Point point = celly.getPoint();
		int x = point.getX();
		int y = point.getY();
		switch(keyCode) { 
			case KeyEvent.VK_UP:
				y--;
				break;
			case KeyEvent.VK_DOWN:
				y++;
				break;
			case KeyEvent.VK_LEFT:
				x--;
				break;
			case KeyEvent.VK_RIGHT :
				x = x + 5;
				break;
		 }
		 return new Point(x, y);
	}
}