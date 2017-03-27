package leetcode3;

public class Counting_Bits {
	public int[] countBits(int num) {
        if(num < 0) return new int[0];
        int[] res = new int[num + 1];
        res[0] = 0;
        for(int i = 1; i <= num; i ++){
        		res[i] = res[i / 2] + i % 2;
        }
        return res;
    }
}
