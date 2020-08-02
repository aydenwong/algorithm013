package code.ayden.algorithm.com.queue.practice;

/**
 * @description: 队列
 * @author: aydenwang
 * @create: 2020-08-02 14:21
 * @version: 1.0.0
 **/
public class MyQueue {

    private int[] array;
    private int front;
    private int rear;
    private int capacity;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
        front = 0;
        rear = 0;
    }

    /**
     * 队尾入队
     * @param item
     * @return
     */
    public boolean enQueue(int item) {
        // rear是数组下标，按理比size要小1，但是rear每次都会++操作
        if (rear == capacity) {
            return false;
        }
        array[rear] = item;
        rear++;
        return true;
    }

    /**
     * 队头出队
     * @return
     */
    public boolean deQueue(){
        if (front == rear) {
            return false;
        }
        front ++;
        return true;
    }

}
