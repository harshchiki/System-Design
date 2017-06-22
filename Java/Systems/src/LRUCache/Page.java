package LRUCache;

public class Page {
	final String content;
	public Page(String content){
		this.content = content;
	}
	
	public int hashCode(){
		return this.content.hashCode(); // returns 0 if reference is null
	}
}
