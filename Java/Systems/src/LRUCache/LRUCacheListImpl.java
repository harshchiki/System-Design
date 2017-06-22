package LRUCache;
import java.util.Objects;


/**
 * Insertion from tail - MOST RECENTLY USED
 * 	- on insert
 * 	- on use of a page
 * 
 * Deletion for head - LEAST RECENTLY USED
 * 
 * @author Harsh
 *
 */
public class LRUCacheListImpl implements LRUCachList {
	private final int MAX_SIZE;
	private LRUCacheListNode head, tail;
	private int size;

	public LRUCacheListImpl(final int size){
		this.MAX_SIZE = size;
	}

	@Override
	public LRUCacheListNode getHead() {
		return this.head;
	}

	@Override
	public LRUCacheListNode getTail() {
		return this.tail;
	}

	@Override
	public void insert(LRUCacheListNode lRUCacheListNode) {
		if(tail == null && head == null){
			// list is empty
			tail = head = lRUCacheListNode;			
		}else{
			if(size == MAX_SIZE){
				// list is full
				this.remove();
			}
			
			// insertion to made at the tail
			// this denotes the most recently used node
			LRUCacheListNode nodeAtTail = tail;
			nodeAtTail.prev = lRUCacheListNode;
			lRUCacheListNode.next = nodeAtTail;
			tail = lRUCacheListNode;
		}
		// maintain size
		size++;
	}

	@Override
	public LRUCacheListNode remove() {
		if(head == null){
			// empty list 
			return null;
		}else{
			// making the head point to the node prev to the current head.
			LRUCacheListNode nodeAtHead = head;
			nodeAtHead.prev.next = null;
			head = nodeAtHead.prev;
			nodeAtHead.prev = nodeAtHead.next = null;
			//maintain size
			size--;
			return nodeAtHead;
		}
	}

	@Override
	public LRUCacheListNode removeLRUCacheListNode(LRUCacheListNode nodeToBeRemoved) {
		if(head == null && tail == null){
			// empty list
			return null;
		}
		// take the reference of the tail - and keep moving forward until null
		LRUCacheListNode node = tail;
		while(node != null){
			if(node.equals(nodeToBeRemoved)){
				// node to be removed is found
				LRUCacheListNode prevNode = node.prev;
				LRUCacheListNode nxtNode = node.next;

				if(null != prevNode){					
					//first node found
					prevNode.next = nxtNode;
				}

				// node could have been found in the end
				if(null != nxtNode){
					nxtNode.prev = prevNode;
				}

				if(prevNode == null && nxtNode == null){
					tail =  head = null;
				}
				
				if(prevNode == null && nxtNode != null){
					tail = nxtNode;
				}
				
				if(prevNode != null && nxtNode == null){
					head = prevNode;
				}
				
				size--;
				node.next = node.prev = null;
				return node;
			}
			node = node.next;
		}
		return null;

	}

	/*
	 * remove the node and insert to the list
	 * (non-Javadoc)
	 * @see LRUCache.LRUCachList#bringToHead(LRUCache.LRUCacheListNode)
	 */
	@Override
	public void bringToHead(LRUCacheListNode nodeToBeBroughtForward) {
		LRUCacheListNode removedNode = this.removeLRUCacheListNode(nodeToBeBroughtForward);
		this.insert(removedNode);
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void printList() {
		if(this.head == null){
			return;
		}
		
		LRUCacheListNode node = tail;
		while(node!=null){
			System.out.print(node.page.content+ ", ");
			node = node.next;
		}
	}




}

class LRUCacheListNode{
	Page page;
	LRUCacheListNode next = null, prev = null;
	public LRUCacheListNode(Page page) {
		this.page = page;
	}

	@Override
	public boolean equals(Object o){
		return Objects.equals(this.page, ((LRUCacheListNode) o).page);
	}
	
	@Override
	public int hashCode(){
		return System.identityHashCode(this.page);
	}
}
