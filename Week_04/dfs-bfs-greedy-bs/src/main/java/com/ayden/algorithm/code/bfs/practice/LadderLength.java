package com.ayden.algorithm.code.bfs.practice;

import com.ayden.algorithm.code.common.Pair;

import java.util.*;

/**
 * @description: 单词接龙
 * @author: aydenwang
 * @create: 2020-08-23 20:27
 * @version: 1.0.0
 **/
public class LadderLength {

    /**
     * 思路：
     * 从起始单词到目标单词，每次转换一个字符，可以视作有向无环图，求层高的问题。
     *
     * 计算每次转换一个字符后，匹配下一个可能存在的字符，可以用 * 做通配符，建立一个hash表。
     * 比如 "list" -> "l*st" 作为key，value是所有能匹配到的字典里的单词，比如 "last","lost"
     *
     * 计算通配符字符串时，一定不要用charAt的api，如果出现重复字符就会替换两个
     *
     * 求层高的问题，可以用广度优先搜索，需要借助队列
     * 先加入当前层的字符，beginWord
     * 匹配下一层字符后，依次加入队列
     * 再遍历下一层全部字符，找到匹配的字符，加入更下一层
     * 遍历时，避免出现环，需要记录和排除已经访问过的字符
     *
     * 时间复杂度：O（M*N）M单词个数，N单词长度
     * 空间复杂度：O（M*N）
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 0;
        }

        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord);

        int length = beginWord.length();
        char wildcard = '*';

        Map<String, List<String>> dict = new HashMap<>();
        wordSet.forEach(s -> {
            for (int i = 0; i < length; i++) {
                //String replace = s.replace(s.charAt(i), wildcard);
                //一定不要用charAt的api，如果出现重复字符就会替换两个
                String replace = s.substring(0, i) + wildcard + s.substring(i+1);
                dict.putIfAbsent(replace, new ArrayList());
                dict.get(replace).add(s);
            }
        });

        //System.out.println(dict);

        Queue<String> queue = new LinkedList();

        queue.offer(beginWord);

        Set<String> set = new HashSet<>();
        int level = 1;
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                //System.out.println(level+"-"+i+"-"+poll);
                if (poll.equals(endWord)) {
                    return level;
                }

                for (int j = 0; j < length; j++) {
                    String replace = poll.substring(0, j) + wildcard + poll.substring(j+1);
                    List<String> list = dict.get(replace);
                    if (list != null) {
                        list.removeAll(set);
                        if (!list.isEmpty()) {
                            queue.addAll(list);
                            set.addAll(list);
                            //System.out.println(set);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
    /**
     * "leet"
     * "code"
     * ["lest","leet","lose","code","lode","robe","lost"]
     */
        LadderLength ll = new LadderLength();
        List<String> list = new ArrayList<>();
        list.add("lest");
        list.add("leet");
        list.add("lose");
        list.add("code");
        list.add("lode");
        list.add("robe");
        list.add("lost");

        //lost -> most -> mist -> miss
        int ladderLength = ll.ladderLength("leet", "code", list);

        System.out.println(ladderLength);
    }

}
