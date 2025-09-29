package vehicles52_practice2;

public class ElectricCar extends Car {
    public int batteryCapacity;

    public ElectricCar() {
        super(); //вызов конструктора родительского класса
        this.batteryCapacity = 0;
        this.engineType = "Electric";
    }

    public ElectricCar(String ownerName, String insuranceNumber, int batteryCapacity) {
        super(ownerName, insuranceNumber);
        this.batteryCapacity = batteryCapacity;
        this.engineType = "Electric";
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Battery capacity: " + batteryCapacity + "%");
        System.out.println();
    }
}
