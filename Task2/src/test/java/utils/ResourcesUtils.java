package utils;

import java.io.*;
import java.util.Properties;

public class ResourcesUtils {

    public static String getResources(String key) throws Exception {
            Properties props=new Properties();
            props.load(new InputStreamReader(new FileInputStream("src/test/java/resources/config.properties")));
            return props.getProperty(key);
        }
    }

