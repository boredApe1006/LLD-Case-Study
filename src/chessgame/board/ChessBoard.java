package chessgame.board;


import chessgame.Move;
import chessgame.Pair;
import chessgame.cell.ChessCell;
import chessgame.piece.ChessPiece;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChessBoard implements Board{

    private final List<List<ChessCell>> cells;
    private static final int rowCount = 8;
    private static final int colCount = 8;
    public ChessBoard() {
        this.cells = new ArrayList<>();
        for(int i = 0; i < rowCount; ++i) {
            List<ChessCell> chessCells = new ArrayList<>();
            for(int j = 0; j < colCount; ++j) {
                chessCells.add(new ChessCell(i,j));
            }
            this.cells.add(chessCells);
        }
    }
    @Override
    public void applyMove(Move move) {
       ChessCell sourceCell = getCell(move.getSource());
       ChessPiece chessPiece = sourceCell.getChessPiece().get();
       chessPiece.move(sourceCell,getCell(move.getDestination()),
               this);
    }

    @Override
    public void display() {
         for(int row = 0; row < rowCount; ++row) {
             for(int col = 0; col < colCount; ++col) {
                 Pair p = new Pair(row,col);
                 Optional<ChessPiece> chessPiece = getCell(p).getChessPiece();
                 if(!chessPiece.isPresent()) {
                     System.out.print("0 | ");
                 } else {
                     System.out.println(chessPiece.get().getName()
                      + " | ");
                 }
             }
             System.out.println();
         }
    }
    public ChessCell getCell(Pair pair) {
      this.cells.get(pair.getX()).get(pair.getY());
    }

    public void putPiece(ChessPiece chessPiece, int row, int col) {
        cells.get(row).get(col).setChessPiece(Optional.of(chessPiece));
    }

    public void removePiece(int row, int col) {
        cells.get(row).get(col).setChessPiece(Optional.empty());
    }

}
