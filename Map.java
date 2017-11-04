/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 10/14/2017 
*/
public class Map{

	Room[] rooms;
	Room currentRoom;
	
	public Map(Entity[][][] Entitys){
		rooms = new Room[Entitys.length];
		for(int i = 0; i < Entitys.length; i++){
			rooms[i] = new Room(Entitys[i]);
		}
		currentRoom = rooms[0];
	}
}