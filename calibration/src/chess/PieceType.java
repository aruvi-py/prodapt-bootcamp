package chess;

public enum PieceType {

  PAWN(""),
  BISHOP("B"),
  KNIGHT("N"),
  ROOK("R"),
  QUEEN("Q"),
  KING("K");

  private String notation;

  private PieceType(String notation) {
    this.notation = notation;
  }
  
  @Override
  public String toString() {
    return notation;
  }

}
