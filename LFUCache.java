package leetcode3;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
	public static void main(String[] args){
		LFUCache sol = new LFUCache(2);
		sol.put(1,1);
		sol.put(2,2);
		System.out.println(sol.get(1));
		sol.put(3,3);
		System.out.println(sol.get(2));
		System.out.println(sol.get(3));
		sol.put(4,4);
	}
	
	HashMap<Integer, Integer> keyToVals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> lists;
    int cap;
    int min = -1;
    
    public LFUCache(int capacity) {
    	keyToVals = new HashMap<Integer, Integer>();
        counts = new HashMap<Integer, Integer>();
        lists = new HashMap<Integer, LinkedHashSet<Integer>>();
        cap = capacity;
        lists.put(1, new LinkedHashSet<Integer>());
    }
    
    public int get(int key) {
        if(!keyToVals.containsKey(key)) return -1;
        int count = counts.get(key);
        counts.put(key, count + 1);
        lists.get(count).remove(key);
        if(count == min && lists.get(count).size() == 0) min = count + 1;
        if(!lists.containsKey(count + 1)) lists.put(count + 1, new LinkedHashSet<Integer>());
        lists.get(count + 1).add(key);
        return keyToVals.get(key);
    }
    
    public void put(int key, int value) {
    	if(cap <= 0) return;
        if(this.keyToVals.containsKey(key)){
        	this.keyToVals.put(key, value);
        	get(key);
        	return;
        }
        if(this.keyToVals.size() >= cap){
        	int old = this.lists.get(min).iterator().next();
        	this.keyToVals.remove(old);
        	this.lists.get(min).remove(old);
        }
        this.keyToVals.put(key, value);
        this.counts.put(key, 1);
        this.lists.get(1).add(key);
        min = 1;
    }
}
