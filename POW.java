package leetcode3;

public class POW {
	public double myPow(double x, int n) {
        if(n == 0) return 1;
		int one = 1;
		if(n == Integer.MIN_VALUE) {
			n = n + 1;
			if(x < 0) x = -x;
		}
		if(n < 0) {n = -n; one = -1;}
		Double res = null;
		if(n % 2 == 0) res = myPow(x * x, n / 2);
		else res = x * myPow(x * x, n / 2);
		return one == 1? res: 1 / res;
    }
}
