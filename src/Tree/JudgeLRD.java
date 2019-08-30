package Tree;

/**
 * @ClassName JudgeLRD   <link> https://blog.csdn.net/u013132035/article/details/80607000 </link>
 * @Descrption 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * // 二叉搜索树：空树或者二叉树的所有结点比它的左子结点大，比它的右子结点小
 * // 在后序遍历得到的序列中，最后一个数字是树的根结点的值。
 * // 数组中前面的数字可以分为两部分：
 * //     第一部分是左子树结点的值，它们都比根结点的值小；
 * //     第二部分是右子树结点的值，它们都比根结点的值大。
 * public class Solution {
 *     public boolean VerifySquenceOfBST(int [] sequence) {
 *             int root = sequence[sequence.length() - 1];
 *     }
 * }
 * @Author lt
 * @Date 2019/5/26 19:04
 * @Version 1.0
 **/
public class JudgeLRD {
    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 3};
        if (verifySquenceOfBST(array1)) {
            System.out.println("yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean verifySquenceOfBST(int [] sequence) {
        int length = sequence.length;
        if (null == sequence || length == 0) {
            return false;
        }
        return (recursiveJudgeLRD(sequence, 0, length - 1));
    }

    private static boolean recursiveJudgeLRD(int[] sequence, int start, int end) {
        if(start >= end){
            return true;
        }
        int root = sequence[end];
        int i = 0;
        for (; i < end; i++) {
            if (sequence[i] > sequence[end]) {
                break;
            }
        }
        // 确定右子树的起始索引
        int j = i;
        for (; j < end; j++) {
            if (sequence[j] < sequence[end]) {
                return false;
            }
        }

        boolean left = true;
        if (i > start) {
            left = recursiveJudgeLRD(sequence, start, i - 1);
        }

        boolean right = true;
        if (i < end) {
            right = recursiveJudgeLRD(sequence, j, end - 1);
        }

        return (left && right);
    }
}
