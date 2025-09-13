package vehicles_2_practice2.vehicles;
//public class ElectricCar extends Car { задача из 2 практики, тут чисто прикрутили интерфейс для ElectricCar
public class ElectricCar extends Car implements ElectricVehicle {
    private int BatteryCapacity;

    public ElectricCar(String model, String license, String color, int year, String ownerName, String insuranceNumber, int BatteryCapacity) {
        super(model, license, color, year, ownerName, insuranceNumber, "Electric");
        this.BatteryCapacity = BatteryCapacity;
        this.engineType = "Electric";
    }

    public int getBatteryCapacity() { return BatteryCapacity; }
    public void setBatteryCapacity(int batteryCapacity) { this.BatteryCapacity = batteryCapacity; }

    public String vehicleType() {
        return "ElectricCar";
    }
    public String toString() {
        return super.toString() + "\nBattery capacity: " + BatteryCapacity + " %";
    }
}
