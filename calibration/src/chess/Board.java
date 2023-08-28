package chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Board {

  public static final int SIZE = 8;
  public static final int WHITE_PIECES_START_RANK = 1;
  public static final int BLACK_PIECES_START_RANK = 8;
  public static final int WHITE_PAWNS_START_RANK = 2;
  public static final int BLACK_PAWNS_START_RANK = 7;

  private Player black;
  private Player white;

  public Board(Player white, Player black) {
    this.white = white;
    this.black = black;
  }
  
  public boolean containsPiece(Square square) {
    return containsPiece(Color.WHITE, square) || containsPiece(Color.BLACK,square);
  }

  public boolean containsPiece(Color color, Square square) {
    List<Piece> pieces = color == Color.WHITE ? white.getPieces() : black.getPieces();
    return pieces.stream().filter(piece -> piece.getPosition().equals(square)).count() == 1;
  }

  private List<Move> filterOutOccupiedDestinations (List<Move> moves) {
    return moves.stream()
        .filter(move -> !containsPiece(move.getPiece().getColor(), move.getDestination()))
        .collect(Collectors.toList());
  }

  public List<List<Move>> getAllPossibleMoves(Player player) {
    return player.getPieces().stream()
        .map(piece -> piece.allowedMoves(this))
        .map(moves -> filterOutOccupiedDestinations(moves))
        .collect(Collectors.toList());
  }

  public boolean isBlackCheck() {
    Piece blackKing = black.getPieces().stream()
        .filter(piece -> piece.getClass() == King.class)
        .findAny().get();
    List<Piece> possibleChecks = white.getPieces().stream()
        .filter(piece -> piece.canKill(blackKing, this))
        .collect(Collectors.toList());
    return possibleChecks.size() > 0;
  }

  public boolean isBlackCheckMate() {
    boolean isCheckmate = true;
    //Piece blackKing = black.getPieces().stream()
    //    .filter(piece -> piece.getClass() == King.class)
    //    .findAny().get();
    //List<Move> possibleKingMoves = blackKing.allowedMoves();
    //possibleKingMoves = possibleKingMoves.stream()
    //    .filter(move -> !containsPiece(Color.BLACK, move.getDestination()))
    //    .collect(Collectors.toList());
    //if (possibleKingMoves.size() == 0)
    //  return true;
    List<List<Move>> allMoves = getAllPossibleMoves(black);
    for (List<Move> pieceMoves : allMoves) {
      for (Move move : pieceMoves) {
        move.attempt();
        if (!isBlackCheck()) {
          isCheckmate = false;
        }
        move.rollBack();
      }
    }
    return isCheckmate;
  }
  
  public Optional<Piece> getPieceAt(Square square) {
    List<Piece> allPieces = new ArrayList<Piece>();
    allPieces.addAll(white.getPieces());
    allPieces.addAll(black.getPieces());
    return allPieces.stream()
        .filter(piece -> piece.getPosition().equals(square))
        .findAny();
  }
  
  @Override
  public String toString() {
    String out = "";
    List<Square[]> allSquares = Arrays.asList(Square.getAllSquares());
    Collections.reverse(allSquares);
    for (Square[] row : allSquares) {
      out += "| ";
      for (Square square : row) {
        Optional<Piece> pieceAtSquare = getPieceAt(square);
        String symbol = pieceAtSquare.isPresent() ? 
            pieceAtSquare.get().getUnicodeSymbol() : " ";
        out += String.format(" %s |", symbol);
      }
      out += "\n_________________________________\n";
    }
    return out;
  }
}
