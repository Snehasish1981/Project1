package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readConfigproperties {
    Properties properties;
    String propertiesPath = "C:\\Users\\Snehashis\\IdeaProjects\\edurekaProject\\src\\test\\java\\properties\\Config.properties";

    public readConfigproperties() {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(propertiesPath);
            try {
                properties.load(fis);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
        public String getURL() {
            String url = properties.getProperty("url");
            if (url != null)
                return url;
            else
                throw new RuntimeException("Not found");
        }
    }

