package leetcode3;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
	/** Initialize your data structure here. */
	Set<Integer> sum = null;
	Set<Integer> num = null;
	
    public TwoSum() {
        this.sum = new HashSet<Integer>();
        this.num = new HashSet<Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int a) {
        if(num.contains(a)) sum.add(2 * a);
        else { for(int i: num) sum.add(i + a); }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        return this.sum.contains(value);
    }
}
