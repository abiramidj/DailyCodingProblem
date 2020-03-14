package com.dailycoding.solved;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Given an arithmetic expression in Reverse Polish Notation, write a program to evaluate it.
 * The expression is given as a list of numbers and operands. For example: [5, 3, '+'] should return 5 + 3 = 8.
 * For example, [15, 7, 1, 1, '+', '-', '/', 3, '*', 2, 1, 1, '+', '+', '-'] should return 5,
 * since it is equivalent to ((15 / (7 - (1 + 1))) * 3) - (2 + (1 + 1)) = 5.
 * You can assume the given expression is always valid.
 * """
 *
 *
 */

public class ReversePolishNotation {

    static Set<String> expressions = new HashSet<>();
    static {
        expressions.add("+");
        expressions.add("-");
        expressions.add("/");
        expressions.add("*");
    }

    public static void main(String[] args) {
        String[] expr = {"15", "7", "1", "1", "+", "-", "/", "3", "*", "2", "1", "1", "+", "+", "-"};
        System.out.println(new ReversePolishNotation().calculate(expr));
    }

    private int calculate(String[] input){
        Stack<Integer> numbers = new Stack<>();
        int first = 0, second = 0;
        for (String val:input){
            if(expressions.contains(val)){
                second = numbers.pop();
                first = numbers.pop();
                numbers.push(executeExpression(first, second, val));
            }else {
                numbers.push(Integer.valueOf(val));
            }
        }

        return numbers.pop();
    }

    private int executeExpression(int first, int second, String expr){
        if("+".equalsIgnoreCase(expr)){
            return first + second;
        }else if("-".equalsIgnoreCase(expr)){
            return first - second;
        }else if("*".equalsIgnoreCase(expr)){
            return first*second;
        }else {
            return first/second;
        }

    }
}
