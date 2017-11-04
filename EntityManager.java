/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 11/03/2017 
*/
public class EntityManager{

	private CellyManager cellyManager;
	
	public EntityManager(Celly celly){
		cellyManager = new CellyManager(celly);
	}
	
	public void evaluateInput(int pressState, int key){
		cellyManager.evaluateInput(pressState, key);
	}
	
	public void evaluateInput(boolean[] keys){
		cellyManager.evaluateInput(keys);
	}
	
	public void update(){
		cellyManager.update();
	}
}