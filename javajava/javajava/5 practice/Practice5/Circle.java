package Practice5;

public class Circle {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    public double GetRadius(){return radius;}
    public int compareTo(Circle other) {
        return Double.compare(this.radius, other.radius);
    }
    public static Circle findMax(Circle[] circles) {
        Circle max = circles[0];
        for (Circle c : circles) {
            if (c.compareTo(max) > 0) {
                max = c;
            }
        }
        return max;
    }

    public static Circle findMax2D(Circle[][]matrix) {
        Circle mx = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].compareTo(mx) > 0){
                    mx = matrix[i][j];
                }
            }
        }
        return mx;
    }

    public String toString() {
        return "" + radius + "";
    }
}
