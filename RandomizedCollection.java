package leetcode3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomizedCollection {
	ArrayList<Integer> values = null;
	HashMap<Integer, Set<Integer>> valToIdx = null;
	Random rand = null;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        values = new ArrayList<Integer>();
        valToIdx = new HashMap<Integer, Set<Integer>>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
    	boolean res = this.valToIdx.containsKey(val);
    	this.values.add(val);
        if(this.valToIdx.containsKey(val)){
        	this.valToIdx.get(val).add(this.values.size() - 1);
        }else{
        	Set<Integer> indexSet = new HashSet<Integer>();
        	indexSet.add(this.values.size() - 1);
        	this.valToIdx.put(val, indexSet);
        }
        return res;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
    	if(!this.valToIdx.containsKey(val)) return false;
    	int loc = this.valToIdx.get(val).iterator().next();
    	this.valToIdx.get(val).remove(loc);
    	if(loc < this.values.size() - 1){
    		int lastOne = this.values.get(values.size() - 1);
    		valToIdx.get(lastOne).remove(values.size() - 1);
    		values.set(loc, lastOne);
    		valToIdx.get(lastOne).add(loc);
    	}
    	values.remove(this.values.size() - 1);
    	if(valToIdx.get(val).isEmpty()) valToIdx.remove(val);
    	return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
    	int index = this.rand.nextInt(this.values.size());
        return this.values.get(index);
    }
}
