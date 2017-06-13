package ChessGame.pieces;

import java.util.Map;

import ChessGame.MoveStrategy;

public class Bishop extends AbstractChessPiece implements ChessPiece {
	MoveStrategy moveStrategy = new BishopMoveStrategy(this);
	
	public Bishop(final PieceColor pieceColor, 
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
		moveStrategy.move(this.position, to);
	}

	@Override
	public boolean isActive() {
		return this.isActive;
	}


	class BishopMoveStrategy implements MoveStrategy{
		private final ChessPiece piece;
		
		BishopMoveStrategy(ChessPiece piece){
			this.piece = piece;
		}

		@Override
		public boolean isValidMove(Position from, Position to) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void move(Position from, Position to) {
			if(this.isValidMove(from, to)){
				if(chessMap.containsKey(to)){
					System.out.println(" Removing "+chessMap.get(to));					
				}
				chessMap.put(to, this.piece);;
			}else{
				// exception - invalid move;
			}
		}

		@Override
		public void updateScore(int currentScore) {
			// TODO Auto-generated method stub

		}
	}

}
