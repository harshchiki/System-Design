package LRUCache;
import java.util.HashMap;

public class LRUCache implements Cache {
	
	private LRUCachList list;
	private HashMap<Integer, LRUCacheListNode> hashMap;
	private final int CACHE_SIZE;
	private int currentSize = 0;
	
	public LRUCache(int size){
		this.CACHE_SIZE = size;
		this.list = new LRUCacheListImpl(size); 
		hashMap = new HashMap<Integer, LRUCacheListNode>(size);
	}

	@Override
	public Page getPage(Page searchPage) {
		if(null != searchPage && hashMap.containsKey(searchPage)){
			return hashMap.get(System.identityHashCode(searchPage)).page;
		}else{
			return lookupRemoveAdd(searchPage);
		}
	}
	
	private Page lookupRemoveAdd(Page page){
		
		if(CACHE_SIZE == list.size()){
			LRUCacheListNode removedNode = list.remove();
			Page removedPage = removedNode!= null? removedNode.page:null;
			
			if(null != removedPage){
				hashMap.remove(System.identityHashCode(removedPage));
			}
		}
		
		LRUCacheListNode addedNode = new LRUCacheListNode(page);
		list.insert(addedNode);
		hashMap.put(System.identityHashCode(page), addedNode);
		
		return page;
	}

	@Override
	public void printCache() {
		this.list.printList();
	}

}
