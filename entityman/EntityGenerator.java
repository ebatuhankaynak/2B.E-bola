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
import java.util.HashMap;

import entity.*;
import engine.*;

public class EntityGenerator{
	
	private Entity[][][] entities;
	private EntityFactory entityFactory;
	
	private Celly celly;
	
	private ArrayList<Alive> aliveEntities;
	private ArrayList<Interactable> interactableEntities;
	private HashMap<Portal, Integer> portalMap;
	
	private	int roomCount = 3;							//HARDCODED
	
	private final int ROW = GameEngine.ROW;
	private final int COL = GameEngine.COL;
	
	public EntityGenerator(String[][] text, String[] portalText){
		entityFactory = new EntityFactory();
		entities = new Entity[roomCount][ROW][COL];
		aliveEntities = new ArrayList<Alive>();
		interactableEntities = new ArrayList<Interactable>();
		portalMap = new HashMap<>();
		generateEntities(text, portalText);
	}
	
	private void generateEntities(String[][] text, String[] portalText){
		for(int i = 0; i < roomCount; i++){
			int portalCount = 0;
			for(int r = 0; r < ROW; r++){
				String row = text[i][r];
				for(int c = 0; c < COL; c++){
					Entity entity = entityFactory.createObject(row.charAt(c));
					entity.setPoint(new Point(c * 60, r * 60)); 	//HARDCODED
					entities[i][r][c] = entity; 	//change this (same with gamepanel)
					if(entity instanceof Alive){
						Alive alive = (Alive) entity;
						aliveEntities.add(alive);
					}else if (entity instanceof Portal){
						String ch = "" + portalText[i].charAt(portalCount);
						portalMap.put((Portal) entity, new Integer(Integer.parseInt(ch)));
						portalCount++;
						interactableEntities.add((Portal) entity);
					}
				}
			}
		}
	}
	
	public HashMap<Portal, Integer> getPortalMap(){
		return portalMap;
	}
	
	public ArrayList<Alive> getAliveEntities(){
		return aliveEntities;
	}
	
	public ArrayList<Interactable> getInteractableEntities(){
		return interactableEntities;
	}
	
	public Celly getCelly(){
		return celly;
	}
	
	public Entity[][][] getEntities(){
		return entities;
	}
}