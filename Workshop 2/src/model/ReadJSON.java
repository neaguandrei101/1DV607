package model;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class  ReadJSON {
	
	public ReadJSON() {}

	public static BoatClub getBoatClubFromJsonFile(String readFileName)  {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(new File(readFileName), BoatClub.class);
		} catch (IOException e) {
			e.printStackTrace();
			return new BoatClub();
		}
	}
}
