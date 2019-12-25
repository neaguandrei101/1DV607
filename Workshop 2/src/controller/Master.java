package controller;

import model.BoatClub;
import model.RegistryHandler;
import view.*;

import java.io.IOException;

public class Master {
    IView view = new EnglishView();
    BoatClub boatClub = new BoatClub();

    public void startMenu() {
        MenuLanguage choice = view.startMessage();
        switch (choice) {
            case ENGLISH:
                view = new EnglishView();
                viewMenu();
                break;
            case SWEDISH:
                view = new SwedishView();
                viewMenu();
                break;
        }
    }

    private void viewMenu() {
        Menu choice = view.printMenu();
        switch (choice) {
            case ADD_MEMBER:
                this.view.addMember(this.boatClub);
                viewMenu();
                break;
            case CHANGE_MEMBER:
                this.view.changeMember(this.boatClub);
                viewMenu();
                break;
            case REMOVE_MEMBER:
                this.view.removeMember(this.boatClub);
                viewMenu();
                break;
            case LOOK_MEMBER:
                this.view.lookMember(this.boatClub);
                viewMenu();
                break;
            case LIST_COMPACT:
                this.view.listCompact(this.boatClub);
                viewMenu();
                break;
            case LIST_VERBOSE:
                this.view.listVerbose(this.boatClub);
                viewMenu();
                break;
            case ADD_BOAT:
                this.view.addBoat(this.boatClub);
                viewMenu();
                break;
            case CHANGE_BOAT:
                this.view.changeBoat(this.boatClub);
                viewMenu();
                break;
            case REMOVE_BOAT:
                this.view.removeBoat(this.boatClub);
                viewMenu();
                break;
            case READ_REGISTRY:
                readFromRegistry();
                viewMenu();
                break;
            default:
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
