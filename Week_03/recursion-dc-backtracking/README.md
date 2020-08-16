# 递归

#### 递归问题

递归是一种算法或者编程技巧，一般会具有以下三种条件

1. 一个问题可以拆分为几个子问题的解，规模更小

2. 问题和拆分出的子问题，求解思路是一致的，只是数据规模更小

3. 存在拆分的终止条件，即递归终止条件

#### 简单问题：电影院排数问题

求解现在在电影院的第几排？

当前排=前一排+1，第一排为1.

公式：f(n)=f(n-1)+1;f(1)=1;

代码：

```java
public int f(int n){
    if(n=1){
        return 1;
    }
    return f(n-1) + 1;
}
```

#### 如何编写递归代码

1. 找到大问题分解为小问题的规律

2. 写出递归公式

3. 推敲终止条件

4. 递归公式和终止条件翻译为代码

#### 复杂问题：走台阶问题

如果有n级台阶，一次可以走一级，一次也可以走两级，问有多少种走法？

1. 找到规律

    n级台阶的走法，可以从第一步的走法开始，第一步可以走一级，也可以走两级，那n级台阶的走法就是第一步一级，加上剩下的n-1级的走法，和第一步两级，加上剩下的n-2级的走法。

2. 递归公式

    f(n) = f(n-1)+ f(n-2)

3. 终止条件

    当只有一级台阶时，只有一种走法,f(1) = 1;但是当只有两级台阶时，两种走法,f(2) = f(1)
    +f(0)，这样f(0)也是一种走法，不好理解。

    所有条件可以有两个：f(1) = 1，f(2) = 2

4. 翻译为代码

```java
int f(n){
    if(n==1){
        return 1;
    }
    if(n==2){
        return 2;
    }
    return f(n-1)+f(n-2)
}
```

#### 递归要小心栈溢出

递归太深的话，很可能会导致栈溢出，所以最好在递归代码中做一下判断

比如：
```java
// 全局变量，表示递归的深度。
int depth = 0;

int f(int n) {
  ++depth；
  if (depth > 1000) throw exception;
  
  if (n == 1) return 1;
  return f(n-1) + 1;
}

```
#### 递归要小心重复计算

比如找台阶方式的递归实现，就出现了递归计算。因为在计算f(n)的时候，计算了f(n-1)和f(n-2)，那么计算f(n-1)时，f(n-1)也就是f(n)的f(n-2)已经计算过了，可以缓存起来。

代码：
```java
public int f(int n) {
  if (n == 1) return 1;
  if (n == 2) return 2;
  
  // hasSolvedList 可以理解成一个 Map，key 是 n，value 是 f(n)
  if (hasSolvedList.containsKey(n)) {
    return hasSovledList.get(n);
  }
  
  int ret = f(n-1) + f(n-2);
  hasSovledList.put(n, ret);
  return ret;
}
```

#### 递归可以翻译为for循环
递归的代码，一般都能翻译为for循环

比如电影院的例子
```
int f(int n) {
  int ret = 1;
  for (int i = 2; i <= n; ++i) {
    ret = ret + 1;
  }
  return ret;
}
```

比如台阶的例子

```
int f(int n) {
  if (n == 1) return 1;
  if (n == 2) return 2;
  
  int ret = 0;
  int pre = 2;
  int prepre = 1;
  for (int i = 3; i <= n; ++i) {
    ret = pre + prepre;
    prepre = pre;
    pre = ret;
  }
  return ret;
}

```