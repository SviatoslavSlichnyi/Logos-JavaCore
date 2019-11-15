package homework.ls_07_SOLID;

public class Main {

    public static void main(String[] args) {

        Su27 su27 = new Su27(300, 100, 40, 400);
        PlaneController planeController = new PlaneController(su27);

        planeController.startEngine();

        planeController.takeOff();

        planeController.goUp();

        planeController.goDown();

        planeController.goLeft();

        planeController.goDown();

        su27.stealth();

        su27.nuclearAttack();

        su27.turbo();

        planeController.landing();

    }

}
