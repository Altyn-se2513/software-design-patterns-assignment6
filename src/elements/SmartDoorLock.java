package elements;

import visitors.DeviceVisitor;

public class SmartDoorLock implements SmartDevice {
    private final String location;
    private final boolean isLocked;
    private final int powerWatts;

    public SmartDoorLock(String location, boolean isLocked, int powerWatts) {
        this.location = location;
        this.isLocked = isLocked;
        this.powerWatts = powerWatts;
    }

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visit(this);
    }

    public String getLocation() { return location; }
    public boolean isLocked() { return isLocked; }
    public int getPowerWatts() { return powerWatts; }
}