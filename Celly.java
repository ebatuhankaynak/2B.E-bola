/**
* @author  Batuhan Kaynak
* @version 1.1
* Created: 10/14/2017 
*/
public class Celly extends Entity{
	private Point point;
	private int movementSpeedModifier;
	private int hp;						//hp = HealthPoints
	
	private int velocityX;
	private int velocityY;
	
	public Celly(){
		this.movementSpeedModifier = 1;
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