/**Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string 
Beats 55 percent

*/
/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
    const str1 = strs[0]
    const str1L = str1.length;
    let prefix="";

    for(let i =0;i<str1L;i++){
        const ch = str1.charAt(i);
        for(let j=0;j<strs.length;j++){
            const strIn = strs[j];
            if(i >= strIn.length){
                return prefix;
            }
            if(ch!=strIn.charAt(i)){
                return prefix;
            }
        }
        prefix = prefix + ch;
    }
    return prefix;
};
