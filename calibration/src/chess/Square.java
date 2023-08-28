package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Square {
  
  private int file;//zero-indexed
  private int rank;//zero-indexed
  
  private static final int SIZE = 8;
  
  private static Square[][] squares = new Square[SIZE][SIZE];
  
  public static final String FILES = "abcdefgh";
  
  private Square(int file, int rank) {
    this.file = file;
    this.rank = rank;
  }
  
  public static Square of(String notation) {
    String[] components = notation.split("");
    int file = FILES.indexOf(components[0]);
    int rank = Integer.valueOf(components[1]) - 1;
    if (squares[rank][file] == null) {
      initAllSquares();
    }
    return squares[rank][file];
  }
  
  private static void initAllSquares() {
    for (int i = 0; i < SIZE; i++)
      for (int j = 0; j < SIZE; j++)
        squares[i][j] = new Square(j, i);
  }
  
  public static Square[][] getAllSquares() {
    initAllSquares();
    return squares;
  }
  
  public int getRank() {
    return rank;
  }
  
  public int getFile() {
    return file;
  }
  
  public String toString() {
    return String.format("%s%d", FILES.charAt(file), rank + 1);
  }

  @Override
  public int hashCode() {
    return Objects.hash(file, rank);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Square other = (Square) obj;
    return file == other.file && rank == other.rank;
  }
  
  private boolean isWithinLimits(int index) {
    return index >= 0 && index < SIZE;
  }
  
  private boolean areWithinLimits(int rowIndex, int colIndex) {
    return isWithinLimits(rowIndex) && isWithinLimits(colIndex);
  }
  
  public Optional<Square> offsetBy (int fileOffset, int rankOffset) {
    int newFile = file + fileOffset;
    int newRank = rank + rankOffset;
    if (!areWithinLimits(newFile, newRank))
      return Optional.empty();
    return Optional.of(squares[newRank][newFile]);
  }
  
  public Optional<Square> getNextIn(Direction direction) {
    return offsetBy(direction.getX(), direction.getY());
  }
  
  public List<Square> getAllIn(Direction direction) {
    List<Square> squares = new ArrayList<Square>();
    Optional<Square> next = getNextIn(direction);
    while (!next.isEmpty()) {
      squares.add(next.get());
      next = next.get().getNextIn(direction);
    }
    return squares;
  }

}
