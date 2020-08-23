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
                String replace = s.replace(s.charAt(i), wildcard);
                dict.putIfAbsent(replace, new ArrayList());
                dict.get(replace).add(s);
            }
        });

        Queue<String> queue = new LinkedList();

        queue.offer(beginWord);

        Set<String> set = new HashSet<>();
        int level = 1;
        while (!queue.isEmpty()){
            for (int i = 0; i < queue.size(); i++) {
                String poll = queue.poll();

                if (poll.equals(endWord)) {
                    return level;
                }

                for (int j = 0; j < length; j++) {
                    String replace = poll.replace(poll.charAt(j), wildcard);
                    List<String> list = dict.get(replace);
                    if (list != null) {
                        list.removeAll(set);
                        queue.addAll(list);
                        set.addAll(list);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {

        LadderLength ll = new LadderLength();
        List<String> list = new ArrayList<>();
        list.add("ted");
        list.add("tex");
        list.add("red");
        list.add("tax");
        list.add("tad");
        list.add("den");
        list.add("rex");
        list.add("pee");

        int ladderLength = ll.ladderLength("red", "tax", list);

        System.out.println(ladderLength);
    }

}
