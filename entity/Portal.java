/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 11/08/2017 
*/
package entity;

import gui.*;

public class Portal extends Interactable{

	private Room destination;
	
	public void setDestination(Room destination){
		this.destination = destination;
	}
	
	public Room getDestination(){
		return destination;
	}
}