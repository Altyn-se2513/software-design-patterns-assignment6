import elements.SmartDevice;
import visitors.DeviceVisitor;

import java.util.ArrayList;
import java.util.List;

public class SmartHome {
    private final List<SmartDevice> devices = new ArrayList<>();

    public void addDevice(SmartDevice device) {
        devices.add(device);
    }

    public void removeDevice(SmartDevice device) {
        devices.remove(device);
    }

    public void accept(DeviceVisitor visitor) {
        for (SmartDevice device : devices) {
            device.accept(visitor);
        }
    }
}