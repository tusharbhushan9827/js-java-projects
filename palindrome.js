/**
 * @param {number} x
 * @return {boolean}
 */
/**
Given an integer x, return true if x is a 
palindrome
, and false otherwise.
Solution beats 99.42%
*/
var isPalindrome = function(x) {
    let isPal = true;
    let numbeAsString = x+'';
    const lStr = numbeAsString.length;
    const backIndex = lStr-1;
    for(let i = 0 ;i<lStr;i++){
        const startChar = numbeAsString.charAt(i);
        const lastChar = numbeAsString.charAt(backIndex-i);
        if(startChar!=lastChar)
        {
            isPal = false;
            return isPal;
        }

    }
    return isPal;
    
};
