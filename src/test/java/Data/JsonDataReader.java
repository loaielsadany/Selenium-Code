package Data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {

    public String firstName;
    public String lastName;
    public String email;
    public String password;

    public void JasonReader() throws IOException, ParseException {

        String path= System.getProperty("user.dir")+"\\src\\test\\java\\Data\\UserData.Json";
        File src=new File(path);
        JSONParser parser=new JSONParser();
        JSONArray array= (JSONArray) parser.parse(new FileReader(src));
        for(Object jsonOb:array){
            JSONObject person= (JSONObject) jsonOb;
            firstName= (String) person.get("firstName");
            System.out.println(firstName);
            lastName= (String) person.get("lastName");
            System.out.println(lastName);
            email= (String) person.get("email");
            System.out.println(email);
            password= (String) person.get("password");
            System.out.println(password);



        }

    }

}
