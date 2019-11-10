package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RegistryHandler {
	public static BoatClub getBoatClubFromJsonFile(String relativePath)  throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(relativePath), BoatClub.class);
    }

	public static void saveBoatClubToJsonFile(String relativePath, BoatClub boatClub) throws IOException{
        Files.write(Paths.get(relativePath), boatClub.getJsonFileMembers());
    }
}
