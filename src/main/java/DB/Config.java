package DB;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    public static final String DB_URL = "db.url";
    public static final String DB_LOGIN = "db.login";
    public static final String DB_PASSWORD = "db.password";
    public static final String DB_LIMIT = "db.limit";

    private static Properties properties = new Properties();

    public static  String getProperty(String name){
        if(properties.isEmpty()){
            try(InputStream is = Config.class.getClassLoader().getResourceAsStream("db.properties")){
                properties.load(is);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
        return properties.getProperty(name);
    }
}
