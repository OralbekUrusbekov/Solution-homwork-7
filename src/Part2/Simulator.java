// Simulation driver for Part 2
// Creates aircrafts and simulates message sending and runway access using ScheduledExecutorService
package Part2;

import java.util.*;
import java.util.concurrent.*;

public class Simulator {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();
        Random rand = new Random();

        List<Aircraft> aircrafts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Aircraft a;
            int type = rand.nextInt(3);
            String id = "A" + i;

            switch (type) {
                case 0 -> a = new PassengerPlane(id);
                case 1 -> a = new CargoPlane(id);
                default -> a = new Helicopter(id);
            }

            tower.registerAircraft(a);
            aircrafts.add(a);
        }

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            Aircraft a = aircrafts.get(rand.nextInt(aircrafts.size()));
            int chance = rand.nextInt(10);
            if (chance < 2) {
                a.send("MAYDAY", tower); // Emergency
            } else {
                if (tower.requestRunway(a)) {
                    a.receive("Landing successful.");
                    tower.releaseRunway();
                }
            }

            tower.processQueues();
        }, 0, 1, TimeUnit.SECONDS);

        // Auto shutdown after 20 seconds
        scheduler.schedule(() -> {
            scheduler.shutdown();
            System.out.println("\nSimulation ended.");
        }, 20, TimeUnit.SECONDS);
    }
}
