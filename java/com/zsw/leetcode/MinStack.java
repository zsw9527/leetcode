package com.zsw.leetcode;

import java.util.Stack;

public class MinStack {

        /** initialize your data structure here. */
        private Stack<Integer> stack;

        private Stack<Integer> helper;

        public MinStack() {
            stack = new Stack<>();
            helper = new Stack<>();
        }
        
        public void push(int x) {
            stack.push(x);
            if (helper.isEmpty() || x <= helper.peek()) {
                helper.push(x);
            } else {
                helper.push(helper.peek());
            }
        }
        
        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
            }
            if (!helper.isEmpty()) {
                helper.peek();
            }
        }
        
        public int top() {
            return stack.peek();
        }
        
        public int getMin() {
            return helper.peek();
        }

        public static void main(String[] args) {
            MinStack minStack = new MinStack();
            minStack.push(9);
            minStack.push(2);
            minStack.push(24);
            System.out.println(minStack.getMin());
        }
}