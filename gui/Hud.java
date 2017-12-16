package gui;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.*;

import entity.*;

public class Hud extends JPanel{
	
	private JLabel mitochondriaLabel = new JLabel();
	private JLabel ribosomeLabel = new JLabel();
	
	private JLabel hpLabel = new JLabel();
	private JLabel msLabel = new JLabel();
	
	private JLabel eventLabel = new JLabel();
	
	public Hud(){
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(200, 100));
		
		JPanel inventoryPanel = new JPanel();
		inventoryPanel.setPreferredSize(new Dimension(100, 100));
		inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.PAGE_AXIS));
		inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.PAGE_AXIS));
		inventoryPanel.add(new JLabel("Inventory"));
		inventoryPanel.add(new JLabel(" "));
		inventoryPanel.add(mitochondriaLabel);
		inventoryPanel.add(ribosomeLabel);
		add(inventoryPanel, BorderLayout.WEST);
		
		JPanel statusPanel = new JPanel();
		statusPanel.setPreferredSize(new Dimension(100, 100));
		statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.PAGE_AXIS));
		statusPanel.add(new JLabel("Status"));
		statusPanel.add(new JLabel(" "));
		statusPanel.add(hpLabel);
		statusPanel.add(msLabel);
		add(statusPanel, BorderLayout.CENTER);
		
		JPanel statusPanel = new JPanel();
		statusPanel.setPreferredSize(new Dimension(100, 100));
		statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.PAGE_AXIS));
		statusPanel.add(new JLabel("Events"));
		statusPanel.add(new JLabel(" "));
		statusPanel.add(eventLabel);
		add(statusPanel, BorderLayout.EAST);
	}
	
	public void update(Celly celly){
		mitochondriaLabel.setText("Mitochondria: " + celly.getInventory().getMitochondriaCount());
		ribosomeLabel.setText("Ribosome: " + celly.getInventory().getRibosomeCount());
		
		hpLabel.setText("Hp: " + celly.getHp());
		msLabel.setText("Movement: " + celly.getVelocityX());
	}
}