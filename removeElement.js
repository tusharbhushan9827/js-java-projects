/**Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:*/

/**https://leetcode.com/problems/remove-element/description/*/

/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function (nums, val) {
    const numsL = nums.length;
    let data = [];
    for (let i = 0; i < numsL; i++) {
        if (nums[i]!= val) {
            data.push(nums[i]);
        }
    }
    nums.splice(0,numsL,...data);
    return nums.length;
};
