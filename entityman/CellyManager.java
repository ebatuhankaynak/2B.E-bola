/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 11/03/2017 
*/
package entityman;

import java.awt.event.*;
import java.awt.Rectangle;
import java.util.ArrayList;

import entity.*;
import engine.*;

public class CellyManager{
	
	private Celly celly;
	private EntityManager entityManager;
	
	public CellyManager(EntityManager entityManager, Celly celly){
		this.entityManager = entityManager;
		this.celly = celly;
	}
	
	public void obtainItem(Interactable interactable){
		Inventory inventory = celly.getInventory();
		if(interactable instanceof Key){
			Key[] keys = inventory.getKeys();
			boolean success = false;
			for(Key key : keys){
				if(key == null){
					key = (Key)interactable;
					success = true;
					break;
				}
			}
			if(success){
				System.out.println("Key in inventory :)");
			}else{
				System.out.println("Key inventory full :(");
			}
		}
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
		}
	}
	
	public boolean checkInteraction(EffectWindow effectWindow){
		return effectWindow.contains(celly.getPoint());
	}
	
	/* public void checkHostile(ArrayList<Virus> viri){
		for(Virus v : viri){
			System.out.println(v);
			if(v.getEffectWindow().contains(celly.getPoint())){
				celly.setHp(celly.getHp() - 10);
				if(celly.getHp() == 0){
					GameEngine.gameOver = true;
				}
			}
		}
	} */
	
	public boolean checkIfValidMove(Point point){
		boolean withinMap = entityManager.checkCoordsWithinMap(point);
		//boolean noObstacle = checkNoObstacle(point);
		return withinMap;// && noObstacle;
	}
}
