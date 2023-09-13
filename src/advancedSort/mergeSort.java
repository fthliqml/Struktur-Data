package advancedSort;

public class mergeSort {
    public static void main(String[] args) {
        int[] Arrs = {1,3,4,5,2,4,8,9,10};

        for (int i = 0; i < Arrs.length; i++) {
            System.out.print(Arrs[i]+ " ");
        }
        merge(Arrs);
        System.out.println(" ");
        for (int i = 0; i < Arrs.length; i++) {
            System.out.print(Arrs[i]+" ");
        }
    }
    private static void merge(int[] arr){
        
        if (arr.length <= 1) {
            return;
        }
        int middle = arr.length/2;
        int[] left = new int[middle];
        int[] right = new int[arr.length - middle];

        int i = 0;
        int j = 0;
        for (;i < arr.length; i++) {
            if (i< middle) {
                left[i] = arr[i];
            }else{
                right[j] = arr[i];
                j++;
            }
        }
        merge(left);
        merge(right);
        allMerge(left, right, arr);
    }
    private static void allMerge(int[] left,int[] right,int[] arr){
        int leftSize = arr.length/2;
        int rightSize = arr.length - leftSize;
        int i= 0, l = 0 ,r =0;

        while (l < leftSize && r < rightSize) {
            if (left[l] < right[r]) {
                arr[i] = left[l];
                i++;
                l++;
            }else{
                arr[i] = right[r];
                i++;
                r++;
            }
        }
        while (l < leftSize) {
            arr[i] = left[l];
            l++;
            i++;
        }
        while (r < rightSize) {
            arr[i] = right[r];
            r++;
            i++;
        }
    }
}
