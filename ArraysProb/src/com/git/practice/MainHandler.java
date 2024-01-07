package com.git.practice;

public class MainHandler {

	public static void main(String[] args) {

		int[] ary = { 1, 2, -3, 4, 5, -9, 9, -9, 8, 5 };
		System.out.println(maxSumSubarray(ary));
	}

	public static int maxSumSubarray(int[] ary) {
		int maxSum = 0;
		int curSum = 0;

		for (int i = 0; i < ary.length; i++) {
			curSum = curSum + ary[i];

			if (curSum <= 0) {
				curSum = 0;
			}

			if (maxSum < curSum) {
				maxSum = curSum;
			}

		}
		return maxSum;
	}

}
