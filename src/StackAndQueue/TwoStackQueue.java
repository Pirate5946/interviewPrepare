package StackAndQueue;/**
 * Created by lt on 2019/1/26.
 */

import java.util.Stack;

/**
 * @ClassName TwoStackQueue
 * @Descrption 用两个栈实现队列、支持队列的基本操作（add、poll、peek）
 * @Author lt
 * @Date 2019/1/26 15:01
 * @Version 1.0
 **/
public class TwoStackQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStackQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void add(int pushInt) {
        stackPush.push(pushInt);
    }

    public int poll() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty");
        } else if (stackPop.empty()) {
            stackPop.push(stackPush.pop());
        }
        return stackPop.peek();
    }
}
