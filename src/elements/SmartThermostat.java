package elements;

import visitors.DeviceVisitor;

public class SmartThermostat implements SmartDevice {
    private final String location;
    private final double temperatureCelsius;
    private final int powerWatts;

    public SmartThermostat(String location, double temperatureCelsius, int powerWatts) {
        this.location = location;
        this.temperatureCelsius = temperatureCelsius;
        this.powerWatts = powerWatts;
    }

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visit(this);
    }

    public String getLocation() { return location; }
    public double getTemperatureCelsius() { return temperatureCelsius; }
    public int getPowerWatts() { return powerWatts; }
}