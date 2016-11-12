package leetcode3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class inside_trader {
	static class info {
		int day;
		String name;

		info(int a, String b) {
			this.day = a;
			this.name = b;
		}
	}

	static class trade {
		int day;
		String name;
		String type;
		double amount;

		public trade(int a, String b, String c, double d) {
			this.day = a;
			this.name = b;
			this.type = c;
			this.amount = d;
		}
	}

	public static void main(String[] args) {
		String[] test = { "0|20", "0|Kristi|SELL|3000", "0|Will|BUY|5000", "0|Tom|BUY|50000", "0|Shilpa|BUY|1500",
				"1|Tom|BUY|1500000", "3|25", "5|Shilpa|SELL|1500", "8|Kristi|SELL|600000", "9|Shilpa|BUY|500", "10|15",
				"11|5", "14|Will|BUY|100000", "15|Will|BUY|100000", "16|Will|BUY|100000", "17|25" };
		String[] test2 = { "0|10", "0|Kristi|BUY|250000", "0|Will|BUY|50000", "0|Tom|SELL|30000", "0|Shilpa|BUY|210000",
				"1|25", "1|Shilpa|BUY|100000", "2|35", "2|Kristi|SELL|200000", "3|5" };
		String [] test3 = {
				"0|1000",
				"0|Shilpa|BUY|30000",
				"0|Will|BUY|50000",
				"0|Tom|BUY|40000",
				"0|Kristi|BUY|15000",
				"1|Kristi|BUY|11000",
				"1|Tom|BUY|1000",
				"1|Will|BUY|19000",
				"1|Shilpa|BUY|25000",
				"2|1500",
				"2|Will|SELL|7000",
				"2|Shilpa|SELL|8000",
				"2|Kristi|SELL|6000",
				"2|Tom|SELL|9000",
				"3|500",
				"38|1000",
				"78|Shilpa|BUY|30000",
				"79|Kristi|BUY|60000",
				"80|1100",
				"81|1200"
		};
		String[] s = findPotentialInsiderTraders(test3);
		for (String st : s) {
			System.out.println(st);
		}
	}

	private static void parseData(String[] datafeed, ArrayList<trade> trades, HashMap<Integer, Integer> map) {
		for (int i = 0; i < datafeed.length; i++) {
			String[] arr = datafeed[i].split("\\|");
			// trade t = null;
			if (arr.length == 2) {
				map.put(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
			} else if (arr.length == 4) {
				trade t = new trade(Integer.parseInt(arr[0]), arr[1], arr[2], Double.parseDouble(arr[3]));
				trades.add(t);
			}
		}
	}

	public static String[] findPotentialInsiderTraders(String[] datafeed) {
		ArrayList<trade> trades = new ArrayList<trade>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<info> res = new ArrayList<info>();
		int dayLimit = 0;
		for (int i = 0; i < datafeed.length; i++) {
			String[] arr = datafeed[i].split("\\|");
			// trade t = null;
			if (arr.length == 2) {
				dayLimit = Integer.parseInt(arr[0]);
				map.put(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
			} else if (arr.length == 4) {

				trade t = new trade(Integer.parseInt(arr[0]), arr[1], arr[2], Double.parseDouble(arr[3]));
				trades.add(t);
			}
		}
		int limit = 5000000;
		for (trade tr : trades) {
			int day = tr.day;
			while (!map.containsKey(day)) {
				day--;
			}
			int after3days = day + 3;
			int priceBefore = map.get(day);

			if (map.containsKey(day)) {
				while (day <= after3days) {
					day++;
					// looking for price after 3 days
					while (!map.containsKey(day) && day <= dayLimit) {
						day++;
					}
					if (map.containsKey(day)) {
						int priceAfter = map.get(day);
						if (tr.type.equals("SELL")) {
							if (Math.abs(priceAfter * tr.amount - priceBefore * tr.amount) >= limit) {
								info i = new info(tr.day, tr.name);
								if (!res.contains(res)) {
									res.add(i);
								}
							}
						} else if (tr.type.equals("BUY")) {
							if (priceAfter * tr.amount - priceBefore * tr.amount >= limit) {
								info i = new info(tr.day, tr.name);
								if (!res.contains(res)) {
									res.add(i);
								}
							}
						}
					}
				}
			}

		}
		Collections.sort(res, new Comparator<info>() {

			@Override
			public int compare(info o1, info o2) {
				Integer x1 = o1.day;
				Integer x2 = o2.day;
				int sComp = x1.compareTo(x2);
				if (sComp != 0) {
					return sComp;
				} else {
					String s1 = o1.name;
					String s2 = o2.name;
					return s1.compareTo(s2);
				}
			}
		});

		String[] resArr = new String[res.size()];
		StringBuilder b = null;
		for (int i = 0; i < res.size(); i++) {
			b = new StringBuilder();
			b.append(res.get(i).day);
			b.append("|");
			b.append(res.get(i).name);
			resArr[i] = b.toString();
		}

		return resArr;
	}
}
