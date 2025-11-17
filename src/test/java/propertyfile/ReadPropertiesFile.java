package propertyfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
   private Properties properties ;
    public ReadPropertiesFile () throws IOException {
        properties = new Properties ();
        String filepath = System.getProperty("user.dir") + "\\data\\config.properties";
        FileInputStream file = new FileInputStream (filepath);
        properties.load (file);
        file.close();
    }
    public String getvalue (String key)
    {
       return properties.getProperty(key);
    }
}
