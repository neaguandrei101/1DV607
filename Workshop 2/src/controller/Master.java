package controller;

import model.BoatClub;
import model.RegistryHandler;
import view.*;

import java.io.IOException;

public class Master {
    private IView view = new EnglishView();
    private BoatClub boatClub = new BoatClub();

    public void startMenu() {
        LanguageOptions choice = view.startMessage();
        switch (choice) {
            case ENGLISH:
                view = new EnglishView();
                menu();
                break;
            case SWEDISH:
                view = new SwedishView();
                menu();
                break;
        }
    }

    private void menu() {
        MenuOptions choice = view.printMenu();
        switch (choice) {
            case ADD_MEMBER:
                this.view.addMember(this.boatClub);
                menu();
                break;
            case CHANGE_MEMBER:
                this.view.changeMember(this.boatClub);
                menu();
                break;
            case REMOVE_MEMBER:
                this.view.removeMember(this.boatClub);
                menu();
                break;
            case LOOK_MEMBER:
                this.view.lookMember(this.boatClub);
                menu();
                break;
            case LIST_COMPACT:
                this.view.listCompact(this.boatClub);
                menu();
                break;
            case LIST_VERBOSE:
                this.view.listVerbose(this.boatClub);
                menu();
                break;
            case ADD_BOAT:
                this.view.addBoat(this.boatClub);
                menu();
                break;
            case CHANGE_BOAT:
                this.view.changeBoat(this.boatClub);
                menu();
                break;
            case REMOVE_BOAT:
                this.view.removeBoat(this.boatClub);
                menu();
                break;
            case READ_REGISTRY:
                readFromRegistry();
                menu();
                break;
            case EXIT:
                try {
                    RegistryHandler.saveBoatClubToJsonFile("LocalBoatClubRegistry.json", this.boatClub);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.exit(0);
                break;
        }
    }

    private void readFromRegistry() {
        try {
            this.boatClub = RegistryHandler.getBoatClubFromJsonFile("LocalBoatClubRegistry.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
