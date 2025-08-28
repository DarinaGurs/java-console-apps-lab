public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot(0, 0, Direction.UP);
        robot.moveRobot(0, 3);
        System.out.println("Robot position: (" + robot.getX() + ", " + robot.getY() + ")");
        System.out.println("Robot direction: " + robot.getDirection());
    }
}