package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RegistryHandler {
	
	public RegistryHandler() {}

	public static BoatClub getBoatClubFromJsonFile(String relativePath)  {
		try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(relativePath), BoatClub.class);
		} catch (IOException e) {
			e.printStackTrace();
			return new BoatClub();
		}
	}

	public static void saveBoatClubToJsonFile(String relativePath, BoatClub boatClub) {
        try {
            Files.write(Paths.get(relativePath), boatClub.getJsonFileMembers());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
