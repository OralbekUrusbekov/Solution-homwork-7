// Concrete colleague class representing a cargo plane
package Part2;

public class CargoPlane extends Aircraft {
    public CargoPlane(String id) {
        super(id);
    }

    @Override
    public void receive(String msg) {
        System.out.println("[Cargo " + id + "] received: " + msg);
    }
}
