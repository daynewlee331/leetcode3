package leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class merge_intervals {
	class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	
	public List<Interval> merge(List<Interval> intervals) {
		if(intervals.size() < 1) return intervals;
        Collections.sort(intervals,new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
			
		});
		
		PriorityQueue<Interval> q = new PriorityQueue<Interval>(intervals.size(), new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o2.end - o1.end;
			}});
		
		// start with the first meeting, put it to a meeting room
	    q.offer(intervals.get(0));
		for(int i = 1; i < intervals.size(); i ++){
			Interval current = q.poll();
			if(intervals.get(i).start > current.end){//can't merge
				q.offer(current);
				q.offer(intervals.get(i));
			}else{
				Interval tmp = new Interval();
				tmp.start = current.start;
				if(intervals.get(i).end > current.end) tmp.end = intervals.get(i).end;
				else tmp.end = current.end;
				q.offer(tmp);
			}
		}
		List<Interval> res = new ArrayList<Interval>(q);
	    return res;
    }
}
