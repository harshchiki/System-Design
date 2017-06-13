package ChessGame.pieces;

import java.util.Map;

public class Queen extends AbstractChessPiece implements ChessPiece {
	
	public Queen(final PieceColor pieceColor,
			final Position position,
			final Map<Position, ChessPiece> chessMap){
		super(pieceColor, position, chessMap);
	}
	@Override
	public PieceColor getPieceColor() {
		return this.color;
	}

	@Override
	public boolean isActive() {
		return this.isActive;
	}
	@Override
	public void move(Position to) {
		// TODO Auto-generated method stub
		
	}

}
