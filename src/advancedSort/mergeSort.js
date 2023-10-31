function merge(array){
    if (array.length <= 1) {
        return array;
    }
    const middle = Math.floor(array.length / 2);
    let left = array.slice(0, middle);
    let right = array.slice(middle, array.length);

    left = merge(left);
    right = merge(right);

    return mergeAll(left, right);
}

function mergeAll(left,right) {
    let sorted = [];
    let i = 0 , j = 0;
    
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


arr = [1543, 2341, 7890, 5678, 4321, 9087, 3210, 8765, 4567, 1098, 5432, 9876, 8765, 2310, 5678, 9087, 8765, 1098, 6543, 3210]
sortedArray = merge(arr);

console.log("\nTampilan Awal Array: ");
console.log(arr)

console.log("");

console.log("Tampilan Akhir Setelah Dilakukan Merge Sorting : ");
console.log(sortedArray)
