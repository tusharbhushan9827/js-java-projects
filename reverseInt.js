/**Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.*/
//88 Percent beats

/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    let strInt =  x+'';
    let reverse = '';
    let isNegative  = false;
        if(x<0){
        strInt = strInt.substring(1);
        isNegative = true;
    }
    for(let j = strInt.length ; j >= 0 ; j--){
        reverse = reverse+strInt.charAt(j);
    }
    const numbRev = parseInt(reverse);
    if(numbRev>=2147483647){
        return 0;
    }
    return isNegative ? '-'+reverse:reverse;
};
