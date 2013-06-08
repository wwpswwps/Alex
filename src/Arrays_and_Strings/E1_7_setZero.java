package Arrays_and_Strings;

import java.util.ArrayList;

/*
 * 1.7 Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column is set to 0.
 */

public class E1_7_setZero {

	// Solution 1 �Լ�д�ķ���
	// �����к��е�ArrayList��Ȼ���¼Ϊ0Ԫ�ص��кź��к�
	// Ȼ�����������������Ӧ�к��е�Ԫ��Ϊ0
	public static void setZero(int[][] matrix) {
		int col_len = matrix.length;
		int row_len = matrix[0].length;//��Ϊ��֪���Ǿ�������ÿ�е�Ԫ�������
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
		// ����E1_6_rotateMatrix���Լ�д���Ǹ�print�ĺ�������ӡ
		E1_6_rotateMatrix.print(matrix, col_len, row_len);
	}

	// test
	public static void main(String[] args) {
		int[][] test = { { 1, 2, 0, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 }, { 17, 18, 19, 20 } };
		setZero(test);
	}

	// Solution 2 From Cracking
	//��Ϊ0�ĸ���С�ڵ���ԭ���ľ�����������������ܻ��˷ѽ϶�Ŀռ�
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
