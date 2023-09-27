/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:
  0 <= s.length <= 5 * 104
  s consists of English letters, digits, symbols and spaces.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<>(); //seen dictionary
        int l=0; //left pointer, point the current char index.
        int length=0; //max length
        for(int r=0; r<s.length();r++){ //right pointer
            if(charMap.containsKey(s.charAt(r)) && charMap.get(s.charAt(r))>=l){ //check if it's repeated char
                l=charMap.get(s.charAt(r))+1; //move left index up
                charMap.put(s.charAt(r),r);
            }else{
                length= Math.max(length, r-l+1);
                charMap.put(s.charAt(r),r);
            }
        }
        return length;
    }
}
