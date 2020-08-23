package com.ayden.algorithm.code.recursion.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 生成左右括号
 * @author: aydenwang
 * @create: 2020-08-17 09:21
 * @version: 1.0.0
 **/
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        char[] chars = new char[2 * n];
        generate(chars, 0, combinations);
        return combinations;
    }

    private void generate(char[] chars, int position, List<String> combinations) {
        if (position == chars.length) {
            if (valid(chars)) {
                combinations.add(new String(chars));
            }
        } else {
            chars[position] = '(';
            generate(chars, position + 1, combinations);

            chars[position] = ')';
            generate(chars, position + 1, combinations);
        }
    }

    private boolean valid(char[] chars) {
        int balance = 0;
        for (char aChar : chars) {
            if (aChar == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        new GenerateParenthesis().generateParenthesis(2);
    }

}
