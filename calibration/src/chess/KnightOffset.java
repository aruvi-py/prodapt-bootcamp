package chess;

public enum KnightOffset {
  
  NE1(2, 1),
  NE2(1, 2),
  NW1(-2, 1),
  NW2(-1, 2),
  SE1(2, -1),
  SE2(1, -2),
  SW1(-2, -1),
  SW2(-1, -2);
  
  private int x;
  private int y;
  
  private KnightOffset(int x, int y) {
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
