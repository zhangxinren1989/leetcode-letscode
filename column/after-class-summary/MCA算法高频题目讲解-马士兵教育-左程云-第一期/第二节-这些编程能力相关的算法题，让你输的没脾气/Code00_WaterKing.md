## 题目 水王数(超级水王问题)
找一个数组中，出现次数超过一半的数
## 题解
```
public static void water(int[] arr) {
    if (arr == null || arr.length == 0) {
        System.out.println("没有水王数");
    } else {
        int target = 0;
        int hp = 0;
        for (int cur : arr) {
            if (hp == 0) {
                target = cur;
                hp = 1;
            } else if (cur != target) {
                hp--;
            } else {
                hp++;
            }
        }
        if (hp == 0) {
            System.out.println("没有水王数");
            return;
        }
        int times = 0;
        for (int cur : arr) {
            if (target == cur) {
                times++;
            }
        }
        if (times > arr.length / 2) {
            System.out.println("水王数是 : " + target);
        } else {
            System.out.println("没有水王数");
        }
    }
}
```
### 题解说明
一次删除两个不同的数，这样如果有水王数，水王数会剩下来
最多两次遍历