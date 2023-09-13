const arr = [8,7,9,4,3,6,1,5];

function merge(array){
    if (array.length <=1) {
        return array;
    }
    const middle = Math.floor(array.length / 2);
    let left = array.slice(0,middle);
    let right = array.slice(middle,array.length);

    left = merge(left);
    right = merge(right);
    return mergeAll(left, right)
}
function mergeAll(left,right) {
    let sorted = [];
    let i =0 , j = 0;
    
    while (i < left.length && j < right.length) {
        if (left[i] < right[j]) {
            sorted.push(left[i]);
            i++;
        } else {
            sorted.push(right[j]);
            j++;
        }
    }
    return sorted.concat(left.slice(i) , right.slice(j));
}

const sortedArray = merge(arr);
console.log(arr)
console.log(sortedArray)
