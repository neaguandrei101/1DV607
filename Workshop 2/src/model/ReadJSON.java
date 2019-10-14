package model;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

public class  ReadJSON {
	
	public ReadJSON() {}

	public static BoatClub getBoatClubFromJsonFile(String absolutePath)  {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Path path = Paths.get(absolutePath);
			return objectMapper.readValue(path.toFile(), BoatClub.class);
		} catch (IOException e) {
			e.printStackTrace();
			return new BoatClub();
		}
	}
}
