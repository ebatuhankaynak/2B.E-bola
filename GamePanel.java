/**
* @author  Batuhan Kaynak
* @version 1.2
* Created: 10/20/2017 
* todo: change Celly to Alive
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JLayeredPane{
	
	private final int ROW = GameEngine.ROW;
	private final int COL = GameEngine.COL;
	private final int PIXELS = GameEngine.PIXELS * GameEngine.PIXEL_SCALE;
	
	DynamicPanel dynamicPanel;
	StaticPanel staticPanel;
	
	public GamePanel(InputManager inputManager, Room room, HashMap images){
		int width = COL * PIXELS;
        int height = ROW * PIXELS;
		System.out.println(width + "-" + height);
        setPreferredSize(new Dimension(width, height));
		
		dynamicPanel = new DynamicPanel(room, images);
		dynamicPanel.setBounds(0, 0, width, height);
		dynamicPanel.addKeyListener(inputManager);
		dynamicPanel.setFocusable(true);
		
		add(dynamicPanel, new Integer(0));
		
		staticPanel = new StaticPanel(room, images);
		staticPanel.setBounds(0, 0, width, height);
		
		add(staticPanel, new Integer(-1));
	}
	
	public void requestFocus(){
		dynamicPanel.requestFocusInWindow();
	}
	
	public void update(Room room){
		dynamicPanel.update(room);
		staticPanel.update(room);
		
		
		
		dynamicPanel.requestFocusInWindow();
	}
	
	private abstract class Layer extends JPanel{
		protected Room room;
		protected HashMap images;
		
		public Layer(Room room, HashMap images){
			this.room = room;
			this.images = images;
			this.setOpaque(false);
		}
		
		public void update(Room room){
			this.room = room;
			revalidate();
			repaint();
		}
	}
	
	private class StaticPanel extends Layer{
		public StaticPanel(Room room, HashMap images){
			super(room, images);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int rectWidth = getWidth() / COL;
			int rectHeight = getHeight() / ROW;
			
			for (int i = 0; i < ROW; i++) {
				for (int j = 0; j < COL; j++) {
					int x = i * rectWidth;
					int y = j * rectHeight;
					
					Entity Entity = room.entities[i][j];
					if(!(Entity instanceof Alive)){
						String className = Entity.getClass().getSimpleName();
						Images enumVal = Images.valueOf(className);
						g.drawImage((BufferedImage)(images.get(enumVal)), x, y, this);
					}else{
						Entity = new Entity();
						String className = Entity.getClass().getSimpleName();
						Images enumVal = Images.valueOf(className);
						g.drawImage((BufferedImage)(images.get(enumVal)), x, y, this);
					}
				}
			}
		}
	}
	
	private class DynamicPanel extends Layer{
		public DynamicPanel(Room room, HashMap images){
			super(room, images);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int rectWidth = getWidth() / COL;
			int rectHeight = getHeight() / ROW;
			
			for (int i = 0; i < ROW; i++) {
				for (int j = 0; j < COL; j++) {
					Entity entity = room.entities[i][j];
					if(entity instanceof Alive){
						int x = ((Alive) entity).getPoint().getX(); // 60.0 * rectWidth;
						int y = ((Alive) entity).getPoint().getY(); // 60.0 * rectHeight;
						String className = entity.getClass().getSimpleName();
						Images enumVal = Images.valueOf(className);
						g.drawImage((BufferedImage)(images.get(enumVal)), x, y, this);
					}
				}
			}
		}
	}
}