/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 12/02/2017 
*/
package entity;

public class Lock{
	
	private Key key;
	
	public Lock(){
		this.key = null;
	}
	
	public Lock(Key key){
		this.key = key;
	}
	
	public void setKey(Key key){
		this.key = key;
	}
}