package chess;

public class Rook extends LongDistancePiece {
  public Rook(String notation, Color color) {
    super(PieceType.ROOK, Square.of(notation), color);
    allowedDirections = Direction.ROOK_ALLOWED_DIRECTIONS;
  }

  @Override
  public String getUnicodeSymbol() {
    return getColor() == Color.WHITE ? "♖" : "♜";
  }

}
