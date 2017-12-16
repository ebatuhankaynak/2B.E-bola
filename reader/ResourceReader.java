/**
* @author  Batuhan Kaynak
* @version 1.0
* Created: 10/20/2017 
*/
package reader;

import java.util.HashMap;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import javax.imageio.ImageIO;
import java.net.URL;
import java.io.IOException;

public class ResourceReader{
	
	HashMap<Images, BufferedImage> hashMap;
	
	public ResourceReader(){
		hashMap = new HashMap<>();
		File imagesDir = new File("../Images");
		System.out.println(imagesDir);
		
		String[] files = imagesDir.list();
		int pictureCount = files.length;
		
		for(Images i : Images.values()){
			hashMap.put(i, readImage(i.name()));
		}
		
	}
	
	private BufferedImage readImage(String className){
		URL resource = getClass().getResource("../Images/" + className + ".png");
        try {
            return ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
	}
	
	public HashMap getImages(){
		return hashMap;
	}
}