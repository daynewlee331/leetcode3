package leetcode3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Vector2D implements Iterator<Integer> {
	Queue<Integer> queue = null;
	List<List<Integer>> buffer = null;
	int index = 0;
	public Vector2D(List<List<Integer>> vec2d) {
		if(vec2d == null) return;
		this.index = 0;
		this.buffer = vec2d;
        this.queue = new LinkedList<Integer>();
        while(this.index < this.buffer.size() && this.buffer.get(index).size() == 0){
        	this.index ++;
        }
        if(this.buffer.size() > 0 && this.index < this.buffer.size()){
        	for(int num: this.buffer.get(index)) this.queue.offer(num);
            this.index ++;
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        if(!this.queue.isEmpty()) return true;
        if(this.index >= this.buffer.size()) return false;
        while(this.index < this.buffer.size() && this.buffer.get(index).size() == 0){
        	this.index ++;
        }
        if(this.buffer.size() > 0 && this.index < this.buffer.size()){
        	for(int num: this.buffer.get(index)) this.queue.offer(num);
            this.index ++;
        }
        return !this.queue.isEmpty();
    }
}
