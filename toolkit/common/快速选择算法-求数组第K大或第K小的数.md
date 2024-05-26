## 快速选择算法-求数组第K大或第K小的数
这篇文章参考了[快速排序/快速选择算法](https://blog.csdn.net/qq_64580912/article/details/129459981)这篇文章，是在做leetcode 1738-找出第K大的异或坐标值 题的时候想到所做一篇文章，这题用到了快速选择算法

不过官解的快速选择算法写的比较难以理解，[0526-1738-找出第K大的异或坐标值](https://github.com/zhangxinren1989/leetcode-letscode/blob/main/column/daily-task/2024/05/0526-1738-%E6%89%BE%E5%87%BA%E7%AC%ACK%E5%A4%A7%E7%9A%84%E5%BC%82%E6%88%96%E5%9D%90%E6%A0%87%E5%80%BC.md)

这里给出了快排和快速选择算法的代码，以供作为模板使用，具体理解可以看上面提供的第一篇文章，关于官解的做法，也在上面第二篇文章中给了简单的解释

快速选择算法是在快排的基础上的，与快排的代码差别很小
### 快速排序代码
```java
    public void quickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int index = (int) (left + Math.random() * (right - left + 1));
        int pivot = nums[index];//随机值生成index
        swap(nums, index, right);
        int l = left, r = right - 1;
        while (true) {
            while (l < right && nums[l] < pivot) {//找到第一个比pivot大于等于的数
                l++;
            }
            while (r > 0 && nums[r] > pivot) {// 找到第一个比pivot小于等于的数
                r--;
            }
            if (l < r)
                swap(nums, l++, r--);
            else
                break;
        }
        swap(nums, l, right);
        quickSort(nums, left, l - 1);
        quickSort(nums, l + 1, right);

    }

    public  void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
```
### 快速选择算法代码
```java
public void quickSelect(int[] nums, int left, int right, int k) {
        if (left >= right)
            return;
        int index = (int) (left + Math.random() * (right - left + 1));
        int pivot = nums[index];//随机值生成index
        swap(nums, index, right);
        int l = left, r = right - 1;
        while (true) {
            while (l < right && nums[l] < pivot) {//找到第一个比pivot大的数
                l++;
            }
            while (r > 0 && nums[r] > pivot) {//
                r--;
            }
            if (l < r)
                swap(nums, l++, r--);
            else
                break;
        }
        swap(nums, l, right);
        // 下面几行是快排和快速选择的惟一不同
        if (l > k ) {
            quickSelect(nums, left, l - 1,k);
        } else if (l < k ) {
            quickSelect(nums, l + 1, right,k);
        }
    }

    public  void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
```
### 求第k大的代码(两种方法)
```java
public int findKthLargestByQuickSort(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

public int findKthLargestByQuickSelect(int[] nums, int k) {
        quickSelect(nums, 0, nums.length - 1,nums.length-k);
        return nums[nums.length - k];
        }
```