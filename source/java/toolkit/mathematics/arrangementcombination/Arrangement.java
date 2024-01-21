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
