package leetcode3;

import java.util.List;

public class coin_change {
	/*
	 * For the iterative solution, we think in bottom-up manner. 
	 * Suppose we have already computed all the minimum counts up to sum, 
	 * what would be the minimum count for sum+1?
	 * */
	public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length < 1 || amount <= 0) return 0;
        int[] dp = new int[amount + 1];
        int sum = 1;
        while(sum <= amount ){
        	int min = -1;
        	for(int coin: coins){
        		if(sum >= coin && dp[sum - coin] >= 0){
        			int tmp = dp[sum - coin] + 1;
        			if(min < 0) min = tmp;
        			else min = Math.min(tmp, min);
        		}
        		dp[sum] = min;
        	}
        	sum ++;
        }
        return dp[amount];
    }
}
