package leetcode3;

public class UnionFind2D {
	private int[] prev;
	private int[] size;
	private int m, n, count;
	
	public UnionFind2D(int m, int n){
		this.m = m;
		this.n = n;
		this.count = 0;
		this.prev = new int[m * n + 1];
		this.size = new int[m * n + 1];
	}
	
	public int getIndex(int x, int y){ return x * n + y + 1;}
	public int getSize(){return this.count;}
	public int getPrev(int x, int y){
		if(x >= 0 && x < m && y >= 0 && y < n) return prev[getIndex(x, y)];
		return 0;
	}
	public int add(int x, int y){
		int i = getIndex(x, y);
		this.prev[i] = i;
		this.size[i] = 1;
		count ++;
		return i;
	}
	public int root(int i){
		while(i != prev[i]){
			prev[i] = prev[prev[i]];
			i = prev[i];
		}
		return i;
	}
	public boolean find(int p, int q) {return root(p) == root(q);}
	public void unite(int p, int q){
		int root1 = root(p);
		int root2 = root(q);
		if(size[root1] < size[root2]){
			prev[root1] = root2;
			size[root2] += size[root1];
		}else{
			prev[root2] = root1;
			size[root1] += size[root2];
		}
		count --;
	}
}
