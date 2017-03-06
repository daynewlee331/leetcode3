package leetcode3;

import java.util.ArrayList;
import java.util.List;

public class number_of_islands_two {
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		List<Integer> res = new ArrayList<Integer>();
		if(m < 1 || n < 1 || positions == null || positions.length < 1) return res;
		UnionFind2D islands = new UnionFind2D(m, n);
		int[][] directions = {{0, 1},{0, -1},{-1, 0},{1, 0}};
		for(int[] position: positions){
			int p = islands.add(position[0], position[1]);
			for(int[] d: directions){
				int q = islands.getPrev(position[0] + d[0], position[1] + d[1]);
				if(q > 0 && !islands.find(p, q)){
					islands.unite(p, q);
				}
			}
			res.add(islands.getSize());
		}
		return res;
	}
}
