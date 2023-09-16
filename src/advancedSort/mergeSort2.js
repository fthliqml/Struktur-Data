function merge(array) {
    if (array.length <= 1) {
        return;
    }

    let LeftArray = [];
    let RightArray = [];
    const middle = Math.floor(array.length / 2);

    let i = 0;
    let j = 0;
    for (; i < array.length; i++) {
        if (i < middle) {
            LeftArray[i] = array[i];
        } else {
            RightArray[j] = array[i];
            j++;
        }
    }
    merge(LeftArray);
    merge(RightArray);
    array.length = 0; 
    array.push(...mergeSort(LeftArray, RightArray));
    
}
function mergeSort(LeftArray, RightArray) {
    const sorted = [];

    while (LeftArray.length && RightArray.length) {
        if (LeftArray[0] <= RightArray[0]) {
            sorted.push(LeftArray.shift());
        }else{
            sorted.push(RightArray.shift());
        }
        
    }
    if (LeftArray.length) {
        sorted.push(...LeftArray);
    }else{
        sorted.push(...RightArray);
    }
    return sorted;
}
let arr = [3,2,6,1,7,4,8,9,5];
merge(arr);
console.log(arr);