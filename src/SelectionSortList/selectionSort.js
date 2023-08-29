const arr = [100, 30, 1, 6, 22, 7, 16, 1, 12, 22];

function SelectionSort (arr) {
  let i, j, getIndex, temp;

  for (i = 0; i < arr.length; i++) {
    temp = arr[i];

    for (j = (i + 1); j < arr.length; j++) {
      if (temp > arr[j]) {
        temp = arr[j];
        getIndex = j;
      }
    }
    arr[getIndex] = arr[i];
    arr[i] = temp;
    console.log(arr);
  }
  console.log('Hasil Akhir');
  console.log(arr);
}
console.log('Tampilan Awal');
console.log(arr);
console.log('Proses Selection Sort');
SelectionSort(arr);
