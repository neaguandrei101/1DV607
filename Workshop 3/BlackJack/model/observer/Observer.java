package BlackJack.model.observer;

import java.util.ArrayList;

public abstract class Observer {
    private ArrayList<Observer_IO> obs = new ArrayList<Observer_IO>();

    public void addGameObserver(Observer_IO gameObserver){
        obs.add(gameObserver);
    }

    public void check_Observer(){
        for(int i = 0; i< obs.size(); i++){
            obs.get(i).send_To_Observer();
        }
    }
}