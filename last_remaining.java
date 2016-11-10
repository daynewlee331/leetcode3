package leetcode3;

public class last_remaining {
	public int lastRemaining(int n) {
        int head = 1;
        boolean left = true; //mean from left to right
        int distance = 1;//distance between every two numbers
        int rem = n; //remaining numbers
        while(rem > 1){
            if(left || rem % 2 == 1){
                head = head + distance;
            }
            rem = rem / 2;
            left = !left;
            distance = distance * 2;
        }
        return head;
    }
}
