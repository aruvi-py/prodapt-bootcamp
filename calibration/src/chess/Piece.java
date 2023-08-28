package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class Piece {
  private PieceType type;
  private Square position;
  private Color color;
  
  public abstract List<Move> allowedMoves(Board board);
  public abstract String getUnicodeSymbol();
  
  public boolean canMoveTo(Square destination, Board board) {
    return allowedMoves(board).stream()
        .map(move -> move.getDestination())
        .collect(Collectors.toList()).contains(destination);
  }
  
  public boolean canKill(Piece other, Board board) {
    return other.getColor() != this.getColor()
        && this.canMoveTo(other.getPosition(), board);
  }
  
  public Piece(PieceType type, Square position, Color color) {
    this.type = type;
    this.position = position;
    this.color = color;
  }
  
  public PieceType getType() {
    return type;
  }
  
  public Square getPosition() {
    return position;
  }
  
  public Color getColor() {
    return color;
  }
  
  public void setPosition(Square newPos) {
    this.position = newPos;
  }
  
  
  @Override
  public String toString() {
    return String.format("%s%s", type.toString(), position.toString());
  }

  @Override
  public int hashCode() {
    return Objects.hash(color, position, type);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Piece other = (Piece) obj;
    return color == other.color && Objects.equals(position, other.position) && type == other.type;
  }
  
}
