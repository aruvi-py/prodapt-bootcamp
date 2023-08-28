package chess;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Queen extends Piece {
  
  public Queen(String notation, Color color) {
    super(PieceType.QUEEN, Square.of(notation), color);
  }

  @Override
  public List<Move> allowedMoves(Board board) {
    Rook tempRook = new Rook(this.getPosition().toString(), this.getColor());
    Bishop tempBishop = new Bishop(this.getPosition().toString(), this.getColor());
    List<Move> transformedRookMoves = tempRook.allowedMoves(board).stream()
        .map(move -> new Move(this, move.getDestination(), board))
        .collect(Collectors.toList());
    List<Move> transformedBishopMoves = tempBishop.allowedMoves(board).stream()
        .map(move -> new Move(this, move.getDestination(), board))
        .collect(Collectors.toList());
    Set<Move> moveset = new HashSet<Move>();
    moveset.addAll(transformedRookMoves);
    moveset.addAll(transformedBishopMoves);
    return new ArrayList<Move>(moveset);
  }

  @Override
  public String getUnicodeSymbol() {
    return getColor() == Color.WHITE ? "♕" : "♛";
  }

}
