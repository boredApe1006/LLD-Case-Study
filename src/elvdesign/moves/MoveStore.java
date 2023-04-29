package elvdesign.moves;


import elvdesign.data.Direction;
import elvdesign.data.Move;

import java.util.Optional;

public interface MoveStore {

    void addMove(Move move);

    Optional<Move> getTop();

    void clearTop();

    Direction getCurrentDirection();
}
