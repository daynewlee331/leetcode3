package leetcode3;

public class Lonely_Pixel_One {
	public int findLonelyPixel(char[][] picture) {
        if(picture == null || picture.length < 1) return 0;
        int m = picture.length, n = picture[0].length;
        int[] countRow = new int[m], countCol = new int[n];
        for(int i = 0; i < m; i ++){
        	for(int j = 0; j < n; j ++){
        		if(picture[i][j] == 'B') {
        			countRow[i] ++;
        			countCol[j] ++;
        		}
        	}
        }
        int count = 0;
        for(int i = 0; i < m; i ++){
        	for(int j = 0; j < n; j ++){
        		if(picture[i][j] == 'B' && countRow[i] == 1 && countCol[j] == 1) count ++;
        	}
        }
        return count;
    }
}
