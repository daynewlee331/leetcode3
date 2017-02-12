package leetcode3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class round_sum {
	public static void main(String[] args){
		double[] test1 = {30.3, 2.4, 3.5};
		double[] test2 = {30.9, 2.4, 3.9};
		
		round_sum sol = new round_sum();
		int[] a = sol.getRounded(test1);
		int[] b = sol.getRounded(test2);
		
		for(int num: b){
			System.out.print(num + " ");
		}
	}
	
	class RoundedNum{
		int index;
		double val;
		RoundedNum(int i, double v){
			this.index = i;
			this.val = v;
		}
	}
	
	/*
	 * Example1:
	 * input = 30.3, 2.4, 3.5
	 * output = 30 2 4
	 * 
	 * Example2:
	 * input = 30.9, 2.4, 3.9
	 * output = 31 2 4
	 * */
	
	public int[] roundNumsTwo(double[] a) {
		if (a == null || a.length < 1) return new int[0];
		int[] res = new int[a.length];
		double originSum = 0;
		long floorSum = 0;
		PriorityQueue<RoundedNum> pq = new PriorityQueue<>(new Comparator<RoundedNum>(){
			@Override
			public int compare(RoundedNum o1, RoundedNum o2) {
				// TODO Auto-generated method stub
				if(o2.val > o1.val) return 1;
				else if(o2.val < o1.val) return -1;
				else return 0;
			}
		});
		for (int i = 0; i < a.length; i++) {
			floorSum += (int) a[i];
			originSum += a[i];
			res[i] = (int) a[i];
			pq.offer(new RoundedNum(i, a[i] - (int)a[i]));
		}
		double remaining = (int)(Math.round(originSum) - floorSum);
		for(int i = 0; i < remaining; i ++){
			RoundedNum tmp = pq.poll();
			res[tmp.index] ++;
		}
		return res;
	}
	
	public int[] getRounded(double[] nums){
		int[] res = new int[nums.length];
		RoundedNum[] list = new RoundedNum[nums.length];
		double sumOrigin = 0;
		double sumRound = 0;
		for(int i = 0; i < res.length; i ++){
			res[i] = (int)nums[i];
			sumOrigin += nums[i];
			sumRound += res[i];
			String decimal = String.format("%.1f", nums[i] - Math.floor(nums[i]));
			list[i] = new RoundedNum(i, Double.parseDouble(decimal));
		}
		double remaining = Math.round(sumOrigin) - sumRound;
		Arrays.sort(list, new Comparator<RoundedNum>(){
			@Override
			public int compare(RoundedNum o1, RoundedNum o2) {
				// TODO Auto-generated method stub
				if(o1.val > o2.val) return -1;
				else if(o1.val < o2.val) return 1;
				else return 0;
			}});
		
		for(int i = 0; i < remaining; i ++){
			res[list[i].index] ++;
		}
		return res;
	}
}
