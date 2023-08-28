package chess;

public enum Direction {
  
  NORTH (0, 1),
  NORTHEAST (1, 1),
  EAST (1, 0),
  SOUTHEAST (-1, 1),
  SOUTH (0, -1),
  SOUTHWEST (-1, -1),
  WEST (-1, 0),
  NORTHWEST (1, -1);
  
  private int x;
  private int y;
  
  public static Direction[] ROOK_ALLOWED_DIRECTIONS = 
    {Direction.NORTH, Direction.SOUTH, 
     Direction.EAST, Direction.WEST};
  
  public static Direction[] BISHOP_ALLOWED_DIRECTIONS = 
    {Direction.NORTHEAST, Direction.NORTHWEST,
     Direction.SOUTHEAST, Direction.SOUTHWEST};
  
  private Direction(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  public int getX() {
    return x;
  }
  
  public int getY() {
    return y;
  }

}
