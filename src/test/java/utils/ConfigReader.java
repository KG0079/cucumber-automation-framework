package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties;

	public static void loadConfig() {
		String environment = System.getProperty("env", "qa");

		String filePath = "src/test/resources/config/config-" + environment + "properties";
		properties = new Properties();
	}

	static {

		try {

			FileInputStream file = new FileInputStream("src/test/resources/config/config.properties");

			properties.load(file);

		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public static String getProperty(String key) {

		String systemProperty = System.getProperty(key);

		if (systemProperty != null) {
			return systemProperty;
		}

		return properties.getProperty(key);
	}
}