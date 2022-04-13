package test2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonEx {
    public static void main(String[] args) throws Exception {

        toJsonFile("c:\\result2.json");
        JSONObject obj = fromFileJSON("c:\\result2.json");
        System.out.println(obj.toJSONString());
        System.out.println(obj.get("price1"));
    }

    public static void toJsonFile(String nameFile) throws IOException {
        JSONObject obj = new JSONObject();
        obj.put("name", "crunchy.com");
        obj.put("author", "Kim");
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("EBay");
        jsonArray.add("Google");
        jsonArray.add("Amazone");
        obj.put("Companys", jsonArray);
        obj.put("price1", 100);

        try (FileWriter file = new FileWriter(new File(nameFile))) {
            file.write(obj.toJSONString());
            // System.out.println(obj.toJSONString());
        }
    }

    public static JSONObject fromFileJSON(String nameFile) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader file = new FileReader(new File(nameFile));
        Object obj = parser.parse(file);

        return (JSONObject) obj;
    }
}
