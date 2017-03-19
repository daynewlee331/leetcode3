package leetcode3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Min_Time_Difference {
	public static void main(String[] args){
		Min_Time_Difference sol = new Min_Time_Difference();
		List<String> timePoints = new ArrayList<String>();
		timePoints.add("23:59"); 
		timePoints.add("00:00");
		sol.findMinDifference(timePoints);
	}
	
	class Time{
		int hr;
		int min;
		public Time(int h, int m){
			this.hr = h;
			this.min = m;
		}
	}
	
	public int findMinDifference(List<String> timePoints) {
        if(timePoints == null || timePoints.size() < 0) return 0;
        List<Time> list = new ArrayList<Time>();
        for(String t: timePoints){
        	String[] sub = t.split(":");
        	list.add(new Time(Integer.parseInt(sub[0]), Integer.parseInt(sub[1])));
        }
        Collections.sort(list, new Comparator<Time>(){
			@Override
			public int compare(Time o1, Time o2) {
				if(o1.hr == o2.hr){
					return o1.min - o2.min;
				}
				return o1.hr - o2.hr;
			}
        });
        Time earlist = new Time(list.get(0).hr + 24, list.get(0).min);
        list.add(earlist);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i < list.size(); i ++){
        	minDiff = Math.min(minDiff, getDiff(list.get(i), list.get(i - 1)));
        }
        return minDiff;
    }
	
	public int getDiff(Time t1, Time t2){
		return (t1.hr - t2.hr) * 60 + (t1.min - t2.min);
	}
}
