## 题目 之字型打印
之字型打印一个数组，如

[1,2,3]

[4,5,6]

[7,8,9]

打印出1,2,4,3,5,7,6,8,9
## 题解
```
public static void printMatrixZigZag(int[][] matrix) {
		int tR = 0;
		int tC = 0;
		int dR = 0;
		int dC = 0;
		int endR = matrix.length - 1;
		int endC = matrix[0].length - 1;
		boolean fromUp = false;
		while (tR != endR + 1) {
			printLevel(matrix, tR, tC, dR, dC, fromUp);
			tR = tC == endC ? tR + 1 : tR;
			tC = tC == endC ? tC : tC + 1;
			dC = dR == endR ? dC + 1 : dC;
			dR = dR == endR ? dR : dR + 1;
			fromUp = !fromUp;
		}
		System.out.println();
	}

	public static void printLevel(int[][] m, 
			int Arow, int ACol, int Brow, int Bcol, boolean f) {
		if (f) {
			while (Arow != Brow + 1) {
				System.out.print(m[Arow++][ACol--] + " ");
			}
		} else {
			while (Brow != Arow - 1) {
				System.out.print(m[Brow--][Bcol++] + " ");
			}
		}
	}
```
### 题解说明
coding能力，双指针，注意会变换方向，指针A先右后下移动，指针B先下后右移动，每次打印A-B之间的线