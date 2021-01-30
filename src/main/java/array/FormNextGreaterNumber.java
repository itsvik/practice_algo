package array;

import java.util.Arrays;

public class FormNextGreaterNumber {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 3, 2};
        int i = arr.length - 2;
        int smallest = i;
        while (i > 0 && arr[i] >= arr[i+1] ){
            i--;
            smallest = arr[smallest] > arr[i+1] ? i+1: smallest;
        }
        if(i >= 0 ){
            arr[i] = arr[smallest] + arr[i];
            arr[smallest] = arr[i] - arr[smallest];
            arr[i] = arr[i] - arr[smallest];
            Arrays.sort(arr, i, arr.length-1);
        } else{
            System.out.println("Greatest number");
            return;
        }
        Arrays.stream(arr).forEach(System.out::print);
    }
}
