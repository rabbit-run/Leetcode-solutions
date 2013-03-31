/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

public class Solution {
    public String addBinary(String a, String b) {
        int indexA = a.length()-1;
        int indexB = b.length()-1;
        ArrayList<Character> ac = new ArrayList<Character>();
        int carry = 0;
        
        while (indexA>=0 || indexB>=0) {
            int aBit = 0; 
            if (indexA>=0) {
                aBit = Character.getNumericValue(a.charAt(indexA));
            }
            int bBit = 0;
            if (indexB>=0) {
                bBit = Character.getNumericValue(b.charAt(indexB));
            }
            int sum = aBit + bBit + carry;
            
            if (sum >= 2) {
                carry = 1;
                sum -= 2;
            }
            else {
                carry = 0;
            }
            ac.add(Character.forDigit(sum,10));
            indexA--;
            indexB--;
        }
        if (carry == 1) {
            ac.add('1');
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = ac.size() - 1; i >= 0; i--){
            sb.append(ac.get(i));
        }
        return sb.toString();
        
    }
}
