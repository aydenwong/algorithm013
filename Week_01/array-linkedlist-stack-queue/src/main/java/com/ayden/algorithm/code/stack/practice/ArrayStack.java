package com.ayden.algorithm.code.stack.practice;

/**
 * @description: 栈实现
 * @author: aydenwang
 * @create: 2020-08-04 09:06
 * @version: 1.0.0
 **/
public class ArrayStack {

    private int[] items;
    private int count;
    private int capacity;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
        count = 0;
    }

    public int pop() {
        if (count == 0) {
            return -1;
        }
        count--;
        return items[count];
    }

    public boolean push(int item) {
        if (count == capacity) {
            return false;
        }
        items[count] = item;
        count++;
        return true;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return items[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

}
