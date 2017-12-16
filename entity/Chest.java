/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 12/02/2017 
*/
package entity;

public class Chest extends Interactable implements Lockable{
	
	private Lock lock;
	
	public Chest(){
		this.lock = null;
	}
	
	public Chest(Lock lock){
		this.lock = lock;
	}
	
	public void setKey(Key key){
		this.lock = new Lock();
		lock.setKey(key);
	}
	
	public Lock getLock(){
		return lock;
	}
}