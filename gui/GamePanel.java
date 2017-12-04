/**
* @author  Batuhan Kaynak
* @version 1.2
* Created: 10/20/2017 
* todo: change Celly to Alive
*/
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import entity.*;
import engine.*;
import inputman.*;
import reader.*;

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
		
		public void draw(Graphics g, Entity entity, int x, int y){
			String className = entity.getClass().getSimpleName();
			Images enumVal = Images.valueOf(className);
			g.drawImage((BufferedImage)(images.get(enumVal)), x, y, this);
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
			
			ArrayList<Interactable> interactables = room.getInteractableEntities();
			
			for (int i = 0; i < interactables.size(); i++) {
				Interactable interactable = interactables.get(i);
				int x = interactable.getPoint().getX(); // 60.0 * rectWidth;
				int y = interactable.getPoint().getY(); // 60.0 * rectHeight;
				draw(g, interactable, x, y);
			}
			
			for (int i = 0; i < ROW; i++) {
				for (int j = 0; j < COL; j++) {
					int x = i * rectWidth;
					int y = j * rectHeight;
					
					//wat iz dis batu???
					Entity Entity = room.entities[i][j];
					if(!(Entity instanceof Alive) && !(Entity instanceof Alive)){
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
			
			ArrayList<Alive> alives = room.getAliveEntities();
			
			for (int i = 0; i < alives.size(); i++) {
					Alive alive = alives.get(i);
					int x = alive.getPoint().getX(); // 60.0 * rectWidth;
					int y = alive.getPoint().getY(); // 60.0 * rectHeight;
					draw(g, alive, x, y);
			}
		}
	}
}