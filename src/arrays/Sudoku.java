package arrays;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {
	
	public static boolean isValidSudoku(char[][] board){
		
		//in total 9 small cube.
		for(int i = 0; i < 9; i ++){
			
			Set<Character> row = new HashSet<>();
			Set<Character> column = new HashSet<>();
			Set<Character> cube = new HashSet<>();
			
			for(int j = 0; j < 9; j ++){
				
				//step 1: check each row, only contain 1-9 once. 
				if(board[i][j] != '.' && !row.add(board[i][j])) return false;
				
				//step 2: check each column, only contain 1-9 once.
				if(board[j][i] != '.' && !column.add(board[j][i])) return false;
				
				//step 3: check each cube, only contain 1-9 once.
				int rowIndex = 3*(i/3) + j/3;
				int colIndex = 3*(i%3) + j%3;
				if(board[rowIndex][colIndex]!='.' && !cube.add(board[rowIndex][colIndex])) return false;
			}
		}
		return true;
	}

}
