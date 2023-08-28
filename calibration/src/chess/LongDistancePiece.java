package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class LongDistancePiece extends Piece{
  
  public LongDistancePiece(PieceType type, Square position, Color color) {
    super(type, position, color);
  }

  protected Direction[] allowedDirections;
  
  @Override
  public List<Move> allowedMoves(Board board) {
    List<Move> allowed = new ArrayList<Move>();
    for (Direction dir : allowedDirections) {
      for (Square square : getPosition().getAllIn(dir)) {
        if (board.containsPiece(getColor(), square))
          break;
        else
          allowed.add(new Move(this, square, board));
        if (board.containsPiece(Color.opposite(getColor()), square))
          break;     
      }
    }
    return allowed;
  }

  @Override
  public boolean canMoveTo(Square destination, Board board) {
    return allowedMoves(board).stream()
        .map(move -> move.getDestination())
        .collect(Collectors.toList()).contains(destination);
  }

}
