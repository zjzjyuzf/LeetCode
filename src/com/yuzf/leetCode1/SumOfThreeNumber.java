package com.yuzf.leetCode1;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 
 * 15. 三数之和
 * 			给定一个含有n个整数的数组S，找出其中的所有的三元组，使得三元组中3个整数a,b,c满足a+b+c=0.
		注意：返回的结果不能包含重复的三元组.
 * 例如，对于给定数组
 * 		 S = [-1, 0, 1, 2, -1, -4]
		返回的结果是：
			[
			  [-1, 0, 1],
			  [-1, -1, 2]
			]
 * 
 * 
 * @author yuzf
 *
 */
public class SumOfThreeNumber {

	public List<Vector<Integer>> sumOfThreeNumber(int[] arr){
		
		/**
		 * 解题思路
		 * 1.先对arr进行排序
		 * 2.定义两个循环,三个索引,
		 * 				i:最外层循环,从头便利到尾
		 * 				j:从j+1开始遍历,判断arr[i] + arr[j] ? arr[k]
		 * 				k:第一层循环每循环一次,重新赋值为 arr.length -1
		 * 要点:
		 * 		当arr[i] == arr[i-1] 时 直接跳过
		 */
//		Vector<Integer> v = new Vector<Integer>();
		
		List<Vector<Integer>> result = new ArrayList<Vector<Integer>>();
		
		
		
		
		return result;
	}
	
	
}
