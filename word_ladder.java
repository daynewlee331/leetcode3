package leetcode3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class word_ladder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		HashSet<String> wordSet = new HashSet<String>(wordList);
        if(!wordSet.contains(endWord)) return 0;
        HashSet<String> sq = new HashSet<String>();
        HashSet<String> eq = new HashSet<String>();
        HashSet<String> visited = new HashSet<String>();
        sq.add(beginWord); eq.add(endWord);
        int len = 1;
		while (!sq.isEmpty() && !eq.isEmpty()) {
			if(sq.size() > eq.size()){
				HashSet<String> tmp = sq;
				sq = eq;
				eq = tmp;
			}
			HashSet<String> buffer = new HashSet<String>();
			for(String cur: sq){
				StringBuilder builder = null;
				for (int i = 0; i < cur.length(); i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						builder = new StringBuilder(cur);
						builder.setCharAt(i, c);
						String neighbor = builder.toString();
						if(eq.contains(neighbor)) return len + 1;
						if (wordSet.contains(neighbor) && !visited.contains(neighbor)) {
							visited.add(neighbor);
							buffer.add(neighbor);
						}
					}
				}
			}
			sq = buffer;
			len++;
		}
		return 0;
    }
	
	public ArrayList<String> nextWords(String s, Set<String> wordList){
		ArrayList<String> res = new ArrayList<String>();
		StringBuilder sb = null;
		for(int i = 0; i < s.length(); i ++){
			for(char j = 'a'; j <= 'z'; j ++){
				sb = new StringBuilder(s);
				sb.setCharAt(i, j);
				if(wordList.contains(sb.toString())) res.add(sb.toString());
			}
		}
		return res;
	}
}
