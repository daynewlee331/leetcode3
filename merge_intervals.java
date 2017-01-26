package leetcode3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class merge_intervals {
	class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<Interval>();
		if(intervals.size() < 1) return res;
		Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		
		Interval pre = null;
		for(Interval inter: intervals){
			if(pre == null || inter.start > pre.end){
				res.add(inter);
				pre = inter;
			}else if(pre.end >= inter.start){
				int end = Math.max(pre.end, inter.end);
				pre.end = end;
			}
		}
		return res;
    }
}
