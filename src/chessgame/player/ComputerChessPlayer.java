package chessgame.player;

import chessgame.Move;
import chessgame.board.ChessBoard;
import chessgame.piece.ChessPiece;
import chessgame.piece.PieceName;

import java.util.Map;

public class ComputerChessPlayer extends ChessPlayer{
    public ComputerChessPlayer(Map<PieceName, ChessPiece> pieces, ChessBoard chessBoard, String name) {
        super(pieces, chessBoard, name);
    }
    @Override
    public Move makeMove() {
        return null;
    }
}
