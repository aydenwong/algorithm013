package com.ayden.algorithm.code.queue.practice1;

/**
 * @description: 循环队列
 * @author: aydenwang
 * @create: 2020-08-13 20:08
 * @version: 1.0.0
 **/
public class MyCircularQueue {

    private int capacity;
    private int[] arr;
    private int head;
    private int tail;

    public MyCircularQueue(int capacity) {
        //指向队头第一个元素位置
        head = 0;
        //指向队尾元素的下一个位置，即下一个入队元素的下标
        tail = 0;

        //需要浪费一个位置下标，因为tail指向的是一个空元素，环形队列满时，tail指向的元素下标在head的
        //如果元素放满，因为rear指向队尾元素的下一个位置，按照循环队列的定义，这是会指向队列头部的第一个元素
        //这样 rear==front，和队列为空时 rear==front有冲突
        this.capacity = capacity + 1;
        this.arr = new int[this.capacity];
    }

    public boolean enQueue(int e) {
        if (isFull()) {
            return false;
        }
        arr[tail] = e;
        //取模，可以理解为hash，相当于把队列下标映射到队列长度的槽位index，特殊的是槽位数量和下标数量相等
        tail = (tail + 1) % capacity;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        //取模，可以理解为hash，相当于把队列下标映射到队列长度的槽位index，特殊的是槽位数量和下标数量相等
        head = (head + 1) % capacity;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        //因为tail指向最后一个元素的下一个元素，队尾元素下标是 tail-1
        //因为可能tail=0，最后一个元素的下标需要 -1后，取模
        return arr[(tail - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        if (head == tail) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if ((tail + 1) % capacity == head) {
            return true;
        }
        return false;
    }
}
