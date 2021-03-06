package leetcode3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PhoneDirectory {
	Queue<Integer> candidates = null;
	Set<Integer> used = null;
	int max = 0;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
    	candidates = new LinkedList<Integer>();
    	used = new HashSet<Integer>();
    	for(int i = 0; i < maxNumbers; i ++) candidates.offer(i);
    	max = maxNumbers - 1;
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(candidates.isEmpty()) return -1;
        int res = candidates.poll();
        used.add(res);
        return res;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
    	if(number < 0 || number > max) return false;
    	return !used.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(used.contains(number)){
        	used.remove(number);
        	candidates.offer(number);
        }
    }
}
