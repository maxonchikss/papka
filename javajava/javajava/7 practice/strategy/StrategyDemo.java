package strategy;
//создаются разные стратегии (в их роли классы) и выбирается любая из них
public class StrategyDemo {
    public static void main(String[] args) {
        DeliveryContext context = new DeliveryContext();

        double weight = 20.0;

        context.setStrategy(new StandardDelivery());
        System.out.println("Standard: " + context.executeStrategy(weight));

        context.setStrategy(new ExpressDelivery());
        System.out.println("Express: " + context.executeStrategy(weight));

        context.setStrategy(new CourierDelivery());
        System.out.println("Courier: " + context.executeStrategy(weight));
    }
}
