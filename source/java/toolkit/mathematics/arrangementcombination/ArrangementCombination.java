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