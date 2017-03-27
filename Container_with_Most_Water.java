package leetcode3;

public class Container_with_Most_Water {
	public int maxArea(int[] height) {
        if(height == null || height.length < 1) return 0;
        int i = 0, j = height.length - 1, max = 0;
        while(i < j){
        		max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
        		if(height[i] < height[j]) i ++;
        		else j --;
        }
        return max;
    }
}
