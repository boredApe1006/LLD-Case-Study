package elvdesign.data;

import elvdesign.elev.Elevator;
import elvdesign.state.ElevatorState;

public class IdleState implements ElevatorState {

    private final Elevator elevator;

    public IdleState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void destine(Floor floor, Direction direction) {
           this.elevator.getMoveStore().addMove(new Move(floor , direction));
           Direction topDirection =
                   this.elevator.getMoveStore().getTop().get().getDestinationDirection();

           if(topDirection.equals(Direction.UP)) {
               this.elevator.setState(new MovingUpState(this.elevator));
           } else {
               this.elevator.setState(new MovingDownState(this.elevator));
           }
           // more checks
    }

    @Override
    public void open(Floor floor) {
           // some code
        this.elevator.setState(new GateOpenState(this.elevator));
    }

    @Override
    public void close(Floor floor) {

    }

    @Override
    public void stop(Floor floor) {
       throw new RuntimeException();
    }

    @Override
    public State getName() {
        return State.IDLE;
    }
}
