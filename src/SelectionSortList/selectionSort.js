const RandomNumber = (count) =>{
    const arrs = new Array();
    for (let i = 0; i < count ; i++) {
        let rand = Math.random();
        const l = Math.floor(rand < 0.5 ? Math.random()* -100: Math.random() * 100);
        arrs.push(l);
    }
    return arrs;
}
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
  console.log('Hasil Akhir');
  console.log(arr);
}

const array = RandomNumber(10);
console.log('Tampilan Awal');
console.log(array);
console.log("");
SelectionSort(array);
