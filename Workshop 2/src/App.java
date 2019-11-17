import controller.Act;
import view.UI;

public class App {

    public static void main(String[] args) throws Exception {
        UI ui = new UI();
    	Act act = new Act(ui);
    	act.readChoice();
    }

}
