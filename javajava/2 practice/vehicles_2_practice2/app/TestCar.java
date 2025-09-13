package vehicles_2_practice2.app;
import vehicles_2_practice2.vehicles.Car;
import vehicles_2_practice2.vehicles.ElectricCar;
import vehicles_2_practice2.vehicles.Vehicle;
public class TestCar {
    public static void main(String[] args) {
        Vehicle car1 = new Car("S63 AMG", "K040LG", "Beige", 2020, "Me", "4782345678324568", "Gasoline");
        Vehicle car2 = new ElectricCar("Tesla Model S", "G004YY", "Pink", 2022, "Sergey", "435634674356456", 44);


        System.out.println(car1.toString());
        System.out.println();
        System.out.println(car2.toString());


        car1.setOwnerName("!!!Me again!!!");
        car2.setOwnerName("!!!Kabachkov!!!");
        car2.setInsuranceNumber("0000000000000000001AMP");//рудимент 3 практики есчо
        ((ElectricCar) car2).setBatteryCapacity(80);

        System.out.println("------------------------------------------------------");
        System.out.println(car1.toString());
        System.out.println();
        System.out.println(car2.toString());
    }
}