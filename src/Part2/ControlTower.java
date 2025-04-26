// Concrete mediator class in the Mediator Pattern
// Manages landing and take-off queues and handles emergency logic
package Part2;

import java.util.*;

public class ControlTower implements TowerMediator {
    private Deque<Aircraft> landingQueue = new LinkedList<>();
    private Queue<Aircraft> takeoffQueue = new LinkedList<>();
    private List<Aircraft> allAircraft = new ArrayList<>();
    private boolean runwayFree = true;
    public void registerAircraft(Aircraft a) {
        allAircraft.add(a);
    }

    @Override
    public void broadcast(String msg, Aircraft sender) {
        if ("MAYDAY".equalsIgnoreCase(msg)) {
            System.out.println("\n>>> EMERGENCY: " + sender.getId() + " requested MAYDAY!");
            notifyAll(sender.getId() + " is landing immediately. All other aircraft HOLD.");
            landingQueue.remove(sender);
            landingQueue.addFirst(sender); // Emergency aircraft to the front
            runwayFree = true;
        } else {
            notifyAll("[" + sender.getId() + "]: " + msg);
        }
    }

    private void notifyAll(String message) {
        for (Aircraft a : allAircraft) {
            a.receive(message);
        }
    }

    @Override
    public boolean requestRunway(Aircraft a) {
        if (runwayFree) {
            runwayFree = false;
            System.out.println(">>> Runway granted to " + a.getId());
            return true;
        } else {
            System.out.println(">>> Runway busy. " + a.getId() + " is queued.");
            landingQueue.add(a);
            return false;
        }
    }

    public void releaseRunway() {
        runwayFree = true;
    }

    public void processQueues() {
        if (runwayFree && !landingQueue.isEmpty()) {
            Aircraft next = landingQueue.poll();
            System.out.println(">>> Now allowing " + next.getId() + " to land.");
            next.receive("You are cleared to land.");
            runwayFree = false;
        }
    }
}
