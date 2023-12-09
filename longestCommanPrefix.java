/**Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String str1 = strs[0];
        String comm = "";
        int str1L = str1.length();

        for(int i = 0;i<str1L;i++){
            char ch = str1.charAt(i);
            for(String s: strs){
                if(s.length() <= i){
                   return comm;
                }
                if(s.charAt(i) != ch){
                    return comm;
                }
            }
            comm = comm + ch;
        }
        return comm;
    }
}
