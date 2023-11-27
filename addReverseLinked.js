/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function (l1, l2) {
    let strN = [];
     getNodeDigit(l1,'',strN);
     getNodeDigit(l2,'',strN);
    const l1Number =  BigInt(strN[0]);
    const l2Number =  BigInt(strN[1]);
    const sum = l1Number + l2Number;
    const solve = addToLinkList(sum.toString());
    return solve;

};

function getNodeDigit(node, digit,returnValue) {
    if (node != null) {
        digit = node.val+digit;
        getNodeDigit(node.next, digit,returnValue);
    }
    else {
        numberString = digit+'';
        returnValue.push(numberString);
        return returnValue;
    }
};


function addToLinkList(strAt) {
      
        let head=new ListNode(strAt.charAt(strAt.length-1),null);
        let curr=head;
        for(let i=strAt.length-2;i>=0;i--)
        {
            curr.next=new ListNode(strAt.charAt(i));
            curr=curr.next;
        }
        return head;
    
};
