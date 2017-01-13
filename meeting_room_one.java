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
	
	//leetcode 253: meeting rooms 2
	public int minMeetingRooms(Interval[] intervals) {
		if(intervals == null || intervals.length < 1) return 0;
		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		for(int i = 0; i < intervals.length; i ++){
			starts[i] = intervals[i].start;
			ends[i] = intervals[i].end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		int rooms = 0;
		int endsItr = 0;
		//if no starting events left, no rooms needed, jump out of loop
		for(int i = 0; i < starts.length; i ++){
			if(starts[i] < ends[endsItr]){
				rooms ++;
			}else endsItr ++;
			//if some starting time happens later than some ending time, 
			//that meeting is over, we move on
		}
		return rooms;
	}
	
	//leetcode 252: meeting rooms 1
	public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
        });
        
        for(int i = 0; i + 1 < intervals.length; i ++){
        	if(intervals[i + 1].start < intervals[i].end) return false;
        }
        return true;
    }
}
