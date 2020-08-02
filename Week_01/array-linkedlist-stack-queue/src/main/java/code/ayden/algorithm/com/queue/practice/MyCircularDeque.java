package code.ayden.algorithm.com.queue.practice;

/**
 * @description: 循环双端队列
 * 时间复杂度：O(1)。该数据结构中，所有方法都具有恒定的时间复杂度。
 * 空间复杂度：O(N)，其中 NN 是队列的预分配容量。循环队列的整个生命周期中，都持有该预分配的空间。
 * @author: aydenwang
 * @create: 2020-08-02 12:11
 * @version: 1.0.0
 **/
class MyCircularDeque {

    private int[] array;
    private int front;
    private int rear;
    private int capacity;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        //需要一个空元素，区分队列满时和队列为空的判断条件
        //队列为空判断条件：front=rear，队列满的判断条件 (rear + 1)%capacity=front
        //如果元素放满，因为rear指向队尾元素的下一个位置，按照循环队列的定义，这是会指向队列头部的第一个元素，也就是front=rear
        capacity = k + 1;
        array = new int[capacity];
        front = 0;
        rear = 0;
    }

    /**
     * 队头添加入队（反）
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        // (+ capacity)考虑下front为0时
        front = (front - 1 + capacity) % capacity;
        array[front] = value;
        return true;
    }

    /**
     * 队尾添加入队(正)
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        array[rear]= value;
        rear = (rear + 1) % capacity;
        return true;
    }

    /**
     * 队头出队（正）
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    /**
     * 队尾出队（反）
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        // (+ capacity)考虑下rear为0时
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return array[front];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return array[(rear - 1 + capacity) % capacity];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        /**
         * 想想初始状态没有元素时，两个的下标
         */
        if (rear == front) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        /**
         * 队尾+1后，与长度取模，得到index，
         * 如果index和front重合，说明队尾再增加一个元素就要和队首重合了，说明此时队列已经满了
         */
        if ((rear + 1) % capacity != front) {
            return false;
        }
        return true;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */