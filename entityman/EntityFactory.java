/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 10/14/2017 
*/
package entityman;
import entity.*;
public class EntityFactory{

	public Entity createObject(char c){
		switch(c){
			case 'C': return new Celly();
			case 'T': return new Entity();
			//case 'R': return new RockTile();
			//case 'G': return new GrassTile();
			//case 'W': return new WaterTile();
			case 'P': return new Portal();
			//case 'O': return new OpenChest();
			//case 'L': return new LockedChest();
			case 'V': return new Virus();
			//case 'V': return new ChaserVirus();
			//case 'S': return new ShooterVirus();
			//case 'E': return new EbolaVirus();
			//case 'K': return new Key();
			default:  return null;
		}
	}
}
