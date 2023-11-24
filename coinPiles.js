/**
 * @param {number[]} piles
 * @return {number}
 */
var maxCoins = function(piles) {

const numberOfPiles = piles.length;
const sortedPiles = piles.sort(function (a, b) {  return a - b;  });
let aliceTurn = true;
let myTurn = false;
const numberOfparts = numberOfPiles / 3;
let myMax = 0;

for(let i = sortedPiles.length-1;i>=numberOfparts;i--)
{
     if(aliceTurn)
     {
       aliceTurn = false;
       myTurn = true;
     }
     else if(myTurn)
     {
       myMax = myMax + sortedPiles[i];
       myTurn = false;
       aliceTurn = true;
     }
}
    return myMax;
};
