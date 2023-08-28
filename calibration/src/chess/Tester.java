package chess;

import java.util.Arrays;

public class Tester {
  public static void main(String[] args) throws Exception {
    Pawn whitePawn = new Pawn("a2", Color.WHITE);
    Knight whiteKnight = new Knight("b1", Color.WHITE);
    Queen whiteQueen = new Queen("a1", Color.WHITE);
    
    Player white = new Player("Aruvi", Color.WHITE);
    System.out.println(white.getPieces());
    Player black = new Player("Vinay", Color.BLACK);
    Board board = new Board(white, black);
    System.out.println(whitePawn.canMoveTo(Square.of("b4"), board));
    System.out.println(whiteKnight.canMoveTo(Square.of("d1"), board));
    System.out.println(whiteQueen.allowedMoves(board));
    
    
    Piece whiteKingsPawn = white.getPieceAt(Square.of("e2")).get();
    Move whiteOpener = new Move(whiteKingsPawn, Square.of("e4"), board);
    whiteOpener.commit();
    
    Piece blackKingsPawn = black.getPieceAt(Square.of("d7")).get();    
    Move blackOpener = new Move(blackKingsPawn, Square.of("d6"), board);
    blackOpener.commit();
    
    
    Piece whitesBishop = white.getPieceAt(Square.of("f1")).get();
    Move whiteAttack = new Move(whitesBishop, Square.of("b5"), board);
    whiteAttack.commit();
    
    Piece blacksSavingQueen = black.getPieceAt(Square.of("d8")).get();
    System.out.println(black.getPieces());
    System.out.println(blacksSavingQueen.allowedMoves(board));
    System.out.println(blacksSavingQueen.canMoveTo(Square.of("d7"), board));
    
    //blacksSavingQueen.setPosition(Square.of("d7"));
    
    System.out.println(blackKingsPawn);
    System.out.println(whitesBishop);
    System.out.println(board.isBlackCheck());
    System.out.println(board.isBlackCheckMate());
    System.out.println(board);
    for (Square[] row : Square.getAllSquares())
      System.out.println(Arrays.toString(row));
    
    Pawn p = new Pawn("a2", Color.BLACK);
    Piece[] pieceArr = new Piece[2];
    pieceArr[0] = p;
    
    Box<Piece> pieceBox = new Box<>();
    pieceBox.unlock();
    pieceBox.setValue(p);
    
    Box<Pawn> pawnBox = new Box<>();
    pawnBox.unlock();
    pawnBox.setValue(whitePawn);
    
    pieceBox.transferFrom(pawnBox);
    
    System.out.println(pieceBox.getClass());
    System.out.println(pawnBox.getClass());
    
    System.out.println(p);
  }
}
