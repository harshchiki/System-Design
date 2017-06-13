package ChessGame;

import ChessGame.pieces.Position;

public interface MoveStrategy {
	boolean isValidMove(Position from, Position to);
	void move(Position from, Position to);
	void updateScore(int currentScore);
}
