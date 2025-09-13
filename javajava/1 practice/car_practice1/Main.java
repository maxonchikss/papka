package car_practice1;
public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car("Dodge Demon SRT", "A777MR", "Black", 2024);
        Car car3 = new Car(1990);

//        car1.ToString();
        car2.ToString();
//        car3.ToString();

        car2.setModel("Land Cruiser 200");
        car2.setLicense("A777MP");
        car2.setColor("BLACK");
        car2.setYear(2010);

        System.out.println("Модель: " + car2.getModel());
        System.out.println("Номер: " + car2.getLicense());
        System.out.println("Цвет: " + car2.getColor());
        System.out.println("Год: " + car2.getYear());
        car2.GetAgeCar();
    }
}