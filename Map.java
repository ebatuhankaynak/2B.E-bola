/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 10/14/2017 
*/
public class Map{

	Room[] rooms;
	Room currentRoom;
	
	public Map(Entity[][][] entities){
		rooms = new Room[entities.length];
		for(int i = 0; i < entities.length; i++){
			rooms[i] = new Room(entities[i]);
		}
		currentRoom = rooms[0];
	}
}