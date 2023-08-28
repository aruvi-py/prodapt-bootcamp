package chess;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class King extends Piece {

  public King(String notation, Color color) {
    super(PieceType.KING, Square.of(notation), color);
  }

  @Override
  public List<Move> allowedMoves(Board board) {
    return Arrays.stream(Direction.values())
          .map(dir -> getPosition().getNextIn(dir))
          .flatMap(Optional<Square>::stream)//retain only non-empty squares
          .filter(square -> !board.containsPiece(getColor(), square))
          .map(square -> new Move(this, square, board))
          .collect(Collectors.toList());
  }

  @Override
  public String getUnicodeSymbol() {
    return getColor() == Color.WHITE ? "♔" : "♚";
  }
  
  

}
