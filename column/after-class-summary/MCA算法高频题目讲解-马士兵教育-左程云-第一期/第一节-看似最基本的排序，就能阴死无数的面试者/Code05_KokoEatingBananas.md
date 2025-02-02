## 题目 koko吃香蕉
有若干堆香蕉，每堆有若干根，koko一小时可以吃固定根数，如一堆香蕉有x根，koko每小时吃y根，吃完一堆需x/y + x%y，即最后一点有剩余时，他会停止一些时间，不会去吃下一堆

问最少一小时吃多少根，可以在h小时内把香蕉吃完
## 题解
```
public class Code05_KokoEatingBananas {

	public static int minEatingSpeed(int[] piles, int h) {
		int L = 1;
		int R = 0;
		for (int pile : piles) {
			R = Math.max(R, pile);
		}
		int ans = 0;
		int M = 0;
		while (L <= R) {
			M = L + ((R - L) >> 1);
			if (hours(piles, M) <= h) {
				ans = M;
				R = M - 1;
			} else {
				L = M + 1;
			}
		}
		return ans;
	}

	public static int hours(int[] piles, int speed) {
		int ans = 0;
		int offset = speed - 1;
		for (int pile : piles) {
			ans += (pile + offset) / speed;
		}
		return ans;
	}

}
```
### 题解说明
二分法，吃多少根用二分法确定，注意初值的确定和边界情况，初值如每小时吃的最多的香蕉数，边界如根本就不可能的情况，如有h+1堆，要h小时吃完