package leetcode3;

import java.util.Arrays;
import java.util.Comparator;

public class Non_Overlapping_Intervals {
	/*
	解题思想（贪心法）： 
	1、按照起始位置排序 
	2、按照顺序，两个指针遍历，一前一后，
	如果当前位置和上一个位置不冲突就顺序平移两个指针
	（后指针的值给前指针，然后后指针移动到下一位）
	，如果冲突的话，那么前指针则变成当前两个指针当中覆盖最小的一个（贪心所在）
	，后指针移动到下一个位置就好*/
	public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
        });
        int i = 0, count = 0;
        for(int j = 1; j < intervals.length; j ++){
        	if(intervals[i].end <= intervals[j].start) i = j;
        	else{
        		if(intervals[i].end >= intervals[j].end) i = j;
        		count ++;
        	}
        }
        return count;
    }
}
