package leetcode3;

public class Maximum_Product_Word_Lengths {
	class Word{
		int[] letters = new int[26];
		Word(String w){
			for(char c: w.toCharArray()) letters[c - 'a'] = 1;
		}
		
		public boolean containsSameLetters(Word w2){
			for(int i = 0; i < letters.length; i ++){
				if(letters[i] == 1 && w2.letters[i] == 1) return true;
			}
			return false;
		}
	}
	
	public int maxProduct(String[] words) {
        if(words == null || words.length < 1) return 0;
        Word[] arr = new Word[words.length];
        for(int i = 0; i < words.length; i ++){
        	arr[i] = new Word(words[i]);
        }
        int max = 0;
        for(int i = 0; i < arr.length; i ++){
        	for(int j = i + 1; j < arr.length; j ++){
        		if(!arr[i].containsSameLetters(arr[j])) {
        			int len = words[i].length() * words[j].length();
        			max = Math.max(len, max);
        		}
        	}
        }
        return max;
    }
}
