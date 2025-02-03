## 题目 回旋打印
回旋打印一个数组，如  

[1,2,3]

[4,5,6]

[7,8,9]

打印出 1,2,3,6,9,8,7,4,5
## 题解
```
public static void print(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		int leftUpRow = 0;
		int leftUpCol = 0;
		int rightDownRow = matrix.length - 1;
		int rightDownCol = matrix[0].length - 1;
		// 还没结束！
		while (leftUpRow <= rightDownRow && leftUpCol <= rightDownCol) {
			f(matrix, leftUpRow++, leftUpCol++, rightDownRow--, rightDownCol--);
		}
	}

	// 打印框！
	public static void f(int[][] matrix, int leftUpRow, int leftUpCol, int rightDownRow, int rightDownCol) {
		if (leftUpRow == rightDownRow && leftUpCol == rightDownCol) {
			System.out.print(matrix[leftUpRow][leftUpCol] + " ");
		} else { // 不是一个数！
			if (leftUpRow == rightDownRow) { // 当前的框是一条横线
				for (int col = leftUpCol; col <= rightDownCol; col++) {
					System.out.print(matrix[leftUpRow][col] + " ");
				}
			} else if (leftUpCol == rightDownCol) { // 当前的框是一条竖线
				for (int row = leftUpRow; row <= rightDownRow; row++) {
					System.out.print(matrix[row][leftUpCol] + " ");
				}
			} else { // 正常的框
				for (int col = leftUpCol; col < rightDownCol; col++) {
					System.out.print(matrix[leftUpRow][col] + " ");
				}
				for (int row = leftUpRow; row < rightDownRow; row++) {
					System.out.print(matrix[row][rightDownCol] + " ");
				}
				for (int col = rightDownCol; col > leftUpCol; col--) {
					System.out.print(matrix[rightDownRow][col] + " ");
				}
				for (int row = rightDownRow; row > leftUpRow; row--) {
					System.out.print(matrix[row][leftUpCol] + " ");
				}
			}
		}
	}
```
### 题解说明
没有什么算法和技巧，看coding能力，注意控制边界条件

每次剥去外层，外层四个方向改变

