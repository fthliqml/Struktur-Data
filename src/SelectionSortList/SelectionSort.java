package SelectionSortList;

public class SelectionSort {
    //Looping mencari value yang paling kecil lalu menaruh di index 0 atau depan
    public static void display(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print("["+arr[i]+"]");
            System.out.print(" ");
        }
    }

    public static void selectionSort(int[] arr){
        int i, j, temp;
        boolean swapped;
    }

    public static void main(String[] args) {
        int[] num = {10, 9, 3, 19, 2};
        display(num);
    }
}
