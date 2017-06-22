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

	/*
	 * 
	 * (non-Javadoc)
	 * @see LRUCache.Cache#getPage(LRUCache.Page)
	 */
	@Override
	public Page getPage(Page searchPage) {
		/*
		 * lookup the cache whether the page exists.
		 */
		if(null != searchPage && hashMap.containsKey(searchPage)){
			Page page = hashMap.get(searchPage.hashCode()).page;
			/*
			 * Since the page is referred, and becomes the most recently used page,
			 * so bringing it to head.
			 */
			list.bringToHead(hashMap.get(searchPage.hashCode())); // hashcode would not change and so not changing the hashmap
			return page;
		}else{
			return lookupRemoveAdd(searchPage);
		}
	}
	
	private Page lookupRemoveAdd(Page page){
		
		/*
		 * Removing the least recently used node (oldest) when the size of the cache is full
		 * has to be removed from both the list and the hashMap.
		 */
		if(CACHE_SIZE == list.size()){
			LRUCacheListNode removedNode = list.remove();
			Page removedPage = removedNode!= null? removedNode.page:null;
			
			if(null != removedPage){
				hashMap.remove(System.identityHashCode(removedPage));
			}
		}
		
		/* the requested page is added (in ideal scenarios this
		 * would be from the underlying data store. 
		 */
		LRUCacheListNode addedNode = new LRUCacheListNode(page);
		list.insert(addedNode);
		hashMap.put(System.identityHashCode(page), addedNode);
		
		/*
		 * The fetched page from the underlying data store (in this case overlooked)
		 * is added to both the list and hashmap (in the code segment just above)
		 * and returned.
		 * 
		 * This page is the most recently used page, and qualifies to e removed the last 
		 * of all the existing frames
		 */
		return page;
	}

	@Override
	public void printCache() {
		this.list.printList();
	}

}
