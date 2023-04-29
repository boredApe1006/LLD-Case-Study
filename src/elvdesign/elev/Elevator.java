package elvdesign.elev;

import elvdesign.data.Direction;
import elvdesign.data.Floor;
import elvdesign.moves.MoveStore;
import elvdesign.state.ElevatorState;

public class Elevator {

    private Floor currentFloor;
    private ElevatorState state;

    private final MoveStore moveStore;

    public Elevator(MoveStore moveStore) {
        this.moveStore = moveStore;
    }

    public void destine(Floor floor, Direction direction) {
        this.state.destine(floor,direction);
    }

    public void open(Floor floor) {
        this.state.open(floor);
    }
    public void close(Floor floor) {
        this.state.close(floor);
    }
    public void stop(Floor floor) {
        this.state.stop(floor);
    }
    public Floor getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Floor currentFloor) {
        this.currentFloor = currentFloor;
    }

    public ElevatorState getState() {
        return state;
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }

    public MoveStore getMoveStore() {
        return moveStore;
    }
}
