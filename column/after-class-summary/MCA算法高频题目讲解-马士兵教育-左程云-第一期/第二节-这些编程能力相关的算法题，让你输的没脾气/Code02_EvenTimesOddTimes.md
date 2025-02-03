## 题目 找出现奇数次的数

一个数组中，只有一个数出现奇数次，其它数都出现偶数次，找出这个数

## 题解
```
public static void printOddTimesNum1(int[] arr) {
		int eor = 0;
		for (int i = 0; i < arr.length; i++) {
			eor ^= arr[i];
		}
		System.out.println(eor);
	}
```
### 题解说明
位运算的经典题目了，使用异或运算