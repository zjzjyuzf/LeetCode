package com.yuzf.leetCode1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.Test;



/**
 * 89. 格雷编码
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 * 示例1:
		输入: 2
		输出: [0,1,3,2]
		解释:
		00 - 0
		01 - 1
		11 - 3
		10 - 2
		对于给定的 n，其格雷编码序列并不唯一。
		例如，[0,2,3,1] 也是一个有效的格雷编码序列。
		00 - 0
		10 - 2
		11 - 3
		01 - 1
 * 示例2:
 * 		输入: 0
		输出: [0]
		解释: 我们定义格雷编码序列必须以 0 开头。
     	给定编码总位数为 n 的格雷编码序列，其二进制长度为 n,数组大小为2的n次, 当 n = 0 时，长度为 2的0次 = 1。
     	因此，当 n = 0 时，其格雷编码序列为 [0]。
 * @author yuzf
 *
 */
public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> list = new ArrayList<Integer>();
		/**
		 * yuzf解题思路
		 * 	计算位数,初始化2的n次个0的字符串
		 * 	字符串转换为字符数组
		 * 	每次随机转一个,1->0,0->1 与之前记录下来的做比较有就存,无就再执行,并记录下来
		 * 	每次记录一个新的,转化为数字,并添加到 list中
		 * 	效率问题怎么解决?
		 * 	
		 */
//		int length1 = (int) Math.pow(2,n-1);
		int length1 = n;
		int length2 = (int) Math.pow(2,n);
		
		StringBuffer strbuf = new StringBuffer();
		int i = 0;
		while(i < length1) {
			strbuf.append("0");
			i++;
		}
		String str = strbuf.toString();
		//字符串转化为数字字符
		char[] charArr = str.toCharArray();
		
//		System.out.println(charArr);
		
        //生成随机数
        Integer number = createRandom(length1);
		
		List<String> tempList = new ArrayList<>();
		tempList.add(str);
		while(tempList.size() < length2) {
			change120(charArr,number);
//			System.out.println(charArr.toString());   垃圾东西
//			System.out.println("-------------------");
//			System.out.println(String.valueOf(charArr));
        	if(! tempList.contains(String.valueOf(charArr))) {
        		tempList.add(String.valueOf(charArr));
        	}
        	number = createRandom(length1);
		}
		
		//二进制转化为十进制
		for(String s : tempList) {
//			System.out.println(Integer.valueOf(s,2));
//			list.add(Biannary2Decimal(s));
			list.add(Integer.valueOf(s,2));
		}
		
		return list;
    }
	
	//生成比length小的
	public static int createRandom(int length) {
		Random random = new Random();
		return random.nextInt(length);
	}
	
	//数字字符转化
	public static void change120(char[] arr,int index) {
		
		char ch = arr[index];
		if(ch == '0') {
			arr[index] = '1';
		}else {
			arr[index] = '0';
		}
//		System.out.println(arr);
	}
	/**
     * 讲10 进制转化为二进制
     * @param de ：待转换的十进制
     * @return   ：转换后的二进制（string）
     */
    public static String Decimal2Binary(int de){
        String numstr = "";
        while (de>0){
        int res = de%2; //除2 取余数作为二进制数
        numstr = res + numstr;
        de = de/2;
        }
        return  numstr;
    }
    /**
     * 将二进制转换为10进制
     * @param bi ：待转换的二进制
     * @return
     */
    public  static  Integer Biannary2Decimal(String binStr){
//        String binStr = bi+"";
        Integer sum = 0;
        int len = binStr.length();
        for (int i=1;i<=len;i++){
            //第i位 的数字为：
            int dt = Integer.parseInt(binStr.substring(i-1,i));
            sum+=(int)Math.pow(2,len-i)*dt;
        }
        return  sum;
    }
    
    @Test
    public void test() {
    	GrayCode grayCode = new GrayCode();
		List<Integer> list = grayCode.grayCode(4);
		System.out.println(list);
    }
}
/**
 * java进制转换
java中进行二进制，八进制，十六进制，十进制间进行相互转换      
十进制转成十六进制：
Integer.toHexString(int i)
十进制转成八进制
Integer.toOctalString(int i)
十进制转成二进制
Integer.toBinaryString(int i)
十六进制转成十进制
Integer.valueOf("FFFF",16).toString()
八进制转成十进制
Integer.valueOf("876",8).toString()
二进制转十进制
Integer.valueOf("0101",2).toString()
 */

