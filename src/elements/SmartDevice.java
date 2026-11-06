package elements;

import visitors.DeviceVisitor;

public interface SmartDevice {
    void accept(DeviceVisitor visitor);
}