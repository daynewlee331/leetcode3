package leetcode3;

import java.util.HashSet;

public class gas_cost_route {
	public int canCompleteCircuit2(int[] gas, int[] cost) {
		int sum = 0;
		int start = 0;
		int total = 0;
		for(int j = 0; j < gas.length - 1; j ++){
			total += gas[j] - cost[j];
			sum += gas[j] - cost[j];
			if(sum < 0){
				sum = 0;
				start = j + 1;
			}
		}
		return total < 0? -1 : start;
	}
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int start = 0; start < gas.length; start ++){
            if(canReach(start, gas, cost)) return start;
        }
        return -1;
    }
    
    public boolean canReach(int start , int[] gas, int[] cost){
        int left = 0;
        for(int i = start; i < gas.length; i ++){
            left = left + gas[i] - cost[i];
            if(left < 0) return false;
        }
        
        for(int j = 0; j < start; j ++){
            left = left + gas[j] - cost[j];
            if(left < 0) return false;
        }
        
        return true;
    }
}
