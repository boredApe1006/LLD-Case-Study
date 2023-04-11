package chessgame.board;

import chessgame.Move;

public interface Board {

    void applyMove(Move move);

    void display();
}
