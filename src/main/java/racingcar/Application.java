package racingcar;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);

        try {
            controller.startRace();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}