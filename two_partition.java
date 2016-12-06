package leetcode3;

public class two_partition {
	public static void main(String[] args){
		int[] test = {14,1,3,2,10};
		boolean res = partition(test);
		System.out.println(res);
	}
	
	public static boolean partition(int[] arr){
		int total = 0;
		for(int i = 0; i < arr.length; i ++){
			total += arr[i];
		}
		if(total % 2 != 0) return false;
		boolean[] part = new boolean[total + 1];
		part[0] = true;
		
		for(int i = 0; i < arr.length; i ++){
			for(int j = total - arr[i]; j>= 0; j --){
				if(part[j]) part[j + arr[i]] = true;
			}
		}
		
		return part[total / 2];
	}
}
