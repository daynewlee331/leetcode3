package leetcode3;

import java.util.Arrays;
import java.util.Comparator;

public class meeting_room_one {
	class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	//leetcode 252: meeting rooms 1
	public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
        	
        });
        
        for(int i = 0; i + 1 < intervals.length; i ++){
        	if(intervals[i + 1].start < intervals[i].end){
        		return false;
        	}
        }
        
        return true;
    }
}
