/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 11/08/2017 
*/
package entity;

import gui.*;

public class Portal extends Interactable{

	private Room destination;
	
	private Lock lock;
	
	public Portal(){
		this.lock = null;
	}

	public Portal(Lock lock){
		this.lock = lock;
	}
	
	public void setDestination(Room destination){
		this.destination = destination;
	}
	
	public Room getDestination(){
		return destination;
	}
}