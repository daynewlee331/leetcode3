package leetcode3;

public class TrieNode {
	TrieNode[] children = null;
	int wordNum = 0;
	boolean isEnd;
	char val = '*';
	public TrieNode() {
		this.children = new TrieNode[26];
		this.wordNum = 0;
		this.isEnd = false;
    }
}
