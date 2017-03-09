package leetcode3;

import java.util.HashSet;

public class Line_Reflection {
	public boolean isReflected(int[][] points) {
		if(points == null || points.length < 1) return false;
        HashSet<String> set = new HashSet<String>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int[] point: points){
        		int x = point[0], y = point[1];
        		min = Math.min(min, x);
        		max = Math.max(max, x);
        		set.add(x + "#" + y);
        }
        int sum = max + min;
        for(int[] point: points){
        		int x = point[0], y = point[1];
        		if(!set.contains(sum - x + "#" + y)) return false;
        }
        return true;
    }
}
