/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 11/07/2017 
*/
package entity;

import java.awt.Rectangle;

public class Alive extends Entity{
	private Point point;
	protected int movementSpeedModifier;
	private int hp;						//hp = HealthPoints
	
	private int velocityX;
	private int velocityY;
	
	public Alive(){
		super();
		//setEffectWindow(new Rectangle(point.getX(), point.getY(), RECT / 2, RECT / 2));
	}
	
	public void setVelocityX(int velocityX){
		this.velocityX = velocityX * movementSpeedModifier;
	}
	
	public void setVelocityY(int velocityY){
		this.velocityY = velocityY * movementSpeedModifier;
	}
	
	public int getVelocityX(){
		return velocityX;
	}
	
	public int getVelocityY(){
		return velocityY;
	}
	
	public void setPoint(Point point){
		this.point = point;
	}
	
	public Point getPoint(){
		return point;
	}
	
	public void setMovementSpeedModifier(int movementSpeedModifier){
		this.movementSpeedModifier = movementSpeedModifier;
	}
	
	public void setHp(int hp){
		this.hp = hp;
	}
	
	public int getMovementSpeedModifier(){
		return movementSpeedModifier;
	}
	
	public int getHp(){
		return hp;
	}
}