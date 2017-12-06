package entity;

public class Inventory{
	private Key[] keys;
	
	public Inventory(){
		keys = new Key[2];
	}
	
	public Key[] getKeys(){
		return keys;
	}
}