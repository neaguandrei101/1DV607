package model;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RegistryHandler {
    public static BoatClub getBoatClubFromJsonFile(String relativePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(relativePath), BoatClub.class);
    }

    public static void saveBoatClubToJsonFile(String relativePath, BoatClub boatClub) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(relativePath), boatClub);
    }
}
