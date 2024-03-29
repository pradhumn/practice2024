package com.git.practice;

public class MainHandler {

	public static void main(String[] args) {

		// int[] ary = { 1, 2, -3, 4, 5, -9, 9, -9, 8, 5 };
		// System.out.println(maxSumSubarray(ary));

		// int[] ary = {1, 2, 1, 4 ,7 ,8};
		// System.out.println(containerWithMostWater(ary));

		// int[] ary = { 2, 0, 2 };
		// System.out.println(trappingRainWaterProb(ary));

		// print frequency of sorted element
		int[] ary = { 1, 1, 3, 4, 5, 6, 6, 6, 7, 7, 8, 8, 9, 10 };
		printfrq(ary);

	}

	private static void printfrq(int[] ary) {
		int count = 1;
		for (int i = 1; i < ary.length; i++) {
			if (ary[i - 1] == ary[i]) {
				count++;
				if (i == ary.length - 1)
					System.out.println(ary[i] + "=" + count);

			} else {

				System.out.println(ary[i - 1] + "=" + count);
				if (i == ary.length - 1)
					System.out.println(ary[i] + "=" + count);

				if (count > 1)
					count = 1;
			}

		}
	}

	private static int trappingRainWaterProb(int[] ary) {
		int left = 0;
		int right = ary.length - 1;
		int leftMax = 0;
		int rightMax = 0;
		int ans = 0;

		while (left < right) {
			if (ary[left] <= ary[right]) {
				if (ary[left] > leftMax)
					leftMax = ary[left];
				else
					ans = ans + (leftMax - ary[left]);
				left++;
			}

			else {
				if (ary[right] > rightMax)
					rightMax = ary[right];

				else
					ans = ans + (rightMax - ary[right]);
				right--;

			}

		}
		return ans;
	}

	private static int containerWithMostWater(int[] ary) {
		int left = 0;
		int right = ary.length - 1;

		int ans = 0;
		while (left < right) {

			int water = Math.min(ary[left], ary[right]) * (right - left);

			if (water > ans)
				ans = water;

			if (ary[left] < ary[right])
				left++;
			else
				right--;

		}

		return ans;
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
