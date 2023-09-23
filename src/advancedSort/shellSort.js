const shellSort = (array) => {
    let gap = Math.floor(array.length / 2);

    while (gap > 0) {
        for (i = gap; i < array.length; i++) {
            temp = array[i];
            for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                array[j] = array[j - gap];
            }
            array[j] = temp;
        }

        gap = Math.floor(gap / 2);
    }

    return array;
};


let arr = [4,6,3,2,4,7,2,8,3];
shellSort(arr);
console.log(arr)
