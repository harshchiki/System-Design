package ChessGame.pieces;

public class Position {
	public int x, y;
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}

	
	public boolean equals(Object o){
		Position other = (Position) o;
		return this.x == other.x && this.y == other.y;
	}
	
	public int hashCode(){
		// for eg. 3,4 -> 34's hashCode.
		return Integer.valueOf(x*10+y).hashCode();
	}
}
