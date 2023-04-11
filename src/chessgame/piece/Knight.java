package chessgame.piece;

import chessgame.board.ChessBoard;
import chessgame.cell.ChessCell;

public class Knight implements ChessPiece{

    private final PieceName pieceName;
    private final Color color;
    private final boolean isDead;

    public Knight(PieceName pieceName, Color color, boolean isDead) {
        this.pieceName = pieceName;
        this.color = color;
        this.isDead = isDead;
    }

    @Override
    public void move(ChessCell source, ChessCell destination, ChessBoard chessBoard) {
          int x_diff = Math.abs(source.getX() - destination.getX());
          int y_diff = Math.abs(source.getY() - destination.getY());
          // Illegal move
          if(!(Math.max(x_diff,y_diff) == 2
                  && Math.min(x_diff,y_diff) == 1 )   ) {
                throw new RuntimeException("Invalid Move");
          }
          if(destination.getChessPiece().isPresent()) {
              if(destination.getChessPiece().get().getColor().equals(this.color)) {
                  throw new RuntimeException("Destination Invalid my piece only");
              } else {
                  destination.getChessPiece().get().setDead(true);
              }
          }
          chessBoard.removePiece(source.getX(), source.getY());
          chessBoard.putPiece(this, destination.getX(),
                  destination.getY());
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public void setDead(boolean isDead) {

    }

    @Override
    public PieceName getName() {
        return null;
    }

    @Override
    public Color getColor() {
        return null;
    }
}
