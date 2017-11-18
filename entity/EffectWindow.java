/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 11/16/2017 
*/

package entity;

public class EffectWindow{
	
	private int x;
	private int y;
	private int length;
	
	public EffectWindow(int x, int y, int length){
		this.x = x;
		this.y = y;
		this.length = length;
	}
	
	public boolean contains(Point point){
		int xp = point.getY(); //WOW THIS IS SO DANGEROUS I CANT EVEN
		int yp = point.getX();
		
		//System.out.println(x + "-" + y + "*-*" + xp + "---" + yp);
		
		//System.out.println((xp >= x && xp <= x + length) + "---" + (yp >= y && yp <= y + length));
		return (xp >= x && xp <= x + length) && (yp >= y && yp <= y + length);
	}
}