package leetcode3;

public class sqrt {
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		sqrt s = new sqrt();
		s.mySqrt(8);
	}

	//binary search my sqrt instead of newton ...
	public int mySqrt(int x) {
		if (x == 0) return 0;
		if (x < 0) return x;
		long lo = 1, hi = x / 2 + 1;
		long y = x;
		while (lo <= hi) {
			long num = (int) ((double) lo / 2 + (double) hi / 2);
			if (num * num == y)
				return (int) num;
			else if (num * num > y)
				hi = num;
			else {
				if ((num + 1) * (num + 1) > y)
					return (int) num;
				else
					lo = num;
			}
		}
		return 0;
	}
}
