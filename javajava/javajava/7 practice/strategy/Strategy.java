package strategy;

interface DeliveryStrategy { double calculateCost(double weight); }

class StandardDelivery implements DeliveryStrategy {
    public double calculateCost(double weight) { return 100 + weight * 10; }
}

class ExpressDelivery implements DeliveryStrategy {
    public double calculateCost(double weight) { return 200 + weight * 20; }
}

class CourierDelivery implements DeliveryStrategy {
    public double calculateCost(double weight) { return 500; }
}
    class DeliveryContext {
        private DeliveryStrategy strategy;

        public void setStrategy(DeliveryStrategy strategy) {
            this.strategy = strategy;
        }

        public double executeStrategy(double weight) {
            return strategy.calculateCost(weight);
        }
    }


