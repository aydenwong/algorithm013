package code.ayden.algorithm.com.queue.practice;

/**
 * @description: 循环队列
 * 时间复杂度：O(1)。该数据结构中，所有方法都具有恒定的时间复杂度。
 * 空间复杂度：O(N)，其中 NN 是队列的预分配容量。循环队列的整个生命周期中，都持有该预分配的空间。
 * @author: aydenwang
 * @create: 2020-08-02 12:11
 * @version: 1.0.0
 **/
public class MyCircularQueue {

    /**
     * 队列数组
     */
    private int[] array;
    /**
     * 数组容量
     */
    private int capacity;
    /**
     * 指向队列头部第 1 个有效数据的位置
     */
    private int front;

    /**
     * 指向队列尾部（即最后 1 个有效数据）的下一个位置，即下一个从队尾入队元素的位置
     * 如果rear也是队尾元素所在位置，没法区分空队列和有一个元素的队列
     */
    private int rear;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        /**
         * 空闲一个元素
         * 为了避免“队列为空”和“队列为满”的判别条件冲突，我们有意浪费了一个位置。
         * 如果元素放满，因为rear指向队尾元素的下一个位置，按照循环队列的定义，这是会指向队列头部的第一个元素
         * 这样 rear==front，和队列为空时 rear==front有冲突
         *
         * 判断队列满的条件：(rear + 1) % capacity == front;
         * 可以这样理解，当 rear 循环到数组的前面，要从后面追上 front，还差一格的时候，判定队列为满
         */
        capacity = k + 1;
        array = new int[capacity];
        front = 0;
        rear = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        /**
         * rear指向队列尾部（即最后 1 个有效数据）的下一个位置，即下一个从队尾入队元素的位置，所以先赋值，再移动指针
         */
        array[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        /**
         * front指向队列头部第 1 个有效数据的位置
         */
        front = (front + 1) % capacity;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return array[front];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return array[(rear - 1 + capacity) % capacity];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        //队首和队尾指向同一个位置，队列已为空
        return front == rear;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        // 判断是否为空，是队尾元素位置+1后取模等于队首元素位置
        return (rear + 1) % capacity == front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */