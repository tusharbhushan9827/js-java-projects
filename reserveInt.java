/**Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.*/
//88 Percent beats

class Solution {
    public int reverse(int x) {
        String xStr = x+"";
        String rev = "";
        boolean isNegative = false;
        if(x<0){
            xStr = xStr.substring(1);
            isNegative = true;
        }
        for(int i = (xStr.length()-1); i>=0 ;i--)
        {
            rev = rev + xStr.charAt(i)+"";
        }
        if(isNegative){
            rev = "-"+rev;
        }
        try{
        int revInt = Integer.parseInt(rev);
        return revInt;
        }
        catch(Exception e){
            return 0;
        }
    }
}
