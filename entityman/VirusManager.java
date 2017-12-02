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
	
	//Use velocity
	private void chasePlayer(Virus virus){
		Point cp = celly.getPoint();
		Point vp = virus.getPoint();
		int x = vp.getX();
		int y = vp.getY();
		int dX = x - cp.getX();
		int dY = y - cp.getY();
		
		int newX = x;
		Point p = null;
		if (dX > 0){
			p = new Point(x - 1, y);
			newX = x - 1;
		}else if (dX < 0){
			p = new Point(x + 1, y);
			newX = x + 1;
		}
		
		if (dY > 0){
			p = new Point(newX, y - 1);
		}else if (dY < 0){
			p = new Point(newX, y + 1);
		}
		virus.setPoint(p);
	}
	
}