/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 10/14/2017 
*/
package entity;

import java.awt.image.BufferedImage;

import engine.*;

public class Entity{
	
	private BufferedImage image;
	private EffectWindow effectWindow;
	private Point point;
	
	public final int RECT = GameEngine.PIXELS * GameEngine.PIXEL_SCALE;
	
	public Entity(){
		
	}
	
	public void setPoint(Point point){
		this.point = point;
		this.effectWindow = new EffectWindow(point.getX(), point.getY(), RECT);
	}
	
	public Point getPoint(){
		return point;
	}
	
	public EffectWindow getEffectWindow(){
		return effectWindow;
	}
	
	public void setEffectWindow(EffectWindow effectWindow){
		this.effectWindow = effectWindow;
	}
	
	public void setImage(BufferedImage image){
		this.image = image;
	}
	
	public BufferedImage getImage(){
		return image;
	}
	
	@Override
	public String toString(){
		return this.getClass().getSimpleName();
	}
}