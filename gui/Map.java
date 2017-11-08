/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 10/14/2017 
*/
package gui;

import entity.*;

public class Map{

	private Room[] rooms;
	private Room currentRoom;
	
	public Map(Entity[][][] entities){
		rooms = new Room[entities.length];
		for(int i = 0; i < entities.length; i++){
			rooms[i] = new Room(entities[i]);
		}
		currentRoom = rooms[0];
	}
	
	public Room getCurrentRoom(){
		return currentRoom;
	}
}