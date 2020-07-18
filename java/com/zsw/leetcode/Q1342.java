package com.zsw.leetcode;


/**
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 * @author zsw
 *
 */
public class Q1342 {

	public int numberOfSteps (int num) {
		if (num == 0) return 0;
		if (num % 2 == 0) return 1 + numberOfSteps(num / 2);
		else return 1 + numberOfSteps(num-1);
    }
	
	public static void main(String[] args) {
		System.out.println(new Q1342().numberOfSteps(5));
		System.out.println(new Q1342().numberOfSteps(6));
		System.out.println(new Q1342().numberOfSteps(2));
	}
}
