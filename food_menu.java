package leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class food_menu {
	public static void main(String[] args) {
		food_menu sol = new food_menu();
		double[] prices = { 0.32, 1.30, 3.37, 0.65, 0.95, 2.30 };
		List<List<Double>> result = sol.price_combo(prices, 2.57);
		for (int i = 0; i < result.size(); i++) {
			System.out.println("Combination " + i + ":");
			for (int j = 0; j < result.get(i).size(); j++)
				System.out.print(result.get(i).get(j) + ", ");
			System.out.println();
		}
	}
	
	public List<List<Double>> price_combo(double[] prices, double target){
		List<List<Double>> res = new ArrayList<List<Double>>();
		if(prices == null || prices.length < 1 || target == 0) return res;
		int[] tmp = new int[prices.length];
		for(int i = 0; i < prices.length; i ++){
			tmp[i] = (int) (prices[i] * 100);
		}
		Arrays.sort(tmp);
		DFS(res, (int)(target * 100), tmp, new ArrayList<Integer>());
		return res;
	}
	
	public void DFS(List<List<Double>> res, int target, int[] prices, List<Integer> cur){
		if(target < 0) return;
		if(target == 0){
			List<Double> sub = new ArrayList<Double>();
			for(Integer num: cur){
				sub.add(num / 100.0);
			}
			res.add(sub);
			return;
		}
		for(int i = 0; i < prices.length; i ++){
			cur.add(prices[i]);
			DFS(res, target - prices[i], prices, cur);
			cur.remove(cur.size() - 1);
		}
	}
}
