package playerJson;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadPlayerJson {

	public static String[] readJson() throws IOException, ParseException {
		String baseDir = System.getProperty("user.dir");
		JSONParser jp = new JSONParser();
		FileReader fr = new FileReader(baseDir + "\\src\\test\\resources\\playerList.json");
		Object obj = jp.parse(fr);
		JSONObject playerJsonObj = (JSONObject) obj;
		JSONArray playerJsonArray = (JSONArray) playerJsonObj.get("player");
		String[] playersArray = new String[playerJsonArray.size()];
		for (int i = 0; i < playerJsonArray.size(); i++) {
			JSONObject players = (JSONObject) playerJsonArray.get(i);
			String country = (String) players.get("country");
			String role = (String) players.get("role");
			playersArray[i] = country + "-" + role;
		}

		return playersArray;

	}

}
