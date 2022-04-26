package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
private Properties prop;
	
	/**
	 * This Method is used to load the properties from config.properties file
	 * @return Properties Object
	 */
	
	public Properties init_prop(String filePath){
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop.load(fis);
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}catch(IOException ie) {
			ie.printStackTrace();
		}
		
		return prop;
	}

}
