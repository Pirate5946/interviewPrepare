package Tree;

/**
 * If you can access a binary tree {@link TreeNode} from its {@param root}, could your find the
 * {@return length} of the longest path  that appear in the array of given {@param nodeValues}.
 * <p>
 * A "path" is a one-way linked list that starts from a parent node and ends with one of its
 * sub nodes.
 * <p>
 * For example 1:
 * 3
 * /  \
 * 5   4
 * /  \   \
 * 7  11   2
 * <p>
 * root = TreeNode{ val = 3, left=TreeNode(5), right = TreeNode(4) }
 * nodeValues = int[] {5, 7, 11, 4}
 * <p>
 * result: 2
 * longest path: 5 -> 7 and 5 -> 11
 * <p>
 * For example 2:
 * 11
 * /   \
 * 1     5
 * /  \
 * 3   8
 * \
 * 4
 * <p>
 * root = TreeNode{ val = 11, left=TreeNode(1), right = TreeNode(5) }
 * nodeValues = int[] {4, 1, 11, 5, 8}
 * <p>
 * result: 4
 * longest path: 11 -> 1 -> 8 -> 4
 * <p>
 * <p>
 * <p>
 * Please note:
 * 1. {@link TreeNode#val} of every {@link TreeNode} is unique.
 * 2. Values of {@link TreeNode#val} are random.
 * 3. Values in {@param nodeValues} are in random sequence, only part of tree nodes
 * are given in the array.
 * 3. Every value present in {@param nodeValues} must have a valid {@link TreeNode}
 * in the tree.
 * 4. Just return the {@return length} is enough, no need to find the exact path.
 */
public class TreePath {

    // add data structure your need
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode11 = treeNode1.left;
        treeNode11 = new TreeNode(2);
        TreeNode treeNode3 = treeNode11.left;
        treeNode3 = new TreeNode(2);
        TreeNode treeNode111 = treeNode11.left;
        treeNode111 = new TreeNode(2);
        int[] intArray = {};
        System.out.println(longestPath(treeNode1, intArray));
    }

    // Definition for a binary tree node
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int longestPath(TreeNode root, int[] nodeValues) {
        // implement your method
        if (root == null)
            return 0;
        int left = longestPath(root.left, nodeValues);
        int right = longestPath(root.right, nodeValues);
//            return Math.max(left+1, right+1);
        return (left > right) ? (left + 1) : (right + 1);
    }
}

/**
 * FQ & A
 * Q1: Can root node be null?
 * A1: Yes, of course. And nodeValues also can
 * <p>
 * Q2: Do I need to provide test cases?
 * A2: Not necessary, but test is always encouraged(bonus).
 * <p>
 * Q3: I do have an idea, but I don't think my code is working upon the deadline.
 * A3: Your idea counts. Submit your unfinished code before deadline and send your
 * fished code with a follow up AS SOON AS POSSIBLE.
 * <p>
 * Q4: What F**K is this talking about? 如果你完全看不懂。
 * A4: Just ask. 请联系工作人员，并指出无法理解的点或原因
 */
