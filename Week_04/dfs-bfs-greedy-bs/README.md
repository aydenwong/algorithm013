# 二分查找

#### 思路
前提：有序的数组结构

思路：对有序的数据集合，每次通过下标找到集合的中间元素，通过对比中间元素，将待查的集合缩小一半，直到找到要查找的元素，或者区间缩小为0

#### 时间复杂度

查找区间大小是一个等比数列：n,n/2,n/4,n/8...n/2<sup>k</sup>...

n/2k=1,k=log2n

O(logn)

#### 代码

```
public int bsearch(int[] a, int n, int value) {
  int low = 0;
  int high = n - 1;

  while (low <= high) {
    int mid = (low + high) / 2;
    if (a[mid] == value) {
      return mid;
    } else if (a[mid] < value) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }
  }
  return -1;
}
```

#### 局限性

- 依赖顺序表，也就是数组结构，因为需要随机访问
- 针对的是有序的数据，而且变化不频繁，因为插入和删除后还要保证有序，成本高
- 数据量太小时不适合，因为遍历会更快。但是元素比较很耗时的时候适用
- 数据量太大也不适合，因为依赖数组结构，需要连续内存

