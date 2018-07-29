package com.yuzf.other;

import org.junit.Assert;
import org.junit.Test;

/**
 * 调整队形
 * 在幼儿园有n个小朋友排列为一个队伍，从左到右一个挨着一个编号为(0~n-1)。其中有一些是男生，有一些是女生，男生用’B’表示，女生用’G’表示。
 * 小朋友们都很顽皮，当一个男生挨着的是女生的时候就会发生矛盾。作为幼儿园的老师，你需要让男生挨着女生或者女生挨着男生的情况最少。
 * 你只能在原队形上进行调整，每次调整只能让相邻的两个小朋友交换位置，现在需要尽快完成队伍调整，你需要计算出最少需要调整多少次可以让上述情况最少。例如：
 * GGBBG -> GGBGB -> GGGBB 这样就使之前的两处男女相邻变为一处相邻，需要调整队形2次 输入描述:
 * 输入数据包括一个长度为n且只包含G和B的字符串.n不超过50. 输出描述: 输出一个整数，表示最少需要的调整队伍的次数 输入例子: GGBBG 输出例子:
 * 2
 * 
 * 
 * @author yuzf
 *
 */

public class AdjustmentFormation {

	/**
	 * 只有两种可能 全在右边或者全在左边
	 * 我们不妨考虑B，我们可以事先求出B全部在左边和全部在右边两种情况下的和。
	 * 然后对当前每个B的下标求和，显然我们每进行一次有用的调整必然使当前的和+1或者-1。
	 * 那么，我们只要计算出当前的和与最终结果的和的差就行了，由于最终结果有两种情况，我们取最小值即可。
	 */
	public int leastTimes(String queue) {

		char[] charArr = queue.toCharArray();

		int countB = 0; //用于计算B的个数

		int indexB = 0; //用于计算当前B下标的和
		
		for (int i = 0; i < charArr.length - 1; i++) {

			if (charArr[i] == 'B') {
				indexB += i ;
				countB ++;
			}
				
		}
		
		int length = charArr.length;
		
		//计算B全在右边的时候下标值
		int Rcount = ((length - countB) + (length - 1)) * countB / 2 ;
		//计算B全在zuo边的时候下标值
		int Lcount = (countB - 1)*countB/2;
		
//		System.out.println(indexB);
//		System.out.println(Lcount);
//		System.out.println(Rcount);
		
		return Math.min(Math.abs(indexB - Rcount), Math.abs(indexB - Lcount));
	}

	@Test
	public void test() {

		int temp = leastTimes("GGBBG");

		Assert.assertEquals(2, temp);
	}

}
