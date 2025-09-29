package vehicles_2_practice2.vehicles;

public abstract class Vehicle { //общий базовый функционал для других классов
    private String model;
    private String license;
    private String color;
    private int year;
    private String ownerName;
    private String insuranceNumber;
    protected String engineType;

    public abstract String vehicleType();

    public Vehicle(String model, String license, String color, int year, String ownerName, String insuranceNumber, String engineType) {
        this.model = model;
        this.license = license;
        this.color = color;
        this.year = year;
        this.ownerName = ownerName;
        this.insuranceNumber = insuranceNumber;
        this.engineType = engineType;
    }

    public String getModel() { return model; }
    public String getLicense() { return license; }
    public String getColor() { return color; }
    public int getYear() { return year; }
    public String getOwnerName() { return ownerName; }
    public String getInsuranceNumber() { return insuranceNumber; }
    public String getEngineType() { return engineType; }
    public void setModel(String model) { this.model = model; }
    public void setLicense(String license) { this.license = license; }
    public void setColor(String color) { this.color = color; }
    public void setYear(int year) { this.year = year; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
    public void setInsuranceNumber(String insuranceNumber) { this.insuranceNumber = insuranceNumber; }
    public void setEngineType(String engineType) { this.engineType = engineType; }

    public String toString() {
        return "Type: " + vehicleType() + "\n" +
                "Model: " + model + "\n" +
                "License: " + license + "\n" +
                "Color: " + color + "\n" +
                "Year: " + year + "\n" +
                "Owner: " + ownerName + "\n" +
                "Insurance: " + insuranceNumber + "\n" +
                "Engine type: " + engineType;
    }
}