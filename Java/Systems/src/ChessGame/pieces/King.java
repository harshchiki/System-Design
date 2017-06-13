package ChessGame.pieces;

import java.util.Map;

public class King extends AbstractChessPiece implements ChessPiece {
	
	public King(final PieceColor pieceColor,
			final Position position, final Map<Position, ChessPiece> chessMap){
		super(pieceColor, position, chessMap);
	}
	
	@Override
	public PieceColor getPieceColor() {
		return this.color;
	}

	@Override
	public void move(Position to) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isActive() {
		return this.isActive;
	}

}
