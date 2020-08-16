package com.ayden.algorithm.code.queue.practice;

/**
 * @description: 双端队列
 * @author: aydenwang
 * @create: 2020-08-02 16:40
 * @version: 1.0.0
 **/
public class MyDeque {

    private int[] array;
    private int front;
    private int rear;
    private int capacity;

    public MyDeque(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
        front = 0;
        rear = 0;
    }

    /**
     * 队尾入队
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        // rear是数组下标，按理比size要小1，但是rear每次都会++操作
        if (rear == capacity) {
            return false;
        }
        array[rear] = value;
        rear++;
        return true;
    }

    /**
     * 队头出队
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (front == rear) {
            return false;
        }
        front++;
        return true;
    }

    /**
     * 队头入队
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        // rear是数组下标，按理比size要小1，但是rear每次都会++操作
        if (front == 0) {
            return false;
        }
        front--;
        array[front] = value;
        return true;
    }

    /**
     * 队尾出队
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (front == rear) {
            return false;
        }
        rear--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (front == rear) {
            return -1;
        }
        return array[front];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (front == rear) {
            return -1;
        }
        // 当 rear 为 0 时防止数组越界
        return array[rear - 1];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return rear == capacity;
    }

}
