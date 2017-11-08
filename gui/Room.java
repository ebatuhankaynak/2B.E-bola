/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 10/14/2017 
*/
package gui;

import entity.*;

public class Room{

	Entity[][] entities;
	
	public Room(Entity[][] entities){
		this.entities = entities;	
		System.out.println();
			
	}
	
	public Entity[][] getEntities(){
		return entities;
	}
}