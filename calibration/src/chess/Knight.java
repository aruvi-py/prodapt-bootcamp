package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Knight extends Piece{

  public Knight(String notation, Color color) {
    super(PieceType.KNIGHT, Square.of(notation), color);
  }

  @Override
  public List<Move> allowedMoves(Board board) {
    List<Move> allowed = new ArrayList<Move>();
    for (KnightOffset offset : KnightOffset.values()) {
      Optional<Square> possibility = getPosition()
          .offsetBy(offset.getX(), offset.getY());
      if (!possibility.isEmpty()) {
        if (!board.containsPiece(getColor(), possibility.get()))
          allowed.add(new Move(this, possibility.get(), board));
      }
    }
    return allowed;
  }

  @Override
  public String getUnicodeSymbol() {
    return getColor() == Color.WHITE ? "♘" : "♞";
  }
}
