// Abstract colleague class in the Mediator Pattern
// All aircraft types inherit from this and communicate via the TowerMediator
package Part2;

public abstract class Aircraft {
    protected String id;

    public Aircraft(String id) {
        this.id = id;
    }

    public abstract void receive(String msg); // Receive message from the tower

    public void send(String msg, TowerMediator mediator) {
        mediator.broadcast(msg, this); // Send message via mediator
    }

    public String getId() {
        return id;
    }
}
