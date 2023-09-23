const QuickSort = (A, start, end) => {
    if (start >= end) {
        return;
    }
    let pIndex = Partition(A, start, end);
   
    QuickSort(A, start, pIndex - 1);
    
    QuickSort(A, pIndex + 1, end);
}

const Partition =(A, start, end) =>{
    if (A.length > 1 == false) {
        return 0;
    }
    let pivotIndex = Math.ceil((start + end) / 2);
    let pivotValue = A[pivotIndex];
    for (var i = 0; i < A.length; i++) {
        var leftValue = A[i];
        // 
        if (i < pivotIndex) {
            if (leftValue > pivotValue) {
                A[pivotIndex] = leftValue;
                A[i] = pivotValue;
                pivotIndex = i;
            }
        }
        else if (i > pivotIndex) {
            if (leftValue < pivotValue) {
                A[pivotIndex] = leftValue;
                A[i] = pivotValue;
                pivotIndex = i;
            }
        }
    }
    return pivotIndex;

}

const QuickSortTest =  () => {
    const arrTest = [9,4,5,2,6,2,3,1,6];
    QuickSort(arrTest, 0, arrTest.length - 1);
    console.log("arrTest", arrTest);
}

QuickSortTest();


