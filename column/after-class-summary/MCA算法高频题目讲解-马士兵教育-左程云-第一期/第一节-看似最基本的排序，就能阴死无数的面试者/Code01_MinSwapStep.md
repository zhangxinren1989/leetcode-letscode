## 题目
一个数组中只有两种字符'G'和'B'，

可以让所有的G都放在左侧，所有的B都放在右侧

或者可以让所有的G都放在右侧，所有的B都放在左侧

但是只能在相邻字符之间进行交换操作，请问请问至少需要交换几次，

## 题解1
```
public static int minSteps1(String s) {
		if (s == null || s.equals("")) {
			return 0;
		}
		char[] str = s.toCharArray();
		int step1 = 0;
		int gi = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == 'G') {
				step1 += i - (gi++);
			}
		}
		int step2 = 0;
		int bi = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == 'B') {
				step2 += i - (bi++);
			}
		}
		return Math.min(step1, step2);
	}
```
### 题解1说明
可以G全到左边，也可以G全到右边，（B的情况正相反），秉持的原则是，对G来说，G之前不交换，否则浪费次数，要做到G之间不交换，那么如果去左边，那么最左的G到左边第一位，第二左的G到左边第二位。。。

双指针可以解决，第一个指针记录最左边第几位，第二个指针记第几个G的位置，差值就是这个G要移的次数，因为G的数量小于等于总G+B的数量，所以总会有第一个指针不会大于第二个指针

如果有一个动图会比较直观，但题目不难，如果会了，也能自己想像出来，等有比较难的题，会来画图说明，以帮助理解
## 题解2
```
public static int minSteps2(String s) {
		if (s == null || s.equals("")) {
			return 0;
		}
		char[] str = s.toCharArray();
		int step1 = 0;
		int step2 = 0;
		int gi = 0;
		int bi = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == 'G') { // 当前的G，去左边   方案1
				step1 += i - (gi++);
			} else {// 当前的B，去左边   方案2
				step2 += i - (bi++);
			}
		}
		return Math.min(step1, step2);
	}
```
### 题解2说明
是对题解1的一个小优化，两步并作一步来做，后面会有几题分步来写的，比较难一点