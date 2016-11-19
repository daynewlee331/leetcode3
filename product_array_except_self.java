package leetcode3;

public class product_array_except_self {
	public static void main(String[] args){
		int[] test = {1,2,3,4};
		product_array_except_self p = new product_array_except_self();
		p.productExceptSelf(test);
	}
	
	//e.g an array of 4 elements
	//{              1,         a[0],    a[0]*a[1],    a[0]*a[1]*a[2],  }
	//{ a[1]*a[2]*a[3],    a[2]*a[3],         a[3],                 1,  }
	public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i = 1; i < res.length ; i ++){
        	res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for(int j = res.length - 1; j >= 0; j --){
        	res[j] *= right;
        	right *= nums[j];
        }
        return res;
    }
}
