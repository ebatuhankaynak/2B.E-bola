/**
* @author  Batuhan Kaynak
* @version 1.2
* Created: 10/14/2017 
*/
package entityman;
import javax.imageio.ImageIO;
import java.net.URL;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import entity.*;
import engine.*;

public class EntityGenerator{
	
	private Entity[][][] entities;
	private EntityFactory entityFactory;
	
	private Celly celly;
	
	private ArrayList<Alive> aliveEntities;
	
	private	int roomCount = 3;							//HARDCODED
	
	private final int ROW = GameEngine.ROW;
	private final int COL = GameEngine.COL;
	
	public EntityGenerator(String[][] text){
		entityFactory = new EntityFactory();
		entities = new Entity[roomCount][ROW][COL];
		aliveEntities = new ArrayList<Alive>();
		generateEntities(text);
	}
	
	private void generateEntities(String[][] text){
		for(int i = 0; i < roomCount; i++){	
			for(int r = 0; r < ROW; r++){
				String row = text[i][r];
				for(int c = 0; c < COL; c++){
					Entity entity = entityFactory.createObject(row.charAt(c));
					entities[i][r][c] = entity; 	//change this (same with gamepanel)
					if(entity instanceof Alive){
						Alive alive = (Alive) entity;
						alive.setPoint(new Point(c * 60, r * 60)); 	//HARDCODED
						aliveEntities.add(alive);
					}
					/* 
					if(entity instanceof Celly){
						celly = (Celly) entity;
						celly.setPoint(new Point(c * 60, r * 60)); 	//HARDCODED
						System.out.println("Created Celly with " + celly.getPoint());
					} 
					*/
				}
			}
		}
	}
	
	public ArrayList<Alive> getAliveEntities(){
		return aliveEntities;
	}
	
	public Celly getCelly(){
		return celly;
	}
	
	public Entity[][][] getEntities(){
		return entities;
	}
}