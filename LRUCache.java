package leetcode3;

import java.util.HashMap;

public class LRUCache {
	public static void main(String[] args){
		LRUCache cache = new LRUCache(1);
		cache.set(2, 1);
		System.out.println(cache.get(2));
		cache.set(3, 2);
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		/*
		cache.set(0, 50);
		cache.set(1, 49);
		cache.set(2, 66);
		cache.set(3, 47);
		System.out.println(cache.get(0));
		System.out.println(cache.get(0));
		cache.set(3, 35);
		System.out.println(cache.get(3));
		System.out.println(cache.get(3));
		cache.set(4, 85);
		System.out.println(cache.get(4));*/
	}
	
	int cap;
	int length;
	doublyLinkedListNode head;
	doublyLinkedListNode tail;
	HashMap<Integer, doublyLinkedListNode> map  = null;
	
	public LRUCache(int capacity) {
		head = new doublyLinkedListNode(-999, -999);
		tail = new doublyLinkedListNode(-9999, -9999);
        this.cap = capacity;
        this.length = 0;
        head.next = tail;
        tail.next = head;
        head.prev =tail;
        tail.prev = tail;
        map  = new HashMap<Integer, doublyLinkedListNode>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
        	doublyLinkedListNode cur = map.get(key);
        	doublyLinkedListNode tmp1 = cur.prev;
        	doublyLinkedListNode tmp2 = cur.next;
        	tmp1.next = tmp2;
        	tmp2.prev = tmp1;
        	addNewNode(key, cur.value);
        	return cur.value;
        }else{
        	return -1;
        }
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
        	doublyLinkedListNode cur = map.get(key);
        	doublyLinkedListNode tmp1 = cur.prev;
        	doublyLinkedListNode tmp2 = cur.next;
        	tmp1.next = tmp2;
        	tmp2.prev = tmp1;
        	addNewNode(key, value);
        }else{
        	if(this.length < this.cap){
        		addNewNode(key, value);
        		this.length ++;
        	}else{
        		doublyLinkedListNode last = this.tail.prev;
        		doublyLinkedListNode pre_last = this.tail.prev.prev;
        		pre_last.next = tail;
        		tail.prev = pre_last;
        		map.remove(last.key);
        		addNewNode(key, value);
        	}
        	
        }
    }
    
    private void addNewNode(int key, int value){
    	doublyLinkedListNode tmp = head.next;
    	doublyLinkedListNode newNode = new doublyLinkedListNode(key, value);
    	head.next = newNode;
    	newNode.next = tmp;
    	tmp.prev = newNode;
    	newNode.prev = head;
    	map.put(key, newNode);
    }
    
    class doublyLinkedListNode{
		int key;
		int value;
		doublyLinkedListNode prev;
		doublyLinkedListNode next;
		
		public doublyLinkedListNode(int key, int value){
			this.key = key;
			this.value = value;
		}
	}
}
