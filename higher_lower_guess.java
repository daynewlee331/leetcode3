package leetcode3;

public class higher_lower_guess {
	public int guessNumber(int n) {
        if(n == 1) return 1;
        long i = 1;
        long j = n;
        while(i <= j){
            long mid = (i + j) / 2;
            int flag = guess((int)mid);
            if(flag == 0){
                return (int)mid;
            }else if(flag > 0){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        return 0;
    }
	
	public int guess(int mid){
		return 0;
	}
}	
