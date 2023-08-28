package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pawn extends Piece {

  private static final int WHITE_STARTING_RANK = 1;
  private static final int BLACK_STARTING_RANK = 6;
  private static final Direction WHITE_NONKILL = Direction.NORTH;
  private static final Direction[] WHITE_KILL = 
    {Direction.NORTHEAST, Direction.NORTHWEST};
  private static final Direction BLACK_NONKILL = Direction.SOUTH;
  private static final Direction[] BLACK_KILL = 
    {Direction.SOUTHEAST, Direction.SOUTHWEST};

  public Pawn(String notation, Color color) {
    super(PieceType.PAWN, Square.of(notation), color);
  }

  public void verifyAndAdd(List<Move> moves, Board board, Square square) {
    if (!board.containsPiece(getColor(), square))
      moves.add(new Move(this, square, board));
  }

  private Direction getNonKillMovementDir() {
    return getColor() == Color.WHITE ? WHITE_NONKILL : BLACK_NONKILL;
  }

  private Direction[] getKillMovementDirs() {
    return getColor() == Color.WHITE ? WHITE_KILL : BLACK_KILL;
  }

  private int getStartingRank() {
    return getColor() == Color.WHITE ? WHITE_STARTING_RANK : BLACK_STARTING_RANK;
  }

  @Override
  public List<Move> allowedMoves(Board board) {
    List<Move> allowed = new ArrayList<Move>();

    verifyAndAdd(allowed, board, 
        getPosition().getNextIn(getNonKillMovementDir()).get());
    if (getPosition().getRank() == getStartingRank()) {
      verifyAndAdd(allowed, board, 
          getPosition().getNextIn(getNonKillMovementDir()).get()
          .getNextIn(getNonKillMovementDir()).get());
    }
    for (Direction dir : getKillMovementDirs()) {
      Optional<Square> possibility = getPosition().getNextIn(dir);
      if (!possibility.isEmpty())
        if (board.containsPiece(Color.opposite(getColor()), possibility.get()))
          allowed.add(new Move(this, possibility.get(), board));
    }
    return allowed;

  }

  @Override
  public String getUnicodeSymbol() {
    return getColor() == Color.WHITE ? "♙" : "♟";
  }



}
