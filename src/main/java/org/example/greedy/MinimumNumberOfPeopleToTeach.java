package org.example.greedy;

import java.util.HashSet;
import java.util.Set;

public class MinimumNumberOfPeopleToTeach {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int [] freq = new int [n + 1];
        int max = 0;
        int common = -1;
        Set<Integer> noSpeak = new HashSet<>();
        for (int [] friend : friendships) {
            int f1 = friend[0] - 1;
            int f2 = friend[1] - 1;
            Set<Integer>set1=new HashSet<>();
            Set<Integer>set2=new HashSet<>();
            for (int i = 0; i < languages[f1].length; i++) {
                set1.add(languages[f1][i]);
            }
            for (int j = 0; j < languages[f2].length; j++) {
                set2.add(languages[f2][j]);
            }
            set1.retainAll(set2);
            if (set1.size() == 0) {
                noSpeak.add(f1);
                noSpeak.add(f2);
            }
        }
        int result = 0;
        for (int f : noSpeak) {
            for (int l : languages[f]) {
                freq[l] += 1;
            }
        }
        for (int num : freq) {
            if (num > result) {
                result = num;
            }
        }
        return noSpeak.size() - result;
    }
}
