package util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUltil {
	public static Properties readProoerties() {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Properties properties = new Properties();
		try {
			properties.load(classLoader.getResourceAsStream("/config/database.properties"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return properties;
	}
}
