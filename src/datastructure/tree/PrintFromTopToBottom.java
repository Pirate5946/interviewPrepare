package datastructure.tree;

import java.util.ArrayList;

/**
 * @ClassName PrintFromTopToBottom
 * @Descrption TODO
 * @Author lt
 * @Date 2019/6/9 21:41
 * @Version 1.0
 **/
public class PrintFromTopToBottom {
    public static void main(String[] args) {
        TreeNode root = TreeUtil.initTree();
        printFromTopToBottom(root);

    }
    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        ArrayList<TreeNode> tempList = new ArrayList<>();
        tempList.add(root);
        /**
         * 循环内的操作 ： 弹出父节点，添加子节点
         */
        while (tempList.size() > 0) {
            TreeNode node = tempList.remove(0);
            System.out.println(node.val);
            resultList.add(node.val);
            if (node.left != null) {
                tempList.add(node.left);
            }
            if (node.right != null) {
                tempList.add(node.right);
            }
        }
        return resultList;
    }

}
