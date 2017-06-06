package LRUCache;

public interface LRUCachList {
	LRUCacheListNode getHead();
	LRUCacheListNode getTail(); // by default from tail
	void insert(LRUCacheListNode LRUCacheListNode);
	LRUCacheListNode remove(); // by default from head
	LRUCacheListNode removeLRUCacheListNode(LRUCacheListNode LRUCacheListNode);
	void bringToHead(LRUCacheListNode LRUCacheListNode);
	int size();
	void printList();
}
