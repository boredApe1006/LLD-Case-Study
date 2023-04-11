package chessgame.game;

import chessgame.BoardGame;
import chessgame.board.Board;
import chessgame.board.ChessBoard;
import chessgame.piece.PieceName;
import chessgame.player.ChessPlayer;
import chessgame.player.Player;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Chess extends BoardGame {
    private final ChessPlayer player1, player2;

    public Chess( ChessPlayer player1, ChessPlayer player2, ChessBoard chessBoard) {
        super(chessBoard,new ArrayDeque<Player>(
                Arrays.asList(player1,player2)
        ));
        this.player1 = player1;
        this.player2 = player2;
        prepareBoard(this.player1,this.player2,chessBoard);

    }

    private void prepareBoard(ChessPlayer firstPlayer, ChessPlayer secondPlayer, ChessBoard board) {
        placePawns(1, board, firstPlayer);
        placePawns(6, board, secondPlayer);
        placePawns(0, board, firstPlayer);
        placePawns(7, board, secondPlayer);
//        placeKing(0,board, firstPlayer);
//        placeKing(7,board, secondPlayer);
//        placeQueen(0,board, firstPlayer);
//        placeQueen(7,board, secondPlayer);

    }

    private void placePawns(int row, ChessBoard board, ChessPlayer player) {
        List<PieceName> pieceNames =
                Arrays.asList(PieceName.PAWN1, PieceName.PAWN2, PieceName.PAWN3, PieceName.PAWN4,
                               PieceName.PAWN5, PieceName.PAWN6, PieceName.PAWN7, PieceName.PAWN8);

        int col = 0;
        for(PieceName pieceName : pieceNames) {
            board.putPiece(player.getPiece(pieceName) , row, col++);
        }
    }
    @Override
    public boolean isOver() {
        return player1.getPiece(PieceName.KING).isDead() ||
                player2.getPiece(PieceName.KING).isDead();
    }
}
