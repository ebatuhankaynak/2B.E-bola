/**
* @author  Batuhan Kaynak
* @version 1.1
* Created: 10/14/2017 
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapManager{
	
	//public static final String MAP_FOLDER_PATH = "";
	private final int ROW = GameEngine.ROW;
	private final int COL = GameEngine.COL;
	
	public String[][] rooms;
	
	public MapManager(){
		
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
		
		String roomPath = "Maps/" + level;
		int roomCount = 3; //HARDCODED
		
		rooms = new String[3][ROW];
		
		//Find the corresponding level folder and get all the rooms
		File file;
		BufferedReader bf;
		String line = "";
		for(int i = 0; i < roomCount; i++){
			try {
				file = new File(roomPath + "/R" + (i + 1) + ".txt");
				bf = new BufferedReader(new FileReader(file));
				int lineNum = 0;
				while ((line = bf.readLine()) != null) {
					rooms[i][lineNum] = line;
					lineNum++;
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}

		/*
		File levelDir = new File("Maps/" + level);
		if (levelDir.exists()){
			try {
				File file = new File("R1.txt");
				BufferedReader bf = new BufferedReader(new FileReader(file));
				String line = "";
				while ((line = bf.readLine()) != null) {
					System.out.println(line);
					level = line;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			//Missing game files
		}
		*/
	}
}