# Smart Home - Visitor Design Pattern

**Student:** Abdinurova Altyn                           
**Course:** Software Design Patterns                     
**Assignment:** #6 - Visitor Pattern

## 1. Overview
This project implements the **Visitor behavioral design pattern** in Java. The chosen topic is a **Smart Home** system. 
The goal is to demonstrate how we can add new operations (like diagnostics, energy calculation, and firmware updates) to a collection of smart devices **without modifying the device classes themselves**. This strictly follows the Open/Closed Principle.

## 2. Project Structure

```text
src/
│
├── Main.java              # Client code (traverses the object structure)
├── SmartHome.java         # Object Structure (holds the collection of devices)
│
├── elements/              # Concrete Elements
│   ├── SmartDevice.java   # Element Interface
│   ├── SmartLight.java
│   ├── SmartThermostat.java
│   └── SmartDoorLock.java
│
└── visitors/              # Concrete Visitors
    ├── DeviceVisitor.java # Visitor Interface
    ├── DiagnosticVisitor.java
    ├── EnergyConsumptionCalculator.java
    └── FirmwareUpdater.java
```

## 3. How It Works (Double Dispatch)
The core mechanism of this pattern is **Double Dispatch**, which completely replaces the need for `instanceof` checks or type-casting.
1. The client calls `device.accept(visitor)`.
2. The specific device (e.g., `SmartLight`) calls `visitor.visit(this)`, passing its own specific type.
3. The Java compiler automatically resolves which overloaded `visit()` method to call based on the specific device class.

## 4. Clean Code Principles Justification 

Here are the 5 Clean Code principles demonstrated in this project, as required by the assignment:

1. **Meaningful Names:** 
   * *Justification:* Names clearly distinguish Element vs. Visitor responsibilities. E.g., `DeviceVisitor` and `EnergyConsumptionCalculator` make the intent obvious without needing comments.
2. **No `instanceof` / Type-checking chains:** 
   * *Justification:* Thanks to Double Dispatch, there is zero type-checking in the code. The `DeviceVisitor` interface handles all type resolution via polymorphism.
3. **Single Responsibility Principle (SRP):** 
   * *Justification:* Each Concrete Visitor implements exactly one operation across all element types. For example, `FirmwareUpdater` only knows how to update firmware, while `DiagnosticVisitor` only checks status. Devices only store state.
4. **Encapsulation Trade-offs:** 
   * *Justification:* The Visitor needs access to the element internals to perform its job. We handled this by making the fields `private final` (so they cannot be altered) and providing safe, read-only getters (e.g., `getPowerWatts()`). 
5. **Demonstrated Extensibility (OCP):** 
   * *Justification:* Adding a third visitor requires **zero changes** to the element classes. The `FirmwareUpdater` class was added as a 3rd visitor to prove that the object structure (`SmartLight`, etc.) remains completely untouched.

## 5. How to Run

1. Compile the files from the `src` directory:
```bash
javac -d out src/*.java src/elements/*.java src/visitors/*.java
```
2. Run the app:
```bash
java -cp out Main
```

## 6. Expected Output

```text
--- 1. Running System Diagnostics ---
[Diag] Light at 'Living Room': Brightness is 80%. Status: OK.
[Diag] Thermostat at 'Bedroom': Temp is 22.5°C. Status: OK.
[Diag] DoorLock at 'Front Door': Is Locked? true. Status: OK.

--- 2. Calculating Energy Consumption ---
[Energy] Light at 'Living Room' consumes 48 W.
[Energy] Thermostat at 'Bedroom' consumes 150 W.
[Energy] DoorLock at 'Front Door' consumes 15 W.
Total home energy consumption: 213 W.

--- 3. Bulk Firmware Update ---
[Firmware] Updating software for Light at 'Living Room'...
[Firmware] Updating software for Thermostat at 'Bedroom'...
[Firmware] Updating software for DoorLock at 'Front Door'...
```