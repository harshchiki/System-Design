package ChessGame.pieces;

import java.util.Map;

public abstract class AbstractChessPiece {
	protected final PieceColor color;
	protected boolean isActive = true;
	protected Position position;
	final Map<Position, ChessPiece> chessMap;
	AbstractChessPiece(PieceColor color, Position position,
			final Map<Position, ChessPiece> chessMap){
		this.color = color;
		this.position = position;
		this.chessMap = chessMap;
	}
	
	public Position getPosition(){
		return this.position;
	}
}
