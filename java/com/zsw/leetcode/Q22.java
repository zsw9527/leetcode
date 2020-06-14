package com.zsw.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q22 {

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		generateParenthesis(res, 0, 0, sb, n);
		return res;
	}

	public void generateParenthesis(List<String> res, int left, int right, StringBuilder sb, int max) {
		if (sb.length() == 2 * max) {
			res.add(sb.toString());
			return;
		}
		if (left < max) {
			sb.append("(");
			generateParenthesis(res, left + 1, right, sb, max);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (right < left) {
			sb.append(")");
			generateParenthesis(res, left, right + 1, sb, max);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
