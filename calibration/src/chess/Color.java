package chess;

public enum Color {
  
  BLACK,
  WHITE;
  
  public static Color opposite(Color color) {
    return color == BLACK ? WHITE : BLACK;
  }

}
