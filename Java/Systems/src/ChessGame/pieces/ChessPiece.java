package ChessGame.pieces;

public interface ChessPiece {
	PieceColor getPieceColor();
	void move(Position to);
	boolean isActive();
	Position getPosition();
}
