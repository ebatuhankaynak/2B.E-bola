/**
* @author  Batuhan Kaynak
* @version 1.1
* Created: 10/14/2017 
*/
package gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import engine.*;

public class MapReader{
	
	//public static final String MAP_FOLDER_PATH = "";
	private final int ROW = GameEngine.ROW;
	private final int COL = GameEngine.COL;
	
	public String[][] rooms;
	public String[] portals;
	public String[] keys;
	
	public static int roomCount;
	
	public MapReader(){
		
		//Read save file to determine which level to load
		String level = "";
		try {
            File file = new File("save.txt");
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bf.readLine()) != null) {
				level = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		//Close reader??
		//No save file??
		
		String roomPath = "../Maps/" + level;
		roomCount = new File(roomPath).list().length;
		
		rooms = new String[roomCount][ROW];
		portals = new String[roomCount];
		keys = new String[roomCount];
		
		//Find the corresponding level folder and get all the rooms
		File file;
		BufferedReader bf;
		String line = "";
		for(int i = 0; i < roomCount; i++){
			try {
				file = new File(roomPath + "/R" + (i + 1) + ".txt");
				bf = new BufferedReader(new FileReader(file));
				int lineNum = 0;
				while (lineNum != ROW) { //(line = bf.readLine()) != null
					line = bf.readLine();
					rooms[i][lineNum] = line;
					lineNum++;
				}
				line = bf.readLine();
				portals[i] = line;
				
				line = bf.readLine();
				keys[i] = line;
				
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}