// Interface for the Mediator Pattern
// Declares methods for broadcasting messages and requesting runway access
package Part2;

public interface TowerMediator {
    void broadcast(String msg, Aircraft sender);
    boolean requestRunway(Aircraft a); // true when cleared
}
