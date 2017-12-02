/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 10/14/2017 
*/
package gui;

import java.util.HashMap;

import entity.*;

public class Map{

	private Room[] rooms;
	private Room currentRoom;
	
	public Map(Entity[][][] entities, HashMap<Portal, Integer> portalMap){
		rooms = new Room[entities.length];
		for(int i = 0; i < entities.length; i++){
			System.out.println(i);
			rooms[i] = new Room(entities[i]);
		}
		currentRoom = rooms[0];
		for(Portal p : portalMap.keySet()){
			p.setDestination(rooms[(int)(portalMap.get(p)) - 1]);
		}
	}
	
	public void setCurrentRoom(Room room){
		Celly celly = currentRoom.findCelly();
		room.getAliveEntities().add(celly);
		currentRoom.getAliveEntities().remove(celly);
		this.currentRoom = room;
	}
	
	public Room getCurrentRoom(){
		return currentRoom;
	}
}