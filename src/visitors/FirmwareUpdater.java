package visitors;

import elements.SmartDoorLock;
import elements.SmartLight;
import elements.SmartThermostat;

public class FirmwareUpdater implements DeviceVisitor {
    @Override
    public void visit(SmartLight light) {
        System.out.println("[Firmware] Updating software for Light at '" + light.getLocation() + "'...");
    }

    @Override
    public void visit(SmartThermostat thermostat) {
        System.out.println("[Firmware] Updating software for Thermostat at '" + thermostat.getLocation() + "'...");
    }

    @Override
    public void visit(SmartDoorLock doorLock) {
        System.out.println("[Firmware] Updating software for DoorLock at '" + doorLock.getLocation() + "'...");
    }
}