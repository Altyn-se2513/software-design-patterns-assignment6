package visitors;

import elements.SmartDoorLock;
import elements.SmartLight;
import elements.SmartThermostat;

public class EnergyConsumptionCalculator implements DeviceVisitor {
    private int totalEnergyWatts = 0;

    @Override
    public void visit(SmartLight light) {
        int consumption = light.getPowerWatts() * light.getBrightness() / 100;
        totalEnergyWatts += consumption;
        System.out.println("[Energy] Light at '" + light.getLocation() + "' consumes " + consumption + " W.");
    }

    @Override
    public void visit(SmartThermostat thermostat) {
        int consumption = thermostat.getPowerWatts();
        totalEnergyWatts += consumption;
        System.out.println("[Energy] Thermostat at '" + thermostat.getLocation() + "' consumes " + consumption + " W.");
    }

    @Override
    public void visit(SmartDoorLock doorLock) {
        int consumption = doorLock.getPowerWatts();
        totalEnergyWatts += consumption;
        System.out.println("[Energy] DoorLock at '" + doorLock.getLocation() + "' consumes " + consumption + " W.");
    }

    public int getTotalEnergyWatts() {
        return totalEnergyWatts;
    }
}