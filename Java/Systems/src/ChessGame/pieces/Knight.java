package ChessGame.pieces;

import java.util.Map;

public class Knight extends AbstractChessPiece implements ChessPiece {
	
	public Knight(final PieceColor pieceColor,
			final Position position,
			final Map<Position, ChessPiece> chessMap){
		super(pieceColor, position, chessMap);
	}
	@Override
	public PieceColor getPieceColor() {
		return this.color;
	}

	@Override
	public void move(Position to) {
		
	}
	@Override
	public boolean isActive() {
		return this.isActive;
	}

}
