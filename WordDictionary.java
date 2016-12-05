package leetcode3;

public class WordDictionary {
	private TrieNode root = new TrieNode();

	// Adds a word into the data structure.
	public void addWord(String word) {
		if (word == null || word.length() < 1)
			return;
		char[] arr = word.toCharArray();
		TrieNode cur = root;
		for (int i = 0; i < arr.length; i++) {
			if (cur.children[arr[i] - 'a'] == null) {
				cur.children[arr[i] - 'a'] = new TrieNode();
				cur.children[arr[i] - 'a'].wordNum = 1;
				cur.children[arr[i] - 'a'].val = arr[i];
			} else {
				cur.children[arr[i] - 'a'].wordNum++;
			}
			cur = cur.children[arr[i] - 'a'];
		}
		cur.isEnd = true;
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return searchHelper(word, 0, root);
	}

	private boolean searchHelper(String word, int index, TrieNode current) {
		if (index == word.length()) {
			return current.isEnd;
		}
		if (word.charAt(index) != '.') {
			if (current.children[word.charAt(index) - 'a'] == null) return false;
			return searchHelper(word, index + 1, current.children[word.charAt(index) - 'a']);

		} else {
			for (int i = 0; i < current.children.length; i++) {
				if (current.children[i] != null) {
					if (searchHelper(word, index + 1, current.children[i]))
						return true;
				}
			}
		}
		return false;
	}
}
