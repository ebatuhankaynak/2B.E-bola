/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 10/14/2017 
*/
public class EntityFactory{

	public Entity createObject(char c){
		switch(c){
			case 'T': return new Entity();
			case 'C': return new Celly();
			case 'V': return new Virus();
			case 'P': return new Portal();
			default:  return null;
		}
	}
}