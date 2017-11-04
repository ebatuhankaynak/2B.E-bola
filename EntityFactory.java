/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 10/14/2017 
*/
public class EntityFactory{

	public Entity createObject(char c){
		switch(c){
			case 'T': return new Entity();
			case 'P': return new Celly();
			default:  return null;
		}
	}
}