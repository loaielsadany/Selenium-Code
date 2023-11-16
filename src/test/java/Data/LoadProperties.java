package Data;

import org.apache.commons.io.FileUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

    public static Properties loadProperties(String path) throws IOException {

        Properties pro=new Properties();
        FileInputStream stream=new FileInputStream(path);
        pro.load(stream);
        return (pro);
    }

    public static Properties userData;

    static {
        try {
            userData = loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\Properties\\DataProperties");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
