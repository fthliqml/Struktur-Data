// Method Random Number
const RandomNumber = (count) => {
    if (count<=0) {
      throw new Error('Parameter tidak boleh kurang dari sama dengan 0');
    }else if (count > 10000) {
      throw new Error('Parameter tidak melebihi 10000');
    }
    const arrs = new Array();
    for (let i = 0; i < count ; i++) {
        let rand = Math.random();
        const l = Math.floor(rand < 0.5 ? Math.random()* - 100: Math.random() * 100);
        arrs.push(l);
    }
    return arrs;
}

// Method Merge Sorting
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


arr = RandomNumber(100);
const sortedArray = merge(arr);

console.log("\nTampilan Awal : ");
console.log(arr)

console.log();

console.log("Tampilan Akhir : ");
console.log(sortedArray)
