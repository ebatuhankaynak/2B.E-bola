/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 10/14/2017 
*/
package gui;

import java.util.HashMap;
import java.util.ArrayList;

import entity.*;

public class Map{

	private Room[] rooms;
	private Room currentRoom;
	
	public Map(Entity[][][] entities, HashMap<Portal, Integer> portalMap, HashMap<Key, int[]> keyMap){
		rooms = new Room[entities.length];
		for(int i = 0; i < entities.length; i++){
			System.out.println(i);
			rooms[i] = new Room(entities[i]);
		}
		currentRoom = rooms[0];
		for(Portal p : portalMap.keySet()){
			p.setDestination(rooms[(int)(portalMap.get(p)) - 1]);
		}
		for(Key k : keyMap.keySet()){
			int roomNum = keyMap.get(k)[0];
			int order = keyMap.get(k)[1];
			
			ArrayList<Chest> chests = rooms[roomNum - 1].getChests();
			System.out.println(chests.get(order - 1));
			chests.get(order - 1).setKey(k);
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