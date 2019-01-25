package Tree;

import java.util.Stack;

/**
 * Created by lt on 2019/1/23.
 * desc: 遍历二叉树
 *          1. 递归 recursive
 *            1.1 先序遍历（根节点在前面）   根、左、右
 *            1.2 中序遍历（根节点在中间）   左、根、右
 *            1.3 后序遍历（根节点在后面）  左、右、根
 *          2. 非递归 （）
 */

public class TraverseTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    /**
     * 先序遍历
     * @param node
     */
    public void preOrderRecur(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value + " ");
        preOrderRecur(node.left);
        preOrderRecur(node.right);
    }

    /**
     * 中序遍历   左、根、右
     * @param node
     */
    public void inOrderRecur(Node node) {
        if (node == null) {
            return;
        }
        inOrderRecur(node.left);
        System.out.println(node.value + " ");
        inOrderRecur(node.right);
    }

    /**
     * 后序遍历 左、右、根
     * @param node
     */
    public void postOrderRecur(Node node) {
        if (node == null) {
            return;
        }

        postOrderRecur(node.left);
        postOrderRecur(node.right);
        System.out.println(node.value + " ");
    }

    /**
     * 先序遍历  非递归实现
     * 考虑 单个分叉时应该怎么做， 后进先出，有子节点的话、先右节点入栈，然后左节点入栈
     *      1. 入栈顺序  右（如果有）、左（如果有）
     *     2. 出栈顺序  左（如果有）、右（如果有）
     **/
    public void preOrderUnRecur(Node root) {
        System.out.println("pro-order : ");
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(root);
//            System.out.println(root.value + " ");
            while (!stack.isEmpty()) {
                Node head = stack.pop();
                System.out.println(head.value + " ");
                if (null != head.right) {
                    stack.push(head.right);
                }
                if (null != head.left) {
                    stack.push(head.left);
                }
            }
        }
    }

    /**
     * 中序遍历  非递归实现     先把 根节点的左子树 入栈
     * 从局部来看  左、根、右
     */
    public void inOrderUnRecur(Node root) {
        System.out.println("in-order :");
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) { // 重置root，以及判断 root 是否为空 ，很重要
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.println(root.value + " ");
                    root = root.right;
                }

            }
        }


    }
}
