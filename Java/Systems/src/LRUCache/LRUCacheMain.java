package LRUCache;

public class LRUCacheMain {
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		Page p1 = new Page("P1");
		cache.getPage(p1);
		cache.printCache();
		System.out.println();
		System.out.println("After P1");
		Page p2 = new Page("P2");
		cache.getPage(p2);
		cache.printCache();
		System.out.println();
		System.out.println("After P2");
		Page p3 = new Page("P3");
		cache.getPage(p3);
		cache.printCache();
		System.out.println();
		System.out.println("After P3");
		Page p4 = new Page("P4");
		cache.getPage(p4);
		cache.printCache();
		System.out.println();
		System.out.println("After P4");
	}
}
