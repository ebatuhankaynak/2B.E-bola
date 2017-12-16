/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 11/08/2017 
*/
package entityman;

import java.util.ArrayList;
import entity.*;
import java.util.Timer;
import java.util.TimerTask;

import engine.*;

public class VirusManager{

	private ArrayList<Virus> viri;
	private ArrayList<Alive> aliveEntities;
	private EntityManager entityManager;
	private Celly celly;
	
	public VirusManager(EntityManager entityManager, ArrayList<Virus> viri, Celly celly){
		this.entityManager = entityManager;
		this.viri = viri;
		this.celly = celly;
	}
	
	public void update(ArrayList<Virus> viri, ArrayList<Alive> aliveEntities){
		this.viri = viri;
		this.aliveEntities = aliveEntities;
		new Timer().schedule(new TimerTask(){
			public void run() {
				 ArrayList<Virus> junk = new ArrayList<Virus>();
				if(!GameEngine.pause){
					for(Virus v : viri){
						v.setHp(v.getHp() - 10);
						if(v.getHp() == 0){
							v.setHp(100);
							junk.remove(v);
						}
					}
				}
				viri.removeAll(junk);
			}
		}, 0, 500);
	}
	
	public void sampleRandomAction(){
		for(int i = 0; i < viri.size(); i++){
			chasePlayer(viri.get(i));
			final Virus v = viri.get(i);
			if(viri.get(i) instanceof Ebola){
				new Timer().schedule(new TimerTask(){
					public void run() {
						shootFireball((Ebola)v);
					}
				}, 0, 100000);
			}
		}
	}
	
	private void chasePlayer(Virus virus){
		Point cp = celly.getPoint();
		Point vp = virus.getPoint();
		int x = vp.getX();
		int y = vp.getY();
		int dX = x - cp.getX();
		int dY = y - cp.getY();
		
		if (dX > 0){
			virus.setVelocityX(-5);
		}else if (dX < 0){
			virus.setVelocityX(5);
		}else{
			virus.setVelocityX(0);
		}
		
		if (dY > 0){
			virus.setVelocityY(-5);
		}else if (dY < 0){
			virus.setVelocityY(5);
		}else{
			virus.setVelocityY(0);
		}
		
		if(virus.getVelocityX() != 0 && virus.getVelocityY() != 0){
			virus.setVelocityX((virus.getVelocityX() / 5) * 3);
			virus.setVelocityY((virus.getVelocityY() / 5) * 3);
		}
		virus.setPoint(new Point(vp.getX() + virus.getVelocityX(), vp.getY() + virus.getVelocityY()));
	}
	
	private void shootFireball(Ebola ebola){
		if(!GameEngine.pause){
			//Fireball fb = new Fireball();
			Virus virus = new Virus();
			//Point ep = ebola.getPoint();
			virus.setPoint(new Point((int) Math.ceil(Math.random() * 600), (int) Math.ceil(Math.random() * 600)));
			aliveEntities.add(virus);
			viri.add(virus);
		}
	}
	
	public ArrayList<Virus> getViri(){
		return viri;
	}
}


