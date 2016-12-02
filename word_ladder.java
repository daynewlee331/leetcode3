package leetcode3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class word_ladder {
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        
    }
	
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> q = new LinkedList<String>();
        wordList.add(endWord);
        wordList.add(beginWord);
        HashSet<String> visited = new HashSet<String>();
        q.add(beginWord);
        int length = 1;
        visited.add(beginWord);
        
		while (!q.isEmpty()) {
			length++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String cur = q.poll();
				ArrayList<String> neighors = nextWords(cur, wordList);
				for (String st : neighors) {
					if (!visited.contains(st)) {
						if(st.equals(endWord)) return length;
						visited.add(st);
						q.add(st);
					}
				}
			}
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
