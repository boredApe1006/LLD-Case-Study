package chessgame;

import chessgame.board.ChessBoard;
import chessgame.game.Chess;
import chessgame.piece.Bishop;
import chessgame.piece.ChessPiece;
import chessgame.piece.Color;
import chessgame.piece.PieceName;
import chessgame.player.ChessPlayer;
import chessgame.player.HumanChessPlayer;

import java.util.HashMap;
import java.util.Map;

public class Tester {
    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();
        ChessPlayer firstPlayer = new HumanChessPlayer(
                getPieces(Color.WHITE), chessBoard, "Vivek");
        ChessPlayer secondPlayer = new HumanChessPlayer(
                getPieces(Color.BLACK), chessBoard, "Vivek");
        BoardGame chessBoardGame = new Chess(firstPlayer,secondPlayer,chessBoard);
        chessBoardGame.startGame();
    }

    private static Map<PieceName, ChessPiece> getPieces(Color color) {
        Map<PieceName,ChessPiece> pieces = new HashMap<>();
//        pieces.put(PieceName.BISHOP1, new Bishop(PieceName.BISHOP1,color,false));
    //    pieces.put(PieceName.BISHOP1, new Bishop(PieceName.BISHOP1,color,false));
  //
  //

  return pieces;
    }
}
