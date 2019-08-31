package datastructure.stackandqueue;

import java.util.Stack;

/**
 * Created by lt on 2019/1/18.
 */
public class GetMinStack {
    private Stack stackData;
    private Stack stackMin;

    public static void main(String[] args) {
        GetMinStack getMinStack = new GetMinStack();
        getMinStack.push(1);
        getMinStack.push(2);
        System.out.println(getMinStack.getMin());
    }
    public GetMinStack() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    /**
     * 当前数据入栈之前跟 stackMin的栈顶元素比较
     * @param number
     */
    public void push(int number) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(number);
        } else if (number <= this.getMin()) {
            this.stackMin.push(number);
        }
        stackData.push(number);
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("这是一个空栈！！！");
        }
        int value = (int) this.stackData.pop();
        int minValue = (int) this.stackMin.peek();
        if (value == minValue) {
            this.stackMin.pop();
        }
        return value;
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("这是一个空栈！！！");
        }
        return (int) this.stackMin.peek();
    }
}
