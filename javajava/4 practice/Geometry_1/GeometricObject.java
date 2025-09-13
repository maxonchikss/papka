package Geometry_1;

public abstract class GeometricObject implements Comparable{
    private String color;
    private boolean filled;
    private String name;
//    private String dateCreated;

    public GeometricObject(){
        this.name = "-";
        this.color = "None";
        this.filled = false;
//        this.dateCreated = "00.00.0000";
    }

    public GeometricObject(String name, String color, boolean filled){
        this.name = name;
        this.color = color;
        this.filled = filled;
//        this.dateCreated = dateCreated;
    }
    public void setName(String name) {this.name = name;}
    public void setColor(String color) {this.color = color;}
    public void setFilled(boolean filled) {this.filled = filled;}
//    public void dateCreated(String color) {this.dateCreated = dateCreated;}

    public String getName() {return name;}
    public String getColor () {return color;}
    public boolean isFilled() {return filled;}
//    public String getdateCreated () {return dateCreated;}

    public abstract double getArea();

    public static GeometricObject max(GeometricObject obj1, GeometricObject obj2) {
        if (obj1.getArea() >= obj2.getArea()) {
            return obj1;
        } else {
            return obj2;
        }
    }

    public int compareTo(GeometricObject other) {
        if (this.getArea() > other.getArea()) return 1;
        else if (this.getArea() < other.getArea()) return -1;
        else return 0;
    }

    public String toString() {
        return //"GeometricObject created on " + dateCreated +
                "Color: " + color +
                " and filled: " + filled;
    }

}
