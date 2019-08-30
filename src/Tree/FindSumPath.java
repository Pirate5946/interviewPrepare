package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @ClassName FindSumPath
 * @Descrption TODO
 * @Author lt
 * @Date 2019/6/8 16:48
 * @Version 1.0
 **/
public class FindSumPath {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode leave21 = new TreeNode(2);
         root.left = leave21;
        TreeNode leave22 = new TreeNode(3);
        root.right = leave22 ;
        TreeNode leave31 = new TreeNode(4);
        leave21.left = leave31 ;
        TreeNode leave41 = new TreeNode(5);
        leave31.left = leave41;

        ArrayList<ArrayList<Integer>> allPath = findAllPath(root, 6);
        System.out.println(allPath);
    }

    public static ArrayList<ArrayList<Integer>> findAllPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> allPath = new ArrayList<>();
        if (root == null) {
            return allPath;
        }
        ArrayList<Integer> path = new ArrayList<>();

        findPath(root, allPath, path, target);

        Collections.sort(allPath, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.size()>o2.size()) {
                    return -1;
                } else if(o1.size()==o2.size()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        return allPath;
    }

    private static void findPath(TreeNode root, ArrayList<ArrayList<Integer>> allPath,
                          ArrayList<Integer> path, int target) {
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (target == root.val) {
                allPath.add(path);
            }
            return;
        }
        if (target < root.val) {
            return;
        }

        // 这个path2 变量很关键 ；
        // 它是递归内部 每一层 new出来的变量，所以他记忆着每一层的变量 ： 具有记忆属性
        ArrayList<Integer> path2 = new ArrayList<>(path);

        if (root.left != null) {
            findPath(root.left, allPath, path, target - root.val);
        }
        if (root.right != null) {
            findPath(root.right, allPath, path2, target - root.val);
        }
    }

}
