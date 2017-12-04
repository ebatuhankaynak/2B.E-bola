/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 11/08/2017 
*/
package entityman;
import java.util.ArrayList;
import entity.*;

public class VirusManager{

	private ArrayList<Virus> viri;
	private EntityManager entityManager;
	private Celly celly;
	
	public VirusManager(EntityManager entityManager, ArrayList<Virus> viri, Celly celly){
		this.entityManager = entityManager;
		this.viri = viri;
		this.celly = celly;
	}
	
	public void update(ArrayList<Virus> viri){
		this.viri = viri;
	}
	
	public void sampleRandomAction(){
		for(int i = 0; i < viri.size(); i++){
			chasePlayer(viri.get(i));
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
}