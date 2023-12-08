/**Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.*/

var isValid = function (s) {

    const closingBracketMap = { '}': '{', ']': '[', ')': '(' };
    let bracketStack = [];
    const strLength =  s.length;

    if(strLength % 2 != 0){
       return false;
    }

    for (let i = 0; i < strLength; i++) {
        const ch = s.charAt(i);
        if (ch === '{' || ch === '[' || ch === '(') {
            bracketStack.push(ch);
        }
        else {
            const compCH = bracketStack.pop();
            if (compCH != closingBracketMap[ch]) {
                return false;
            }
        }

    }
    return bracketStack.length === 0;
};
