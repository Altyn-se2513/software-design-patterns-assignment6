package visitors;

import elements.SmartDoorLock;
import elements.SmartLight;
import elements.SmartThermostat;

public class DiagnosticVisitor implements DeviceVisitor {
    @Override
    public void visit(SmartLight light) {
        System.out.println("[Diag] Light at '" + light.getLocation() + "': Brightness is " + light.getBrightness() + "%. Status: OK.");
    }

    @Override
    public void visit(SmartThermostat thermostat) {
        System.out.println("[Diag] Thermostat at '" + thermostat.getLocation() + "': Temp is " + thermostat.getTemperatureCelsius() + "°C. Status: OK.");
    }

    @Override
    public void visit(SmartDoorLock doorLock) {
        System.out.println("[Diag] DoorLock at '" + doorLock.getLocation() + "': Is Locked? " + doorLock.isLocked() + ". Status: OK.");
    }
}