/**
* @author  Batuhan Kaynak
* @version 1.2
* Created: 10/17/2017 
* inputmanager and panels and entity manager changed //reader not complete // point redundant
*/
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;

public class GameEngine implements InputListener{
	
	public static final int ROW = 10;
	public static final int COL = 10;
	public static final int PIXELS = 1;
	public static final int PIXEL_SCALE = 60;
	
	private EntityManager entityManager;
	private GamePanel gamePanel;
	
	private Map map;
	private ResourceReader resourceReader;
	
	private InputManager inputManager;
	private MapManager mapManager;
	private	EntityGenerator entityGenerator;
	
	public GameEngine(){
		mapManager = new MapManager();
		entityGenerator = new EntityGenerator(mapManager.rooms);
		map = new Map(entityGenerator.getEntities());
		
		resourceReader = new ResourceReader();
		entityManager = new EntityManager(entityGenerator.getCelly()); //TURN THIS INTO ALIVE
		
		inputManager = new InputManager();
		inputManager.addListener(this);
		gamePanel = new GamePanel(inputManager, map.currentRoom, resourceReader.getImages());
		gamePanel.requestFocus();
		
		new Timer().schedule(new TimerTask(){
			public void run() {
				entityManager.evaluateInput(inputManager.keys);
				gamePanel.update(map.currentRoom);
			}
		}, 0, 4);
	}
	
	public void inputRecieved(int pressState, int key){
		//check şf non celly button
		
		//entityManager.evaluateInput(pressState, key);
		//entityManager.evaluateInput(inputManager.keys);
		//gamePanel.update(map.currentRoom);
		//System.out.println("Input Recep: " + key);
	}
	
	public GamePanel getGamePanel(){
		return gamePanel;
	}
}