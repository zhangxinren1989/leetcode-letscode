## 题目 寻找名人
leetcode原题277题

如果一个人不认识其它任何一个人，其它任何一个人都认识他，那么这个人是明星，系统提供一个know方法，来判断两个人的认识关系

判断有没有明星

## 题解
```
// 提交时不要提交这个函数，因为默认系统会给你这个函数
	// knows方法，自己不认识自己
	public static boolean knows(int x, int i) {
		return true;
	}

	// 只提交下面的方法 0 ~ n-1
	public int findCelebrity(int n) {
		// 谁可能成为明星，谁就是cand
		int cand = 0;
		for (int i = 0; i < n; ++i) {
			if (knows(cand, i)) { // 如果cand认识i，那么i候选，如果不认识，那么i不可能候选，无论如何，i处理掉了
				cand = i;
			}
		}
		// cand是什么？唯一可能是明星的人！
		// 下一步就是验证，它到底是不是明星
		// 1) cand是不是不认识所有的人 cand...（右侧cand都不认识）
		// 所以，只用验证 ....cand的左侧即可
		for (int i = 0; i < cand; ++i) {
			if (knows(cand, i)) {
				return -1;
			}
		}
		// 2) 是不是所有的人都认识cand
		for (int i = 0; i < n; ++i) {
			if (!knows(i, cand)) {
				return -1;
			}
		}
		return cand;
	}
```
### 题解说明
O(n)的算法，从前向后遍历候选者，如果认识一个人，那么不是明星，换下一个候选者，如果不认识一个人，那这一个人不会是明星

最后对候选者验证：是不是认识其它人，是不是其它人认识他