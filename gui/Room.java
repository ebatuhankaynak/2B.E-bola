/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 10/14/2017 
*/
package gui;

import java.util.ArrayList;

import entity.*;

public class Room{
	
	public Entity[][] entities;
	private ArrayList<Alive> aliveEntities;
	private ArrayList<Interactable> interactableEntities;
	
	public Room(Entity[][] entities){
		this.entities = entities;
		aliveEntities = new ArrayList<>();
		interactableEntities = new ArrayList<>();
		
		for(int r = 0; r < entities.length; r++){
			for(int c = 0; c < entities[r].length; c++){
				Entity entity = entities[r][c];
				if(entity instanceof Alive){
					aliveEntities.add((Alive) entity);
					System.out.println("Here I am!: " + (Alive) entity);
				}else if(entity instanceof Interactable){
					interactableEntities.add((Interactable) entity);
				}
			}
		}
			
	}
	
	public Celly findCelly(){
		Celly celly = null;
		for(Alive alive : aliveEntities){
			if(alive instanceof Celly){
				celly = (Celly) alive;
				break;
			}
		}
		return celly;
	}
	
	public ArrayList<Alive> getAliveEntities(){
		return aliveEntities;
	}
	
	public ArrayList<Interactable> getInteractableEntities(){
		return interactableEntities;
	}
	
	public Entity[][] getEntities(){
		return entities;
	}
}