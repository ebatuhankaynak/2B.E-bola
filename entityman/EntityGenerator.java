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
	
	private HashMap<Portal, Integer> portalMap;
	private HashMap<Key, int[]> keyMap;
	
	private	int roomCount = 3;							//HARDCODED
	
	private final int ROW = GameEngine.ROW;
	private final int COL = GameEngine.COL;
	
	public EntityGenerator(String[][] text, String[] portalText, String[] keyText){
		entityFactory = new EntityFactory();
		entities = new Entity[roomCount][ROW][COL];
		portalMap = new HashMap<>();
		keyMap = new HashMap<>();
		generateEntities(text, portalText, keyText);
	}
	
	private void generateEntities(String[][] text, String[] portalText, String[] keyText){
		for(int i = 0; i < roomCount; i++){
			int portalCount = 0;
			int keyCount = 0;
			
			String[] keysOfRoom = null;
			if(keyText[i] != null){
				keysOfRoom = keyText[i].split("/");
			}
			
			for(int r = 0; r < ROW; r++){
				String row = text[i][r];
				for(int c = 0; c < COL; c++){
					Entity entity = entityFactory.createObject(row.charAt(c));
					entity.setPoint(new Point(c * 60, r * 60)); 	//HARDCODED
					entities[i][r][c] = entity; 	//change this (same with gamepanel)
					if (entity instanceof Portal){
						String ch = "" + portalText[i].charAt(portalCount);
						portalMap.put((Portal) entity, new Integer(Integer.parseInt(ch)));
						portalCount++;
					}else if (entity instanceof Key){
						System.out.println(i);
						String str = keysOfRoom[keyCount];
						keyCount++;
						String[] numsStr = str.split("-");
						int roomNum = Integer.parseInt(numsStr[0]); 
						int order = Integer.parseInt(numsStr[1]);
						int[] nums = {roomNum, order};
						keyMap.put((Key) entity, nums);
					}
				}
			}
		}
	}
	
	public HashMap<Portal, Integer> getPortalMap(){
		return portalMap;
	}
	
	public HashMap<Key, int[]> getKeyMap(){
		return keyMap;
	}
	
	public Celly getCelly(){
		return celly;
	}
	
	public Entity[][][] getEntities(){
		return entities;
	}
}