import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class task3 {

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try {
            JSONObject rootObject = (JSONObject) parser.parse(new FileReader(args[1]));
            JSONObject valuesJson = (JSONObject) parser.parse(new FileReader(args[0]));
            JSONArray testsArray = (JSONArray) rootObject.get("tests");
            JSONArray valuesArray = (JSONArray) valuesJson.get("values");

            updateValues(testsArray, valuesArray);

            try (FileWriter file = new FileWriter(args[2])) {
                file.write(rootObject.toJSONString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static void updateValues(JSONArray array, JSONArray valueArray) {
        for (Object obj : array) {
        	for(Object vobj : valueArray) {
        		if (obj instanceof JSONObject && vobj instanceof JSONObject) {
                    JSONObject jsonObject = (JSONObject) obj;
                    JSONObject vjsonObject = (JSONObject) vobj;
                    Long id = (Long) jsonObject.get("id");
                    Long vid = (Long) vjsonObject.get("id");
                    String newValue = (String) vjsonObject.get("value");
                    if (id.equals(vid)) {
                        jsonObject.put("value", newValue);
                    }
                }
        	}
        }
    }
}