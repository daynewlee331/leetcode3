package leetcode3;

public class MovingAverage {
	private int[] elements = null;
	private int insert = 0;
	private long total = 0;
	private int count = 0;
	/** Initialize your data structure here. */
    public MovingAverage(int size) {
    	insert = 0;
        total = 0;
        elements = new int[size];
    }
    
    public double next(int val) {
    	if(count < elements.length) count ++;
    	total -= elements[insert];
    	total += val;
    	elements[insert] = val;
    	insert = (insert + 1) % elements.length;
    	return total * 1.0 / count;
    }
}
