package com.array;

public class TwoD {
	public static void main(String[] args) {
		int[][] a = new int[2][3];
		for(int[] temp : a) {
			for(int tempInt : temp) {
				System.out.print(tempInt+" ");
			}
			System.out.println();
		}
		
		int[][] arr = new int[2][];
		
		arr[0] = new int[] {2,4,1,5};
		arr[1] = new int[] {1,2,3,4,5,5,6,6};
		
		for(int[] temp : arr) {
			for(int i : temp) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		int[][] arr1 = new int[][] {{1,3,4},{1,6,6,4},{6,8}};
		for(int[] temp : arr1) {
			for(int i : temp) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
