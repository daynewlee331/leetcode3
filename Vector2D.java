package leetcode3;

import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {
	List<List<Integer>> buffer = null;
	int currentRow = 0;
	int currentCol = 0;
	
	public Vector2D(List<List<Integer>> vec2d) {
        this.buffer = vec2d;
        this.currentRow = 0;
        this.currentCol = 0;
        while(this.currentRow < this.buffer.size()){
        	if(this.buffer.get(currentRow).size() == 0) this.currentRow ++;
        	else break;
        }
    }

    @Override
    public Integer next() {
        int res = this.buffer.get(this.currentRow).get(currentCol);
        this.currentCol ++;
        return res;
    }

    @Override
    public boolean hasNext() {
    	if(this.currentRow >= this.buffer.size()) return false;
        if(this.currentCol < this.buffer.get(this.currentRow).size()) return true;
        this.currentCol = 0;
        this.currentRow ++;
        while(this.currentRow < this.buffer.size()){
        	if(this.buffer.get(currentRow).size() == 0) this.currentRow ++;
        	else break;
        }
        return this.currentRow < this.buffer.size();
    }
}
