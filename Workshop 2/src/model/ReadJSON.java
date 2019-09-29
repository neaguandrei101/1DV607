package model;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJSON {
	
	public ReadJSON() {}

	public BoatClub getBoatClubFromJsonFile(String readFileName)  {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(new File(readFileName), BoatClub.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
			return new BoatClub();
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return new BoatClub();
		} catch (IOException e) {
			e.printStackTrace();
			return new BoatClub();

		}
	}
}
