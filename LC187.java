// TC: O(n)
// SC: O(n)

import java.util.*;

// Approach: Rolling Hash
public class LC187 {
    private int getIndex(char ch){
        switch(ch){
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
        }
        return -1;
    }
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        if(n<=10) return ans;
        HashMap<Integer, Integer> map = new HashMap<>();
        int hash = 0;
        for(int i=0;i<10;i++){
            int idx = getIndex(s.charAt(i));
            hash <<= 2;
            hash |= idx;
        }
        map.put(hash, 1);
        for(int i=10;i<n;i++){
            int idx = getIndex(s.charAt(i));
            hash <<= 2;
            hash |= idx;
            hash &= ~(3<<20);
            map.put(hash, map.getOrDefault(hash, 0)+1);
            if(map.get(hash)==2) ans.add(s.substring(i-9, i+1));
        }
        return ans;
    }
}


// Approach: Just Hashing
// TC: O(n)
// SC: O(n)

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        if (n <= 10)
            return ans;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 9; i < n; i++) {
            String ss = s.substring(i - 9, i + 1);
            map.put(ss, map.getOrDefault(ss, 0) + 1);
            if (map.get(ss) == 2)
                ans.add(ss);
        }
        return ans;
    }
}