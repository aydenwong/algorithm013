package com.ayden.algorithm.code.recursion.study;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 括号生成
 * @author: aydenwang
 * @create: 2020-08-11 08:50
 * @version: 1.0.0
 **/
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
            // System.out.println(current);
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return (balance == 0);
    }

    public static void main(String[] args) {
        new GenerateParenthesis().generateParenthesis(1);
    }
}
