package leetcode3;

public class my_pow {
	public static void main(String[] args){
		System.out.println(Integer.MIN_VALUE >> 1);
	}
	
	public double myPow(double x, int n) {
        if (n == 0) return 1;
		if (n == 1) return x;
		
		if(n< 0&& n>Integer.MIN_VALUE) return 1/myPow(x,-n);
        else if(n==Integer.MIN_VALUE)   {
        	int m = n >> 1;
        	return 1/myPow(x*x, -m);
        }
		
		double tmp = myPow(x, n >> 1);
		if (n % 2 == 0) return tmp * tmp;
		else return tmp * tmp * x;
    }
}
