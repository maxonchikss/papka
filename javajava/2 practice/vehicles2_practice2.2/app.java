package vehicles52_practice2;

public class app {
    public static void main(String[] args) {
        Car car = new Car();
        Car bmw = new Car("Kabachkow", "777RUS23-12");
        ElectricCar tesla = new ElectricCar();
        ElectricCar teslaY = new ElectricCar("Dub", "thecheapestone-001", 100);

        car.printInfo();
        System.out.println();
        bmw.printInfo();
        System.out.println();
        tesla.printInfo();
        teslaY.printInfo();

    }
}
