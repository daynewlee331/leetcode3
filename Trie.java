package leetcode3;

public class Trie {
	private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	if(word == null || word.length() < 1) return;
        char[] arr = word.toCharArray();
        TrieNode cur = root;
        for(int i = 0; i < arr.length; i ++){
        	if(cur.children[arr[i] - 'a'] == null){
        		cur.children[arr[i] - 'a'] = new TrieNode();
        		cur.children[arr[i] - 'a'].wordNum = 1;
        		cur.children[arr[i] - 'a'].val = arr[i];
        	}else{
        		cur.children[arr[i] - 'a'].wordNum ++;
        	}
        	cur = cur.children[arr[i] - 'a'];
        }
        cur.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	if(word == null || word.length() < 1) return false;
    	char[] arr = word.toCharArray();
    	TrieNode cur = root;
    	for(int i = 0; i < arr.length; i ++){
    		if(cur.children[arr[i] - 'a'] == null) return false;
    		else cur = cur.children[arr[i] - 'a'];
    	}
    	return cur.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        char[] arr = prefix.toCharArray();
        TrieNode cur = root;
        for(int i = 0; i < arr.length; i ++){
        	if(cur.children[arr[i] - 'a'] == null) return false;
    		else cur = cur.children[arr[i] - 'a'];
        }
        return true;
    }
}
