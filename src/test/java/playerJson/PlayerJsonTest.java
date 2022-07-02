package playerJson;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayerJsonTest {

	@Test
	void validateForeginPlayer() throws IOException, ParseException {
		String[] players = ReadPlayerJson.readJson();
		int expectedForeignPlayers = 4;
		int actualForeignPlayers = 0;
		for(int i=0; i<players.length; i++) {
			String[] pArray = players[i].split("-");
			if(!pArray[0].equals("India")) {
				actualForeignPlayers++;
			}
		}
		Assert.assertEquals(actualForeignPlayers, expectedForeignPlayers);
	}
	
	@Test
	void validateAtleastOneWicketKeeper() throws IOException, ParseException{
		String[] players = ReadPlayerJson.readJson();
		boolean wicketKeeper = false;
		for(int i=0; i<players.length; i++) {
			String[] pArray = players[i].split("-");
			if(pArray[1].equals("Wicket")) {
				wicketKeeper = true;
			}
		}
		
		
		Assert.assertTrue(wicketKeeper);
	}
	

	
}
