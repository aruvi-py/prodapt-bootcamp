package chess;

public class Bishop extends LongDistancePiece{
  
  public Bishop(String notation, Color color) {
    super(PieceType.BISHOP, Square.of(notation), color);
    allowedDirections = Direction.BISHOP_ALLOWED_DIRECTIONS;
  }

  @Override
  public boolean canMoveTo(Square destination, Board board) {
    if (!super.canMoveTo(destination, board))
      return false;
    if (destination.equals(getPosition()))
      return false;
    int rankOffset = destination.getRank() 
        - this.getPosition().getRank();
    int fileOffset = destination.getFile()
        - this.getPosition().getFile();
    return Math.abs(rankOffset) == Math.abs(fileOffset);
  }

  @Override
  public String getUnicodeSymbol() {
    return getColor() == Color.WHITE ? "♗" : "♝";
  }

}
