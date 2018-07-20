package com.yuzf.other;

/**
 * 
 * 旋涡矩阵
 * 
 * @author yuzf
 *
 */

public class Matrix {

	public static void main(String[] args) {
		int n=5;
		int[][] arr = print(n);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}

	
	public static int[][] print(int n){
		int[][] arr = new int[n][n];
		int x=0,y=-1;
		int temp=1;
		int k=n;   //最大索引
		int g=0;	//最小索引
		while(n>0){
			y+=1;
			for(int j=y;j<k;j++){	
				y=j;
				arr[x][y] = temp;
				temp++;
			}
			temp--;//边界处赋值两次
			for(int i=x;i<k;i++){				
				x=i;
				arr[x][y]=temp;
				temp++;
			}
			temp--;
			for(int j=k-1;j>=g;j--){				
				y=j;
				arr[x][y]=temp;
				temp++;
			}
			temp--;
			for(int i=k-1;i>g;i--){		
				x=i;
				arr[x][y]=temp;
				temp++;
			}		
			n-=2;
			k--;
			g++;
		}
		return arr;
	}	
}
