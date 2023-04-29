package elvdesign.state;

import elvdesign.data.Direction;
import elvdesign.data.Floor;
import elvdesign.data.State;

public interface ElevatorState {

    void destine(Floor floor, Direction direction);
    void open(Floor floor);
    void close(Floor floor);
    void stop(Floor floor);

    State getName();

}
