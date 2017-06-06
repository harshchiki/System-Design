package LRUCache;
import java.util.Objects;


/**
 * Insertion from tail
 * 
 * Deletion for head
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
	public void insert(LRUCacheListNode LRUCacheListNode) {
		if(tail == null && head == null){
			tail = head = LRUCacheListNode;			
		}else{
			if(size == MAX_SIZE){
				this.remove();
			}
			LRUCacheListNode nodeAtTail = tail;
			nodeAtTail.prev = LRUCacheListNode;
			LRUCacheListNode.next = nodeAtTail;
			tail = LRUCacheListNode;
		}
		size++;
	}

	@Override
	public LRUCacheListNode remove() {
		if(head == null){
			return null;
		}else{
			LRUCacheListNode nodeAtHead = head;
			nodeAtHead.prev.next = null;
			head = nodeAtHead.prev;
			nodeAtHead.prev = nodeAtHead.next = null;
			size--;
			return nodeAtHead;
		}
	}

	@Override
	public LRUCacheListNode removeLRUCacheListNode(LRUCacheListNode nodeToBeRemoved) {
		if(head == null && tail == null){
			return null;
		}

		LRUCacheListNode node = tail;
		while(node != null){
			if(Objects.equals(node, nodeToBeRemoved)){
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
