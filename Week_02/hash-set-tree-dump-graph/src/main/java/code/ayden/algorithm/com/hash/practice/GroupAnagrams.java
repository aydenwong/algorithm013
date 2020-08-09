package code.ayden.algorithm.com.hash.practice;

import java.util.*;

/**
 * @description: 字母异位词分组
 * @author: aydenwang
 * @create: 2020-08-06 09:13
 * @version: 1.0.0
 **/
public class GroupAnagrams {

    /**
     * 思路：对每个字符串排序，排序后的字符串作为key，value是相同排序的StringList，存到hash表中。
     * 最后输出value
     *
     * 时间复杂度：O(nklogk)
     * n 是strs规模，k是最大字符的长度。因为排序最快也要k *log k 的时间复杂度。
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagramsSort(String[] strs) {
        Map<String, List<String>> hashTable = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String hash = String.valueOf(chars);
            List<String> strings = hashTable.putIfAbsent(hash, new ArrayList<>());
            if (strings != null) {
                strings.add(str);
            }else{
                hashTable.get(hash).add(str);
            }
        }
        return new ArrayList<>(hashTable.values());
    }

    /**
     * 思路：对每个字符串，转化为对应的assic码出现的次数的排列，作为key，value是相同排序的StringList，存到hash表中。
     * 相比排序法，复杂度从O(nklogk) -> O(n)
     * 复杂度反映的是随着数据规模增长，程序执行时间的变化趋势。所以这种方法在字符串很多的情况下，确实会比排序法快一些。
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagramsHash(String[] strs) {
        Map<String, List<String>> hashTable = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            int[] keyCode = new int[26];
            Arrays.fill(keyCode,0);
            for (int i1 = 0; i1 < chars.length; i1++) {
                keyCode[chars[i1]-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < keyCode.length; k++) {
                int j = keyCode[k];
                sb.append(j);
            }
            String hash = sb.toString();
            List<String> strings = hashTable.putIfAbsent(hash, new ArrayList<>());
            if (strings != null) {
                strings.add(str);
            }else{
                hashTable.get(hash).add(str);
            }
        }
        return new ArrayList<>(hashTable.values());
    }

    public static void main(String[] args) {
        String str= "abc";
        char[] chars = str.toCharArray();
        for (int i1 = 0; i1 < chars.length; i1++) {
            System.out.println(chars[i1]);
            System.out.println(chars[i1]-'a');
        }
    }

}
