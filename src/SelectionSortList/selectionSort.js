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
    if (temp != arr[i]){
      arr[getIndex] = arr[i];
      arr[i] = temp;
    }
    console.log("Selected Value : "+temp);
    console.log(arr);
  }
  return arr;
}

array = [95, 88, 92, 84, 97, 89, 91, 99, 86, 93, 87, 96, 83, 90, 100, 94, 82, 98, 85, 81]
console.log('Tampilan Awal');
console.log(array);
console.log("");
Result = SelectionSort(array);
console.log("");
console.log('Hasil Akhir'); 
console.log(Result);
