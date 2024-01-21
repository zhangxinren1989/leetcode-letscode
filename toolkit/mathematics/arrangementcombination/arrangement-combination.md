## 两个方法求排列/组合数

第一个方法是我看别人写的求不同的数的排列数的方法，代码很简洁，通过交换当前位置与之后位置的数来实现全排列，但这里要求所有的数不同，如果有相同的数，那这个方法就不适用了，而且所得的全排列没有什么特定的顺序。

代码如下：
```java
package toolkit.mathematics.arrangementcombination;

public class Arrangement {
    public static void main(String[] args) {
        Arrangement test = new Arrangement();
        int[] arr = new int[]{1, 2, 3, 4};
        test.swapPaiLei(arr, 0, 0);
    }

    /**
     * 求不同数的排列数
     * @param data
     * @param cnt
     * @param cur
     */
    private void swapPaiLei(int[] data, int cnt, int cur) {
        if(cnt == data.length) {
            System.out.println(cur);
            return;
        }

        for(int i = cnt; i < data.length; i++) {
            swap(data, cnt, i);
            swapPaiLei(data, cnt + 1, cur * 10 + data[cnt]);
            swap(data, cnt, i);
        }
    }

    private void swap(int[] data, int i, int j) {
        int t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
}
```
第二个方法是自己写一道leetcode题时想出来的方法，利用了java中的TreeMap这个有序的Map，最终的效果是既可以用来求排列数，也可以用来求组合数，即可以有重复的数字，并且所得的结果有序。

代码如下：
```java
package toolkit.mathematics.arrangementcombination;

import java.util.TreeMap;

public class ArrangementCombination {
    public static void main(String[] args) {
        ArrangementCombination test = new ArrangementCombination();
        String data = "1122334";
//        String data = "4321";
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (char c : data.toCharArray()) {
            Integer value = map.getOrDefault(c - '0', 0);
            map.put(c - '0', value + 1);
        }
        test.ascPaiLeiZuHe(map, data.length(), 0);
    }

    /**
     * 求排列组合数（从小到大序）
     * @param map
     * @param cnt
     * @param cur
     */
    private void ascPaiLeiZuHe(TreeMap<Integer, Integer> map, int cnt, int cur) {
        if (cnt == 0) {
            // 对一个确定的TreeMap,下面是按由小到大的顺序打印的组合数，
            // 即通过一个TreeMap，可以实现获取由小到大的组合数的功能（如果数都不同，也即可
            // 以获取排列数
            System.out.println(cur);
            return;
        }
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (value == 0) continue;
            map.put(key, value - 1);
            ascPaiLeiZuHe(map, cnt - 1, cur * 10 + key);
            map.put(key, value);
        }
    }
}
```