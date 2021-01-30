package array;

import java.util.HashSet;
import java.util.Set;

public class ThreeSumTarget {

    public static void main(String[] args) {

        int[] arr = new int[]{2,6,1,4,3,-7,8,10,5};
        int sum = 13;

        for (int i = 0; i < arr.length - 2; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i+1; j < arr.length; j++) {
                if(set.contains(sum - (arr[i] + arr[j]))){
                    System.out.println("found " + arr[i] + " " + arr[j] + " " + (sum - arr[i] - arr[j]));
//                    return;
                }
                set.add(arr[j]);
            }
        }
//        System.out.println("Not Found");

    }
}
