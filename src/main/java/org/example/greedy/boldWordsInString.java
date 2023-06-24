package org.example.greedy;

public class boldWordsInString {
    public String boldWords(String[] words, String s) {
        StringBuilder sb = new StringBuilder();
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            for (String word : words) {
                if(s.startsWith(word, i)) {
                    if(index < i) {
                        sb.append("<b>");
                    }
                    index = Math.max(index, i + word.length());
                }
            }
            if(index == i) {
                sb.append("</b>");
            }
            sb.append(s.charAt(i));
        }
        if(index == s.length()) {
            sb.append("</b>");
        }
        return sb.toString();
    }
}
