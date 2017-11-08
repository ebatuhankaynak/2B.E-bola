/**
* @author  Batuhan Kaynak
* @version 1.1
* Created: 11/03/2017 
*/
package entityman;

import java.util.ArrayList;

import entity.*;
import engine.*;

public class EntityManager{

	private CellyManager cellyManager;
	private VirusManager virusManager;
	private Entity[][] entities;
	
	private final int ROW = GameEngine.ROW;
	private final int COL = GameEngine.COL;
	private final int PIXELS = GameEngine.PIXELS * GameEngine.PIXEL_SCALE;
	
	public EntityManager(Entity[][] entities, ArrayList<Alive> aliveEntities){
		this.entities = entities;
		Celly celly = null;
		ArrayList<Virus> viri = new ArrayList<Virus>();
		for(int i = 0; i < aliveEntities.size(); i++){
			if(aliveEntities.get(i) instanceof Celly){
				celly = (Celly) aliveEntities.get(i);
				aliveEntities.remove(i);
			}else{
				Virus virus = (Virus) aliveEntities.get(i);
				viri.add(virus);
			}
		}
		cellyManager = new CellyManager(this, celly);
		virusManager = new VirusManager(this, viri, celly);
	}
	
	public void runAI(){
		virusManager.sampleRandomAction();
	}

	public boolean checkCoordsWithinMap(Point point){
		int x = point.getX();
		int y = point.getY();
		return (y >= 0 && y <= ROW * PIXELS - 30 && x >= 0 && x <= COL * PIXELS - 30); //HARDCODED CELLY PIXEL
	}
	
	//thıs should be ın map manager*??? yews yes it is a table
	public boolean checkNoObstacle(Point point){
		//return !(entities[point.x][point.y] instanceof ObstacleTile);
		return true;							//!!!HARDCODED!!!
	}
	
	public void evaluateInput(int pressState, int key){
		cellyManager.evaluateInput(pressState, key);
	}
	
	public void evaluateInput(boolean[] keys){
		cellyManager.evaluateInput(keys);
	}
	
	public void update(){
		cellyManager.update();
	}
}