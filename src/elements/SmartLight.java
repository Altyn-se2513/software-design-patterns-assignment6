package elements;

import visitors.DeviceVisitor;

public class SmartLight implements SmartDevice {
    private final String location;
    private final int brightness;
    private final int powerWatts;

    public SmartLight(String location, int brightness, int powerWatts) {
        this.location = location;
        this.brightness = brightness;
        this.powerWatts = powerWatts;
    }

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visit(this); 
    }

    public String getLocation() { return location; }
    public int getBrightness() { return brightness; }
    public int getPowerWatts() { return powerWatts; }
}