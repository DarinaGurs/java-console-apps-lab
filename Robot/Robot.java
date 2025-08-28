public class Robot {
    private int x;
    private int y;
    private Direction direction;

    // Конструктор класса Robot
    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    // Метод для получения текущего направления робота
    public Direction getDirection() {
        return direction;
    }

    // Метод для получения текущей координаты по оси X
    public int getX() {
        return x;
    }

    // Метод для получения текущей координаты по оси Y
    public int getY() {
        return y;
    }

    // Изменяем направление в зависимости от текущего направления робота
    public void turnLeft() {
        switch (direction) {
            case UP:
                direction = Direction.LEFT;
                break;
            case DOWN:
                direction = Direction.RIGHT;
                break;
            case LEFT:
                direction = Direction.DOWN;
                break;
            case RIGHT:
                direction = Direction.UP;
                break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case UP:
                direction = Direction.RIGHT;
                break;
            case DOWN:
                direction = Direction.LEFT;
                break;
            case LEFT:
                direction = Direction.UP;
                break;
            case RIGHT:
                direction = Direction.DOWN;
                break;
        }
    }
    public void stepForward() {
        switch (direction) {
            case UP:
                y++;
                break;
            case DOWN:
                y--;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
        }
    }

    public void moveRobot(int toX, int toY) {
        // Двигаемся по оси X
        while (x != toX) {
            if (x < toX) {
                // Если текущая координата X меньше, чем целевая, поворачиваем направо
                while (direction != Direction.RIGHT) {
                    turnRight();
                }
            } else {
                // Если текущая координата X больше, чем целевая, поворачиваем налево
                while (direction != Direction.LEFT) {
                    turnLeft();
                }
            }
            stepForward();
        }

        // Двигаемся по оси Y
        while (y != toY) {
            if (y < toY) {
                // Если текущая координата Y меньше, чем целевая, поворачиваем направо
                while (direction != Direction.UP) {
                    turnRight();
                }
            } else {
                // Если текущая координата Y больше, чем целевая, поворачиваем налево
                while (direction != Direction.DOWN) {
                    turnLeft();
                }
            }
            stepForward();
        }
    }
}
