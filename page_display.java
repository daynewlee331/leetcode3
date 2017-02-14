package leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class page_display {
	  public static void main(String[] args) {
	    String[] strs = new String[]{
	      "1,28,300.1,SanFrancisco",
	      "1,5,209.1,SanFrancisco",
	      "2,7,208.1,SanFrancisco",
	      "3,8,207.1,SanFrancisco",
	      "4,10,206.1,Oakland",
	      "5,16,205.1,SanFrancisco",
	      "5,29,204.1,SanFrancisco",
	      "6,20,203.1,SanFrancisco",
	      "5,21,202.1,SanFrancisco"/*,
	      "2,18,201.1,SanFrancisco",
	      "2,30,200.1,SanFrancisco",
	      "15,27,109.1,Oakland",
	      "10,13,108.1,Oakland",
	      "11,26,107.1,Oakland",
	      "12,9,106.1,Oakland",
	      "13,1,105.1,Oakland",
	      "22,17,104.1,Oakland",
	      "1,2,103.1,Oakland",
	      "28,24,102.1,Oakland",
	      "18,14,11.1,SanJose",
	      "6,25,10.1,Oakland",
	      "19,15,9.1,SanJose",
	      "3,19,8.1,SanJose",
	      "3,11,7.1,Oakland",
	      "27,12,6.1,Oakland",
	      "1,3,5.1,Oakland",
	      "25,4,4.1,SanJose",
	      "5,6,3.1,SanJose",
	      "29,22,2.1,SanJose",
	      "30,23,1.1,SanJose"*/
	    };
	    List<String> input = new ArrayList<>(Arrays.asList(strs));
	    getPages(input, 3);
	  }       
	
	  
	public static List<List<String>> getPages(List<String> input, int k){
		List<List<String>> res = new ArrayList<List<String>>();
		if(input == null || input.size() < 1 || k < 1) return res;
		Iterator<String> iterator = input.iterator();
		Set<Integer> visited = new HashSet<Integer>();
		List<String> page = new ArrayList<String>();
		while(iterator.hasNext()){
			String cur = iterator.next();
			int id = Integer.parseInt(cur.split(",")[0]);
			if(!visited.contains(id)){
				page.add(cur);
				visited.add(id);
				iterator.remove();
			}
			if(visited.size() == k || !iterator.hasNext()){
				res.add(page);
				page = new ArrayList<String>();
				visited.clear();
				iterator = input.iterator();
			}
		}
		Iterator<List<String>> check = res.iterator();
		List<String> buffer = new ArrayList<String>();
		while(check.hasNext()){
			List<String> element = check.next();
			if(element.size() < k) {
				buffer.addAll(element);
				check.remove();
			}
		}
		List<String> sub = new ArrayList<String>();
		for(int j = 0; j < buffer.size(); j ++){
			sub.add(buffer.get(j));
			if(sub.size() == k){
				res.add(sub);
				sub = new ArrayList<String>();
			}
		}
		if(sub.size() > 0) res.add(sub);
		return res;
	}
}	
