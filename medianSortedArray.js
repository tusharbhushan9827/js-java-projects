Intuition
I dont know whatever comes to mind after half grey goose vodka

Approach
Well whatever I just used median formula and imagined the scenarios

Complexity
Time complexity:
i am certain it is less then what leet expected 87% beat

Space complexity:
To drunk to calclate it drunk

Code
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function (nums1, nums2) {
    const newA = nums1.concat(nums2);
    newA.sort(function(a,b){return a-b});
    if(newA.length%2>0){
        return newA[Math.floor(newA.length/2)];
    }
    const mid = Math.ceil(newA.length/2);
    const x = newA[mid-1];
    const y = newA[mid];
    return (x+y)/2;
};
