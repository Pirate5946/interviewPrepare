package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode40_CombinationSum2 {

	public static void main(String[] args) {

		int[] candidates = new int[]{1,3,8,5,1,2};
		System.out.println("results: "+combinationSum2(candidates,17));
	}
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		   List<List<Integer>> list = new LinkedList<List<Integer>>();
		   Arrays.sort(candidates);
		   backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
		   return list;
		}

		private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int target, int start) {
		   
		   if(target < 0) return; /** no solution */
		   else if(target == 0) list.add(new ArrayList<>(tempList));
		   else{
		      for (int i = start; i < cand.length; i++) {
		    	  // && 同真为真  ;  || 同假为假  
		    	 if(i > start && cand[i] == cand[i-1]) {
		    		 System.out.println("i :"+i);
		    		 System.out.println("start :"+start);
		    		 continue; /** skip duplicates */
		    	 }
		         tempList.add(cand[i]);
		         System.out.println(cand[i]);
		         System.out.println("tempList :"+tempList+"   list :"+list+"  start :"+start+"   target :"+target+"    i :"+i);
		         backtrack(list, tempList, cand, target - cand[i], i+1);
		         System.out.println("tempList :"+tempList+"   list :"+list+"  start :"+start+"   target :"+target+"    i :"+i+" ...");
		         tempList.remove(tempList.size() - 1);
		      }
		   }
		}
}
