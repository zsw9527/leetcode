package com.zsw.swordoffer;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q5 {
    public String replaceSpace(String s) {
//        return s.replaceAll(" ", "%20");
        StringBuilder sb = new StringBuilder("");

        for (char c : s.toCharArray()) {
            if (c != ' ') {
                sb.append(c);
            } else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q5 q5 = new Q5();
        System.out.println(q5.replaceSpace("We are happy."));
    }
}
