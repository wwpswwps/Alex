package Arrays_and_Strings;

import java.util.ArrayList;

/*
 * 1.7 Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column is set to 0.
 */

public class E1_7_setZero {

	// Solution 1 自己写的方法
	// 设置行和列的ArrayList，然后记录为0元素的行号和列号
	// 然后遍历矩阵来设置相应行和列的元素为0
	public static void setZero(int[][] matrix) {
		int col_len = matrix.length;
		int row_len = matrix[0].length;//因为已知这是矩阵，所以每行的元素数相等
		ArrayList<Integer> row = new ArrayList<Integer>();
		ArrayList<Integer> col = new ArrayList<Integer>();
		for (int i = 0; i < col_len; i++) {
			for (int j = 0; j < row_len; j++) {
				if (matrix[i][j] == 0) {
					row.add(i);
					col.add(j);
				}
			}
		}
		for (int r = 0, c = 0; (r < row.size()) || (c < col.size()); r++, c++) {
			for (int j = 0; j < row_len; j++) {
				matrix[row.get(r)][j] = 0;
				matrix[j][col.get(c)] = 0;
			}
		}
		// 调用E1_6_rotateMatrix中自己写的那个print的函数来打印
		E1_6_rotateMatrix.print(matrix, col_len, row_len);
	}

	// test
	public static void main(String[] args) {
		int[][] test = { { 1, 2, 0, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 }, { 17, 18, 19, 20 } };
		setZero(test);
	}

	// Solution 2 From Cracking
	//因为0的个数小于等于原来的矩阵，所以这个方法可能会浪费较多的空间
	public static void setZeros(int[][] matrix) {
		int[] row = new int[matrix.length];
		int[] column = new int[matrix[0].length];
		// Store the row and column index with value 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = 1;
					column[j] = 1;
				}
			}
		}

		// Set arr[i][j] to 0 if either row i or column j has a 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if ((row[i] == 1 || column[j] == 1)) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
