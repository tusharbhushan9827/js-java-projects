/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
/**
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.
*/
var searchMatrix = function (matrix, target) {

    const m = matrix.length;
    const n = matrix[0].length;

    let rowNumber = 0;
    let lastItemValue = 0;
    for (let mJ = 0; mJ < m; mJ++) {
        lastItemValue = matrix[mJ][n - 1];
        if (lastItemValue >= target) {
            rowNumber = mJ;
            break;
        }

    }

    if (lastItemValue < target) {

        return false;
    }

    if (lastItemValue == target) {
        return true;
    }

    for (let nJ = 0; nJ < n - 1; nJ++) {
        const itemValue = matrix[rowNumber][nJ];
        if (itemValue == target) {
            return true;
        }
        if (itemValue > target) {
            return false;
        }

    }
    return false;
};
