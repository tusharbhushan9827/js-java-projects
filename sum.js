/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
 */
var twoSum = function (nums, target) {

    const valueMap = {};
    for (let i = 0; i < nums.length; i++) {
        const valueLp = nums[i];
        valueMap[valueLp] = i;
    }

    for (let j = 0; j < nums.length; j++) {
        const key1 = target - nums[j];
        const keyvalue = valueMap[key1];
        if (keyvalue && keyvalue != j) {
            const number = [j, keyvalue]
            return number;
        }
    }

};
