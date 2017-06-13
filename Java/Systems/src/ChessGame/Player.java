package ChessGame;

public class Player {
	public final String id;
	public final String name;
	
	public Player(final String id, final String name){
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString(){
		return this.name;
	}
	
}
