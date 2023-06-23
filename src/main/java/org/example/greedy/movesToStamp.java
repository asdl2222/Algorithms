package org.example.greedy;

import java.util.Stack;

public class movesToStamp {
    String t;
    public int[] movesToStamp(String stamp, String target) {
        // try to match word with ? mark. If it is true, we will change to ? and add current index.
        // it may possible we can't substitute anymore, so use flag to check and return it.
        // match with ? will continue and character match -> change flag and return it.
        this.t = target;
        int m = target.length();
        boolean change = true;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append('?');
        }
        while (change) {
            change = false;
            for (int i = 0; i < m; i++) {
                if(swap(i, stamp)) {
                    target = t;
                    change = true;
                    stack.push(i);
                }
            }
        }
        if (stack.size() == 0 || !t.equals(sb.toString())) {
            return new int [0];
        }
        int [] result = new int [stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
    public boolean swap(int start, String stamp) {
        StringBuilder sb = new StringBuilder(t);
        int i = 0;
        boolean find = false;
        while (i < stamp.length() && start < t.length()) {
            char c1 = stamp.charAt(i);
            char c2 = sb.charAt(start);
            if (c2 == '?') {
                i += 1;
                start += 1;
            }
            else if (c1 == c2) {
                sb.setCharAt(start, '?');
                i += 1;
                start += 1;
                find =  true;
            }
            else {
                break;
            }
        }

        if(i == stamp.length() && find) {
            t = sb.toString();
            return true;
        }
        return false;
    }
}
