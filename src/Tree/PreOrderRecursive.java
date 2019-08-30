package Tree;

/**
 * @ClassName PreOrderRecursive
 * @Descrption TODO
 * @Author lt
 * @Date 2019/6/9 21:12
 * @Version 1.0
 **/
public class PreOrderRecursive {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.initTree();
        preOrderRecur(root);
    }

    private static void preOrderRecur(TreeNode root) {
        if (root == null) {
            return ;
        }
        System.out.println(root.val);
        preOrderRecur(root.left);
        preOrderRecur(root.right);

    }

}
