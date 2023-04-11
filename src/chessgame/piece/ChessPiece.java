package chessgame.piece;

import chessgame.board.ChessBoard;
import chessgame.cell.ChessCell;

public interface ChessPiece {

    void move(ChessCell source, ChessCell destination, ChessBoard chessBoard);

    boolean isDead();

    void setDead(boolean isDead);

    PieceName getName();

    Color getColor();
}
