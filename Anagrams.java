/*
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
*/

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        HashMap<String,String> dictionary = new HashMap<String,String>();
        ArrayList<String> res = new ArrayList<String>();
        for(String s : strs) {
            String sorted = sortStr(s);
            if (dictionary.containsKey(sorted)) {
                if (dictionary.get(sorted) != null) {
                    res.add(dictionary.get(sorted));
                    dictionary.put(sorted,null);
                }
                res.add(s);
            }
            else {
                dictionary.put(sorted,s);
            }
        }
        
        return res;
    }
    
    public String sortStr(String s) {
        if (s==null) return null;
        if (s.length() == 1) return s;
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}

