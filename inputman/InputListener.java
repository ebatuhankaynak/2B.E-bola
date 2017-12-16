/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 11/02/2017 
*/
package inputman;

import java.awt.event.*;

public interface InputListener{
	void inputRecieved(boolean[] keys);
	void inputRecieved();
}