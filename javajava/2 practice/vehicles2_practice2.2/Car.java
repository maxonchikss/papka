package vehicles52_practice2;

public class Car {
    private String ownerName;
    private String insuranceNumber;
    protected String engineType;


    public Car() {
        this.ownerName = "Unknown";
        this.insuranceNumber = "Unknown";
        this.engineType = "Unknown";
    }
    public Car(String ownerName, String insuranceNumber) {
        this.ownerName = ownerName;
        this.insuranceNumber = insuranceNumber;
        this.engineType = "Unknown";
    }


    public String getOwnerName() {
        return ownerName;
    }
    public String getInsuranceNumber() {
        return insuranceNumber;
    }
    public String getEngineType() {
        return engineType;
    }


    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }
    public String setEngineType() {
        return this.engineType = engineType;
    }


    public void printInfo() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Insurance: " + insuranceNumber);
        System.out.println("Engine type: " + engineType);
    }
}
