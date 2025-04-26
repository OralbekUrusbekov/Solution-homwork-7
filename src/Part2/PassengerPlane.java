// Concrete colleague class representing a passenger plane
// Overrides receive to show a custom message
package Part2;

public class PassengerPlane extends Aircraft {
    public PassengerPlane(String id) {
        super(id);
    }

    @Override
    public void receive(String msg) {
        System.out.println("[Passenger " + id + "] received: " + msg);
    }
}
