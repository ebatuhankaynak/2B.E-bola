package entity;

public class Inventory{
	
	
	
	private Key[] keys;
	private int mitochondriaCount;
	private int ribosomeCount;
	
	public Inventory(){
		keys = new Key[2];
		mitochondriaCount = 0;
		ribosomeCount = 0;
	}
	
	public Key[] getKeys(){
		return keys;
	}
	
	public int getMitochondriaCount(){
		return mitochondriaCount;
	}
	
	public int getRibosomeCount(){
		return ribosomeCount;
	}
}