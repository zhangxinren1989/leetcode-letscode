## 题目
> 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
### 示例1：
> 输入: [1,2,3,4,5]  
> 输出: True  
### 示例2：
> 输入: [0,0,1,2,5]  
> 输出: True  
### 限制：
> 数组长度为 5   
> 数组的数取值为 [0, 13] .  
## 我的题解
### 代码(c++)
```cpp
class Solution {
public:
    bool isStraight(vector<int>& nums) {
        int n[14] = {0};
        for(int i: nums){
            n[i]++;
        }
        int a = 0;
        int pre = 0;
        for(int i = 1; i < 14; i++){
            if(n[i] > 1)return false;
            if(n[i] == 1){
                if(pre)a+=i-pre-1;
                pre=i;
            }
        }

        return a <= n[0];
    }
};
```
### 代码说明
练习了一下c++，因为大小王可以当任何牌，所以牌可以不连续，用王补不连续的牌
## 其它题解
### 代码(c++)
```cpp
class Solution {
public:
    bool isStraight(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int k = 0;
        while(nums[k] == 0) k ++;
        for(int i = k; i < nums.size() - 1; i ++)
            if(nums[i] == nums[i + 1])
                return false;
        return nums.back() - nums[k] <= 4;
    }
};
```
### 代码说明
先排下序，不能有相同的，然后用王补不连续的牌
## 补充说明
内容来源于[晴雨](http://proprogrammar.com/article/834)