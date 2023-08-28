package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Player {
  
  private String name;
  private Color color;
  private List<Piece> pieces;
  
  public static final int SIZE = 8;
  public static final int WHITE_PIECES_START_RANK = 1;
  public static final int BLACK_PIECES_START_RANK = 8;
  public static final int WHITE_PAWNS_START_RANK = 2;
  public static final int BLACK_PAWNS_START_RANK = 7;
  
  public Player(String name, Color color) {
    this.name = name;
    this.color = color;
    if (color == Color.BLACK)
      blackInit();
    else
      whiteInit();
  }
  
  public Color getColor() {
    return color;
  }
  
  private void blackInit() {
    pieces = new ArrayList<Piece>();
    for (String file : Square.FILES.split("")) {
      pieces.add(new Pawn(file + BLACK_PAWNS_START_RANK, Color.BLACK));
    }
    pieces.add(new Rook("a8", Color.BLACK));
    pieces.add(new Rook("h8", Color.BLACK));
    
    pieces.add(new Knight("b8", Color.BLACK));
    pieces.add(new Knight("g8", Color.BLACK));
    
    pieces.add(new Bishop("c8", Color.BLACK));
    pieces.add(new Bishop("f8", Color.BLACK));
    
    pieces.add(new Queen("d8", Color.BLACK));
    pieces.add(new King("e8", Color.BLACK));
  }
  
  private void whiteInit() {
    pieces = new ArrayList<Piece>();
    for (String file : Square.FILES.split("")) {
      pieces.add(new Pawn(file + WHITE_PAWNS_START_RANK, Color.WHITE));
      
    }
    pieces.add(new Rook("a1", Color.WHITE));
    pieces.add(new Rook("h1", Color.WHITE));
    
    pieces.add(new Knight("b1", Color.WHITE));
    pieces.add(new Knight("g1", Color.WHITE));
    
    pieces.add(new Bishop("c1", Color.WHITE));
    pieces.add(new Bishop("f1", Color.WHITE));
    
    pieces.add(new Queen("d1", Color.WHITE));
    pieces.add(new King("e1", Color.WHITE));
  }
  
  public List<Piece> getPieces() {
    return pieces;
  }
  
  public Optional<Piece> getPieceAt(Square square) {
    return pieces.stream().filter(piece -> piece.getPosition().equals(square)).findAny();
  }
    
}
