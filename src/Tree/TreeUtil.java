package Tree;

/**
 * @ClassName TreeUtil
 * @Descrption TODO
 * @Author lt
 * @Date 2019/6/30 9:22
 * @Version 1.0
 **/
public class TreeUtil {
    public static TreeNode initTree() {
        TreeNode root = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(3);
        root.left = node11;
        root.right = node12;
        TreeNode node21 = new TreeNode(4);
        TreeNode node22 = new TreeNode(5);
        node11.left = node21;
        node11.right = node22;
        TreeNode node23 = new TreeNode(6);
        TreeNode node24 = new TreeNode(7);
        node12.left = node23;
        node12.right = node24;
        return root;
    }

}
