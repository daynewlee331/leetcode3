package leetcode3;

public class TicTacToe {
	private int[] rows = null;
	private int[] cols = null;
	private int diagnose = 0;
	private int anti_diagnose = 0;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int toMove = player == 1? 1 : -1;
        rows[row] += toMove;
        cols[col] += toMove;
        if(row == col) diagnose += toMove;
        if(row + col == cols.length - 1) anti_diagnose += toMove;
        int n = this.rows.length;
        if(Math.abs(rows[row]) == n ||
        		Math.abs(cols[col]) == n ||
        		Math.abs(this.diagnose) == n ||
        		Math.abs(this.anti_diagnose) == n) return player;
        return 0;
    }
}
