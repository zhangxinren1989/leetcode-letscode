## 题目 摩尔投票问题
摩尔投票算法（Moore's Voting Algorithm）是一种在数组或序列中查找出现次数超过一半的主要元素的算法

即和Code00的水王问题是一样的
## 题解
```
public static void printHalfMajor(int[] arr) {
		int cand = 0;
		int HP = 0;
		for (int i = 0; i < arr.length; i++) {
			if (HP == 0) {
				cand = arr[i];
				HP = 1;
			} else if (arr[i] == cand) {
				HP++;
			} else {
				HP--;
			}
		}
		if (HP == 0) {
			System.out.println("no such number.");
			return;
		}
		HP = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == cand) {
				HP++;
			}
		}
		if (HP > arr.length / 2) {
			System.out.println(cand);
		} else {
			System.out.println("no such number.");
		}
	}
```
### 题解说明
同水王问题