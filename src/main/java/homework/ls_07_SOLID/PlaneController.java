package homework.ls_07_SOLID;

public class PlaneController {

    private Plane plane;

    public PlaneController(Plane plane) {
        this.plane = plane;
    }

    public void goUp() {
        plane.goUp();
    }

    public void goDown() {
        plane.goDown();
    }

    public void goRight() {
        plane.goRight();
    }

    public void goLeft() {
        plane.goLeft();
    }

    public void startEngine() {
        plane.startEngine();
    }

    public void takeOff() {
        plane.takeOff();
    }

    public void landing() {
        plane.landing();
    }

}
