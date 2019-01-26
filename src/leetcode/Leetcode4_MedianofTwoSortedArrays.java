package leetcode;
import java.util.Arrays;

/*
  注意边界条件判断
  1. 合并两个数组，重新排序 (http://blog.csdn.net/jaycee110905/article/details/9179227)
  2. 判断数组个数，奇数取    int[length << 1 + 1]  ; 偶数取 (int[length << 1] + int[length << 1] + 1) / 2
*/
class Leetcode4_MedianofTwoSortedArrays {
	public static void main(String[] args) {
		int[] nums1 = new int[]{1,5};
		int[] nums2 = new int[]{2,3};
		
		findMedianSortedArrays(nums1, nums2);
	}
	
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0)
            return 0;
        
        //int[] nums = (int[])ArrayUtils.addAll(nums1,nums2);
      //int[] nums = (int[])ArrayUtils.addAll(nums1,nums2);
        int length = nums1.length + nums2.length;
        int[] nums = new int[length];
        System.arraycopy(nums1, 0, nums, 0, nums1.length);
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
        Arrays.sort(nums);
        
        if (length % 2 == 0){
            return (nums[length / 2 - 1] + nums[length / 2]) / 2.0;
        }
        return nums[length / 2] / 1.0;
    }
}