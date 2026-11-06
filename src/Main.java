import elements.SmartDoorLock;
import elements.SmartLight;
import elements.SmartThermostat;
import visitors.DiagnosticVisitor;
import visitors.DeviceVisitor;
import visitors.EnergyConsumptionCalculator;
import visitors.FirmwareUpdater;

public class Main {
    public static void main(String[] args) {
        SmartHome home = new SmartHome();
        
        home.addDevice(new SmartLight("Living Room", 80, 60));
        home.addDevice(new SmartThermostat("Bedroom", 22.5, 150));
        home.addDevice(new SmartDoorLock("Front Door", true, 15));

        System.out.println("--- 1. Running System Diagnostics ---");
        DeviceVisitor diagnostics = new DiagnosticVisitor();
        home.accept(diagnostics);

        System.out.println("\n--- 2. Calculating Energy Consumption ---");
        EnergyConsumptionCalculator energyCalculator = new EnergyConsumptionCalculator();
        home.accept(energyCalculator);
        System.out.println("Total home energy consumption: " + energyCalculator.getTotalEnergyWatts() + " W.");

        System.out.println("\n--- 3. Bulk Firmware Update ---");
        DeviceVisitor firmwareUpdater = new FirmwareUpdater();
        home.accept(firmwareUpdater);
    }
}