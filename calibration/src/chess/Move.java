package chess;

public class Move {
  
  
  private Square oldPos;
  private Piece piece;
  private Square destination;
  private Board board;
  
  public Move(Piece piece, Square destination, Board board) {
    this.piece = piece;
    this.destination = destination;
    this.board = board;
  }
  
  public Move(String notation, Board board) {
    //TODO: read the notation.
  }
  
  public boolean isLegal() {
    return piece.canMoveTo(destination, board);
  }
  
  public void attempt() {
    oldPos = piece.getPosition();
    if (isLegal())
      piece.setPosition(destination);
  }
  
  public void rollBack() {
    piece.setPosition(oldPos);
  }
  
  public void commit() {
    if (isLegal())
      piece.setPosition(destination);
    oldPos = piece.getPosition();
  }

  public Square getDestination() {
    return destination;
  }
  
  public Piece getPiece() {
    return piece;
  }
  
  @Override
  public String toString() {
    return String.format("%s%s%s", piece.getType(), piece.getPosition(), destination);
  }

}
