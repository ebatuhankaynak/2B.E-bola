/**
* @author  Batuhan Kaynak
* @version 1.2
* Created: 10/17/2017 
* inputmanager and panels and entity manager changed //reader not complete // point redundant
*/
package engine;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;
import java.util.ArrayList;

import entityman.*;
import gui.*;
import inputman.*;
import reader.*;
import entity.*;
import soundman.*;

public class GameEngine implements InputListener, EntityEventListener{
	
	public static final int ROW = 10;
	public static final int COL = 10;
	public static final int PIXELS = 1;
	public static final int PIXEL_SCALE = 60;
	
	private EntityManager entityManager;
	private GamePanel gamePanel;
	private Hud hud;
	
	private Map map;
	private ResourceReader resourceReader;
	
	private InputManager inputManager;
	private MapReader mapReader;
	private	EntityGenerator entityGenerator;
	
	public GameEngine(){
		mapReader = new MapReader();
		entityGenerator = new EntityGenerator(mapReader.rooms, mapReader.portals, mapReader.keys);
		
		map = new Map(entityGenerator.getEntities(), entityGenerator.getPortalMap(), entityGenerator.getKeyMap());
		
		resourceReader = new ResourceReader();
		
		Room currentRoom = map.getCurrentRoom();
		
		entityManager = new EntityManager(currentRoom.getEntities(), 
							currentRoom.getAliveEntities(), currentRoom.getInteractableEntities());
		entityManager.addListener(this);
		
		inputManager = new InputManager();
		inputManager.addListener(this);
		
		SoundManager soundManager = new SoundManager();
		soundManager.playSound("audio1.wav");
		
		gamePanel = new GamePanel(inputManager, map.getCurrentRoom(), resourceReader.getImages());
		gamePanel.requestFocus();
		
		hud = new Hud();
		
		new Timer().schedule(new TimerTask(){
			public void run() {
				entityManager.evaluateInput(inputManager.getKeys());
				entityManager.runAI();
				gamePanel.update(map.getCurrentRoom());
				hud.update(entityManager.getCelly());
			}
		}, 0, 40);
		/* new Timer().schedule(new TimerTask(){
			public void run() {
				entityManager.damageAI();
			}
		}, 0, 500); */
	}
	
	public void onEntityEvent(Interactable interactable){
		if(interactable instanceof Portal){
			Portal portal = (Portal) interactable;
			Room room = portal.getDestination();
			map.setCurrentRoom(room);
			entityManager.update(room.getEntities(), room.getAliveEntities(), room.getInteractableEntities());
			//gamePanel.update(room);
		}else if(interactable instanceof Key){
			entityManager.obtainItem(interactable);
			map.replace(interactable);
		}
		else if(interactable instanceof Chest){
			//entityManager.obtainItem(interactable);
			map.replace(interactable);
		}
	}
	
	public Hud getHud(){
		return hud;
	}
	
	public void inputRecieved(boolean[] keys){
		//entityManager.evaluateInput(keys);
	}
	
	public GamePanel getGamePanel(){
		return gamePanel;
	}
}