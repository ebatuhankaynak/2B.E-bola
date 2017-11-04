/**
* @author  Batuhan Kaynak
* @version 1.1
* Created: 10/14/2017 
*/
import javax.imageio.ImageIO;
import java.net.URL;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class EntityGenerator{
	
	private Entity[][][] entities;
	private EntityFactory entityFactory;
	
	private Celly celly;
	
	private	int roomCount = 3;							//HARDCODED
	
	private final int ROW = GameEngine.ROW;
	private final int COL = GameEngine.COL;
	
	public EntityGenerator(String[][] text){
		entityFactory = new EntityFactory();
		entities = new Entity[roomCount][ROW][COL];
		generateEntities(text);
	}
	
	private void generateEntities(String[][] text){
		for(int i = 0; i < roomCount; i++){	
			for(int r = 0; r < ROW; r++){
				String row = text[i][r];
				for(int c = 0; c < COL; c++){
					Entity entity = entityFactory.createObject(row.charAt(c));
					entities[i][r][c] = entity;
					if(entity instanceof Celly){
						celly = (Celly) entity;
						celly.setPoint(new Point(r * 60, c * 60)); 	//HARDCODED
						System.out.println("Created Celly with " + celly.getPoint());
					}
				}
			}
		}
	}
	
	public Celly getCelly(){
		return celly;
	}
	
	public Entity[][][] getEntities(){
		return entities;
	}
}