package code.ayden.algorithm.com.heap.practice;

import java.util.*;

/**
 * @description: 堆排序
 * @author: aydenwang
 * @create: 2020-08-09 21:32
 * @version: 1.0.0
 **/
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer integer = map.putIfAbsent(num, 1);
            if (integer != null) {
                map.put(num, integer + 1);
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (Integer integer : map.keySet()) {
            if (queue.size() < k) {
                queue.add(integer);
            } else {
                Integer peek = queue.peek();
                if (map.get(peek) < map.get(integer)){
                    queue.remove();
                    queue.add(integer);
                }
            }
        }

        int[] top = new int[queue.size()];
        for (int i = 0; i < top.length; i++) {
            top[i] = queue.poll();
        }

        return top;
    }

}
