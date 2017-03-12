package leetcode3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Spreadsheet {

	class Cell {
		Double value;
		String content;
		public Cell(String content) {
			this.content = content;
			this.value = null;
		}
	}

	Cell[][] Cells;
	private int width;
	private int length;
	Set<Cell> visited = new HashSet<Cell>();
	// recursively evaluate a cell if expression evaluate it.
	// check to see if cycle occurred using HashSet.
	// return value when evaluation completed.
	private Double calculateCell(Cell currentCell) {
		if (currentCell.value != null) {
			return currentCell.value;
		} else if (currentCell.value == null && !visited.contains(currentCell)) {
			visited.add(currentCell);
			String[] tokens = currentCell.content.split(" ");
			Stack<Double> stack = new Stack<Double>();
			for (int i = 0; i < tokens.length; i++) {
				String s = tokens[i];
				if (s.equals("+")) stack.push(stack.pop() + stack.pop());
				else if (s.equals("*")) stack.push(stack.pop() * stack.pop());
				else if (s.equals("/")) {
					double num1 = stack.pop();
					double num2 = stack.pop();
					stack.push(num2 / num1);
				} else if (s.equals("-")) {
					double num1 = stack.pop();
					double num2 = stack.pop();
					stack.push(num2 - num1);
				} else if(s.equals("++")){ Double num = stack.pop(); stack.push(++ num);
				} else if(s.equals("--")){ Double num = stack.pop(); stack.push(-- num);
				} else if (isNumeric(s) != null) stack.push(isNumeric(s));
				else {
					Cell newCell = getCell(s);
					if(newCell == null) System.exit(1);
					else stack.push(calculateCell(newCell));
				}
			}
			currentCell.value = stack.pop();
		} else {
			System.out.println("calculateCell error: Graph has cycles");
			System.exit(1);
		}
		return currentCell.value;
	}

	private Cell getCell(String s) {
		try {
			int row = (int) s.charAt(0) % 65;
			int col = Integer.parseInt(s.substring(1)) - 1;
			return Cells[row][col];
		} catch (NumberFormatException e) {
			System.out.println("Checking Cell [" + s + "] error:" + e);
			return null;
		}
	}
	
	private Double isNumeric(String s) {
		try { return Double.parseDouble(s); } 
		catch (NumberFormatException e) { return null; }
	}

	// Populate cell values into the SpreadSheet
	private void generateSpreadsheet() {
		try {
			Scanner sc = new Scanner(System.in);
			Cells = null;
			
			int[] size = new int[2];
			if (sc.hasNextLine()) {
				String[] fields = sc.nextLine().split(" ");
				if (fields.length != 2) throw new Exception("generateSpreadsheet failed: wrong input size");
				else {
					for (int i = 0; i < fields.length; i++) {size[i] = Integer.parseInt(fields[i]);}
					Cells = new Cell[size[1]][size[0]];
					length = size[0];
					width = size[1];
				}
			}

			int row = 0, col = 0, count = 0;
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line.length() < 1) break;
				Cells[row][col] = new Cell(line);
				count++;
				col++;
				if (col == length) { col = 0; row ++; }
			}

			if (count != size[0] * size[1]) throw new Exception("generateSpreadsheet failed: sizes are not matching");
		} catch (Exception e) {
			System.out.println("generateSpreadsheet failed: " + e);
			System.exit(1);
		}
	}
	
	public static void calculateCells(Spreadsheet spreadSheet){
		int m = spreadSheet.width, n = spreadSheet.length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				spreadSheet.visited = new HashSet<Cell>();
				spreadSheet.calculateCell(spreadSheet.Cells[i][j]);
			}
		}
	}
	
	public static void printResult(Spreadsheet spreadSheet){
		int m = spreadSheet.width, n = spreadSheet.length;
		System.out.println(n + " " + m);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == m - 1 && j == n - 1) System.out.printf("%.5f", spreadSheet.Cells[i][j].value);
				else System.out.printf("%.5f%n", spreadSheet.Cells[i][j].value);
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			Spreadsheet spreadSheet = new Spreadsheet();
			spreadSheet.generateSpreadsheet();
			calculateCells(spreadSheet);
			printResult(spreadSheet);
		} catch (Exception e) {
			System.out.println("Error occurrend in main:" + e.getMessage());
		}
	}
}