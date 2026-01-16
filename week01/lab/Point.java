package week01.lab;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) { // int x & int y are the parameters
        this.x = x; // this.x refers to the instance variable, not the parameter
        this.y = y;
    }

    public int quadrant() {
        if (x > 0 && y > 0) {
            return 1;
        }
        else if (x < 0 && y > 0) {
            return 2;
        }
        else if (x < 0 && y < 0) {
            return 3;
        }
        else {
            return 4;
        }
    }

    public void flip() { // negates & swaps x/y values e.g. (5, -3) -> (3, -5) & (4, 17) -> (-17, -4)
        int temp = x;
        x = -y;
        y = -temp;
    }

    public int manhattanDistance(Point other) {
        return Math.abs(x - other.x) + Math.abs(y - other.y); // |x1 - x2| + |y1 - y2|
    }

    public boolean isVertical(Point other) { // checks if x values are equal i.e. line is vertical
        return x == other.x;
    }

    public double slope(Point other) {
        if (isVertical(other)) { // checks if line is vertical first
            throw new IllegalArgumentException();
        }
        double slope = (y - other.y) / (x - other.x); // (y2 - y1) / (x2 - x1)
        return Math.round(slope * 10000.0) / 10000.0; // rounds to 4 decimal places
    }

    public boolean isCollinear(Point p1, Point p2) {
        if (x == p1.x && x == p2.x) {
            return true;
        }
        
        if (y == p1.y && y == p2.y) {
            return true;
        }
        
        double slope1 = slope(p1);
        double slope2 = slope(p2);

        return slope1 == slope2;
    }
}