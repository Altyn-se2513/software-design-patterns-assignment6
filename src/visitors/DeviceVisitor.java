package visitors;

import elements.SmartDoorLock;
import elements.SmartLight;
import elements.SmartThermostat;

public interface DeviceVisitor {
    void visit(SmartLight light);
    void visit(SmartThermostat thermostat);
    void visit(SmartDoorLock doorLock);
}