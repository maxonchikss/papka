package car_practice1;
public class Car {
    String model;
    String license;
    String color;
    int year;

    public Car(){
        this.model = "Empty";
        this.license = "Empty";
        this.color = "Empty";
        this.year = 0;
    }

    public Car(String model, String license, String color, int year){
        this.model = model;
        this.license = license;
        this.color = color;
        this.year = year;
    }

    public Car(int year){
        this.model = "Empty";
        this.license = "Empty";
        this.color = "Empty";
        this.year = year;
    }
    public void ToString(){
        System.out.println("Model: " + model);
        System.out.println("License: " + license);
        System.out.println("Color: " + color);
        System.out.println("Year: " + year);
        System.out.println();
    }
    public String getModel() {
        return model;
    }

    public String getLicense() {
        return license;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public void GetAgeCar() {
        System.out.println("Возраст авто: " + (2025 - this.year));
    }
}