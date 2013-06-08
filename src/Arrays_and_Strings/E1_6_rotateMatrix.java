package Arrays_and_Strings;

/*
 * 1.6 Given an image represented by an NxN matrix,
 * where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees.
 * Can you do this in place?
 * 
 * | 1 2 3 |		| 7 4 1 |
 * | 4 5 6 |  =>	| 8 5 2 |
 * | 7 8 9 |		| 9 6 3 |
 */

public class E1_6_rotateMatrix {
	// Solution 1 自己写的，需要一个print函数来帮忙
	// 同时也适用于n*m的矩阵，即，行和列不相等的矩阵
	public static void rotateMatrix(int[][] matrix, int col_len, int row_len) {
		int[][] temp = new int[col_len][row_len];
		for (int i = 0; i < col_len; i++) {
			for (int j = 0; j < row_len; j++) {
				temp[i][j] = matrix[col_len - 1 - j][i];
			}
		}
		print(temp, col_len, row_len);
	}

	public static void print(int[][] str, int col_len, int row_len) {
		for (int i = 0; i < col_len; i++) {
			for (int j = 0; j < row_len; j++) {
				System.out.print(str[i][j] + " ");
			}
			System.out.println();
		}
	}

	// test
	public static void main(String[] args) {
		int[][] test = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		rotateMatrix(test, 4, 4);
	}

	// Solution 2 From Cracking
	//只对n*n的矩阵有效
	//但是可以不用设置一个新的矩阵(二维数组)
	/*
	 * 		| 1 1 1 1 1 1 |
	 * 		| 1 2 2 2 2 1 |
	 * 		| 1 2 3 3 2 1 |	=>这个6*6的矩阵就有6/2=3的layer
	 * 		| 1 2 3 3 2 1 |
	 * 		| 1 2 2 2 2 1 |
	 * 		| 1 1 1 1 1 1 |
	 * 
	 */
	public static void rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i]; // save top
				// left -> top
				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
	}
}
