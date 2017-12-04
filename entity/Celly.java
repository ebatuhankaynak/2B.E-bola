/**
* @author  Batuhan Kaynak
* @version 1.1
* Created: 10/14/2017 
*/
package entity;
public class Celly extends Alive{
	
	private Inventory inventory;
	
	public Celly(){
		this.movementSpeedModifier = 1;
		this.inventory = new Inventory();
	}
}