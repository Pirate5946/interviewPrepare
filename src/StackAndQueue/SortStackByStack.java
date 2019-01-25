package StackAndQueue;

/**
 * Created by lt on 2019/1/19.
 */

import java.util.Stack;

/**
 * 利用一个栈和变量，对另一个栈进行排序
 */
public class SortStackByStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(312);
        stack.push(123);
        stack.push(1244);
        stack.push(1233);
        sortStack(stack);
        System.out.println(stack);
    }

    Stack<Integer> stack = new Stack<>();

    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            while(!help.isEmpty() && help.peek() < pop) {
                stack.push(help.pop());
            }
            help.push(pop);
        }

        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
