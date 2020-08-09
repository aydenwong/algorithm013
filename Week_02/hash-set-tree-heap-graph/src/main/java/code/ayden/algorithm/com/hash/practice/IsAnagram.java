package code.ayden.algorithm.com.hash.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 有效的字母异位词
 * @author: aydenwang
 * @create: 2020-08-06 08:27
 * @version: 1.0.0
 **/
public class IsAnagram {

    /**
     * 先排序，再比较
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    /**
     * 对字符串中出现的字符，映射成对应的ascci码，hash表存储ascci码作为key，字母出现次数作为value
     * s的字符+1，t的字符-1，最后比较value是不是为0
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramHash(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hash[c - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            hash[c - 'a']--;
            if (hash[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
