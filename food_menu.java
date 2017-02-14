package leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class food_menu {
	public static void main(String[] args) {
		food_menu sol = new food_menu();
		double[] prices = { 0.32, 1.30, 3.37, 0.65, 0.95, 2.30 };
		List<List<Double>> result = sol.getAllCombo(prices, 2.57);
		for (int i = 0; i < result.size(); i++) {
			System.out.println("Combination " + i + ":");
			for (int j = 0; j < result.get(i).size(); j++)
				System.out.print(result.get(i).get(j) + ", ");
			System.out.println();
		}
	}
	
	public List<List<Double>> getAllCombo(double[] prices, double target){
		List<List<Double>> res = new ArrayList<List<Double>>();
		int[] tmp = new int[prices.length];
		for(int i = 0; i < prices.length; i ++){
			tmp[i] = (int)(prices[i] * 100);
		}
		Arrays.sort(tmp);
		getCombo(tmp, (int)(target * 100), res, new ArrayList<Integer>(), 0);
		return res;
	}
	
	public void getCombo(int[] prices, int target, List<List<Double>> res, List<Integer> cur, int start){
		if(target < 0) return;
		if(target == 0) {
			List<Double> sub = new ArrayList<Double>();
			for(int e: cur) sub.add(e / 100.0);
			res.add(sub);
			return;
		}
		for(int i = start; i < prices.length; i ++){
			cur.add(prices[i]);
			getCombo(prices, target - prices[i], res, cur, i);
			cur.remove(cur.size() - 1);
		}
	}
}
