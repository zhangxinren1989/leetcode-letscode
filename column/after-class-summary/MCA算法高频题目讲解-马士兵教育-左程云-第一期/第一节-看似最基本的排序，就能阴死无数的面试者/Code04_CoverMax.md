## 题目
最大线段重合问题
若干线段，每个有一个长度，开始=结束时不算重合，问最多的地方有几条线段重合

## 题解1
```
// 方法一
	public static int maxCover1(int[][] lines) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < lines.length; i++) {
			min = Math.min(min, lines[i][0]);
			max = Math.max(max, lines[i][1]);
		}
		int cover = 0;
		for (double p = min + 0.5; p < max; p += 1) {
			int cur = 0;
			for (int i = 0; i < lines.length; i++) {
				if (lines[i][0] < p && lines[i][1] > p) {
					cur++;
				}
			}
			cover = Math.max(cover, cur);
		}
		return cover;
	}
```
### 题解1说明
暴力方法，对每个位置求有几条重合，一个技巧是不用整数位置，而是用.5的位置

## 题解2
```
public static int zuo(int[][] lines) {
		// 根据开始位置排序
		Arrays.sort(lines, (a, b) -> a[0] - b[0]);
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		// 堆：加入一个数字，弹出一个数字，时间复杂度O(log N)
		int max = 0;
		for (int[] line : lines) {
			int start = line[0];
			int end = line[1];
			while (!heap.isEmpty() && heap.peek() <= start) {
				heap.poll();
			}
			heap.add(end);
			int curAns = heap.size();
			max = Math.max(max, curAns);

		}
		return max;
	}
```
### 题解2说明
优先队列方法，把重合的线段都放入优先队列中，当不满足重合时，会从优先队列中取出，所以最终结果就是优先队列的size的最大值

## 题解3
```
public static int zhang(int[][] lines) {
		// 根据开始位置排序
		Arrays.sort(lines, (a, b) -> {
			if(a[0] != b[0]) return a[0] - b[0];
			return a[1] - b[1];
		});
		PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
			if(Math.abs(a) != Math.abs(b)) {
				return Math.abs(a) - Math.abs(b);
			}
			// 下面两行的作用：如果有起点有终点，让终点排在起点前面
			if(a < 0) return -1;
			return 1;
		});
		//
		int max = 0;
		// 先让所有的起点，终点入队，终点用负数，以区分起点
		for (int[] line : lines) {
			int start = line[0];
			int end = -line[1];
			heap.add(start);
			heap.add(end);
		}
		int sum = 0;
		// 出队，遇起点+1，遇终点-1
		while(!heap.isEmpty()) {
			int cur = heap.poll();
			if(cur >= 0) {
				sum++;
			}else {
				sum--;
			}
			if(sum > max) max = sum;
		}

		return max;
	}
```
### 题解3说明
自己想的写法，写过类似的题目，和左老师说的有点不同，